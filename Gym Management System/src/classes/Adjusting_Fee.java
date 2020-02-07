package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adjusting_Fee extends JFrame {
	
	 Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;

	private JPanel contentPane;
	private JTable Fee_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adjusting_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adjusting_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adjusting_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adjusting_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adjusting_Fee frame = new Adjusting_Fee();
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
	public void Get_Fee()
	{
		String sql="Select id as'ID',duration as'Duration(in month)',amount as 'Amount' from fees";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            Fee_Table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        finally {
	    	   try {
	    		   pst.close();
	    		   rs.close();
	    		   con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
	       }
	
	}
	public Adjusting_Fee() {
		setTitle("Gym || Adjust Fee");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 407, 509);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 398, 47);
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdjustDuration = new JLabel("Adjust Gym Fee With Duration ");
		lblAdjustDuration.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdjustDuration.setBounds(49, 11, 296, 25);
		panel.add(lblAdjustDuration);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Fee_Value uffv= new Update_Fee_Value();
				uffv.btnUpdate.setText("Save");
				uffv.lblUpdatingFee.setText("Insert new Duration & Fee");
				uffv.ForInsert();
				uffv.show();
		
			}
		});
		btnNewButton.setIcon(new ImageIcon(Adjusting_Fee.class.getResource("/images/add product.png")));
		btnNewButton.setBounds(10, 48, 79, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=Fee_Table.getSelectedRow();
				if(row>0)
				{
					String table_click=Fee_Table.getModel().getValueAt(row,0).toString();
					Update_Fee_Value ufv= new Update_Fee_Value();
					ufv.updating_fees(table_click);
					ufv.show();
				}
				else {
					JOptionPane.showMessageDialog(Fee_Table, "     Please select a row");
				}
			}
		});
		btnUpdate.setIcon(new ImageIcon(Adjusting_Fee.class.getResource("/images/updateUser.png")));
		btnUpdate.setBounds(93, 48, 95, 23);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_1 = new JButton("Update All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Overall_Fee update=new Update_Overall_Fee();
				update.show();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Adjusting_Fee.class.getResource("/images/update.png")));
		btnNewButton_1.setBounds(189, 48, 101, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Get_Fee();
			}
		});
		btnRefresh.setIcon(new ImageIcon(Adjusting_Fee.class.getResource("/images/refresh.png")));
		btnRefresh.setBounds(292, 48, 93, 23);
		contentPane.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 74, 381, 400);
		contentPane.add(scrollPane);
		
		Fee_Table = new JTable();
		Fee_Table.setShowGrid(false);
		Fee_Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(Fee_Table);
		Get_Fee();
	}

}
