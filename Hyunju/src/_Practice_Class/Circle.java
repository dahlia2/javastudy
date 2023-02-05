package _Practice_Class;

public class Circle {
	
	/*
	 다음에 구현된 Circle 클래스를 참고로 다음을 만족하는 Cylinder 클래스를 작성하시오.

		· 원통을 나타내는 Cylinder 클래스는 Circle형의 원과 실수형의 높이를 필드로 선언
		· 메소드 getVolume()은 원통의 부피를 반환
		· Cylinder 클래스의 main() 메소드에서 반지름이 2.8, 높이가 5.6의 원통의 부피를 출력

		// 원의 넓이 구하는 공식 = 반지름 * 반지름 * 원주율(3.14)
		// 원기둥 부피 공식 = 밑면의 넓이 * 높이

	 */
	
	public double radius;  // 반지름
	public static double PI = 3.14592;  // 원주율
	
	// 생성자 구현
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// 현재 반지름을 사용하여 원의 면적을 구하는 메소드
	public double getArea() {
		return radius * radius * PI;
	}
	

}
