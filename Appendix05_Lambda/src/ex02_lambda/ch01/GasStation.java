package ex02_lambda.ch01;

public class GasStation {

	// field
	private int totalOil = 1000;
	private int payPerLiter = 2000;
	private int earning = 0;
	
	// field (Car) : 익명 객체를 field에 저장하기
	private Car car = () -> {
		int oil = 10;
		totalOil -= oil;
		earning += oil * payPerLiter;
		System.out.println("기름 넣기 완료");
	};

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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
