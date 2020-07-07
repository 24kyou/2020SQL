package fresh.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fresh.model.BeanUser;

public class FrmVip extends JDialog implements ActionListener {
	
	private JPanel toolBar=new JPanel();
	
	private Button BeVip=new Button("成为Vip");
	private Button NotBeVip=new Button("取消Vip");
	
    private Object tblTitle[]={"用户id","姓名","性别","手机号码","所在城市","成为vip的时间"};
    private Object tblData[][];
    DefaultTableModel tablmod=new DefaultTableModel();
	private JTable userTable=new JTable(tablmod);
	public void loadVip() {
		BeanUser bu= BeanUser.currentLoginUser;
		tblData=new Object[1][6];
		tblData[0][0]=bu.getUser_id();
		tblData[0][1]=bu.getUser_name();
		tblData[0][2]=bu.getUser_gen();
		tblData[0][3]=bu.getUser_tel();
		tblData[0][4]=bu.getUser_city();
		tblData[0][5]=bu.getVip_end_time();
		tablmod.setDataVector(tblData, tblTitle);
		this.userTable.validate();
		this.userTable.repaint();
		
	}
	
	public FrmVip(JDialog f,String s,boolean b) {
		super(f,s,b);
		toolBar.add(BeVip);
		toolBar.add(NotBeVip);
		this.getContentPane().add(toolBar,BorderLayout.SOUTH);
		this.loadVip();
		this.getContentPane().add(new JScrollPane(this.userTable),BorderLayout.CENTER);
		this.setSize(800,600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.BeVip.addActionListener(this);
		this.NotBeVip.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			return ;
			}
		});
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
         if(e.getSource()==this.BeVip) {
        	 FrmBeVip dlg=new FrmBeVip(this,"成为vip",true);
        	 dlg.setVisible(true);
 		    this.loadVip();
         }else if(e.getSource()==this.NotBeVip) {
        	 FrmBeVip dlg=new FrmBeVip(this,"取消vip",true);
        	 dlg.setVisible(true);
 		    this.loadVip();
         }
	}

}
