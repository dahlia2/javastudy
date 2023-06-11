package ex06_function.ch01;

import java.util.function.Function;

public class MainClass {

	/*
		Function
		
		1. 매개변수를 받아서 처리한 뒤 어떤 값을 반환하는 함수형 인터페이스이다.
		2. apply() 추상 메소드를 가지고 있다.
		3. 어떤 값을 받아서 처리한 결과를 반환하기 때문에 함수라고 부른다.
		
		4. 형식
		
			@FunctionalInterface
			public interface Function<T, R> {  // T는 매개변수의 타입, R은 반환값의 타입
			    R apply(T t);
			}
	*/
	

	public static void main(String[] args) {
		
		// 문자열 형식의 정수값을 받아서 숫자 형식의 정수값을 반환하는 Function 인터페이스
		
		// Function<String, Integer> : String을 받아서 Integer를 반환하는 Function
		
		// 익명 구현 객체
		Function<String, Integer> function1 = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		int n1 = function1.apply("10");
		System.out.println(n1);
		
		// 람다식
		Function<String, Integer> function2 = t -> Integer.parseInt(t);
		int n2 = function2.apply("20");
		System.out.println(n2);
		
	}

}
