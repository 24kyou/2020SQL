package fresh.ui;

import java.awt.BorderLayout;
import java.awt.Button;
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

import fresh.control.UserManager;
import fresh.model.BeanUser;
import fresh.util.BaseException;

public class FrmUserManage extends JDialog implements ActionListener {
	
	public JPanel toolBar=new JPanel();
	private JPanel workPane = new JPanel();
	
	private Button userChange_city=new Button("���и���ȷ��");
	private Button userChange_tel=new Button("�绰����ȷ��");
	private Button userChange_pwd=new Button("�������ȷ��");
	private Button btnCancel=new Button("�˳�");
	
	private JLabel labelOldPwd = new JLabel("������        ��        ");
	private JLabel labelNewPwd1 = new JLabel("������       ��        ");
	private JLabel labelNewPwd2 = new JLabel("������ȷ�ϣ�        ");	
	private JLabel labelNewcity1= new JLabel("ʡ :");
	private JLabel labelNewcity2= new JLabel("�� :");
	private JLabel labelNewcity3= new JLabel("��/�ֵ�/�أ�");
	private JLabel labelNewTel = new JLabel("�µ绰:");
	
	private JTextField edtNewCity1 = new JTextField(255);
	private JTextField edtNewCity2 = new JTextField(255);
	private JTextField edtNewCity3 = new JTextField(255);

	private JPasswordField edtOldPwd = new JPasswordField(25);
	private JPasswordField edtNewPwd1 = new JPasswordField(25);
	private JPasswordField edtNewPwd2 = new JPasswordField(25);
	private JTextField edtNewTel = new JTextField(25);
	
	public FrmUserManage(JDialog f, String s, boolean b) {
		super(f,s,b);
		setAlwaysOnTop(true);
		
		this.setSize(300, 300);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		if(s=="���ĳ���") {		
		toolBar.setBounds(0, 128, 284, 33);
		toolBar.add(userChange_city);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar);
		workPane.setBounds(0,50,284,33);
		workPane.add(labelNewcity1);
		workPane.add(edtNewCity1);
		workPane.add(labelNewcity2);
		workPane.add(edtNewCity2);
		workPane.add(labelNewcity3);
		workPane.add(edtNewCity3);
		this.getContentPane().add(workPane,BorderLayout.CENTER);
		this.validate();
		 btnCancel.addActionListener(this);
		 userChange_city.addActionListener(this);
		}
		else if(s=="��������") {
			toolBar.setBounds(0, 128, 284, 33);
			toolBar.add(userChange_pwd);
			toolBar.add(btnCancel);
			this.getContentPane().add(toolBar);
			workPane.setBounds(0,0,284,33);
			workPane.add(labelOldPwd);
			workPane.add(edtOldPwd);
			workPane.add(labelNewPwd1);
			workPane.add(edtNewPwd1);
			workPane.add(labelNewPwd2);
			workPane.add(edtNewPwd2);
            this.getContentPane().add(workPane,BorderLayout.CENTER);
            this.validate();
			btnCancel.addActionListener(this);
			userChange_pwd.addActionListener(this);
		}
		else if(s=="���ĵ绰") {
			toolBar.setBounds(0, 128, 284, 33);
			toolBar.add(userChange_tel);
			toolBar.add(btnCancel);
			this.getContentPane().add(toolBar);
			workPane.setBounds(0,0,284,33);
			workPane.add(labelNewTel);
			workPane.add(edtNewTel);
			this.getContentPane().add(workPane,BorderLayout.CENTER);
			this.validate();
			 btnCancel.addActionListener(this);
			 userChange_tel.addActionListener(this);
		}
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
         if(e.getSource()==btnCancel) {
        	this.setVisible(false);
        	return ;
        }
         else if(e.getSource()==this.userChange_city) {
        	String newProvince=String.valueOf(this.edtNewCity1.getText());
        	String newCity=String.valueOf(this.edtNewCity2.getText());
        	String newArea=String.valueOf(this.edtNewCity3.getText());
        	String city=newProvince+newCity+newArea;
        	if(city==BeanUser.currentLoginUser.getUser_city()) {
        		JOptionPane.showMessageDialog(null, "������ɵ�ַ�ظ�","����",JOptionPane.ERROR_MESSAGE);
        		return;
        	}
        	try {
        		(new UserManager()).changcity(newProvince,newCity,newArea);
        		
        	}catch(BaseException e1) {
        		JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
        	}
        }
        else if(e.getSource()==this.userChange_pwd) {
        	String OldPwd=String.valueOf(this.edtOldPwd.getPassword());
        	String Pwd1=String.valueOf(this.edtNewPwd1.getPassword());
        	String Pwd2=String.valueOf(this.edtNewPwd2.getPassword());
        	try {
        		(new UserManager()).changPwd(OldPwd,Pwd1,Pwd2);
        	}catch(BaseException e1) {
        		JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
        	}
        }
        else if(e.getSource()==this.userChange_tel) {
        	String tel=String.valueOf(this.edtNewTel.getText());
        	
        	try {
        		(new UserManager()).changTel(tel);
        		
        	}catch(BaseException e1) {
        		JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
        	}
        }
	}
}
