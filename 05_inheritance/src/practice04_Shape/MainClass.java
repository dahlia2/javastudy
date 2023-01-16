package practice04_Shape;

public class MainClass {

	public static void main(String[] args) {
		
		Shape circle = new Circle(1.5);  
		System.out.println("원 면적 : " + circle.getArea());
		
		Shape rectangle = new Rectangle(1.5, 2.5);
		System.out.println("사각형 면적 : " + rectangle.getArea()); // 너비 1.5, 높이가 2.5인 정사각형
		
		Shape square = new Square(1.5); // 너비, 높이가 1.5인 정사각형  ->  사각형의 자식으로 상속 관계
		System.out.println("정사각형 면적 : " + square.getArea());
		
	}
	
}
