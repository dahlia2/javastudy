package ex01_anonymous_object.ch03;

public class GasStation {

	// field
	private int totalOil = 1000;
	private int payPerLiter = 2000;
	private int earning = 0;
	
	// 메소드의 지역변수(매개변수는 지역변수의 일종)로 익명 객체 처리하기
	//   기름을 판매하는 sellOil 메소드를 만들고,
	//   Car 객체를 매개변수로 선언해서 처리하는 방식
	public void sellOil(Car car) {
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
