package ex06_object;

public class MainClass {
	
	/*
		 java.lang.Object 클래스
		 1. 모든 클래스의 최상위 슈퍼 클래스이다.
		 2. 별도의 슈퍼 클래스를 명시하지 않는 경우 Object 클래스가 슈퍼 클래스이다.
		 3. >>>모든 것을 저장<<<할 수 있는 만능 타입.
		 4. Object 타입으로 저장된 객체는 Object 클래스의 메소드만 호출할 수 있으므로
		    >>>꺼낼 때는 다시 원래 객체 타입<<<으로 캐스팅해서 사용해야 한다.
	 */
	
	/* 
		  Object 클래스의 주요 메소드
		  1. equals
			  1) 동등 비교할 때 사용하는 메소드
			  2) 동등 비교하는 객체들의 참조값을 비교함 (객체의 값. 내용물을 비교하지 못한다는 말)
			  3) 객체 값으로 동등 비교하기 위해서는 equals 메소드를 "오버라이드"해야 함
		  2. toString : 문자열로 변환할 때 사용하는 메소드
			  1) 문자열로 반환할 때 사용하는 메소드
			  2) "객체이름 + @ + 참조값" 형식으로 변환함
			  3) 원하는 형식으로 변경하려면 toString 메소드를 "오버라이드"해야 함.
			
	 */

	public static void ex01() {
		Object person = new Person();
		
		if(person instanceof Person) {   // 저장만 하는 경우 캐스팅 필수 x
			((Person) person).eat();     //Object 객체는 사용하기 위해서 항상 캐스팅해야 한다.
			((Person) person).sleep();
		}
	}
	
	public static void ex02() {
		// name이 같으면 같은 Person으로 처리하기로 한 시스템
		Person person1 = new Person("홍길동");
		Person person2 = new Person("홍길동");
		
		if(person1.equals(person2)) { // person1가 호출 person2 매개변수
			System.out.println("같은 Person이다.");
		} else {
			System.out.println("다른 Person이다.");
		}
	}
	
	public static void ex03() {
		
		Person person = new Person("홍길동");
		
		System.out.println(person);
		System.out.println(person.toString());  // toString 메소드는 호출을 생략함 (system out으로 호출할 때 자동으로 반영)
	}

	 
	public static void main(String[] args) {
		ex03();
	}

}
