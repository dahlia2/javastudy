package ex02_loop;

public class Ex02_while {

	/*
	 	while문
	 	1. 특정 조건을 만족하면 반복하는 반복문
	 	(어떤 데이터를 가져오는 경우 => 주로 사용 파일이나, 데이터베이스 등 갯수를 알 수 없을 때)
	 	2. 형식
	 		while(조건문) {
	 			실행문
	 		}
	 */
	
	public static void ex01() {
		
		// 1 ~ 10 (이 경우는 보통 for문에 사용)
		int a =1;
		while(a <= 10) {
			System.out.println(a);
			a++;
		}
		
	}
	
	public static void ex02() {
		
		int account = 85000;
		int money = 550;
		int n = 0;
		
		while(account >= money) {
			System.out.print(++n + "번째 출금 결과 : ");
			account -= money;
			System.out.println("계좌 " + account + "원");
			
		}
		
	}
	
	public static void ex03() {
		
		// 예제 2번을 for문으로 변경
		
		int account = 85000;
		int money = 550;
		
		for(int i = 1; i <= 154; i++) {
			System.out.print(i + "번째 출금 결과 : ");
			account -= money;
			System.out.println("계좌 " + account + "원");
		}
		
	}
	
	
	// 메소드 호출
	public static void main(String[] args) {
		ex03();
	}

}
