package practice04_Shape;

public class Circle implements Shape {

	// 필드
	private double radius;
	
	// 생성자
	public Circle(double radius) {                  // Shape circle <<타입은shape 생성은circle>>  = new Circle(1.5);
		super();
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return PI * radius * radius;
	}
	
}