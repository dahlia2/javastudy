package ex05_wrapper;

public class MainClass {
	
	/*
		 wrapper Class
		1. 기본 자료형(Primitive Type)을 참조 자료형(Reference Type)으로 만들어 놓은 클래스이다.
		
		2. 종류
		 byte     →   Byte
		 int      →   Integer
		 long     →   Long
		 double   →   Double
		 boolean  →   Boolean
		 char     →   Character
		 
		3. 용어 정리
		 	1) Auto Boxing :  기본 자료형 -> 참조 자료형
		 	    예: int i = 10;
		 			Interger a = 10; 클래스 타입으로 저장 (참조 자료형)
		 	2) Auto UnBoxing : 참조 자료형 -> 기본 자료형
				예: Interger a = 
				 	int i = 10;
		4. 반드시 참조 자료형을 요구하는 제네릭에서(generic)에서 주로 사용한다.
	 */

	public static void main(String[] args) {
		
		Integer a = 10; //Auto Boxing
		Integer b = 10; //Auto Boxing
		
		int sum = a + b;  //Auto Boxing
		System.out.println(sum);
		

	}

}
