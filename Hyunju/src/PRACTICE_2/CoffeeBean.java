package PRACTICE_2;

public class CoffeeBean {
	
	// 커피 원산지 정보
	private String origin;
	
	// 커피빈에 대한 원산지를 입력하면 거기에 대응하는 객체를 생성해줌
	public CoffeeBean(String origin) {
		this.origin = origin;
	}
	
	// 원산지 정보를 알려주는 메소드
	
	public void info() {
		System.out.println("원산지는 " + origin + "입니다.");
	}
	
}
