package practice10_Walkable;

// 애완동물이다 -> 부모클래스는 Pet
// 산책할 수 있다 -> implements는 Walkable 클래스

public class Dog extends Pet implements Walkable{

	public Dog(String petname) {
		super(petName);
	}

}
