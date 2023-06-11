package ex04_supplier.ch02;

public class MainClass {
	
	// 호출하면 1초(1000밀리초) 후에 0~999 사이 난수를 반환하는 getRandomPoint() 메소드
	public static int getRandomPoint() {
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return (int)(Math.random() * 1000);
	}
	
	public static void main(String[] args) {
		
		CheckPoint checkPoint = new CheckPoint();
		
		checkPoint.confirmPoint("gold",   getRandomPoint());
		checkPoint.confirmPoint("silver", getRandomPoint());
		checkPoint.confirmPoint("bronze", getRandomPoint());
		
	}

}
