package Practice_05;

public class Food {
	
	private String foodName;
	private int foodCalorie;
	
	public Food(String foodName, int foodCalorie) {
		super();
		this.foodName = foodName;
		this.foodCalorie = foodCalorie;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodCalorie() {
		return foodCalorie;
	}

	public void setFoodCalorie(int foodCalorie) {
		this.foodCalorie = foodCalorie;
	}
	
	public void eat() {
		System.out.println(foodName + " " + foodCalorie + "를 먹습니다.");
	}
	
	}
