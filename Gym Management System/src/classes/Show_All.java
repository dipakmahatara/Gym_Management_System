package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Show_All extends JFrame {


	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	public JButton btnUpdate,btnNew,btnDelete;
	private JPanel contentPane;
	private JTable Member_Table;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_All frame = new Show_All();
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
	public void Get_Data()
	{
		String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',gender as 'Gender',reg_date as 'Registered Date',weight as 'Weight',contact_no as 'Contact No',country as 'Country',address as 'Address',email as 'Email' from members";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next();
            Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
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
	public Show_All() {
		setTitle("Gym || Show All Members");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 60, 1360, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 49, 1344, 522);
		contentPane.add(scrollPane);
		
	
		
		Member_Table = new JTable();
		Member_Table.setShowGrid(false);
		Member_Table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(Member_Table);
		Member_Table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), new Integer(310), "Dipak Bhandari", "Male", null, new Integer(60), new Double(9.809522227E9), "Nepal", "Salyan", "bhandari@gmail.com"},
				{new Integer(2), new Integer(21564), "Bhupal Singh", "Male", null, new Integer(454), new Double(8956424.0), "Nepal", "Karnali", "dgd@gmail.com"},
				{new Integer(3), new Integer(24445), "Rajan Dangi", "Female", null, new Integer(454), new Double(8956424.0), "Nepal", "Salyan", "dgd@gmail.com"},
				{new Integer(4), new Integer(8965), "Hari Bahadur", "Male", null, new Integer(60), new Double(9.847562145E9), "China", "Pune", "hari@gmail.com"},
				{new Integer(5), new Integer(454), "Polo", "Male", null, new Integer(45), new Double(9.8561204E7), "Nepal", "Pyuthan", "polo@gmail.com"},
				{new Integer(10), new Integer(800), "Giriraj Basel", "Male", null, new Integer(70), new Double(9.809865145E9), "Nepal", "Butwal", "giriraj701@gmail.com"},
				{new Integer(7), new Integer(101), "Deep", "Male", null, new Integer(56), new Double(9.809522227E9), "Nepal", "Pyuthan", "dip@gmail.com"},
			},
			new String[] {
				"ID", "Membership No", "Full Name", "Gender", "Registered Date", "Weight", "Contact No", "Country", "Address", "Email"
			}
		));
		
		btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Member adm=new Add_Member();
				adm.show();
				
			}
		});
		btnNew.setIcon(new ImageIcon(Show_All.class.getResource("/images/add product.png")));
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNew.setBounds(10, 11, 95, 23);
		contentPane.add(btnNew);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="Select * from members where membership_no="+txtSearch.getText()+"";
		        try{
		        	con=Connect.connectDb();
		            pst=con.prepareStatement(sql);
		            rs=pst.executeQuery();
		           if( rs.next())
		           {
		            Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
		           		           }
		           else {
		        	   JOptionPane.showMessageDialog(null, "There is no any data having Membership_No:"+txtSearch.getText()+"");
		           }
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
		});
		btnSearch.setIcon(new ImageIcon(Show_All.class.getResource("/images/search member.png")));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(1003, 11, 89, 23);
		contentPane.add(btnSearch);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					DefaultTableModel table = (DefaultTableModel)Member_Table.getModel();
			        String search = txtSearch.getText();
			        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
			        Member_Table.setRowSorter(tr);
			        tr.setRowFilter(RowFilter.regexFilter(search));
					
			}
		});
		txtSearch.setBounds(883, 12, 110, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblMembershipNo = new JLabel("Membership No:");
		lblMembershipNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMembershipNo.setBounds(764, 15, 110, 14);
		contentPane.add(lblMembershipNo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1344, 47);
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con= Connect.connectDb();
				
				int row= Member_Table.getSelectedRow();
				if(row>0)
				{
				String table_click=Member_Table.getModel().getValueAt(row,0).toString();
				
				Add_Member adm=new Add_Member();
				adm.lblAddingNewMember.setText("Updating Member");
				adm.btnSave.setText("Update");
				adm.updating(table_click);
				adm.show();
				}
				else {
					JOptionPane.showMessageDialog(Member_Table, "Please select at least one row");
				}
			}
		});
		btnUpdate.setBounds(120, 11, 110, 23);
		panel.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon(Show_All.class.getResource("/images/ediit.png")));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Get_Data();
			}
		});
		btnRefresh.setBounds(240, 11, 107, 23);
		panel.add(btnRefresh);
		btnRefresh.setIcon(new ImageIcon(Show_All.class.getResource("/images/refresh.png")));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					con= Connect.connectDb();
					
					int row= Member_Table.getSelectedRow();
					if(row>0)
					{
						int p=JOptionPane.showConfirmDialog(null,"Are you sure to delete" , "Delete Confirmation", JOptionPane.YES_NO_OPTION);
						if(p==0)
						{
							
						String table_click=Member_Table.getModel().getValueAt(row,0).toString();
					String sql="Delete from members where id="+table_click+"";
					pst=con.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(Member_Table, "Deleted successfully");
					}
					}
					else {
						JOptionPane.showMessageDialog(Member_Table, "Pleasse select any history");
						
						
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnDelete.setIcon(new ImageIcon(Show_All.class.getResource("/images/delete1.png")));
		btnDelete.setBounds(357, 11, 95, 23);
		panel.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnLatest = new JButton("Latest");
		btnLatest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=Connect.connectDb();
					String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',gender as 'Gender',reg_date as 'Registered Date',weight as 'Weight',contact_no as 'Contact No',country as 'Country',address as 'Address',email as 'Email' from members order by id desc";
			            con=Connect.connectDb();
			            pst=con.prepareStatement(sql);
			            rs=pst.executeQuery();
			        
			            Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
			                  
					
				}catch(Exception eee)
				{
					JOptionPane.showMessageDialog(null, eee);
				}
			}
		});
		btnLatest.setBounds(462, 11, 101, 23);
		panel.add(btnLatest);
		btnLatest.setIcon(new ImageIcon(Show_All.class.getResource("/images/latest history.png")));
		btnLatest.setFont(new Font("Tahoma", Font.BOLD, 13));
		//Get_Data();
	}
}
