package ph.org.zero.tools.toys.usbio24mkii.examples;

import ph.org.zero.tools.toys.usbio24mkii.port.PortEventAdapter;
import ph.org.zero.tools.toys.usbio24mkii.port.PortEvent;
import ph.org.zero.tools.toys.usbio24mkii.port.Port;

public class DevPortAListener
    extends PortEventAdapter {
  Frame1 adaptee;
  DevPortAListener(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void isPortRegistered(PortEvent evt) {
    Port lPortAlloc = ( (Port) evt.getSource());
    adaptee.ARegDec.setText("" +
                            lPortAlloc.getPortDirectionRegister()
                            );

    adaptee.ARegWHex.setText(
        Integer.toHexString(lPortAlloc.getPortDirectionRegister()).toUpperCase()
        );

    for (int i = 0; i < lPortAlloc.getPins().length; i++) {
      if (lPortAlloc.getPins()[i].getPinRegisterAsInput()) {
        //consider num of pins = num of buttons
        adaptee.regBtnGroupA[i].setText("I");
      }
      else {
        adaptee.regBtnGroupA[i].setText("O");
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
    adaptee.APinRHex.setText(
        Integer.toHexString(lPortAlloc.getPortBinaryData())
        );

    adaptee.APinWHex.setText(
        Integer.toHexString(lPortAlloc.getPortBinaryData())
        );

    adaptee.APinRDec.setText("" +
                             lPortAlloc.getPortBinaryData()

                             );

    adaptee.APinWDec.setText("" +
                             lPortAlloc.getPortBinaryData()
                             );

    for (int i = 0; i < lPortAlloc.getPins().length; i++) {
      if (lPortAlloc.getPins()[i].getPinState()) {
        //consider num of pins = num of buttons
        adaptee.buttonGroupA[i].setText("1");
      }
      else {
        adaptee.buttonGroupA[i].setText("0");
      }

    }
    lPortAlloc = null;

  }
}
