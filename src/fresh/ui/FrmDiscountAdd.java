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
 
 private Button btnOk = new Button("����");
 private Button btnCancel = new Button("ȡ��");
 
private JLabel laberlDiscount=new JLabel("�ۿ���");
private JLabel keeptime=new JLabel("����ʱ��");
private JComboBox cmType=new JComboBox(new String[] { "�����Ż�", "��ʱ�ۿ�","�Ż�ȯ"});
	
	public FrmDiscountAdd(JDialog f,String s,boolean b) {
		super(f,s,b);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
