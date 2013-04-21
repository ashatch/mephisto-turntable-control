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

package ph.org.zero.tools.toys.usbio24mkii;

import ph.org.zero.tools.toys.usbio24mkii.port.*;

public interface Device {
  /**
   * Provide Listener to the device
   * @param listener DeviceEventListener
   */
  public void addDeviceEventListener(DeviceEventListener listener);

  /**
   *
   * @return DeviceEventListener[]
   */
  public DeviceEventListener[] getDeviceEventListeners();

  /**
   *
   * @param listener DeviceEventListener
   */
  public void removeDeviceEventListener(DeviceEventListener listener);

  /**
   *
   */
  public void removeDeviceEventListeners();

  /**
   *
   * @param commPortLocation String - COMM Port Location e.g. on MS COMM4
   */

  public void setCommPortLocation(String commPortLocation);

  /**
   * Action to open the device
   * @throws Exception
   *   if the device is currently used by other application
   *   and or the device is not present
   * @return long
   */

  public long open() throws Exception;

  /**
   * Action to close the device
   */
  public void close();

  /**
   * There are 3 ports on this device
   * it returns ports a, b , c respectively
   *
   * e.g.
   * getPorts()[0] - returns port A
   * getPorts()[1] - returns port B
   * getPorts()[2] - returns port C
   * @return Port[]
   */
  public Port[] getPorts();

  /**
   * Name of the device
   * @return String
   */
  public String getName();

  //properties | default Key - Value;

  public static String configurationHeader = "xXx_JVCP-USBIOMKII24_xXx";
  public static String configurationFileName = "JVCPUSBIOMKII24.property";
  public static String configurationDevLocKey = "jusbiomkii24.devloc";
  public static String configurationNumPortKey = "jusbiomkii24.numports";
  public static String configurationNumPortVal = "3";
  public static String configurationNumPinKey = "jusbiomkii24.numpins";
  public static String configurationNumPinVal = "8";

}
