package fresh.model;

public class BeanEmployee {
public static BeanEmployee currentLoginUser=null; 
public String Employee_id;
public String name;
public String pwd;
public String position;//cooker-2,sender-1,manager-0,servicer-3,After-sales-4
public String Emplyee_tel;
public String manager_id;
public String getEmployee_id() {
	return Employee_id;
}
public void setEmployee_id(String employee_id) {
	Employee_id = employee_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getEmplyee_tel() {
	return Emplyee_tel;
}
public void setEmplyee_tel(String emplyee_tel) {
	Emplyee_tel = emplyee_tel;
}
public String getManager_id() {
	return manager_id;
}
public void setManager_id(String manager_id) {
	this.manager_id = manager_id;
}

}
