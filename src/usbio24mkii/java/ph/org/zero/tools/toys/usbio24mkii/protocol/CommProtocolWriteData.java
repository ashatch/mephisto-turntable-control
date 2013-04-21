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

package ph.org.zero.tools.toys.usbio24mkii.protocol;

public interface CommProtocolWriteData {
  public static final byte PORT_A_COMMAND = 'A';
  public static final byte PORT_B_COMMAND = 'B';
  public static final byte PORT_C_COMMAND = 'C';

  public void writeDataPortA(int data);

  public void writeDataPortB(int data);

  public void writeDataPortC(int data);

  public String getDataPortACmd();

  public String getDataPortBCmd();

  public String getDataPortCCmd();
}
