package ex10_static;

public class MainClass {

	public static void main(String[] args) {
		
		// static 요소는 객체를 이용해서 호출할 수 있으나, 권장하지 않는다.
		MyMath myMath = new MyMath();
		System.out.println(MyMath.PI);

		MyMath yourMath = new MyMath();
		System.out.println(MyMath.PI);
		
		/* static 메소드이므로 Mymath 클래스의 하나만 저장할 수 있음.
		     = myMath와 yourMate 객체의 pi의 참조값이 같음.
		   
		   그래서 myMath.PI yourMath.PI 객체들로 비교하지 말고(실행은 되지만 권장 x),
		   묶어서 MyMath.PI 클래스로 비교하면 된다.
		     = static 요소는 클래스를 이용해서 호출하는 것이 권장 */
		System.out.println(MyMath.PI);
		System.out.println(yourMath.PI);
		
		System.out.println(myMath.getCircleArea(1.5));
		
		
		// 최대값 출력
		System.out.println(MyMath.max(1.1, 2.2, 3.3));
		System.out.println(MyMath.max(1.1, 2.2, 3.3, 4.4));
		System.out.println(MyMath.max(1.1, 2.2, 3.3, 4.4, 5.5));

		// 최소값 출력
		System.out.println(MyMath.min(5.5, 4.4, 3.3));
		System.out.println(MyMath.min(5.5, 4.4, 3.3, 2.2));
		System.out.println(MyMath.min(5.5, 4.4, 3.3, 2.2, 1.1));
		
	}

}
