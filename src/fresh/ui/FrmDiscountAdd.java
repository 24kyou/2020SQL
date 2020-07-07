package fresh.ui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmDiscountAdd extends JDialog implements ActionListener {
 private JPanel toolBar =new JPanel();
 private JPanel workPane =new JPanel();
 
 private Button btnOk = new Button("创建");
 private Button btnCancel = new Button("取消");
 
private JLabel laberlDiscount=new JLabel("折扣名");
private JLabel keeptime=new JLabel("持续时间");
private JComboBox cmType=new JComboBox(new String[] { "满减优惠", "限时折扣","优惠券"});
	
	public FrmDiscountAdd(JDialog f,String s,boolean b) {
		super(f,s,b);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
