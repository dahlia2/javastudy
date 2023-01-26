package ex02_consturctor;

public class User {
	
	private String id;
	private String pw;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
}
