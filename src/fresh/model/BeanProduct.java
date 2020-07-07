package fresh.model;

public class BeanProduct {
private String Id;
private String category;
private String ProductName;
private double VipPrice;
private double OriPrice; 
private int num;
private String information;
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public double getVipPrice() {
	return VipPrice;
}
public void setVipPrice(double vipPrice) {
	VipPrice = vipPrice;
}
public double getOriPrice() {
	return OriPrice;
}
public void setOriPrice(double oriPrice) {
	OriPrice = oriPrice;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getInformation() {
	return information;
}
public void setInformation(String information) {
	this.information = information;
}

}
