package applet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {

	public static void main(String[] args) throws IOException {
		// Create an output stream to the file
		FileOutputStream output = new FileOutputStream("temp.dat");

		// output values to the file
		for (int i = 1; i <= 10; i++) {
			output.write(i);
		}

		// Close the output stream
		output.close();

		// Create an output stream for file temp1.dat
		DataOutputStream output1 = new DataOutputStream(new FileOutputStream("temp1.dat"));

		// Write student test scores to the file
		output1.writeUTF("John");
		output1.writeDouble(85.5);
		output1.writeUTF("Ivan");
		output1.writeDouble(100);
		output1.writeUTF("Tim");
		output1.writeDouble(95.5);

		// Close
		output1.close();

		// Create an input stream for the file
		FileInputStream input = new FileInputStream("temp.dat");

		// Read values from the file
		int value;
		while ((value = input.read()) != -1) {
			System.out.println(value + " ");
		}

		// close the input stream
		input.close();

		// Create an input stream for the file temp1.dat
		DataInputStream input1 = new DataInputStream(new FileInputStream("temp1.dat"));

		// Read file
		System.out.println(input1.readUTF() + " " + input1.readDouble());
		System.out.println(input1.readUTF() + " " + input1.readDouble());
		System.out.println(input1.readUTF() + " " + input1.readDouble());
	}
}
