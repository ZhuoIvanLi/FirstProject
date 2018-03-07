package FirstSample;

import javax.swing.JOptionPane;

public class BorrowLoan {

	public static void main(String[] arg) {
		Name name = new Name("ivan", 'D', "Li");

		Address address = new Address("232 st", "dsfsd", "AB", "t5r0o3");

		Loan loan = new Loan(5.5, 15, 250000);

		Borrower borrower = new Borrower(name, address);

		borrower.setLoan(loan);

		JOptionPane.showMessageDialog(null, borrower.toString());

	}
}
