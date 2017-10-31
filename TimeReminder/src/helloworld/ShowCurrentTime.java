package helloworld;

import javax.swing.JOptionPane;

public class ShowCurrentTime {

	public static void main(String[] args) {
		long totalMilliseconds = System.currentTimeMillis();

		long totalSeconds = totalMilliseconds / 1000;

		int currentSecond = (int) (totalSeconds % 60);

		long totalMinutes = totalSeconds / 60;
		int currentMinutes = (int) (totalMinutes % 60);

		long totalHours = totalMinutes / 60;

		int currentHour = (int) (totalHours % 24);

		String output = "current time is " + currentHour + ";" + currentMinutes + ":" + currentSecond;

		JOptionPane.showMessageDialog(null, output);

		int option = 0;
		while (option == JOptionPane.YES_OPTION) {

			System.out.println("continue loop");
			option = JOptionPane.showConfirmDialog(null, "Continue?");

		}

		String yearString = JOptionPane.showInputDialog("Enter a year(number only):");

		int year = Integer.parseInt(yearString);

		boolean isLeapYear = (year % 4 == 0 && year % 1 != 0) || (year % 400 == 0);
		JOptionPane.showMessageDialog(null, year + " " + "is a leap year? " + isLeapYear);
		System.out.printf("%d This is a leap year? %b", year, isLeapYear);

	}
}
