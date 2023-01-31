package b;

import javax.swing.JOptionPane;

// 2번째 클래스 생성 좌석들을 묶어서 SeatGroup 클래스를 만든다.
// 좌석의 타입마다 좌석이 다른 것이 특징

public class SeatGroup {

	private String seatType; // "S", "B", "A" 석이 있음
	private Seat[] seats; // 배열의 선언

	// new SeatGroup("S", 10) : "S"석이 10개 있다. -> 를 만들어주기 위해 생성자 생성!
	public SeatGroup(String seatType, int length) {
		this.seatType = seatType;
		seats = new Seat[length]; //배열의 생성 // 입력된 값이 Seat의 10좌석을 만들어줌
		for (int i = 0; i < length; i++) {
			seats[i] = new Seat(); // 좌석이 있다면 길이가 있다는 것이고 그만큼 각각의 seats 배열의 Seat 생성자를 만드는 것임.
		}
		// 사람이 예약을 하면 예약을 했을 때! 자리를 만드는 형식으로 시작해서 생성자를 만들 수 있음
		// ㄴ 어떠한 기준이든 그에 따라서 new Seat! => 자리를 만드는 기준으로 생각하면 됨
	}

	// 빈은 저장된 걸 보내주고 값을 내놓을 수 있지만 SeatGroup은 클래스 그 자체라서 이렇게 생성자 만드는 것임
	// practice04 bus 클래스 보고 다시 한 번 공부!
	
	
	
		public void info() {
			System.out.println("[" + seatType + "] 타입");
			for (int i = 0; i < seats.length; i++) {

				System.out.print(i < 10 ? "0" : " " + seats[i + 1]); // 공백 6칸을(이름 3글자를 위해. 한글 1글자는 공백2칸) 출력한다

				/* 인덱스의 일의 자리가 9이면 줄을 바꾸고 아니면 공백을 준다. => 1 ~ 10 좌석 표시후 다음칸 나열
				                                                              => 11 ~ 20 좌석 표시후 다음칸 나열 */
				if (i % 10 == 9) {
					System.out.println();
				} else {
					System.out.print("");
				}
			}
		}
			
		public boolean reserve() {

			info(); // 예매 상황 보여주기

			// [JOptionPane 클래스] 대화상자 안에 내용이 창으로 따로 떠서 나옴. C언어라서 중요하지 X
			String strNo = JOptionPane.showInputDialog("예약할 시트번호를 입력하세요.");

			int seatNo = Integer.parseInt(strNo);

			if (seatNo < 0 | seatNo > seats.length) {
				System.out.println(seatNo + "번 좌석은 없는 좌석입니다");
				return false; // 예약하기 실패
			}
			if (seats[seatNo - 1].isOccupied()) {
				System.out.println(seatNo + "번 좌석은 이미 예약된 자석입니다.");
				return false; // 예약하기 실패
			}
			String name = JOptionPane.showInputDialog("예약자 성함을 입력하세요.");
			seats[seatNo - 1].reserve(name);
			return true;
			
		}
		
		// 예약 취소하기
		public boolean cancel() {

		info();
		String name = JOptionPane.showInputDialog("취소자 성함을 입력하세요.");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied() && seats[i].isMatched(name)) {
				// 해당 자리에 점유되어있는지, 입력받은 이름이 점유되어있는 이름과 일치한지 모두 true이면 실행
				     // 중복되어있는 이름이 없다고 가정
				seats[i].reserve(null);
				JOptionPane.showMessageDialog(null, "예약자 " + name + "의 예약이 취소되었습니다.");
			}
		} // for문 끝
		JOptionPane.showMessageDialog(null, "입력된 이름" + name + "은 존재하지 않습니다.");
		return false;
		}

}