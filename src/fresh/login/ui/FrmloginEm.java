package fresh.login.ui;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;

import fresh.control.EmployeeManager;
import fresh.control.UserManager;
import fresh.model.BeanEmployee;
import fresh.model.BeanUser;
import fresh.util.BusinessException;

public class FrmloginEm extends JDialog implements ActionListener {

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button ManagerLogin=new Button("工作人员登陆");
	private Button btnCancel = new Button("退出");
	private JLabel labelUser = new JLabel("账号：        ");
	private JLabel labelPwd = new JLabel("密码：        ");
	private JPasswordField edtUserId = new JPasswordField(25);
	private JPasswordField edtPasswd=new JPasswordField(25);
	
	public FrmloginEm(Frame f, String s, boolean b) {
		super(f,s,b);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		toolBar.setBounds(0, 128, 284, 33);
		toolBar.add(ManagerLogin);
		this.getContentPane().add(toolBar);
		toolBar.add(btnCancel);
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
		
		ManagerLogin.addActionListener(this);
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
		if (e.getSource() == this.ManagerLogin) {
			EmployeeManager em=new EmployeeManager();
			String userid=this.edtUserId.getUIClassID();//前面是gettext()
			String pwd=new String(this.edtPasswd.getPassword());
			BeanEmployee user=em.loadUser(userid);
			if(pwd.equals(user.getPwd())){
				BeanEmployee.currentLoginUser=user;
				setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null,  "密码错误","错误提示",JOptionPane.ERROR_MESSAGE);
			} 
		}
		else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		}
	}
	
}
