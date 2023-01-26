package Practice_05_SmartPhone;

// 상속- 하나만 받을 수 있음. 구현- 여러 개 가능 (동시에 받아도 됨)
// 상속을 먼저 한 후 구현

// 전화와 컴퓨터 기능을 갖춘 스마트폰 
public class SmartPhone extends Phone implements Computer {

// 핸드폰 기능: 전화, 문자
// 컴퓨터 기능: 게임, 인터넷

// **생각필요** 부모인 핸드폰 클래스부터 만들기
// **생각필요** 구현하고 있는 컴퓨터 클래스 만들기
	
// **생각필요** 부모와 요소들이 갖고 있는 미완성 메소드 오버라이딩 (오버라이드와 헷갈 X)
	
	@Override
	public void call() {
		System.out.println("전화기능");
	}
	
	@Override
	public void sms() {
		System.out.println("문자기능");	
	}

	@Override
	public void game() {
		System.out.println("게임기능");
	}

	@Override
	public void internet() {
		System.out.println("인터넷기능");
	}
	
}
