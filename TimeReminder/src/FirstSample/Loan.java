package FirstSample;

import java.util.Date;

public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private Date loanDate;

	/* Default Constructor */

	public Loan() {
		this(7.5, 30, 100000);
	}

	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		// TODO Auto-generated constructor stub
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		this.loanDate = new Date();
	}

	public double getAnnualInerestRate() {
		return annualInterestRate;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setAnnualInterestRate(double annualIR) {
		this.annualInterestRate = annualIR;
	}

	public void setNumberOfYears(int numberOY) {
		this.numberOfYears = numberOY;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	// find monthly payment
	public double getMonthlyPayment() {
		double monthlyIR = annualInterestRate / 1200;
		return loanAmount * monthlyIR / (1 - (Math.pow(1 / (1 + monthlyIR), numberOfYears * 12)));
	}

	// Find total payment
	public double getTotalPayment() {
		return getMonthlyPayment() * numberOfYears * 12;
	}

}
