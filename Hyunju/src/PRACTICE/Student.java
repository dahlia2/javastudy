package PRACTICE;

public class Student {
	
	private String subject;
	private int number;
	
	Student(String subject, int number) {
		this.subject = subject;
		this.number = number;
	}

	public static void main(String[] args) {
		
		Student student1 = new Student("국어국문학과", 123456);
		
		System.out.println(student1.subject);
		System.out.println(student1.number);
		
	}

}
