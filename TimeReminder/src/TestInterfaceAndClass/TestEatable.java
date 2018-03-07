package TestInterfaceAndClass;

import TestInterfaceAndClass.Eatable.Apple;
import TestInterfaceAndClass.Eatable.Chicken;
import TestInterfaceAndClass.Eatable.Tiger;

public class TestEatable {

	public static void main(String[] args) {
		Object[] objects = { new Tiger(), new Chicken(), new Apple() };

		for (int i = 0; i < objects.length; i++) {
			showObject(objects[i]);
		}

	}

	public static void showObject(Object o) {
		if (o instanceof Eatable) {
			System.out.println(((Eatable) o).howToEat());
		}
	}

}
