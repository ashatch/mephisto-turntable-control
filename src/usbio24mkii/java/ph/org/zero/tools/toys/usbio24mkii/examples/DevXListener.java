package ph.org.zero.tools.toys.usbio24mkii.examples;

import ph.org.zero.tools.toys.usbio24mkii.DeviceEventAdapter;
import ph.org.zero.tools.toys.usbio24mkii.DeviceEvent;

public class DevXListener
    extends DeviceEventAdapter {
  Frame1 adaptee;

  DevXListener(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void deviceActive(DeviceEvent event) {
    adaptee.txDevStat.setText("Device Active");
  }

  public void deviceConnected(DeviceEvent event) {
    adaptee.txDevStat.setText("Device Connected");
  }

  public void deviceDisconnected(DeviceEvent event) {
    adaptee.txDevStat.setText("set device number and then click connect");
  }

  public void deviceInvalid(DeviceEvent event) {
    adaptee.txDevStat.setText("Device Invalid");
  }
}
