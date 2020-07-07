package fresh.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fresh.control.DiscountManager;
import fresh.control.DishManager;
import fresh.control.ProductManager;
import fresh.login.ui.FrmMainEm;
import fresh.model.BeanDiscount;
import fresh.model.BeanDish;
import fresh.model.BeanProduct;
import fresh.util.BaseException;
/*�������۹���*/
public class FrmDiscount extends JDialog implements ActionListener {
private JPanel toolBar=new JPanel();

//�û�����
private Button coupons=new Button("�Ż�ȯ");//�Ż�ȯ
private Button FullDiscount=new Button("�����Ż�");
private Button TimeLimited=new Button("��ʱ�Ż�");
private Button moreinform =new Button("������Ϣ");
private Button back=new Button("�˳�");


private JTextField edtsearchD=new JTextField(25);
private Button searchD=new Button("������Ʒ�Ż�");

//����Ա����
private Button addcoupons=new Button("����Ż�ȯ");
private Button addFullDiscount=new Button("��������Ż�");
private Button addTimeLimited=new Button("�����ʱ�Ż�");
private Button delete=new Button("ɾ���Ż�");
private Object tblData[][];
private Object tblTitle1[]= {"�Żݱ��","�Ż����","��ʼʱ��","����ʱ��"};
private Object tblTitle2[]= {"��Ʒ���","��Ʒ��","�Żݱ��","�Ż����","��ʼʱ��","����ʱ��"};
DefaultTableModel tablmod=new DefaultTableModel();
private JTable userTable=new JTable(tablmod);

private void loadAllco() {
	try {
		List<BeanDiscount> Discount=(new DiscountManager()).loadcoDiscount();
		tblData=new Object[Discount.size()][4];
		for(int i=0;i<Discount.size();i++) {
			tblData[i][0]=Discount.get(i).getDiscount_id();
			tblData[i][1]=Discount.get(i).getType();
			tblData[i][2]=Discount.get(i).getBegin_time();
			tblData[i][3]=Discount.get(i).getEnd_time();
		}
		tablmod.setDataVector(tblData,tblTitle1);
		this.userTable.validate();
		this.userTable.repaint();
	} catch (BaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private void loadAllfd() {
	try {
	List<BeanDiscount>Discount = (new DiscountManager()).loadfdDiscount();
	tblData=new Object[Discount.size()][4];
	for(int i=0;i<Discount.size();i++) {
		tblData[i][0]=Discount.get(i).getDiscount_id();
		tblData[i][1]=Discount.get(i).getType();
		tblData[i][2]=Discount.get(i).getBegin_time();
		tblData[i][3]=Discount.get(i).getEnd_time();
	}
	tablmod.setDataVector(tblData,tblTitle1);
	this.userTable.validate();
	this.userTable.repaint();
	tablmod.setDataVector(tblData,tblTitle1);
	this.userTable.validate();
	this.userTable.repaint();
	} catch (BaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private void loadAllpro() {
	try {
	List<BeanDiscount>Discount = (new DiscountManager()).loadProDiscount();
	tblData=new Object[Discount.size()][4];
	for(int i=0;i<Discount.size();i++) {
		tblData[i][0]=Discount.get(i).getDiscount_id();
		tblData[i][1]=Discount.get(i).getType();
		tblData[i][2]=Discount.get(i).getBegin_time();
		tblData[i][3]=Discount.get(i).getEnd_time();
	}
	tablmod.setDataVector(tblData,tblTitle1);
	this.userTable.validate();
	this.userTable.repaint();
	} catch (BaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private void reload(String product_id,String type) {
	try {
		List<BeanDiscount> Discount=(new DiscountManager()).loadDiscount(product_id,type);
		tblData=new Object[Discount.size()][6];
			for(int i=0;i<Discount.size();i++) {
			tblData[i][0]=Discount.get(i).getProduct_id();
			tblData[i][1]=Discount.get(i).getProduct_name();
			tblData[i][2]=Discount.get(i).getDiscount_id();
			tblData[i][3]=Discount.get(i).getType();
			tblData[i][4]=Discount.get(i).getBegin_time();
			tblData[i][5]=Discount.get(i).getEnd_time();
		}
		tablmod.setDataVector(tblData,tblTitle2);
		this.userTable.validate();
		this.userTable.repaint();
	} catch (BaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void reload(String product_id) {
	// TODO Auto-generated method stub
	try {
		List<BeanDiscount> Discount=(new DiscountManager()).loadDiscount(product_id);
		tblData=new Object[Discount.size()][6];
			for(int i=0;i<Discount.size();i++) {
			tblData[i][0]=Discount.get(i).getProduct_id();
			tblData[i][1]=Discount.get(i).getProduct_name();
			tblData[i][2]=Discount.get(i).getDiscount_id();
			tblData[i][3]=Discount.get(i).getType();
			tblData[i][4]=Discount.get(i).getBegin_time();
			tblData[i][5]=Discount.get(i).getEnd_time();
		}
		tablmod.setDataVector(tblData,tblTitle2);
		this.userTable.validate();
		this.userTable.repaint();
	} catch (BaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public FrmDiscount(JDialog f, String s, boolean b) {//�����û�������龰
		super(f, s, b);
	    this.setTitle("�Ż�Ŀ¼");
		toolBar.setSize(800, 40);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));		
		toolBar.add(coupons);
		toolBar.add(FullDiscount);
		toolBar.add(TimeLimited);
		toolBar.add(edtsearchD);
		toolBar.add(searchD);
		toolBar.add(moreinform);
		toolBar.add(back);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		this.loadAllco();
		this.loadAllfd();
		this.loadAllpro();
		this.getContentPane().add(new JScrollPane(this.userTable), BorderLayout.CENTER);
		
		this.setSize(800,600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		this.validate();
		this.coupons.addActionListener(this);
		this.FullDiscount.addActionListener(this);
		this.TimeLimited.addActionListener(this);
		this.searchD.addActionListener(this);
		this.back.addActionListener(this);
		this.moreinform.addActionListener(this);
		}

	/**
	 * @wbp.parser.constructor
	 */
	public FrmDiscount(JFrame f, String s, boolean b) {
		super(f, s, b);
		 this.setTitle("�Żݹ���");
		toolBar.setSize(800, 40);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));		
		toolBar.add(coupons);
		toolBar.add(addcoupons);
		toolBar.add(FullDiscount);
		toolBar.add(addFullDiscount);
		toolBar.add(TimeLimited);
		toolBar.add(addTimeLimited);
		toolBar.add(edtsearchD);
		toolBar.add(searchD);
		toolBar.add(back);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		this.loadAllco();
		this.loadAllfd();
		this.loadAllpro();
		this.getContentPane().add(new JScrollPane(this.userTable), BorderLayout.CENTER);
		
		this.setSize(800,600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		this.validate();
		this.coupons.addActionListener(this);
		this.addcoupons.addActionListener(this);
		this.FullDiscount.addActionListener(this);
		this.addFullDiscount.addActionListener(this);
		this.TimeLimited.addActionListener(this);
		this.addTimeLimited.addActionListener(this);
		this.searchD.addActionListener(this);
		this.back.addActionListener(this);
		this.moreinform.addActionListener(this);	
		
		// TODO Auto-generated constructor stub
		
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
      if(e.getSource()==this.searchD) {
    	 if("".equals(this.edtsearchD)||this.edtsearchD==null) {
    		 JOptionPane.showMessageDialog(null,  "��������Ʒ","��ʾ",JOptionPane.ERROR_MESSAGE);
  			return; 
    	 }
    	 this.reload(this.edtsearchD.getText()); 
      }else if(e.getSource()==this.coupons) {
    	  this.loadAllco();
      }else if(e.getSource()==this.FullDiscount) {
    	  this.loadAllfd();
      }else if(e.getSource()==this.TimeLimited) {
    	  this.loadAllpro();
      }else if(e.getSource()==this.moreinform) {
    	  int i=userTable.getSelectedRow();
    	  if(i<0) {
    		  JOptionPane.showMessageDialog(null,  "��ѡ����Ʒ","��ʾ",JOptionPane.ERROR_MESSAGE);
     			return;
    	  }
    	  this.reload(userTable.getValueAt(i, 0).toString(), userTable.getValueAt(i, 1).toString());
    	  //�������ȷ i+1
      }else if(e.getSource()==this.addcoupons) {
    	  FrmDiscountAdd dlg=new FrmDiscountAdd(this,"����Ż�ȯ",true);
    	  dlg.setVisible(true);
      }else if(e.getSource()==this.addFullDiscount) {
    	  FrmDiscountAdd dlg=new FrmDiscountAdd(this,"�������",true);
    	  dlg.setVisible(true);
      }else if(e.getSource()==this.addTimeLimited) {
    	  FrmDiscountAdd dlg=new FrmDiscountAdd(this,"�����ʱ�Ż�",true);
    	  dlg.setVisible(true);
      }
	}
 
}
