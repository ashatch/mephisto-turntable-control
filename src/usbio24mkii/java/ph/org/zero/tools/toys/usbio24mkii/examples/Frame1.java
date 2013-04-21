package ph.org.zero.tools.toys.usbio24mkii.examples;

import javax.swing.JFrame;
import javax.swing.JPanel;
import ph.org.zero.tools.toys.usbio24mkii.Device;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import ph.org.zero.tools.toys.usbio24mkii.port.pin.Pin;
import java.awt.event.KeyEvent;
import java.awt.AWTEvent;
import ph.org.zero.tools.toys.usbio24mkii.DevicePeerFactory;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.BorderFactory;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Frame1
    extends JFrame {
  JPanel contentPane;
  Device device;

  JButton[] buttonGroupA = new JButton[8];
  JButton[] buttonGroupB = new JButton[8];
  JButton[] buttonGroupC = new JButton[8];

  JButton[] regBtnGroupA = new JButton[8];
  JButton[] regBtnGroupB = new JButton[8];
  JButton[] regBtnGroupC = new JButton[8];

//  Pin[] PinsA;
//  Pin[] PinsB;
//  Pin[] PinsC;

  JPanel jPanel1 = new JPanel();
  JTextField BPinWDec = new JTextField();
  JButton BPin0x10 = new JButton();
  JButton APin0x01 = new JButton();
  JTextField CPinWDec = new JTextField();
  JButton CPin0x20 = new JButton();
  GridLayout gridLayout4 = new GridLayout();
  JTextField BPinWHex = new JTextField();
  JButton APin0x04 = new JButton();
  JLabel jLabel14 = new JLabel();
  JButton CPin0x08 = new JButton();
  GridLayout gridLayout2 = new GridLayout();
  JTextField APinWDec = new JTextField();
  JLabel jLabel9 = new JLabel();
  JButton CPin0x04 = new JButton();
  JButton APin0x10 = new JButton();
  GridLayout gridLayout3 = new GridLayout();
  JButton APin0x02 = new JButton();
  JLabel jLabel16 = new JLabel();
  JButton CPin0x80 = new JButton();
  JButton CPin0x02 = new JButton();
  JButton BPin0x40 = new JButton();
  JLabel jLabel17 = new JLabel();
  JPanel jPanel5 = new JPanel();
  JTextField APinWHex = new JTextField();
  JButton BPin0x02 = new JButton();
  JLabel jLabel6 = new JLabel();
  JButton BPin0x20 = new JButton();
  JButton APin0x20 = new JButton();
  JButton BPin0x04 = new JButton();
  JButton CPin0x40 = new JButton();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel13 = new JLabel();
  JPanel jPanel3 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JButton CPin0x01 = new JButton();
  JPanel jPanel2 = new JPanel();
  JButton BPin0x80 = new JButton();
  JLabel jLabel11 = new JLabel();
  JButton APin0x80 = new JButton();
  JLabel jLabel7 = new JLabel();
  JButton BPin0x01 = new JButton();
  JButton APin0x40 = new JButton();
  JButton CPin0x10 = new JButton();
  JButton APin0x08 = new JButton();
  JButton BPin0x08 = new JButton();
  JLabel jLabel15 = new JLabel();
  JTextField CPinWHex = new JTextField();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JLabel APinRHex = new JLabel();
  JLabel APinRDec = new JLabel();
  JLabel BPinRHex = new JLabel();
  JLabel BPinRDec = new JLabel();
  JLabel CPinRHex = new JLabel();
  JLabel CPinRDec = new JLabel();
  JLabel jLabel25 = new JLabel();
  JLabel txDevStat = new JLabel();
  JLabel jLabel27 = new JLabel();
  JTextField txCommPortLoc = new JTextField();
  JButton cmdConnect = new JButton();
  JTextField jTextField8 = new JTextField();
  JButton CPin0x11 = new JButton();
  JTextField jTextField9 = new JTextField();
  GridLayout gridLayout5 = new GridLayout();
  JTextField jTextField10 = new JTextField();
  JButton APin0x09 = new JButton();
  JLabel jLabel111 = new JLabel();
  JButton CPin0x03 = new JButton();
  JButton BPin0x03 = new JButton();
  GridLayout gridLayout6 = new GridLayout();
  JTextField jTextField11 = new JTextField();
  JLabel jLabel28 = new JLabel();
  JLabel jLabel29 = new JLabel();
  JButton CPin0x41 = new JButton();
  GridLayout gridLayout7 = new GridLayout();
  JLabel jLabel112 = new JLabel();
  JButton BPin0x05 = new JButton();
  JLabel jLabel113 = new JLabel();
  JButton BPin0x11 = new JButton();
  JPanel jPanel7 = new JPanel();
  JTextField jTextField12 = new JTextField();
  JButton APin0x05 = new JButton();
  JLabel jLabel30 = new JLabel();
  JButton CPin0x81 = new JButton();
  JLabel jLabel31 = new JLabel();
  JButton CPin0x09 = new JButton();
  JLabel jLabel32 = new JLabel();
  JLabel jLabel33 = new JLabel();
  JLabel jLabel210 = new JLabel();
  JButton APin0x03 = new JButton();
  JButton APin0x81 = new JButton();
  JLabel jLabel114 = new JLabel();
  JButton CPin0x05 = new JButton();
  JPanel jPanel8 = new JPanel();
  JLabel jLabel211 = new JLabel();
  JLabel jLabel34 = new JLabel();
  JLabel jLabel115 = new JLabel();
  JLabel jLabel35 = new JLabel();
  JPanel jPanel9 = new JPanel();
  GridLayout gridLayout8 = new GridLayout();
  JLabel jLabel36 = new JLabel();
  JLabel jLabel212 = new JLabel();
  JButton CPin0x06 = new JButton();
  JButton APin0x11 = new JButton();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JButton BPin0x21 = new JButton();
  JButton BPin0x81 = new JButton();
  JLabel jLabel116 = new JLabel();
  JButton APin0x06 = new JButton();
  JButton BPin0x41 = new JButton();
  JLabel jLabel117 = new JLabel();
  JButton BPin0x06 = new JButton();
  JLabel jLabel37 = new JLabel();
  JLabel jLabel213 = new JLabel();
  JLabel jLabel118 = new JLabel();
  JButton APin0x41 = new JButton();
  JButton CPin0x21 = new JButton();
  JLabel jLabel119 = new JLabel();
  JButton APin0x21 = new JButton();
  JTextField jTextField13 = new JTextField();
  JLabel jLabel120 = new JLabel();
  JButton BPin0x09 = new JButton();
  JTextField BRegDec = new JTextField();
  JTextField CRegDec = new JTextField();
  JButton CReg0x10 = new JButton();
  JTextField BRegWHex = new JTextField();
  GridLayout gridLayout9 = new GridLayout();
  JButton AReg0x08 = new JButton();
  JLabel jLabel121 = new JLabel();
  JButton BReg0x01 = new JButton();
  JButton CReg0x01 = new JButton();
  GridLayout gridLayout10 = new GridLayout();
  JTextField ARegDec = new JTextField();
  JLabel jLabel38 = new JLabel();
  JButton CReg0x40 = new JButton();
  GridLayout gridLayout11 = new GridLayout();
  JLabel jLabel122 = new JLabel();
  JButton BReg0x04 = new JButton();
  JLabel jLabel123 = new JLabel();
  JButton BReg0x10 = new JButton();
  JPanel jPanel6 = new JPanel();
  JTextField ARegWHex = new JTextField();
  JButton AReg0x04 = new JButton();
  JLabel jLabel39 = new JLabel();
  JButton CReg0x80 = new JButton();
  JButton CReg0x08 = new JButton();
  JLabel jLabel40 = new JLabel();
  JLabel jLabel41 = new JLabel();
  JLabel jLabel42 = new JLabel();
  JButton AReg0x01 = new JButton();
  JButton AReg0x80 = new JButton();
  JLabel jLabel124 = new JLabel();
  JButton CReg0x04 = new JButton();
  JPanel jPanel12 = new JPanel();
  JLabel jLabel43 = new JLabel();
  JLabel jLabel125 = new JLabel();
  JPanel jPanel13 = new JPanel();
  GridLayout gridLayout12 = new GridLayout();
  JButton CReg0x02 = new JButton();
  JButton AReg0x10 = new JButton();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  JButton BReg0x20 = new JButton();
  JButton BReg0x80 = new JButton();
  JButton AReg0x02 = new JButton();
  JButton BReg0x40 = new JButton();
  JLabel jLabel127 = new JLabel();
  JButton BReg0x02 = new JButton();
  JLabel jLabel46 = new JLabel();
  JButton AReg0x40 = new JButton();
  JLabel jLabel128 = new JLabel();
  JButton CReg0x20 = new JButton();
  JButton AReg0x20 = new JButton();
  JTextField CRegWHex = new JTextField();
  JButton BReg0x08 = new JButton();
  JLabel jLabel129 = new JLabel();

  //Construct the frame
  public Frame1() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
      device = new DevicePeerFactory().getDevicePeerName(null);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    contentPane = (JPanel)this.getContentPane();
    contentPane.setLayout(null);
    this.setResizable(false);
    this.setSize(new Dimension(538, 400));
    this.setState(Frame.NORMAL);
    this.setTitle("USBIO24 Java Test Utility");
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(7, 194, 518, 139));
    jPanel1.setLayout(null);
    BPinWDec.setBounds(new Rectangle(395, 72, 25, 21));
    BPinWDec.addKeyListener(new Frame1_BPinWDec_keyAdapter(this));
    BPinWDec.setHorizontalAlignment(SwingConstants.CENTER);
    BPinWDec.setText("255");
    BPinWDec.setBorder(BorderFactory.createEtchedBorder());
    BPinWDec.setFont(new java.awt.Font("Arial", 0, 9));
    BPinWDec.setBackground(Color.white);
    BPin0x10.setText("0");
    BPin0x10.addActionListener(new Frame1_BPin0x10_actionAdapter(this));
    BPin0x10.setBorder(BorderFactory.createEtchedBorder());
    BPin0x10.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x01.setText("0");
    APin0x01.addActionListener(new Frame1_APin0x01_actionAdapter(this));
    APin0x01.setBorder(BorderFactory.createEtchedBorder());
    APin0x01.setFont(new java.awt.Font("Tahoma", 0, 8));
    CPinWDec.setBounds(new Rectangle(395, 98, 25, 21));
    CPinWDec.addKeyListener(new Frame1_CPinWDec_keyAdapter(this));
    CPinWDec.setHorizontalAlignment(SwingConstants.CENTER);
    CPinWDec.setText("255");
    CPinWDec.setBorder(BorderFactory.createEtchedBorder());
    CPinWDec.setFont(new java.awt.Font("Arial", 0, 9));
    CPinWDec.setBackground(Color.white);
    CPin0x20.setText("0");
    CPin0x20.addActionListener(new Frame1_CPin0x20_actionAdapter(this));
    CPin0x20.setBorder(BorderFactory.createEtchedBorder());
    CPin0x20.setFont(new java.awt.Font("Tahoma", 0, 8));
    gridLayout4.setColumns(8);
    BPinWHex.setBackground(Color.white);
    BPinWHex.setFont(new java.awt.Font("Arial", 0, 9));
    BPinWHex.setBorder(BorderFactory.createEtchedBorder());
    BPinWHex.setHorizontalAlignment(SwingConstants.CENTER);
    BPinWHex.setText("FF");
    BPinWHex.setBounds(new Rectangle(360, 72, 25, 21));
    BPinWHex.addKeyListener(new Frame1_BPinWHex_keyAdapter(this));
    APin0x04.setText("0");
    APin0x04.addActionListener(new Frame1_APin0x04_actionAdapter(this));
    APin0x04.setBorder(BorderFactory.createEtchedBorder());
    APin0x04.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel14.setBounds(new Rectangle(6, 74, 34, 16));
    jLabel14.setText("B");
    jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10));
    CPin0x08.setText("0");
    CPin0x08.addActionListener(new Frame1_CPin0x08_actionAdapter(this));
    CPin0x08.setBorder(BorderFactory.createEtchedBorder());
    CPin0x08.setFont(new java.awt.Font("Tahoma", 0, 8));
    gridLayout2.setColumns(8);
    gridLayout2.setRows(1);
    APinWDec.setBackground(Color.white);
    APinWDec.setFont(new java.awt.Font("Arial", 0, 9));
    APinWDec.setBorder(BorderFactory.createEtchedBorder());
    APinWDec.setHorizontalAlignment(SwingConstants.CENTER);
    APinWDec.setText("255");
    APinWDec.setBounds(new Rectangle(395, 45, 25, 21));
    APinWDec.addKeyListener(new Frame1_APinWDec_keyAdapter(this));
    jLabel9.setText("0x04");
    jLabel9.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
    CPin0x04.setText("0");
    CPin0x04.addActionListener(new Frame1_CPin0x04_actionAdapter(this));
    CPin0x04.setBorder(BorderFactory.createEtchedBorder());
    CPin0x04.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x10.setText("0");
    APin0x10.addActionListener(new Frame1_APin0x10_actionAdapter(this));
    APin0x10.setBorder(BorderFactory.createEtchedBorder());
    APin0x10.setFont(new java.awt.Font("Tahoma", 0, 8));
    gridLayout3.setColumns(8);
    gridLayout3.setRows(1);
    APin0x02.setText("0");
    APin0x02.addActionListener(new Frame1_APin0x02_actionAdapter(this));
    APin0x02.setBorder(BorderFactory.createEtchedBorder());
    APin0x02.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel16.setBounds(new Rectangle(358, 22, 28, 14));
    jLabel16.setText("HEX");
    jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel16.setRequestFocusEnabled(true);
    jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10));
    CPin0x80.setText("0");
    CPin0x80.addActionListener(new Frame1_CPin0x80_actionAdapter(this));
    CPin0x80.setBorder(BorderFactory.createEtchedBorder());
    CPin0x80.setFont(new java.awt.Font("Tahoma", 0, 8));
    CPin0x02.setText("0");
    CPin0x02.addActionListener(new Frame1_CPin0x02_actionAdapter(this));
    CPin0x02.setBorder(BorderFactory.createEtchedBorder());
    CPin0x02.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x40.setText("0");
    BPin0x40.addActionListener(new Frame1_BPin0x40_actionAdapter(this));
    BPin0x40.setBorder(BorderFactory.createEtchedBorder());
    BPin0x40.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel17.setBounds(new Rectangle(393, 22, 28, 14));
    jLabel17.setText("DEC");
    jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
    jPanel5.setLayout(gridLayout1);
    jPanel5.setBounds(new Rectangle(49, 45, 308, 21));
    APinWHex.setBackground(Color.white);
    APinWHex.setFont(new java.awt.Font("Arial", 0, 9));
    APinWHex.setBorder(BorderFactory.createEtchedBorder());
    APinWHex.setText("FF");
    APinWHex.setHorizontalAlignment(SwingConstants.CENTER);
    APinWHex.setBounds(new Rectangle(360, 45, 25, 21));
    APinWHex.addKeyListener(new Frame1_APinWHex_keyAdapter(this));
    BPin0x02.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x02.setBorder(BorderFactory.createEtchedBorder());
    BPin0x02.setText("0");
    BPin0x02.addActionListener(new Frame1_BPin0x02_actionAdapter(this));
    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel6.setText("0x20");
    BPin0x20.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x20.setBorder(BorderFactory.createEtchedBorder());
    BPin0x20.setText("0");
    BPin0x20.addActionListener(new Frame1_BPin0x20_actionAdapter(this));
    APin0x20.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x20.setBorder(BorderFactory.createEtchedBorder());
    APin0x20.setText("0");
    APin0x20.addActionListener(new Frame1_APin0x20_actionAdapter(this));
    BPin0x04.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x04.setBorder(BorderFactory.createEtchedBorder());
    BPin0x04.setText("0");
    BPin0x04.addActionListener(new Frame1_BPin0x04_actionAdapter(this));
    CPin0x40.setFont(new java.awt.Font("Tahoma", 0, 8));
    CPin0x40.setBorder(BorderFactory.createEtchedBorder());
    CPin0x40.setText("0");
    CPin0x40.addActionListener(new Frame1_CPin0x40_actionAdapter(this));
    jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel5.setText("0x40");
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setText("0x80");
    jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel8.setText("0x08");
    jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel12.setText("PORT");
    jLabel12.setBounds(new Rectangle(6, 21, 34, 16));
    jPanel4.setBounds(new Rectangle(49, 18, 308, 22));
    jPanel4.setLayout(gridLayout4);
    jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel13.setText("A");
    jLabel13.setBounds(new Rectangle(6, 47, 34, 16));
    jPanel3.setLayout(gridLayout3);
    jPanel3.setBorder(null);
    jPanel3.setBounds(new Rectangle(49, 98, 308, 21));
    gridLayout1.setColumns(8);
    gridLayout1.setRows(1);
    CPin0x01.setFont(new java.awt.Font("Tahoma", 0, 8));
    CPin0x01.setBorder(BorderFactory.createEtchedBorder());
    CPin0x01.setText("0");
    CPin0x01.addActionListener(new Frame1_CPin0x01_actionAdapter(this));
    jPanel2.setLayout(gridLayout2);
    jPanel2.setBorder(null);
    jPanel2.setBounds(new Rectangle(49, 72, 308, 21));
    BPin0x80.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x80.setBorder(BorderFactory.createEtchedBorder());
    BPin0x80.setText("0");
    BPin0x80.addActionListener(new Frame1_BPin0x80_actionAdapter(this));
    jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel11.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel11.setText("0x01");
    APin0x80.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x80.setBorder(BorderFactory.createEtchedBorder());
    APin0x80.setText("0");
    APin0x80.addActionListener(new Frame1_APin0x80_actionAdapter(this));
    jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel7.setText("0x10");
    BPin0x01.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x01.setBorder(BorderFactory.createEtchedBorder());
    BPin0x01.setText("0");
    BPin0x01.addActionListener(new Frame1_BPin0x01_actionAdapter(this));
    APin0x40.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x40.setBorder(BorderFactory.createEtchedBorder());
    APin0x40.setText("0");
    APin0x40.addActionListener(new Frame1_APin0x40_actionAdapter(this));
    CPin0x10.setFont(new java.awt.Font("Tahoma", 0, 8));
    CPin0x10.setBorder(BorderFactory.createEtchedBorder());
    CPin0x10.setText("0");
    CPin0x10.addActionListener(new Frame1_CPin0x10_actionAdapter(this));
    APin0x08.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x08.setBorder(BorderFactory.createEtchedBorder());
    APin0x08.setText("0");
    APin0x08.addActionListener(new Frame1_APin0x08_actionAdapter(this));
    BPin0x08.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x08.setBorder(BorderFactory.createEtchedBorder());
    BPin0x08.setText("0");
    BPin0x08.addActionListener(new Frame1_BPin0x08_actionAdapter(this));
    jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel15.setText("C");
    jLabel15.setBounds(new Rectangle(6, 100, 34, 16));
    CPinWHex.setBounds(new Rectangle(360, 98, 25, 21));
    CPinWHex.addKeyListener(new Frame1_CPinWHex_keyAdapter(this));
    CPinWHex.setText("FF");
    CPinWHex.setHorizontalAlignment(SwingConstants.CENTER);
    CPinWHex.setBorder(BorderFactory.createEtchedBorder());
    CPinWHex.setFont(new java.awt.Font("Arial", 0, 9));
    CPinWHex.setBackground(Color.white);
    jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel10.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel10.setText("0x02");
    jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel18.setText("Port Value");
    jLabel18.setBounds(new Rectangle(8, 176, 70, 14));

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel1.setBorder(null);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Write Value");
    jLabel1.setBounds(new Rectangle(362, 8, 58, 14));
    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("Read Value");
    jLabel2.setBounds(new Rectangle(437, 8, 57, 14));
    jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel19.setRequestFocusEnabled(true);
    jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel19.setText("HEX");
    jLabel19.setBounds(new Rectangle(436, 22, 28, 14));
    jLabel110.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel110.setText("DEC");
    jLabel110.setBounds(new Rectangle(471, 22, 28, 14));
    APinRHex.setFont(new java.awt.Font("Tahoma", 0, 9));
    APinRHex.setBorder(BorderFactory.createEtchedBorder());
    APinRHex.setText("");
    APinRHex.setBounds(new Rectangle(438, 45, 25, 21));
    APinRDec.setBounds(new Rectangle(473, 45, 25, 21));
    APinRDec.setFont(new java.awt.Font("Tahoma", 0, 9));
    APinRDec.setBorder(BorderFactory.createEtchedBorder());
    APinRDec.setText("");
    BPinRHex.setBounds(new Rectangle(438, 72, 25, 21));
    BPinRHex.setFont(new java.awt.Font("Tahoma", 0, 9));
    BPinRHex.setBorder(BorderFactory.createEtchedBorder());
    BPinRHex.setText("");
    BPinRDec.setBounds(new Rectangle(473, 72, 25, 21));
    BPinRDec.setFont(new java.awt.Font("Tahoma", 0, 9));
    BPinRDec.setBorder(BorderFactory.createEtchedBorder());
    BPinRDec.setText("");
    CPinRHex.setBounds(new Rectangle(438, 98, 25, 21));
    CPinRHex.setFont(new java.awt.Font("Tahoma", 0, 9));
    CPinRHex.setBorder(BorderFactory.createEtchedBorder());
    CPinRHex.setText("");
    CPinRDec.setBounds(new Rectangle(473, 98, 25, 21));
    CPinRDec.setFont(new java.awt.Font("Tahoma", 0, 9));
    CPinRDec.setBorder(BorderFactory.createEtchedBorder());
    CPinRDec.setText("");
    jLabel25.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel25.setText("Direction Register I/O");
    jLabel25.setBounds(new Rectangle(10, 17, 122, 14));
    txDevStat.setFont(new java.awt.Font("Tahoma", 0, 10));
    txDevStat.setForeground(Color.black);
    txDevStat.setBorder(BorderFactory.createLoweredBevelBorder());
    txDevStat.setHorizontalAlignment(SwingConstants.CENTER);
    txDevStat.setText("set device number and then click connect");
    txDevStat.setBounds(new Rectangle(7, 339, 518, 17));
    jLabel27.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel27.setText("Port Location");
    jLabel27.setBounds(new Rectangle(175, 17, 71, 14));
    txCommPortLoc.setFont(new java.awt.Font("Dialog", 0, 10));
    txCommPortLoc.setText("COM4");
    txCommPortLoc.setBounds(new Rectangle(242, 11, 66, 20));
    cmdConnect.setBounds(new Rectangle(332, 11, 105, 20));
    cmdConnect.setFont(new java.awt.Font("Tahoma", 0, 10));
    cmdConnect.setBorder(BorderFactory.createEtchedBorder());
    cmdConnect.setText("connect");
    cmdConnect.addActionListener(new Frame1_cmdConnect_actionAdapter(this));
    jTextField8.setBackground(Color.white);
    jTextField8.setFont(new java.awt.Font("Arial", 0, 9));
    jTextField8.setBorder(BorderFactory.createEtchedBorder());
    jTextField8.setText("255");
    jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField8.setBounds(new Rectangle(395, 72, 25, 21));
    CPin0x11.setText("0");
    CPin0x11.setBorder(BorderFactory.createEtchedBorder());
    CPin0x11.setFont(new java.awt.Font("Tahoma", 0, 8));
    jTextField9.setBackground(Color.white);
    jTextField9.setFont(new java.awt.Font("Arial", 0, 9));
    jTextField9.setBorder(BorderFactory.createEtchedBorder());
    jTextField9.setText("255");
    jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField9.setBounds(new Rectangle(395, 98, 25, 21));
    gridLayout5.setColumns(8);
    jTextField10.setBounds(new Rectangle(360, 72, 25, 21));
    jTextField10.setText("FF");
    jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField10.setBorder(BorderFactory.createEtchedBorder());
    jTextField10.setFont(new java.awt.Font("Arial", 0, 9));
    jTextField10.setBackground(Color.white);
    APin0x09.setText("0");
    APin0x09.setBorder(BorderFactory.createEtchedBorder());
    APin0x09.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel111.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel111.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel111.setText("B");
    jLabel111.setBounds(new Rectangle(6, 74, 34, 16));
    CPin0x03.setText("0");
    CPin0x03.setBorder(BorderFactory.createEtchedBorder());
    CPin0x03.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x03.setText("0");
    BPin0x03.setBorder(BorderFactory.createEtchedBorder());
    BPin0x03.setFont(new java.awt.Font("Tahoma", 0, 8));
    gridLayout6.setRows(1);
    gridLayout6.setColumns(8);
    jTextField11.setBounds(new Rectangle(395, 45, 25, 21));
    jTextField11.setText("255");
    jTextField11.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField11.setBorder(BorderFactory.createEtchedBorder());
    jTextField11.setFont(new java.awt.Font("Arial", 0, 9));
    jTextField11.setBackground(Color.white);
    jLabel28.setText("");
    jLabel28.setBorder(BorderFactory.createEtchedBorder());
    jLabel28.setFont(new java.awt.Font("Tahoma", 0, 9));
    jLabel28.setBounds(new Rectangle(438, 98, 25, 21));
    jLabel29.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel29.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel29.setText("0x04");
    CPin0x41.setText("0");
    CPin0x41.setBorder(BorderFactory.createEtchedBorder());
    CPin0x41.setFont(new java.awt.Font("Tahoma", 0, 8));
    gridLayout7.setRows(1);
    gridLayout7.setColumns(8);
    jLabel112.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel112.setRequestFocusEnabled(true);
    jLabel112.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel112.setText("HEX");
    jLabel112.setBounds(new Rectangle(358, 22, 28, 14));
    BPin0x05.setText("0");
    BPin0x05.setBorder(BorderFactory.createEtchedBorder());
    BPin0x05.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel113.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel113.setText("DEC");
    jLabel113.setBounds(new Rectangle(393, 22, 28, 14));
    BPin0x11.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x11.setBorder(BorderFactory.createEtchedBorder());
    BPin0x11.setText("0");
    jPanel7.setLayout(null);
    jPanel7.setBounds(new Rectangle(7, 194, 518, 139));
    jPanel7.setBorder(BorderFactory.createEtchedBorder());
    jTextField12.setBackground(Color.white);
    jTextField12.setFont(new java.awt.Font("Arial", 0, 9));
    jTextField12.setBorder(BorderFactory.createEtchedBorder());
    jTextField12.setText("FF");
    jTextField12.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField12.setBounds(new Rectangle(360, 45, 25, 21));
    APin0x05.setText("0");
    APin0x05.setBorder(BorderFactory.createEtchedBorder());
    APin0x05.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel30.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel30.setText("0x20");
    CPin0x81.setText("0");
    CPin0x81.setBorder(BorderFactory.createEtchedBorder());
    CPin0x81.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel31.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel31.setText("0x40");
    CPin0x09.setText("0");
    CPin0x09.setBorder(BorderFactory.createEtchedBorder());
    CPin0x09.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel32.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel32.setText("0x08");
    jLabel33.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel33.setText("0x80");
    jLabel210.setBounds(new Rectangle(438, 72, 25, 21));
    jLabel210.setFont(new java.awt.Font("Tahoma", 0, 9));
    jLabel210.setBorder(BorderFactory.createEtchedBorder());
    jLabel210.setText("");
    APin0x03.setText("0");
    APin0x03.setBorder(BorderFactory.createEtchedBorder());
    APin0x03.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x81.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x81.setBorder(BorderFactory.createEtchedBorder());
    APin0x81.setText("0");
    jLabel114.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel114.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel114.setText("PORT");
    jLabel114.setBounds(new Rectangle(6, 21, 34, 16));
    CPin0x05.setText("0");
    CPin0x05.setBorder(BorderFactory.createEtchedBorder());
    CPin0x05.setFont(new java.awt.Font("Tahoma", 0, 8));
    jPanel8.setBounds(new Rectangle(49, 18, 308, 22));
    jPanel8.setLayout(gridLayout5);
    jLabel211.setBounds(new Rectangle(473, 45, 25, 21));
    jLabel211.setFont(new java.awt.Font("Tahoma", 0, 9));
    jLabel211.setBorder(BorderFactory.createEtchedBorder());
    jLabel211.setText("");
    jLabel34.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel34.setBorder(null);
    jLabel34.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel34.setText("Write Value");
    jLabel34.setBounds(new Rectangle(362, 8, 58, 14));
    jLabel115.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel115.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel115.setText("A");
    jLabel115.setBounds(new Rectangle(6, 47, 34, 16));
    jLabel35.setFont(new java.awt.Font("Tahoma", 0, 9));
    jLabel35.setBorder(BorderFactory.createEtchedBorder());
    jLabel35.setText("");
    jLabel35.setBounds(new Rectangle(438, 45, 25, 21));
    jPanel9.setLayout(gridLayout7);
    jPanel9.setBorder(null);
    jPanel9.setBounds(new Rectangle(49, 98, 308, 21));
    gridLayout8.setColumns(8);
    gridLayout8.setRows(1);
    jLabel36.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel36.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel36.setText("Read Value");
    jLabel36.setBounds(new Rectangle(437, 8, 57, 14));
    jLabel212.setBounds(new Rectangle(473, 98, 25, 21));
    jLabel212.setFont(new java.awt.Font("Tahoma", 0, 9));
    jLabel212.setBorder(BorderFactory.createEtchedBorder());
    jLabel212.setText("");
    CPin0x06.setText("0");
    CPin0x06.setBorder(BorderFactory.createEtchedBorder());
    CPin0x06.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x11.setText("0");
    APin0x11.setBorder(BorderFactory.createEtchedBorder());
    APin0x11.setFont(new java.awt.Font("Tahoma", 0, 8));
    jPanel10.setLayout(gridLayout6);
    jPanel10.setBorder(null);
    jPanel10.setBounds(new Rectangle(49, 72, 308, 21));
    jPanel11.setLayout(gridLayout8);
    jPanel11.setBounds(new Rectangle(49, 45, 308, 21));
    BPin0x21.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x21.setBorder(BorderFactory.createEtchedBorder());
    BPin0x21.setText("0");
    BPin0x81.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x81.setBorder(BorderFactory.createEtchedBorder());
    BPin0x81.setText("0");
    jLabel116.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel116.setRequestFocusEnabled(true);
    jLabel116.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel116.setText("HEX");
    jLabel116.setBounds(new Rectangle(436, 22, 28, 14));
    APin0x06.setText("0");
    APin0x06.setBorder(BorderFactory.createEtchedBorder());
    APin0x06.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x41.setText("0");
    BPin0x41.setBorder(BorderFactory.createEtchedBorder());
    BPin0x41.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel117.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel117.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel117.setText("0x01");
    BPin0x06.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x06.setBorder(BorderFactory.createEtchedBorder());
    BPin0x06.setText("0");
    jLabel37.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel37.setText("0x10");
    jLabel213.setBounds(new Rectangle(473, 72, 25, 21));
    jLabel213.setFont(new java.awt.Font("Tahoma", 0, 9));
    jLabel213.setBorder(BorderFactory.createEtchedBorder());
    jLabel213.setText("");
    jLabel118.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel118.setText("DEC");
    jLabel118.setBounds(new Rectangle(471, 22, 28, 14));
    APin0x41.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x41.setBorder(BorderFactory.createEtchedBorder());
    APin0x41.setText("0");
    CPin0x21.setText("0");
    CPin0x21.setBorder(BorderFactory.createEtchedBorder());
    CPin0x21.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel119.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel119.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel119.setText("C");
    jLabel119.setBounds(new Rectangle(6, 100, 34, 16));
    APin0x21.setFont(new java.awt.Font("Tahoma", 0, 8));
    APin0x21.setBorder(BorderFactory.createEtchedBorder());
    APin0x21.setText("0");
    jTextField13.setBounds(new Rectangle(360, 98, 25, 21));
    jTextField13.setText("FF");
    jTextField13.setHorizontalAlignment(SwingConstants.CENTER);
    jTextField13.setBorder(BorderFactory.createEtchedBorder());
    jTextField13.setFont(new java.awt.Font("Arial", 0, 9));
    jTextField13.setBackground(Color.white);
    jLabel120.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel120.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel120.setText("0x02");
    BPin0x09.setFont(new java.awt.Font("Tahoma", 0, 8));
    BPin0x09.setBorder(BorderFactory.createEtchedBorder());
    BPin0x09.setText("0");
    BRegDec.setBackground(Color.white);
    BRegDec.setFont(new java.awt.Font("Arial", 0, 9));
    BRegDec.setBorder(BorderFactory.createEtchedBorder());
    BRegDec.setText("255");
    BRegDec.setHorizontalAlignment(SwingConstants.CENTER);
    BRegDec.setBounds(new Rectangle(395, 72, 25, 21));
    BRegDec.addKeyListener(new Frame1_BRegDec_keyAdapter(this));
    CRegDec.setBackground(Color.white);
    CRegDec.setFont(new java.awt.Font("Arial", 0, 9));
    CRegDec.setBorder(BorderFactory.createEtchedBorder());
    CRegDec.setText("255");
    CRegDec.setHorizontalAlignment(SwingConstants.CENTER);
    CRegDec.setBounds(new Rectangle(395, 98, 25, 21));
    CRegDec.addKeyListener(new Frame1_CRegDec_keyAdapter(this));
    CReg0x10.setText("I");
    CReg0x10.addActionListener(new Frame1_CReg0x10_actionAdapter(this));
    CReg0x10.setBorder(BorderFactory.createEtchedBorder());
    CReg0x10.setFont(new java.awt.Font("Tahoma", 0, 8));
    BRegWHex.setBounds(new Rectangle(360, 72, 25, 21));
    BRegWHex.addKeyListener(new Frame1_BRegWHex_keyAdapter(this));
    BRegWHex.setText("FF");
    BRegWHex.setHorizontalAlignment(SwingConstants.CENTER);
    BRegWHex.setBorder(BorderFactory.createEtchedBorder());
    BRegWHex.setFont(new java.awt.Font("Arial", 0, 9));
    BRegWHex.setBackground(Color.white);
    gridLayout9.setColumns(8);
    AReg0x08.setText("I");
    AReg0x08.addActionListener(new Frame1_AReg0x08_actionAdapter(this));
    AReg0x08.setBorder(BorderFactory.createEtchedBorder());
    AReg0x08.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel121.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel121.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel121.setText("B");
    jLabel121.setBounds(new Rectangle(6, 74, 34, 16));
    BReg0x01.setText("I");
    BReg0x01.addActionListener(new Frame1_BReg0x01_actionAdapter(this));
    BReg0x01.setBorder(BorderFactory.createEtchedBorder());
    BReg0x01.setFont(new java.awt.Font("Tahoma", 0, 8));
    CReg0x01.setText("I");
    CReg0x01.addActionListener(new Frame1_CReg0x01_actionAdapter(this));
    CReg0x01.setBorder(BorderFactory.createEtchedBorder());
    CReg0x01.setFont(new java.awt.Font("Tahoma", 0, 8));
    gridLayout10.setRows(1);
    gridLayout10.setColumns(8);
    ARegDec.setBounds(new Rectangle(395, 45, 25, 21));
    ARegDec.addKeyListener(new Frame1_ARegDec_keyAdapter(this));
    ARegDec.setText("255");
    ARegDec.setHorizontalAlignment(SwingConstants.CENTER);
    ARegDec.setBorder(BorderFactory.createEtchedBorder());
    ARegDec.setFont(new java.awt.Font("Arial", 0, 9));
    ARegDec.setBackground(Color.white);
    jLabel38.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel38.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel38.setText("0x04");
    CReg0x40.setText("I");
    CReg0x40.addActionListener(new Frame1_CReg0x40_actionAdapter(this));
    CReg0x40.setBorder(BorderFactory.createEtchedBorder());
    CReg0x40.setFont(new java.awt.Font("Tahoma", 0, 8));
    gridLayout11.setRows(1);
    gridLayout11.setColumns(8);
    jLabel122.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel122.setRequestFocusEnabled(true);
    jLabel122.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel122.setText("HEX");
    jLabel122.setBounds(new Rectangle(358, 22, 28, 14));
    BReg0x04.setText("I");
    BReg0x04.addActionListener(new Frame1_BReg0x04_actionAdapter(this));
    BReg0x04.setBorder(BorderFactory.createEtchedBorder());
    BReg0x04.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel123.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel123.setText("DEC");
    jLabel123.setBounds(new Rectangle(393, 22, 28, 14));
    BReg0x10.setFont(new java.awt.Font("Tahoma", 0, 8));
    BReg0x10.setBorder(BorderFactory.createEtchedBorder());
    BReg0x10.setText("I");
    BReg0x10.addActionListener(new Frame1_BReg0x10_actionAdapter(this));
    jPanel6.setLayout(null);
    jPanel6.setBounds(new Rectangle(7, 33, 431, 139));
    jPanel6.setBorder(BorderFactory.createEtchedBorder());
    ARegWHex.setBackground(Color.white);
    ARegWHex.setFont(new java.awt.Font("Arial", 0, 9));
    ARegWHex.setBorder(BorderFactory.createEtchedBorder());
    ARegWHex.setText("FF");
    ARegWHex.setHorizontalAlignment(SwingConstants.CENTER);
    ARegWHex.setBounds(new Rectangle(360, 45, 25, 21));
    ARegWHex.addKeyListener(new Frame1_ARegWHex_keyAdapter(this));
    AReg0x04.setText("I");
    AReg0x04.addActionListener(new Frame1_AReg0x04_actionAdapter(this));
    AReg0x04.setBorder(BorderFactory.createEtchedBorder());
    AReg0x04.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel39.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel39.setText("0x20");
    CReg0x80.setText("I");
    CReg0x80.addActionListener(new Frame1_CReg0x80_actionAdapter(this));
    CReg0x80.setBorder(BorderFactory.createEtchedBorder());
    CReg0x80.setFont(new java.awt.Font("Tahoma", 0, 8));
    CReg0x08.setText("I");
    CReg0x08.addActionListener(new Frame1_CReg0x08_actionAdapter(this));
    CReg0x08.setBorder(BorderFactory.createEtchedBorder());
    CReg0x08.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel40.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel40.setText("0x40");
    jLabel41.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel41.setText("0x08");
    jLabel42.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel42.setText("0x80");
    AReg0x01.setText("I");
    AReg0x01.addActionListener(new Frame1_AReg0x01_actionAdapter(this));
    AReg0x01.setBorder(BorderFactory.createEtchedBorder());
    AReg0x01.setFont(new java.awt.Font("Tahoma", 0, 8));
    AReg0x80.setFont(new java.awt.Font("Tahoma", 0, 8));
    AReg0x80.setBorder(BorderFactory.createEtchedBorder());
    AReg0x80.setText("I");
    AReg0x80.addActionListener(new Frame1_AReg0x80_actionAdapter(this));
    jLabel124.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel124.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel124.setText("PORT");
    jLabel124.setBounds(new Rectangle(6, 21, 34, 16));
    CReg0x04.setText("I");
    CReg0x04.addActionListener(new Frame1_CReg0x04_actionAdapter(this));
    CReg0x04.setBorder(BorderFactory.createEtchedBorder());
    CReg0x04.setFont(new java.awt.Font("Tahoma", 0, 8));
    jPanel12.setBounds(new Rectangle(49, 18, 308, 22));
    jPanel12.setLayout(gridLayout9);
    jLabel43.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel43.setBorder(null);
    jLabel43.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel43.setText("Write Value");
    jLabel43.setBounds(new Rectangle(362, 8, 58, 14));
    jLabel125.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel125.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel125.setText("A");
    jLabel125.setBounds(new Rectangle(6, 47, 34, 16));
    jPanel13.setLayout(gridLayout11);
    jPanel13.setBorder(null);
    jPanel13.setBounds(new Rectangle(49, 98, 308, 21));
    gridLayout12.setColumns(8);
    gridLayout12.setRows(1);
    CReg0x02.setText("I");
    CReg0x02.addActionListener(new Frame1_CReg0x02_actionAdapter(this));
    CReg0x02.setBorder(BorderFactory.createEtchedBorder());
    CReg0x02.setFont(new java.awt.Font("Tahoma", 0, 8));
    AReg0x10.setText("I");
    AReg0x10.addActionListener(new Frame1_AReg0x10_actionAdapter(this));
    AReg0x10.setBorder(BorderFactory.createEtchedBorder());
    AReg0x10.setFont(new java.awt.Font("Tahoma", 0, 8));
    jPanel14.setLayout(gridLayout10);
    jPanel14.setBorder(null);
    jPanel14.setBounds(new Rectangle(49, 72, 308, 21));
    jPanel15.setLayout(gridLayout12);
    jPanel15.setBounds(new Rectangle(49, 45, 308, 21));
    BReg0x20.setFont(new java.awt.Font("Tahoma", 0, 8));
    BReg0x20.setBorder(BorderFactory.createEtchedBorder());
    BReg0x20.setText("I");
    BReg0x20.addActionListener(new Frame1_BReg0x20_actionAdapter(this));
    BReg0x80.setFont(new java.awt.Font("Tahoma", 0, 8));
    BReg0x80.setBorder(BorderFactory.createEtchedBorder());
    BReg0x80.setText("I");
    BReg0x80.addActionListener(new Frame1_BReg0x80_actionAdapter(this));
    AReg0x02.setText("I");
    AReg0x02.addActionListener(new Frame1_AReg0x02_actionAdapter(this));
    AReg0x02.setBorder(BorderFactory.createEtchedBorder());
    AReg0x02.setFont(new java.awt.Font("Tahoma", 0, 8));
    BReg0x40.setText("I");
    BReg0x40.addActionListener(new Frame1_BReg0x40_actionAdapter(this));
    BReg0x40.setBorder(BorderFactory.createEtchedBorder());
    BReg0x40.setFont(new java.awt.Font("Tahoma", 0, 8));
    jLabel127.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel127.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel127.setText("0x01");
    BReg0x02.setFont(new java.awt.Font("Tahoma", 0, 8));
    BReg0x02.setBorder(BorderFactory.createEtchedBorder());
    BReg0x02.setText("I");
    BReg0x02.addActionListener(new Frame1_BReg0x02_actionAdapter(this));
    jLabel46.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel46.setText("0x10");
    AReg0x40.setFont(new java.awt.Font("Tahoma", 0, 8));
    AReg0x40.setBorder(BorderFactory.createEtchedBorder());
    AReg0x40.setText("I");
    AReg0x40.addActionListener(new Frame1_AReg0x40_actionAdapter(this));
    jLabel128.setFont(new java.awt.Font("Tahoma", 0, 10));
    jLabel128.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel128.setText("C");
    jLabel128.setBounds(new Rectangle(6, 100, 34, 16));
    CReg0x20.setText("I");
    CReg0x20.addActionListener(new Frame1_CReg0x20_actionAdapter(this));
    CReg0x20.setBorder(BorderFactory.createEtchedBorder());
    CReg0x20.setFont(new java.awt.Font("Tahoma", 0, 8));
    AReg0x20.setFont(new java.awt.Font("Tahoma", 0, 8));
    AReg0x20.setBorder(BorderFactory.createEtchedBorder());
    AReg0x20.setText("I");
    AReg0x20.addActionListener(new Frame1_AReg0x20_actionAdapter(this));
    CRegWHex.setBounds(new Rectangle(360, 98, 25, 21));
    CRegWHex.addKeyListener(new Frame1_CRegWHex_keyAdapter(this));
    CRegWHex.setText("FF");
    CRegWHex.setHorizontalAlignment(SwingConstants.CENTER);
    CRegWHex.setBorder(BorderFactory.createEtchedBorder());
    CRegWHex.setFont(new java.awt.Font("Arial", 0, 9));
    CRegWHex.setBackground(Color.white);
    BReg0x08.setFont(new java.awt.Font("Tahoma", 0, 8));
    BReg0x08.setBorder(BorderFactory.createEtchedBorder());
    BReg0x08.setText("I");
    BReg0x08.addActionListener(new Frame1_BReg0x08_actionAdapter(this));
    jLabel129.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel129.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel129.setText("0x02");
    contentPane.add(jPanel1, null);

    buttonGroupA[7] = APin0x80;
    buttonGroupA[6] = APin0x40;
    buttonGroupA[5] = APin0x20;
    buttonGroupA[4] = APin0x10;
    buttonGroupA[3] = APin0x08;
    buttonGroupA[2] = APin0x04;
    buttonGroupA[1] = APin0x02;
    buttonGroupA[0] = APin0x01;

    buttonGroupB[7] = BPin0x80;
    buttonGroupB[6] = BPin0x40;
    buttonGroupB[5] = BPin0x20;
    buttonGroupB[4] = BPin0x10;
    buttonGroupB[3] = BPin0x08;
    buttonGroupB[2] = BPin0x04;
    buttonGroupB[1] = BPin0x02;
    buttonGroupB[0] = BPin0x01;

    buttonGroupC[7] = CPin0x80;
    buttonGroupC[6] = CPin0x40;
    buttonGroupC[5] = CPin0x20;
    buttonGroupC[4] = CPin0x10;
    buttonGroupC[3] = CPin0x08;
    buttonGroupC[2] = CPin0x04;
    buttonGroupC[1] = CPin0x02;
    buttonGroupC[0] = CPin0x01;

    regBtnGroupA[7] = AReg0x80;
    regBtnGroupA[6] = AReg0x40;
    regBtnGroupA[5] = AReg0x20;
    regBtnGroupA[4] = AReg0x10;
    regBtnGroupA[3] = AReg0x08;
    regBtnGroupA[2] = AReg0x04;
    regBtnGroupA[1] = AReg0x02;
    regBtnGroupA[0] = AReg0x01;

    regBtnGroupB[7] = BReg0x80;
    regBtnGroupB[6] = BReg0x40;
    regBtnGroupB[5] = BReg0x20;
    regBtnGroupB[4] = BReg0x10;
    regBtnGroupB[3] = BReg0x08;
    regBtnGroupB[2] = BReg0x04;
    regBtnGroupB[1] = BReg0x02;
    regBtnGroupB[0] = BReg0x01;

    regBtnGroupC[7] = CReg0x80;
    regBtnGroupC[6] = CReg0x40;
    regBtnGroupC[5] = CReg0x20;
    regBtnGroupC[4] = CReg0x10;
    regBtnGroupC[3] = CReg0x08;
    regBtnGroupC[2] = CReg0x04;
    regBtnGroupC[1] = CReg0x02;
    regBtnGroupC[0] = CReg0x01;

    jPanel5.add(APin0x80, null);
    jPanel5.add(APin0x40, null);
    jPanel5.add(APin0x20, null);
    jPanel5.add(APin0x10, null);
    jPanel5.add(APin0x08, null);
    jPanel5.add(APin0x04, null);
    jPanel5.add(APin0x02, null);
    jPanel5.add(APin0x01, null);
    jPanel1.add(jLabel19, null);
    jPanel1.add(jLabel110, null);
    jPanel1.add(APinRHex, null);
    jPanel1.add(APinRDec, null);
    jPanel1.add(BPinRHex, null);
    jPanel1.add(BPinRDec, null);
    jPanel1.add(CPinRHex, null);
    jPanel1.add(CPinRDec, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jLabel2, null);
    contentPane.add(jLabel18, null);
    contentPane.add(txDevStat, null);
    contentPane.add(jLabel25, null);
    contentPane.add(jPanel6, null);
    jPanel6.add(jLabel43, null);
    jPanel6.add(ARegWHex, null);
    jPanel6.add(jLabel124, null);
    jPanel6.add(jPanel12, null);
    jPanel12.add(jLabel42, null);
    jPanel12.add(jLabel40, null);
    jPanel12.add(jLabel39, null);
    jPanel12.add(jLabel46, null);
    jPanel12.add(jLabel41, null);
    jPanel12.add(jLabel38, null);
    jPanel12.add(jLabel129, null);
    jPanel12.add(jLabel127, null);
    jPanel6.add(jLabel125, null);
    jPanel6.add(jPanel13, null);
    jPanel13.add(CReg0x80, null);
    jPanel13.add(CReg0x40, null);
    jPanel13.add(CReg0x20, null);
    jPanel13.add(CReg0x10, null);
    jPanel13.add(CReg0x08, null);
    jPanel13.add(CReg0x04, null);
    jPanel13.add(CReg0x02, null);
    jPanel13.add(CReg0x01, null);
    jPanel6.add(jPanel14, null);
    jPanel14.add(BReg0x80, null);
    jPanel14.add(BReg0x40, null);
    jPanel14.add(BReg0x20, null);
    jPanel14.add(BReg0x10, null);
    jPanel14.add(BReg0x08, null);
    jPanel14.add(BReg0x04, null);
    jPanel14.add(BReg0x02, null);
    jPanel14.add(BReg0x01, null);
    jPanel6.add(jLabel128, null);
    jPanel6.add(CRegWHex, null);
    jPanel6.add(BRegDec, null);
    jPanel6.add(CRegDec, null);
    jPanel6.add(BRegWHex, null);
    jPanel6.add(jLabel121, null);
    jPanel6.add(ARegDec, null);
    jPanel6.add(jLabel122, null);
    jPanel6.add(jLabel123, null);
    jPanel6.add(jPanel15, null);
    jPanel15.add(AReg0x80, null);
    jPanel15.add(AReg0x40, null);
    jPanel15.add(AReg0x20, null);
    jPanel15.add(AReg0x10, null);
    jPanel15.add(AReg0x08, null);
    jPanel15.add(AReg0x04, null);
    jPanel15.add(AReg0x02, null);
    jPanel15.add(AReg0x01, null);
    contentPane.add(cmdConnect, null);
    contentPane.add(txCommPortLoc, null);
    contentPane.add(jLabel27, null);
    jPanel1.add(APinWHex, null);
    jPanel1.add(jLabel12, null);
    jPanel1.add(jPanel4, null);
    jPanel4.add(jLabel4, null);
    jPanel4.add(jLabel5, null);
    jPanel4.add(jLabel6, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(jLabel9, null);
    jPanel4.add(jLabel10, null);
    jPanel4.add(jLabel11, null);
    jPanel1.add(jLabel13, null);
    jPanel1.add(jPanel3, null);
    jPanel3.add(CPin0x80, null);
    jPanel3.add(CPin0x40, null);
    jPanel3.add(CPin0x20, null);
    jPanel3.add(CPin0x10, null);
    jPanel3.add(CPin0x08, null);
    jPanel3.add(CPin0x04, null);
    jPanel3.add(CPin0x02, null);
    jPanel3.add(CPin0x01, null);
    jPanel1.add(jPanel2, null);
    jPanel2.add(BPin0x80, null);
    jPanel2.add(BPin0x40, null);
    jPanel2.add(BPin0x20, null);
    jPanel2.add(BPin0x10, null);
    jPanel2.add(BPin0x08, null);
    jPanel2.add(BPin0x04, null);
    jPanel2.add(BPin0x02, null);
    jPanel2.add(BPin0x01, null);
    jPanel1.add(jLabel15, null);
    jPanel1.add(CPinWHex, null);
    jPanel1.add(BPinWDec, null);
    jPanel1.add(CPinWDec, null);
    jPanel1.add(BPinWHex, null);
    jPanel1.add(jLabel14, null);
    jPanel1.add(APinWDec, null);
    jPanel1.add(jLabel16, null);
    jPanel1.add(jLabel17, null);
    jPanel1.add(jPanel5, null);
    jPanel7.add(jLabel116, null);
    jPanel7.add(jLabel118, null);
    jPanel7.add(jLabel35, null);
    jPanel7.add(jLabel211, null);
    jPanel7.add(jLabel210, null);
    jPanel7.add(jLabel213, null);
    jPanel7.add(jLabel28, null);
    jPanel7.add(jLabel212, null);
    jPanel7.add(jLabel34, null);
    jPanel7.add(jLabel36, null);
    jPanel7.add(jTextField12, null);
    jPanel7.add(jLabel114, null);
    jPanel7.add(jPanel8, null);
    jPanel7.add(jLabel115, null);
    jPanel7.add(jPanel9, null);
    jPanel7.add(jPanel10, null);
    jPanel7.add(jLabel119, null);
    jPanel7.add(jTextField13, null);
    jPanel7.add(jTextField8, null);
    jPanel7.add(jTextField9, null);
    jPanel7.add(jTextField10, null);
    jPanel7.add(jLabel111, null);
    jPanel7.add(jTextField11, null);
    jPanel7.add(jLabel112, null);
    jPanel7.add(jLabel113, null);
    jPanel7.add(jPanel11, null);
    jPanel8.add(jLabel33, null);
    jPanel8.add(jLabel31, null);
    jPanel8.add(jLabel30, null);
    jPanel8.add(jLabel37, null);
    jPanel8.add(jLabel32, null);
    jPanel8.add(jLabel29, null);
    jPanel8.add(jLabel120, null);
    jPanel8.add(jLabel117, null);
    jPanel9.add(CPin0x81, null);
    jPanel9.add(CPin0x41, null);
    jPanel9.add(CPin0x21, null);
    jPanel9.add(CPin0x11, null);
    jPanel9.add(CPin0x09, null);
    jPanel9.add(CPin0x05, null);
    jPanel9.add(CPin0x06, null);
    jPanel9.add(CPin0x03, null);
    jPanel10.add(BPin0x81, null);
    jPanel10.add(BPin0x41, null);
    jPanel10.add(BPin0x21, null);
    jPanel10.add(BPin0x11, null);
    jPanel10.add(BPin0x09, null);
    jPanel10.add(BPin0x05, null);
    jPanel10.add(BPin0x06, null);
    jPanel10.add(BPin0x03, null);
    jPanel11.add(APin0x81, null);
    jPanel11.add(APin0x41, null);
    jPanel11.add(APin0x21, null);
    jPanel11.add(APin0x11, null);
    jPanel11.add(APin0x09, null);
    jPanel11.add(APin0x05, null);
    jPanel11.add(APin0x06, null);
    jPanel11.add(APin0x03, null);

  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void cmdConnect_actionPerformed(ActionEvent e) {
    if (cmdConnect.getText().equalsIgnoreCase("connect")) {
      device.setCommPortLocation(this.txCommPortLoc.getText());
      device.addDeviceEventListener(new DevXListener(this));
      try {
        device.open();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
      device.getPorts()[0].addPortEventListener(new DevPortAListener(this));
      device.getPorts()[1].addPortEventListener(new DevPortBListener(this));
      device.getPorts()[2].addPortEventListener(new DevPortCListener(this));
      cmdConnect.setText("disconnect");
    }
    else {

      for (int i = 0; i < device.getPorts().length; i++) {
        device.getPorts()[i].removePortEventListeners();
        for (int ii = 0; ii < device.getPorts()[i].getPins().length; ii++) {
          device.getPorts()[i].getPins()[ii].removePinEventListers();
        }
      }

      device.close();
      device.removeDeviceEventListeners();
      cmdConnect.setText("connect");
    }

  }

  void setRegistersAction(JButton cmp, Pin cpin) {
    if (cmp.getText().equalsIgnoreCase("I")) {
      cpin.setPinRegisterAsInput(false);
    }
    else {
      cpin.setPinRegisterAsInput(true);
    }
  }

  void AReg0x80_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x80, device.getPorts()[0].getPins()[7]);
  }

  void AReg0x40_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x40, device.getPorts()[0].getPins()[6]);
  }

  void AReg0x20_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x20, device.getPorts()[0].getPins()[5]);
  }

  void AReg0x10_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x10, device.getPorts()[0].getPins()[4]);
  }

  void AReg0x08_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x08, device.getPorts()[0].getPins()[3]);
  }

  void AReg0x04_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x04, device.getPorts()[0].getPins()[2]);
  }

  void AReg0x02_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x02, device.getPorts()[0].getPins()[1]);
  }

  void AReg0x01_actionPerformed(ActionEvent e) {
    setRegistersAction(AReg0x01, device.getPorts()[0].getPins()[0]);
  }

  void BReg0x80_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x80, device.getPorts()[1].getPins()[7]);
  }

  void BReg0x40_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x40, device.getPorts()[1].getPins()[6]);
  }

  void BReg0x20_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x20, device.getPorts()[1].getPins()[5]);
  }

  void BReg0x10_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x10, device.getPorts()[1].getPins()[4]);
  }

  void BReg0x08_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x08, device.getPorts()[1].getPins()[3]);
  }

  void BReg0x04_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x04, device.getPorts()[1].getPins()[2]);
  }

  void BReg0x02_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x02, device.getPorts()[1].getPins()[1]);
  }

  void BReg0x01_actionPerformed(ActionEvent e) {
    setRegistersAction(BReg0x01, device.getPorts()[1].getPins()[0]);
  }

  void CReg0x80_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x80, device.getPorts()[2].getPins()[7]);
  }

  void CReg0x40_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x40, device.getPorts()[2].getPins()[6]);
  }

  void CReg0x20_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x20, device.getPorts()[2].getPins()[5]);
  }

  void CReg0x10_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x10, device.getPorts()[2].getPins()[4]);
  }

  void CReg0x08_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x08, device.getPorts()[2].getPins()[3]);
  }

  void CReg0x04_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x04, device.getPorts()[2].getPins()[2]);
  }

  void CReg0x02_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x02, device.getPorts()[2].getPins()[1]);
  }

  void CReg0x01_actionPerformed(ActionEvent e) {
    setRegistersAction(CReg0x01, device.getPorts()[2].getPins()[0]);
  }

  void setPinAction(JButton cmp, Pin cpin) {
    if (cmp.getText().equalsIgnoreCase("1")) {
      cpin.setPinStateAsOn(false);
    }
    else {
      cpin.setPinStateAsOn(true);
    }
  }

  void APin0x80_actionPerformed(ActionEvent e) {
    setPinAction(APin0x80, device.getPorts()[0].getPins()[7]);
  }

  void APin0x40_actionPerformed(ActionEvent e) {
    setPinAction(APin0x40, device.getPorts()[0].getPins()[6]);
  }

  void APin0x20_actionPerformed(ActionEvent e) {
    setPinAction(APin0x20, device.getPorts()[0].getPins()[5]);
  }

  void APin0x10_actionPerformed(ActionEvent e) {
    setPinAction(APin0x10, device.getPorts()[0].getPins()[4]);
  }

  void APin0x08_actionPerformed(ActionEvent e) {
    setPinAction(APin0x08, device.getPorts()[0].getPins()[3]);
  }

  void APin0x04_actionPerformed(ActionEvent e) {
    setPinAction(APin0x04, device.getPorts()[0].getPins()[2]);
  }

  void APin0x02_actionPerformed(ActionEvent e) {
    setPinAction(APin0x02, device.getPorts()[0].getPins()[1]);
  }

  void APin0x01_actionPerformed(ActionEvent e) {
    setPinAction(APin0x01, device.getPorts()[0].getPins()[0]);
  }

  void BPin0x80_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x80, device.getPorts()[1].getPins()[7]);
  }

  void BPin0x40_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x40, device.getPorts()[1].getPins()[6]);
  }

  void BPin0x20_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x20, device.getPorts()[1].getPins()[5]);
  }

  void BPin0x10_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x10, device.getPorts()[1].getPins()[4]);
  }

  void BPin0x08_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x08, device.getPorts()[1].getPins()[3]);
  }

  void BPin0x04_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x04, device.getPorts()[1].getPins()[2]);
  }

  void BPin0x02_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x02, device.getPorts()[1].getPins()[1]);
  }

  void BPin0x01_actionPerformed(ActionEvent e) {
    setPinAction(BPin0x01, device.getPorts()[1].getPins()[0]);
  }

  void CPin0x80_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x80, device.getPorts()[2].getPins()[7]);
  }

  void CPin0x40_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x40, device.getPorts()[2].getPins()[6]);
  }

  void CPin0x20_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x20, device.getPorts()[2].getPins()[5]);
  }

  void CPin0x10_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x10, device.getPorts()[2].getPins()[4]);
  }

  void CPin0x08_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x08, device.getPorts()[2].getPins()[3]);
  }

  void CPin0x04_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x04, device.getPorts()[2].getPins()[2]);
  }

  void CPin0x02_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x02, device.getPorts()[2].getPins()[1]);
  }

  void CPin0x01_actionPerformed(ActionEvent e) {
    setPinAction(CPin0x01, device.getPorts()[2].getPins()[0]);
  }

  void ARegWHex_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[0].setPortDirectionRegister(
          Integer.decode("0x" + ARegWHex.getText()).intValue()
          );
    }
  }

  void ARegDec_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[0].setPortDirectionRegister(
          Integer.decode(ARegDec.getText()).intValue()
          );
    }
  }

  void BRegWHex_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[1].setPortDirectionRegister(
          Integer.decode("0x" + BRegWHex.getText()).intValue()
          );
    }
  }

  void BRegDec_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[1].setPortDirectionRegister(
          Integer.decode(BRegDec.getText()).intValue()
          );
    }
  }

  void CRegWHex_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[2].setPortDirectionRegister(
          Integer.decode("0x" + CRegWHex.getText()).intValue()
          );
    }
  }

  void CRegDec_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[2].setPortDirectionRegister(
          Integer.decode(CRegDec.getText()).intValue()
          );
    }
  }

  void APinWHex_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[0].setPortBinaryData(
          Integer.decode("0x" + APinWHex.getText()).intValue()
          );
    }
  }

  void APinWDec_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[0].setPortBinaryData(
          Integer.decode(APinWDec.getText()).intValue()
          );
    }
  }

  void BPinWHex_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[1].setPortBinaryData(
          Integer.decode("0x" + BPinWHex.getText()).intValue()
          );
    }
  }

  void BPinWDec_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[1].setPortBinaryData(
          Integer.decode(BPinWDec.getText()).intValue()
          );
    }
  }

  void CPinWHex_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[2].setPortBinaryData(
          Integer.decode("0x" + CPinWHex.getText()).intValue()
          );
    }
  }

  void CPinWDec_keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      device.getPorts()[2].setPortBinaryData(
          Integer.decode(CPinWDec.getText()).intValue()
          );
    }
  }
}

