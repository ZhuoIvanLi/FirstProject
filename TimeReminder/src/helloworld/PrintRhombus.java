package helloworld;

public class PrintRhombus {
	final static int rhombusSize = 12;

	public PrintRhombus() {

		for (int i = 0; i < rhombusSize; i++) {
			// initiate string for one line use
			String s = new String();

			for (int j = 1; j <= rhombusSize; j++) {
				if (i < rhombusSize / 2) {
					s += printFirst(rhombusSize / 2 - i, j);
				} else {
					s += printSec(i - rhombusSize / 2 + 1, j);

				}
			}

			// print this line
			System.out.println(s);

		}
	}

	private String printFirst(int r, int j) {
		if (j == r) {
			// System.out.println(i);
			return "/";
		}
		if (j == r + ((rhombusSize / 2 - r) == 0 ? 1 : (rhombusSize / 2 - r) * 2 + 1)) {
			// System.out.println(i);
			return "\\";
		} else {
			return " ";
		}

	}

	private String printSec(int r, int j) {

		if (j == r) {
			return "\\";
		}
		if (j == r + ((rhombusSize / 2 - r) == 0 ? 1 : (rhombusSize / 2 - r) * 2 + 1)) {
			return "/";
		} else {
			return " ";
		}

	}

	public static void main(String[] args) {

		PrintRhombus p = new PrintRhombus();
	}

}
