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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fresh.control.ProductManager;
import fresh.model.BeanProduct;
import fresh.util.BaseException;

public class FrmProduct extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	
	private Button GoIntoDish=new Button("生鲜卖场");
	private Button buy=new Button("购物车");
	private Button addProduct=new Button("添加商品");
	private Button search_p=new Button("搜索商品");
	private Button feedBack=new Button("商品反馈");
	private Button discount =new Button("商品优惠活动");
	private Button moreinform =new Button("商品详细信息");
	private Button back=new Button("退出");
	private Object tblData[][];
	private Object tblTitle[]= {"商品编号","商品名","商品类别","商品数量","价格","会员价"};
	
	private JTextField edtsearch=new JTextField(15);
	
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable userTable=new JTable(tablmod);
	private void reloadproductTable() {
		try {
			List<BeanProduct> product=(new ProductManager()).loadAllProduct();
			tblData=new Object[product.size()][6];
			for(int i=0;i<product.size();i++) {
				tblData[i][0]=product.get(i).getId();
				tblData[i][1]=product.get(i).getProductName();
				tblData[i][2]=product.get(i).getCategory();
				tblData[i][3]=product.get(i).getNum();
				tblData[i][4]=product.get(i).getOriPrice();
				tblData[i][5]=product.get(i).getVipPrice();
			}	
		}catch(BaseException e) {
			e.printStackTrace();
		}
	}
	private void reloadproduct(String ProductName) {
		try {
			List<BeanProduct> product=(new ProductManager()).loadProduct(ProductName);
			if(product.isEmpty()) {
				JOptionPane.showMessageDialog(null,"商品不存在","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			tblData=new Object[product.size()][6];
			for(int i=0;i<product.size();i++) {
				tblData[i][0]=product.get(i).getId();
				tblData[i][1]=product.get(i).getProductName();
				tblData[i][2]=product.get(i).getCategory();
				tblData[i][3]=product.get(i).getNum();
				tblData[i][4]=product.get(i).getOriPrice();
				tblData[i][5]=product.get(i).getVipPrice();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.userTable.validate();
			this.userTable.repaint();
		}catch(BaseException e) {
			e.printStackTrace();
		}
	}
	public FrmProduct(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setSize(800, 40);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(GoIntoDish);
		toolBar.add(addProduct);
		toolBar.add(buy);
		toolBar.add(edtsearch);
		toolBar.add(search_p);
		toolBar.add(discount);
		toolBar.add(moreinform);
		toolBar.add(feedBack);
		toolBar.add(back);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		this.reloadproductTable();
		this.getContentPane().add(new JScrollPane(this.userTable), BorderLayout.CENTER);
		
		this.setSize(800,600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		this.validate();
		
this.addProduct.addActionListener(this);
this.GoIntoDish.addActionListener(this);
this.addProduct.addActionListener(this);
this.search_p.addActionListener(this);
this.discount.addActionListener(this);
this.moreinform.addActionListener(this);
this.buy.addActionListener(this);
this.back.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource()==this.search_p) {
	this.reloadproduct(this.edtsearch.getText());
}
else if(e.getSource()==this.GoIntoDish) {
	FrmDish dlg=new FrmDish(this,"生鲜",true);
	dlg.setVisible(true);
	this.reloadproductTable();
}
else if(e.getSource()==this.discount) {
	FrmDiscount dlg=new FrmDiscount(this,"折扣",true);
	dlg.setVisible(true);
	this.reloadproductTable();
}
else if(e.getSource()==this.buy) {
	FrmBuyer dlg=new FrmBuyer(this,"购物车",true);
}
else if(e.getSource()==this.addProduct) {
	
}
else if(e.getSource()==this.feedBack) {
	//进入反馈界面
}
else if(e.getSource()==this.moreinform) {
	//进入商品详细信息界面
}
else if(e.getSource()==this.back) {
   this.setVisible(false);
	return ;
}
	}

}
