package entities;

import entities.enums.Color;

public class Circle extends Shape {

	final static double PI = 3.14159265359;
	
	private Double radius;
	
	public Circle() {
		super();
	}

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	@Override
	public Double area() {
		return PI * (radius * radius);
	}
}
