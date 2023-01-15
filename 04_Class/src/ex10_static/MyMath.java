package ex10_static;

public class MyMath {
	
	/*
	 	static
	 	1. 정적 요소
	 	2. 객체 생성 이전에 클래스 영역에 만들어지는 요소 = 객체 생성 이전에 미리 만들어지는 요소
 	 	3. 객체마다 생성되지 않고 클래스별로 1개씩만 생성됨
 	 	4. 클래스를 이용해서 호출하기 때문에 클래스 변수(=필드), 클래스 메소드라고 부름
 	 	5. static 요소는 다른 static 요소만을 참조할 수 있음 => non-static 요소는(후에 만들어지는 요소는) 참조할 수 없음
	*/
	
	// 필드
	public static final double PI = 3.141592;       // final 처리된 것은 누구든지 써야하므로 public 처리
	
	// 메소드
	public double getCircleArea(double radius) {    // border - radius: 반지름
		return PI * radius * radius; 
	}
	
	
	public static double max(double... numbers) {   // 메소드 또한 공유하기 위해 static 처리
		double max = Double.MIN_VALUE; // Double 클래스.MIN_VALUE 스태틱 파이널
		for(int i = 0; i < numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
		} return max;
	}
		
		public static double min(double... numbers) {    // 메소드 또한 공유하기 위해 static 처리
			double min = Double.MAX_VALUE; //Double 클래스.MIN_VALUE 스태틱 파이널
			for(int i = 0; i < numbers.length; i++) {
				if(min > numbers[i]) {
					min = numbers[i];
				} 
			} return min;
		}
		
}
