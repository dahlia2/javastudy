package ex02_loop;

public class Ex01_for {
	
	/*
		 for문
		 1. 연속된 숫자를 생성하는 반복문(배열에서 주로 사용)
		 2. 형식
		 	for(①초기문; ②조건문; ④증감문) {    * 초기문은 0으로 시작, 조건문은 < 가 일반적 (배열로 인해)
		 		③실행문
		 	}
	*/
	
	public static void ex01() {
		
		// 1 ~ 10 출력
		for(int a = 1; a <= 10; a++) {
			System.out.println(a);
		}
	}
		
	public static void ex02() {
			
		// 횟수(5번)
		
		int count = 5;
		for(int a = 0; a < count; a++) {
			System.out.println("Hello World");
		}
			
	}
	
	public static void ex03() {
		
		// 10 ~ 1
		
		for(int a = 10; a > 0; a--) {
			System.out.println(a);
		}
		
	}
	
	public static void ex04() {
		
		// 구구단 2단 출력
		
		int dan = 2; // 이 곳에 원하는 구구단을 넣으면 된다.
		
		for(int a = 1; a < 10; a++) {
			System.out.println(dan + " x " + a + " = " + (dan * a));
		}
		
	}
	
	
	// 메소드 호출
	public static void main(String[] args) {
		ex03();
		System.out.println();
		ex04();
	}

}
