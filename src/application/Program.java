package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 09.02 Pilha de chamadas de métodos (stack trace)

		method1();

		System.out.println("End of program.");

	}

	public static void method1() {
		System.out.println("***METHOD1 START***");
		method2();
		System.out.println("***METHOD1 END***");
	}

	public static void method2() {
		System.out.println("***METHOD2 START***");
		Scanner sc = new Scanner(System.in);

		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!");
			// método para indicar a pilha de chamadas de métodos
			e.printStackTrace();
			sc.next();
		} 
		catch (InputMismatchException e) {
			System.out.println("Input error!");
		}
		sc.close();
		System.out.println("***METHOD2 END***");
	}
}