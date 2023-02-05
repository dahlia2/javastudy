package practice10_Concert;

public class Seat {
	
	// 예약자 이름
	private String name;
	
	
	// 예약자 이름값 전달
	public String getName() {
		return name;
	}

	// 입력받은 예약자 이름 저장
	public void setName(String name) {
		this.name = name;
	}

	// 예약된 자리 있는가
	public boolean isOccupied() {
		return name != null;    // 이름 데이터가 없는 게 아니라면 true 반환 => 예약되어 있다면 true 반환
	}
	
	// 예약자 일치한지 확인
	public boolean isMatched(String name2) {
		return name2.equals(this.name);
	}
	
	// 예약 취소
	public void cancel() {
		name = null; // ** 초기화 처리
	}

}
