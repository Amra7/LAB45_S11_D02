package ba.bitcamp.lecture.Benjo.InputAndOutput;

import java.io.*;

public class StreamReadWriteInput {

	/**
	 * Method for cleaning Buffer.
	 * @param buffer
	 * @param numRead - number of bit that are read.
	 */
	private static void cleanBuffer(byte[] buffer, int numRead) {
		for (int i = 0; i < numRead; i++) {
			buffer[i] = 0;
		}
	}

	public static void main(String[] args) {

		FileInputStream fis = null;

		byte[] inputBuffer = new byte[10];

		OutputStream os = new DataOutputStream(System.out);
		StringBuilder outputBuilder = new StringBuilder();

		try {
			fis = new FileInputStream("./Files/inputSomething.txt");
			InputStream is = new DataInputStream(fis);

			int numRead = 0;
			while ((numRead = is.read(inputBuffer)) >= 0) {
				outputBuilder.append(new String(inputBuffer));
				cleanBuffer(inputBuffer, numRead);
			}
			System.out.println("Citanje zavrseno.");
			// System.out.println(outputBuilder.toString());
			String outputString = outputBuilder.toString();
			os.write(outputString.getBytes());

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			System.out.println("\nDone");
		}

	} // end of main

} // end of class
