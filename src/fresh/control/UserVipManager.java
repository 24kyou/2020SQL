package fresh.control;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import fresh.model.BeanUser;
import fresh.util.BaseException;
import fresh.util.DBUtil;

public class UserVipManager {
   private int bevip;
   private int VipKeepTime=60;
   java.sql.ResultSet rs=null;
   java.sql.PreparedStatement pst=null;
   Connection conn=null;
   String sql=null;
   DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	public void changVip(boolean beVip)throws BaseException {
		// TODO Auto-generated method stub
		if(beVip==true) bevip=1;
		else bevip=0;
		Date date=new Date();
			    Calendar calendar=new GregorianCalendar();
			    calendar.setTime(date);
			    calendar.add(calendar.DATE, VipKeepTime);
			    date=calendar.getTime();
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			if(bevip==1) {
				sql="update user_id set is_vip=1 where user_id=?";
			    pst=conn.prepareStatement(sql);
			    pst.setString(1, BeanUser.currentLoginUser.getUser_id());
			    pst.execute();
			    pst.close();
			    
			    sql="update user_id set vip_end_time=? where user_id=?";
			    pst=conn.prepareStatement(sql);
			    pst.setTimestamp(1, new Timestamp(date.getTime()));
			    pst.setString(2, BeanUser.currentLoginUser.getUser_id());
			    pst.execute();
			    pst.close();
			    
			  }
			else if(bevip==0) {
				sql="update user_id set is_vip=0 where user_id=?";
			    pst=conn.prepareStatement(sql);
			    pst.setString(1, BeanUser.currentLoginUser.getUser_id());
			    pst.execute();
			    pst.close();
			}
			conn.commit();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

}
