package ex01_one_dim;

public class Ex03_advance_for {

	public static void ex01() {
		
		int [] scores = {50, 90, 60, 100, 80};
		int total = scores[0];  // 첫 번째 값으로 초기화
		
		for(int i = 1; i < scores.length; i++) {
			total += scores[i];
		}
		
		System.out.println(total);
		
	}
	
	public static void ex02() { // 예제 1번을 더 쉽게 => advance for문!
		
		int [] scores = {50, 90, 60, 100, 80};
		int total = 0;
		for(int n : scores) {
			total += n;
		}
		System.out.println(total);
		
	}
	
	public static void ex03() { // 연습 1번
		
		int [] scores = {50, 90, 60, 100, 80};
		
		int max = 0;
		int min = 100;
		for(int n : scores) {
			if(max < n) {
				max = n ;
			}
			if(min > n) {
				min = n;
			}
		}
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void ex04() { // 연습 2번
		
		String[] files = {"hello.txt", "hi.txt", "안녕.txt"};
		
		for(String f : files) {
			System.out.println(f);
		}
		
	}
	
	
	// 메소드 호출
	public static void main(String[] args) {
		ex04();
		}

	}
