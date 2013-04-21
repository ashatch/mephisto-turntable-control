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

package ph.org.zero.tools.toys.usbio24mkii.drv.vcp;

import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.port.VCPPort;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.probes.Message;

public class VCPDeviceCommGrounds {
  static VCPPort A, B, C;
  static Message.CommProtocolReadDataImpl readings
      = new Message.CommProtocolReadDataImpl();

  private static int portAValue;
  private static int portBValue;
  private static int portCValue;

  public static void setPorts(VCPPort AA, VCPPort BB, VCPPort CC) {
    A = AA;
    B = BB;
    C = CC;
  }

  public static void updatePortA() {

    try {
      //System.out.println( (int) readings.readDataPortA());
      if (portAValue != ( ( (int) (readings.readDataPortA())) & 0xFF)) {
        portAValue = ( ( (int) (readings.readDataPortA())) & 0xFF);
        A.__pinsStates(portAValue);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void updatePortB() {
    try {
      //System.out.println( (int) readings.readDataPortA());
      if (portBValue != ( ( (int) (readings.readDataPortB())) & 0xFF)) {
        portBValue = ( ( (int) (readings.readDataPortB())) & 0xFF);
        B.__pinsStates(portBValue);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void updatePortC() {
    try {
      //System.out.println( (int) readings.readDataPortA());
      if (portCValue != ( ( (int) (readings.readDataPortC())) & 0xFF)) {
        portCValue = ( ( (int) (readings.readDataPortC())) & 0xFF);
        C.__pinsStates(portCValue);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
