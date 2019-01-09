package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Goods;
import util.JDBCutils;
public class GoodsDAO {
	//获取商品信息
	public ArrayList<Goods> getAllGoods(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<>(); 
		try {
			conn = JDBCutils.getConnection();
			String sql = "select * from goods";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Goods item =new Goods();
				item.setId(rs.getInt("商品id"));
				item.setName(rs.getString("商品名"));
				item.setPrice(rs.getInt("价格"));
				item.setText(rs.getString("商品描述"));
				item.setPhoto(rs.getString("图片"));
				list.add(item);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCutils.release(rs,stmt, conn);
		}
		return list; 
	}
	//根据商品id获取商品信息
	public Goods getGoodId(Object id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Goods item=new Goods();
		try {
			conn = JDBCutils.getConnection();
			String sql = "select * from goods where 商品id=? ";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, (String) id);
			rs=stmt.executeQuery();
			if(rs.next()) {
				item.setId(rs.getInt("商品id"));
				item.setName(rs.getString("商品名"));
				item.setPrice(rs.getInt("价格"));
				item.setText(rs.getString("商品描述"));
				item.setPhoto(rs.getString("图片"));
				return item;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCutils.release(rs,stmt, conn);
		}
		
		return item;
	}
}
