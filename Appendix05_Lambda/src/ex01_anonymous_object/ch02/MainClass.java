package ex01_anonymous_object.ch02;

public class MainClass {

	public static void main(String[] args) {
		
		GasStation gasStation = new GasStation();
		
		// 기름을 팔자.
		gasStation.sellOil("소나타", 50);
		gasStation.sellOil("그랜저", 50);
		
		System.out.println("남은기름 : " + gasStation.getTotalOil());
		System.out.println("번 돈 : " + gasStation.getEarning());

	}

}
