package ex02_Runnable;

public class Gun {
	
	private int bullet;
	
	public Gun(int bullet) {
		this.bullet = bullet;
	}
	
	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}

	
	public void shoot() {
		if(bullet == 0) {
			throw new RuntimeException("총알이 없습니다.");  // 모든 UNCHECKED 예외는 RuntimeExeption의 자식. 하지만 생략 가능
		} else {
		bullet--;
		System.out.println("빵! " + bullet + "발 남았습니다.");
	}
}
	

}
