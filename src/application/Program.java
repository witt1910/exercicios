package application;

import java.io.File;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 11.05 Manipular pastas com File	\

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		// Listar somente pastas
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("FOLDERS:");
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		// Listar somente arquivos
		File[] files = path.listFiles(File::isFile);
		System.out.println("FILES:");
		for(File file : files) {
			System.out.println(file);
		}
		
		// Criar pasta (e confirmar a sua criação)
		boolean success = new File(strPath + "\\subdir").mkdir();
		System.out.println("Directory created successfully: " + success);
		sc.close();
	}
}