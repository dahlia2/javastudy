package practice10_Concert;

public class MainClass {

	public static void main(String[] args) {
		
		// *** 순서 ①
		// 콘서트홀 이름을 "장충체육관"로 지은 후, 콘서트홀 manage 메소드 호출로 버튼 실행
		new ConcertHall("장충체육관").manage();
		
		// ? 메인메소드에서 객체를 통해 호출하는 게 아닌, new을 붙여서 메소드 사용
	}

}
