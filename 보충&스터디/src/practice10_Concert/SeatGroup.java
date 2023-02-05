package practice10_Concert;

import java.util.Scanner;

public class SeatGroup {
	
	// 타입 "S", "R", "A" 중 하나를 가짐
	// 자리 배열 객체 클래스 갖고 있음
	// 사용자에게 입력 받을 기능
	
	private String seatType;
	private Seat[] seats;
	private Scanner sc;
	
	
	// 타입과 갯수에 따른 시트그룹 생성
	
	public SeatGroup(String seatType, int count) {	// **  new SeatGroup("S", 20)
		this.seatType = seatType;
		seats = new Seat[count];
		// ** (자리 갯수 = 데이터 담을 값인) Seat 클래스 생성 후 -> (리모컨 역할) seats 객체 선언
		
		for(int i = 0; i < count; i++) {
			seats[i] = new Seat();	// ** 빈 좌석 생성
		}
		sc = new Scanner(System.in);
	}

	
	// [예약 기능]
	// *상기* 좌석은 [S] 20개, [R] 30개, [A] 40개 (1부터 시작)
	// 해당 범위에 넘어선 값을 입력했다면 "없는 좌석입니다"라고 입력 거절
	// ? boolean 타입인 이유
	
	/*
	 예시))
	 =====reserveInfo 메소드로 이렇게 보여준 후
	 	[S]
		1   2   3   4   5   6   7   8   9   10  
		11  12  13  14  15  16  17  18  19  20  
	
		예약할 시트번호 >>> 13
		예약자 이름 >>> 이현주
	 */
	
	public boolean reserve() {
		reserveInfo();
		
		System.out.println("예약할 시트번호 >>> ");
		int seatNo = sc.nextInt();
		if(seatNo < 1 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			return false; 
		}
		// 예약된 시트인지 확인
		if(seats[seatNo - 1].isOccupied()) {	// ** Seat클래스에서 해당 값을 이미 가지고 있다면
			System.out.println(seatNo + "번 좌석은 이미 예약되었습니다.");
			return false;
		}
		// 예약 진행
		System.out.print("예약자 이름 >>> ");
		String name = sc.next();
		seats[seatNo - 1].setName(name);	// ** Seat클래스에서 (입력받은 번호로 만든) 해당 저장값에 이름 전달
		return true;
	}
	
	
	
	// [취소 기능]
	public boolean cancel() {
		reserveInfo();
		
		System.out.print("취소자 이름 >>> ");
		String name = sc.next();
		
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {  // 예약된 자리와 비교
				if(seats[i].isMatched(name)) { // 예약자 이름과 취소자 이름이 같으면 true 반환 
												// ㄴ ** Seat클래스에서 isMatched 메서드 생성
					seats[i].cancel();  // 예약자의 데이터를 삭제
					                       // ㄴ Seat클래스에서 cancel 메서드 생성
					System.out.println("예약자" + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		}  // for문 끝
		System.out.println(name + "으로 예약된 좌석이 없습니다.");  // ** for문을 돌려봐도 해당 값이 없음
		return false;
	}
	
	

	// [예약상황 출력 기능]
	
	/*
	 예시))  각 클래스 마다 보유 좌석을 나열
	 
	 	[S]
		1   2   3   4   5   6   7   8   9   10  
		11  12  13  14  15  16  17  18  19  20 
		
	 */
	
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		
		for(int i = 0; i < seats.length; i++) {
			
			if(seats[i].isOccupied()) {   // 자리 데이터가 존재하다면
				System.out.print(seats[i].getName().substring(0, 1) + "* ");
				// ** 그 자리의 이름을 프린트 해주고 -> Seat클래스에서 getName 메소드 생성
				// ** 가져온 이름 앞자리 2개만 보여주고 *표시 -> subString 이용
			} else
			{
				System.out.print((i + 1) + (i < 9 ? "   " : "  "));
				// ** i에서 1더하고, 공백 덧붙임(i가 9보다 작으면 2칸 & 9보다 크면 1칸)
				// ** ㄴ 인덱스 때문에 1을 더한 값을 넣어줌
				// ** ㄴ 10 밑이면 공백을 한칸 더 만들어줌
			}
			
			if((i + 1) % 10 == 0) {  // ** 해당 인덱스의 값이 10 배수라면 줄 변환
				System.out.println();
			}
		}  // for문 끝
		System.out.println();
	}

}
