package fresh.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

import fresh.control.UserVipManager;
import fresh.util.BaseException;

public class FrmBeVip extends JDialog implements ActionListener {
	private JPanel toolBar=new JPanel();
	
	private Button btnBeVip=new Button("确定成为Vip");
    private Button btnNotBeVip=new Button("确定取消Vip");
	
    public FrmBeVip(JDialog f,String s,boolean b) {
		super(f,s,b);
		this.setSize(340,140);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		if(s=="成为vip") {
			toolBar.add(btnBeVip);
			this.getContentPane().add(toolBar,BorderLayout.CENTER);
			btnBeVip.addActionListener(this);
			this.validate();
		}
		else if(s=="取消vip") {
			toolBar.add(btnNotBeVip);
			this.getContentPane().add(toolBar,BorderLayout.CENTER);
			btnNotBeVip.addActionListener(this);
			this.validate();
		}
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				return ;
				}
			});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getSource()==this.btnBeVip) {
        	boolean BeVip=true;
        	try {
				(new UserVipManager()).changVip(BeVip);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        else if(e.getSource()==this.btnNotBeVip) {
        	boolean BeVip=false;
        	try {
				(new UserVipManager()).changVip(BeVip);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
	}

}
