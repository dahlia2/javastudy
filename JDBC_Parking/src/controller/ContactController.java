package controller;

import java.util.Scanner;

import service.ContactService;
import service.ContactServiceimpl;

public class ContactController {
	
	// 필드
	private Scanner sc;
	private ContactService service;
	
	
	// 생성자
	public ContactController() {
		sc = new Scanner(System.in);
		service = new ContactServiceimpl();
	}

	
	// 메소드
	public void play() {
		
		while(true) {
			
			System.out.println("[ Welcome to 대박 주차장 ]");
			System.out.print("①추가 ②삭제 ③전체조회 ④종료 >>> ");
			String choice = sc.next();
			
			switch (choice) {
			case "1":
				service.addCar();
				break;
			case "2":
				service.removeCar();
				break;
			case "3":
				service.findAllCar();
				break;
			case "4":
				System.out.println("연락처 관리 프로그램이 종료되었습니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}
}
