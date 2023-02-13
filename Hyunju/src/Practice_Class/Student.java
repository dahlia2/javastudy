package Practice_Class;

/* 
 
 문제 1 - 다음을 만족하는 Student 클래스를 작성하시오.

· String형의 학과와 정수형의 학번을 필드로 선언
· Student 클래스의 main() 메소드에서 Student 객체를 생성하여 학과와 학번 필드에 적당한 값을 입력 후 출력

*/

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
