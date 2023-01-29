package PRACTICE;

public class Student2 {
	
	private String subject;
	private int number;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static void main(String[] args) {
		
		Student2 student1 = new Student2();
		
		student1.setSubject("국어국문학과");
		student1.setNumber(123456);
		
		System.out.println(student1.subject);
		System.out.println(student1.number);
		
	}

}
