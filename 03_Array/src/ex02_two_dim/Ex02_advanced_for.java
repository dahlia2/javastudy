package ex02_two_dim;

public class Ex02_advanced_for {
	
	public static void ex01() {
		
		int[][] scores = {
				{70, 80, 90} ,
				{80, 90, 100} ,
				{50, 60, 70}
		};

		
		for(int[] arr : scores) {  // 2차원 데이터에서 데이터를 빼오면 1차원 데이터
			for(int score : arr) {  
				System.out.print(score + "\t");
			}
			System.out.println();
		}
	}
	
	public static void ex02() {
		
		String[][] timeTable = {
				{"국어", "윤리", "수학", "체육"},
				{"미술", "수학", "영어"},
				{"사회", "한자", "수학", "국어", "영어"},
				{"음악", "국어", "윤리"},
				{"수학", "영어", "체육", "과학"}
		};
		
		for(String[] day : timeTable) {
			for(String subject : day) {
				System.out.println(subject + "\t");
				} 
			System.out.println();
			}
		}



	// 메소드 호출
	public static void main(String[] args) {
		ex01();
	}

}
