package Coffee;

import Practice_04.CoffeeBean;
import Practice_04.Espresso;

public class MainClass {

	public static void main(String[] args) {


		// 브라질 원두
		CoffeeBean coffeeBean = new CoffeeBean("브라질");
		CoffeeBean coffeeBean2 = new CoffeeBean("케냐");
		
		// 브라질 원두 + 물 50ml를 '사용한' 에스프레소 샷
		Espresso espresso = new Espresso(coffeeBean, 50);
		// 케냐 원두 + 물 30ml를 '사용한' 에스프레소 샷
		Espresso expresso2 = new Espresso(coffeeBean2, 30);
		
		// 에스프레소 2샷에 물 100ml를 사용한 아메리카노
		Americano americano = new Americano(2, 100);	
		
		// 각 다른 2잔의 에스프레소 샷 추가
	//	americano.addEspresso(espresso2);  // 왜 안 되는지...
		
		// 커피 원두 원산지, 에스프레소 샷 정보 등 조호;
		americano.info(); 

	}

}
