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

package ph.org.zero.tools.toys.usbio24mkii.drv.vcp.port;

import java.util.*;

import ph.org.zero.tools.toys.usbio24mkii.*;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.probes.*;
import ph.org.zero.tools.toys.usbio24mkii.port.*;
import ph.org.zero.tools.toys.usbio24mkii.port.pin.*;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.port.pin.VCPPin;
import ph.org.zero.tools.toys.usbio24mkii.port.PortEventListener;

public class VCPPort
    implements Port {
  Device dev;
  String portName;
  Vector m_portEventList = new Vector();
  Vector m_pins = new Vector();
  TNT.specific miniNukes;
  FrameWork.specific assemble;
  int portBinaryData;
  int pinStat = 0;
  int portDirectionRegister = 255;

  public VCPPort() {
  }

  public VCPPort(Device dev
                 , String portName
                 , TNT.specific miniNukes
                 , FrameWork.specific portRegister) {
    this.dev = dev;
    this.portName = portName;
    this.miniNukes = miniNukes;
    this.assemble = portRegister;

    //for now make all outputs
    //portRegister.execCommand(0);
    //for now make all inputs
    //portRegister.execCommand(255);

    initPins(8);
    setPortDirectionRegister(this.portDirectionRegister);

  }

  private void initPins(int numberOfPins) {
    for (int i = 1; i <= numberOfPins; i++) {
      m_pins.add(new VCPPin(this, Math.pow(2, i - 1)));
    }
  }

  public void addPortEventListener(PortEventListener listener) {
    /*
     System.out.println("Port Event Listener Added @ >> "+this.toString());*/
    m_portEventList.add(listener);
  }

  public Device getDevice() {
    return this.dev;
  }

  public Pin[] getPins() {
    Pin[] retValue = new Pin[m_pins.size()];
    for (int i = 0; i < m_pins.size(); i++) {
      retValue[i] = (Pin) m_pins.get(i);
    }
    return retValue;
  }

  public PortEventListener[] getPortEventListeners() {
    PortEventListener[] ret;
    ret = new PortEventListener[m_portEventList.size()];
    m_portEventList.copyInto(ret);
    return ret;

  }

  public void removePortEventListener(PortEventListener listener) {
    m_portEventList.remove(listener);
  }

  public void removePortEventListeners() {
    m_portEventList.clear();
  }

  /*==========================================================*/
  public void setPortBinaryData(int data) {
    portBinaryData = data;
    this._nukem(portBinaryData);
  }

  public int getPortBinaryData() {
    return portBinaryData;
  }

  public void setPortDirectionRegister(int directionRegister) {
    this.portDirectionRegister = directionRegister;
    this._assemble(this.portDirectionRegister);
    this.__pinsIOReg(this.portDirectionRegister);
  }

  public int getPortDirectionRegister() {
    return portDirectionRegister;
  }

  /*==========================================================*/

  public void _nukem(int db) {
    PortEventListener[] tmpPortListeners = this.getPortEventListeners();
    miniNukes.execCommand(db);
    for (int i = 0; i < tmpPortListeners.length; i++) {
      tmpPortListeners[i].isPortWriting(
          new VCPPortEvent(
          this, PortEvent.PORT_STATE_WRITING, PortEvent.CAUSE_NORMAL));
    }
    tmpPortListeners = null;
  }

  public void _assemble(int db) {
    PortEventListener[] tmpPortListeners = this.getPortEventListeners();
    assemble.execCommand(db);
    for (int i = 0; i < tmpPortListeners.length; i++) {
      tmpPortListeners[i].isPortWriting(
          new VCPPortEvent(
          this, PortEvent.PORT_REGISTERING, PortEvent.CAUSE_NORMAL));
    }
    tmpPortListeners = null;
  }

  public void __pinsIOReg(int pinsReg) {
    this.portDirectionRegister = pinsReg;
    PortEventListener[] tmpPortListeners = this.getPortEventListeners();
    for (int i = 0; i < m_pins.size(); i++) {
      int pIOAddress = ( (VCPPin) m_pins.get(i)).getPinAddress();
      if ( (pIOAddress & pinsReg) == pIOAddress) {
        ( (VCPPin) m_pins.get(i)).setPinRegisterAsInput();
      }
      else {
        ( (VCPPin) m_pins.get(i)).setPinRegisterAsOutput();
      }
    }
    for (int i = 0; i < tmpPortListeners.length; i++) {
      tmpPortListeners[i].isPortRegistered(
          new VCPPortEvent(
          this, PortEvent.PORT_REGISTERED, PortEvent.CAUSE_NORMAL));
    }
    tmpPortListeners = null;
  }

  public void __pinsStates(int pinsStates) {
    this.portBinaryData = pinsStates;
    PortEventListener[] tmpPortListeners = this.getPortEventListeners();

    for (int i = 0; i < m_pins.size(); i++) {
      int pIOAddress = ( (VCPPin) m_pins.get(i)).getPinAddress();
      /*
             System.out.println(pIOAddress);*/
      if ( (pIOAddress & pinsStates) == pIOAddress) {
        ( (VCPPin) m_pins.get(i)).setPinStateAsOn();
      }
      else {
        ( (VCPPin) m_pins.get(i)).setPinStateAsOff();
      }
    }

    for (int i = 0; i < tmpPortListeners.length; i++) {
      tmpPortListeners[i].isPortWritten(
          new VCPPortEvent(
          this, PortEvent.PORT_STATE_WRITTEN, PortEvent.CAUSE_NORMAL));

    }
    tmpPortListeners = null;

  }

  public String toString() {
    return this.portName;
  }

}
