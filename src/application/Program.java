package application;

import java.util.HashMap;
import java.util.Map;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {

		// 14.16 - Map - com objetos - comapra-se ou por ponteiro 
		// ou pore hashCode e equals

		// Pode-se usar objetos criados como chaves
		Map<Product, Double> stock = new HashMap<>();

		// Criando-se objetos
		Product p1 = new Product("Tv", 900.0);
		Product p2 = new Product("Notebook", 1200.0);
		Product p3 = new Product("Tablet", 400.0);

		// Acrecendo-se os objetos
		stock.put(p1, 10000.0);
		stock.put(p2, 20000.0);
		stock.put(p3, 15000.0);

		// Criando novo objto, igual ao p1, mas com outra referência/ponteiro
		Product ps = new Product("Tv", 900.0);

		// sem hashCode e equals, compara-se por ponteiros - e daria 'false'
		System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
	}
}