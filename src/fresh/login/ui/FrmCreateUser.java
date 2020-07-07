package fresh.login.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fresh.control.UserManager;
import fresh.model.BeanUser;
import fresh.util.BaseException;
import fresh.util.BusinessException;

public class FrmCreateUser extends JDialog implements ActionListener {
	private BeanUser user=null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	
	private Button btnOk = new Button("注册");
	private Button btnCancel = new Button("取消");
	 
	private JLabel labelUser = new JLabel("用户名：");
	private JLabel labelPwd = new JLabel("密码：");
	private JLabel labelPwd2 = new JLabel("密码：");
	private JLabel labelTel=new JLabel("电话：");
	private JLabel labelGen=new JLabel("性别：");
	private JLabel labelNewcity1= new JLabel("省：");
	private JLabel labelNewcity2= new JLabel("市：");
	private JLabel labelNewcity3= new JLabel("区/街道/县：");
	
	private JTextField edtUserName = new JTextField(60);
	private JPasswordField edtPwd = new JPasswordField(60);
	private JPasswordField edtPwd2 = new JPasswordField(50);
	private JTextField edtCity1 = new JTextField(50);
	private JTextField edtCity2 = new JTextField(60);
	private JTextField edtCity3 = new JTextField(55);
	private JTextField edtTel =new JTextField(60);
	
	private JComboBox cmGenType=new JComboBox(new String[] { "男", "女"});
	
	public FrmCreateUser(JDialog f,String s,boolean b) {
		super(f,s,b);
		this.setSize(450, 400);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserName);
		workPane.add(labelTel);
		workPane.add(edtTel);
		workPane.add(labelGen);
		workPane.add(cmGenType);
		workPane.add(labelNewcity1);
		workPane.add(edtCity1);
		workPane.add(labelNewcity2);
		workPane.add(edtCity2);
		workPane.add(labelNewcity3);
		workPane.add(edtCity3);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		workPane.add(labelPwd2);
		workPane.add(edtPwd2);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
     if(e.getSource()==this.btnOk) {
    	 if(this.cmGenType.getSelectedIndex()<0) {
     JOptionPane.showMessageDialog(null,  "请选择性别","提示",JOptionPane.ERROR_MESSAGE);
				return;
    	 }
    	String newProvince=String.valueOf(this.edtCity1.getText());
     	String newCity=String.valueOf(this.edtCity2.getText());
     	String newArea=String.valueOf(this.edtCity3.getText());
     	String city=newProvince+newCity+newArea;
      	String UserName=String.valueOf(this.edtUserName.getText());
      	String Userpwd1=String.valueOf(this.edtPwd.getPassword());
      	String Userpwd2=String.valueOf(this.edtPwd2.getPassword());
      	String UserTel=String.valueOf(this.edtTel.getText());
      	String gen=this.cmGenType.getSelectedItem().toString();
      	if(!Userpwd1.equals(Userpwd2)) {
      		JOptionPane.showMessageDialog(null,  "两次密码不一样","提示",JOptionPane.ERROR_MESSAGE);
			return;
      	}
    	 user=new BeanUser();
    	 user.setUser_city(city);
    	 user.setUser_gen(gen);
    	 user.setUser_name(UserName);
    	 user.setUser_pwd(Userpwd1);
    	 user.setUser_tel(UserTel);
    	 try {
			(new UserManager()).creatUser(user);
    	 this.setVisible(false);
     }catch(BaseException | BusinessException e1) {
    	 this.user=null;
	JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
     }
    	 }
     else if(e.getSource()==this.btnCancel) {
    	 this.setVisible(false);
     }
	}

}
