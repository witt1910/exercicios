package application;

import java.io.File;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 11.06 Obter informações do caminho do arquivo

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);

		// Obter somente nome e tipo
		System.out.println("getName: " + path.getName());
		// Obter somente o diretório do arquivo
		System.out.println("getParent: " + path.getParent());
		// Obter direiório e nome do arquivo, com tipo
		System.out.println("getPath: " + path.getPath());
		
		sc.close();
	}
}