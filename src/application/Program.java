package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {

		// 05.02 Vetores (com objetos)
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Product[] product = new Product[n];

		for (int count = 0; count < product.length; count++) {
			sc.nextLine();
			String name = sc.nextLine();
			double price = sc.nextDouble();
			product[count] = new Product(name, price);
		}

		double sum = 0.0;

		for (int count = 0; count < product.length; count++) {
			sum += product[count].getPrice();
		}

		double avg = sum / n;

		System.out.printf("AVERAGE PRICE = %.2f", avg);

		sc.close();
	}
}