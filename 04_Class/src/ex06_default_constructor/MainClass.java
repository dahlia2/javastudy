package ex06_default_constructor;

public class MainClass {
	
	/*  왕중요!!
	 	생성자(Constructor)
	 	1. 객체를 생성할 때 사용되는 메소드이다.
	 	2. new 키워드 이후에 호출된다.
	 	3. 특징
	 		1) 생성자의 이름은 클래스의 이름과 같다.
	 		2) 반환타입이 존재하지 않는다.
	 		3) 매개변수는 일반 메소드와 동일하게 사용한다.
	 */
	/*
	 	디폴트 생성자(Default Constructor)
	 	1. 개발자가 생성자를 만들지 않으면 자동으로 사용되는 생성자이다.    즉 개발자가 만들면 디폴트생성자가 아님
	 	2. 매개변수가 없고, 본문이 비어 있는 형태이다.
	 	
	 */
	/* 
			default constructor
			객체(클래스 필드) 생성할 때 만드는 메소드를 생성자라고 함.
			Calculator calculator = new Calculator();
			-> 클래스 필드(객체) 생성
			-> 이름이 Calculator인 메소드 호출
			
			특징: 메소드 이름이 클래스와 같음, 전달하는 인수 x
	 */

	public static void main(String[] args) {
		
		//User 객체 생성(생성자가 자동으로 호출되는 지점)
		User user = new User();
		
		user.info();

	}

}
