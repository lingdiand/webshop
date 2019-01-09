package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cart;
import bean.Goods;
import bean.User;
import util.JDBCutils;

public class ShoppingcartDAO {
	//根据id获取商品信息
	public static void getGoodId(String username,String id,String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cart cart=new Cart();
		try {
			conn = JDBCutils.getConnection();
			String sql = "select * from goods where 商品id=? ";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,id);
			rs=stmt.executeQuery();
			if(rs.next()) {
				cart.setUsername(username);
				cart.setGoodname(rs.getString("商品名"));
				cart.setNum(num);
				cart.setId(id);
				cart.setPrice(rs.getString("价格"));
				insert(cart);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	finally {
			JDBCutils.release(rs,stmt, conn);
		}
	}
	//将数据添加到shoppingcart数据表中
	public static boolean insert(Cart cart) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCutils.getConnection();
			String sql = "insert into shoppingcart values(?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, cart.getUsername());
			stmt.setString(2, cart.getGoodname());
			stmt.setString(3, cart.getNum());
			stmt.setString(4, cart.getId());
			stmt.setString(5, cart.getPrice());
			stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	//获取购物车所有信息
	public ArrayList<Cart> getAllGoods(Object name){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cart> list = new ArrayList<>(); 
			try {
				conn = JDBCutils.getConnection();
				String sql = "select * from shoppingcart where 用户名=?";
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, (String)name);
				rs=stmt.executeQuery();
				while(rs.next()) {
					Cart item =new Cart();
					item.setUsername(rs.getString("用户名"));
					item.setGoodname(rs.getString("商品名"));
					item.setNum(rs.getString("购买数量"));
					item.setId(rs.getString("商品id"));
					item.setPrice(rs.getString("单价"));
					list.add(item);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCutils.release(rs,stmt, conn);
			}
			return list; 
	}	
	//根据id删除商品信息
	public static void delGoodId(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCutils.getConnection();
			String sql = "delete from shoppingcart where 商品id=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//通过id获取购物车信息
	public static Cart getCartId(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cart cart=new Cart();
		try {
			conn = JDBCutils.getConnection();
			String sql = "select * from shoppingcart where 商品id=? ";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,id);
			rs=stmt.executeQuery();
			if(rs.next()) {
				cart.setGoodname(rs.getString("商品名"));
				cart.setUsername(rs.getString("用户名"));
				cart.setNum(rs.getString("购买数量"));
				cart.setId(rs.getString("商品id"));
				cart.setPrice(rs.getString("单价"));
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	finally {
			JDBCutils.release(rs,stmt, conn);
		}
		return cart;
	}
}