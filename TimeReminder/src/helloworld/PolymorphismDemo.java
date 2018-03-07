package helloworld;

public class PolymorphismDemo {

	public static void main(String[] args) {
		Object o1 = new Person();
		Circle o2 = new Circle();
		Object o3 = new Student();

		test1(o1);
		test1(o2);
		test1(o3);

		test2(o1);
		test2(o2);
		test2(o3);

		((Student) o3).testMethod();

	}

	public static void test1(Object o) {
		if (o instanceof Person) {
			System.out.println("this is person");
		} else if (o instanceof Circle) {
			System.out.println("this is circle");
		}
	}

	public static void test2(Object o) {
		System.out.println(o.toString());
	}
}

class GraduateStudent extends Student {
}

class Student extends Person {
	public String toString() {
		return "Student";
	}

	public void testMethod() {
		System.out.println("Execute the method");
	}
}

class Person extends Object {
	public String toString() {
		return "Person";
	}
}

class Circle extends Object {
	public String toString() {
		return "Circle";
	}
}
