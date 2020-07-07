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

    private JMenu menu_Buy=new JMenu("商品");
    private JMenu menu_Order=new JMenu("订单");
    private JMenu menu_privacy=new JMenu("我的信息");                                                                     
	
    private JMenuItem  menuItem_Product=new JMenuItem("商品选择");
    
    private JMenuItem  menuItem_order=new JMenuItem("订单查询");
    
    private JMenuItem  menuItem_infrom=new JMenuItem("用户信息");
    private JMenuItem  menuItem_send_infrom=new JMenuItem("用户配送信息");
    
    private JMenuBar menubar=new JMenuBar();
    private FrmloginUser dlglogin=null;
    private JPanel statusBar = new JPanel();
 
    public FrmMainUser() {
    this.setExtendedState(Frame.MAXIMIZED_BOTH);
	this.setTitle("用户购买管理系统");
	 dlglogin=new FrmloginUser(this,"登陆",true);
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
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!"+BeanUser.currentLoginUser.getUser_name());
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
			FrmUser dlg=new FrmUser(this,"用户信息",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_order){
			FrmOrder dlg=new FrmOrder(this,"订单查询",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_Product){
			FrmProduct dlg=new FrmProduct(this,"商品选择",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_send_infrom){
			FrmSendInfrom dlg=new FrmSendInfrom(this,"用户配送信息",true);
			dlg.setVisible(true);
		}

	}

}
