package helloworld;

import java.util.ArrayList;;

public class MyStack {
	private ArrayList list = new ArrayList();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getSize() {
		return list.size();
	}

	public Object peek() {
		return list.get(getSize() - 1);
	}

	public Object pop() {
		Object o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}

	public Object push(Object o) {
		list.add(o);
		return o;
	}

	public int search(Object o) {
		return list.lastIndexOf(o);
	}

	public String toString() {
		return "stack: " + list.toString();
	}

	public static void main(String[] args) {
		MyStack ms = new MyStack();

		System.out.println("Is the stack Empty? " + ms.isEmpty());

		ms.push("test1");
		ms.push("test2");

		System.out.println("Size: " + ms.getSize());
		System.out.println("Content: " + ms);

	}

}
