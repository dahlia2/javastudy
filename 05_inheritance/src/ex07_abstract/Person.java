package ex07_abstract;

/*
	추상 메소드
	1. abstract method
	2. 본문이 없는 메소드
	3. 중괄호를 없애고, 세미콜론을 붙이고, abstract 키워드를 메소드 앞에 추가한다. (주로 public abstrac 메서드명으로 쓰임)
 */

/*
 	추상 클래스
	1. abstract class
 	2. 추상 메소드를 1개 이상 가진 클래스
 	3. abstract 키워드를 클래스 앞에 추가한다.
 	4. 추상 클래스를 상속 받는 클래스는 "반드시" "모든" "추상 메소드"를 오버라이드 해야 한다.
 	5. 추상 클래스는 객체 생성이 불가능하다. (new Person이 불가능)
 	   (본문이 없는 메소드를 가지고 있기 떄문에)
*/

public abstract class Person {   // abstract 메소드를 가졌으므로 class 앞에도 abstract 추가
	
	public void eat() {
		System.out.println("먹는다.");
	}

	public void sleep() {
		System.out.println("잔다.");
		
	}
	
	public abstract void study(); // 본문이 없는 메소드. 추상 메소드
	
}
