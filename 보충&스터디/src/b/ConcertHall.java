package b;

import javax.swing.JOptionPane;

public class ConcertHall {
	
	private SeatGroup[] seatGroups;
	
	private String[] seatTypes = {"S", "R", "A"};
	private int[] seatCount = {30, 40, 50};
	// ㄴ Map 있다면 굳이 필요하지 않음 고로 배열 2개가 필요함
	

	// new ConcertHall() 호출시 만들어지는 것
	public ConcertHall() {
		seatGroups = new SeatGroup[seatTypes.length]; // 시트의 타입이나 카운트의 갯수만큼 그룹을 만든다.  // 배열의 생성
		                  // 현재 seatGroups은 null -> 배열은 만든다고 채워지지 않음 그냥 선언만 할 뿐 (틀만 잡는 개념)
		
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i] = new SeatGroup(seatTypes[i], seatCount[i]);
			
		}
	}

	
	// 예약 확인하기
	public void info() {
		for (int i = 0; i < seatGroups.length; i++) {
			seatGroups[i].info(); // 좌석 등급마다 정보를 보여달라
			System.out.println("-----------------------------------");
		}
	}
	
	
	// 예약하기
	public void reserve() {
		String seatType = JOptionPane.showInputDialog("좌석 타입을 입력하세요.");

		for (int i = 0; i < seatTypes.length; i++) {
			if (seatType.equals(seatTypes[i])) { // 단순히 알파벳 글자값만 비교
				seatGroups[i].reserve(); // 입력할 시트타입이 같다면 예약할 수 있는 메소드 호출
				return; // 예약 종료
			}
		}
		JOptionPane.showMessageDialog(null, "입력한 " + seatType + "타입은 존재하지 않습니다.");
	}
	
	
	// 예약취소
	public void cancel() {

		String seatType = JOptionPane.showInputDialog("좌석 타입을 입력하세요.");

		for (int i = 0; i < seatTypes.length; i++) {
			if (seatType.equals(seatTypes[i])) { // 단순히 알파벳 글자값만 비교
				seatGroups[i].cancel(); // 입력할 시트타입이 같다면 예약할 수 있는 메소드 호출
				return; // 예약 종료
			}
		}
		JOptionPane.showMessageDialog(null, "입력한 " + seatType + "타입은 존재하지 않습니다.");

	}
}

		  
		  /*
	  	switch (seatType) {
			case "S" : seatGroups[0].reserve(); break; 
			case "R" : seatGroups[1].reserve(); break; 
			case "A" : seatGroups[2].reserve(); break; 
			default:
				break;
		} */
		  
		  // 좌석 타입에서 인덱스를 통해 reserve 메소드를 호출하면 된다
	