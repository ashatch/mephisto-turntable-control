package ph.org.zero.tools.toys.usbio24mkii.examples;

import ph.org.zero.tools.toys.usbio24mkii.port.PortEventAdapter;
import ph.org.zero.tools.toys.usbio24mkii.port.PortEvent;
import ph.org.zero.tools.toys.usbio24mkii.port.Port;


public class DevPortBListener
    extends PortEventAdapter {
  Frame1 adaptee;
  DevPortBListener(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void isPortRegistered(PortEvent evt) {
    Port lPortAlloc = ( (Port) evt.getSource());
    adaptee.BRegDec.setText("" +
                            lPortAlloc.getPortDirectionRegister()
                            );

    adaptee.BRegWHex.setText(
        Integer.toHexString(lPortAlloc.getPortDirectionRegister()).toUpperCase()
        );

    for (int i = 0; i < lPortAlloc.getPins().length; i++) {
      if (lPortAlloc.getPins()[i].getPinRegisterAsInput()) {
        //consider num of pins = num of buttons
        adaptee.regBtnGroupB[i].setText("I");
      }
      else {
        adaptee.regBtnGroupB[i].setText("O");
      }

    }
    lPortAlloc = null;
  }

  public void isPortRegistering(PortEvent evt) {
    adaptee.txDevStat.setText("sending [" + evt.getSource() +
                              "] Registers command");
  }

  public void isPortWriting(PortEvent evt) {
    adaptee.txDevStat.setText("sending [" + evt.getSource() + "] IO command");
  }

  public void isPortWritten(PortEvent evt) {
    Port lPortAlloc = ( (Port) evt.getSource());
    adaptee.BPinRDec.setText("" +
                             lPortAlloc.getPortBinaryData()
                             );
    adaptee.BPinWDec.setText("" +
                             lPortAlloc.getPortBinaryData()
                             );

    adaptee.BPinRHex.setText(
        Integer.toHexString(lPortAlloc.getPortBinaryData()).toUpperCase()
        );

    adaptee.BPinWHex.setText(
        Integer.toHexString(lPortAlloc.getPortBinaryData()).toUpperCase()
        );

    for (int i = 0; i < lPortAlloc.getPins().length; i++) {
      if (lPortAlloc.getPins()[i].getPinState()) {
        //consider num of pins = num of buttons
        adaptee.buttonGroupB[i].setText("1");
      }
      else {
        adaptee.buttonGroupB[i].setText("0");
      }

    }
    lPortAlloc = null;

  }
}
