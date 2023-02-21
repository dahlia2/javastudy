package service;

import java.util.List;
import java.util.Scanner;

import dao.ContactDAO;
import dto.ContactDTO;

public class ContactServiceimpl implements ContactService {
	
	// 필드
	private Scanner sc;
	private ContactDAO dao;
	
	// 생성자
	public ContactServiceimpl() {
		sc = new Scanner(System.in);
		dao = ContactDAO.getInstance();
	}
	
	
	
	// 메소드 ///////////////////////////
	
	
	// [ 차량 추가 ]
	@Override
	public void addCar() {
		System.out.println("========== 차량 추가하기 ==========");
		
		System.out.print("신규 차량 입력 [차량 번호] >>> ");
		String num = sc.nextLine(); // 공백도 들어가게 Line
		
		System.out.print("신규 차량 입력 [모델명] >>> ");
		String model = sc.next();
		
		// 받은 값을 하나로 모음
		ContactDTO car = new ContactDTO();
		car.setNum(num);
		car.setModel(model);  // DTO set 설정!
		
		// 하나의 행 값이 들어가 있음
		int addResult = dao.insertCar(car);
		
		System.out.println(addResult + "개의 차량이 등록되었습니다.");
	}
	
	
	// [ (고유No을 통해) 차량 제거 ]
	public void removeCar() {
		System.out.println("========== 차량 삭제하기 ========== ");
		System.out.println(" 삭제할 차량 번호 >>> ");
		String num = sc.next();
		
		List<ContactDTO> carList = dao.selectCarsByname(num);
		System.out.println(" <<< 조회된 차량 목록 >>> ");
		for(ContactDTO car : carList) {
			System.out.println(car);
		}
		System.out.print(" 삭제할 고유No >>> ");
		int car_no = sc.nextInt();
		
		int removeResult = dao.deleteCar(car_no);
		System.out.println(removeResult + " 대의 차가 제거되었습니다.");
		
	}
	
	// [ (차량 고유No으로) 주차장 조회 ]
	@Override
	public void findAllCar() {
		System.out.println("======= 주차장 조회하기======");
		System.out.println("조회할 차량 고유 No >>> ");
		String num = sc.next();
		
		List<ContactDTO> carList = dao.selectCarsByname(num);
		for(ContactDTO car : carList) {
			System.out.println(car);
		}
		
	}
	
}