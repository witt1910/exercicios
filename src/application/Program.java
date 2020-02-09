package application;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 05.07 Matriz

//		Fazer um programa para ler um número inteiro N e uma matriz de
//		ordem N contendo números inteiros. Em seguida, mostrar a diagonal
//		principal e a quantidade de valores negativos da matriz.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] mat = new int[n][n];

		int negativeNumbers = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = sc.nextInt();
				if (mat[i][j] < 0) {
					negativeNumbers++;
				}
			}
		}

		System.out.println("Main diagonal:");
		for (int i = 0; i < mat.length; i++) {
			System.out.print(mat[i][i] + " ");
		}

		System.out.println();
		System.out.println("Negative numbers = " + negativeNumbers);

		sc.close();

		// Resolução alternativa
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//		int[][] mat = new int[n][n];
//
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[i].length; j++) {
//				mat[i][j] = sc.nextInt();
//			}
//		}
//
//		System.out.println("Main diagonal:");
//		for (int i = 0; i < mat.length; i++) {
//			System.out.print(mat[i][i] + " ");
//		}
//		System.out.println();
//
//		int count = 0;
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[i].length; j++) {
//				if (mat[i][j] < 0) {
//					count++;
//				}
//			}
//		}
//		System.out.println("Negative numbers = " + count);
//
//		sc.close();
	}
}