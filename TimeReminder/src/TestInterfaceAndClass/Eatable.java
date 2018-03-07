package TestInterfaceAndClass;

public interface Eatable {

	public String howToEat();

	class Animal {

	}

	class Chicken extends Animal implements Eatable, Comparable {

		int weight;

		public Chicken() {
		}

		public Chicken(int weight) {
			this.weight = weight;
		}

		public String howToEat() {
			return "Fry it";
		}

		public int compareTo(Object o) {
			return weight = ((Chicken) o).weight;
		}

	}

	class Tiger extends Animal {

	}

	abstract class Fruit implements Eatable {

	}

	class Apple extends Fruit {
		public String howToEat() {
			return "make apple";
		}

	}

	class Orange extends Fruit {

		public String howToEat() {
			return "make orange";
		}
	}
}
