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

package ph.org.zero.tools.toys.usbio24mkii.drv.vcp.port.pin;

import ph.org.zero.tools.toys.usbio24mkii.port.pin.Pin;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.port.VCPPort;
import java.util.Vector;
import ph.org.zero.tools.toys.usbio24mkii.port.pin.PinEventListener;
import ph.org.zero.tools.toys.usbio24mkii.port.Port;
import ph.org.zero.tools.toys.usbio24mkii.port.pin.PinEvent;

public class VCPPin
    implements Pin {
  VCPPort port;
  int pinAddress;
  private boolean pinState;
  boolean pinRegisterAsInput;
  Vector m_pinEventList = new Vector();

  public VCPPin(VCPPort port, double pinAddress) {
    this.port = port;
    this.pinAddress = (int) pinAddress;

  }

  public void addPinEventListener(PinEventListener event) {
    m_pinEventList.add(event);
  }

  public Port getDevicePort() {
    return port;
  }

  public PinEventListener[] getPinEventListeners() {
    PinEventListener[] ret;
    ret = new PinEventListener[m_pinEventList.size()];
    m_pinEventList.copyInto(ret);
    return ret;

  }

  public void removePinEventListener(PinEventListener listener) {
    m_pinEventList.remove(listener);
  }

  public void setPinConfiguration() {
  }

  public boolean setPinRegisterAsInput(boolean b) {
    //this.pinRegisterAsInput = b;

    if (b) {
      this.port.setPortDirectionRegister(port.getPortDirectionRegister()
                                         | Integer.parseInt(this.toString()));
    }
    else {
      this.port.setPortDirectionRegister(port.getPortDirectionRegister()
                                         ^
                                         Integer.parseInt(this.toString()));
    }
    return this.pinRegisterAsInput;
  }

  public boolean setPinStateAsOn(boolean b) {
    if (!this.pinRegisterAsInput) {
      pinState = b;
      if (b) {
        port.setPortBinaryData(port.getPortBinaryData()
                               | Integer.parseInt(this.toString()));
      }
      else {
        port.setPortBinaryData(port.getPortBinaryData()
                               ^ Integer.parseInt(this.toString()));
      }
    }
    else {
      System.out.println("<< Can not register >>");
    }
    return pinState;
  }

  public void setPinStateAsOff() {
    this.pinState = false;
    triggerPinStateChanged();
  }

  public void setPinStateAsOn() {
    this.pinState = true;
    triggerPinStateChanged();
  }

  public void triggerPinStateChanged() {
    PinEventListener[] tmpPinEventListener = this.getPinEventListeners();
    for (int i = 0; i < tmpPinEventListener.length; i++) {
      tmpPinEventListener[i].pinStateChanged(
          new VCPPinEvent(
          this, PinEvent.PIN_STATE_CHANGED, PinEvent.CAUSE_NORMAL));
    }
    tmpPinEventListener = null;

  }

  public void setPinRegisterAsInput() {
    this.pinRegisterAsInput = true;
    triggerPinRegisterChanged();
  }

  public void setPinRegisterAsOutput() {
    this.pinRegisterAsInput = false;
    triggerPinRegisterChanged();
  }

  public void triggerPinRegisterChanged() {
    PinEventListener[] tmpPinEventListener = this.getPinEventListeners();
    for (int i = 0; i < tmpPinEventListener.length; i++) {
      tmpPinEventListener[i].pinRegisterChanged(
          new VCPPinEvent(
          this, PinEvent.PIN_REGISTER_INVOKED, PinEvent.CAUSE_NORMAL));
    }
    tmpPinEventListener = null;
  }

  public void removePinEventListers() {
    m_pinEventList.clear();
  }

  public String toString() {
    return "" + this.pinAddress;
  }

  public boolean getPinState() {
    if (pinState) {
      return true;
    }
    else {
      return false;
    }
  }

  public boolean getPinRegisterAsInput() {
    return this.pinRegisterAsInput;
  }

  public int getPinAddress() {
    return this.pinAddress;
  }
  /*
    public void setPinRegisterDirection(){
      port.setPinInputDirectionRegister(Integer.parseInt(this.toString()) &
                                        port.getCurrentDirectionRegister());
    }


   */

}
