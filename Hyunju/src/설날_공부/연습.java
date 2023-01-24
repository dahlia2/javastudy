package 설날_공부;

import java.util.Scanner;

public class 연습 {
	
	public static void ex01() {
		
	// 문제4. 0~9 사이 난수를 100개 생성하시오.
		// 발생한 0~9 사이의 각 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하시오.
		// 예시)
		// 0 : #### 4
		// 1 : ############ 12
		// 2 : ############ 12
		// 3 : ##### 5
		// 4 : ######## 8
		// 5 : ########### 11
		// 6 : ############ 12
		// 7 : ################## 18
		// 8 : ####### 7
		// 9 : ########### 11
				
		int[] arr = new int[100];
		int[] count = new int[10];
	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
			count[arr[i]]++;
		}
	
		for (int i = 0; i < count.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < count[i]; j++) {
				sb.append("#");
			}
			String graph = sb.toString();
			System.out.println(i + " : " + graph + " " + count[i]);
		}
	
	}
	
	
	public static void ex02() {
		// 문제5. 간단한 성적 관리 프로그램을 구현하시오.
		// 학생은 3명, 과목은 3과목으로 가정한다.
		// 학생 이름 : "정숙", "미희", "상철"
		// 과목 이름 : "국어", "영어", "수학"
		// 입력 받은 성적과 각 성적의 합계를 함께 출력하시오.
		// 예시)
		// 정숙의 국어 점수 >>> 50
		// 정숙의 영어 점수 >>> 51
		// 정숙의 수학 점수 >>> 53
		// 미희의 국어 점수 >>> 60
		// 미희의 영어 점수 >>> 61
		// 미희의 수학 점수 >>> 63
		// 상철의 국어 점수 >>> 70
		// 상철의 영어 점수 >>> 71
		// 상철의 수학 점수 >>> 73
		//
		// 	    국어 영어 수학 총점	
		// 정숙 50   51   53   154	
		// 미희 60   61   63   184	
		// 상철 70   71   73   214	
		// 합계 180  183  189  552	
			
		String[] student = { "정숙", "미희", "상철", "합계" };
		String[] subject = { "국어", "영어", "수학", "총점" };
		int[][] score = new int[student.length][subject.length];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < score.length - 1; i++) {
			for (int j = 0; j < score[i].length - 1; j++) {
				System.out.print(student[i] + "의 " + subject[j] + " 점수 >>> ");
				score[i][j] = sc.nextInt(); 
				score[i][subject.length - 1] += score[i][j]; 
				score[student.length - 1][j] += score[i][j]; 
			}
		}
		System.out.print("\n\t"); 
		for (int i = 0; i < subject.length; i++) {
			System.out.print(subject[i] + "\t");
		}

		System.out.println();

		for (int i = 0; i < student.length; i++) {
			System.out.print(student[i] + "\t");
			for (int j = 0; j < subject.length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void ex03() {
	
	}
	public static void main(String[] args) {
		ex03();
	}
				
}
