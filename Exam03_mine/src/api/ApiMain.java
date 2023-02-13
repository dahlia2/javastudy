package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {
	
	Accident accident;
	

	public static void main(String[] args) {
		
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		String serviceKey = "gj7dS2Er/XeESIZFV3uS5NLHQjEioW2Om5WzKKdNH43iCrt0OR29TPpQr1bSs3ak4sqDUl7a7JYI3b3cCxVeSg==";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File file = new File("C:" + File.separator + "storage", "accident.txt");
		
		try {
			
			// 읽어들이기 과정
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&siDo=1100" + "&guGun=1125" + "&searchYear=2021"
					+ "&returnType=xml" + "&numOfRows=10" + "&pageNo=1";
				// 리턴타입 json으로 해야 함 ..
				
			url = new URL(apiURL);
			
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			// 파일에 내보내기
			writer = new BufferedWriter(new FileWriter(file));
			
			while((line = reader.readLine()) != null) {
				
				writer.write(line);
				sb.append(line);
			}
			
			reader.close();
			writer.close();
			
			con.disconnect();
			
			
			// (JSON 사용으로) Accident 만들기
			
			
			JSONArray jsa = new JSONArray(sb.toString());
			
			for(int i = 0; i < jsa.length(); i++) {
				
				JSONObject jso = jsa.getJSONObject(i);
				String occrrncDt = jso.getString("occrrncDt");
				String occrrncDayCd = jso.getString("occrrncDayCd");
				int dthDnvCnt = jso.getInt("dthDnvCnt");
				int injpsnCnt= jso.getInt("injpsnCnt");
				Accident acc = new Accident(occrrncDt, occrrncDayCd, dthDnvCnt , injpsnCnt);
				List<Accident> list = new ArrayList<Accident>();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
       
	}

}
