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

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Fee extends JFrame {
	
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;

	private JLabel lblReg_Fee;
	private JPanel contentPane;
	private JTable View_Fee_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Fee frame = new View_Fee();
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
	

	public void Get_Registration_Fee()
	{
			
		String sql="Select * from registration_fee";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
           while(rs.next())
           {
           lblReg_Fee.setText(rs.getString("registration_fee"));
            
           }
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
	}
	
	public void Get_View_Fee()
	{
			
		String sql="Select id as'ID',duration as'Duration(In Month) ',amount as 'Amount' from fees";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
         //   rs.next();
            View_Fee_Table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
	}
	
	public View_Fee() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 407, 509);
		
		setLocationRelativeTo(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 401, 47);
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblViewFeeDetails = new JLabel("View Fee Details");
		lblViewFeeDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblViewFeeDetails.setBounds(113, 11, 155, 25);
		panel.add(lblViewFeeDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 391, 325);
		contentPane.add(scrollPane);
		
		View_Fee_Table = new JTable();
		View_Fee_Table.setShowGrid(false);
		scrollPane.setViewportView(View_Fee_Table);
		View_Fee_Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Duration (In Month)", "Amount"
			}
		));
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Get_View_Fee();
			}
		});
		btnRefresh.setIcon(new ImageIcon(View_Fee.class.getResource("/images/refresh.png")));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(293, 58, 105, 23);
		contentPane.add(btnRefresh);
		
		JLabel lblCurrentRegistrationFee = new JLabel("Registration Fee Status:");
		lblCurrentRegistrationFee.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentRegistrationFee.setBounds(10, 58, 166, 23);
		contentPane.add(lblCurrentRegistrationFee);
		
		lblReg_Fee = new JLabel("");
		lblReg_Fee.setForeground(new Color(0, 191, 255));
		lblReg_Fee.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReg_Fee.setBounds(174, 58, 105, 23);
		contentPane.add(lblReg_Fee);
		Get_Registration_Fee();
	}
}
