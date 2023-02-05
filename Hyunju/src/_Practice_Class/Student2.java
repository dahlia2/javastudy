package _Practice_Class;

/*

문제-2. 위에서 구현한 Student 클래스를 다음을 만족하도록 기능을 추가하여 작성하시오.

·필드를 모두 private로 하고,getter와 setter를 구현하고
·Student 클래스의 main()메소드에서 Student 객체를 생성하여 setter를 사용하여 학과와 학번 필드에 적당한 값을 입력 후 출력

*/

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
