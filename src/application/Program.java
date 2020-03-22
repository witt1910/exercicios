package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {
	public static void main(String[] args) {

		// 08.06 Métodos abstratas (inherance 07)

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Shape> list = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		int numb = sc.nextInt();

		for (int count = 1; count <= numb; count++) {
			System.out.println("Shape #" + count + " data:");
			System.out.print("Rectangle or circle (r/c)? ");
			char op = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			if (op == 'r') {
				System.out.print("Widht: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				Shape rec = new Rectangle(color, width, height);
				list.add(rec);
			}
			if (op == 'c') {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				Shape cir = new Circle(color, radius);
				list.add(cir);
			}
		}

		System.out.println();
		System.out.println("SHAPE AREAS:");
		for (Shape shp : list) {
			System.out.printf("%.2f%n", shp.area());
		}

		sc.close();
	}
}