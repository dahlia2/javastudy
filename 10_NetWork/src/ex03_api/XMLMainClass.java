package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class XMLMainClass {
	
	public static void ex01() {
		
		/*
			  한국공항공사_항공기 운항정보 : 공항 코드 정보
			  1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
			  2. 요청 변수(Request Parameter)
			  	1) ServiceKey : 인증키
			  	2) pageNo : 페이지번호
			  	3) schDate : 검색일자
			  	4) schDeptCityCode : 출발도시코드
			  	5) schArrvCityCode : 도착도시코드
		*/
		
		String serviceKey = "gj7dS2Er/XeESIZFV3uS5NLHQjEioW2Om5WzKKdNH43iCrt0OR29TPpQr1bSs3ak4sqDUl7a7JYI3b3cCxVeSg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			
			// 순서 지키기
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET"); // 주소창을 입력한 걸 GET하기 위해
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); // xml 문서의 데이터 타입 , 한글화 시키기 위하여 UTF 처리까지
			
			int responseCode = con.getResponseCode();  // 정상이라면 200이 나와야 함
			
			if(responseCode == HttpURLConnection.HTTP_OK) { //  responseCode == 200 (코드가 정상인가?)
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));   // 정상일 때
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));	// 아닐 때
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}     // =============== 내려 받는 과정 끝
			
			reader.close();
			con.disconnect();
			
			// 파일에 보내는 과정
			File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("공항코드정보.xml이 생성되었습니다.");
			
		} catch(IOException e) {  // 전체 예외 통합
				e.printStackTrace();
			}
			
		/* } catch (UnsupportedEncodingException e) {   // encoding 할 때 필요한 예외
			e.printStackTrace();
		
		} catch(MalformedURLException e) {     // 잘못된 프로토콜 처리할 때 필요한 예외
			e.printStackTrace();
		
		} catch(IOException e) {  // 입출력에 필요한 예외
			e.printStackTrace();
		} */ 
		
	}
	
	public static void ex02() {
		
		String serviceKey = "gj7dS2Er/XeESIZFV3uS5NLHQjEioW2Om5WzKKdNH43iCrt0OR29TPpQr1bSs3ak4sqDUl7a7JYI3b3cCxVeSg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			
			// 순서 지키기
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&pageNo=1" + "&schDate=20230201" + "&schDeptCityCode=INC" + "&schArrvCityCode=HND";
			//apiURL += ""
			url = new URL(apiURL);
			
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET"); 
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); 
			
			int responseCode = con.getResponseCode();  
			
			if(responseCode == HttpURLConnection.HTTP_OK) { 
				reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));	
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			reader.close();
			con.disconnect();
			
			// 파일에 보내는 과정
			File file = new File("C:" + File.separator + "storage", "국제선운항스케줄.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선운항스케줄.xml가 생성되었습니다.");
			
		} catch(IOException e) {  // 전체 예외 통합
				e.printStackTrace();
			}
		
	}
	
	public static void main(String[] args) {
		
		ex02();

	}

}
