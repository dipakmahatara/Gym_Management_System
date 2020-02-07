package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Add_Fees extends JFrame {
	

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;

	private JDateChooser reg_Date,e_Date,s_Date;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtmNo;
	private JLabel lblFullName;
	private JLabel lblMemberStatus;
	private JLabel lblDuration;
	private JLabel lblTotal;
	private JLabel lblPaidFee;
	private JLabel lblEndDate;
	private JLabel lblTotalFee;
	private JLabel lblPaidFee_1;
	private JLabel lblChange;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnCancel;
	private JTextField txtFull_Name;
	private JTextField txtTotal;
	private JTextField txtpaid;
	private JTextField txtTotal2;
	private JTextField txtPaid2;
	private JTextField txtchange;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTable table;
	private JTextField txtnowpaid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Fees frame = new Add_Fees();
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
	public Add_Fees() {
		setTitle("Deep Da||Add Fees");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 200, 727, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 0, 715, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Membership No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(138, 11, 132, 25);
		panel.add(lblNewLabel);
		
		txtmNo = new JTextField();
		txtmNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmNo.setBounds(301, 11, 157, 24);
		panel.add(txtmNo);
		txtmNo.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		
					con=Connect.connectDb();
					String sql="Select full_name,reg_date,start_date,end_date from members where membership_no="+txtmNo.getText()+"";
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					rs.next();
					{
						txtFull_Name.setText(rs.getString("full_name"));
						txtFull_Name.setEnabled(false);
						
						reg_Date.setDate(rs.getDate("reg_date"));
						reg_Date.setEnabled(false);
						//reg_Date
						s_Date.setDate(rs.getDate("start_date"));
						s_Date.setEnabled(false);
						//double a=(rs.getDouble("paid_fee"));
						e_Date.setDate(rs.getDate("end_date"));
						e_Date.setEnabled(false);
						txtTotal.setText("2000");
						
						//String b=String.valueOf(a);
						txtpaid.setText("500");
						
						
									
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/search1.png")));
		btnSearch.setBounds(506, 11, 107, 26);
		panel.add(btnSearch);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Member Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(10, 57, 298, 119);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(6, 17, 106, 14);
		panel_4.add(lblFullName);
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblRegDate = new JLabel("Reg. Date:");
		lblRegDate.setBounds(6, 38, 106, 23);
		panel_4.add(lblRegDate);
		lblRegDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtFull_Name = new JTextField();
		txtFull_Name.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtFull_Name.setBounds(130, 16, 157, 20);
		panel_4.add(txtFull_Name);
		txtFull_Name.setColumns(10);
		
		 reg_Date = new JDateChooser();
		reg_Date.setBounds(130, 41, 157, 20);
		panel_4.add(reg_Date);
		
		s_Date = new JDateChooser();
		s_Date.setBounds(130, 66, 157, 20);
		panel_4.add(s_Date);
		
		e_Date = new JDateChooser();
		e_Date.setBounds(130, 92, 157, 20);
		panel_4.add(e_Date);
		
		JLabel lblStartDate_1 = new JLabel("Start Date:");
		lblStartDate_1.setBounds(6, 66, 106, 19);
		panel_4.add(lblStartDate_1);
		lblStartDate_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblEndDate_1 = new JLabel("End Date:");
		lblEndDate_1.setBounds(6, 93, 106, 14);
		panel_4.add(lblEndDate_1);
		lblEndDate_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Fee Information", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 174, 298, 191);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblMemberStatus = new JLabel("Member Status:");
		lblMemberStatus.setBounds(6, 38, 106, 14);
		panel_3.add(lblMemberStatus);
		lblMemberStatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblDuration = new JLabel("Duration(Month):");
		lblDuration.setBounds(6, 63, 106, 14);
		panel_3.add(lblDuration);
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblTotal = new JLabel("Total Fee:");
		lblTotal.setBounds(6, 84, 106, 14);
		panel_3.add(lblTotal);
		lblTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblPaidFee = new JLabel("Paid Fee:");
		lblPaidFee.setBounds(6, 109, 106, 14);
		panel_3.add(lblPaidFee);
		lblPaidFee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblEndDate = new JLabel("End Date:");
		lblEndDate.setVisible(false);
		lblEndDate.setBounds(6, 159, 106, 14);
		panel_3.add(lblEndDate);
		lblEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setVisible(false);
		dateChooser_1.setBounds(122, 160, 153, 20);
		panel_3.add(dateChooser_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Registered", "Unregistered"}));
		comboBox.setBounds(122, 37, 153, 20);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2", "1", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_1.setBounds(122, 62, 153, 20);
		panel_3.add(comboBox_1);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtTotal.setBounds(122, 85, 153, 20);
		panel_3.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtpaid = new JTextField();
		txtpaid.setEnabled(false);
		txtpaid.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpaid.setBounds(122, 108, 153, 20);
		panel_3.add(txtpaid);
		txtpaid.setColumns(10);
		
		JLabel lblNowPaid = new JLabel("Now Paid");
		lblNowPaid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNowPaid.setBounds(6, 135, 106, 14);
		panel_3.add(lblNowPaid);
		
		txtnowpaid = new JTextField();
		txtnowpaid.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				txtTotal2.setText(txtTotal.getText());
				
				int aa=Integer.parseInt(txtTotal2.getText());
				int s=Integer.parseInt(txtpaid.getText());
				int y=Integer.parseInt(txtnowpaid.getText());
				int z=s+y;
				int x=aa-z;
				txtPaid2.setText(String.valueOf(z));
				txtchange.setText(String.valueOf(x));
			
				
			}
		});
		txtnowpaid.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtnowpaid.setColumns(10);
		txtnowpaid.setBounds(122, 134, 153, 20);
		panel_3.add(txtnowpaid);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Amount Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(318, 217, 399, 99);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblTotalFee = new JLabel("Total Fee:");
		lblTotalFee.setBounds(6, 16, 62, 14);
		panel_2.add(lblTotalFee);
		lblTotalFee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblPaidFee_1 = new JLabel("Paid Fee:");
		lblPaidFee_1.setBounds(6, 41, 62, 14);
		panel_2.add(lblPaidFee_1);
		lblPaidFee_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblChange = new JLabel("Change:");
		lblChange.setBounds(6, 64, 62, 23);
		panel_2.add(lblChange);
		lblChange.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtTotal2 = new JTextField();
		txtTotal2.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtTotal2.setBounds(179, 15, 133, 20);
		panel_2.add(txtTotal2);
		txtTotal2.setColumns(10);
		
		txtPaid2 = new JTextField();
		txtPaid2.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtPaid2.setBounds(179, 40, 133, 20);
		panel_2.add(txtPaid2);
		txtPaid2.setColumns(10);
		
		txtchange = new JTextField();
		txtchange.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtchange.setBounds(179, 67, 133, 20);
		panel_2.add(txtchange);
		txtchange.setColumns(10);
		panel_2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTotalFee, lblPaidFee_1, lblChange, txtTotal2, txtPaid2, txtchange}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		panel_1.setBounds(318, 319, 399, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("Paid Fee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentication ap= new Authentication();
				ap.show();
				
				
			}
		});
		btnNewButton.setBounds(6, 16, 111, 23);
		panel_1.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/paid.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(127, 16, 106, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/clear all.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(243, 16, 106, 23);
		panel_1.add(btnCancel);
		btnCancel.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/cancel.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Older Fee Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(318, 56, 399, 157);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 383, 134);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Date of Paid", "Paid Amount", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}
}
