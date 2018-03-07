package helloworld;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestFile {
	public static void main(String[] args) throws Exception {
		File file = new File("Files/text.txt");
		// if (file.createNewFile()) {
		// System.out.println("Exist? " + file.exists());
		// System.out.println("Can it be read? " + file.canRead());
		// System.out.println("Can it be written? " + file.canWrite());
		// System.out.println("Absolute path is " + file.getAbsolutePath());
		// }
		//
		if (file.exists()) {
			System.out.println("File already exists");

		} else {
			// Create a file
			PrintWriter output = new PrintWriter(file);

			output.print("test22: ");
			output.println("9926");

			output.close();
		}
		// Crate a Scanner for the file
		Scanner input = new Scanner(file);

		while (input.hasNext()) {
			String firstName = input.next();
			int number = input.nextInt();

			System.out.println(firstName + " " + number);
		}

		input.close();

	}

}
