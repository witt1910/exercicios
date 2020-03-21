package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	public static void main(String[] args) {

		// 08.03 Inheritance 04 - "Final" e Polimorfismo 

		// Uma empresa possui funcionarios próprios e terceirizados.
		// Para cada funcionário, deseja-se registrar nome, horas
		// trabalhadas e valor por hora. Funcionarios terceirizado
		// possuem ainda uma despesa adicional.
		// O pagamento dos funcionarios corresponde ao valor da hora
		// multiplicado pelas horas trabalhadas, sendo que os
		// funcionários terceirizados ainda recebem um bônus
		// correspondente a 110% de sua despesa adicional.
		// Fazer um programa para ler os dados de N funcionários (N
		// fornecido pelo usuário) e armazená-los em uma lista. Depois
		// de ler todos os dados, mostrar nome e pagamento de cada
		// funcionário na mesma ordem em que foram digitados.
		// Construa o programa conforme projeto ao lado. Veja
		// exemplo na próxima página.

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> emp = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int numberEmployees = sc.nextInt();

		for (int i = 1; i <= numberEmployees; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if (outsourced == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				emp.add(employee);
			} else {
				Employee employee = new Employee(name, hours, valuePerHour);
				emp.add(employee);
			}
		}

		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee e : emp) {
			System.out.println(e.getName() + " - $ " + String.format("%.2f", e.payment()));
		}

	}
}