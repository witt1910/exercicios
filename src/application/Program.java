package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {

		// 08.05 Classes abstratas

		Locale.setDefault(Locale.US);
		List<Account> list = new ArrayList<>();

		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
		list.add(new BusinessAccount(1002, "Maria", 1000.00, 400.0));
		list.add(new SavingsAccount(1004, "Bob", 300.00, 0.01));
		list.add(new BusinessAccount(1005, "Anna", 500.00, 500.0));

		// Somar os saldos de contas de diferentes subtipos,
		// pelo tipo principal comum.
		double sum = 0.0;
		for (Account acc : list) {
			sum += acc.getBalance();
		}

		// Depositar em qualquer conta, de qualquer tipo,
		// a mesma quantia.
		for (Account acc : list) {
			acc.deposit(10.0);
		}

		for (Account acc : list) {
			System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}
	}
}