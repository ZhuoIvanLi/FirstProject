package helloworld;

import javax.swing.JOptionPane;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// Read number of disks, n
		String intString = JOptionPane.showInputDialog("Enter number of disks: ");

		// Convert string into integer
		int n = Integer.parseInt(intString);

		// Find the solution recursively
		System.out.println("The moves are: ");
		moveDisks(n, 'A', 'B', 'C');

		JOptionPane.showMessageDialog(null, "finish project");
	}

	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {

		if (n == 1) {
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		} else {
			moveDisks(n - 1, fromTower, auxTower, toTower);

			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);

			moveDisks(n - 1, auxTower, toTower, fromTower);
		}

	}
}
