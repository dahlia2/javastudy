package Employee;

import java.util.Scanner;

public class Company {
	
	// 직원들 -> 배열
	// 인덱스 필드
	// 값 입력받을 스캐너
	
	/* ***************** 미완성
	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	// 회사에는 최대 5명의 사원을 구할 수 있다 -> 회사클래스의 길이는 5
	// 스캐너 값을 입력 받음
	public Company() {
	//	employees = new Employee[5];
		sc = new Scanner(System.in);   // 여기에 스캐너 들어가는 결정적인 개념..
	}
	
	// 사원을 고용하는 메소드
	public void addEmployee() {
//	if(idx == employees.length) { // 입력한 것이 5명을 초과하면
			System.out.println("더 이상 사원을 고용할 수 없습니다.");
			return;
		}
		// 초과하지 않는다면? 고용형태 정규or비정규 입력받기
		System.out.print("고용 형태 선택(1. 정규 2. 비정규) >>> ");
		String kind = sc.next();
		
		System.out.print("신규 사원번호 >>> ");
		int empNo = sc.nextInt();
		
		System.out.print("신규 사원명 >>> ");
		String name = sc.next();
		
		// 입력값이 정규와 비정규임에 따라 기본급, 시급 입력받음
		switch(kind) {
		
		case "1" :
		case "정규" :
			System.out.print("기본급 >>> ");
			int salary = sc.nextInt();
			
			// 사원번호, 이름, 기본급 값을 담긴 Regular(정규직) 객체(사원) 생성
			Regular regular = new Regular(empNo, name, salary);
			// 그 사원은 employees 의 idx번째 사원이 된다.
			employees[idx++] = regular;
			break;
			
		case "2":
		case "비정규":
			System.out.print("시급 >>> ");
			int hourPay = sc.nextInt();
		//	employees[idx++] = new Temporary(empNo, name, hourPay);
			break;
			
		default:
			System.out.println("잘못된 고용 형태입니다. 다시 시도하세요.");
	
		} // switch문 끝
		System.out.println("사원 등록 완료. 현재 등록된 사원" + idx + "명");
	}
	
	 
 */
	
}
