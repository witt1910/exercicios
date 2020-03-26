package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {

		// 11.07 Exercicio sobre File - File e Buffered, Readers e Writers

//		Fazer um programa para ler o caminho de um arquivo .csv
//		contendo os dados de itens vendidos. Cada item possui um
//		nome, preço unitário e quantidade, separados por vírgula. Você
//		deve gerar um novo arquivo chamado "summary.csv", localizado
//		em uma subpasta chamada "out" a partir da pasta original do
//		arquivo de origem, contendo apenas o nome e o valor total para
//		aquele item (preço unitário multiplicado pela quantidade),
//		conforme exemplo.

//		Source file:
//		TV LED,1290.99,1
//		Video Game Chair,350.50,3
//		Iphone X,900.00,2
//		Samsung Galaxy 9,850.00,2
//		
//		Output file (out/summary.csv):
//		TV LED,1290.99
//		Video Game Chair,1051.50
//		Iphone X,1800.00
//		Samsung Galaxy 9,1700.00

		// Padroniza entrada por ponto - US
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Cria lista de produtos
		List<Product> list = new ArrayList<>();

		// Obtem caminho do arquivo 'product'
		System.out.print("Enter a file path: ");
		String sourceFileStr = sc.nextLine();

		// Cria File a partir do caminho de 'product'
		File sourceFile = new File(sourceFileStr);
		
		// Cria String com caminho da pasta de 'product'
		String sourceFolderStr = sourceFile.getParent();

		// Cria pasta '..\out'
		boolean success = new File(sourceFolderStr + "\\out").mkdir();

		// Registra caminho do arquivo a ser criado, '..\out\summary.csv'
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		// Inicia o processo de leitura do arquivo, identificando-o como o que fora 
		// digitado inicialmente
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			// Registra numa String a primeira linha do arquivo
			String itemCsv = br.readLine();
			
			// Faz com que seja lida cada linha até a última
			while (itemCsv != null) {

				// Cria um vetor de Strings, partindo uma linha por vez
				String[] fields = itemCsv.split(",");
				// converte o segundo item do vetor em double
				double price = Double.parseDouble(fields[1]);
				// converte o terceiro item do vetor em int
				int quantity = Integer.parseInt(fields[2]);
				// Cria um produto, passando a Stirng, o Double e o Integer necessários
				Product product = new Product(fields[0], price, quantity);

				// Adiciona o referido produto à lista
				list.add(product);

				// Insere a linha seguinte (se existir) na String, para ser lida
				itemCsv = br.readLine();
			}

			// Inicia o processo de escrita (cria) do arquivo, pelo nome e endereço indicado
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				// Percorre todos os itens da lista
				for (Product item : list) {
					// Registra os dados de cada item, separado por vírgula, no novo arquivo
					bw.write(item.getName());
					bw.write(",");
					bw.write(String.format("%.2f", item.total()));
					bw.newLine();
				}

				// Imprime tela de confirmação do processo, com novo caminho indicado
				System.out.println(targetFileStr + " CREATED!");

			// Erro a ser exibido se houver problema na escrita
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		// Erro a ser exibido se houver problema na leitura
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		// Fechamento do Scanner
		sc.close();
	}
}