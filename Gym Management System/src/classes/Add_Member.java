package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Add_Member extends JFrame {

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	 private String updatedMember;
	 private JRadioButton rdbtnFemale;
	 private JRadioButton rdbtnMale;
	 private ImageIcon finalImage;
	 private String filename;
	 private String gender=null;
	 private String contryVal=null;
	 
	public JButton btnSave;
	public JLabel lblAddingNewMember;
	private JComboBox comboCountry;
	  JPanel contentPane;
	  private JTextField txtmemberno;
	  private JTextField txtWeight;
	  private JTextField txtEmail;
	  private JTextField txtOccupation;
	  private JTextField textContact;
	  private JTextField txtPaidfee;
	  private JTextField txtAddress;
	  private JTextField txtFullname;
	  private JTextField txtId;
	  private ButtonGroup btnGroup;
	  private JComboBox cmbxStatus;
	  private JTextArea txtDiscription ;
	  private JDateChooser startDate;
	  private JDateChooser registeredDate;
	  private JDateChooser endDate;
	  private JDateChooser dob;
	  private JComboBox cmbxDuration;
	  private JComboBox cmbxFeesmode;
	  private JLabel lblPhoto;

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
					Add_Member frame = new Add_Member();
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
	public void updating(String idno)
	{
		con=Connect.connectDb();
		 String sql="select * from members where id='"+idno+"'";
	       try {
		    	pst=con.prepareStatement(sql);
		        rs=pst.executeQuery();
		        if(rs.next())
		        {
		        	  txtId.setText(rs.getString("id"));
		        	  txtmemberno.setText(rs.getString("membership_no"));
		        	  txtFullname.setText(rs.getString("full_name"));
		        	  txtEmail.setText(rs.getString("email"));
		        	  txtOccupation.setText(rs.getString("occupation"));
		        	  String rgender=rs.getString("gender");
		        	  if(rgender.equals("Male"))
		        	  {
		        		  rdbtnMale.setSelected(true);
		        		  gender="Male";
		        	  }
		        	  else {
		        		  rdbtnFemale.setSelected(true);
		        		  gender="Female";
		        	  }
		        	 
		        	  txtAddress.setText(rs.getString("address"));
		        	  cmbxStatus.setSelectedItem(rs.getString("status"));
		        	  comboCountry.setSelectedItem(rs.getString("country"));
		        	  txtWeight.setText(rs.getString("weight"));
		        	  startDate.setDate(rs.getDate("start_date"));
		        	  endDate.setDate(rs.getDate("end_date"));
		        	  registeredDate.setDate(rs.getDate("reg_date"));
		        	  cmbxFeesmode.setSelectedItem(rs.getString("fees_mode"));
		        	  txtPaidfee.setText(rs.getString("paid_fee"));
		        	  cmbxDuration.setSelectedItem(rs.getString("duration"));
		        	  txtDiscription.setText(rs.getString("discription"));
		        	  dob.setDate(rs.getDate("dob"));
		        	  textContact.setText(rs.getString("contact_no"));
		        	  byte[] imagebytes = rs.getBytes("img");
		        	  Image image=getToolkit().createImage(imagebytes);
		        	  Image newImage=image.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),Image.SCALE_SMOOTH);
			    	  ImageIcon icon=new ImageIcon(newImage);		        	 
		        	  lblPhoto.setIcon(icon);
		        	  
		        	  txtOccupation.setText(rs.getString("occupation"));
		        	  
		        	   pst.close();
		    		   rs.close();
		    		   con.close();
					
				
				}
		        
	       }catch(Exception e)
	       {
	    	   JOptionPane.showMessageDialog(null, e);
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
	public Add_Member() {
		setTitle("Gym || Adding New Member");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(280, 150, 860, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullname = new JLabel("Full Name");
		lblFullname.setForeground(Color.ORANGE);
		lblFullname.setBackground(Color.WHITE);
		lblFullname.setBounds(194, 45, 79, 14);
		lblFullname.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		contentPane.add(lblFullname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.ORANGE);
		lblGender.setBackground(Color.WHITE);
		lblGender.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblGender.setBounds(194, 101, 118, 14);
		contentPane.add(lblGender);
		
		JLabel lblContact = new JLabel("Contact No");
		lblContact.setForeground(Color.ORANGE);
		lblContact.setBackground(Color.WHITE);
		lblContact.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblContact.setBounds(194, 126, 118, 14);
		contentPane.add(lblContact);
		
		JLabel lblDateofbirth = new JLabel("Date Of Birth");
		lblDateofbirth.setForeground(Color.ORANGE);
		lblDateofbirth.setBackground(Color.WHITE);
		lblDateofbirth.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblDateofbirth.setBounds(194, 151, 118, 14);
		contentPane.add(lblDateofbirth);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.ORANGE);
		lblWeight.setBackground(Color.WHITE);
		lblWeight.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblWeight.setBounds(194, 261, 128, 14);
		contentPane.add(lblWeight);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.ORANGE);
		lblDuration.setBackground(Color.WHITE);
		lblDuration.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblDuration.setBounds(194, 311, 118, 14);
		contentPane.add(lblDuration);
		
		JLabel lblPaidfee = new JLabel("Paid Fee");
		lblPaidfee.setForeground(Color.ORANGE);
		lblPaidfee.setBackground(Color.WHITE);
		lblPaidfee.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblPaidfee.setBounds(194, 336, 118, 14);
		contentPane.add(lblPaidfee);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.ORANGE);
		lblStatus.setBackground(Color.WHITE);
		lblStatus.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblStatus.setBounds(194, 286, 118, 14);
		contentPane.add(lblStatus);
		
		JLabel lblStartdate = new JLabel("Start Date");
		lblStartdate.setForeground(Color.ORANGE);
		lblStartdate.setBackground(Color.WHITE);
		lblStartdate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblStartdate.setBounds(526, 176, 127, 14);
		contentPane.add(lblStartdate);
		
		JLabel lblEnddate = new JLabel("End Date");
		lblEnddate.setForeground(Color.ORANGE);
		lblEnddate.setBackground(Color.WHITE);
		lblEnddate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblEnddate.setBounds(536, 201, 127, 29);
		contentPane.add(lblEnddate);
		
		JLabel lblDiscription = new JLabel("Description");
		lblDiscription.setForeground(Color.ORANGE);
		lblDiscription.setBackground(Color.WHITE);
		lblDiscription.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblDiscription.setBounds(526, 241, 127, 14);
		contentPane.add(lblDiscription);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblEmail.setBounds(526, 48, 127, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.ORANGE);
		lblAddress.setBackground(Color.WHITE);
		lblAddress.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblAddress.setBounds(526, 126, 127, 14);
		contentPane.add(lblAddress);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setForeground(Color.ORANGE);
		lblOccupation.setBackground(Color.WHITE);
		lblOccupation.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblOccupation.setBounds(526, 95, 127, 14);
		contentPane.add(lblOccupation);
		
		JLabel lblRegistereddate = new JLabel("Registered Date");
		lblRegistereddate.setForeground(Color.ORANGE);
		lblRegistereddate.setBackground(Color.WHITE);
		lblRegistereddate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblRegistereddate.setBounds(526, 73, 127, 14);
		contentPane.add(lblRegistereddate);
		
		JLabel lblFeesmode = new JLabel("Fees Mode");
		lblFeesmode.setForeground(Color.ORANGE);
		lblFeesmode.setBackground(Color.WHITE);
		lblFeesmode.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblFeesmode.setBounds(526, 151, 127, 14);
		contentPane.add(lblFeesmode);
		
		JLabel lblMembershipNo = new JLabel("Membership No");
		lblMembershipNo.setForeground(Color.ORANGE);
		lblMembershipNo.setBackground(Color.WHITE);
		lblMembershipNo.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblMembershipNo.setBounds(194, 70, 118, 14);
		contentPane.add(lblMembershipNo);
		
		lblAddingNewMember = new JLabel("Adding New Member");
		lblAddingNewMember.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblAddingNewMember.setBounds(322, 0, 291, 37);
		contentPane.add(lblAddingNewMember);
		
		lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(Add_Member.class.getResource("/images/man.png")));
		lblPhoto.setBounds(0, 42, 184, 213);
		contentPane.add(lblPhoto);
		
		btnGroup=new ButtonGroup();
		
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser imgchooser=new JFileChooser();
				imgchooser.showOpenDialog(null);
				File f= new File(imgchooser.getSelectedFile().getPath());
				filename=f.getAbsolutePath();
				ImageIcon myImage= new ImageIcon(filename);
				Image  img= myImage.getImage();
				Image newImage=img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),Image.SCALE_SMOOTH);
				finalImage=new ImageIcon(newImage);
				lblPhoto.setIcon(finalImage);
				
						
			}
		});
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpload.setIcon(new ImageIcon(Add_Member.class.getResource("/images/upload.png")));
		btnUpload.setBounds(30, 261, 119, 23);
		contentPane.add(btnUpload);
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setIcon(new ImageIcon(Add_Member.class.getResource("/images/delete.png")));
		btnDelete.setBounds(30, 290, 119, 23);
		contentPane.add(btnDelete);
		
		
		
		txtmemberno = new JTextField();
		
		txtmemberno.setEnabled(false);
		try{con=Connect.connectDb();
		
		String sql1="Select membership_no from members";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int b=0;
		while(rs.next())
		{
			b=rs.getInt("membership_no");
		}
		b=b+1;
		String bb=String.valueOf(b);
		txtmemberno.setText(bb);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		txtmemberno.setForeground(new Color(0, 0, 0));
		txtmemberno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtmemberno.setBounds(322, 70, 181, 20);
		contentPane.add(txtmemberno);
		txtmemberno.setColumns(10);
		
		txtWeight = new JTextField();
		txtWeight.setForeground(new Color(0, 0, 0));
		txtWeight.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtWeight.setColumns(10);
		txtWeight.setBounds(322, 258, 181, 20);
		contentPane.add(txtWeight);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(663, 45, 181, 20);
		contentPane.add(txtEmail);
		
		txtOccupation = new JTextField();
		txtOccupation.setForeground(new Color(0, 0, 0));
		txtOccupation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtOccupation.setColumns(10);
		txtOccupation.setBounds(663, 98, 181, 20);
		contentPane.add(txtOccupation);
		
		textContact = new JTextField();
		textContact.setForeground(new Color(0, 0, 0));
		textContact.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textContact.setColumns(10);
		textContact.setBounds(322, 126, 181, 20);
		contentPane.add(textContact);
		
		txtPaidfee = new JTextField();
		txtPaidfee.setForeground(new Color(0, 0, 0));
		txtPaidfee.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPaidfee.setColumns(10);
		txtPaidfee.setBounds(322, 333, 181, 20);
		contentPane.add(txtPaidfee);
		
		txtDiscription = new JTextArea();
		txtDiscription.setBounds(662, 236, 182, 76);
		contentPane.add(txtDiscription);
		
		cmbxFeesmode = new JComboBox();
		cmbxFeesmode.setModel(new DefaultComboBoxModel(new String[] {"Monthly", "Quartly"}));
		cmbxFeesmode.setBounds(663, 151, 181, 20);
		contentPane.add(cmbxFeesmode);
		
		txtAddress = new JTextField();
		txtAddress.setForeground(new Color(0, 0, 0));
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(663, 126, 181, 20);
		contentPane.add(txtAddress);
		
		txtFullname = new JTextField();
		txtFullname.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					updatedMember=txtFullname.getText();
					
			}
				
		});
		txtFullname.setForeground(new Color(0, 0, 0));
		txtFullname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtFullname.setColumns(10);
		txtFullname.setBounds(322, 45, 181, 20);
		contentPane.add(txtFullname);
		
		 rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Male";
				}
		});
		rdbtnMale.setBounds(322, 97, 71, 23);
		contentPane.add(rdbtnMale);
		
		 rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Female";
			}
		});
		rdbtnFemale.setBounds(432, 97, 71, 23);
		contentPane.add(rdbtnFemale);
		btnGroup.add(rdbtnFemale);
		btnGroup.add(rdbtnMale);
		
		cmbxStatus = new JComboBox();
		cmbxStatus.setModel(new DefaultComboBoxModel(new String[] {"Registered"}));
		cmbxStatus.setBounds(322, 283, 181, 20);
		contentPane.add(cmbxStatus);
		
		dob = new JDateChooser();
		dob.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MMMMMM-dd");
				String s=format.format(dob.getDate());
				String arr[]=s.split("-");
				int year=Integer.parseInt(arr[0]);
				Month month=(Month.valueOf(arr[1].toUpperCase()));
				int day=Integer.parseInt(arr[2]);
				
				LocalDate localDate=LocalDate.now();
				LocalDate birthday=LocalDate.of(year, month, day);
				
				Period p=Period.between(birthday, localDate);
				int curAge=p.getYears();
				String curAge1=String.valueOf(curAge);
				
			}
		});
		
		
	
		
	
		dob.setDateFormatString(" yyyy-MM-dd");
		dob.getCalendarButton().setForeground(Color.BLACK);
		dob.setToolTipText("");
		dob.getCalendarButton().setToolTipText("");
		dob.getCalendarButton().setBackground(Color.WHITE);
		dob.setBounds(322, 151, 181, 20);
		contentPane.add(dob);
		
		endDate = new JDateChooser();
		endDate.setDateFormatString("yyyy-MM-dd");
		endDate.setBounds(663, 205, 181, 20);
		contentPane.add(endDate);
		
	    startDate = new JDateChooser();
		startDate.setDateFormatString("yyyy-MM-dd");
		startDate.setBounds(663, 176, 181, 20);
		Date ddd=new Date();
		startDate.setDate(ddd);
		contentPane.add(startDate);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(Color.ORANGE);
		lblCountry.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblCountry.setBackground(Color.WHITE);
		lblCountry.setBounds(194, 182, 118, 20);
		contentPane.add(lblCountry);
		
		cmbxDuration = new JComboBox();
		cmbxDuration.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String item=cmbxDuration.getSelectedItem().toString();
				if(item.equals("4"))
					{
					Date d=startDate.getDate();
					int month=d.getMonth();
					month=month+4;
					int day=d.getDay();
					day=day+4;
					d.setMonth(month);
					
					endDate.setDate(d);
					
					}
			}
		});
		cmbxDuration.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
		cmbxDuration.setBounds(322, 308, 181, 20);
		contentPane.add(cmbxDuration);
		
		registeredDate = new JDateChooser();
		registeredDate.setDateFormatString("yyyy-MM-dd");
		registeredDate.setBounds(663, 70, 181, 20);
		contentPane.add(registeredDate);
		
		comboCountry = new JComboBox();
		comboCountry.setModel(new DefaultComboBoxModel(new String[] {"Nepal", "India", "China", "Japan", "Bangladesh", "Bhutan", "America", "Maldivs", "Pakistan"}));
		comboCountry.setBounds(322, 182, 181, 20);
		contentPane.add(comboCountry);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.ORANGE);
		lblId.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblId.setBackground(Color.WHITE);
		lblId.setBounds(30, 336, 33, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		
		txtId.setEnabled(false);
		try{con=Connect.connectDb();
		
		String sql1="Select id from members";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int a=0;
		while(rs.next())
		{
			a=rs.getInt("id");
		}
		a=a+1;
		String aa=String.valueOf(a);
		txtId.setText(aa);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		txtId.setForeground(Color.BLACK);
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtId.setColumns(10);
		txtId.setBounds(73, 332, 76, 20);
		contentPane.add(txtId);
		
		btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				con=Connect.connectDb();
				String sql=null;
				if(btnSave.getText().equals("Save"))
				{
				sql="Insert into members(membership_no,full_name,gender,address,country,weight,"+
				"status,email,reg_date,start_date,end_date,fees_mode,discription,duration,paid_fee,"+
				"contact_no,dob,occupation,img) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				}
				else if(btnSave.getText().equals("Update"))
				{
				
					sql="update members set membership_no=?,full_name=?,gender=?,address=?,country=?,weight=?,"+ 
							"status=?,email=?,reg_date=?,start_date=?,end_date=?,fees_mode=?,discription=?,duration=?,paid_fee=?,"+ 
							"contact_no=?,dob=?,occupation=?,img=? where membership_no="+txtmemberno.getText()+"";
				}
				else {
					
				}
				try{
					pst = con.prepareStatement(sql);
					pst.setString (1,txtmemberno.getText());   
					pst.setString (2, txtFullname.getText());
					pst.setString (3,gender);
					pst.setString (4,txtAddress.getText());
					
					contryVal=comboCountry.getSelectedItem().toString();;
					pst.setString (5, contryVal);
					pst.setString (6, txtWeight.getText());
					
					String statusVal=cmbxStatus.getSelectedItem().toString();	
					pst.setString (7, statusVal);
					pst.setString (8, txtEmail.getText());
				
					pst.setString (9, ((JTextField)registeredDate.getDateEditor().getUiComponent()).getText());
					pst.setString (10, ((JTextField)startDate.getDateEditor().getUiComponent()).getText());
					pst.setString (11, ((JTextField)endDate.getDateEditor().getUiComponent()).getText());
					
					String feesModeVal=cmbxFeesmode.getSelectedItem().toString();				
					pst.setString (12, feesModeVal);

					pst.setString (13, txtDiscription.getText());
					
					String durationVal=cmbxDuration.getSelectedItem().toString();
					pst.setString(14, durationVal);
					pst.setString(15, txtPaidfee.getText());
					pst.setString(16, textContact.getText());
					pst.setString (17, ((JTextField)dob.getDateEditor().getUiComponent()).getText());
					pst.setString(18, txtOccupation.getText());
					
					if(filename!=null)
		            {
					FileInputStream fis=new FileInputStream(filename);
		            pst.setBinaryStream(19,fis,(int)filename.length());
					pst.execute();
					
					Date det=new Date();
					SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
					String date=format.format(det);
					Login log=new Login();
					
					if(btnSave.getText().equals("Update"))
					{
						JOptionPane.showMessageDialog(null, "Data updated successfully");
						
						/* For Storing History in database*/
						String msz="Member "+txtFullname.getText()+" is updated to "+updatedMember+" by "+log.Hitory_User+"";
						String sql1="Insert into history(date,task) values(?,?)";
						pst=con.prepareStatement(sql1);
						pst.setString(1, date);
						pst.setString(2, msz);
						pst.execute();
					}
					else if(btnSave.getText().equals("Save"))
					{
					JOptionPane.showMessageDialog(null, "Data successfully inserted");
					String msz="Member "+txtFullname.getText()+" is added by "+log.txtUsername.getText()+"";
					String sql1="Insert into history(date,task) values(?,?)";
					pst=con.prepareStatement(sql1);
					pst.setString(1, date);
					pst.setString(2, msz);
					pst.execute();
					}
					else {
						
					}
		            }
					else {
						JOptionPane.showMessageDialog(null, "PleaseSelect the image");
					}
					
					
					
								
			     
			     }
			     catch(Exception e1)
			     {
			    	 JOptionPane.showMessageDialog(null, e1);
			     }
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(656, 330, 95, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(Add_Member.class.getResource("/images/cancel.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			dispose();
				
				
				
				
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(755, 330, 89, 23);
		contentPane.add(btnCancel);
	}
}
