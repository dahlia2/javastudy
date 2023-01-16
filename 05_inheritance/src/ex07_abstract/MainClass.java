package ex07_abstract;

public class MainClass {

	public static void main(String[] args) {
		
		Person person = new Student();
		
		person.eat();
		person.sleep();
		person.study(); 
		
		/* 하나의 메소드로 여러 객체를 받아서 처리할 수도 있음
		method(Person person) { } 
		          ㄴ Student 혹은 Alba의 객체가 올 수 있다. */
		
	}
}
