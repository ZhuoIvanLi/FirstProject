package myList;

public class TestList {
	public static void main(String[] args) {
		// Create a list
		MyArrayList myAList = new MyArrayList();

		// Add elements to the list
		myAList.add("Tom");

		System.out.println("1: " + myAList);

		// Additional to the beginning of the list
		myAList.add(0, "John");
		System.out.println("2: " + myAList);

		myAList.add("Ivan");
		System.out.println("3: " + myAList);

		myAList.add(2, "test insert");
		System.out.println("4: " + myAList);

		myAList.add(1, "insert in 1");
		System.out.println("5: " + myAList);

		// remove object in Array list
		myAList.remove("test insert");
		System.out.println("6: " + myAList);

		myAList.remove(1);
		System.out.println("7: " + myAList);

		// test
	}

}
