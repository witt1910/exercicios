package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.entities.LogEntry;

public class Program {
	public static void main(String[] args) {

		// 14.12 Set - Exerc�cio 01 - HashSet

//		Um site de internet registra um log de acessos dos usu�rios. Um
//		registro de log consiste no nome de usu�rio (apenas uma palavra) e o
//		instante em que o usu�rio acessou o site no padr�o ISO 8601,
//		separados por espa�o, conforme exemplo. Fazer um programa que leia
//		o log de acessos a partir de um arquivo, e da� informe quantos usu�rios
//		distintos acessaram o site.

//		input file:
//		amanda 2018-08-26T20:45:08Z
//		alex86 2018-08-26T21:49:37Z
//		bobbrown 2018-08-27T03:19:13Z
//		amanda 2018-08-27T08:11:00Z
//		jeniffer3 2018-08-27T09:19:24Z
//		alex86 2018-08-27T22:39:52Z
//		amanda 2018-08-28T07:42:19Z

		Scanner sc = new Scanner(System.in);

		Set<LogEntry> set = new HashSet<>();

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				set.add(new LogEntry(username, moment));

				line = br.readLine();
			}

			System.out.println("Total users: " + set.size());

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}
