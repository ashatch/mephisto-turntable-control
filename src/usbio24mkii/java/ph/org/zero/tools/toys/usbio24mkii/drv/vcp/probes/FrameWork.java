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

import ph.org.zero.tools.toys.usbio24mkii.protocol.CommProtocolDirectionRegisters;
import java.io.UnsupportedEncodingException;

public class FrameWork
    implements CommProtocolDirectionRegisters {
  char[] portADirectionRegister = new char[3];
  char[] portBDirectionRegister = new char[3];
  char[] portCDirectionRegister = new char[3];
  Tunnel tl;

  public FrameWork(Tunnel tl) {
    this.tl = tl;

    for (int i = 0
         ; i < (PORT_A_COMMAND.length |
                PORT_B_COMMAND.length |
                PORT_C_COMMAND.length)
         ; i++) {

      portADirectionRegister[i] = PORT_A_COMMAND[i];
      portBDirectionRegister[i] = PORT_B_COMMAND[i];
      portCDirectionRegister[i] = PORT_C_COMMAND[i];
    }

  }

  public String getPortADirectionRegister() {
    return new String(portADirectionRegister);
  }

  /**
   * getPortBDirectionRegister
   *
   * @return String
   */
  public String getPortBDirectionRegister() {
    return new String(portBDirectionRegister);
  }

  /**
   * getPortCDirectionRegister
   *
   * @return String
   */
  public String getPortCDirectionRegister() {
    return new String(portCDirectionRegister);
  }

  /**
   * setPortADirectionRegister
   *
   * @param conf int
   */
  public void setPortADirectionRegister(int conf) {
    if (conf >= 256) {
      conf = 0;
    }
    portADirectionRegister[2] = (char) conf;
    try {
      tl.implant(new String(portADirectionRegister).getBytes("ISO8859_1"));

      /*
             System.out.println(">>" +
                         (char) getPortADirectionRegister().getBytes(
          "ISO8859_1")[0] + "" +
                         (char) getPortADirectionRegister().getBytes(
          "ISO8859_1")[1] + ":" +
       (int) getPortADirectionRegister().getBytes("ISO8859_1")[
                         2]); */

    }
    catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * setPortBDirectionRegister
   *
   * @param conf int
   */
  public void setPortBDirectionRegister(int conf) {
    if (conf >= 256) {
      conf = 0;
    }
    portBDirectionRegister[2] = (char) conf;
    try {
      tl.implant(new String(portBDirectionRegister).getBytes("ISO8859_1"));

      /*
             System.out.println(">>" +
                         (char) getPortBDirectionRegister().getBytes(
          "ISO8859_1")[0] + "" +
                         (char) getPortBDirectionRegister().getBytes(
          "ISO8859_1")[1] + ":" +
       (int) getPortBDirectionRegister().getBytes("ISO8859_1")[
                         2]); */
    }
    catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * setPortCDirectionRegister
   *
   * @param conf int
   */
  public void setPortCDirectionRegister(int conf) {
    if (conf >= 256) {
      conf = 0;
    }
    portCDirectionRegister[2] = (char) conf;
    try {
      tl.implant(new String(portCDirectionRegister).getBytes("ISO8859_1"));

      /*
             System.out.println(">>" +
                         (char) getPortCDirectionRegister().getBytes(
          "ISO8859_1")[0] + "" +
                         (char) getPortCDirectionRegister().getBytes(
          "ISO8859_1")[1] + ":" +
       (int) getPortCDirectionRegister().getBytes("ISO8859_1")[
                         2]); */
    }
    catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
    }
  }

  public void destroy() {
    tl = null;
    portADirectionRegister = null;
    portBDirectionRegister = null;
    portCDirectionRegister = null;
  }

  public class specific {
    char portLoc;

    public specific(char portLoc) {
      this.portLoc = portLoc;
    }

    public void execCommand(int data) {
      switch (portLoc) {
        case 'A':
          setPortADirectionRegister(data);
          break;
        case 'B':
          setPortBDirectionRegister(data);
          break;
        case 'C':
          setPortCDirectionRegister(data);
          break;
      }
    }
  }

}
