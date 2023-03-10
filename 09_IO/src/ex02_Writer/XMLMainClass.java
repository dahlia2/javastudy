package ex02_Writer;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLMainClass {  // 자바보단 자바스크립트에서 사용함
	
	/*
		XML
		1. eXtensible Markup Language
		2. HTML(표준 마크업 언어)의 확장 버전
		3. 정해진 태그 외 사용자 정의 태그의 사용이 가능하다.
		
	*/
	
	/*
	 	목표.
	 	1. 경로
	 		C:\storage\product.xml // 문서 자체를 객체로 보는 방식 'dom' (document object model)
	 	2. 내용
	 		<products>       // 부모는 '문서 자체' -> product 파일(document)
	 			<product>    // element. 부모는 products element
	 				<model>세탁기</model>    // 여기서 세탁기는 textContent (태그 사이에 text) -> 제이손으로 넘어가면 text() 메서드
	 				<maker>삼성</maker>
	 				<price>100</price>
	 			</product>
	 			<product>
	 				<model>냉장고</model>
	 				<maker>LG</maker>
	 				<price>200</price>
	 			</product>
	 			<product>
	 				<model>TV</model>
	 				<maker>삼성</maker>
	 				<price>300</price>
	 			</product>
	 		</products>
	*/

	public static void main(String[] args) {
		
		Map<String, Object> product1 = new HashMap<String, Object>();
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		Map<String, Object> product2 = new HashMap<String, Object>();
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		Map<String, Object> product3 = new HashMap<String, Object>();
		product3.put("model", "TV");
		product3.put("maker", "삼성");  
		product3.put("price", 300);
		
		List<Map<String, Object>> productList = Arrays.asList(product1, product2, product3);
		
		try {
			
			// Document 생성(Document는 XML문서 자체를 의미한다.)
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // 문서 빌더(문서를 만드는 사람으로 비유)의 공장 생성
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlStandalone(true); 
			
			// <products> 태그 : Element 생성
			Element products = document.createElement("products");
			document.appendChild(products);
			
			// productList 순회
			for(Map<String, Object> map : productList) {
				// <product> 태그 : Element 생성
				Element product = document.createElement("product");
				products.appendChild(product);
				
				// <model> 태그 : Element 생성
				Element model = document.createElement("model");
				product.appendChild(model);
				model.setTextContent((String)map.get("model"));
				
				// <maker> 태그 : Element 생성
				Element maker = document.createElement("maker");
				product.appendChild(maker);
				maker.setTextContent(map.get("maker").toString());
				
				// <price> 태그 : Element 생성
				Element price = document.createElement("price");
				product.appendChild(price);
				price.setTextContent((int)map.get("price") + "");
				
				// XML 설정
				TransformerFactory transformerfactory = TransformerFactory.newInstance();
				Transformer transformer = transformerfactory.newTransformer();
				transformer.setOutputProperty("encoding", "UTF-8");
				transformer.setOutputProperty("indent", "yes");
				transformer.setOutputProperty("doctype-public", "yes");
				
				// XML 문서 만들기
				File dir = new File("C:" + File.separator + "storage");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "product.xml");
				Source source = new DOMSource(document);
				StreamResult streamResult = new StreamResult(file);
				transformer.transform(source, streamResult);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
