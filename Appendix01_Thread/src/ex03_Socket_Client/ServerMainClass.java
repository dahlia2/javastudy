package ex03_Socket_Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMainClass {
	
	
	public static void main(String[]args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
	
	try {
		
		serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("localhost", 9090));
		
		System.out.println("==== 채팅 서버 오픈====");
		
		while(true) {
			
			socket = serverSocket.accept(); // ClientMainClass의 socket.connect() 요청을 받아주는 코드
			System.out.println("접속한 클라이언트 정보 : " + socket.getInetAddress()); // 접속한 클라이언트의 IP 주소를 받아오는 소켓
		
		}
		
	} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
			serverSocket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
}
