package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
	public static void main(String[] args) {

		// 05.06 List (exercicio)

//		Fazer um programa para ler um n�mero inteiro N e depois os dados (id, nome e salario) de
//		N funcion�rios. N�o deve haver repeti��o de id.
//		Em seguida, efetuar o aumento de X por cento no sal�rio de um determinado funcion�rio.
//		Para isso, o programa deve ler um id e o valor X. Se o id informado n�o existir, mostrar uma
//		mensagem e abortar a opera��o. Ao final, mostrar a listagem atualizada dos funcion�rios,
//		conforme exemplos.
//		Lembre-se de aplicar a t�cnica de encapsulamento para n�o permitir que o sal�rio possa
//		ser mudado livremente. Um sal�rio s� pode ser aumentado com base em uma opera��o de
//		aumento por porcentagem dada.

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registraded? ");
		int numb = sc.nextInt();
		System.out.println();
		for (int count = 0; count < numb; count++) {
			System.out.println("Employee #" + (count + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
			System.out.println();
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}
	}
}