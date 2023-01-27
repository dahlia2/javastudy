package Practice_05_SmartPhone;


public class MainClass {

	public static void main(String[] args) {
		
		/* **생각필요**
			1. 먼저 가장 기본인 Phone 클래스의 객체 만들기
			2. 자식 클래스의 구성인 Computer은 보이지 않으므로 캐스팅 필요 */
		
		Phone phone = new SmartPhone();
		phone.call();
		phone.sms();
		
		((Computer) phone).game();
		((Computer) phone).internet();

	}

}
