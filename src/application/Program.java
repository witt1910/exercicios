package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employee;

public class Program {
	public static void main(String[] args) {

		// 13.10 Interfaces/Comparable - Exercício 04 - comparação entre objetos (com Comparable)

		List<Employee> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				String name = fields[0];
				double salary = Double.parseDouble(fields[1]);
				Employee employee = new Employee(name, salary);
				list.add(employee);
				employeeCsv = br.readLine();
			}
			
			Collections.sort(list);
			
			for(Employee emp : list) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}