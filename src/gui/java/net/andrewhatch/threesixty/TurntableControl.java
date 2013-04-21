package net.andrewhatch.threesixty;

import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TurntableControl {
	boolean packFrame = false;
	
	static{
		try {
			
			System.out.println("loading native...");
			System.out.println(System.mapLibraryName("rxtxSerial"));
			String libName = "librxtxSerial.jnilib";
			URL url = TurntableControl.class.getResource(libName);
			
			File toFile = File.createTempFile("librxtxSerial", "");
			if(toFile.exists()) {System.out.println("already exists");};
			toFile.deleteOnExit();
			System.out.println("Extracting jnilib into " + toFile.getAbsolutePath());
			InputStream in = url.openStream();
			FileOutputStream fos = new FileOutputStream(toFile);
			final int BUF_SIZE = 1024 * 8;
			byte[] buffer = new byte[BUF_SIZE];
			int bytesRead = -1;
			while((bytesRead = in.read(buffer)) > -1) {
			    fos.write(buffer, 0, bytesRead);
			}
			fos.flush();
			fos.close();
			in.close();
			System.setProperty("java.library.path", toFile.getParent());
			System.out.println("loading");
			
			System.load(toFile.getAbsolutePath());		
//			System.loadLibrary("rxtxSerial");
		}
		catch (IOException ioe) 
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Couldn't find the native library!");
			System.exit(1);
		}
	}

	//Construct the application
	public TurntableControl() {

		TurntableUI frame = new TurntableUI();
		//Validate frames that have preset sizes
		//Pack frames that have useful preferred size info, e.g. from their layout
		if (packFrame) {
			frame.pack();
		}
		else {
			frame.validate();
		}
		//Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation( (screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}


	//Main method
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		new TurntableControl();
	}
}
