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

import ph.org.zero.tools.toys.usbio24mkii.protocol.USBIOModuleSignature;
import ph.org.zero.tools.toys.usbio24mkii.protocol.CommProtocolReadData;

public class Message {
  static String OxAA;
  static String OxFF;

  public static class USBModuleSignature
      implements USBIOModuleSignature {
    public String deviceIdentity() {
      return OxAA;
    }
  }

  public static class CommProtocolReadDataImpl
      implements CommProtocolReadData {
    public byte[] readDataAllPorts() throws Exception {
      if (OxFF.length() >= 3) {
        return OxFF.getBytes("ISO8859_1");
      }
      else {
        throw new Exception("null reading");
      }
    }

    public byte readDataPortA() throws Exception {
      if (OxFF.length() >= 1) {
        return OxFF.getBytes("ISO8859_1")[0];
      }
      else {
        throw new Exception("null reading");
      }
    }

    public byte readDataPortB() throws Exception {
      if (OxFF.length() >= 2) {
        return OxFF.getBytes("ISO8859_1")[1];
      }
      else {
        throw new Exception("null reading");
      }
    }

    public byte readDataPortC() throws Exception {
      if (OxFF.length() >= 3) {
        return OxFF.getBytes("ISO8859_1")[2];
      }
      else {
        throw new Exception("null reading");
      }
    }
  }
}
