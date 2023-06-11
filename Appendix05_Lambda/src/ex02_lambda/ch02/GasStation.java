package ex02_lambda.ch02;

public class GasStation {

	// field
	private int totalOil = 1000;
	private int payPerLiter = 2000;
	private int earning = 0;
	
	// 메소드의 지역변수로 익명 객체 처리하기
	//   기름을 판매하는 sellOil 메소드를 만들고,
	//   자동차모델(String)과 oil값(판매하는 기름량)을 매개변수로 선언해서 처리하는 방식
	public void sellOil(String model, int oil) {
		
		// sellOil 메소드의 지역변수 Car car 선언
		Car car;
		
		// 익명 객체를 이용해서 지역변수 car의 객체 생성
		car = () -> {
			totalOil -= oil;
			earning += oil * payPerLiter;
			System.out.println(model + " 차량 기름 넣기 완료");
		};
		
		// sellOil 메소드 호출이 종료되면 car 객체는 사라지기 때문에,
		// sellOil 메소드 내부에서 car 객체의 addOil 메소드를 호출해야 한다.
		car.addOil();
		
	}
	

	public int getTotalOil() {
		return totalOil;
	}

	public void setTotalOil(int totalOil) {
		this.totalOil = totalOil;
	}

	public int getPayPerLiter() {
		return payPerLiter;
	}

	public void setPayPerLiter(int payPerLiter) {
		this.payPerLiter = payPerLiter;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}
	
}
