package fresh.login.ui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import fresh.model.*;
import fresh.ui.*;



public class FrmMainEm extends JFrame implements ActionListener {
	private JMenuBar menubar=new JMenuBar(); 
    private JMenu menu_Em_Manager=new JMenu("Ա������");//������
    private JMenu menu_Or_send=new JMenu("�������ʹ���");//����Ա
    private JMenu menu_cook=new JMenu("������Ʒ����");//��ʦ
    private JMenu menu_complain=new JMenu("Ͷ�ߴ���");//�ۺ�
    private JMenu menu_product_Addition =new JMenu("��Ʒ����");//���Ա
    private JMenu menu_setting=new JMenu("Ա����Ϣ����");
    
    private JMenuItem  menuItem_EmManager=new JMenuItem("Ա������");
    private JMenuItem  menuItem_Discount_1=new JMenuItem("���۹���");
    private JMenuItem  menuItem_Discount_2=new JMenuItem("�Żݹ���");
    private JMenuItem  menuItem_Discount_3=new JMenuItem("��ʱ��������");
    
    private JMenuItem  menuItem_send=new JMenuItem("�������͹���");
    
    private JMenuItem  menuItem_How_cook=new JMenuItem("��Ʒ������");
    private JMenuItem  menuItem_cook_order=new JMenuItem("��Ʒ����");
    private JMenuItem  menuItem_Food_feedback=new JMenuItem("��Ʒ����");
    
    private JMenuItem  menuItem_Complaints=new JMenuItem("Ͷ�߹���");
    
    private JMenuItem  menuItem_product=new JMenuItem("��Ʒ����");
    private JMenuItem  menuItem_product_feedback=new JMenuItem("��Ʒ��������");
    
    private JMenuItem  menuItem_inf=new JMenuItem("Ա��������Ϣ����");

    
    private JPanel statusBar = new JPanel();
 
	private FrmloginEm dlglogin=null;
	public FrmMainEm() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("Ա��ϵͳ");
		 dlglogin=new FrmloginEm(this,"��½",true);
		 dlglogin.setVisible(true);
		 
		 if("������".equals(BeanEmployee.currentLoginUser.getPosition())) {
			 menu_Em_Manager.add(menuItem_EmManager);
			 menuItem_EmManager.addActionListener(this);
			 menu_Em_Manager.add(menuItem_Discount_1);
			 menuItem_Discount_1.addActionListener(this);
			 menu_Em_Manager.add(menuItem_Discount_2);
			 menuItem_Discount_2.addActionListener(this);
			 menu_Em_Manager.add(menuItem_Discount_3);
			 menuItem_Discount_3.addActionListener(this);
			 menubar.add(menu_Em_Manager);
		 }
		 else if("����Ա".equals(BeanEmployee.currentLoginUser.getPosition())) {
			 menu_Or_send.add(menuItem_send);
			 menuItem_send.addActionListener(this);
			 menubar.add(menu_Or_send);
		 }
		 else if("��ʦ".equals(BeanEmployee.currentLoginUser.getPosition())) {
			 menu_cook.add(menuItem_How_cook);
			 menuItem_How_cook.addActionListener(this);
			 menu_cook.add(menuItem_cook_order);
			 menuItem_cook_order.addActionListener(this);
			 menu_cook.add(menuItem_Food_feedback);
			 menuItem_Food_feedback.addActionListener(this);
			 menubar.add(menu_cook);
		 }
         else if("�ۺ�".equals(BeanEmployee.currentLoginUser.getPosition())) {
        	 menu_complain.add(menuItem_Complaints);
        	 menuItem_Complaints.addActionListener(this);
        	 menu_complain.add(menuItem_product_feedback);
        	 menuItem_product_feedback.addActionListener(this);
        	 menubar.add(menu_complain);
		 }
         else if("���Ա".equals(BeanEmployee.currentLoginUser.getPosition())) {
        	 menu_product_Addition.add(menuItem_product);
        	 menuItem_product.addActionListener(this);
        	 menu_product_Addition.add(menuItem_product_feedback);
        	 menuItem_product_feedback.addActionListener(this);
        	 menubar.add(menu_product_Addition);
		 }	 
		 
		 menu_setting.add(this.menuItem_inf);
		 menuItem_inf.addActionListener(this);
		 menubar.add(menu_setting);
		 
		 this.setJMenuBar(menubar);
		 statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		 JLabel label=new JLabel("����!"+BeanEmployee.currentLoginUser.getName());
		    statusBar.add(label);
		    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
		    this.addWindowListener(new WindowAdapter(){   
		    	public void windowClosing(WindowEvent e){ 
		    		System.exit(0);
	             }
	        });
		    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.menuItem_EmManager){
			FrmEmployeeManager dlg=new FrmEmployeeManager(this,"Ա������",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_Discount_1){
			FrmDiscount dlg=new FrmDiscount(this,"���۹���",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_Discount_2){
			FrmDiscount dlg=new FrmDiscount(this,"�Żݹ���",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_Discount_3){
			FrmDiscount dlg=new FrmDiscount(this,"��ʱ��������",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_send){
			Frmsend dlg=new Frmsend(this,"�������͹���",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_How_cook){
			FrmCookWay dlg=new FrmCookWay(this,"��Ʒ����",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_cook_order){
			FrmCookOrder dlg=new FrmCookOrder(this,"Ͷ�߹���",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_Complaints){
			FrmComplaints dlg=new FrmComplaints(this,"��Ʒ����",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_product){
			FrmProduct dlg=new FrmProduct(this,"��Ʒ����",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_product_feedback){
			FrmProductFeedback dlg=new FrmProductFeedback(this,"��Ʒ��������",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.menuItem_inf){
			FrmEmployeeManager dlg=new FrmEmployeeManager(this,"Ա������",true);
			dlg.setVisible(true);
		}
		
	}

}
