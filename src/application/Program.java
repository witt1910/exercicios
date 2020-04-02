package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 14.16 - Map - Exerc�cio 01

//		Na contagem de votos de uma elei��o, s�o gerados v�rios registros
//		de vota��o contendo o nome do candidato e a quantidade de votos
//		(formato .csv) que ele obteve em uma urna de vota��o. Voc� deve
//		fazer um programa para ler os registros de vota��o a partir de um
//		arquivo, e da� gerar um relat�rio consolidado com os totais de cada
//		candidato.
		
//		input file example:
//		Alex Blue,15
//		Maria Green,22
//		Bob Brown,21
//		Alex Blue,30
//		Bob Brown,15
//		Maria Green,27
//		Maria Green,22
//		Bob Brown,25
//		Alex Blue,31

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votes = new LinkedHashMap<>();

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				} else {
					votes.put(name, count);
				}
				line = br.readLine();
			}

			for (String s : votes.keySet()) {
				System.out.println(s + ": " + votes.get(s));
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
			;
		}

		sc.close();
	}
}