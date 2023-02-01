package PRACTICE_2;

public class Expresso {
	
	// 커피원두와 물
	private CoffeeBean coffeeBean;
	private int water;
	
	
	// 커피빈과 물을 가져오는 법  >>>  1. 생성자
	public Expresso(CoffeeBean coffeeBean, int water) {
		this.coffeeBean = coffeeBean;
		this.water = water;
	}

	
	// 커피빈과 물을 가져오는 법  >>>  2. 겟셋
	public CoffeeBean getCoffeeBean() {
		return coffeeBean;
	}

	public void setCoffeeBean(CoffeeBean coffeeBean) {
		this.coffeeBean = coffeeBean;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
		
	// 커피원두와 물의 정보를 알려주는 메소드
	public void info() {
		coffeeBean.info();
		System.out.println("물 ml은 " + water + "ml입니다.");
	}

}
