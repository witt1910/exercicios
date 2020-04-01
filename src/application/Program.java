package application;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {

		// 14.05 Generics - Tipos curinga delimitados (bounded wildcard)
		// Princípio get/put - contravariância
		// List<? extends Number> list, por exemplo
		// Permite realizar um Put, mas não um Get
		// Não se sabe se o tipo do item a ser buscado é compatível

		List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Maria");
		myObjs.add("Alex");
		
		List<? super Number> myNums = myObjs;
		
		myNums.add(10);
		myNums.add(3.14);
		
		Number x = myNums.get(0); // erro de compilacao
	}
}