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

import ph.org.zero.tools.toys.usbio24mkii.protocol.CommProtocolWriteData;
import java.io.UnsupportedEncodingException;

public class TNT
    implements CommProtocolWriteData {
  Tunnel tl;
  char[] portACmd = new char[2];
  char[] portBCmd = new char[2];
  char[] portCCmd = new char[2];

  public TNT(Tunnel tl) {
    this.tl = tl;
    portACmd[0] = PORT_A_COMMAND;
    portBCmd[0] = PORT_B_COMMAND;
    portCCmd[0] = PORT_C_COMMAND;
  }

  /**
   * writeDataPortA
   *
   * @param data int
   */
  public void writeDataPortA(int data) {
	  System.out.println("Write port A: " + data + "(" + (char)data + ")");
    if (data >= 256 || data <= 0) {
      data = 0;
    }
    portACmd[1] = (char) data;
    try {
      tl.implant(new String(portACmd).getBytes("ISO8859_1"));
      /*
             System.out.println(">>" +
                         (char) getDataPortACmd().getBytes("ISO8859_1")[0] +
                         ":" +
                         (int) getDataPortACmd().getBytes("ISO8859_1")[1]);*/
    }
    catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * writeDataPortB
   *
   * @param data int
   */
  public void writeDataPortB(int data) {
    if (data >= 256 || data <= 0) {
      data = 0;
    }
    portBCmd[1] = (char) data;
    try {
      tl.implant(new String(portBCmd).getBytes("ISO8859_1"));
      /*
             System.out.println(">>" +
                         (char) getDataPortBCmd().getBytes("ISO8859_1")[0] +
                         ":" +
                         (int) getDataPortBCmd().getBytes("ISO8859_1")[1]); */
    }
    catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * writeDataPortC
   *
   * @param data int
   */
  public void writeDataPortC(int data) {
    if (data >= 256 || data <= 0) {
      data = 0;
    }
    portCCmd[1] = (char) data;
    try {
      tl.implant(new String(portCCmd).getBytes("ISO8859_1"));
      /*
             System.out.println(">>" +
                         (char) getDataPortCCmd().getBytes("ISO8859_1")[0] +
                         ":" +
                         (int) getDataPortCCmd().getBytes("ISO8859_1")[1]); */
    }
    catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * getDataPortACmd
   *
   * @return String
   */
  public String getDataPortACmd() {
    return new String(portACmd);
  }

  /**
   * getDataPortBCmd
   *
   * @return String
   */
  public String getDataPortBCmd() {
    return new String(portBCmd);
  }

  /**
   * getDataPortCCmd
   *
   * @return String
   */
  public String getDataPortCCmd() {
    return new String(portCCmd);
  }

  public void neutralize() {
    portACmd = null;
    portBCmd = null;
    portCCmd = null;
    tl = null;
  }

  public class specific {
    char portLoc;

    public specific(char portLoc) {
      this.portLoc = portLoc;
    }

    public void execCommand(int data) {
      switch (portLoc) {
        case 'A':
          writeDataPortA(data);
          break;
        case 'B':
          writeDataPortB(data);
          break;
        case 'C':
          writeDataPortC(data);
          break;
      }
    }
  }

}
