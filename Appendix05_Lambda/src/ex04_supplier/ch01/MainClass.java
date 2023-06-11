package ex04_supplier.ch01;

import java.util.function.Supplier;

public class MainClass {

	/*
		Supplier 인터페이스
		
		1. 아무 것도 전달하지 않아도 항상 특정 값을 반환하는 함수형 인터페이스이다.
		2. get() 추상 메소드를 가지고 있다.
		3. 항상 값을 반환하기 때문에 제공자라고 부른다.
		
		4. 형식
		
			@FunctionalInterface
			public interface Supplier<T> {
			    T get();  // T 타입의 값을 반환함
			}
	*/
	
	public static void main(String[] args) {
		
		// 익명 구현 객체
		Supplier<String> supplier1 = new Supplier<String>() {
			@Override
			public String get() {
				return "Hello";
			}
		};
		System.out.println(supplier1.get());
		
		// 람다식
		Supplier<String> supplier2 = () -> "Hello";
		System.out.println(supplier2.get());
		
	}

}
