package applet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.out.println("Usage: java copyFile sourceFile targetFile");
			System.exit(0);

		}

		// Check if source file exists
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " not exists");
			System.exit(0);
		}

		// Check if target file exists
		File targetFile = new File(args[0]);
		if (!targetFile.exists()) {
			System.out.println("Target file " + args[0] + " not exists");
			System.exit(0);
		}

		BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));

		System.out.println("The file " + args[0] + " has " + input.available() + " bytes");

		int r;
		while ((r = input.read()) != -1)
			output.write((byte) r);

		input.close();
		output.close();

		System.out.println("Copy done!");
	}
}
