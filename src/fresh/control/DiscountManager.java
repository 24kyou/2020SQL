package fresh.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fresh.model.BeanDiscount;
import fresh.util.BaseException;
import fresh.util.DBUtil;

public class DiscountManager {
java.sql.Connection conn=null;
java.sql.PreparedStatement pst=null;
java.sql.ResultSet rs=null;
java.sql.Statement st=null;
String sql=null;
	  public List<BeanDiscount> loadcoDiscount()throws BaseException {
		// TODO Auto-generated method stub 
		  List<BeanDiscount> result=new ArrayList<BeanDiscount>();
		  try {
			 
			conn=DBUtil.getConnection();
			sql="select * from co_tbl WHERE end_date > NOW()";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				BeanDiscount bd=new BeanDiscount();
				bd.setType(rs.getString(1));
				bd.setDiscount_id(rs.getString(1));
				bd.setProduct_id(rs.getString(2));
				bd.setCotent(rs.getString(3));
				bd.setCo_least_amont(rs.getDouble(4));
				bd.setCo_relief_amount(rs.getDouble(5));
				bd.setBegin_time(rs.getDate(6));
				bd.setEnd_time(rs.getDate(7));
				result.add(bd);
			}
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
	  public List<BeanDiscount> loadfdDiscount()throws BaseException {
			// TODO Auto-generated method stub 
			  List<BeanDiscount> result=new ArrayList<BeanDiscount>();
			  try {
				 
				conn=DBUtil.getConnection();
				sql="select * from fd_tbl WHERE end_date > NOW()";
				pst=conn.prepareStatement(sql);
				rs=pst.executeQuery();
				while(rs.next()) {
					BeanDiscount bd=new BeanDiscount();
					bd.setType(rs.getString(1));
					bd.setDiscount_id(rs.getString(1));
					bd.setProduct_id(rs.getString(2));
					bd.setCotent(rs.getString(3));
					bd.setFd_discount(rs.getDouble(4));
					bd.setFd_num(rs.getInt(5));
					bd.setBegin_time(rs.getDate(6));
					bd.setEnd_time(rs.getDate(7));
					result.add(bd);
				}
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

	  public List<BeanDiscount> loadProDiscount()throws BaseException {
			// TODO Auto-generated method stub 
			  List<BeanDiscount> result=new ArrayList<BeanDiscount>();
			  try {
				 
				conn=DBUtil.getConnection();
				sql="select * from pro_tbl where end_date > NOW() ";
				pst=conn.prepareStatement(sql);
				rs=pst.executeQuery();
				while(rs.next()) {
					BeanDiscount bd=new BeanDiscount();
					bd.setType(rs.getString(1));
					bd.setDiscount_id(rs.getString(1));
					bd.setProduct_id(rs.getString(2));
					bd.setCotent(rs.getString(3));
					bd.setPro_amount(rs.getDouble(4));
					bd.setPro_num(rs.getInt(5));
					bd.setBegin_time(rs.getDate(6));
					bd.setEnd_time(rs.getDate(7));
					result.add(bd);
				}
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
	  public List<BeanDiscount> loadDiscount(String product_id)throws BaseException {
			// TODO Auto-generated method stub 
			  List<BeanDiscount> result=new ArrayList<BeanDiscount>();
			  String sql1,sql2,sql3;
			  sql1="select * from pro_tbl where end_date > NOW() and product_id=? ";
			  sql2="select * from co_tbl where end_date > NOW() and product_id=? ";
			  sql3="select * from pro_tbl where end_date > NOW() and product_id=? ";
			  try {
				 
				conn=DBUtil.getConnection();
				pst=conn.prepareStatement(sql1);
				pst.setString(1, product_id);
				rs=pst.executeQuery();
				while(rs.next()) {
					BeanDiscount bd=new BeanDiscount();
					bd.setDiscount_id(rs.getString(1));
					bd.setProduct_id(rs.getString(2));
					bd.setCotent(rs.getString(3));
					bd.setType(rs.getString(1));
					bd.setBegin_time(rs.getDate(6));
					bd.setEnd_time(rs.getDate(7));
					result.add(bd);
				}
				pst.close();
				rs.close();
				
				pst=conn.prepareStatement(sql2);
				pst.setString(1, product_id);
				rs=pst.executeQuery();
				while(rs.next()) {
					BeanDiscount bd=new BeanDiscount();
					bd.setDiscount_id(rs.getString(1));
					bd.setProduct_id(rs.getString(2));
					bd.setCotent(rs.getString(3));
					bd.setType(rs.getString(1));
					bd.setBegin_time(rs.getDate(6));
					bd.setEnd_time(rs.getDate(7));
					result.add(bd);
				}
				pst.close();
				rs.close();
				
				pst=conn.prepareStatement(sql3);
				pst.setString(1, product_id);
				rs=pst.executeQuery();
				while(rs.next()) {
					BeanDiscount bd=new BeanDiscount();
					bd.setDiscount_id(rs.getString(1));
					bd.setProduct_id(rs.getString(2));
					bd.setCotent(rs.getString(3));
					bd.setType(rs.getString(1));
					bd.setBegin_time(rs.getDate(6));
					bd.setEnd_time(rs.getDate(7));
					result.add(bd);
				}
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
	  public List<BeanDiscount> loadDiscount(String product_id,String type)throws BaseException {
			// TODO Auto-generated method stub
		 List<BeanDiscount> result=new ArrayList<BeanDiscount>();
		 
		  try {
			  conn=DBUtil.getConnection();
	if(type.equals("co")) {
			 if(product_id.charAt(0)=='p') {
			sql="select product_tbl.product_id,product_tbl.product_name,\r\n" + 
					"coupons_id,begin_date,end_date \r\n" + 
					"from product_tbl,co_tbl where product_tbl.product_id=co_tbl.product_id\r\n" + 
					"and product_tbl.product_id=? and end_date > NOW()";
			}else if(product_id.charAt(0)=='d') {
				sql="select dish_tbl.dish_id,dish_tbl.dish_name,\r\n" + 
						"coupons_id,begin_date,end_date \r\n" + 
						"from dish_tbl,co_tbl where dish_tbl.dish_id=co_tbl.product_id\r\n" + 
						"and dish_tbl.dish_id=001 and end_date > NOW()";
			}
			 }
	else if(type.equals("fd")) {
		 if(product_id.charAt(0)=='p') 
			 sql="select product_tbl.product_id,product_tbl.product_name,\r\n" + 
			 		"discount_id,begin_time,end_time \r\n" + 
			 		"from product_tbl,fd_tbl where product_tbl.product_id=fd_tbl.product_id\r\n" + 
			 		"and product_tbl.product_id=001 and end_time > NOW()";
		 else if(product_id.charAt(0)=='d')
			 sql="select dish_tbl.dish_id,dish_tbl.dish_name,\r\n" + 
			 		"discount_id,begin_time,end_time \r\n" + 
			 		"from dish_tbl,fd_tbl where dish_tbl.dish_id=fd_tbl.product_id\r\n" + 
			 		"and dish_tbl.dish_id=001 and end_time > NOW()";
	}
	else if(type.equals("pro")) {
		 if(product_id.charAt(0)=='p') 
			sql="select product_tbl.product_id,product_tbl.product_name,\r\n" + 
					"pro_id,begin_time,end_time \r\n" + 
					"from product_tbl,pro_tbl where product_tbl.product_id=pro_tbl.product_id\r\n" + 
					"and product_tbl.product_id=001 and end_time > NOW()";
		 else if(product_id.charAt(0)=='d')
			 sql="select dish_tbl.dish_id,dish_tbl.dish_name,\r\n" + 
			 		"pro_id,begin_time,end_time \r\n" + 
			 		"from dish_tbl,pro_tbl where dish_tbl.dish_id=pro_tbl.product_id\r\n" + 
			 		"and dish_tbl.dish_id=001 and end_time > NOW()";
	}
			pst=conn.prepareStatement(sql);
			pst.setString(1, product_id);
			rs=pst.executeQuery();
			if(!rs.next())return null;
			 do{
				BeanDiscount bd=new BeanDiscount();
				bd.setProduct_id(rs.getString(1));	
				bd.setProduct_name(rs.getString(2));
				bd.setDiscount_id(rs.getString(3));
				bd.setType(type);
				bd.setBegin_time(rs.getDate(4));
				bd.setEnd_time(rs.getDate(5));
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
	  }

