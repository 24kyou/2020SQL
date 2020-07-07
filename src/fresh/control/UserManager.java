package fresh.control;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fresh.util.*;
import fresh.model.BeanUser;

public class UserManager {
java.sql.Connection conn=null;
java.sql.PreparedStatement pst=null;
java.sql.ResultSet rs=null;
String sql=null;
java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public BeanUser loadUser(String userid) throws BaseException, DbException, BusinessException{
		// TODO Auto-generated method stub
		if("".equals(userid)||userid==null)throw new BusinessException("账号名不能为空");
		BeanUser bu=new BeanUser();
		try {
			
		   conn=DBUtil.getConnection();
		   sql="SELECT * from user_tbl WHERE user_id=?";
		   pst=conn.prepareStatement(sql);
		   pst.setString(1, userid);
		   rs=pst.executeQuery();
		   if(!rs.next()) throw new BusinessException("账号不存在");
		   
		   bu.setUser_id(rs.getString(1));
		   bu.setUser_name(rs.getString(2));
		   bu.setUser_gen(rs.getString(3));
		   bu.setUser_pwd(rs.getString(4));
		   bu.setUser_tel(rs.getString(5));
		   bu.setUser_city(rs.getString(6));
		   if(rs.getInt(8)==1)bu.setVip("vip");
		   else bu.setVip("notvip");
		   bu.setVip_end_time(rs.getTimestamp(9));
		   pst.close();
		   rs.close();
		   return bu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DbException(e);
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public List<BeanUser> loadBeanUsers(){
		// TODO Auto-generated method stub
		List<BeanUser> result =new ArrayList<BeanUser>();
		try {
			result.add(this.loadUser(BeanUser.currentLoginUser.getUser_id()));
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	public void changcity(String newProvince, String newCity, String newArea) throws BaseException {
		// TODO Auto-generated method stub
		if("".equals(newProvince)||newProvince==null||newProvince.length()>10||newProvince.length()<3)
			throw new BaseException("省名长度需在3-20个字");
		if("".equals(newCity)||newCity==null||newCity.length()>10||newCity.length()<3)
			throw new BaseException("市名长度需在3-20个字");
		if("".equals(newArea)||newArea==null||newArea.length()>10||newArea.length()<3)
			throw new BaseException("区/街道/县长度需在3-20个字");
		String city=newProvince+newCity+newArea;
		try {
			conn.setAutoCommit(false);
			conn=DBUtil.getConnection();
			String sql="select user_city from user_tbl where user_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,BeanUser.currentLoginUser.getUser_id());
			rs=pst.executeQuery();
			if(!rs.next())throw new BaseException("city 数据库错误");
			rs.close();
			pst.close();
			
			sql="update  user_tbl set user_city=? where user_id=?";
			pst=conn.prepareStatement(sql);
		    pst.setString(1, city);
		    pst.setString(2, BeanUser.currentLoginUser.getUser_id());
		    pst.execute();
			pst.close();
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
	}
	public void changPwd(String oldPwd, String pwd1, String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(oldPwd.equals(pwd1))throw new BaseException("新密码不能与旧密码一致");
		if("".equals(oldPwd)||oldPwd==null||oldPwd.length()>255||oldPwd.length()<6) 
			throw new BaseException("旧密码长度为6-255之间");
		if("".equals(pwd1)||pwd1==null||pwd1.length()>255||pwd1.length()<6) 
			throw new BaseException("新密码长度为6-255之间");
		if(!pwd1.equals(pwd2))throw new BaseException("两次新输入密码不相同");
		try {
			conn=DBUtil.getConnection();
			sql="select user_pwd from user_tbl where user_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, BeanUser.currentLoginUser.getUser_id());
			rs=pst.executeQuery();
		    if(!rs.next())throw new BaseException("pwd DateBase Error");
		    if(rs.getString(1)!=oldPwd)throw new BaseException ("旧密码错误");
		    rs.close();
		    pst.close();
		    
		    sql="update user_tbl set user_pwd=? where user_id=?";
		    pst=conn.prepareStatement(sql);
		    pst.setString(1, pwd1);
		    pst.setString(2, BeanUser.currentLoginUser.getUser_id());
		    pst.execute();
		    pst.close();
		    
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
	}
	public void changTel(String tel) throws BaseException {
		// TODO Auto-generated method stub
		if("".equals(tel)||tel==null||tel.length()>11||tel.length()<1)
			throw new BaseException("电话号码长度为1-11之间");
		if(tel==BeanUser.currentLoginUser.getUser_tel())
			throw new BaseException("新号码不能与旧号码相同");
		try {
			conn=DBUtil.getConnection();
			sql="update user_tbl set user_tel=? where user_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, tel);
			pst.setString(2, BeanUser.currentLoginUser.getUser_id());
			pst.execute();
			pst.close();
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
		
	}

	public void creatUser(BeanUser user)throws BaseException, BusinessException {
		// TODO Auto-generated method stub
//		String user_idNow=new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
//		int user_idnum;
		int gen;
//		String userId;
		if(user.getUser_gen()=="男")gen=1;
		else gen=0;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			sql="select * from user_tbl where user_tel=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUser_tel());
			rs=pst.executeQuery();
			if(rs.next())throw new BusinessException("电话号码已存在");
			rs.close();
			pst.close();
			
			sql="select * from user_tbl where user_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUser_id());
			rs=pst.executeQuery();
			if(rs.next())throw new BusinessException("用户账号已存在");
			rs.close();
			pst.close();
			
			sql="SELECT DISTINCT COUNT(user_id) FROM user_tbl GROUP BY user_id";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
//			if(!rs.next())user_idnum=1;
//			else  user_idnum=rs.getInt(1)+1;
//		    userId=user_idNow+String.format("%04d", user_idnum);
		    rs.close();
		    pst.close();
		    
		    sql="insert into user_tbl(user_id,user_name,user_gen,user_pwd,user_tel,user_city,user_reg_time,is_vip) "
		    		+ "values(?,?,?,?,?,?,?,0)";
		    pst=conn.prepareStatement(sql);
		    pst.setString(1, user.getUser_tel());
		    pst.setString(2, user.getUser_name());
		    pst.setInt(3, gen);
		    pst.setString(4, user.getUser_pwd());
		    pst.setString(5, user.getUser_tel());
		    pst.setString(6, user.getUser_city().toString());
		    pst.setTimestamp(7, new Timestamp(new Date().getTime()));
		    pst.execute();
		    pst.close();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}catch(BusinessException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}throw e;
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	}
