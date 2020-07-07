package fresh.model;

import java.util.Date;

public class BeanDish {
public String order_id;
public int cook_time;
public Date deadline;//
public String dish_id;
public String dish_name;
public double dish_price;
public int dish_num;
public int recommend_values;
public String categories;
public String information;
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public int getCook_time() {
	return cook_time;
}
public void setCook_time(int cook_time) {
	this.cook_time = cook_time;
}
public Date getDeadline() {
	return deadline;
}
public void setDeadline(Date deadline) {
	this.deadline = deadline;
}
public String getDish_id() {
	return dish_id;
}
public void setDish_id(String dish_id) {
	this.dish_id = dish_id;
}
public String getDish_name() {
	return dish_name;
}
public void setDish_name(String dish_name) {
	this.dish_name = dish_name;
}
public double getDish_price() {
	return dish_price;
}
public void setDish_price(double d) {
	this.dish_price = d;
}
public int getDish_num() {
	return dish_num;
}
public void setDish_num(int dish_num) {
	this.dish_num = dish_num;
}
public int getRecommend_values() {
	return recommend_values;
}
public void setRecommend_values(int recommend_values) {
	this.recommend_values = recommend_values;
}
public String getCategories() {
	return categories;
}
public void setCategories(String categories) {
	this.categories = categories;
}
public String getInformation() {
	return information;
}
public void setInformation(String information) {
	this.information = information;
}

}
