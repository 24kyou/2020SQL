package fresh.model;

import java.util.ArrayList;

public class BeanOrder {
public String order_id;//userid+date
public String coupons_id;//优惠券编号
public String user_id;
public String contacter;//不一定和用户是同一人
public String contacter_tel;
public String S_Employee_id;//派送员id
public ArrayList<BeanDish> buycar1;
public ArrayList<BeanProduct> buycar2;
public double origin_amount;
public double real_amount;
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getCoupons_id() {
	return coupons_id;
}
public void setCoupons_id(String coupons_id) {
	this.coupons_id = coupons_id;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getContacter() {
	return contacter;
}
public void setContacter(String contacter) {
	this.contacter = contacter;
}
public String getContacter_tel() {
	return contacter_tel;
}
public void setContacter_tel(String contacter_tel) {
	this.contacter_tel = contacter_tel;
}
public String getS_Employee_id() {
	return S_Employee_id;
}
public void setS_Employee_id(String s_Employee_id) {
	S_Employee_id = s_Employee_id;
}
//public ArrayList<BeanDish> getBuycar1() {
//	return buycar1;
//}
//public void setBuycar1(ArrayList<BeanDish> buycar1) {
//	this.buycar1 = buycar1;
//}
public ArrayList<BeanProduct> getBuycar2() {
	return buycar2;
}
public void setBuycar2(ArrayList<BeanProduct> buycar2) {
	this.buycar2 = buycar2;
}
public double getOrigin_amount() {
	return origin_amount;
}
public void setOrigin_amount(double origin_amount) {
	this.origin_amount = origin_amount;
}
public double getReal_amount() {
	return real_amount;
}
public void setReal_amount(double real_amount) {
	this.real_amount = real_amount;
}

}
