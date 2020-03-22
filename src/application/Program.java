package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {

		// 08.07 Métodos abstratas
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> taxPayers = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int numb = sc.nextInt();

		for (int count = 1; count <= numb; count++) {
			System.out.println("Taxa payer #" + count + " data:");
			System.out.print("Individual or company (i/c)? ");
			char op = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (op == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				TaxPayer indi = new Individual(name, anualIncome, healthExpenditures);
				taxPayers.add(indi);
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				TaxPayer comp = new Company(name, anualIncome, numberOfEmployees);
				taxPayers.add(comp);
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");
		double totalPaxes = 0.0;
		for (TaxPayer tp : taxPayers) {
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
			totalPaxes += tp.tax();
		}

		System.out.println();
		System.out.println("TOTAL PAXES: $ " + String.format("%.2f", totalPaxes));
	}
}