class Frame1_ARegWHex_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_ARegWHex_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.ARegWHex_keyPressed(e);
  }
}

class Frame1_ARegDec_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_ARegDec_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.ARegDec_keyPressed(e);
  }
}

class Frame1_BRegWHex_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_BRegWHex_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.BRegWHex_keyPressed(e);
  }
}

class Frame1_BRegDec_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_BRegDec_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.BRegDec_keyPressed(e);
  }
}

class Frame1_CRegWHex_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_CRegWHex_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.CRegWHex_keyPressed(e);
  }
}

class Frame1_CRegDec_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_CRegDec_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.CRegDec_keyPressed(e);
  }
}

class Frame1_APinWHex_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_APinWHex_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.APinWHex_keyPressed(e);
  }
}

class Frame1_APinWDec_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_APinWDec_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.APinWDec_keyPressed(e);
  }
}

class Frame1_BPinWHex_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_BPinWHex_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.BPinWHex_keyPressed(e);
  }
}

class Frame1_BPinWDec_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_BPinWDec_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.BPinWDec_keyPressed(e);
  }
}

class Frame1_CPinWHex_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_CPinWHex_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.CPinWHex_keyPressed(e);
  }
}

class Frame1_CPinWDec_keyAdapter
    extends java.awt.event.KeyAdapter {
  Frame1 adaptee;

  Frame1_CPinWDec_keyAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.CPinWDec_keyPressed(e);
  }
}

class Frame1_cmdConnect_actionAdapter
    implements java.awt.event.ActionListener {
  Frame1 adaptee;

  Frame1_cmdConnect_actionAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cmdConnect_actionPerformed(e);
  }
}
