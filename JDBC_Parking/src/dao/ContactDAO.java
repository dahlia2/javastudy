package dao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.ContactDTO;

public class ContactDAO {    // DB의 data에 접근하기 위한 객체
	
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
	public int insertCar(ContactDTO car) {   // 매개변수 car에는 차량번호와 모델명이 들어있음
		
		try {
			 
			con = getConnection();  // 공통메소드1 - 자원 얻기
			sql = "INSERT INTO PARKING(CAR_NO, NUM, MODEL) VALUES(PARKING_SEQ.NEXTVAL, ?, ?)"; // 고유번호는 시퀀스로!
			ps = con.prepareStatement(sql);
			ps.setString(1, car.getNum());
			ps.setString(2, car.getModel());
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();  // 공통메소드2 - 자원 닫기
		}
		return res;
	}
	
	
	
	// [ CRUD 메소드 2 - (차량 고유No으로) 차량 제거 ]
	public int deleteCar(int car_no) {
		
		try { 
			
			con = getConnection();
			sql = "DELECT FROM PARKING WHERE CAR_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, car_no);
			res = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(); 
		}
		return res;
}
	
	
	
	// [ CRUD 메소드 3 - 번호를 통해 차량 조회 ]
	public List<ContactDTO> selectCarsByname(String num) {
		List<ContactDTO> carList = new ArrayList<ContactDTO>();
		
		try {
			con = getConnection();
			sql = "SELECT CAR_NO, NUM, MODEL";
			sql += " FROM PARKING";
			sql += "ORDER BY PARKING DESC"; // 내림차순으로 정렬
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ContactDTO car = new ContactDTO();
				car.setCar_no(rs.getInt("CONTACT_NO"));
				// 쿼리 각 칼럼의 데이터 값을 가져와서 GET하고 CONTACTDTO를 통해 SET한 후
				// car 변수에 저장
				car.setNum(rs.getString("NUM"));
				car.setModel(rs.getString("MODEL"));
				
				// 각 한 줄씩 더해주는 작업
				carList.add(car);
			} // while문 끝
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return carList;
		}
	
}



