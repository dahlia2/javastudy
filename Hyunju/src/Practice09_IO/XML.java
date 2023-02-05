package Practice09_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML {
	
	public static void ex01() {
		
		/*
		  한국공항공사_항공기 운항정보 : 공항코드 정보
		  1. 서비스 URL:
		  2. 요청 변수
		   1) servicekey 인증키
		*/
		
		// 먼저 api 주소와 서비스키를 스트링에 담아준다
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		String serviceKey = "gj7dS2Er/XeESIZFV3uS5NLHQjEioW2Om5WzKKdNH43iCrt0OR29TPpQr1bSs3ak4sqDUl7a7JYI3b3cCxVeSg==";
		       // 서비스키는 'Decoding' (암호화) 되어있는 걸로!
		
		// URL와 Http어쩌구 선언 + 널값 초기화
		URL url = null;
		HttpURLConnection con = null;
		
		// 속도를 높여줄 버터리더,라이터 선언 + 널값 초기화
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		
		// 예외 처리를 위해 try문 시작!
		try {
			
			// api 주소에 서비스키 덧붙여주기 + servicekey 암호화 풀기 작업
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			//  api + 서비스키 한 것을 URL 클래스 객체에 담음 -> 주소타입으로 만듬
			url = new URL(apiURL);
			// HTTP어쩌구를 이용해서 통로를 뚫어줌
			con = (HttpURLConnection) url.openConnection();
			
			// 왜 쓰는지 잘 모르겠음.. 쌤께 다시 여쭤볼 것
			con.setRequestMethod("GET");
			// set할 것 -> 컨텐트 타입을 xml파일로 (한글을 처리하기 위해 UTF-8로 인코딩 작업)
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			// 가져온 코드가 정산인지 확인하는 작업 -> 200이 나와야 정상
			int resonpeCode = con.getResponseCode();
			if(resonpeCode == 200) {
				// 정상이라면 통로를 뚫을 수 있고 변환작업을 맞친 con을 인풋스트림할게
				// 글자로 읽을 수 있게 인풋스트림'리더'까지 한 후 속도를 올릴 거야
				// 이 모든 것을 버터리더 객체 reader에 담을게
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				// 정상이 아니라면 에러스트림을 가져올 거고.. 이하 같음
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			
			// 리더가 읽은 걸 받을 string 선언 + 널값초기화
			String line = null;
			// 받은 string들을 이어줄 스트링빌더 선언
			StringBuilder sb = new StringBuilder();
			
			//  리더가 한 줄씩 받아온 게 빈값이 아닐 경우
			while((line = reader.readLine()) != null) {
				// 한 줄씩 이어준 뒤 줄바꿈할게
				sb.append(line + "\n");
			}
		  // ===== 내려받는 과정 끝
			
			// 리더 닫고 연결도 끊기 (생략가능)
			reader.close();
			con.disconnect();
			
		
		// 파일로 전송하기
		
			// 파일 생성위치와 이름 정하기
			File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
			
			// 파일에 글자를 보낼 수 있는 파일라이터에 버퍼 끼우는 과정
			writer = new BufferedWriter(new FileWriter(file));
			// sb를 스트링으로 변환해서 보내기
			writer.write(sb.toString());
			// 라이터도 닫음 (생략가능)
			writer.close();
			
			System.out.println("공항코드정보.xml이 생성되었습니다.");
			
		} catch (Exception e) {  // 모든 예외 처리
			e.printStackTrace();
		}
	}

	public static void ex01_parse() {
		
		// 공항코드정보.xml 파일을 콘솔로 출력하기
		
		File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
		
		
		// try문 선언
		try {
			
			// 목적은 Document 객체를 구하는 것
			// 이 목적을 달성하기 위해선 DocumentBuilder가 필요하며,
			// DocumnetBuilder의 객체를 DocumentFactory로 인하여 만들어진다
			// 즉 일하는 사람이 있으려면? 공장부터 생성돼야 한다는 의미!
			// -> 이 과정을 Factory Pattern (다른 클래스의 인스턴스를 가지고 객체 생성) 이라고 함
			
			// 문서를 객체로 만들? 공장 선언
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// XML파일을 Document 객체를 얻을 수 있는 클래스 -> 공장에서 일할 사람? 선언
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// 파일을 문서 타입으로 변환
			// 부모는 문서 자체임 document
			Document doc = builder.parse(file);
			
			
			// <response> 최상위태그 출력
			// 파일을 문서로 담은 doc에서 element 가져오기
			// document의 자식 -> element
			Element root = doc.getDocumentElement();
			System.out.println(root.getNodeName());

			// <header> <body> 출력
			// ㄴ <response> 의 자식태그
			NodeList nodeList = root.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				// 노드리스트.아이템메소드 통해 리스트에 있는 값들을 출력
				Node node = nodeList.item(i);
				System.out.println("  " + node.getNodeName());

				// header의 자식태그 - <resultCode> <resultMsg>
				// body의 자식태그 - <items> <numofRows> <pageNo> <totalCount>
				NodeList nodeList2 = node.getChildNodes();
				for (int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());

					// body의 자식태그 - <items> 선정
					if (node2.getNodeName().equals("items")) {
						// <items>들의 값들을 <item>으로 자식 태그 생성 및 출력
						NodeList items = node2.getChildNodes();
						for (int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("       " + item.getNodeName());

							// <item>의 자식태그 출력
							NodeList itemChildren = item.getChildNodes();
							for (int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								// 이름 + 그 값들도 함께!
								System.out.println(
										"           " + itemChild.getNodeName() + " ->  " + item.getTextContent());
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void ex02() {
		  /*
		   2) pageNo 페이지번호
		   3) schDate 검색일자
		   4) schDeptCityCode 출발도시코드
		   5) schArrvCityCode 도착도시코드
		// api + 서비스키 덧붙여준 것에 페이지넘버, 출발도착도시코드 덧붙여주기
		apiURL += "&pageNo=1";
		apiURL += "sch */
	}
	
	public static void main(String[] args) {
		ex01_parse();

	}

}
