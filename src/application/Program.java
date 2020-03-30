package application;

import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;
import model.enums.Color;

public class Program {
	public static void main(String[] args)  {

		// 13.05 Interfaces- Exerc�cio 02 (sem interface, apens com classe abstrata)

		Shape s1 = new Circle(Color.BLACK, 2.0);
		Shape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
		
	}
}