package helloworld;

public class Sorting {
	public static void main(String[] args) {
		double[] list = { 3, 4, 55, 32, 21, 2, 9, 0, 6, 4, 56, 666, 77, 89 };

		// selectionSort(list);
		insertionSort(list);

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + "\n");
		}

		for (int i = 0; i < 4; i++) {
			System.out.println((int) (Math.random() * 10));
		}
	}

	public static void selectionSort(double[] list) {
		for (int i = list.length - 1; i >= 1; i--) {
			double currentMax = list[0];
			int currentMaxIndex = 0;

			for (int j = 1; j <= i; j++) {
				if (currentMax < list[j]) {
					currentMax = list[j];
					currentMaxIndex = j;
				}
			}

			// swap list[i] with list[currentMaxIndex]
			if (currentMaxIndex != i) {
				list[currentMaxIndex] = list[i];
				list[i] = currentMax;
			}
		}
	}

	public static void insertionSort(double[] list) {
		for (int i = 1; i < list.length; i++) {
			double currentElement = list[i];
			int k;

			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = currentElement;
		}
	}
}
