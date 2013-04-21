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

package ph.org.zero.tools.toys.usbio24mkii.port;

import ph.org.zero.tools.toys.usbio24mkii.Device;
import ph.org.zero.tools.toys.usbio24mkii.port.pin.Pin;

public interface Port {
  public void addPortEventListener(PortEventListener listener);

  public void removePortEventListener(PortEventListener listener);

  public void removePortEventListeners();

  public PortEventListener[] getPortEventListeners();

  public Device getDevice();

  public Pin[] getPins();

  public void setPortBinaryData(int data);

  public int getPortBinaryData();

  public void setPortDirectionRegister(int directionRegister);

  public int getPortDirectionRegister();

  public static final String PORT_A_NAME = "PORT_A";
  public static final String PORT_B_NAME = "PORT_B";
  public static final String PORT_C_NAME = "PORT_C";
}
