package Coffee;

public class Americano {
	
	// 에스프레소 여러 잔이 들어가고
	// 그 각각 에스프레소에 들어간 샷 개수
	// 물
	// cups 배열의 인덱스
	
	private Espresso[] cups;
	private int shotCount;
	private int extraWater;
	private int idx;
	
	// 아메리카노(샷과 물이 있는)
	// 그 샷은.. 에스프레소의 한 컵이다
	public Americano(int shotCount, int extraWater) {
		cups = new Espresso[shotCount];
		this.shotCount = shotCount;
		this.extraWater = extraWater;
	}
	
	
	// 샷 추가 메소드
	// 샷은 에스프레소에만 있으므로 컵 용량을(인덱스) 초과할 수 없다
	public void addEspresso(Espresso espresso) {
		if(idx == shotCount) {
			System.out.println("더 이상 샷을 추가할 수 없습니다.");
			return;
		}
		cups[idx++] = espresso; // -> 한컵은 에스프레소들의 집합이니까!
			
	}
	
	// 조회 info 메소드
	public void info() {
		int totalWater = 0;
		for(int i = 0; i < cups.length; i++) {
			System.out.println("◁◁◁ " + (i + 1) + "번째 샷 정보 ▷▷▷");
			cups[i].info();
			totalWater += cups[i].getWater();  // 에스프레소에 들어간 물을 더해줌
		}
	totalWater += extraWater;
	System.out.println("아메리카노 총 ml" + totalWater + "ml");
	
	}
	
}
