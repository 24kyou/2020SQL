package fresh.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fresh.model.BeanDish;
import fresh.model.BeanProduct;
import fresh.util.BaseException;
import fresh.util.DBUtil;

public class DishManager {
	java.sql.Connection conn=null;
	java.sql.PreparedStatement pst=null;
	java.sql.ResultSet rs=null;
	String sql=null;
	public List<BeanDish> loadAllDish() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanDish> result=new ArrayList<BeanDish>();
		try {
			conn=DBUtil.getConnection();
			sql="select *from dish_tbl";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(!rs.next())return null;
			do {
			BeanDish bd=new BeanDish();
			bd.setDish_id(rs.getString(1));
			bd.setDish_name(rs.getString(2));
			bd.setDish_price(rs.getDouble(3));
			bd.setDish_num(rs.getInt(4));
			bd.setRecommend_values(rs.getInt(5));
			bd.setCategories(rs.getString(6));
			bd.setInformation(rs.getString(7));
			result.add(bd);
			}while(rs.next());
			pst.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
		
	}
	public List<BeanDish> loadProduct(String productName)throws BaseException {
		// TODO Auto-generated method stub
		List<BeanDish> result=new ArrayList<BeanDish>();
		try {
			conn=DBUtil.getConnection();
		    sql="select dish_id,dish_name from dish_tbl where dish_name=? ";
		    pst=conn.prepareStatement(sql);
		    pst.setString(1, productName);
		    rs=pst.executeQuery();
            if(!rs.next())return null;
		    do {
		    	BeanDish bd=new BeanDish();
		    	bd.setDish_id(rs.getString(1));
		    	bd.setDish_name(rs.getString(2));
		    	bd.setDish_price(rs.getDouble(3));
		    	bd.setDish_num(rs.getInt(4));
		    	bd.setRecommend_values(rs.getInt(5));
		    	bd.setInformation(rs.getString(6));
		    	result.add(bd);
		    }while(rs.next());
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
}
