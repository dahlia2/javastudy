package ex01_anonymous_object.ch03;

public class MainClass {

	public static void main(String[] args) {

		GasStation gasStation = new GasStation();
		
		// 기름을 팔자.
		gasStation.sellOil(new Car() {
			@Override
			public void addOil() {
				String model = "제네시스";
				int oil = 100;
				gasStation.setTotalOil(gasStation.getTotalOil() - oil);
				gasStation.setEarning(gasStation.getEarning() + oil * gasStation.getPayPerLiter());
				System.out.println(model + " 차량 기름 넣기 완료");
			}
		});
		
		gasStation.sellOil(new Car() {
			@Override
			public void addOil() {
				String model = "모닝";
				int oil = 50;
				gasStation.setTotalOil(gasStation.getTotalOil() - oil);
				gasStation.setEarning(gasStation.getEarning() + oil * gasStation.getPayPerLiter());
				System.out.println(model + " 차량 기름 넣기 완료");
			}
		});
		
		System.out.println("남은기름 : " + gasStation.getTotalOil());
		System.out.println("번 돈 : " + gasStation.getEarning());

	}

}
