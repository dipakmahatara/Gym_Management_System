package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class View_Enquiry extends JFrame {

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Enquiry frame = new View_Enquiry();
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
	public void view_inquiry()
	{
													
		
String sql="Select id as'ID',fullname as 'Full Name',address as 'Address',enquiry_for as 'InQuiry For',email as 'Email',date as 'Date' from enquiry";
try{
	con=Connect.connectDb();
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    
    table.setModel(DbUtils.resultSetToTableModel(rs));
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
	public View_Enquiry() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 320);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 0, 594, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblViewAllEnquiries = new JLabel("View All Enquiries");
		lblViewAllEnquiries.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewAllEnquiries.setBounds(192, 11, 191, 25);
		panel.add(lblViewAllEnquiries);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 110, 584, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowGrid(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		JButton btnRespond = new JButton("Respond");
		btnRespond.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRespond.setBounds(213, 74, 106, 25);
		contentPane.add(btnRespond);
		view_inquiry();
	}
}
