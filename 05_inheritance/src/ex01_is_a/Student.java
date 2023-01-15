package ex01_is_a;

public class Student extends Person {   // Person의 클래스를 상속 받음
	
	public void eat() {
		System.out.println("먹는다.");
	}
	
	public void sleep() {
		System.out.println("잔다.");
	}
	
	public void study() {
		System.out.println("공부한다.");
	}

}
