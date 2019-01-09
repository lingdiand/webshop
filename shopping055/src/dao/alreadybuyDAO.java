package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cart;
import bean.Goods;
import bean.alreadybuy;
import util.JDBCutils;

public class alreadybuyDAO {
	//插入数据
	public static void insert(String id) {
		//通过id获取cart表中的数据,将cart表中的值赋值给alreadybuy表
		ShoppingcartDAO cartDao = new ShoppingcartDAO();
		Cart cart = cartDao.getCartId(id);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCutils.getConnection();
			String sql = "insert into alreadybuy values(?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, cart.getUsername());
			stmt.setString(2, cart.getGoodname());
			stmt.setString(3, cart.getNum());
			stmt.setString(4, cart.getId());
			stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JDBCutils.release(rs,stmt, conn);
		}
	}
		//通过用户名获取购买信息
		public ArrayList<alreadybuy> getAllAlready(Object name){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<alreadybuy> list = new ArrayList<>(); 
			try {
				conn = JDBCutils.getConnection();
				String sql = "select * from alreadybuy where 用户名=?";
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, (String)name);
				rs=stmt.executeQuery();
				while(rs.next()) {
					alreadybuy item =new alreadybuy();
					item.setGoodname(rs.getString("商品名"));
					item.setId(rs.getString("商品id"));
					item.setNum(rs.getString("购买数量"));
					item.setUsername(rs.getString("用户名"));
					list.add(item);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCutils.release(rs,stmt, conn);
			}
			return list; 
		}
}
