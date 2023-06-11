package ex01_anonymous_object.ch01;

public class MainClass {

	public static void m1() {
		
		// 인터페이스는 왜 객체를 못 만드는가?
		// Car car = new Car();를 못하는 이유 -> 인터페이스의 추상 메소드는 완성되어 있지 않기 때문에 메모리에 존재할 수 없다.
		
		// 익명 객체(이름이 없는 객체)
		// 추상 메소드를 완성시킬 수 있다면, 인터페이스로 객체로 만들 수 있다. 이 때 익명 객체의 형태로 만든다.
		
		Car car = new Car() {
			@Override
			public void addOil() {
				System.out.println("기름 넣기");
			}
		};
		
		car.addOil();
		
	}
	
	public static void gasStation() {
		
		GasStation gasStation = new GasStation();
		
		gasStation.getCar().addOil();
		
		System.out.println("남은기름 : " + gasStation.getTotalOil());
		System.out.println("번 돈 : " + gasStation.getEarning());
		
	}
	
	public static void main(String[] args) {
		gasStation();
	}

}
