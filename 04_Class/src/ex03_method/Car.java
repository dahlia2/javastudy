package ex03_method;

public class Car {
	
	// 필드
	int oilPot;
	int carSpeed; // pushAccel 마다 속도는 10씩 증가, 최대 속도는 100, pushBrake 마다 속도 10씩 감소
	
	// 기름 넣기 메소드
	void addoil(int oil) {
		oilPot += oil;
		if(oilPot > 50) {   // 최대 50으로 설정
			oilPot = 50;
		}
		
	}
	
	void addoil2(int oil) {
		if(oilPot + oil > 50) {
			oilPot = 50;
			return;  // 메소드를 종료하시오. (반환 타입이 void일 때만 쓰임)
		}
		oilPot += oil;
	}

	
	// 달리기 메소드
	void pushAccel() {
		
		if(oilPot == 0) {
			return;
		}
		
		oilPot--;
		
		if(carSpeed + 10 > 100) {
			carSpeed = 100;
			return;
		}
		
		carSpeed += 10;
		
	}
	
	
	// 멈추기 메소드
	void pushBrake() {
		
		if(carSpeed == 0) {
			return;

		}
		
		carSpeed -= 10;
		if(carSpeed < 0) {
			carSpeed = 0;
		}
		
	}
	
}
