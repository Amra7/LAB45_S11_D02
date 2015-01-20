package ba.bitcamp.lecture.Benjo.InputAndOutput;

import java.io.*;

import javax.swing.JFileChooser;

public class StreamReadWriteInputOutputByUser {

	/**
	 * Method for cleaning Buffer.
	 * 
	 * @param buffer
	 * @param numRead
	 *            - number of bit that are read.
	 */
	private static void cleanBuffer(byte[] buffer, int numRead) {

		for (int i = 0; i < numRead; i++) {
			buffer[i] = 0;
		}
	}

	public static void main(String[] args) {

		JFileChooser filePicker = new JFileChooser();
		File f = new File("");
		// String path = f.pathSeparator;
		// System.out.println(path);

		System.out.println();
		filePicker.setCurrentDirectory(new File(System.getProperty("user.home")
				+ "/Documents/workspace"));
		
		
		// int open = filePicker.showOpenDialog(filePicker);
	
		// if ( open != filePicker.APPROVE_OPTION){
		// System.exit(-1);
		// }
		
		int open = -1;
		while (open != filePicker.APPROVE_OPTION) {

			open = filePicker.showOpenDialog(filePicker);
		}
		String pickFile = filePicker.getSelectedFile().getAbsolutePath();
		
		int export = filePicker.showSaveDialog(filePicker);
		String pickFile2 = "";
		if ( export == filePicker.APPROVE_OPTION){
			pickFile2 = filePicker.getSelectedFile().getAbsolutePath();
		}
		

		FileInputStream fis = null;
		Reader is;

		byte[] inputBuffer = new byte[10];
		FileOutputStream fos;
		OutputStream os;

		StringBuilder outputBuilder = new StringBuilder();

		try {
			fis = new FileInputStream(pickFile);
			is = new InputStreamReader(fis);
			BufferedReader bis = new BufferedReader(is);
			fos = new FileOutputStream( pickFile2, true);
			os = new DataOutputStream(fos);

			int numRead = 0;
			String lineString = "";

			while ((lineString = bis.readLine()) != null) {
				outputBuilder.append(lineString).append("\n");

			}

			os.write(outputBuilder.toString().getBytes());

			System.out.println("Citanje zavrseno.");
			// System.out.println(outputBuilder.toString());
			// String outputString = outputBuilder.toString();
			// os.write(outputString.getBytes());

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			System.out.println("\nDone");
		}

	} // end of main

} // end of class
