package fresh.login.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FrmSee extends JFrame {
	private FrmChoice dlg=null;
	public FrmSee(){
		dlg=new FrmChoice(this,"��½",true);
		dlg.setVisible(true);
	}

}
