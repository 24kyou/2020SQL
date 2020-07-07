package fresh.login.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import fresh.model.BeanUser;
import fresh.ui.*;

public class FrmMainUser extends JFrame implements ActionListener {

    private JMenu menu_Buy=new JMenu("��Ʒ");
    private JMenu menu_Order=new JMenu("����");
    private JMenu menu_privacy=new JMenu("�ҵ���Ϣ");                                                                     
	
    private JMenuItem  menuItem_Product=new JMenuItem("��Ʒѡ��");
    
    private JMenuItem  menuItem_order=new JMenuItem("������ѯ");
    
    private JMenuItem  menuItem_infrom=new JMenuItem("�û���Ϣ");
    private JMenuItem  menuItem_send_infrom=new JMenuItem("�û�������Ϣ");
    
    private JMenuBar menubar=new JMenuBar();
    private FrmloginUser dlglogin=null;
    private JPanel statusBar = new JPanel();
 
    public FrmMainUser() {
    this.setExtendedState(Frame.MAXIMIZED_BOTH);
	this.setTitle("�û��������ϵͳ");
	 dlglogin=new FrmloginUser(this,"��½",true);
	 dlglogin.setVisible(true);
	 
	 menu_Buy.add(this.menuItem_Product);
	 menuItem_Product.addActionListener(this);
	 menubar.add(menu_Buy);
	 
	 menu_Order.add(this.menuItem_order);
	 menuItem_order.addActionListener(this);
	 menubar.add(menu_Order);
	 
	 menu_privacy.add(this.menuItem_infrom);
	 menuItem_infrom.addActionListener(this);
	 menu_privacy.add(this.menuItem_send_infrom);
	 menuItem_send_infrom.addActionListener(this);
	 menubar.add(menu_privacy);

	    this.setJMenuBar(menubar);
	    //״̬��
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("����!"+BeanUser.currentLoginUser.getUser_name());
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
		if(e.getSource()==this.menuItem_infrom){
			FrmUser dlg=new FrmUser(this,"�û���Ϣ",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_order){
			FrmOrder dlg=new FrmOrder(this,"������ѯ",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_Product){
			FrmProduct dlg=new FrmProduct(this,"��Ʒѡ��",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_send_infrom){
			FrmSendInfrom dlg=new FrmSendInfrom(this,"�û�������Ϣ",true);
			dlg.setVisible(true);
		}

	}

}
