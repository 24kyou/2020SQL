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

import fresh.control.DishManager;
import fresh.control.ProductManager;
import fresh.model.BeanDish;
import fresh.model.BeanProduct;
import fresh.util.BaseException;

public class FrmDish extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	
	private Button GoIntoProduct=new Button("商品");
	private Button addDish=new Button("添加菜品");
	private Button buy=new Button("购物车");
	private Button search_D=new Button("搜索菜品");
	private Button feedBack=new Button("菜品反馈");
	private Button discount =new Button("菜品优惠活动");
	private Button moreinform =new Button("菜品详细细信息");
	private Button back=new Button("退出");
	private Object tblData[][];
	private Object tblTitle[]= {"菜品编号","菜品名","菜品价格","商品数量","推荐值","信息"};
	private JTextField edtsearch=new JTextField(15);
	
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable userTable=new JTable(tablmod);
	private void reloadproductTable() {
		try {
			List<BeanDish> product=(new DishManager()).loadAllDish();
			tblData=new Object[product.size()][6];
			for(int i=0;i<product.size();i++) {
				tblData[i][0]=product.get(i).getDish_id();
				tblData[i][1]=product.get(i).getDish_name();
				tblData[i][2]=product.get(i).getDish_price();
				tblData[i][3]=product.get(i).getDish_num();
				tblData[i][4]=product.get(i).getRecommend_values();
				tblData[i][5]=product.get(i).getCategories();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.userTable.validate();
			this.userTable.repaint();
		}catch(BaseException e) {
			e.printStackTrace();
		}
	}
	private void reloadproduct(String ProductName) {
		try {
			List<BeanDish> product=(new DishManager()).loadProduct(ProductName);
			if(product.isEmpty()) {
				JOptionPane.showMessageDialog(null,"商品不存在","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			tblData=new Object[product.size()][6];
			for(int i=0;i<product.size();i++) {
				tblData[i][0]=product.get(i).getDish_id();
				tblData[i][1]=product.get(i).getDish_name();
				tblData[i][2]=product.get(i).getDish_price();
				tblData[i][3]=product.get(i).getDish_num();
				tblData[i][4]=product.get(i).getRecommend_values();
				tblData[i][5]=product.get(i).getInformation();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.userTable.validate();
			this.userTable.repaint();
		}catch(BaseException e) {
			e.printStackTrace();
		}
	}
   public FrmDish(JDialog f,String s,boolean b) {
	   super(f, s, b);
	   toolBar.setSize(800, 40);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(GoIntoProduct);
		toolBar.add(addDish);
		toolBar.add(buy);
		toolBar.add(edtsearch);
		toolBar.add(search_D);
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
		
this.addDish.addActionListener(this);
this.GoIntoProduct.addActionListener(this);
this.addDish.addActionListener(this);
this.search_D.addActionListener(this);
this.discount.addActionListener(this);
this.moreinform.addActionListener(this);
this.buy.addActionListener(this);
this.back.addActionListener(this);
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
