package ex01_Thread;

public class MainClass {  
	
	  // 쓰레드를 한다면 (single 스레드 환경인)메인부터 처리하기 때문에 System.out.prinln 부터 실행되는 것이다.

	public static void main(String[] args) {
		
		
		Calculator myCalc = new Calculator("영희");  // myCalc 스레드 생성
		myCalc.start();    // start 메소드는 run 메소드를 스스로 호출한다.
		                   // main은 myCalc 스레드의 동작 시작만 처리하고, 동작 완료까지 기다리지 않습니다.
		                   // ㄴ 이해 안 되지만 그냥 외우기..^^
		
		Calculator yourCalc = new Calculator("상철");
		yourCalc.start(); 
		
		// myCalc 스레드가 yourCalc 스레드보다 먼저 실행된다는 보장이 전혀 없다.
		// 스레드 실행 순서를 정하는 건 개발자가 아니라 JVM이다.
		   // ㄴ FIFO, SJT 기준 등 .. 으로 처리한다고 생각하면 됨
		                   
		System.out.println("main 메소드를 종료합니다.");

	}

}
