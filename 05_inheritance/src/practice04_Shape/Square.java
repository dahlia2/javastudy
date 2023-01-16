package practice04_Shape;

public class Square extends Rectangle{
	
	// 필드 필요 없음 (Rectangle이 갖고 있음)
	
	// 생성자 (필드 없을 때 생성자 만들기  Source >> Generate Superclass 사용)
	
	public Square(double width) {
		super(width, width);
	}
	
}
