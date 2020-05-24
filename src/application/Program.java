package application;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
	public static void main(String[] args) throws ParseException {

		// 14.14b Set - Exerc�cio 02 - HashSet e addAll()

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

		Set<Integer> courseA = new HashSet<>();
		Set<Integer> courseB = new HashSet<>();
		Set<Integer> courseC = new HashSet<>();
		Set<Integer> totalStudents = new HashSet<>();

		System.out.print("How many students for course A? ");
		int std = sc.nextInt();
		addGrade(courseA, std);

		System.out.print("How many students for course B? ");
		std = sc.nextInt();
		addGrade(courseB, std);

		System.out.print("How many students for course C? ");
		std = sc.nextInt();
		addGrade(courseC, std);

		totalStudents.addAll(courseA);
		totalStudents.addAll(courseB);
		totalStudents.addAll(courseC);

		System.out.println("Total students: " + totalStudents.size());

		sc.close();
	}

	public static void addGrade(Set<Integer> list, int std) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < std; i++) {
			int grade = sc.nextInt();
			list.add(grade);
		}
		sc.close();
	}
}