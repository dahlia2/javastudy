package practice10_Walkable;

public class MainClass {

	public static void main(String[] args) {
		
	// [생성]
		// 강아지 백구
		// 고양이 냥냥이
		// 뱀 냄름이
		// 사람
		
		Dog dog = new Dog("백구");
		Cat cat = new Cat("냥냥이");
		Snake snake = new Snake("냄름이");
		Person person = new Person();
		
		
	// 사람이 백구에게 개껌주기
	// 사람이 냥냥이에게 츄르주기
	// 사람이 낼름이에게 쥐주기
		
		person.foodFeed(dog, "개껌");
		person.foodFeed(cat, "츄르");
		person.foodFeed(snake, "쥐");
		
		
	// 사람이 백구와 산책하기
	// 사람이 냥냥이와 산책하기
	// 사람이 낼름이와 산책 -> 불가능!
		
		person.walk(dog);
		person.walk(cat);
	 //	person.walk(snake);  -> 불가능!
		
	}

}
