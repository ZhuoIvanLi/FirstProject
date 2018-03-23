package helloworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		try {
			TestException t1 = new TestException(1.0);
			TestException t2 = new TestException(-2.0);

		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}

		Scanner scanner = new Scanner(System.in);
		boolean continueInput = true;

		do {
			try {
				System.out.println("Enter and integer");
				int number = scanner.nextInt();

				// Display the result
				System.out.println("The number entered is " + number);
				continueInput = false;
			} catch (InputMismatchException ex) {
				System.out.println("Incorrect input: an integer is required)");
				scanner.nextLine(); // discard input

			}

		} while (continueInput);
	}

}

class TestException {
	double dou;

	public TestException(double d) {
		setDou(d);
	}

	public void setDou(double d) throws IllegalArgumentException {
		if (d >= 0) {
			dou = d;
		} else {
			throw new IllegalArgumentException("double is negative number");
		}
	}
}
