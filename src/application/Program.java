package application;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {

		// 14.04 Generics - Tipos curinga delimitados (bounded wildcard) - Princ�pio
		// get/put - covari�ncia
		// List<? extends Number> list, por exemplo
		// Permite realizar um Get, mas n�o um Put
		// N�o se sabe se o tipo do item a ser acrescido � compat�vel

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(5);
		List<? extends Number> list = intList;
		Number x = list.get(0);

		list.add(20); // erro de compilacao
	}
}