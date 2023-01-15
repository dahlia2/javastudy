package ex02_has_a;

public class Soldier extends Gun {
	
	// 솔져가 건의 기능을 사용 (군인이 총을 사용한다)
/*
	has a 관계
	1. 상속 관계로 만들 수 있는 관계이다.
	2. Soldier has a Gun
	3. 자식 has a 부모
 */
	
	// 필드
	private String model;
	private int bullet;
	private final int MAX_BULLET = 20;
	
	// 메소드
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;  // 필드변수 모델과 매개변수 모델이 같다
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	// 총알 넣기
	public void reload(int bullet) {
		if(this.bullet == MAX_BULLET) {
			return;
		}
		this.bullet += bullet;
		this.bullet = ((this.bullet > MAX_BULLET) ? MAX_BULLET : this.bullet);
	}
	
	// 총 쏘기
	public void shoot() {
		if(bullet == 0) {
			System.out.println("헛빵");
			return;
		}
		bullet--;   // 매개변수가 없다면 굳이 this를 안 적어도 됨
		System.out.println("빵");
		}
	
}

