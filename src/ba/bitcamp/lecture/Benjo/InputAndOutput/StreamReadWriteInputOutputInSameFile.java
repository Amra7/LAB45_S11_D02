package ba.bitcamp.lecture.Benjo.InputAndOutput;

import java.io.*;

public class StreamReadWriteInputOutputInSameFile {

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

		FileInputStream fis = null;
		Reader is;

		byte[] inputBuffer = new byte[10];
		FileOutputStream fos;
		OutputStream os;

		StringBuilder outputBuilder = new StringBuilder();

		try {
			fis = new FileInputStream("./Files/InputSomething.txt");
			is = new InputStreamReader(fis);
			BufferedReader bis = new BufferedReader(is);
			fos = new FileOutputStream("./Files/InputSomething.txt", true);
			os = new DataOutputStream(fos);

			int numRead = 0;
			String lineString = "";

			while ((lineString = bis.readLine()) != null) {
				outputBuilder.append(lineString).append("\n");

			}

			os.write(outputBuilder.toString().getBytes());

			System.out.println("Citanje zavrseno.");
//          System.out.println(outputBuilder.toString());
//		    String outputString = outputBuilder.toString();
//			os.write(outputString.getBytes());

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			System.out.println("\nDone");
		}

	} // end of main

} // end of class
