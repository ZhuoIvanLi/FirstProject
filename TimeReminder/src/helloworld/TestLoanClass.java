package helloworld;

import javax.swing.JOptionPane;

public class TestLoanClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Enter yearly interest rate
		String annualInterestRateString = JOptionPane.showInputDialog("Enter yearly intereste rate, for example 8.25:");

		double annualInterestRate = Double.parseDouble(annualInterestRateString);

		String numberOfYearsString = JOptionPane
				.showInputDialog("Enter number of years as an integer, \nfor example 5:");

		int numberOfYears = Integer.parseInt(numberOfYearsString);

		String loanString = JOptionPane.showInputDialog("Enter loan amount, for example 120000.95:");

		double loanAmount = Double.parseDouble(loanString);

	}

}
