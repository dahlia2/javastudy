package ex04_supplier.ch03;

import java.util.function.Supplier;

public class CheckPoint {
	
	// 임의의 포인트를 반환하는 Supplier 함수형 인터페이스를 사용한 버전
	
	public void confirmPoint(String grade, Supplier<Integer> supplier) {
		switch(grade) {
		case "gold":
			System.out.println("획득포인트: " + supplier.get() * 3);  // supplier.get() 호출 순간에 getRandomPoint() 메소드가 호출된다.
			break;
		case "silver":
			System.out.println("획득포인트: " + supplier.get() * 2);  // supplier.get() 호출 순간에 getRandomPoint() 메소드가 호출된다.
			break;
		case "bronze":
			System.out.println("획득포인트: " + supplier.get() * 1);  // supplier.get() 호출 순간에 getRandomPoint() 메소드가 호출된다.
			break;
		}
	}
	
}
