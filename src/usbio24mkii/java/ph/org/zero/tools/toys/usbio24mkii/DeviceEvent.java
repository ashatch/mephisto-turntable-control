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

public interface DeviceEvent
    extends Event {

  /**
   * Current Device is active
   */
  public static final int DEVICE_ACTIVE = 0x0010;

  /**
   * Current Device is Connected
   */
  public static final int DEVICE_CONNECTED = 0x0020;

  /**
   * Current Device is Disconnected
   */
  public static final int DEVICE_DISCONNECTED = 0x0021;

  /**
   * Current Device is Invalid or not present
   */
  public static final int DEVICE_INVALID = 0xE001;

  /**
   * Cause of the Event
   * @return int
   */
  public int getCauseID();

  /**
   * Event ID
   * @return int
   */
  public int getEventID();

  /**
   * Source of the Object that cause the event
   * @return Object
   */
  public Object getSource();

}
