package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDB {

	public void joinInsert (String eName, String eId, String ePw) {
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/ExchangeDB?useSSL=false";
		String dbId = "root";
		String dbPw = "rootroot";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String sql = "INSERT into ExchangeTBL (eName, eId, ePw) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eName);
			pstmt.setString(2, eId);
			pstmt.setString(3, ePw);
			pstmt.executeUpdate();
			System.out.println("MemberDB joinInsert() 메서드 실행 완료!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public boolean idDuplicateCheck (String eId) {
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/ExchangeDB?useSSL=false";
		String dbId = "root";
		String dbPw = "rootroot";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String sql = "SELECT eId from ExchangeTBL WHERE eId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eId);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("MemberDB idDuplicateCheck() 메서드 실행 완료!");
				return true;
			}else {
				System.out.println("MemberDB idDuplicateCheck() 메서드 실행 완료!");
				return false;
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean loginSelect (String eId, String ePw) {
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/ExchangeDB?useSSL=false";
		String dbId = "root";
		String dbPw = "rootroot";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String sql = "SELECT * from ExchangeTBL WHERE eId = ? and ePw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eId);
			pstmt.setString(2, ePw);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("로그인 완료.");
				return true;
			} else {
				System.out.println("일치하는 아이디나 비밀번호가 없습니다.");
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
		
	
	
}
