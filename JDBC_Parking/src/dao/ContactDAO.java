package dao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import dto.ContactDTO;

public class ContactDAO {
	
	private static ContactDAO dao = new ContactDAO();
	private ContactDAO() {}
	
	public static ContactDAO getInstance() {
		return dao;
	}
	
	public void 목록보기() { }
	
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private int res;
	
	
// 공통 메소드 ////////////////////////////////////////////////////////////
	
	// [공통 메소드 1 - Connection 얻기]
	private Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Properties p = new Properties();
			p.load(new BufferedInputStream(new FileInputStream("db.properties")));
			
			con = DriverManager.getConnection(p.getProperty("url"), p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}


	// [공통 메소드 2 - 사용한 자원 close ]
	public void close() {  // 자원을 얻어야만 닫을 수 있으니까 굳이 private 처리 x
		
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
// CRUD 메소드 ////////////////////////////////////////////////////////////
	
	// [ CRUD 메소드 1 - 차량 등록 ]
	public int insertCar(ContactDTO car) {
		
		try {
			
			con = getConnection();
			sql = "INSERT INTO PARKING_TBL(CAR_NO, MODEL, NUM) VALUES(PARKING_SEQ.NEXTVAL, ?, ?)"; // 고유번호는 시퀀스로!
			ps = con.prepareStatement(sql);
			ps.setString(1, car.getModel());
			ps.setInt(1, car.getNum());
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
}



