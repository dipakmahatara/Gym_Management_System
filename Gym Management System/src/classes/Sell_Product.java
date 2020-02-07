package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class Sell_Product extends JFrame {
	
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtpname;
	private JTextField txtavquantity;
	private JTextField txtAMount2;
	private JTextField txtdiscount;
	private JTextField txtTotal;
	private JTextField txtChange;
	private JTextField txtCustomer_Name;
	private JTextField txtsp;
	private JTextField txtsoldqaulity;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sell_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sell_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sell_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sell_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sell_Product frame = new Sell_Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	String[][] data= {{"1","Boost Powder","3","5000"},
						{"2","Hand Dumble 5 Kg","4","1700"},
						{"3","Hand Dumble 100 Kg","2","1640"},
						{"4","Massage Oil","10","1470"},
				};

String[] col= {"ID","Product Name","Quantity","Amount"} ; 
private JTable confirm_table;
private JTextField txtPaid;
private JTextField txtcategory;
	public Sell_Product() {
		setTitle("Gym || Sell Product");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(380, 150, 719, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 2), "Step 1 : Enter Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 52, 339, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnterId = new JLabel("Enter ID:");
		lblEnterId.setBounds(6, 17, 91, 14);
		panel_1.add(lblEnterId);
		lblEnterId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(6, 63, 91, 23);
		panel_1.add(lblCategory);
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(6, 42, 91, 14);
		panel_1.add(lblProductName);
		lblProductName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblSoldQuality = new JLabel("Sold Quantity");
		lblSoldQuality.setBounds(6, 141, 91, 23);
		panel_1.add(lblSoldQuality);
		lblSoldQuality.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				try {
					con=Connect.connectDb();
					String sql="Select * from product where product_id="+txtid.getText()+"";
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					rs.next();
					{
				txtpname.setText(rs.getString("product_name"));
				txtcategory.setText(rs.getString("category"));
				txtsp.setText(rs.getString("sell_price"));
				txtavquantity.setText(rs.getString("opening_stock"));
				
				pst.close();
				rs.close();
				con.close();
					}
				}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				finally {
						try {
							pst.close();
							rs.close();
							con.close();
						} catch (Exception e3) {
							JOptionPane.showMessageDialog(null, e3);
						}
					}
			}
		});
		txtid.setBounds(144, 16, 166, 20);
		panel_1.add(txtid);
		txtid.setColumns(10);
		
		txtpname = new JTextField();
		txtpname.setEnabled(false);
		txtpname.setBounds(144, 41, 166, 20);
		panel_1.add(txtpname);
		txtpname.setColumns(10);
		
		txtavquantity = new JTextField();
		txtavquantity.setEnabled(false);
		txtavquantity.setBounds(144, 90, 166, 20);
		panel_1.add(txtavquantity);
		txtavquantity.setColumns(10);
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  DefaultTableModel table = (DefaultTableModel)confirm_table.getModel();
				 
				  	String id=txtid.getText();
			        String name = txtpname.getText();
			        String quantity =txtsoldqaulity.getText();
			        
			        int a=Integer.parseInt(quantity);
			        int b=Integer.parseInt(txtsp.getText());
			        int aamount=a*b;
			        String amount =String.valueOf(aamount);
			       
			        table.addRow(new Object[]{id,name,quantity,amount});
			}
		});
		btnAddToCart.setIcon(new ImageIcon(Sell_Product.class.getResource("/images/add cart.png")));
		btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddToCart.setBounds(193, 165, 117, 23);
		panel_1.add(btnAddToCart);
		
		JLabel lblYouCanAdd = new JLabel("You can add number of item");
		lblYouCanAdd.setBounds(6, 169, 177, 14);
		panel_1.add(lblYouCanAdd);
		lblYouCanAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblSellingPrice = new JLabel("Selling Price");
		lblSellingPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSellingPrice.setBounds(6, 118, 91, 23);
		panel_1.add(lblSellingPrice);
		
		JLabel lblAvQuality = new JLabel("Av. Quantity");
		lblAvQuality.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAvQuality.setBounds(6, 89, 91, 18);
		panel_1.add(lblAvQuality);
		
		txtsp = new JTextField();
		txtsp.setEnabled(false);
		txtsp.setColumns(10);
		txtsp.setBounds(144, 118, 166, 20);
		panel_1.add(txtsp);
		
		txtsoldqaulity = new JTextField();
		txtsoldqaulity.setColumns(10);
		txtsoldqaulity.setBounds(144, 144, 166, 20);
		panel_1.add(txtsoldqaulity);
		
		txtcategory = new JTextField();
		txtcategory.setEnabled(false);
		txtcategory.setColumns(10);
		txtcategory.setBounds(144, 66, 166, 20);
		panel_1.add(txtcategory);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 713, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSellProductsTo = new JLabel("Sell Products To Customer");
		lblSellProductsTo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSellProductsTo.setBounds(207, 11, 311, 29);
		panel.add(lblSellProductsTo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 2), "Step 3 : Final Process", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(6, 262, 697, 138);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(10, 17, 91, 14);
		panel_2.add(lblAmount);
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(10, 42, 91, 14);
		panel_2.add(lblDiscount);
		lblDiscount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(10, 59, 91, 19);
		panel_2.add(lblTotalAmount);
		lblTotalAmount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setBounds(10, 117, 91, 14);
		panel_2.add(lblChange);
		lblChange.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtAMount2 = new JTextField();
		txtAMount2.setEnabled(false);
		txtAMount2.setBounds(147, 11, 169, 20);
		panel_2.add(txtAMount2);
		txtAMount2.setColumns(10);
		
		txtdiscount = new JTextField();
		txtdiscount.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					int a=Integer.parseInt(txtAMount2.getText());
					int b=Integer.parseInt(txtdiscount.getText());
					int c=a-b;
					txtTotal.setText(String.valueOf(c));
					
			}
		});
		txtdiscount.setBounds(147, 36, 169, 20);
		panel_2.add(txtdiscount);
		txtdiscount.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setBounds(147, 60, 169, 20);
		panel_2.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtChange = new JTextField();
		txtChange.setEnabled(false);
		txtChange.setBounds(147, 111, 169, 20);
		panel_2.add(txtChange);
		txtChange.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(410, 29, 107, 14);
		panel_2.add(lblCustomerName);
		lblCustomerName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setBounds(410, 50, 107, 14);
		panel_2.add(lblInformation);
		lblInformation.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(523, 56, 146, 59);
		panel_2.add(textArea);
		
		txtCustomer_Name = new JTextField();
		txtCustomer_Name.setBounds(523, 28, 146, 20);
		panel_2.add(txtCustomer_Name);
		txtCustomer_Name.setColumns(10);
		
		txtPaid = new JTextField();
		txtPaid.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				int d=Integer.parseInt(txtPaid.getText());
				int change=Integer.parseInt(txtTotal.getText())-d;
				
				txtChange.setText(String.valueOf(change));
				
			}
		});
		txtPaid.setColumns(10);
		txtPaid.setBounds(147, 86, 169, 20);
		panel_2.add(txtPaid);
		
		JLabel lblPaidAmount = new JLabel("Paid Amount");
		lblPaidAmount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPaidAmount.setBounds(10, 87, 91, 14);
		panel_2.add(lblPaidAmount);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 2), "Step 2 : Confirm or Edit Order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(348, 52, 355, 199);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm_table.setModel(new DefaultTableModel(null, new String[] {"Product Id", "Product Name", "Quantity", "Amount"}));
				/* DefaultTableModel table = (DefaultTableModel)confirm_table.getModel();
				try{
					int row=confirm_table.getSelectedRow();
					if(row>0)
					{
					table.removeRow(row);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Select one row");
					}
				}
				catch(Exception e4)
				{
					JOptionPane.showMessageDialog(null, e4);
				}*/
				txtid.setText(null);
			}
		});
		btnDeleteAll.setIcon(new ImageIcon(Sell_Product.class.getResource("/images/delete.png")));
		btnDeleteAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteAll.setBounds(118, 160, 114, 23);
		panel_3.add(btnDeleteAll);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sum=0;
				int j=confirm_table.getRowCount();
				for(int i=0; i<j; i++)
				{
					sum=sum+Integer.parseInt(confirm_table.getValueAt(i, 3).toString());
					
				}
				txtAMount2.setText(String.valueOf(sum));
				txtAMount2.setEnabled(false);
				
			}
		});
		btnProceed.setIcon(new ImageIcon(Sell_Product.class.getResource("/images/paid.png")));
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProceed.setBounds(242, 160, 103, 23);
		panel_3.add(btnProceed);
		
		JLabel lblClickOnProceed = new JLabel("Click On Proceed");
		lblClickOnProceed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClickOnProceed.setBounds(6, 169, 114, 14);
		panel_3.add(lblClickOnProceed);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 335, 119);
		panel_3.add(scrollPane);
		
		confirm_table = new JTable();
		scrollPane.setViewportView(confirm_table);
		confirm_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product Id", "Product Name", "Quantity", "Amount"
			}
		));
		
		JLabel lblPleaseSureAll = new JLabel("Please sure all the Transcations is done correctly.! It can not be undone again");
		lblPleaseSureAll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseSureAll.setBounds(6, 409, 457, 14);
		contentPane.add(lblPleaseSureAll);
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						String name=txtCustomer_Name.getText();
						JOptionPane.showMessageDialog(null, "Products are successfully sell  to "+name);
					
					
			}
		});
		btnSell.setIcon(new ImageIcon(Sell_Product.class.getResource("/images/sell.png")));
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSell.setBounds(487, 405, 89, 23);
		contentPane.add(btnSell);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(Sell_Product.class.getResource("/images/cancel.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(597, 405, 106, 23);
		contentPane.add(btnCancel);
	}
}
