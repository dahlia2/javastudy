package ex06_function.ch02;

import java.util.function.Function;

public class MainClass {

	public static void printName(Function<Person, String> function) {
		Person person = new Person("정숙", 20);
		System.out.println(function.apply(person));
	}
	
	public static void printAge(Function<Person, Integer> function) {
		Person person = new Person("상철", 30);
		System.out.println(function.apply(person));
	}
	
	public static void main(String[] args) {

		
		printName( (p) -> p.getName() );  // printName(Function<Person, String> function)으로 선언되어 있으므로,
		                                  // 매개변수 p는 Person 타입이고 반환값 p.getName()은 String 타입이다.
		
		printAge( (p) -> p.getAge() );    // printAge(Function<Person, Integer> function)으로 선언되어 있으므로,
		                                  // 매개변수 p는 Person 타입이고 반환값 p.getAge()는 Integer 타입이다.
		
	}

}
