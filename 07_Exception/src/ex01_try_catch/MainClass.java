package ex01_try_catch;

import java.io.FileReader;
import java.util.Scanner;

public class MainClass {

	public static void ex01() {
		
		try {
			String[] season = new String[4];
			
			season[0] = "spring";
			season[1] = "summer";
			season[2] = "autumn";
			season[3] = "winter";
			season[4] = "what??";
			
			for(String str : season) {
				System.out.println(str.substring(0, 3));
			}
	
		} catch(Exception e) { 	// NullPointerException의 e로 입력하는 것이 일반적
								// Unchecked Exception의 경우 RuntimeException으로도 처리 가능
			System.out.println("ArrayIndexOutOfBoundsExceptions 발생");
			
		}
	}
	
	public static void ex02() {
		
		try {
			String input = "1,2,3, ,4,5";
			String[] numbers = input.split(",");
			int[] iNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++) {
				iNumbers[i] = Integer.parseInt(numbers[i]);
				System.out.println(numbers[i]);
			}
		} catch(NumberFormatException e) {  //UnChecked Exception이므로 RunTimeException 가능
											//catch(Exception e) // 모든 예외처리는 Exception으로 처리가능
			System.out.println("NumberFormatException 발생");
			
		}
	}
	
	public static void ex03() {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("계산식을 입력하시오(예: 1+2) >>> ");
			
			String expr = sc.next();
			String[]item = expr.split("[+]");
			
			int number1 = Integer.parseInt(item[0]);
			int number2 = Integer.parseInt(item[1]);
			System.out.println(number1 + number2);
			sc.close();
			
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("+를 포함해서 입력하세요.");
			} catch(NumberFormatException e) {
				System.out.println("정수 덧셈만 가능합니다.");
			} catch(Exception e) { // 마지막 catch 블록은 Exception으로 모든 예외를 처리한다.
				System.out.println("예외가 발생했습니다.");
			}
			
	}
	
	public static void ex04() {
		
		try {
			FileReader fr = new FileReader("sample.txt");
			fr.close();
		} catch(Exception e) {
			System.out.println("예외가 발생하였다.");
		}
	}
	
	public static void main(String[] args) {
		ex04();
	}

}
