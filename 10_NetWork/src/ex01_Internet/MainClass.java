package ex01_Internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MainClass {
	
	/*
	 	URL
	 	1. Uniform Resource Locator
	 	2. 정형화된 자원의 경로
	 	3. 실제로는 웹 주소를 의미한다
	 	4. 구성                              (↓개발자가 만든 주소 )
	 	     프로토콜:// 	호스트	    /  서버경로  ?파라미터=값&파라미터=값&...            /query
	 	   		https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=삼성전자
	 	   		1) 프로토콜 : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토컬)
	 	   		2) 호스트 	: 서버의 대표 주소
	 	   		3) 서버경로 : URL Mapping(URL Pattern)
	 	   		4) 파라미터 : 서버를 보내는 데이터를 의미(변수라고 생각하면 된다.) ?가 두개면 잘못된 주소
	 	   		5) query    : = 사용자가 검색한 내용
	*/
	
	public static void ex01() {
		
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		URL url = null;
		
		try {
			url = new URL(apiURL); // 반드시 예외처리가 필요한 코드
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트   : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());
		
		}catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		}
		
	}
	
	public static void ex02() {
		
		// 웹 접속을 담당하는 
		
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);		// MalformedURLException 처리가 필요
			con = (HttpURLConnection)url.openConnection(); // IoException 처리가 필요
			
			/*
				HTTP 응답 코드 (공부하기!)
				1. 200	: 정상
				2. 40X	: 잘못된 요청 (없는 주소. 사용자 잘못)
				3. 50X	: 서버측 오류 (서버 잘못)
			*/
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK);  // 정상 200
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND); // 사용자오류 40X
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);  // 서버오류 50X
			
			// apiURL 접속 확인
			int responseCode = con.getResponseCode();  // 응답코드 가져오는 메소드
			if(responseCode == 200) { // 200이라면 정상 -> 접속 성공
				System.out.println(apiURL + " 접속 완료");
				
			// 요청 방식(요청 메소드)
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod);
			
			// 컨텐트 타입
			String contentType = con.getContentType();
			System.err.println("컨텐트 타입 :" + contentType);
				// ㄴ (text / html) , (image / png) , (applicatiln / json) 와 같이 int, double처럼 자바의 상수 개념
			}
			
			// 요청 헤더
			String userAgent = con.getRequestProperty("User-Agent");
			System.out.println("User-Agent : " + userAgent);
			
			String referer = con.getRequestProperty("referer");
			System.out.println("Referer : " + referer);  // 이전 주소가 나옴
			// 대표적으로 사이트에서 로그인 성공하고 원래 페이지로 돌아올 때 쓰임 (보통 메인화면) 
			
			con.disconnect(); // 생략 가능
			
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			System.out.println("apiURL 접속 오류");
		}
		
	}
	
	public static void ex03() {
		
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;
		
		InputStream in = null;      // Daum 로그를 읽어들이는 입력 스트림
		FileOutputStream out = null;   // C:\storage\daum.png로 내보는 출력 스트림
		                                 // ㄴ 가져온 데이터를 '파일로' 보내고 싶으니까 FileOutput스트림 선언
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) { // 접속되었다면 작업을 수행하겠다
				
				in = con.getInputStream();  // 콘을 이용하여 데이터를 이용할 수 있는 메소드를 호출
				out = new FileOutputStream("C:" + File.separator + "storage" + File.separator + "daum.png");
				
				byte[] b = new byte[10];
				int readByte = 0; 
				
				while((readByte = in.read(b)) != -1) {
						out.write(b, 0, readByte);
						}
				
				System.out.println("다운로드 완료");
				
				out.close();
				in.close();
				con.disconnect();
				
				}
			
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
		
		// (자바)  <-  (이미지)   // 내가 작성하는 기준으로 자바로 보면 가져오는 거니까 input   // 글자를 읽어드릴 때 reader writer를 쓰는 것임
		// daum 이미지는 url가 처리했고 java로부터 올 수 잇는 통로를 huc으로 뚫음 걔 객체인 con을 이용하여 getinputstream 메소드로 데이터를 가져옴
		
	}
	
	public static void ex03_02() { // 보조스트림 버퍼 사용
		String upiURL = "https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
		URL url = null;
		HttpURLConnection con = null;
		
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		File file = new File("C:" + File.separator + "storage" + File.separator + "daum.png");
		
		try {
			url = new URL(upiURL);
			con = (HttpURLConnection)url.openConnection();
			
			int responseCode = con.getResponseCode();
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("apiURL 접속 오류");
		}
	
	}

	public static void ex04() {
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		URL url = null;
		HttpURLConnection con = null;
		
		// 커넥션은 writer와 reader를 지원하지 않음. 그렇다면? 바이트를 문자열로 변환할 수 있는 InputStreamReader 활용!
		InputStreamReader reader = null;
		
		// 파일로 보내줄 writer 생성
		FileWriter writer = null;
		
		File file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new InputStreamReader(con.getInputStream());  // 성공했을 땐 정상 스트림  // 인풋스트림을 받아와서 인풋스트림'리더'로 변환 
			} else {
				reader = new InputStreamReader(con.getErrorStream());  // 실패했을 땐 에러 스트림
			}
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2];
			int readCount = 0;   // 2글자씩 읽어들였을 때 나머지 값
			
			while((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount); // 0부터 읽어들인 글자수만큼 사용하겠다
			}
			
			writer = new FileWriter(file);
			writer.write(sb.toString());
			
			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println("다운로드 완료");
			
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
	}
	
	public static void ex05() {
		
			/*
				  인코딩(암호화) : 원본 데이터를 UTF-8 방식으로 암호화
				  디코딩(복호화) : UTF-8 방식으로 암호화된 데이터를 복원
			*/
		
		String data = "한글 english 12345 !@#$+-";  // 띄어쓰기는 +로 인코딩
		
		try {
			
			// 인코딩
			String encodeData = URLEncoder.encode(data, "UTF-8");  // 파일 깨지지 말라고 인터넷에 주소창에 붙여서 보냄
			System.out.println(encodeData);
			
			// 디코딩 (실무에서 쓸 일 거의 없음)
			String decodeData = URLDecoder.decode(encodeData, "UTF-8");  // %ED%95%9C%EA%B8%80+english+12345+%21%40%23%24%2B-로 나온 걸 원상복구 시킨다
			System.out.println(decodeData);
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
	
	}
	
	public static void ex06() {  // 연습   // 주소를 storage/sfc_web_map.xml로 다운로드 받기
		
		// 가져올 주소 스트링 타입에 담기
		String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		
		// 주소를 담을 수 있는 URL 클래스 선언
		URL url = null;
		
		// URL을 연결할 수 있는 HttpURL 선언
		HttpURLConnection huc = null;
		
		// 내부로 읽어들일 수 있고 속도 향상을 위한 BufferedReader 선언
		//BufferedReader br = null;
		
		// 내부로 읽어들일 수 있고, 속도 향상을 위한 BufferedInputStream (* 텍스트를 받아드리는 게 아니라 reader로 사용 x
		//BufferedReader br = new BufferedReader(new InputStreamReader());
		//BufferedInputStream in = new BufferedInputStream(new InputStreamReader();
		
		// 파일로 내보내기 위한 FileWriter + 속도향상 Buffered 착용 함께 생성  / 내보낼 폴더도 함께 선언
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:" + File.separator + "storage", "sfc_web_map.xml")));
		
		
		// 예외처리를 위한 try문 선언
		try {
			
			// 주소를 URL 객체에 담기
			url = new URL(apiURL);
			
			// (주소를 담은 URL 객체의) url에 통로를 만듬
			huc = (HttpURLConnection)url.openConnection();
			
			// 주소를 담을 빈 스트링 초기화
			String message = null;
			
			
			// 접속 가능 코드를 담을 int타입 responsible 선언
			int responsible = huc.getResponseCode();
			
			if(responsible == HttpURLConnection.HTTP_OK)  // 접속가능코드를 담은 객체가 정상이라면
				BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			
			FileWriter fw = new FileWriter(file);
		} catch (IOException e) {
			// TODO: handle exception
		}
	
		
		
	}
	
	
	public static void main(String[] args) {
		ex05();

	}

}
