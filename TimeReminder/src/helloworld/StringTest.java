package helloworld;

public class StringTest {
	public static void main(String[] arg) {
		String s1 = new String("test1");
		String s2 = "test1";

		if (s1 == s2)
			System.out.println("s1 == s2");

		else
			System.out.println("s1 == s2 false");

		if (s1.equals(s2))
			System.out.println("s1 equals s2");
	}
}
