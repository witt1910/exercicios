package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {

		// 15.12 - Stream - exercício resolvido (filter, sorted, map, reduce).

//		Fazer um programa para ler um conjunto de produtos a partir de um
//		arquivo em formato .csv (suponha que exista pelo menos um produto).
//		Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
//		nomes, em ordem decrescente, dos produtos que possuem preço
//		inferior ao preço médio.
		
//		Input files:
//		Tv,900.00
//		Mouse,50.00
//		Tablet,350.50
//		HD Case,80.90
//		Computer,850.00
//		Monitor,290.00
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		// "c:\\temp\\in.txt";
		String path = sc.nextLine();
				
		// A partir dos dados do txt, ele cria os produtos.
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		
			List<Product> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			// Transforma a lista em stream de Produtos, então em stream
			// de preços. Realiza a soma dos elementos e divide pelo
			// total de elementos na list, inserindo na variável avg.
			double avg = list.stream()
					.map(p -> p.getPrice())
					.reduce(0.0, (x,y) -> x + y) / list.size();
			
			System.out.println("Average price: " + String.format("%.2f",  avg));
			
			// Função anônima - arrow function - interface
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

			// A partir da list de Produtos se cria uma stream deles.
			// Depois se filtram os elementos com preço inferior à variável
			// avg. Então se percorrem os elementos restantes e eles são
			// ordenados, comparando-os usando a interface instanciada comp,
			// invertendo a ordem com "reversed". Por fim, transformadas em 
			// list novamente.
			List<String> names = list.stream()
					.filter(p -> p.getPrice() < avg)
					.map(p -> p.getName()).sorted(comp.reversed())
					.collect(Collectors.toList());
			
			// Para cada elemento de "names", chama-se o método println
			// da classe System.out.
			names.forEach(System.out::println);
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	sc.close();
	}
}