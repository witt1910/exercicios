package application;

import java.util.Scanner;

import model.services.PrintService;

public class Program {
	public static void main(String[] args) {

		// 14.01 Generics

//		Deseja-se fazer um programa que leia uma quantidade N, e depois N n�meros
//		inteiros. Ao final, imprima esses n�meros de forma organizada conforme
//		exemplo. Em seguida, informar qual foi o primeiro valor informado.
		
		Scanner sc = new Scanner(System.in);
		
		PrintService<Integer> ps = new PrintService<>();
		
		System.out.print("How many values? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			Integer value = sc.nextInt();
			ps.addValue(value);
		}
		
		ps.print();
		Integer x = ps.first();
		System.out.println("First: " + x);
		
		sc.close();
	}
}