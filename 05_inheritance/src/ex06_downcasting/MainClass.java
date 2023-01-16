package ex06_downcasting;

public class MainClass {
	
	public static void ex01() {
		
		// 업캐팅 upcasting
		Person person = new Student();  // 부모 클래스(타입)의 객체를 자식 클래스에
		
		// 다운캐스팅 downcasting	 
		Student student = (Student)person;
		
		student.eat();
		student.sleep();
		student.study();
		
	}
	
	public static void ex02() {
		
		// Person
		Person person = new Person();
		
		// 잘못된 캐스팅
		Student student = (Student)person;
		
		// 잘못된 캐스팅
		student.eat();
		student.sleep();
		student.study();   // 오류 발생 부분
		
	}
	
	public static void ex03() {
		
		// Person
		Person person = new Person();
		
		// Student 객체(인스턴스, instance)가 맞다면 Student 타입으로 캐스팅하자.
		if(person instanceof Student) {   // person이 Student의 객체라면
			Student student = (Student)person;
			student.eat();
			student.sleep();
			student.study();
		 // 만족하지 않으니까 오류나지 않음
			
		person.eat();     // 얘와  1
		person.sleep();   // 얘랑  1
		((Student)person).study();   //   얘와  2  다른 저장소 
		
		// if문 안에 들어왔으니까 instanceof을 사용하여 person 객체가 Student의 study 메소드를 사용할 수 있음
		((Student) person).study(); // person.study 치면 자동으로 다운캐스팅 해줌
		
		}
		
	}
	
	public static void main(String[] args) {
		ex03();
	}
	
}
