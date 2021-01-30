package com.springbook.biz.user.impl;

import java.sql.*;
import com.springbook.biz.common.*;
import com.springbook.biz.user.UserVO;

public class userDAO {
	// JDBC 관련 변수 	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어들 
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUSer(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리 ");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("Name"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return user;
	}


}
