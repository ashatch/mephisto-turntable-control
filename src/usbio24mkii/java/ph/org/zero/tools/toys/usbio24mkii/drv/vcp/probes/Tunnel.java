/*****************************************************************************
J-USBIOMKII24 API
Copyright (C) 2004, Christopher Gabijan dbx0001@gmail.com

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
******************************************************************************/

package ph.org.zero.tools.toys.usbio24mkii.drv.vcp.probes;

import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import gnu.io.SerialPortEvent;
import java.io.DataOutputStream;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.VCPDeviceCommGrounds;

public class Tunnel
    implements SerialPortEventListener {

  /*
   =======================================
   QUICK NOTES
   =======================================
     There are only 2 basic procedure that can be done
   1st: applying a command do create response from the device this are the ff.
   a -> read only Port A
   b -> read only Port B
   c -> read only Port C
   combination of 2
   ab -> reads port A & B respectively
   ac -> reads port A & C respectively
   and so on.
   combination of 3
   abc -> reads port A & B & C respectively
   cba -> reads port C & B & A respectively
   and last but not the least
   ? -> returns 10 unsigned byte | char

   while using the low level thread in reading this values only ? is an
   exception in which must be read before initializing the thread thus conclude
   on our initiliazation process are the ff.
   -> write ? command to determine the specifice device
   -> if the read command is "USB I/O 24"
   -> store it on a signature USBIOModuleSignature IMPL for future querying
   -> then begin binding low priority thread read command abc
   -> and must catch 3 byte[] on every throw.
   -> THERE MUST BE NO OTHER THREAD THAT WILL INVOKE THE CommProtocolReadData IMPL
   -> IF A DIRECTION REGISTER IS INVOKED : THE APPLICATION MUST BE RESTARTED w/
   -> THE READ THREAD..
   -> STRONGLY IF A WRITE COMMAND is giving output to input THE APPLICATION MUST
   -> THROW AN EXCEPTION CLAUSE IN WHICH IT CAN'T BE REPROGRAM WHILE ON RUNNING
   -> STATE BUT CAN IMPLEMENT IT if the DEVICE CONFIGURATION IS MODIFIED AND IT
   -> MUST BE RESTARTED BEFORE IMPLEMENTING IT.

   This are basic guidelines in which it would be followed for application
   stability and device stability also.

   2nd: THE WRITE COMMANDS

   BASIC DEVICE COMMUNICATION DESC
   -> Tunnel Class is a representation of the IO Communication of the DEVICE
   -> Worker is the low priority read command thread.
   -> TNT is the write command
   -> FrameWork is the Direction Registers

    + Only the inner class of the TNT must be used to write command other
   instruction writing must be prohibited and also applied to FrameWork class
   */

  private InputStream inputStream;
  private OutputStream outputStream;
  private String result;
  private boolean tunnelIsNotDestroyed = true;
  private boolean someOneIsStillInTheHole = false;

  public Tunnel(InputStream is, OutputStream os) {
    this.inputStream = is;
    this.outputStream = os;
    goHole(new byte[] {'?'});
  }

  /* only for workers */
  synchronized void goHole(byte[] command) {

    if (tunnelIsNotDestroyed) {
      this.getCommandAndExecute(command);
    }
  }

  /* for TNT & FrameWork Only */
  synchronized void implant(byte[] command) {
    if (tunnelIsNotDestroyed) {
      this.getCommandAndExecute(command);
      this.switchCommand(0x0000);
    }
  }

  synchronized void implant(String command) {
    if (tunnelIsNotDestroyed) {
      DataOutputStream dos = new DataOutputStream(outputStream);
      try {
        dos.writeChars(command);
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  private synchronized void getCommandAndExecute(byte[] commandEx) {
//	  for(byte b : commandEx) {
//		  System.out.print((int)b + " (" + (char)b + ")");
//	  }
//	  System.out.println();
    while (someOneIsStillInTheHole) {
      try {
        wait();
      }
      catch (InterruptedException ex) {
        System.err.println("Tunnel->getCommandAndExecute|wait" + ex);
      }
    }
    someOneIsStillInTheHole = true;
    try {
      outputStream.write(commandEx);
    }
    catch (IOException ex) {
      System.err.println("Tunnel->getCommandAndExecute|write" + ex);
    }

    notify();
  }

  private synchronized void getExecuteResultAndReport(int nothingImportant) throws
      InterruptedException, IOException {
    switch (nothingImportant) {
      case 0x0001:
        while (!someOneIsStillInTheHole) {
          wait();
        }
        byte readBuffer[] = new byte[64];

        while (inputStream.available() > 0) {
          int numBytes = inputStream.read(readBuffer);
          //result = new String(readBuffer, 0, numBytes);
          result = new String(readBuffer, 0, numBytes, "ISO8859_1");
          ////////////////////tricky side////////////////////////

          if (result.length() == 12) {
            Message.OxAA = result;
          }
          if (result.length() >= 1) {
            Message.OxFF = result;
          }
          if (result.length() == 3) {
            VCPDeviceCommGrounds.updatePortA();
            VCPDeviceCommGrounds.updatePortB();
            VCPDeviceCommGrounds.updatePortC();
          }

        }

      default:
        someOneIsStillInTheHole = false;
        notify();
        break;

    }
  }

  public void serialEvent(SerialPortEvent serialPortEvent) {

    switchCommand(serialPortEvent.getEventType());
  }

  private void switchCommand(int eventType) {
    switch (eventType) {
      case SerialPortEvent.DATA_AVAILABLE:
        try {
          getExecuteResultAndReport(0x0001);
        }
        catch (Exception ex) {
          System.err.println("Error occured : " + ex);
        }
        finally {
          break;
        }
      default:
        try {
          getExecuteResultAndReport(0x0000);
        }
        catch (Exception ex) {
          System.err.println("Error occured : " + ex);
        }
        finally {
          break;
        }
    }
  }

  public void destroyTunnel() {
    this.tunnelIsNotDestroyed = false;
    try {
      inputStream.close();
      outputStream.close();
    }
    catch (IOException ex) {
    }
    inputStream = null;
    outputStream = null;
  }

}
