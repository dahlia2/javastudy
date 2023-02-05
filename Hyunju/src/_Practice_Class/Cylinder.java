package _Practice_Class;

import java.util.concurrent.CyclicBarrier;

public class Cylinder {
	
	/*
	 내가 쓴 답
	private Circle circle = new Circle(double radius);
	private double height;
	
	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getVolume(double radius, double height) {
		return circle.getArea() * height;
		
	}

	
	public static void main(String[] args) {
		
		System.out.println(getVolume(2.8, 5.6));

	}
	 */
	
	Circle circle;
	double height;
	
	public Cylinder (Circle circle, double height) {
		this.circle = circle;
		this.height = height;
	}
	
	public double getVolume() {
		return circle.getArea() * height;
	}
	
	public static void main(String[] args) {
		
		Cylinder cd = new Cylinder(new Circle(2.8), 5.6);
		
		System.out.println("부피 : " + cd.getVolume());
	}
	

}
