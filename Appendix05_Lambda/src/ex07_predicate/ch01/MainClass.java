package ex07_predicate.ch01;

import java.util.function.Predicate;

public class MainClass {

	/*
		Predicate
		
		1. 어떤 값을 전달 받아서 true 또는 false를 반환하는 함수형 인터페이스이다.
		2. test() 추상 메소드를 가지고 있다.
		
		3. 형식
		
			@FunctionalInterface
			public interface Predicate<T> {
			    boolean test(T t);
			}
	*/
	
	public static void main(String[] args) {
		
		// 전달된 Integer값이 0보다 크면 true 아니면 false를 반환하는 Predicate
		
		// 익명 구현 객체
		Predicate<Integer> predicate1 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 0;
			}
		};
		
		if(predicate1.test(-10)) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		
		
		// 람다식
		Predicate<Integer> predicate2 = (t) -> t > 0;
		
		if(predicate2.test(10)) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		
	}

}
