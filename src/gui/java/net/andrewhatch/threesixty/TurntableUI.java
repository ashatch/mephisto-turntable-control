package net.andrewhatch.threesixty;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ph.org.zero.tools.toys.usbio24mkii.Device;
import ph.org.zero.tools.toys.usbio24mkii.DeviceEvent;
import ph.org.zero.tools.toys.usbio24mkii.DeviceEventListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.AWTEvent;
import ph.org.zero.tools.toys.usbio24mkii.DevicePeerFactory;
import ph.org.zero.tools.toys.usbio24mkii.port.PortEvent;
import ph.org.zero.tools.toys.usbio24mkii.port.PortEventListener;

import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.BorderFactory;
import java.awt.Rectangle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class TurntableUI extends JFrame {

	private static final long serialVersionUID = -149724157361269865L;
	private static final String PREFS_DEFAULT_COMPORT = "PREFS_DEFAULT_COMPORT";
	JPanel contentPane;
	Device device;
	
	JLabel lblPortLocation = new JLabel();
	JComboBox rotCombo;
	
	JTextField txCommPortLoc = new JTextField();
	JButton cmdConnect = new JButton();
	JButton cmdRotate = new JButton();

	JLabel status = new JLabel();

	//Construct the frame
	public TurntableUI() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
			device = DevicePeerFactory.getDevicePeerName(null);
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
		this.setSize(new Dimension(538,150));
		this.setState(Frame.NORMAL);
		this.setTitle("Turntable Control");


		lblPortLocation.setFont(new java.awt.Font("Tahoma", 0, 10));
		lblPortLocation.setText("Port Location");
		lblPortLocation.setBounds(new Rectangle(20, 17, 71, 14));
		txCommPortLoc.setFont(new java.awt.Font("Dialog", 0, 10));
		txCommPortLoc.setText(getDefaultComPort());
		txCommPortLoc.setBounds(new Rectangle(90, 15, 250, 20));
		cmdConnect.setBounds(new Rectangle(372, 15, 105, 20));
		cmdConnect.setFont(new java.awt.Font("Tahoma", 0, 10));
		cmdConnect.setBorder(BorderFactory.createEtchedBorder());
		cmdConnect.setText("connect");
		cmdConnect.addActionListener(new Frame1_cmdConnect_actionAdapter(this));
		cmdRotate.setBounds(new Rectangle(150, 61, 105, 20));
		cmdRotate.setFont(new java.awt.Font("Tahoma", 0, 10));
		cmdRotate.setBorder(BorderFactory.createEtchedBorder());
		cmdRotate.setText("Rotate");
		cmdRotate.addActionListener(new Frame1_cmdRotate_actionAdapter(this));
		
		status.setText("[status]");
		status.setBounds(new Rectangle(5, 100, getSize().width - 10, 20));
		status.setFont(new java.awt.Font("Tahoma", 0, 10));
		status.setBorder(BorderFactory.createEtchedBorder());

		

		String[] listStrings = {
				"60 degrees (6 per 360)",
				"30 degrees (12 per 360)",
				"20 degrees (18 per 360)",
				"10 degrees (36 per 360)",
				"5 degrees (72 per 360)",
				"2.5 degrees (144 per 360)"
		};

		rotCombo = new JComboBox(listStrings);
		rotCombo.setSelectedIndex(0);
		rotCombo.setBounds(new Rectangle(20, 61, 105, 20));
		rotCombo.setFont(new java.awt.Font("Tahoma", 0, 10));
//		rotCombo.setBorder(BorderFactory.createEtchedBorder());
		contentPane.add(rotCombo, null);

		contentPane.add(cmdConnect, null);
		contentPane.add(cmdRotate, null);
		contentPane.add(txCommPortLoc, null);
		contentPane.add(lblPortLocation, null);
		contentPane.add(status, null);


	}

	private static String getDefaultComPort() {
		Preferences prefs = Preferences.userNodeForPackage(TurntableUI.class);
		return prefs.get(PREFS_DEFAULT_COMPORT , "<COM1 or /dev/something>");		
	}

	private static void setDefaultComPort(String location) {
		Preferences prefs = Preferences.userNodeForPackage(TurntableUI.class);
		prefs.put(PREFS_DEFAULT_COMPORT , location);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	//Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}

	void cmdRotate_actionPerformed(ActionEvent e) {
		if(cmdConnect.getText().equals("disconnect")) {
			int commandValue = 1;
			switch(rotCombo.getSelectedIndex()) {
			case 0: { // 60 degrees
				commandValue = 1;
				break;
			}
			case 1: { // 30 degrees
				commandValue = 3;
				break;
			}
			case 2: { // 20 degrees
				commandValue = 5;
				break;
			}
			case 3: { // 10 degrees
				commandValue = 7;
				break;
			}
			case 4: { // 5 degrees
				commandValue = 9;
				break;
			}
			case 5: { // 2.5 degrees
				commandValue = 11;
				break;
			}
			}
			status.setText("");
			device.getPorts()[0].setPortBinaryData(commandValue-1);
			device.getPorts()[0].setPortBinaryData(commandValue);
			device.getPorts()[0].setPortBinaryData(0);


		}
	}

	void cmdConnect_actionPerformed(ActionEvent e) {
		if (cmdConnect.getText().equalsIgnoreCase("connect")) {
			setDefaultComPort(this.txCommPortLoc.getText());
			device.setCommPortLocation(this.txCommPortLoc.getText());
//			device.addDeviceEventListener(new DevXListener(this));
			try {
				device.open();

			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			device.addDeviceEventListener(new DeviceEventListener() {

				public void deviceActive(DeviceEvent event) {
					status.setText("Device active");
					
				}

				public void deviceConnected(DeviceEvent event) {
					status.setText("Device active");
					
				}

				public void deviceDisconnected(DeviceEvent event) {
					status.setText("Device disconnected");
					
				}

				public void deviceInvalid(DeviceEvent event) {
					status.setText("Device invalid");
					
				}
				
			});
			device.getPorts()[0].addPortEventListener(new PortEventListener() {

				public void isPortWriting(PortEvent evt) {
					//status.setText("Sending command");
					
				}

				public void isPortWritten(PortEvent evt) {
					status.setText("Command sent.");
					
				}

				public void isPortRegistering(PortEvent evt) {
					// TODO Auto-generated method stub
					
				}

				public void isPortRegistered(PortEvent evt) {
					// TODO Auto-generated method stub
					
				}
				
			});
			device.getPorts()[0].setPortDirectionRegister(0x00);
			device.getPorts()[0].setPortBinaryData(0);
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
}

class Frame1_cmdConnect_actionAdapter
implements java.awt.event.ActionListener {
	TurntableUI adaptee;

	Frame1_cmdConnect_actionAdapter(TurntableUI adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.cmdConnect_actionPerformed(e);
	}
}

class Frame1_cmdRotate_actionAdapter implements java.awt.event.ActionListener {
	TurntableUI adaptee;

	Frame1_cmdRotate_actionAdapter(TurntableUI adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.cmdRotate_actionPerformed(e);
	}
}