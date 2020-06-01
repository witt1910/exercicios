package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Employee;

public class Program {
	public static void main(String[] args) {

		// 15.13 - Stream - exercício de fixação.

//		Fazer um programa para ler os dados (nome, email e salário)
//		de funcionários a partir de um arquivo em formato .csv.
//		Em seguida mostrar, em ordem alfabética, o email dos
//		funcionários cujo salário seja superior a um dado valor
//		fornecido pelo usuário.
//		Mostrar também a soma dos salários dos funcionários cujo
//		nome começa com a letra 'M'.

//		Input file:
//		Maria,maria@gmail.com,3200.00
//		Alex,alex@gmail.com,1900.00
//		Marco,marco@gmail.com,1700.00
//		Bob,bob@gmail.com,3500.00
//		Anna,anna@gmail.com,2800.00

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Cria lista de Employee
			List<Employee> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				// Converte os elementos do arquivo em formato csv para Employee
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}

			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();

			// Cria lista de emails a partir da lista de Employees.
			// Primeiro converte list em stream. Depois filtra os elementos
			// que possuem saário superior ao valor pedido anteriormente.
			// Então pegam-se todos os emails desses Employees, ordena-os
			// crescentemente e os devolve como list.
			List<String> emails = list.stream()
					.filter(p -> p.getSalary() > salary)
					.map(p -> p.getEmail())
					.sorted()
					.collect(Collectors.toList());

			System.out.println("Email of people whose salary is more than 2000.00:");
			emails.forEach(System.out::println);

			// A partir do list, recupera-se ao fim um valor double de soma.
			// Converte-se o list em stream, filtram-se os elementos com inicial
			// 'M', então pega-se apenas o salary de cada um desses elementos,
			//e somam-se um a um, produzindo a soma total de salários.
			double sumSalary = list.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary())
					.reduce(0.0, (x, y) -> x + y);

			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalary));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

	}
}