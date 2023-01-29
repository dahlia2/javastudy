package practice10_Concert;

import java.util.Arrays;
import java.util.Scanner;

public class ConcertHall {
	
	// 콘서트 홀의 이름
	// 좌석 '묶음들'  ->  등급에 따른 좌석 수
	// 자리 등급은 S, R, A
	// 등급마다 좌석 수는 20개, 30개, 40개
	// 사용자에게 입력 받을 기능 (받을 값) 필요
	private String hallName;
	private SeatGroup[] seatGroups;
	private String[] seatTypes = {"S", "R", "A"};  // 한 글잔데 char 타입도 가능?
	private int[] seatCount = {20, 30, 40};
	private Scanner sc;
	
	
	// <<메인에서 받은 hallName(장충체육관의) 전체적인 틀 생성>>
	//  ㄴ 타입에 따른 좌석 갯수로 => 자리를 만듦 => SeatGroup을 생성
	public ConcertHall(String hallName) {
		this.hallName = hallName;
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i] = new SeatGroup(seatTypes[i], seatCount[i]);
		}
		sc = new Scanner(System.in);
	}
	
	
	// 순서 2-2
	// [예약] 사용자에게 예약할 좌석 타입을 받음
	// 없는 타입을 입력할 시 사용자에게 알림
	// *** 입력값을 '받기만 함' -> 반환값이 없으니까 void
	
	// 받은 타입에 따른 좌석 수들을 나열해 보여주고, (예약할 시트번호 & 예약자 이름) 값을 받음
	// *** ㄴ시트그룹 클래스에서 생성
	// *** ㄴ for문 사용
		/***  ㄴ
				S 입력 -> seatGroups[0].reserve()
				R 입력 -> seatGroups[1].reserve()
				A 입력 -> seatGroups[2].reserve()
		*/
	
	/*
	예시))
		
		 예약할 좌석 타입 입력[S, R, A] >>> S
			[S]
			1   2   3   4   5   6   7   8   9   10  
			11  12  13  14  15  16  17  18  19  20  
	
		예약할 시트번호 >>> 13
		예약자 이름 >>> 이현주
		13번 좌석 예약이 완료되었습니다.
	 */
	
	public void reserve() {
		System.out.print("예약할 좌석 타입 입력" + Arrays.toString(seatTypes) + " >>> ");  // *** [S, R, A] 나열값을 스트링으로 나타내기 위해 Arrays 활용
		String scseatType = sc.next();
		
		for(int i = 0; i < seatTypes.length; i++) {
			if(scseatType.equals(seatTypes[i])) {
				seatGroups[i].reserve();
				return;
			}
		}
	System.out.println(scseatType + "타입은 없는 타입입니다.");   // *** for문 다 돌려도 seatTypes에 있는 글자와 일치하는 게 없을 때
	}

	
	// [취소] 사용자에게 취소할 좌석 타입을 받음
	// 없는 타입을 입력할 시 시트그룹의 취소 메소드 호출 후 사용자에게 알림
	
	/*
	 예시))
	 
		 취소할 좌석 타입 입력[S, R, A] >>> A
			[A]
			1   2   3   4   5   6   7   8   9   10  
			11  12  13  14  15  16  17  18  19  20  
			21  22  23  24  25  26  27  28  29  30  
			31  32  33  34  이* 36  37  38  39  40  
		
			취소자 이름 >>> 이현주
			예약자 이현주의 예약이 취소되었습니다.
	*/
	
	private void cancel() {
		System.out.print("취소할 좌석 타입 입력" + " >>> ");
		String scseatType = sc.next();
		
		for(int i = 0; i < seatTypes.length; i++) {   // seatTypes
			if(scseatType.equals(seatTypes[i])) {
				seatGroups[i].cancel();
				return;	
			}
		}
	 System.out.println(scseatType + "타입은 없는 타입입니다.");
	}
	
	
	// [전체 예약 확인]
	// *** 좌석 묶음을 가진 클래스에서 예약 정보를 호출
	
	/*
	예시))
	
		[장충체육관]
		[S]
		1   2   3   4   5   6   7   8   9   10  
		11  12  13  14  15  16  17  18  19  20  
		
		[R]
		1   2   3   4   5   6   7   8   9   10  
		11  12  13  14  15  16  17  18  19  20  
		21  22  23  24  25  26  27  28  29  30  
		
		[A]
		1   2   3   4   5   6   7   8   9   10  
		11  12  13  14  15  16  17  18  19  20  
		21  22  23  24  25  26  27  28  29  30  
		31  32  33  34  이* 36  37  38  39  40  
	*/
	
	private void hallInfo() {
		System.out.println("[" + hallName + "]");
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i].reserveInfo();
		}
		System.out.println();
	}

	
	// 순서 2-1
	// [실행] 예약, 취소, 예약현황, 종료를 사용자에게 선택할 수 있게 보여줌
	public void manage() {
		while(true) {
			System.out.print("1. 예약 2. 취소 3. 예약현황 0. 종료 >>> ");
			String choice = sc.next();
			
			switch(choice) {
			case "1" : reserve(); break;
			case "2" : cancel(); break;
			case "3" : hallInfo(); break;
			case "0" : return;
			default : System.out.println("Bad Request");
			}
		}
	}
	
}
	