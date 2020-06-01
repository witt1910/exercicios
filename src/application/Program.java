package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
	public static void main(String[] args) {

		// 15.11 - Stream - demonstração de pipeline.
		
		// Cria lista já com valores inseridos.
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
		
		// Cria stream de inteiros e aplica a cada elemento da stream
		// a multiplicação de seu valor por 10. Depois imprime. 
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));
		
		// Realiza a soma dos elementos da liste, após converter para 
		// stream, e então imprime a soma.
		int sum = list.stream().reduce(0,  (x, y) -> x + y);
		System.out.println("Sum = " + sum);
		
		// Transforma de list para stream, depois filtra os pares,
		// multiplica os elementos restantes por 10. Converte para
		// list novamente e imprime.
		List<Integer> newList = list.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x * 10)
				.collect(Collectors.toList());
		System.out.println(Arrays.toString(newList.toArray()));

	}
}