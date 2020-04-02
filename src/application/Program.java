package application;

import java.util.HashSet;
import java.util.Set;

public class Program {
	public static void main(String[] args) {

		// 14.08 Set
		// Conjunto que não admite repetições, elementos não possuem posição
		// Acesso, isnerção e remoção rápidos
		// Principais implementações:
		// 		HashSet: rápido (O(1) em tabela hash), não ordenado;
		// 		LinkedHashSet: vel. média, repeita ordem do add;
		//		TreeSet: lento (O(log(n))), ordena pelo compareTo (do Comparable)
		// 		ou Comparator

		Set<String> set = new HashSet<>();

		// add elementos
		set.add("TV");
		set.add("Notebook");
		set.add("Tablet");
		set.add("Fry");
		set.add("Table");
		set.add("Lamp");

		// remove elementos
		set.remove("TV");

		// remove se tal condição for atnedida
		set.removeIf(x -> x.charAt(0) == 'T');

		// indica se o conjunto contem ou nao tal elemento
		System.out.println(set.contains("Notebook"));

		// indica tamanho do conjunto
		System.out.println("Size: " + set.size());

		for (String p : set) {
			System.out.println(p);
		}
	}
}