package JSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class json {
	
	public static void ex01() {
		
		// JSON Object 만들기
		
		JSONObject js = new JSONObject();
		js.put("catelog", "후드집업");
		js.put("brand", "나이키");
		js.put("price", 95000);
		js.put("sell", false);
		
		JSONObject js2 = new JSONObject();
		js2.put("catelog", "가디건");
		js2.put("maker", "꼼데가르송");
		js2.put("price", 200000);
		js2.put("sell", true);
		
		JSONObject js3 = new JSONObject();
		js3.put("catelog", "바지");
		js3.put("maker", "게스");
		js3.put("price", 65000);
		js3.put("sell", false);
		
		System.out.println(js.toString());
		System.out.println(js2.toString());
		System.out.println(js3.toString());
		
		/*
		 
		 프린트 하면 이렇게 출력 -> 이런 식으로 묶어주는 게 < JSON의 기능 >임
		
		{"catelog":"후드집업","price":95000,"sell":false,"brand":"나이키"}
		{"catelog":"가디건","price":200000,"sell":true,"maker":"꼼데가르송"}
		{"catelog":"바지","price":65000,"sell":false,"maker":"게스"}
		
		JSON은 MAP 기반이라 출력에 순서가 없음 (랜덤으로 나옴)
	   
	   	 만약 이걸 자바로 표현한다면? 
	    "{\"catelog\":\"후드집업\",\"price 이런식으로 String값으로 만들어줘야 하고.. 엄청 복잡해짐
	    
	    */

	}
	
	public static void ex02() { 
		
		// JSON Array 만들기
		
		// 1. String -> Array
		String str = "{\"catelog\":\"후드집업\",\"price\":95000,\"sell\":false,\"brand\":\"나이키\"}, {\"catelog\":\"가디건\",\"price\":200000,\"sell\":true,\"maker\":\"꼼데가르송\"}, {\"catelog\":\"바지\",\"price\":65000,\"sell\":false,\"maker\":\"게스\"}";
		JSONArray products = new JSONArray(str);
		
		for(int i = 0; i < products.length(); i++) {
		JSONObject js = products.getJSONObject(i);
		String catelog = js.getString("catelog");
		String brand = js.getString("brand");
		int price = js.getInt("price");
		boolean sell = js.getBoolean("sell");
		
		System.out.println("현재 창고 :" + catelog);
		}
}

	public static void main(String[] args) {
		ex01();
		
	}

}
