package practice10_Walkable;

public class Person {

	// 먹이주는 메소드 (pet과 음식)
	// 펫 name에게 food 주기
	public void foodFeed(Pet pet, String food) {
		System.out.println(pet.getPetName() + "에게" + food + "주기");
		
	}
	
	// 산책하는 메소드
	// public void walk(Pet pet)이 아님을 주의!

	public void walk(Walkable pet) {
	// Walkable은 인터페이스 클래스 -> Pet 클래스의 객체가 되기 위해(getPetName 메소드 활용을 위해) 강제 변환
 		System.out.println(((Pet)pet).getPetName() + "와 산책");
		
	}

}
