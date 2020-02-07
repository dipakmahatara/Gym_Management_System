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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Update_Overall_Fee extends JFrame {
	
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;


	private JPanel contentPane;
	private JTextField txtOnemnthValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Update_Overall_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Overall_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Overall_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Overall_Fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Overall_Fee frame = new Update_Overall_Fee();
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
	public Update_Overall_Fee() {
		setTitle("Gym || Update/Change Overall Fee");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 170);
		setLocationRelativeTo(new Adjusting_Fee());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 309, 46);
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdate = new JLabel("Update /Change Fee");
		lblUpdate.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblUpdate.setBounds(71, 11, 182, 24);
		panel.add(lblUpdate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=Connect.connectDb();
					String sql="select id from fees";
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					
					int value=Integer.parseInt(txtOnemnthValue.getText());
					int nextValue=value;
					int idNo=0;
					while(rs.next())
					{
						 idNo=rs.getInt("id");
						 String sql1="Update fees set amount="+value+" where id="+idNo+"";
						 pst=con.prepareStatement(sql1);
						 pst.execute();
						 value+=nextValue;
					}
					
					JOptionPane.showMessageDialog(null, "Updated Successfully");
	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnUpdate.setIcon(new ImageIcon(Update_Overall_Fee.class.getResource("/images/update.png")));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setForeground(new Color(255, 69, 0));
		btnUpdate.setBounds(106, 106, 97, 23);
		contentPane.add(btnUpdate);
		
		txtOnemnthValue = new JTextField();
		txtOnemnthValue.setBounds(68, 79, 166, 20);
		contentPane.add(txtOnemnthValue);
		txtOnemnthValue.setColumns(10);
		
		JLabel lblPleaseEnterOne = new JLabel("Please enter one month gym fee");
		lblPleaseEnterOne.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPleaseEnterOne.setBounds(58, 57, 204, 20);
		contentPane.add(lblPleaseEnterOne);
	}

}
