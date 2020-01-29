package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rent;

public class Program {
	public static void main(String[] args) {

		// 05.03 Vetores (com objetos)

		// A dona de um pensionato possui dez quartos para alugar para estudantes,
		// sendo esses quartos identificados pelos números 0 a 9.
		// Fazer um programa que inicie com todos os dez quartos vazios, e depois
		// leia uma quantidade N representando o número de estudantes que vão
		// alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos
		// N estudantes. Para cada registro de aluguel, informar o nome e email do
		// estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha
		// que seja escolhido um quarto vago. Ao final, seu programa deve imprimir
		// um relatório de todas ocupações do pensionato, por ordem de quarto,
		// conforme exemplo.

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Rent[] rent = new Rent[10];

		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();

		System.out.println();
		for (int count = 0; count < n; count++) {
			System.out.println("Rent #" + (count + 1) + ":");
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			rent[room] = new Rent(name, email);
			System.out.println();
		}

		System.out.println("Busy rooms:");
		for (int count = 0; count < rent.length; count++) {
			if (rent[count] != null) {
				System.out.println(count + ": " + rent[count].getName() + ", " + rent[count].getEmail());
			}
		}

		sc.close();
	}
}