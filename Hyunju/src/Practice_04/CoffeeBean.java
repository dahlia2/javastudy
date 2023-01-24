package Practice_04;

public class CoffeeBean {
	
	private String origin;  // 커피 원산지
	
	public CoffeeBean(String origin) {
		this.origin = origin;
	}
	
	// 조회 메서드
	public void info() {
		System.out.println("원산지 : " + origin);
	}

}
