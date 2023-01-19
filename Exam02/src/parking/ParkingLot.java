package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() {
	System.out.println("현재 등록된 차량은 : " + idx + "대");
	if(idx == cars.length ) {
		System.out.println("더 이상 차량 등록이 불가능합니다.");
		return;
	}
	
	System.out.print("차량번호 >>>>> ");
	String carNo = sc.next();
	
	System.out.print("모델 >>>>> ");
	String model = sc.next();
	
	cars[idx++] = new Car(carNo, model);
	System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
	}
	
	public void deleteCar() {
		if( idx <= 0
	}
	
	public void printAllCars() {
		
		for(String str : cars) {
			System.out.println(str);
		}
	}
	
	public void manage() {
		
		while(true) {
			
			System.out.println("1. 추가 2. 삭제 3. 전체 0. 종료 >>> ");
			
			String choice = sc.next();
			
			switch(choice) {
			
			case "1":
				addCar(); // addCar 호출
				
			case "2":
				deleteCar();
				
			case "3":
				printAllCars();
				
			case "0":
				return;
				
			default:
				System.out.println("존재하지 않는 메뉴입니다.");
		}
	}
	
}
}
	