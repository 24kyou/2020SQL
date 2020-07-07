package fresh.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fresh.util.BaseException;
import fresh.control.UserManager;
import fresh.model.BeanUser;

public class FrmUser extends JDialog implements ActionListener {
    private JPanel toolBar=new JPanel();
    
    private Button btnChangPwd=new Button("密码修改");
    private Button btnChangTel=new Button("电话号码修改");
    private Button btnChangCity=new Button("电话号码修改");
    private Button btnVip=new Button("Vip信息");
    private Object tblTitle[]={"用户id","姓名","性别","手机号码","所在城市","是否为vip"};
    private Object tblData[][];
    DefaultTableModel tablmod=new DefaultTableModel();
	private JTable userTable=new JTable(tablmod);
	private void reloadUserTable(){
		List<BeanUser> users=(new UserManager()).loadBeanUsers();
		tblData =new Object[users.size()][6];
		for(int i=0;i<users.size();i++){
			tblData[i][0]=users.get(i).getUser_id();
			tblData[i][1]=users.get(i).getUser_name();
			tblData[i][2]=users.get(i).getUser_gen();
			tblData[i][3]=users.get(i).getUser_tel();
			tblData[i][4]=users.get(i).getUser_city();
			tblData[i][5]=users.get(i).getVip();
		}
		tablmod.setDataVector(tblData,tblTitle);
		this.userTable.validate();
		this.userTable.repaint();
	}
    public FrmUser(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnChangPwd);
		toolBar.add(btnChangTel);
		toolBar.add(btnChangCity);
		toolBar.add(btnVip);
		this.getContentPane().add(toolBar,BorderLayout.NORTH);
		this.reloadUserTable();
		this.getContentPane().add(new JScrollPane(this.userTable), BorderLayout.CENTER);
		this.setSize(800,600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		this.btnChangPwd.addActionListener(this);
		this.btnChangTel.addActionListener(this);
		this.btnChangCity.addActionListener(this);
		this.btnVip.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
				return;
			}
		});
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==this.btnChangCity) {
			FrmUserManage dlg=new FrmUserManage(this,"更改城市",true);
		    dlg.setVisible(true);
		    this.reloadUserTable();
		}		
	else if(e.getSource()==this.btnChangPwd) {
			FrmUserManage dlg=new FrmUserManage(this,"更改密码",true);
		    dlg.setVisible(true);
		    this.reloadUserTable();
		    
		}		
	else if(e.getSource()==this.btnChangTel) {
			FrmUserManage dlg=new FrmUserManage(this,"更改电话",true);
		    dlg.setVisible(true);
		    this.reloadUserTable();
		}		
	else if(e.getSource()==this.btnVip) {
		FrmVip dlg=new FrmVip(this,"vip信息",true);
		dlg.setVisible(true);
		this.reloadUserTable();
	}
	}
	

	}