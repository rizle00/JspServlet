package kmj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAO {
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
	
	public ArrayList<DTO> selectList(){
		ArrayList<DTO> list = new ArrayList<>();
		
		if(!isConnection()) return list;
		try {
			ps= conn.prepareStatement("select * from usertbl ");
			rs = ps.executeQuery();
			int i=0;
			while(rs.next()) {
				DTO dto = new DTO();
				i++;
				dto.setIdx(i);
				dto.setUsername(rs.getString("USERNAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setBirthyear(rs.getInt("BIRTHYEAR"));
				dto.setMobile(rs.getString("MOBILE"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insert(DTO dto) {
		if(isConnection()==false) return;
		try {
			ps= conn.prepareStatement("insert into usertbl values (?, ?, ?, ?)");
			ps.setString(1, dto.getUsername());
			ps.setInt(2, dto.getBirthyear());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getMobile());
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DTO selectOne(String username, String idx) {
		DTO dto = new DTO();
		if(!isConnection()) return dto;
		try {
			ps= conn.prepareStatement("select * from usertbl where username = ? ");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setIdx(Integer.parseInt(idx));
				dto.setUsername(rs.getString("USERNAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setBirthyear(rs.getInt("BIRTHYEAR"));
				dto.setMobile(rs.getString("MOBILE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public void update(DTO dto) {
		if(isConnection()==false) return;
		try {
			ps= conn.prepareStatement("update usertbl set ADDRESS = ? ,BIRTHYEAR = ?, MOBILE = ? where USERNAME = ? ");
			ps.setString(1, dto.getAddress());
			ps.setInt(2, dto.getBirthyear());
			ps.setString(3, dto.getMobile());
			ps.setString(4, dto.getUsername());
			int result = ps.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int delete(String USERNAME) {
		if(isConnection()==false) return 0;
		try {
			ps= conn.prepareStatement("delete from usertbl where USERNAME = ? ");
			ps.setString(1, USERNAME);
			int result = ps.executeUpdate();
			System.out.println(result);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
