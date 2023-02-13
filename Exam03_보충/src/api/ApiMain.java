package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiMain {

	public static void main(String[] args) {
		
		try {
			
		// API주소
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		apiURL += "?serviceKey=" + URLEncoder.encode("gj7dS2Er/XeESIZFV3uS5NLHQjEioW2Om5WzKKdNH43iCrt0OR29TPpQr1bSs3ak4sqDUl7a7JYI3b3cCxVeSg==", "UTF-8");
		apiURL += "&searchYear=" + URLEncoder.encode("2021", "UTF-8");   	// 숫자도 UTF 처리
		apiURL += "&siDo=" + URLEncoder.encode("1100", "UTF-8");
		apiURL += "&guGun=" + URLEncoder.encode("1125", "UTF-8");
		apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");   // 읽는 타입은 json으로
		apiURL += "&numOfRows=" + URLEncoder.encode("10", "UTF-8");
		apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");
	
		// URL 객체 생성(API주소의 형식 검증)
		URL url = new URL(apiURL);
		
		// API주소 접속
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		// GET 방식의 요청임을 처리
		con.setRequestMethod("GET");
		
		// 응답 데이터는 "json"임을 처리
		// 웹 상에서 주고 받는 데이터의 타입 : Content-Type
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");  
		                                             // charset은 생략 가능. 결과에 한글처리는 UTF-8 변환해야 한다는 말이 없으므로
		
		// 접속된 API로부터 데이터를 읽어 들일 입력 스트림 생성
		// 1. 정상 스트림과 에러 스트림으로 구분해서 생성
		// 2. API 입력 스트림은 오직 바이트 입력 스트림만 지원하므로 문자 입력 스트림으로 바꾸는 작업이 필요
		// 3. 속도 향상을 위해서 Buffer가 내장된 스트림을 생성
		BufferedReader reader = null;
		if(con.getResponseCode() == 200) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		// BufferedReader는 readLine 메소드를 지원한다.
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		// 이제 API의 응답 데이터는 sb에 저장되어 있다.
		System.out.println(sb.toString());
		
		
		
		//
			
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	}