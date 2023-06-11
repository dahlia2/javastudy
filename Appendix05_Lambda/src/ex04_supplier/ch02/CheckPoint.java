package ex04_supplier.ch02;

public class CheckPoint {
	
	// 현재 등급과 포인트를 전달 받은 뒤,
	// 등급에 따른 획득포인트를 확인할 수 있는 confirmPoint 메소드
	public void confirmPoint(String grade, int point) {
		switch(grade) {
		case "gold":
			System.out.println("획득포인트: " + point * 3);
			break;
		case "silver":
			System.out.println("획득포인트: " + point * 2);
			break;
		case "bronze":
			System.out.println("획득포인트: " + point * 1);
			break;
		}
	}
	
}
