package ex09_access_modifier;

public class MainClass {

	public static void main(String[] args) {
		
		// User 객체 생성하기
		User user = new User();
		
		// user 객체에 id와 pw 전달하기
		user.setId("admin");
		user.setPw("123456");
		
		// user 객체의 id와 pw 확인하기
		System.out.println(user.getId());
		System.out.println(user.getPw());
		
	}

}