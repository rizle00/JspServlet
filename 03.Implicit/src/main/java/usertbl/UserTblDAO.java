package usertbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;


public class UserTblDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean isConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hanul";
		String password = "0000";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				if(!conn.isClosed()) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			return false;
	} 
	// 전체 목록 조회
	public ArrayList<UserTblDTO> selectList(){
		ArrayList<UserTblDTO> list = new ArrayList<>();
		
		if(!isConnection()) return list;
		try {
			ps= conn.prepareStatement("select * from usertbl ");
			rs = ps.executeQuery();
			while(rs.next()) {
				UserTblDTO dto = new UserTblDTO();
				dto.setUsername(rs.getString("USERNAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setBirthday(rs.getInt("BIRTHYEAR"));
				dto.setMobile(rs.getString("MOBILE"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public UserTblDTO selectOne(String name) {
		UserTblDTO dto = new UserTblDTO();
		if(!isConnection()) return dto;
		try {
			ps= conn.prepareStatement("select * from usertbl where username = ? ");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setUsername(rs.getString("USERNAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setBirthday(rs.getInt("BIRTHYEAR"));
				dto.setMobile(rs.getString("MOBILE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void update(String USERNAME, String ADDRESS, int BIRTHYEAR, String MOBILE) {
//		dto로 받아와도 되나 그냥 귀찮아서 이렇게 함..
		if(isConnection()==false) return;
		try {
			ps= conn.prepareStatement("update usertbl set ADDRESS = ? ,BIRTHYEAR = ?, MOBILE = ? where USERNAME = ? ");
			ps.setString(1, ADDRESS);
			ps.setInt(2, BIRTHYEAR);
			ps.setString(3, MOBILE);
			ps.setString(4, USERNAME);
			int result = ps.executeUpdate();
//			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(String USERNAME) {
		if(isConnection()==false) return;
		try {
			ps= conn.prepareStatement("delete from usertbl where USERNAME = ? ");
			ps.setString(1, USERNAME);
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(UserTblDTO dto) {
		if(isConnection()==false) return;
		try {
			ps= conn.prepareStatement("insert into usertbl values (?, ?, ?, ?)");
			ps.setString(1, dto.getUsername());
			ps.setInt(2, dto.getBirthday());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getMobile());
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


