package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.Product;

public class Program {
	public static void main(String[] args) throws ParseException {

		// 15.08 - Function - map (expressão lambda inline)
		// Fazer um programa que, a partir de uma lista de produtos, gere uma
		// nova lista contendo os nomes dos produtos em caixa alta.

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		names.forEach(System.out::println);

	}
}