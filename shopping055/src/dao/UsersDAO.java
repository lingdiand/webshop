package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import util.JDBCutils;

public class UsersDAO {
	// 插入数据（注册）
	public static boolean insert(User user1) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCutils.getConnection();
			String name = user1.getName();
			String password = user1.getPassword();
			String number = user1.getNumber();
			String sql = "insert into users()" + "values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, number);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutils.release(stmt, conn);
		}
		return true;

	}

	// 判断用户是否存在
	public static boolean findUser(String username, String password)   {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User userInfo=null;
		boolean b=true;
		try {
			conn = JDBCutils.getConnection();
			String sql = "select * from users where 用户名=? and 密码=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs  = stmt.executeQuery();
			if(rs.next()){
				userInfo = new User();
				userInfo.setName(rs.getString("用户名"));
				userInfo.setPassword(rs.getString("密码"));
			}
			if(userInfo != null){
				b=true;
			}else {

				b=false;
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			JDBCutils.release(rs,stmt, conn);
		}
		return b;
		
	}
}
