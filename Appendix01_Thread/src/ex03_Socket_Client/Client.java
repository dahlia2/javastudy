package ex03_Socket_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;



public class Client extends Thread {
	
	private BufferedReader reader;  // 서버 정보를 읽는 reader
	
	public Client(Socket socket) {  // 서버 정보가 담긴 socket이 넘어온다.
		
		try {
			
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			reader.readLine(); // 서버는 클라이언트로 문장을 보낸 뒤 엔터를 누른다. 따라서
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run () {
		
		try
			{
			while(true) {
				String message = reader.readLine(); // 서버는 클라이언트로 문장을 보낸 뒤 엔터를 누른다. 따라서 엔터를 입력할 필요 없다/.
				if(message.equals("굿바이")) { // 서버가 굿바이를 보내면 클라이언트가 종료된다.
					break;
				}
				System.out.println(message);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
}
}
