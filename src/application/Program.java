package application;

import java.util.Locale;
import java.util.Scanner;

import model.services.InterestService;
import model.services.UsaInterestService;

public class Program {
	public static void main(String[] args) {

		// 13.11 Interfaces - Default methods

//		Fazer um programa para ler uma quantia e a dura��o em meses de um
//		empr�stimo. Informar o valor a ser pago depois de decorrido o prazo do
//		empr�stimo, conforme regras de juros do Brasil. A regra de c�lculo de
//		juros do Brasil � juro composto padr�o de 2% ao m�s.
//		Depois, inserir o mesmo, com um exemplo norteamericano, considerando
//		juro de 1% ao m�s.

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