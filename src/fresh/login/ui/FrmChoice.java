package fresh.login.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

import fresh.ui.*;

public class FrmChoice extends JDialog implements ActionListener {
private JPanel toolBar = new JPanel();
    private Button btnUser = new Button("用户使用");
	private Button btnManager = new Button("工作人员使用");
	private Button btnCancel = new Button("退出");
	public FrmChoice(Frame f, String s, boolean b) {
		// TODO Auto-generated constructor stub
		this.setTitle("选择模式");
		toolBar.add(btnUser);
		toolBar.add(btnManager);
//		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.CENTER);
		this.setSize(300,100);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		btnUser.addActionListener(this);
		btnManager.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
       if(e.getSource()==this.btnUser)
    	   new FrmMainUser();
       else if(e.getSource()==this.btnManager)
    	   new FrmMainEm();
//       else if(e.getSource()==this.btnCancel) {
//    	   System.exit(0);
//       }
	}
}
