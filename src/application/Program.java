package application;

import java.util.Arrays;
import java.util.List;

public class Program {
	public static void main(String[] args) {

		// 14.03 Generics - Tipos curinga (wildcard types)
		// O supertipo de qualquer tipo de lista é List<?> - e não List<Object>
		
		List<Integer> myInts = Arrays.asList(5, 2, 10);
		printList(myInts);
	}

	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
}