package Practice_05;

public class MainClass {

	public static void main(String[] args) {
		Person p = new Person("제시카");
		
		p.setCalorie(300);
		p.info();
		
		p.eat(new Apple("청송사과", 200));
		p.info();

	}

}
