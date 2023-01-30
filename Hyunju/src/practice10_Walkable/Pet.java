package practice10_Walkable;

public class Pet {
	
	private String petName;
	
	public Pet(String petName) {
		super(); // 생략 가능
		this.petName = petName;
	}

	// 겟셋 메소드
	public String getPetName() {
		return petName;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}

}
