package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Show_All_Product extends JFrame {
	
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;

	private JPanel contentPane;
	private JTable Product_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Show_All_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show_All_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show_All_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show_All_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_All_Product frame = new Show_All_Product();
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
	
	public void Get_Product()
	{				
		String sql="Select product_id as'Product ID',product_name as 'Product Name',category as 'Category',sell_price as 'Pricee', opening_stock as 'Quantity',description as 'Discription' from product";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            Product_Table.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
 		    rs.close();
 		    con.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       finally{
    	   try {
    		   pst.close();
    		   rs.close();
    		   con.close();
    	   }
        	catch(Exception e){
        		
        	}
        }
	}
	
	public Show_All_Product() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 60, 1360, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 1324, 319);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1344, 47);
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblShowAllProducts = new JLabel("Show All Products");
		lblShowAllProducts.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblShowAllProducts.setBounds(564, 11, 219, 25);
		panel.add(lblShowAllProducts);
		
		Product_Table = new JTable();
		scrollPane.setViewportView(Product_Table);
		Product_Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Product Id", "Product Name", "Category", "Price", "Quantity", "Description"
			}
		));
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon(Show_All_Product.class.getResource("/images/refresh.png")));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(711, 61, 102, 23);
		contentPane.add(btnRefresh);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Product adpe=new Add_Product();
				adpe.show();
				
			}
		});
		btnNew.setIcon(new ImageIcon(Show_All_Product.class.getResource("/images/add product.png")));
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNew.setBounds(384, 61, 89, 23);
		contentPane.add(btnNew);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					con=Connect.connectDb();
				int row= Product_Table.getSelectedRow();
				if(row>0)
				{
					String table_click=Product_Table.getModel().getValueAt(row,0).toString();
				
				String sql="Delete from product where product_id='"+table_click+"'";
				pst=con.prepareStatement(sql);
				if(pst.execute())
				{
					JOptionPane.showMessageDialog(Product_Table, "Sorry product isnot cleared");
				}
				else
				{
					JOptionPane.showMessageDialog(Product_Table, "Selected product is deleted");
				}
				}
				else {
					JOptionPane.showMessageDialog(Product_Table, "Pleasse select any product");
					
					
				}
				
				
			}catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, ee);
			}
			}
		});
		btnDelete.setIcon(new ImageIcon(Show_All_Product.class.getResource("/images/delete.png")));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(492, 61, 102, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdate.setIcon(new ImageIcon(Show_All_Product.class.getResource("/images/update.png")));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(604, 61, 97, 23);
		contentPane.add(btnUpdate);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Get_Product();
			}
		});
	}
}
