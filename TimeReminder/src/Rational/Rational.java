package Rational;

public class Rational extends Number implements Comparable {

	// Data fields for numerator and denominator
	private long numerator = 0;
	private long denominator = 1;

	public Rational() {
		this(0, 1);
	}

	public Rational(long numerator, long denominator) {

		// this.numerator=numerator;
		// this.denominator = denominator;

		long gcd = gcd(numerator, denominator);

		this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}

	// find gcd of two numbers
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;

		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
		}

		return gcd;
	}

	// return numerator
	public long getNumeerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	// Add a rational number to this rational
	public Rational add(Rational sec) {
		long n = numerator * sec.getDenominator() + denominator * sec.getNumeerator();
		long d = denominator * sec.getDenominator();

		return new Rational(n, d);
	}

	public Rational subtract(Rational sec) {
		long n = numerator * sec.getDenominator() - denominator * sec.getNumeerator();
		long d = denominator * sec.getDenominator();

		return new Rational(n, d);
	}

	public Rational multiply(Rational sec) {
		long n = numerator * sec.getNumeerator();
		long d = denominator * sec.getDenominator();

		return new Rational(n, d);
	}

	public Rational divide(Rational sec) {
		long n = numerator * sec.getDenominator();
		long d = denominator * sec.getNumeerator();

		return new Rational(n, d);
	}

	// override the toString() method
	public String toString() {
		if (denominator == 1)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}

	// override the equals method in the Object class
	public boolean equals(Object parm) {
		if ((this.subtract((Rational) (parm))).getNumeerator() == 0)
			return true;
		else
			return false;
	}

	// override the hasCode method in the Object class
	public int hashCode() {
		return new Double(this.doubleValue()).hashCode();
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if ((this.subtract((Rational) o)).getNumeerator() > 0)
			return 1;
		else if ((this.subtract((Rational) o)).getNumeerator() < 0)
			return -1;
		else
			return 0;
	}

	@Override
	// override the doubleValue method in java.long.Number
	public double doubleValue() {
		// TODO Auto-generated method stub
		return numerator * 1.0 / denominator;

	}

	@Override
	// override the floatValue() method in java.long.Number
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float) doubleValue();
	}

	@Override
	// override the intValue() method in java.long.Number
	public int intValue() {
		// TODO Auto-generated method stub
		return (int) doubleValue();
	}

	@Override
	// override the longValue() method in java.long.Number
	public long longValue() {
		// TODO Auto-generated method stub
		return (long) doubleValue();
	}

}
