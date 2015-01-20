package ba.bitcamp.lecture.Vedad.File;

import java.io.File;
import java.util.Scanner;

public class MyFile {

	public static void main(String[] args) {

		File file;
		String nameFile;
		String[] listOfFiles;

		System.out.println("Enter name of file ");
		Scanner scan = new Scanner(System.in);
		nameFile = scan.nextLine();
		file = new File(nameFile);

		if (file.exists()) {
			System.out.println("File exist!");
		} else {
			System.out.println("File does not exist!");
			return;
		}

		if (file.isDirectory()) {
			System.out.println("File in directory:");
			listOfFiles = file.list();
			for(String name:listOfFiles) {
				System.out.println(name);
			}
		} else {
			System.out.println("Object is not directory");
			return;
		}
		
		

	}

}
