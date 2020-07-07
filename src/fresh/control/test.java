package fresh.control;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
public  static void main(String[] args) {
	String strNow=new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
	System.out.println(strNow);
}
}
