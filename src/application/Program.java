package application;

import java.util.Locale;
import java.util.Scanner;

import model.services.InterestService;
import model.services.UsaInterestService;

public class Program {
	public static void main(String[] args) {

		// 13.11 Interfaces - Default methods

//		Fazer um programa para ler uma quantia e a duração em meses de um
//		empréstimo. Informar o valor a ser pago depois de decorrido o prazo do
//		empréstimo, conforme regras de juros do Brasil. A regra de cálculo de
//		juros do Brasil é juro composto padrão de 2% ao mês.
//		Depois, inserir o mesmo, com um exemplo norteamericano, considerando
//		juro de 1% ao mês.

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();

		InterestService is = new UsaInterestService(1.0);
		double payment = is.payment(amount, months);

		System.out.println("Payment afeter: " + months + " months:");
		System.out.println(String.format("%.2f", payment));
	}
}