package fresh.model;

import java.util.Date;


public class BeanUser {
public static BeanUser currentLoginUser=null;
public String user_id;
public String user_name;
public String user_gen;//仅设置为男/女
public String user_pwd;
public String user_tel;
public String user_city;
public Date user_reg_time;//用户注册时间，用sql中的now()语句,没有设置getters/setters
public String vip;//vip or NotVip
public Date vip_end_time;



public String getUser_gen() {
	return user_gen;
}
public void setUser_gen(String user_gen) {
	this.user_gen = user_gen;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_pwd() {
	return user_pwd;
}
public void setUser_pwd(String user_pwd) {
	this.user_pwd = user_pwd;
}
public String getUser_tel() {
	return user_tel;
}
public void setUser_tel(String user_tel) {
	this.user_tel = user_tel;
}
public String getUser_city() {
	return user_city;
}
public void setUser_city(String user_city) {
	this.user_city = user_city;
}
public String getVip() {
	return vip;
}
public void setVip(String vip) {
	this.vip = vip;
}
public Date getVip_end_time() {
	return vip_end_time;
}
public void setVip_end_time(Date vip_end_time) {
	this.vip_end_time = vip_end_time;
} 



}



