package dao2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto2.ContactDTO2;

//[ DAO ] : 데베에 접근해서 쿼리문 실행하고 결과 받아옴

public class ContactDAO2 {
	
	// 싱글톤 패턴 -> 필드와 생성자는 private 처리, 메소드를 통해 가져옴
	// 왜? 보안을 위해. 여러 객체가 만들어지지 않게
	
	// DAO의 객체를 만들 수 없게 private 처리..?
	private static ContactDAO2 dao = new ContactDAO2();
	private ContactDAO2() {}
	
	// 메소드를 통해서! DAO 객체를 가져올 수 있게 함
	public static ContactDAO2 getInstance() {
		return dao;
	}
	
	public void 목록보기() { }
	
	
	// DAO 클래스의 메소드들이 공통으로 사용할 객체 선언
	private Connection con; // DB 접속
	private PreparedStatement ps; // 쿼리문 실행
	private ResultSet rs; // SELECT 결과
	private String sql; // 쿼리문 자체
	private int res; // INSERT, UPDATE, DELETE 결과 -> 한 행씩 가져옴
	
	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	
	
	// CRUD 과정 전 메소드
	// 과정 : Connection 얻고 -> CRUD 작업 -> 사용한 자원 반납
	
	
	// [ 공통 메소드 1 ] : 데이터 접속! Connection 얻기
	private Connection getConnection() {
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스 사용 선언
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));  // db 프로퍼티 파일 읽어드리기
			
			con = DriverManager.getConnection(p.getProperty("url"), p); // url와 프로퍼티 값 담아서 데이터 접속
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; // 오류 마친 후 con 반납
	
	}
		
		
	// [ 공통 메소드 2 ] : 사용한 자원 반납(close) 과정
		
	public void close() {
		
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	
	
	// [ CRUD 메소드 1 : 연락처 추가 ]
	// 반환값은 0(실패) 혹은 1(성공) -> 하나라도 실패하면 모두 실패! -> 트랜잭션
	// 매개변수는 DTO 객체 -> 연락처 정보 모두가(name, tel, email, address가 저장되어 있음
	public int insertContact(ContactDTO2 contact) {
		
		try {
			
			con = getConnection(); // 공통메소드1 (오라클클래스사용선언과, 오라클정보와계정아디비번이 담김)
			sql = "INSERT INTO CONTACT2_TBL(CONTACT2_NO, NAME, TEL, EMAIL, ADDRESS) VALUES(CONTACT2_SEQ.NEXTVAL, ?, ?, ?, ?)"; // CONTACT 테이블의 데이터값 추가할 틀
			ps = con.prepareStatement(sql); // 쿼리문을 가져올 수 있는 preparedstatment 객체를 사용하여 데이터 접속
			ps.setString(1, contact.getName());   // 물음표의 첫 번째 값
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			res = ps.executeUpdate(); // 쿼리문 완성한 걸 하나의 행씩 가르킬 수 있는 Resultset 객체에 담음
									  // executeUpdate은 DML 처리 -> return 반납 (쿼리 데이터 수정한 걸 반납)
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	
	
	// [ CRUD 메소드 2 : 연락처 삭제 ]
	// 반환값은 0(실패) 혹은 1(성공) 
	// 매개변수는 int contact_no 변수 -> 삭제할 연락처의 고유 번호
	public int deleteContact(int contact_no) {
		
		try {
			
			con = getConnection();
			sql = "DELETE FROM CONTACT2_TBL WHERE CONTACT2_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);  // contact_no은 사용자가 입력한 번호
			res = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	
	
	// [ CRUD 메소드 3 : 이름으로 연락처 조회 ]
	// 반환값은 List<ContactDTO> -> 정보들을 합친 걸 List로 묶음
	// 매개변수 String name -> 스캐너로 입력한 이름
	public List<ContactDTO2> selectContactsByName(String name) { 
		
		List<ContactDTO2> contactsList = new ArrayList<ContactDTO2>();
		
	try {
		con = getConnection();
		sql = "SELECT CONTACT2_NO, NAME, TEL, EMAIL, ADDRESS";
		sql += " FROM CONTACT2_TBL";
		sql += " WHERE NAME = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		rs = ps.executeQuery();
		
		while(rs.next()) {  // rs.next..음 한 행씩 받아온다는 뜻이었나 (엔터는 반영되지 않는)
			
			// rs 객체는 한 행씩 처리
			ContactDTO2 contact = new ContactDTO2();
			contact.setContact_no(rs.getInt("CONTACT2_NO"));
			contact.setName(rs.getString("NAME"));  // 조회된 쿼리 결과를 담은 ResultSet객체가 NAME값을 겟함 -> DTO 클래스에 설정
			contact.setTel(rs.getString("TEL"));
			contact.setEmail(rs.getString("EMAIL"));
			contact.setAddress(rs.getString("ADDRESS"));
			
			contactsList.add(contact);   // 각 쿼리의 칼럼마다 겟한 데이터를 합쳐서 List로 묶음
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	return contactsList;
	
	}
	
	
	
	// [ CRUD 메소드 4 : 개인정보 수정 ]
	// 반환값은 0(실패) 혹은 1(성공)
	// 매개변수 ContactDTO contact 객체에는 개인정보가(name, tel, email, address)가 저장되어 있음
	public int updateContact(ContactDTO2 contact) {
		
		try {
			
			con = getConnection();
			sql = "UPDATE CONTACT2_TBL";
			sql += "  SET NAME = ?, TEL = ?, EMAIL = ?, ADDRESS = ?";
			sql += " WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql); // 해당 데이터(쿼리)를 연결해줌
			ps.setString(1, contact.getName()); // 입력받은 개인정보전체contact을 셋팅
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			ps.setInt(5, contact.getContact_no());
			res = ps.executeUpdate(); // 전달받은 쿼리문을 실행할 수 있는 메소드를 통해 한 행씩 담음
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	
	// [ CRUD 메소드 5 : 연락처 NO를 이용하여 개인정보 조회 ]
	// 반환값은 ContactDTO
	// 매개변수는 int contact_no 스캐너로 입력받은 고유 번호
	public ContactDTO2 selectContactByNo(int contact_no) {
		
		ContactDTO2 contact = null;
		
		try {
			con = getConnection();
			sql = "SELECT CONTACT2_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += " FROM CONTACT2_TBL";
			sql += " WHERE CONTACT2_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no); // contact_no에 입력받은 no를 저장
			rs = ps.executeQuery();
			
			if (rs.next()) {
				contact = new ContactDTO2();
				contact.setContact_no(contact_no); // 스캐너로 입력받은 번호를 셋팅
				contact.setName(rs.getString(2)); // ResultSet 조회한 쿼리의 2번째 string값은 이름 -> 이름의 데이터를 셋팅
				contact.setTel(sql);
				contact.setEmail(sql);
				contact.setAddress(sql);
			}
			
		}catch (Exception E) {
			E.printStackTrace();
		} finally {
			close();
		}
		
		return contact;  // 셋팅을 끝낸 개인정보 전체의 데이터를 return
	}
	
	
	
	// [ CRUD 메소드 6 : 전체 개인정보 조회 ]
	// 반환값은 List<ContactDTO>
	// 매개변수는 없음
	public List<ContactDTO2> selectAllContacts() {
		
		List<ContactDTO2> contactList = new ArrayList<ContactDTO2>();
		
		try {
			con = getConnection();
			sql = "SELECT CONTACT2_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += " FROM CONTACT2_TBL";
			sql += "ORDER BY CONTACT2_TBL DESC";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				// rs가 한 줄씩 읽어드린 것을 set해주고
				ContactDTO2 contact = new ContactDTO2();
				contact.setContact_no(rs.getInt("CONTACT_NO"));
				contact.setName(rs.getString("NAME"));
				contact.setTel(rs.getString("TEL"));
				contact.setEmail(rs.getString("EMAIL"));
				contact.setAddress(rs.getString("ADDRESS"));
				// 한 줄씩 더해주는 작업 List!
				contactList.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return contactList;
	}
	
	
}
