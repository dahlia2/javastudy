package controller2;

import java.util.Scanner;

import service2.ContactService2;
import service2.ContactServiceimpl2;

public class ContactController2 {
	
	// 필드
	private Scanner sc;
	private ContactService2 service;
	
	
	// 생성자
	public ContactController2() {
		sc = new Scanner(System.in);
		service = new ContactServiceimpl2();
	}
	
	
	// 메소드
	public void play() {
		
		while (true) {
		
			System.out.print("①추가 ②삭제 ③수정 ④개별조회 ⑤전체조회 ⑥종료  >>> ");
			String choice = sc.next();
			
			switch (choice) {
			
			case "1" :
				service.addContact();
				break;
			case "2" :
				service.removeContact();
				break;
			case "3" :
				service.modifyContact();
				break;
			case "4" :
				service.findContactsByName();
			case "5" :
				service.findAllContacts();
			case "6" :
				System.out.println("연락처 관리 프로그램이 종료되었습니다.");
				return; // while문 처음으로 돌아감
			default :
			System.out.println("잘못된 입력입니다. 다시 시도하세요.");
			
			}
			
		}
		
	}
	
}
