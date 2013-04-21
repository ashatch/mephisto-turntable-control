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

public class Worker
    extends Thread {
  Tunnel tl;
  boolean iAmNotDestroyed = true;
  public Worker(Tunnel tl) {
    this.tl = tl;
    this.setDaemon(true);
    this.setPriority(Thread.MIN_PRIORITY);
    this.setName("I_AM_WORKER");
  }

  public void run() {
    while (iAmNotDestroyed) {
      tl.goHole(new byte[] {'a', 'b', 'c'});
    }
  }

  public void selfDestructButton(boolean engage) {
    if (engage) {
      iAmNotDestroyed = false;
    }
  }
}
