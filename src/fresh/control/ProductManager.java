package fresh.control;

import java.util.ArrayList;
import java.util.List;

import fresh.model.BeanProduct;
import fresh.util.BaseException;
import fresh.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
public class ProductManager {
java.sql.ResultSet rs=null;
java.sql.PreparedStatement pst=null;
Connection conn=null;
String sql=null;

    public List<BeanProduct> loadAllProduct()throws BaseException {
		// TODO Auto-generated method stub  
    	List<BeanProduct> result=new ArrayList<BeanProduct>();
	try {
		conn=DBUtil.getConnection();
	    sql="select *from product_tbl ";
	    pst=conn.prepareStatement(sql);
	    rs=pst.executeQuery();
	    while(rs.next()) {
	    	BeanProduct bp=new BeanProduct();
	    	bp.setId(rs.getString(1));
	    	bp.setCategory(rs.getString(2));
	    	bp.setProductName(rs.getString(3));
	    	bp.setVipPrice(rs.getDouble(4));
	    	bp.setNum(rs.getInt(5));
	    	bp.setInformation(rs.getString(6));
	    	bp.setOriPrice(rs.getDouble(7));
	    	result.add(bp);
	    }
	    
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

	public List<BeanProduct> loadProduct(String productName)throws BaseException {
		// TODO Auto-generated method stub
	  	List<BeanProduct> result=new ArrayList<BeanProduct>();
		try {
			conn=DBUtil.getConnection();
		    sql="select *from product_tbl where product_name=? ";
		    pst=conn.prepareStatement(sql);
		    pst.setString(1, productName);
		    rs=pst.executeQuery();
            if(!rs.next())return null;
		    do {
		    	BeanProduct bp=new BeanProduct();
		    	bp.setId(rs.getString(1));
		    	bp.setCategory(rs.getString(2));
		    	bp.setProductName(rs.getString(3));
		    	bp.setVipPrice(rs.getDouble(4));
		    	bp.setNum(rs.getInt(5));
		    	bp.setInformation(rs.getString(6));
		    	bp.setOriPrice(rs.getDouble(7));
		    	result.add(bp);
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
