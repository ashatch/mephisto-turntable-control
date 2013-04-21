package ph.org.zero.tools.toys.usbio24mkii.examples;

import ph.org.zero.tools.toys.usbio24mkii.port.PortEventAdapter;
import ph.org.zero.tools.toys.usbio24mkii.port.PortEvent;
import ph.org.zero.tools.toys.usbio24mkii.port.Port;


public class DevPortCListener
    extends PortEventAdapter {
  Frame1 adaptee;
  DevPortCListener(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void isPortRegistered(PortEvent evt) {
    Port lPortAlloc = ( (Port) evt.getSource());
    adaptee.CRegDec.setText("" +
                            lPortAlloc.getPortDirectionRegister()
                            );

    adaptee.CRegWHex.setText(
        Integer.toHexString(lPortAlloc.getPortDirectionRegister()).toUpperCase()
        );

    for (int i = 0; i < lPortAlloc.getPins().length; i++) {
      if (lPortAlloc.getPins()[i].getPinRegisterAsInput()) {
        //consider num of pins = num of buttons
        adaptee.regBtnGroupC[i].setText("I");
      }
      else {
        adaptee.regBtnGroupC[i].setText("O");
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
    adaptee.CPinRDec.setText("" +
                             lPortAlloc.getPortBinaryData()
                             );
    adaptee.CPinWDec.setText("" +
                             lPortAlloc.getPortBinaryData()
                             );

    adaptee.CPinRHex.setText(
        Integer.toHexString(lPortAlloc.getPortBinaryData()).toUpperCase()
        );

    adaptee.CPinWHex.setText(
        Integer.toHexString(lPortAlloc.getPortBinaryData()).toUpperCase()
        );

    for (int i = 0; i < lPortAlloc.getPins().length; i++) {
      if (lPortAlloc.getPins()[i].getPinState()) {
        //consider num of pins = num of buttons
        adaptee.buttonGroupC[i].setText("1");
      }
      else {
        adaptee.buttonGroupC[i].setText("0");
      }

    }
    lPortAlloc = null;

  }
}
