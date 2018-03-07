package FirstSample;

import java.text.DecimalFormat;

public class Borrower extends Person {

	private Loan loan;
	DecimalFormat df = new DecimalFormat("#.00");

	public Borrower() {
		super();
	}

	public Borrower(Name name, Address address) {
		super(name, address);

	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public String toString() {
		return super.toString() + "monthly payment is" + df.format(loan.getMonthlyPayment()) + '\n'
				+ "total payment is " + df.format(loan.getTotalPayment());
	}
}
