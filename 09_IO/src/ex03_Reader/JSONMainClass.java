package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void main(String[] args) {
		
		// C:\storage\product.json 읽기
		
		File file = new File("C:" + File.separator + "storage", "product.json"); // 대괄호로 묶여있으니 배열로 처리 -> JSONArray 처리

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder sb = new StringBuilder();

			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			JSONArray arr = new JSONArray(sb.toString()); // JSON 배열 하나당 { } => JSON 오브젝트
			
			List<Map<String, Object>> products = new ArrayList<Map<String, Object>>();
			
			for (int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i); // JSONArray 또한 get메소드가 타입별로 만들어져있음
				// obj.toMap(); // 오브젝트를 맵으로 바꿔주는 메소드 // JSON  오브젝트가 맵이랑 구성이 유사함 // 고로 필요 없음
				products.add(obj.toMap()); // JSONObject obj를 Map으로 바꿔서 List에 저장하기

				System.out.println(products);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}

