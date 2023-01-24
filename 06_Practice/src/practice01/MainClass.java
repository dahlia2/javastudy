package practice01;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class MainClass {

	// 문제1. 가위바위보
	// 실행
	// 가위바위보 >>> 가위
	// 당신은 가위, 컴퓨터는 보, 이겼습니다.
	// Hint : 가위는 0, 바위는 1, 보는 2로 처리한다.
	public static void ex01() {
		
		int user = 0;
		int computer = (int) (Math.random() * 3);
		
		String[] choice = {"가위", "바위", "보"};
	
		System.out.print("가위바위보 >>> ");
		Scanner sc = new Scanner(System.in);
		
		switch (sc.next()) {
		case "가위" :
			user = 0;
			break;
		case "바위" :
			user = 1;
			break;
		default :
			user = 2;
		}
		
		String result = null;
		
		switch(user-computer) {
		case -2 :
		case 1 : result = "이겼습니다."; break;
		case 0 : result = "비겼습니다."; break;
		default : result = "졌습니다."; break;
		}
		
		System.out.println("당신은" + sc.next() + "컴퓨터는" + choice[computer] + result);
		
	}
	
	// 문제2. 친구 3명을 저장할 수 있는 배열을 생성하고 임의의 값으로 초기화하시오.
	// 새로 사귄 친구의 수를 입력 받아서 기존 친구들이 저장된 배열의 길이를 새로 사귄 친구의 수만큼 늘리시오.
	public static void ex02() {
		
		String[] friends = {"서희", "정인", "유림"};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("새로 사귄 친구는 몇 명인가요? ");
		int count = sc.nextInt();
		
		String[] total = new String[friends.length + count];
		
		for(int i = 0; i < friends.length; i++) {
			total[i] = friends[i];
		}
		
		friends = total;
		
		System.out.println(friends.length);
		
		sc.close();
			
		}
	
	// 문제3. Scanner 클래스의 next() 메소드를 이용해서 사용자로부터 문자열을 계속 입력 받는다.
	// 사용자가 "종료" 문자열을 입력하면 더 이상 입력 받지 않는다.
	// 총 몇 번만에 종료되었는지 그 횟수를 마지막에 출력한다.
	public static void ex03() {
		
		String user = null;
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		while( ! user.equals("종료")) { 
			System.out.print("문자열을 입력하세요 >>>");
			user = sc.next();
			count++;
		} 
		System.out.println("입력한 횟수는 " + count + "번 입니다.");
		sc.close();
		
	}

	// 문제4. 퀴즈 정답을 맞힐때까지 계속 퀴즈를 내시오.
	// 질문 : 대한민국의 수도는? >>> 서울
	// 정답입니다.
	// 질문 : 대한민국의 수도는? >>> seoul
	// 정답입니다.
	// 질문 : 대한민국의 수도는? >>> 인천
	// 오답입니다.
	public static void ex04() {	
		
		String city = null;
		Scanner sc = new Scanner(System.in);
		
		do {
			if(city != null) {
				System.out.println("오답입니다.");
				}
				System.out.print("대한민국의 수도는? >>> ");
				city = sc.next();
				} while(city.equalsIgnoreCase("seoul") || city.equals("서울"));
				System.out.println("정답입니다.");
				sc.close();
			
	}
	
	// 문제5. 평점 입력 받아서 해당 평점만큼 ★을 출력하시오.
	// 평점은 1 ~ 5 사이 정수로 입력 받는데, 벗어난 범위는 다시 입력 받는다.
	public static void ex05() {
		
		/* **** 내가 쓴 답
		 int score = 0;
		 String[] star = {"★", "★", "★", "★", "★"};
		 Scanner sc = new Scanner(System.in);
		 
		 do {
		 	if(score < 0) {
		 		System.out.println("범위를 벗어났습니다.");
		 		}
		 		} while(score > 5); {
		 		System.out.print("평점을 입력하세요 >>> ");
		 		score = sc.nextInt();
		 		}
		 
		 for(int i = 0; i < score; i++) {
		 System.out.print(star[i]);
		 } */
		
		int grade = 0;
		StringBuilder stb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("1~5 사이 평점을 입력해 주세요: ");
			grade = sc.nextInt();
		} while(grade < 1 || grade > 5);
		for(int i = 1; i <= grade; i++) {
			stb.append("★");
		}
			System.out.println(stb);
		}
	
	// 문제6. 비밀번호를 "1234"로 가정한다.
	// 사용자로부터 비밀번호를 입력 받아서 "1234"와 같으면 "성공", "1234"가 아니면 다시 비밀번호를 입력 받도록 처리하시오.
	// 비밀번호 입력은 최대 5번으로 제한하고, 5번의 입력이 모두 틀리면 최종적으로 "실패"를 출력하시오.
	public static void ex06() {
		
		/* *** 내가 쓴 답
		String passWorld = "";
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		do {
			System.out.print("비밀번호를 입력하세요 >>> ");
			passWorld = sc.next();
			if (passWorld.equals("1234")) {
			System.out.println("성공");
			} while(count < 5) {
				System.out.println("실패");
				System.out.print("비밀번호를 입력하세요 >>> ");
				passWorld = sc.next();
				count++;
			}
		}    */
		
		String pwd = "1234";
		Scanner sc = new Scanner(System.in);
		boolean isSuccess = false;
		
		for(int i = 0; i < 5; i++) {
			System.out.print("비밀번호를 입력하세요 >>> ");
			String input = sc.nextLine();
			if(input.equals(pwd)) {
				System.out.println("성공");
				break;
			}
			System.out.println("실패");
		}
		
	}
	
	// 문제7. 구구단을 외자.
	// 2~9단 사이의 임의의 구구단이 출력되면 정답을 입력한다.
	// 정답을 입력해서 맞으면 "정답", 틀리면 "땡"을 출력하시오.
	// 예시1)
	// 4x9? >>> 36
	// 정답
	// 예시2)
	// 8x7? >>> 49
	// 땡
	public static void ex07() {
		
		int firstNum = (int) (Math.random() * 9);
		int secondNum = (int) (Math.random() * 9);
		int total = firstNum * secondNum;
		int user = 0;
		Scanner sc = new Scanner(System.in);

		while (user != total) {
			System.out.print(firstNum + "*" + secondNum + "? >>> ");
			user = sc.nextInt();
			if (user == total) {
				System.out.println("정답");
				break;
			}
			System.out.println("땡");
		}
		sc.close();
		
	}

	// 문제8. 임의의 주민등록번호(personalId)를 분석하여 나이와 성별을 출력하시오.
	// 나이 : 현재년도 - 태어난년도 + 1
	// 성별 : 하이픈(-) 뒤의 글자가 1,3이면 "남자", 2,4이면 "여자"
	// 예시)
	// 28살 여자입니다.
	public static void ex08() {
		
		String personalID = "940915-3222222";  // 임의로 주민번호 생성
		
		Calendar calendar = Calendar.getInstance();   
		int nowYear = calendar.get(Calendar.YEAR);    // 현재년도
		
		int genderNo = Integer.parseInt(personalID.substring(7, 8));
		// substring 메소드를 활용하여 주민번호의 7번째부터 8이전까지 => 번호 7번째만 <<반환>> => int로 변환하여 저장
		String gender = "";
		
		int yearNo = Integer.parseInt(personalID.substring(0, 2)) + 1900;
		int age = nowYear - yearNo + 1;
				
		switch(genderNo) {
		case 1 :
		case 3 : gender = "남자"; break;
		case 2 : 
		case 4 : gender = "여자"; break;
		}
		
		System.out.println(age + "살 " + gender + "입니다.");
		
	}
	
	// 8번 답안 따라적기
	public static void ex088() {
		String personalId = "141212-3345678";
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int genderNo = Integer.parseInt(personalId.substring(7, 8));
		String birthYear = "";
		switch(genderNo) {
		case 1:
		case 2:
			birthYear = 19 + personalId.substring(0, 2);
			break;
		case 3:
		case 4:
			birthYear = 20 + personalId.substring(0, 2);
			break;
		}
		
		int age = nowYear - Integer.parseInt(birthYear) + 1;
		String[] gender = {"여자", "남자"};
		
		System.out.println(age + "살 " + gender[genderNo%2] + "입니다.");
		// 2로 나눠서 짝,홀 나눠줌 -> 2의 배수 2,4는 여자기 때문에 0이 나올 것임.
		// gender의 인덱스 0에 여자를 위치해줌
		
	}
	
	// 문제9. 다음 기준에 따라서 파일명을 변환하시오.
	// Scanner 클래스의 next() 메소드를 이용해서 파일명을 입력 받은 뒤 파일명을 다음과 같이 수정하시오.
	// 파일명 마지막에 밑줄(_)과 타임스탬프 값을 붙이시오.
	// 예시)
	// 변환 전 파일명 >>> happy.jpg
	// 변환 후 파일명 = happy_1658792128410.jpg
	public static void ex09() {
		
		Scanner sc = new Scanner(System.in);
		String bfName = "";    // 변환 전 파일이름
		String afName = "";    // 변환 후 파일이름
		
		System.out.print("변환 전 파일이름 >>> ");
		bfName = sc.next();
		
		String fileName = bfName.substring(0, bfName.lastIndexOf(".")) + "_" + System.currentTimeMillis();
		String extName = bfName.substring(bfName.lastIndexOf("."));
		afName = fileName + extName;
		
		System.out.println("변환 후 파일명 = " + afName);
		sc.close();
		
	}
	
	// 문제10. Scanner 클래스의 next() 메소드를 이용해서 사람 이름을 입력 받은 뒤
	// 친구의 이름이면 "반갑다 친구야"를 출력하고, 모르는 사람의 이름이면 "처음 뵙겠습니다"를 출력하시오.
	// 친구의 이름을 String[] friend 배열에 저장한 뒤 작업을 수행하시오.
	// 예시1
	// 이름 입력 >>> 정우성
	// 반갑다 친구야
	// 예시2
	// 이름 입력 >>> 유재석
	// 처음 뵙겠습니다
	public static void ex10() {
		
		Scanner sc = new Scanner(System.in);
		String[] friends = {"장서린", "허지원", "이시은", "정우성"};
		String name = "";
		
		System.out.print("이름 입력 >>> ");
		name = sc.next();
		
		if(Arrays.binarySearch(friends, name) >= 0) {
			System.out.println("반갑다 친구야.");
		} else {
			System.out.println("처음 뵙겠습니다.");
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		ex10();
	}

}
