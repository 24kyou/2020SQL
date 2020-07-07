package fresh.login.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import fresh.util.*;
import fresh.control.EmployeeManager;
import fresh.control.UserManager;
import fresh.model.*;
public class FrmloginUser extends JDialog implements ActionListener {
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button userLogin=new Button("用户登陆");
	private Button Usercreate =new Button("用户注册");
	private Button btnCancel = new Button("退出");
	
	private JLabel labelUser = new JLabel("手机号：        ");
	private JLabel labelPwd = new JLabel("密码：        ");
	private JTextField edtUserId = new JTextField(25);
	private JPasswordField edtPasswd=new JPasswordField(25);
	
	public FrmloginUser(Frame f, String s, boolean b) {
		super(f,s,b);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		toolBar.setBounds(0, 128, 284, 33);
		toolBar.add(Usercreate);
		toolBar.add(userLogin);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar);
		workPane.setBounds(0, 0, 284, 128);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		this.getContentPane().add(workPane,BorderLayout.CENTER);
		labelPwd.setHorizontalAlignment(SwingConstants.CENTER);
		workPane.add(labelPwd);
		workPane.add(edtPasswd);
		this.getContentPane().add(workPane,BorderLayout.CENTER);
		this.setSize(300, 200);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		this.validate();
		
		userLogin.addActionListener(this);
		Usercreate.addActionListener(this);
		btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if (e.getSource() == this.userLogin) {
			UserManager um=new UserManager();
			String userid=String.valueOf(this.edtUserId.getText());
			String pwd= String.valueOf(this.edtPasswd.getPassword());
			try {
				BeanUser user;
				try {
					user = um.loadUser(userid);
					if(pwd.equals(user.getUser_pwd())){
					BeanUser.currentLoginUser=user;
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null,  "密码错误","错误提示",JOptionPane.ERROR_MESSAGE);
				}
				} 
				
				catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DbException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (BusinessException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误提示",JOptionPane.ERROR_MESSAGE);
			} 
		}
		else if(e.getSource()==this.Usercreate) {
		  FrmCreateUser dlg=new FrmCreateUser(this,"创建账户",true);
		  dlg.setVisible(true);
		}
		else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		}
	}

}
