package application;

public class Program {
	public static void main(String[] args) {

		// 05.04 For each

		String[] vect = new String[] { "Maria", "Bob", "Alex" };

		for (int count = 0; count < vect.length; count++) {
			System.out.println(vect[count]);
		}

		System.out.println();
		
		for (String obj : vect) {
			System.out.println(obj);
		}

	}
}