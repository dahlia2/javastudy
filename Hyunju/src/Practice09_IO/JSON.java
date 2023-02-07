package Practice09_IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON {
	
	// JSON 개념 다시 공부
	
	// JSONObject는 {} , JSONArray은 []로 표기
	// JSONObject은 객체 -> Map 기반으로 제작된 클래스
	 // 즉 Key-Value 값으로 이루어진 쌍
	 // Key는 무조건 String : Value는 문자열, 숫자, boolean, array 형태가 올 수 있음
	
	
	public static void ex01() {
		
		// 한국환경공단 에어코리아 대기오염정보: 시도별 실시간 측정정보
		// 1. 서비스 url :
		// 2. 요청변수
		//	1) 서비스키(인증키)
		//	2) 리턴타입: xml 혹은 json
		//  3) sidoname: 시도 이름
		
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		// 서비스키는 'Decoding' (암호화) 되어있는 걸로!
		String serviceKey = "gj7dS2Er/XeESIZFV3uS5NLHQjEioW2Om5WzKKdNH43iCrt0OR29TPpQr1bSs3ak4sqDUl7a7JYI3b3cCxVeSg==";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		// try문 시작
		
		try {
			
		// 제이손타입으로 내려받는 과정
			
			// "서울"을 스트링값에 담아주기
			String sidoName = "서울";
			// 스트링값을 이어줄 스트링빌더 선언
			StringBuilder sbURL = new StringBuilder();
			
			// 스트링빌더 append 메소드를 통해 api주소에 서비스키, 리턴타입, 시도네임 덧붙여주기
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); // 서비스키 암호화 풀기
			sbURL.append("&returnType=json");
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8")); // 한글(서울) 변환 과정
			
			// 모든 걸 합친 sbURL을 스트링값으로 변환해서 URL 객체에 담는다
			url = new URL(sbURL.toString());
			// url에 오픈커넥션 메소드를 통해 길을 뚫고 HTTP어쩌구로 변환해서 걔 객체에 담는다
			con = (HttpURLConnection) url.openConnection();
			
			// 공용 API에서 값을 가져오는 걸 GET 메소드로 가져오라고 명시되어있음
			con.setRequestMethod("GET");
			
			// 콘텐트 타입 : 어플-제이손으로 한글은 UTF-8 코드로 변환
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			// 가져온 코드가 정상인지 확인
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) { // 정상 200 ?
				
				// 정상이라면? 통로 인풋스트림과 글자 읽을 수 있눈 인풋reader 생성! 속도를 올릴 버퍼까지~
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				// 정상이 아니라면? 에러스트림과 이하 동일
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			// 리더가 한 줄씩 받아온 값이 null이 아니라면 스트링빌더를 통해 이어붙일게
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			System.out.println(sb.toString());
			
			reader.close();
			con.disconnect();
			
			System.out.println();
			
		// 제이손 오브젝트로 만드는 과정!
			
			// 리더가 한 줄씩 받아온 것을 스트링빌더로 이어붙였고,
			// 그것을 스트링값으로 변환해서 JSON 오브젝트에 담음
			JSONObject obj = new JSONObject(sb.toString());  // 가장 바깥쪽 } 괄호의 값
			
			// obj의 response와 거기의 body를 꺼내왔고
			// 그걸 오브젝트 body에 담고..?
			JSONObject body = obj.getJSONObject("response").getJSONObject("body");
			                          // response은 바깥쪽에서 괄호 2번째 값
									  // body은 바깥쪽에서 괄호 3번째 값
			
			// 다 담은 body를  제이손array의 items로 가져오기..? 
			JSONArray items = body.getJSONArray("items");
			for(int i = 0; i < items.length(); i++) {
				
				// System.out.println(items.getJSONObject(i));
				/* 이렇게 뜸
				{"pm10Value":"-","no2Grade":null,"no2Flag":"통신장애","pm10Flag":"통신장애","khaiGrade":null,"o3Value":"-","o3Flag":"통신장애","so2Grade":null,"khaiValue":"-","o3Grade":null,"so2Value":"-","no2Value":"-","pm10Grade":null,"coFlag":"통신장애","dataTime":"2023-02-05 20:00","sidoName":"서울","coValue":"-","so2Flag":"통신장애","stationName":"중구","coGrade":null}
				{"pm10Value":"71","no2Grade":"2","no2Flag":null,"pm10Flag":null,"khaiGrade":"2","o3Value":"0.037","o3Flag":null,"so2Grade":"1","khaiValue":"92","o3Grade":"2","so2Value":"0.004","no2Value":"0.032","pm10Grade":"2","coFlag":null,"dataTime":"2023-02-05 20:00","sidoName":"서울","coValue":"0.7","so2Flag":null,"stationName":"한강대로","coGrade":"1"}
				{"pm10Value":"63","no2Grade":"2","no2Flag":null,"pm10Flag":null,"khaiGrade":"3","o3Value":"0.031","o3Flag":null,"so2Grade":"1","khaiValue":"154","o3Grade":"2","so2Value":"0.003","no2Value":"0.035","pm10Grade":"2","coFlag":null,"dataTime":"2023-02-05 20:00","sidoName":"서울","coValue":"0.7","so2Flag":null,"stationName":"종로구","coGrade":"1"}
				 */
		
				
			// array의 각각 items들을 JSONObject로 변환
				 // -> (JSONObject)items 으로 강제 변환해서 가져오는 방법 뭐였더라
				JSONObject item = items.getJSONObject(i);
				
				// JSONObject item에 정보가 담겨져있고.. 거기서 stationName을 string값으로 가져옴
				String stationName = item.getString("stationName");
			//	System.out.println(stationName);  // 종로 용산구 광진구 성동구 광변북로..
				
				String pm10Value = item.getString("pm10Value");
			//	System.out.println(pm10Value);  // 71 63 63 61 63 ...
				
				String o3Value = item.getString("o3Value");
			//	System.out.println(o3Value); // 0.037 0.033 0.033 0.017 ...
				
				System.out.println(stationName + " >>>  미세먼지: " + pm10Value + ", 초미세먼지: " + o3Value);

			}		
			
			
			
		}catch (Exception e) {  // 모든 예외처리
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ex01();
	}

}
