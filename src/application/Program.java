package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
	public static void main(String[] args) {

		// 14.14 Set - Exerc�cio 02 - HashSet e addAll()

//		Em um portal de cursos online, cada usu�rio possui um c�digo �nico, 
//		representado por um n�mero inteiro.
//		Cada instrutor do portal pode ter v�rios cursos, sendo que um mesmo aluno pode se
//		matricular em quantos cursos quiser. Assim, o n�mero total de alunos de um instrutor n�o
//		� simplesmente a soma dos alunos de todos os cursos que ele possui, pois pode haver
//		alunos repetidos em mais de um curso.
//		O instrutor Alex possui tr�s cursos A, B e C, e deseja saber seu n�mero total de alunos.
//		Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
//		quantidade total e alunos dele, conforme exemplo.

		Scanner sc = new Scanner(System.in);

		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			a.add(number);
		}

		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			b.add(number);
		}

		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			c.add(number);
		}
		
		Set<Integer> total = new HashSet<>(a);
		total.addAll(b);
		total.addAll(c);

		System.out.println("Total students: " + total.size());

		sc.close();
	}
}