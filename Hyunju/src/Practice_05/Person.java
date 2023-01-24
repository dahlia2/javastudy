package Practice_05;

public class Person {
	
	private int calorie;
	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void eat(Eatable e) {
		((Food)e).eat();
		setCalorie(this.calorie + ((Food)e).getFoodCalorie());
	}
	
	public void info() {
		System.out.println(name + "는 현재" + calorie + "kcal 입니다.");
	}
	
	

}
