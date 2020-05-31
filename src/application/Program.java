package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class Program {
	public static void main(String[] args) throws ParseException {

		// 15.07 - Predicate (expressão lambda inline)
		// Fazer um programa que, a partir de uma lista de produtos, aumente o
		// preço dos produtos em 10%

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

		for (Product p : list) {
			System.out.println(p);
		}
	}
}