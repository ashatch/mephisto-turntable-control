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

package ph.org.zero.tools.toys.usbio24mkii.drv.vcp;

import java.io.*;
import java.util.*;

import gnu.io.*;
import ph.org.zero.tools.toys.usbio24mkii.*;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.port.*;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.probes.*;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.probes.FrameWork.*;
import ph.org.zero.tools.toys.usbio24mkii.drv.vcp.probes.TNT.*;
import ph.org.zero.tools.toys.usbio24mkii.port.*;

public class VCPDeviceImpl
    implements Device {
  Vector m_devList = new Vector();
  Vector m_ports = new Vector();
  String commPortLoc;
  CommPortIdentifier commPortID;
  SerialPort serialPort;
  FrameWork frameWork;
  TNT tnt;
  Tunnel tunnel;
  Worker worker;
  InputStream inputStream;
  OutputStream outputStream;
  boolean connectionInstance = false;
  Message.USBModuleSignature sig = new Message.USBModuleSignature();

  int numPorts;
  public VCPDeviceImpl() {
    this(3, "COM4");
  }

  public VCPDeviceImpl(int numPorts) {
    this.numPorts = numPorts;
  }

  void open(int numPorts) {
    for (int i = 1; i <= numPorts; i++) {
      m_ports.add(new
                  VCPPort(this
                          , "PORT_" + (char) (64 + i)
                          , tnt.new specific( (char) (64 + i))
                          , frameWork.new specific( (char) (64 + i))
                          )
                  );
    }
    VCPDeviceCommGrounds.setPorts(
        (VCPPort)this.getPorts()[0],
        (VCPPort)this.getPorts()[1],
        (VCPPort)this.getPorts()[2]
        );
  }

  public VCPDeviceImpl(int numPorts, String commPortLoc) {
    this(numPorts);
    this.commPortLoc = commPortLoc;

  }

  public void setCommPortLocation(String commPortLocation) {
    this.commPortLoc = commPortLocation;
  }

  public void addDeviceEventListener(DeviceEventListener listener) {
    m_devList.add(listener);
  }

  public DeviceEventListener[] getDeviceEventListeners() {
    DeviceEventListener[] ret;
    ret = new DeviceEventListener[m_devList.size()];
    m_devList.copyInto(ret);
    return ret;
  }

  public void removeDeviceEventListener(DeviceEventListener listener) {
    m_devList.remove(listener);
  }

  public void removeDeviceEventListeners() {
    m_devList.clear();
  }

  public Port[] getPorts() {
    Port[] retValue = new Port[m_ports.size()];
    for (int i = 0; i < m_ports.size(); i++) {
      retValue[i] = (Port) m_ports.get(i);
    }
    return retValue;
  }

  public long open() {
    if (!connectionInstance) {
      DeviceEventListener[] tmpDevListeners = this.getDeviceEventListeners();
      try {
        /*[1st]*/
        this.commPortID =
            CommPortIdentifier.getPortIdentifier(commPortLoc);
        for (int i = 0; i < tmpDevListeners.length; i++) {
          tmpDevListeners[i].deviceActive(
              new VCPDeviceEvent(
              this, DeviceEvent.DEVICE_ACTIVE, DeviceEvent.CAUSE_NORMAL));

          /*[2nd]*/
        }

        this.serialPort =
            (SerialPort) commPortID.open(configurationHeader, 15000);

        serialPort.notifyOnDataAvailable(true);

        this.tunnel = new Tunnel(
            this.serialPort.getInputStream(),
            this.serialPort.getOutputStream());

        this.frameWork = new FrameWork(tunnel);
        this.worker = new Worker(tunnel);
        this.tnt = new TNT(tunnel);

        this.serialPort.addEventListener(tunnel);
        this.open(numPorts);
        this.worker.start();

        for (int i = 0; i < tmpDevListeners.length; i++) {
          tmpDevListeners[i].deviceConnected(
              new VCPDeviceEvent(
              this, DeviceEvent.DEVICE_CONNECTED, DeviceEvent.CAUSE_NORMAL));
        }

      }
      catch (TooManyListenersException ex) {
        for (int i = 0; i < tmpDevListeners.length; i++) {
          tmpDevListeners[i].deviceInvalid(
              new VCPDeviceEvent(
              this, DeviceEvent.DEVICE_INVALID, DeviceEvent.CAUSE_UNKNOWN));
        }
      }
      catch (IOException ex) {
        for (int i = 0; i < tmpDevListeners.length; i++) {
          tmpDevListeners[i].deviceConnected(
              new VCPDeviceEvent(
              this, DeviceEvent.DEVICE_INVALID, DeviceEvent.CAUSE_DEVICE_BUSY));
        }
      }
      catch (PortInUseException ex) {
        for (int i = 0; i < tmpDevListeners.length; i++) {
          tmpDevListeners[i].deviceConnected(
              new VCPDeviceEvent(
              this, DeviceEvent.DEVICE_INVALID, DeviceEvent.CAUSE_DEVICE_BUSY));
        }
      }
      catch (NoSuchPortException ex) {
        for (int i = 0; i < tmpDevListeners.length; i++) {
          tmpDevListeners[i].deviceInvalid(
              new VCPDeviceEvent(
              this, DeviceEvent.DEVICE_INVALID,
              DeviceEvent.CAUSE_DEVICE_NOT_PRESENT));
        }
      }
      connectionInstance = true;
    }

    return 0L;
  }

  public void close() {
    if (connectionInstance) {
      DeviceEventListener[] tmpDevListeners = this.getDeviceEventListeners();

      worker.selfDestructButton(true);

      serialPort.removeEventListener();
      tnt.neutralize();
      frameWork.destroy();
      tunnel.destroyTunnel();

      worker = null;
      tnt = null;
      frameWork = null;
      tunnel = null;
      serialPort.close();
      commPortID = null;

      for (int i = 0; i < tmpDevListeners.length; i++) {
        tmpDevListeners[i].deviceDisconnected(
            new VCPDeviceEvent(
            this, DeviceEvent.DEVICE_DISCONNECTED, DeviceEvent.CAUSE_NORMAL));

      }
      connectionInstance = false;
    }
  }

  /**
   * getName
   *
   * @return String
   */
  public String getName() {
    return sig.deviceIdentity();
  }

}
