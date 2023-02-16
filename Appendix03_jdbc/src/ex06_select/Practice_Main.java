package ex06_select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Practice_Main {

	public static void main(String[] args) {
		
		// 오라클데이터베이스와 연결할 때 사용하는 connection 인터페이스
		Connection con = null;
		
		// 작성된 쿼리문을 전달받으면 해당 쿼리문을 실행해 주는 역할
		// statement 인터페이스는 보안 문제로 사용하지 않는 것이 좋음
		PreparedStatement ps = null;
		
		// 오직 SELECT문에서만 사용된다
		// 여기서 rs 객체는 하나의 행을 가르키는 포인터 역할 -> next 메소드를 통해 각 행을 가리킬 수 있다
		ResultSet rs = null;
		
		try {
			
			// 클래스를 메모리에 로드 -> 이 클래스를 사용하겠다.
			Class.forName("oracle.jdbc.OracleDriver");
			
			
			// db.프로퍼티파일의 객체를 담기 위해  '프로퍼티객체 생성'
			Properties p = new Properties();
			
			
			// db 프로퍼티 '파일'을 읽기위해 -> 파일리더 클래스 생성하고 -> 버퍼까지 끼운 것을
			// 프로퍼티 클래스의 load 메소드로 (같은 프로퍼티니까) 얹어준다
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			
			// 오라클 url 정보를 담은 것을 스트링에 담고
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			
			// DriverManager 클래스로 오라클 접속 정보와 프로퍼티 파일의 객체를 담는다.
			con = DriverManager.getConnection(url, p);
			
			
			// 쿼리문을 작성하여 스트링에 담고 (조회 쿼리문)
			String sql = "SELECT MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE";
			sql += " FROM MEMBER_TBL";
			
			
			// 이 쿼리문을 담은 것을 Connection이 연결해준다
			// Properties가 전달받아 해당 쿼리문을 실행해준다
			ps = con.prepareStatement(sql);
			
			
			// 쿼리문을 실행해 준 걸  -> 하나의 행씩 가르켜주는 역할
			rs = ps.executeQuery();
			
			
			// 여러 결과 행을 담을 수 있는 List 선언
			List<Practice_Member> memberList = new ArrayList<Practice_Member>();
			
			while(rs.next()) {
				
				// (ResultSet 객체) rs은 칼럼의 이름을 그대로 가져다준다 
				Practice_Member member = new Practice_Member();
				member.setMember_no(rs.getInt("MEMBER_NO") );
				// 쿼리를 조회할 수 있는 ResultSet가 MEMBER_NO 값을 찾아서 가져와줌
				// 가져온 값을 set으로 practice_member 필드에 가져다 주고 get으로 적용
				member.setId(rs.getString("ID") );
				member.setName(rs.getString("NAME") );
				member.setAddress(rs.getString("ADDRESS") );
				member.setJoin_date(rs.getDate("JOIN_DATE") );
				
				// 각각의 칼럼의 데이터를 통합하여 arraylist에 저장
				memberList.add(member);
			
			} // while문 종료
			
			
			// 저장한 arraylist 크기가 0이라면? 조회된 의미가 없다는 뜻 -> 0은 값이 없으니까
			
			for(int i = 0; i < memberList.size(); i++) {
				System.out.println(memberList.get(i));
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				try {
					if(rs!= null) rs.close();
					if(ps!= null) ps.close();
					if(con != null) con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}
