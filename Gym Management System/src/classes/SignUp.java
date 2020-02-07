package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	
	private JComboBox userType;
	private JPanel contentPane;
	private JPasswordField txtpasswordField;
	private JTextField txtfullname;
	private JTextField txtusername;
	private JTextField txtanswer;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setTitle("Sign Up Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 297, 443);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(64, 224, 208), 2));
		panel_1.setBounds(4, 356, 288, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login= new Login();
				hide();
				login.show();
			}
		});
		btnBack.setBounds(47, 16, 89, 23);
		panel_1.add(btnBack);
		btnBack.setIcon(new ImageIcon(SignUp.class.getResource("/images/back.png")));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(64, 224, 208), 2), "User Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 136, 288, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox txtcomboBox = new JComboBox();
		txtcomboBox.setBounds(126, 122, 156, 20);
		panel.add(txtcomboBox);
		txtcomboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your father name?", "What is your born city?", "Who is your Best Actor?"}));
		txtcomboBox.setSelectedIndex(0);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con=Connect.connectDb();
					String sql = " insert into login (username,password,full_name, security_question, answer,type)"
								+ " values (?, ?, ?, ?,?,?)";

	      	 PreparedStatement preparedStmt = con.prepareStatement(sql);
		     preparedStmt.setString (1,txtusername.getText());   
		     preparedStmt.setString (2,txtpasswordField.getText());
		     preparedStmt.setString (3,txtfullname.getText());
			 preparedStmt.setString	(4, (String)txtcomboBox.getSelectedItem());
			 preparedStmt.setString(5, txtanswer.getText());
			 preparedStmt.setString(6,userType.getSelectedItem().toString());
			 preparedStmt.execute();
		      JOptionPane.showMessageDialog(null, "you have successfully created new account");
		      preparedStmt.close();
		      con.close();
		      txtusername.setText(null);
		      txtpasswordField.setText(null);
		      txtfullname.setText(null);
		      txtanswer.setText(null);
		      userType.setSelectedItem(null);
		    }
		    catch (Exception e)
		    {
		    	JOptionPane.showMessageDialog(null, e);
		    }
			}
		});
		
		btnCreate.setBounds(161, 16, 101, 23);
		panel_1.add(btnCreate);
		btnCreate.setIcon(new ImageIcon(SignUp.class.getResource("/images/create.png")));
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		
		
		JLabel lblFirstName = new JLabel("Username");
		lblFirstName.setBounds(6, 66, 112, 14);
		panel.add(lblFirstName);
		lblFirstName.setFont(new Font("Yu Mincho Light", Font.PLAIN, 14));
		
		JLabel lblLastName = new JLabel("Full Name");
		lblLastName.setBounds(6, 30, 112, 14);
		panel.add(lblLastName);
		lblLastName.setFont(new Font("Yu Mincho Light", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(6, 97, 112, 14);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Yu Mincho Light", Font.PLAIN, 14));
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(6, 122, 112, 20);
		panel.add(lblSecurityQuestion);
		lblSecurityQuestion.setFont(new Font("Yu Mincho Light", Font.PLAIN, 14));
		
		
		
		txtpasswordField = new JPasswordField();
		txtpasswordField.setBounds(126, 91, 156, 20);
		panel.add(txtpasswordField);
		txtpasswordField.setForeground(Color.BLUE);
		txtpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(6, 153, 112, 20);
		panel.add(lblAnswer);
		lblAnswer.setFont(new Font("Yu Mincho Light", Font.PLAIN, 14));
		
		txtfullname = new JTextField();
		txtfullname.setBounds(126, 24, 156, 20);
		panel.add(txtfullname);
		txtfullname.setForeground(Color.BLUE);
		txtfullname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtfullname.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setBounds(126, 60, 156, 20);
		panel.add(txtusername);
		txtusername.setForeground(Color.BLUE);
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtusername.setColumns(10);
		
		txtanswer = new JTextField();
		txtanswer.setBounds(126, 153, 156, 20);
		panel.add(txtanswer);
		txtanswer.setForeground(Color.BLUE);
		txtanswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtanswer.setColumns(10);
		
		userType = new JComboBox();
		userType.setModel(new DefaultComboBoxModel(new String[] {"admin", "user"}));
		userType.setBounds(126, 184, 156, 20);
		panel.add(userType);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Yu Mincho Light", Font.PLAIN, 14));
		lblUserType.setBounds(6, 187, 112, 17);
		panel.add(lblUserType);
		
		JLabel lblCreateNewAccount = new JLabel("Create New Account");
		lblCreateNewAccount.setForeground(new Color(0, 128, 128));
		lblCreateNewAccount.setBounds(52, 106, 217, 25);
		contentPane.add(lblCreateNewAccount);
		lblCreateNewAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel label = new JLabel("");
		label.setBounds(84, 0, 122, 108);
		contentPane.add(label);
		label.setIcon(new ImageIcon(SignUp.class.getResource("/images/signuping.png")));
	}
}
