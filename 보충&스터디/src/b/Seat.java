package b;

// 가장 작은 단위부터 시작
public class Seat {
	
	// 사람의 이름 
	private String name;  // 필드가 private이라 정보은닉으로 getter setter가 필요하다
	
	public Seat() {} // new Seat() 기본 생성자. 지정된 사람이 없을 때 부르는 생성자  -> setName("홍길동")
	
	public Seat(String name) { // new Seat("홍길동") 좌석 사람이 지정돼있으면 부르는 생성자
		this.name = name;
	}

	public String getName() { // name 확인용 메소드 (예약자 확인용)
		return name;
	}

	public void setName(String name) { // 실제 name 저장용 메소드 (예약 처리용)
		this.name = name;
	}
	
	public void reserve(String name) { // 예약 처리할 때 보여줄 메소드  // 1) reserve("홍길동") 처럼 예약 메소드 이름 통일을 위해서 추가사용  2) set을 살리기 위해서
		reserve(name);
	}
	
	public void cancel() {  // 취소할 때도 setName을 호출하는 걸 -> cancel 메소드를 호출해서 처리할 수 있게 추가생성
		name = null;
	}
	
	public boolean isOccupied() {  // 좌석이 점유되었으며 true 반환
		
		// name 값이 있으면(null이 아니라면) 점유되었다는 걸 알 수 있으니까
		return name != null;   // 이름이 null  아닌게 트루다 -> 좌석이 있다!
		} // 만약 배열이 있는데 값이 없으면 nullpointException 경고층이 뜬다. false가 아님 (더 공부)
	
	public boolean isMatched(String name) {
		// 좌석의 name(필드, this.name) 과 매개변수 String name이 동일하면 true를 반환 // 이름을 받아와서 예약된 이름과 같은지 글자열로 비교
		
		if(this.name.equals(name)) {
			return true;
		} else {
			return false;
		}
		
		/* 추천코드
		 return this.equals(name);   // 좌석 이름과 가져온 이름이 같으면 true를 반환해라
		*/
		
	}

}
