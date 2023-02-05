package Coffee;

public class Espresso {
	
	// 커피원두와 물
	private CoffeeBean coffeeBean;
	private int water;
	
	
	// 에스프레소를 만들려면 원두와 물이 필요  >>>  1. 생성자
	public Espresso(CoffeeBean coffeeBean, int water) {
		this.coffeeBean = coffeeBean;
		this.water = water;
	}

	
	// 에스프레소를 만들려면 원두와 물이 필요  >>>  2. 겟셋
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
		coffeeBean.info();  // 커피빈의 info 메소드 오버라이드
		System.out.println("물 ml은 " + water + "ml입니다.");
	}

}
