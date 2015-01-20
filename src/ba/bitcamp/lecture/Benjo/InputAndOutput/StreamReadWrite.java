package ba.bitcamp.lecture.Benjo.InputAndOutput;

import java.io.*;

public class StreamReadWrite {

	private static void cleanBuffer(byte[] buffer, int numRead) {
		for (int i = 0; i < numRead; i++) {
			buffer[i] = 0;
		}
	}

	public static void main(String[] args) {

		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("./Files/something.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InputStream is = new DataInputStream(fis);
		byte[] inputBuffer = new byte[10];

		OutputStream os = new DataOutputStream(System.out);
		StringBuilder outputBuilder = new StringBuilder();

		try {
			
			int numRead = 0;
			while ((numRead = is.read(inputBuffer)) >= 0) {
				outputBuilder.append(new String( inputBuffer));
				cleanBuffer(inputBuffer, numRead);
			}
			System.out.println("Citanje zavrseno.");
//			System.out.println(outputBuilder.toString());
			String outputString = outputBuilder.toString();
			os.write( outputString.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
