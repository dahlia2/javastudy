package service2;

import java.util.List;
import java.util.Scanner;

import dao2.ContactDAO2;
import dto2.ContactDTO2;

//사용자에게 보여주고 입력 받을 값

public class ContactServiceimpl2 implements ContactService2 {
	
	// 필드
	private Scanner sc;
	private ContactDAO2 dao;  // DAO에서 static에 프라이빗 처리하지 않았나..?
	
	// 생성자
	public ContactServiceimpl2() {
		sc = new Scanner(System.in);
		dao = ContactDAO2.getInstance();
	}
	

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

// - - - - - 메소드 - - - - - - - - - - - - - - - - - - - - -
	
	
	// [ 개인정보 추가 메소드 ]
	@Override
	public void addContact() {
		System.out.println("======== 개인정보 추가하기 ========");
		
		System.out.print("신규 개인정보 입력 [이름] >>> ");
		String name = sc.next();
		
		System.out.print("신규 개인정보 입력 [번호] >>> ");
		String tel = sc.next();
		
		System.out.print("신규 개인정보 입력 [이메일] >>> ");
		String email = sc.next();
		
		System.out.print("신규 개인정보 입력 [주소] >>> ");
		String address = sc.next();
		
		// 받은 값을 하나로 모음
		ContactDTO2 contact = new ContactDTO2();
		contact.setName(name);
		contact.setTel(tel);
		contact.setEmail(email);
		contact.setAddress(address);
		
		// 하나의 행씩 받아옴
		int addResult = dao.insertContact(contact);
		
		System.out.println(addResult + " 개의 연락처가 등록되었습니다.");
		
	}

	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	
	// [ (이름을 통해) 개인정보 삭제 ]
	@Override
	public void removeContact() {
		System.out.println("====== 개인정보 삭제하기 ======");
		System.out.print("삭제할 개인정보 이름 >>> ");
		String name = sc.next();
		
		List<ContactDTO2> contactList = dao.selectContactsByName(name);
		System.out.println("<<< 조회된 연락처 목록 >>>");
		for(ContactDTO2 contact : contactList) {
			System.out.println(contact);
		}
		System.out.print("삭제할 연락처 No >>> ");
		int contact_no = sc.nextInt();
		
		int removeResult = dao.deleteContact(contact_no);
		System.out.println(removeResult + " 개의 연락처가 삭제되었습니다.");
		
	}

	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		
	// [ (이름을 통해) 조회한 후, 개인정보 수정 ]
	@Override
	public void modifyContact() {
		System.out.println(" ===== 개인정보 수정하기 ===== ");
		System.out.print("수정할 연락처 이름 >>> ");
		String name = sc.next();
		
		List<ContactDTO2> contactList = dao.selectContactsByName(name);
		System.out.println("<<< 조회된 개인정보 목록 >>>");
		for(ContactDTO2 contact : contactList) {
			System.out.println(contact);
		}  // ContactDTO [contact_no=1, name=이현주, tel=010-2075-2105, email=15_9@naver.com, address=경기] 라고 뜸
		
		System.out.print("수정할 개인정보 No >>> ");
		int contact_no = sc.nextInt(); // 입력받은 번호를 저장
		ContactDTO2 contact = dao.s;   // 입력받은 번호를 매개변수로 전달위해 저장 (수정 전 내용)
		
		System.out.println("수정할 항목 선택(1. 이름 2. 전화 3. 이메일 4. 주소) >>> ");
		String choice = sc.next();
		
		switch (choice) {
		case "1":
			System.out.println("수정할 이름 입력 >>> ");
			contact.setName(sc.next()); // 입력받은 이름을 DTO에 셋팅
			break;
		case "2" :
			System.out.println("수정할 전화 입력 >>> ");
			contact.setTel(sc.next());
			break;
		case "3" :
			System.out.println("수정할 이메일 입력 >>> ");
			contact.setEmail(sc.next());
			break;
		case "4" :
			System.out.println("수정할 주소 입력 >>> ");
			contact.setAddress(sc.next());
			break;
		default :
			System.out.println("잘못된 입력입니다. 수정을 취소합니다.");
			return;
	}
		
		int modifyResult = dao.updateContact(contact);  // 1행이 수정된 것 -> int 1
		System.out.println(modifyResult + "개의 연락처가 수정되었습니다.");
	}

	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		
	@Override
	public void findContactsByName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAllContacts() {
		// TODO Auto-generated method stub

	}

}
