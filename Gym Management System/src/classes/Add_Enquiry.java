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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Add_Enquiry extends JFrame {
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField txteid;
	private JTextField txtename;
	private JTextField txtaddress;
	private JTextField txtcontact;
	private JTextField txtefor;
	private JTextField txteemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Enquiry frame = new Add_Enquiry();
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
	public Add_Enquiry() {
		setTitle("Gym || Adding Enquiry ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 260, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 257, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdjust = new JLabel("Adding Enquiry");
		lblAdjust.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdjust.setBounds(63, 11, 150, 30);
		panel.add(lblAdjust);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 2), "Add Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 54, 241, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnquiryId = new JLabel("Enquiry ID:");
		lblEnquiryId.setBounds(6, 16, 80, 23);
		panel_1.add(lblEnquiryId);
		lblEnquiryId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(6, 41, 80, 14);
		panel_1.add(lblFullName);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 66, 80, 14);
		panel_1.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblConactNo = new JLabel("Conact No:");
		lblConactNo.setBounds(6, 91, 80, 14);
		panel_1.add(lblConactNo);
		lblConactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnquryFor = new JLabel("Enqury For:");
		lblEnquryFor.setBounds(6, 116, 80, 23);
		panel_1.add(lblEnquryFor);
		lblEnquryFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(6, 143, 80, 14);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txteid = new JTextField();
		txteid.setBounds(96, 19, 132, 20);
		panel_1.add(txteid);
		txteid.setForeground(new Color(0, 128, 128));
		txteid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txteid.setColumns(10);
		
		txtename = new JTextField();
		txtename.setBounds(96, 40, 132, 20);
		panel_1.add(txtename);
		txtename.setForeground(new Color(0, 128, 128));
		txtename.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtename.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(96, 65, 132, 20);
		panel_1.add(txtaddress);
		txtaddress.setForeground(new Color(0, 128, 128));
		txtaddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtaddress.setColumns(10);
		
		txtcontact = new JTextField();
		txtcontact.setBounds(96, 90, 132, 20);
		panel_1.add(txtcontact);
		txtcontact.setForeground(new Color(0, 128, 128));
		txtcontact.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtcontact.setColumns(10);
		
		txtefor = new JTextField();
		txtefor.setBounds(96, 119, 132, 20);
		panel_1.add(txtefor);
		txtefor.setForeground(new Color(0, 128, 128));
		txtefor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtefor.setColumns(10);
		
		txteemail = new JTextField();
		txteemail.setBounds(96, 142, 132, 20);
		panel_1.add(txteemail);
		txteemail.setForeground(new Color(0, 128, 128));
		txteemail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txteemail.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_2.setBounds(10, 228, 241, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * con=Connect.connectDb();
					 
										
					String sql="Insert into enquiry(fullname,address,contact,enquiry_for,email,date) values('"+txtename.getText()+"','"+txtaddress.getText()+"',"+txtcontact.getText()+",'"+txtefor.getText()+","+txteemail.getText()+"')";
					
					pst=con.prepareStatement(sql);
					if(pst.execute())
					{
						JOptionPane.showMessageDialog(null, "Sorry Registration fee canot be inserted");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "New Registration fee is Inserted");
					}
					pst.close();
					con.close();
					
					
				*/
					JOptionPane.showMessageDialog(null, "New enquiry is Inserted");
					hide();
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
				
				
			}
		});
		btnSave.setIcon(new ImageIcon(Add_Enquiry.class.getResource("/images/save.png")));
		btnSave.setBounds(29, 11, 89, 23);
		panel_2.add(btnSave);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(Add_Enquiry.class.getResource("/images/cancel.png")));
		btnCancel.setBounds(128, 11, 103, 23);
		panel_2.add(btnCancel);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}
}
