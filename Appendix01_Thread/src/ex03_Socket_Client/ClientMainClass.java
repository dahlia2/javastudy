package ex03_Socket_Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMainClass {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter writer = null; 
		Scanner sc = null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090));  // 서버 주소는 localhost이고, 포트 번호는 9090이다.
			
			
			// socket 정보를 이용하는 클라이언트를 스레드로 생성
			Client client = new Client(socket);
			client.start();
			
			sc = new Scanner(System.in);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.print(">>> ");
				String message = sc.nextLine(); // 채팅 내용을 입력
				writer.write(message + "\n");
				
				// 이 무한 루프 때문에 서버가 보낸 텍스트와 받는 텍스트를 하나의 메인클래스로 들어오는 게 한 번은 주고 한 번은 받는 식으로 가능한데
				// 스레드를 사용하는 것 같다.. 독립적인 객체였을 때 서로 주고받는 게 가능함.
				// 불편하니까 독립적인 기능이 필요한 것이고 그것이 바로 스레드! 
				
				// 한 서버에 여러 클라이언트 생성이 가능함!
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
			
	/*	
	  socket : 서버로 보내는 통로. byte 기반임
		=     ㅁ
     	->   서버
    */

	}

}
