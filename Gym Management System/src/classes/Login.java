package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton; 
import javax.swing.JTextField;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	private  JComboBox comboUserType ;
	private JPanel contentPane;
	JTextField txtUsername;
	private JPasswordField txtPassword;
	public String Hitory_User;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public void loggedIn()
	{
		con=Connect.connectDb();
		String uname=txtUsername.getText();
		Hitory_User=txtUsername.getText();
		String pasw=String.valueOf(txtPassword.getPassword());
                
		String sql="Select * from login where username='"+uname+"' and password='"+pasw+"'";
		
	     try{
	         pst=con.prepareStatement(sql);
	         rs=pst.executeQuery();
	          
		if(rs.next())
		{
			if(comboUserType.getSelectedItem().equals("admin"))
			{
			Date det=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String date=format.format(det);
			String msz="Logged in by "+Hitory_User;
			String sql1="Insert into history(date,task) values(?,?)";
			pst=con.prepareStatement(sql1);
			pst.setString(1, date);
			pst.setString(2, msz);
			pst.execute();
			rs.close();
			pst.close();
			
			Main_Window mnwd= new Main_Window();
			JOptionPane.showMessageDialog(null, "Login Successfully!!\nYou are Welcome in Our Gym Syemtem");
			hide();
			mnwd.show();
		}
			else {
				Date det=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				String date=format.format(det);
				String msz="Logged in by "+Hitory_User;
				String sql1="Insert into history(date,task) values(?,?)";
				pst=con.prepareStatement(sql1);
				pst.setString(1, date);
				pst.setString(2, msz);
				pst.execute();
				rs.close();
				pst.close();
				
				User_Frame ufwd= new User_Frame();
				JOptionPane.showMessageDialog(null, "Login Successfully!!\nYou are Welcome in Our Gym Syemtem");
				hide();
				ufwd.show();
				
			}
		}

	else {
		JOptionPane.showMessageDialog(null, "Incorrect username and password!!!");
	}
	}catch(SQLException e)
	    
	     {
			JOptionPane.showMessageDialog(null, e);
	     }
	    
	}
	
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/gymm.png")));
		setResizable(false);
		setTitle("Deep Da Gym || Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 416, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			loggedIn();
			}
		});
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/images/login.png")));
		btnLogin.setBounds(91, 143, 91, 23);
		contentPane.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Login.class.getResource("/images/cancel.png")));
		btnExit.setBounds(188, 143, 91, 23);
		contentPane.add(btnExit);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					loggedIn();
				}
			}
		});
		txtUsername.setBounds(91, 57, 188, 23);
		contentPane.add(txtUsername);
		txtUsername.setForeground(new Color(34, 139, 34));
		txtUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 58, 71, 19);
		contentPane.add(lblUsername);
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 88, 71, 19);
		contentPane.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp sign= new SignUp();
				setVisible(false);
				sign.show();
			}
		});
		btnSignUp.setIcon(new ImageIcon(Login.class.getResource("/images/signup.png")));
		btnSignUp.setBounds(133, 177, 102, 23);
		contentPane.add(btnSignUp);
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					loggedIn();
				}
			}
		});
		txtPassword.setBounds(91, 87, 188, 23);
		contentPane.add(txtPassword);
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtPassword.setForeground(new Color(34, 139, 34));
		String under= "<html><u>forgot password<u><html>";
		Cursor cur= new Cursor(Cursor.HAND_CURSOR);
		JLabel lblForgotPassword = new JLabel();
		lblForgotPassword.setCursor(cur);
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Forgot forgot= new Forgot();
				hide();
				forgot.show();
				
			}
		});
		lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblForgotPassword.setForeground(Color.BLUE);
		lblForgotPassword.setText(under);
		lblForgotPassword.setBounds(20, 186, 100, 14);
		contentPane.add(lblForgotPassword);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/username.png")));
		label_1.setBounds(284, 62, 24, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/images/password.png")));
		label_2.setBounds(284, 91, 24, 23);
		contentPane.add(label_2);
		
		comboUserType = new JComboBox();
		comboUserType.setFont(new Font("Times New Roman", Font.BOLD, 13));
		comboUserType.setForeground(new Color(0, 128, 0));
		comboUserType.setModel(new DefaultComboBoxModel(new String[] {"admin", "user"}));
		comboUserType.setBounds(91, 118, 188, 20);
		contentPane.add(comboUserType);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserType.setBounds(10, 118, 71, 19);
		contentPane.add(lblUserType);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 410, 211);
		contentPane.add(label);
		label.setIcon(new ImageIcon(Login.class.getResource("/images/login1.png")));
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtUsername, btnLogin, btnExit, lblUsername, lblPassword}));
		
		
	}
}
