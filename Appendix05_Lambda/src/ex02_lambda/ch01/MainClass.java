package ex02_lambda.ch01;

public class MainClass {

	/*
		람다식
		
		1. 익명 객체를 생성하기 위한 표현식이다.
		2. 실행(Runtime)할 때 익명 객체가 생성되면서 동작한다.
		3. 추상 메소드가 하나인 인터페이스(함수형 인터페이스)에서 람다식을 사용할 수 있다.
		
		4. 형식
		
			(매개변수) -> {
				메소드 본문
			};
		
		5. 적용 예시
		
			1) 매개변수 X, 반환 X
			
				() -> {
					System.out.println("Hello World");
				};
				
				() -> System.out.println("Hello World");  // 메소드 본문이 한 줄이면 중괄호({}) 생략
				
			2) 매개변수 O, 반환 X (매개변수의 타입은 생략한다.)
			
				(n) -> {
					System.out.println(n);
				};
				
			3) 매개변수 X, 반환 O (반환값의 타입은 생략한다.)
			
				() -> {
					return "Hello World";
				};
				
				() -> "Hello World";  // 메소드 본문에 return만 존재하면 return을 생략한다.
				
			4) 매개변수 O, 반환 O
			
				(n) -> {
					System.out.println(n);
					return n + 1;
				};
				
	*/
	
	public static void m1() {
		
		Car car = () -> System.out.println("기름 넣기");
		
		car.addOil();
		
	}
	
	public static void gasStation() {
		
		GasStation gasStation = new GasStation();
		
		gasStation.getCar().addOil();
		
		System.out.println("남은기름 : " + gasStation.getTotalOil());
		System.out.println("번 돈 : " + gasStation.getEarning());
		
	}
	
	public static void main(String[] args) {
		m1();
	}

}
