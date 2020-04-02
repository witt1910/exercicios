package application;

import java.util.HashSet;
import java.util.Set;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {

		// 14.10 Set - hashCode e equals (necessario para objs criados)

		Set<Product> set = new HashSet<>();

		set.add(new Product("TV", 900.0));
		set.add(new Product("Notebook", 1200.0));
		set.add(new Product("Tablet", 400.0));

		Product prod = new Product("Notebook", 1200.0);

		// como ha hashCode e equals, se compara cada elemento
		// e não a referência, que, no caso, daria diferente - false
		System.out.println(set.contains(prod));
	}
}
