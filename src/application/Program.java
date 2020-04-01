package application;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {

		// 14.05 Generics - Tipos curinga delimitados (bounded wildcard)
		// Princ�pio get/put - contravari�ncia
		// List<? extends Number> list, por exemplo
		// Permite realizar um Put, mas n�o um Get
		// N�o se sabe se o tipo do item a ser buscado � compat�vel

		List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Maria");
		myObjs.add("Alex");
		
		List<? super Number> myNums = myObjs;
		
		myNums.add(10);
		myNums.add(3.14);
		
		Number x = myNums.get(0); // erro de compilacao
	}
}