package Practice_Class;

import java.util.Scanner;

public class Student3 {
	
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
		
		Scanner sc = new Scanner(System.in);
		Student3 student = new Student3();
		
		System.out.println("===회원가입===");
		System.out.print("학과명을 입력하세요 >>> ");
		student.setSubject(sc.next());
		System.out.print("학번을 입력하세요 >>> ");
		student.setNumber(sc.nextInt());
		
		System.out.println("학생 1의 학과명: " + student.getSubject() + ", 학번: " + student.getNumber());
		
	}

}
