package search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class ApiSearchBook {


		public static void main(String[] args) throws Exception {
			String clientId = "QiCcDlsw4QIrGip09ROG";
			String clientSecret = "J58f0EAvhE";
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색어를 입력하세요 >>> ");
			String query = sc.nextLine();
			
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + URLEncoder.encode(query, "UTF-8");
			
			URL url = new URL(apiURL);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", clientId);
			conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			BufferedReader br = null;
			if(conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			
			String line = new String();
			
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			br.close();
			
			JSONObject obj = new JSONObject(sb.toString());
	
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("title", obj.get("title"));
			map.put("link", obj.opt("link"));
			map.put("image", obj.opt("image"));
			
			System.out.println(map.toString());
			
			
			File dir = new File("C:" + File.separator + "download");
			File file = new File(dir, query + ".html");
		
			File error = new File(dir + "File.separator" + "log", query + ".html"); 
			
			String str = map.toString();

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			try { 
				
				
				bw.write("<div id=\"test\">" + str + "</div>");
				bw.write( "<script>"
						+  "$(#test).on('click', function() { "
						+  "location.href='https://openapi.naver.com/v1/search/book.json?query=" + query + ";})"
						+ "</script>" );
				
				bw.close();
				
			} catch (Exception e) {
				System.err.println("예외발생시간 : " + new Date());
				e.printStackTrace(System.err);
				e.getMessage();
			}
			
		
			
		}
		
		
		}
			
			
