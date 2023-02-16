package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberTableMainClass {

	public static void main(String[] args) {
		
		/* 1. Connection 생성 */
		
		// Connection 생성
		Connection con = null;
		
		try {
			
			// 오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			// 만약 여기서 class 예외가 나면 -> 오타가 났거나, buildpath(jar)를 설치하지 않은 것
			
			// 프로퍼티 파일 읽어서 프로퍼티 객체 생성
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			// 프로퍼티 객체에 저장된 각 프로퍼티(속성) 가져오기
			String url = p.getProperty("url");  // 스트링을 읽는 Property 클래스 즉, 우리가 이름은 정하면 되는 것
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			// Connection 생성
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	/* 2. 쿼리문 작성 및 실행 */
	
	/*
	 	PreparedStatement 인터페이스
	 	1. Prepared  : 미리 준비하시오.
	 	2. Statement : 쿼리문을
	 	3. 작성된 쿼리문을 전달하면 해당 쿼리문을 실행해 주는 역할을 수행한다.
	 	4. Statement 인터페이스는 보안 문제로 사용하지 않는 것이 좋다.
	*/

	/* 
	 
		 Statement 클래스만 사용한다면 입력한 값 그대로 알려줌
		 
		 아래 로그인 예시)
		 
		 로그인 할 때 입력하는 쿼리문
		 SELECT * FROM ID = 변수 AND PW = 변수;
		  
		 아이디에 입력한 값 : 'aaa'  --
		 비밀번호에 입력한 값 : 'aaa'
		  
		 SELECT * FROM ID = 'aaa'    --(주석) AND PW = 'aaa';
		 
		 ==> PreparedStatement 클래스를 사용한다면 한 번 더 괄호로 묶어주기 때문에 보안을 유지할 수 있음!
	 
	*/
	
	// 주의!! Jdbc에서는 쿼리문의 마지막을 세미콜론(;)을 붙이지 않는다.
		
	StringBuilder sb = new StringBuilder();
	sb.append("CREATE TABLE MEMBER_TBL (");
	sb.append("MEMBER_NO NUMBER NOT NULL");
	sb.append(", ID VARCHAR2(30 BYTE) NOT NULL UNIQUE");
	sb.append(", NAME VARCHAR2(30 BYTE) NOT NULL");
	sb.append(", ADDRESS VARCHAR2(30 BYTE)");
	sb.append(", JOIN_DATE DATE NOT NULL");  // NOT NULL);"  세미콜론 붙이지 않기!!
	sb.append(", CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NO))");
	
	
	
	
	String sql = sb.toString();
	
	// 이렇게 쿼리문을 준비해야 PreparedStatement 클래스를 사용할 수 있음!
	PreparedStatement ps = null; // 다짜고짜 생성할 수 없음. null 처리 해야 함
	
	
	try {
		
		// PreparedStatement 객체 생성
		ps = con.prepareStatement(sql);
		
		// 쿼리문 실행하기
		ps.execute();
		System.out.println("쿼리문이 실행되었습니다.");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	/* 3. 사용한 자원 반납하기 */
	
	try {
		
		if(ps != null) ps.close();		// PreparedStatement의 객체 ps
		if(con != null) con.close();    // Connection의 객체 con
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	
	
	}
}
