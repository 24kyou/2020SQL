package fresh.model;

import java.util.Date;

public class BeanDiscount {
public String product_name;
public Date begin_time;
public Date end_time;
public String type;//pro->��ʱ,co->�Ż�,fd->����
public String Discount_id;//pro_id&&discount_id&&Coupons_id
public String product_id;
public String cotent;//����

public double pro_amount;//�����۸�
public int pro_num;//��������

public double co_least_amont;//ʹ����ͽ��
public double co_relief_amount;//������

public double  fd_discount;//�ۿ�
public int fd_num;//������Ʒ��Ŀ


public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public Date getBegin_time() {
	return begin_time;
}
public void setBegin_time(Date begin_time) {
	this.begin_time = begin_time;
}
public Date getEnd_time() {
	return end_time;
}
public void setEnd_time(Date end_time) {
	this.end_time = end_time;
}
public String getType() {
	return type;
}
public void setType(String type) {
	if(type.charAt(0)=='p')
	this.type = "��ʱ�Ż�";
	else if(type.charAt(0)=='f')
	this.type="�����Ż�";
	else if(type.charAt(0)=='c')
	this.type="�Ż�ȯ";
}
public String getDiscount_id() {
	return Discount_id;
}
public void setDiscount_id(String discount_id) {
	Discount_id = discount_id;
}
public String getProduct_id() {
	return product_id;
}
public void setProduct_id(String product_id) {
	this.product_id = product_id;
}
public String getCotent() {
	return cotent;
}
public void setCotent(String cotent) {
	this.cotent = cotent;
}
public double getPro_amount() {
	return pro_amount;
}
public void setPro_amount(double pro_amount) {
	this.pro_amount = pro_amount;
}
public int getPro_num() {
	return pro_num;
}
public void setPro_num(int pro_num) {
	this.pro_num = pro_num;
}
public double getCo_least_amont() {
	return co_least_amont;
}
public void setCo_least_amont(double co_least_amont) {
	this.co_least_amont = co_least_amont;
}
public double getCo_relief_amount() {
	return co_relief_amount;
}
public void setCo_relief_amount(double co_relief_amount) {
	this.co_relief_amount = co_relief_amount;
}
public double getFd_discount() {
	return fd_discount;
}
public void setFd_discount(double fd_discount) {
	this.fd_discount = fd_discount;
}
public int getFd_num() {
	return fd_num;
}
public void setFd_num(int fd_num) {
	this.fd_num = fd_num;
}



}
