package helloworld;

import javax.swing.JOptionPane;

public class MultiplicationTable {

	public static void main(String[] args) {

		// Display the table heading
		String output = "        Multiplication Table\n";
		output += "-----------------------------------------------\n";

		output += "   | ";
		for (int i = 1; i <= 9; i++)
			output += "   " + i;

		output += "\n";

		for (int i = 1; i <= 9; i++) {
			output += i + " | ";
			for (int j = 1; j <= 9; j++) {
				if (i * j < 10) {
					output += "   " + i * j;
				} else
					output += " " + i * j;
			}
			output += "\n";
		}

		// Display result

		JOptionPane.showMessageDialog(null, output);

	}

}
