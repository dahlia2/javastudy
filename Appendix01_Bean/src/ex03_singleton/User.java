package ex03_singleton;

public class User {
	
	// Singleton : 객체를 하나만 만들 수 있음
	// static 필드 (미리 User를 만들어 준다.)
	static User user = new User();
	
	// private 생성자 (외부에서는 생성자를 호출할 수 없다)
	private User() {
		
	}
	
	// static 메소드 (static 필드를 사용하기 위해서)
	// user 필드를 외부에서 사용할 수 있도록 반환하는 일종의 Getter
	public static User getInstance() {
		return user;
	}
	
}