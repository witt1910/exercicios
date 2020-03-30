package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
	public static void main(String[] args) {

		// 13.09 Interfaces/Comparable - Exerc�cio 04 - compara��o entre Strings

		List<String> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String name = br.readLine();
			while (name != null) {
				list.add(name);
				name = br.readLine();
			}
			
			Collections.sort(list);
			
			for(String s : list) {
				System.out.println(s);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}