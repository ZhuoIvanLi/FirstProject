package FirstSample;

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

		// Create Loan object
		Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

		double monthlyPayment = (int) (loan.getMonthlyPayment() * 100) / 100.0;

		double totalPayment = (int) (loan.getTotalPayment() * 100) / 100.0;

		// Display results
		String output = "The loan was create on " + loan.getLoanDate().toString() + "\nThe monthly payment is "
				+ monthlyPayment + "\nThe total payment is " + totalPayment;

		JOptionPane.showMessageDialog(null, output);

		// Test derived Load method
		LoanMethod1 loanM = new LoanMethod1();

		System.out.println("test monthly payment: " + (int) (loanM.getMonthlyPayment()));
		System.out.println("test total payment: " + (int) (loanM.getTotalPayment()));

	}

}
