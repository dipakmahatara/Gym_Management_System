package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Main_Window extends JFrame {
	
	private Cursor cur=new Cursor(Cursor.HAND_CURSOR);

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*Look and Feel*/
	    try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window frame = new Main_Window();
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
	
	public Main_Window() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Window.class.getResource("/images/gymm.png")));
		setTitle("Deep Da Gym Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1354, 33);
		menuBar.setMargin(new Insets(0, 0, 0, 0));
		menuBar.setBackground(Color.CYAN);
		menuBar.setForeground(Color.ORANGE);
		contentPane.add(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.setFont(new Font("Dialog", Font.BOLD, 12));
		mnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnHome.setIcon(new ImageIcon(Main_Window.class.getResource("/images/home.png")));
		menuBar.add(mnHome);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mnHome.add(mntmHome);
		
		JMenu mnEdit = new JMenu("Members");
		mnEdit.setFont(new Font("Dialog", Font.BOLD, 12));
		mnEdit.setIcon(new ImageIcon(Main_Window.class.getResource("/images/member.png")));
		menuBar.add(mnEdit);
		
		JMenuItem mntmAddMember = new JMenuItem("Add Member");
		mntmAddMember.setOpaque(true);
		mntmAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				Add_Member ad= new Add_Member();
			
				ad.setVisible(true);
				
			}
		});
		mntmAddMember.setIcon(new ImageIcon(Main_Window.class.getResource("/images/add user.png")));
		mnEdit.add(mntmAddMember);
		
		JMenuItem mntmDeleteMember = new JMenuItem("Delete Member");
		mntmDeleteMember.setOpaque(true);
		mntmDeleteMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Member srchM=new Search_Member();
				srchM.lblSearchMember.setText("Deleting Member");
				srchM.btnDelete.setEnabled(true);
				srchM.show();
			}
		});
		mntmDeleteMember.setIcon(new ImageIcon(Main_Window.class.getResource("/images/delete user.png")));
		mnEdit.add(mntmDeleteMember);
		
		JMenuItem mntmUpadateMember = new JMenuItem("Upadate Member");
		mntmUpadateMember.setOpaque(true);
		mntmUpadateMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Show_All sa=new Show_All();
				sa.show();
			
			}
		
		});
		mntmUpadateMember.setIcon(new ImageIcon(Main_Window.class.getResource("/images/update member.png")));
		mnEdit.add(mntmUpadateMember);
		
		JMenuItem mntmSearchMember = new JMenuItem("Search Member");
		mntmSearchMember.setOpaque(true);
		mntmSearchMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Member sr= new Search_Member();
				sr.setVisible(true);
				
			}
		});
		
		JMenuItem mntmViewMembers = new JMenuItem("Show all members");
		mntmViewMembers.setOpaque(true);
		mntmViewMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Show_All sall=new Show_All();
				sall.show();
			}
		});
		mntmViewMembers.setIcon(new ImageIcon(Main_Window.class.getResource("/images/show all.png")));
		mnEdit.add(mntmViewMembers);
		mntmSearchMember.setIcon(new ImageIcon(Main_Window.class.getResource("/images/search member.png")));
		mnEdit.add(mntmSearchMember);
		
		JMenu mnPayments = new JMenu("Fees");
		mnPayments.setFont(new Font("Dialog", Font.BOLD, 12));
		mnPayments.setIcon(new ImageIcon(Main_Window.class.getResource("/images/fees.png")));
		menuBar.add(mnPayments);
		
		JMenuItem mntmFeeInfo = new JMenuItem("fee info Details");
		mntmFeeInfo.setOpaque(true);
		mntmFeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Fee view_fwe=new View_Fee();
				view_fwe.show();
				
			}
		});
		mntmFeeInfo.setIcon(new ImageIcon(Main_Window.class.getResource("/images/fee info.png")));
		mnPayments.add(mntmFeeInfo);
		
		JMenu mnAddAndAdjust = new JMenu("View,Add and Adjust fee");
		mnAddAndAdjust.setOpaque(true);
		mnAddAndAdjust.setIcon(new ImageIcon(Main_Window.class.getResource("/images/view pay.png")));
		mnPayments.add(mnAddAndAdjust);
		
		JMenuItem mntmSetRegistrationFee = new JMenuItem("Set registration fee");
		mntmSetRegistrationFee.setOpaque(true);
		mntmSetRegistrationFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration_Fee registration=new Registration_Fee();
				registration.show();
				
				
			}
		});
		mntmSetRegistrationFee.setIcon(new ImageIcon(Main_Window.class.getResource("/images/reg_fee.png")));
		mnAddAndAdjust.add(mntmSetRegistrationFee);
		
		JMenuItem mntmSetMonthlyFee = new JMenuItem("Set & Adjust monthly fee");
		mntmSetMonthlyFee.setOpaque(true);
		mntmSetMonthlyFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adjusting_Fee uf1=new Adjusting_Fee();
				uf1.show();
				
			}
		});
		mntmSetMonthlyFee.setIcon(new ImageIcon(Main_Window.class.getResource("/images/mothnly_fee.png")));
		mnAddAndAdjust.add(mntmSetMonthlyFee);
		
		JMenuItem mntmUpdatePayment = new JMenuItem("Update Fee");
		mntmUpdatePayment.setOpaque(true);
		mntmUpdatePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Fee_Value uff=new Update_Fee_Value();
				uff.show();
			}
		});
		mntmUpdatePayment.setIcon(new ImageIcon(Main_Window.class.getResource("/images/paymente.png")));
		mnPayments.add(mntmUpdatePayment);
		
		JMenu mnFees = new JMenu("Payments");
		mnFees.setFont(new Font("Dialog", Font.BOLD, 12));
		mnFees.setIcon(new ImageIcon(Main_Window.class.getResource("/images/paymente.png")));
		menuBar.add(mnFees);
		
		
		
		JMenuItem mntmAddFee = new JMenuItem("Add Fee Payments");
		mntmAddFee.setOpaque(true);
		mntmAddFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Fees af= new Add_Fees();
				af.setVisible(true);
			}
		});
		mntmAddFee.setIcon(new ImageIcon(Main_Window.class.getResource("/images/add fee.png")));
		mnFees.add(mntmAddFee);
		
		JMenuItem mntmUpdateFee = new JMenuItem("Update Payment");
		mntmUpdateFee.setOpaque(true);
		mntmUpdateFee.setIcon(new ImageIcon(Main_Window.class.getResource("/images/update.png")));
		mnFees.add(mntmUpdateFee);
		
		JMenu mnProducts = new JMenu("Products");
		mnProducts.setFont(new Font("Dialog", Font.BOLD, 12));
		mnProducts.setIcon(new ImageIcon(Main_Window.class.getResource("/images/product.png")));
		menuBar.add(mnProducts);
		
		JMenuItem mntmSell = new JMenuItem("Sell");
		mntmSell.setOpaque(true);
		mntmSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sell_Product sp= new Sell_Product();
				sp.setVisible(true);
			}
		});
		
		JMenuItem mntmShowAll = new JMenuItem("Show All");
		mntmShowAll.setOpaque(true);
		mntmShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Show_All_Product sapp=new Show_All_Product();
				sapp.show();
				
			}
		});
		mntmShowAll.setIcon(new ImageIcon(Main_Window.class.getResource("/images/show.png")));
		mnProducts.add(mntmShowAll);
		
		JMenuItem mntmAddNew = new JMenuItem("Add New ");
		mntmAddNew.setOpaque(true);
		mntmAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Product ap= new Add_Product();
				ap.setVisible(true);
			}
		});
		mntmAddNew.setIcon(new ImageIcon(Main_Window.class.getResource("/images/add item.png")));
		mnProducts.add(mntmAddNew);
		
		JMenuItem mntmDeleteItem = new JMenuItem("Delete item");
		mntmDeleteItem.setOpaque(true);
		mntmDeleteItem.setIcon(new ImageIcon(Main_Window.class.getResource("/images/delete.png")));
		mnProducts.add(mntmDeleteItem);
		mntmSell.setIcon(new ImageIcon(Main_Window.class.getResource("/images/sell.png")));
		mnProducts.add(mntmSell);
		
		JMenuItem mntmRefresh_1 = new JMenuItem("Refresh");
		mntmRefresh_1.setOpaque(true);
		mntmRefresh_1.setIcon(new ImageIcon(Main_Window.class.getResource("/images/refresh.png")));
		mnProducts.add(mntmRefresh_1);
		
		JMenu mnHistory = new JMenu("History");
		mnHistory.setFont(new Font("Dialog", Font.BOLD, 12));
		mnHistory.setIcon(new ImageIcon(Main_Window.class.getResource("/images/history.png")));
		menuBar.add(mnHistory);
		
		JMenuItem mntmLatest = new JMenuItem("Show history");
		mntmLatest.setOpaque(true);
		mntmLatest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				History history= new History();
				history.show();
			}
		});
		mntmLatest.setIcon(new ImageIcon(Main_Window.class.getResource("/images/latest history.png")));
		mnHistory.add(mntmLatest);
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.setOpaque(true);
		mntmRefresh.setIcon(new ImageIcon(Main_Window.class.getResource("/images/refresh.png")));
		mnHistory.add(mntmRefresh);
		
		JMenu mnNewMenu = new JMenu("Reports");
		mnNewMenu.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu.setIcon(new ImageIcon(Main_Window.class.getResource("/images/report.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmViewReports = new JMenuItem("view members reports");
		mntmViewReports.setOpaque(true);
		mntmViewReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member_Report mr=new Member_Report();
				mr.show();
			}
		});
		mntmViewReports.setIcon(new ImageIcon(Main_Window.class.getResource("/images/view reports.png")));
		mnNewMenu.add(mntmViewReports);
		
		JMenuItem mntmViewFeeReports = new JMenuItem("view Fee reports");
		mntmViewFeeReports.setOpaque(true);
		mntmViewFeeReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fee_Report mr=new Fee_Report();
				mr.show();
			}
		});
		mntmViewFeeReports.setIcon(new ImageIcon(Main_Window.class.getResource("/images/fees.png")));
		mnNewMenu.add(mntmViewFeeReports);
		
		JMenu mnNewMenu_2 = new JMenu("Inquiry");
		mnNewMenu_2.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu_2.setIcon(new ImageIcon(Main_Window.class.getResource("/images/enquiry.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmGenrealEnquiry = new JMenuItem("View Genreal Enquiry");
		mntmGenrealEnquiry.setOpaque(true);
		mntmGenrealEnquiry.setIcon(new ImageIcon(Main_Window.class.getResource("/images/enquiry1.png")));
		mnNewMenu_2.add(mntmGenrealEnquiry);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setOpaque(true);
		mntmDelete.setIcon(new ImageIcon(Main_Window.class.getResource("/images/delete.png")));
		mnNewMenu_2.add(mntmDelete);
		
		JMenu mnFile = new JMenu("Utility");
		mnFile.setIcon(new ImageIcon(Main_Window.class.getResource("/images/file.png")));
		mnFile.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnFile);
		
		JMenuItem mntmUpdateVersion = new JMenuItem("Update (Current version 1.1)");
		mntmUpdateVersion.setOpaque(true);
		mntmUpdateVersion.setIcon(new ImageIcon(Main_Window.class.getResource("/images/update_version.png")));
		mnFile.add(mntmUpdateVersion);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.setOpaque(true);
		mntmCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Runtime run= Runtime.getRuntime();
					String url="calc";
					run.exec(url);
				}catch(Exception except)
				{
					System.out.println("Exception: "+except);
				}
			}
		});
		mntmCalculator.setIcon(new ImageIcon(Main_Window.class.getResource("/images/calculator.png")));
		mnFile.add(mntmCalculator);
		
		JMenuItem mntmNotepad = new JMenuItem("Notepad");
		mntmNotepad.setOpaque(true);
		mntmNotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Runtime run= Runtime.getRuntime();
					String url="notepad";
					run.exec(url);
				}catch(Exception except)
				{
					System.out.println("Exception: "+except);
				}
			}
		});
		mntmNotepad.setIcon(new ImageIcon(Main_Window.class.getResource("/images/notepad.png")));
		mnFile.add(mntmNotepad);
		
		JMenu mnNewMenu_3 = new JMenu("Help");
		mnNewMenu_3.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu_3.setIcon(new ImageIcon(Main_Window.class.getResource("/images/help.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setOpaque(true);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				About about= new About();
				about.setVisible(true);
			}
		});
		mntmAbout.setIcon(new ImageIcon(Main_Window.class.getResource("/images/if_question_8677.gif")));
		mnNewMenu_3.add(mntmAbout);
		
		JMenuItem mntmHoeTo = new JMenuItem("Hoe To..?");
		mntmHoeTo.setOpaque(true);
		mntmHoeTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Desktop d= Desktop.getDesktop();
					String url="https://www.youtube.com/channel/UCu7h5Wu1y9O3KBiw2A2S2Dg?view_as=subscriber";
					d.browse(new URI(url));
				}catch(Exception excep)
				{
					System.out.println("Exception: "+excep);
				}
			}
		});
		mntmHoeTo.setIcon(new ImageIcon(Main_Window.class.getResource("/images/how to.png")));
		mnNewMenu_3.add(mntmHoeTo);
		
		JMenu mnNewMenu_1 = new JMenu("account");
		mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu_1.setIcon(new ImageIcon(Main_Window.class.getResource("/images/account.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setOpaque(true);
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg= new Login();
				setVisible(false);
				lg.setVisible(true);			
				
			}
		});
		mntmLogOut.setIcon(new ImageIcon(Main_Window.class.getResource("/images/logout.png")));
		mnNewMenu_1.add(mntmLogOut);
		
		JMenuItem mntmUpdateAccount = new JMenuItem("Update account");
		mntmUpdateAccount.setOpaque(true);
		mntmUpdateAccount.setIcon(new ImageIcon(Main_Window.class.getResource("/images/change password.png")));
		mnNewMenu_1.add(mntmUpdateAccount);
		
		JLabel lblCurretntDateAnd = new JLabel("Curretnt Date and Time");
		lblCurretntDateAnd.setBounds(920, 657, 167, 23);
		lblCurretntDateAnd.setFont(new Font("Vani", Font.BOLD, 13));
		contentPane.add(lblCurretntDateAnd);
		
		JLabel Datetime = new JLabel("");
		Datetime.setBounds(1122, 657, 195, 16);
		Datetime.setFont(new Font("Yu Mincho Light", Font.BOLD, 12));
		Date localdate= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat();
		Datetime.setText(sdf.format(localdate));
		System.out.println(localdate);
		contentPane.add(Datetime);
		
		JLabel lblFees_1 = new JLabel("Fees");
		lblFees_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Adjusting_Fee uf1=new Adjusting_Fee();
				uf1.show();
			}
		});
		lblFees_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFees_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFees_1.setIcon(new ImageIcon(Main_Window.class.getResource("/images/ToolFee.png")));
		lblFees_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFees_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFees_1.setBounds(193, 33, 62, 66);
		contentPane.add(lblFees_1);
		
		JLabel lblMessages = new JLabel("Messages");
		lblMessages.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					Message message=new Message();
					message.show();
			}
		});
		lblMessages.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMessages.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMessages.setIcon(new ImageIcon(Main_Window.class.getResource("/images/ToolMsz.png")));
		lblMessages.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblMessages.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMessages.setBounds(320, 33, 62, 66);
		contentPane.add(lblMessages);
		
		JLabel lblLogout = new JLabel("Inquiry");
		lblLogout.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				View_Enquiry ve=new View_Enquiry();
				ve.show();
			}
		});
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogout.setIcon(new ImageIcon(Main_Window.class.getResource("/images/ToolQuiry.png")));
		lblLogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblLogout.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogout.setBounds(513, 33, 62, 66);
		contentPane.add(lblLogout);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					Member_Report mrp=new Member_Report();
					mrp.show();
										
			}
		});
		lblReports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblReports.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReports.setIcon(new ImageIcon(Main_Window.class.getResource("/images/ToolReports.png")));
		lblReports.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblReports.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReports.setBounds(136, 33, 62, 66);
		contentPane.add(lblReports);
		
		JLabel lblFees = new JLabel("History");
		lblFees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				History history= new History();
				history.show();
			}
		});
		lblFees.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFees.setIcon(new ImageIcon(Main_Window.class.getResource("/images/ToolHistory.png")));
		lblFees.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFees.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFees.setBounds(387, 33, 62, 66);
		contentPane.add(lblFees);
		
		JLabel lblMembers = new JLabel("Members");
		lblMembers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Show_All sall=new Show_All();
				sall.show();
			}
		});
		lblMembers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMembers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMembers.setIcon(new ImageIcon(Main_Window.class.getResource("/images/ToolMember.png")));
		lblMembers.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblMembers.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMembers.setBounds(248, 33, 62, 66);
		contentPane.add(lblMembers);
		
		JLabel lblProducts = new JLabel("Products");
		lblProducts.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					Show_All_Product sapp=new Show_All_Product();
					sapp.show();
			}
		});
		lblProducts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProducts.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProducts.setIcon(new ImageIcon(Main_Window.class.getResource("/images/ToolProducts.png")));
		lblProducts.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblProducts.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProducts.setBounds(64, 33, 62, 66);
		contentPane.add(lblProducts);
		
		JLabel lblInquiry = new JLabel("Logout");
		lblInquiry.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Login lg= new Login();
				setVisible(false);
				lg.setVisible(true);
			}
		
			
		});
		lblInquiry.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInquiry.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInquiry.setIcon(new ImageIcon(Main_Window.class.getResource("/images/toolLogout.png")));
		lblInquiry.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblInquiry.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInquiry.setBounds(578, 33, 62, 66);
		contentPane.add(lblInquiry);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					dispose();
					show();
			}
		});
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHome.setIcon(new ImageIcon(Main_Window.class.getResource("/images/TollHome.png")));
		lblHome.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblHome.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHome.setBounds(10, 33, 56, 66);
		contentPane.add(lblHome);
		
		JLabel lblPayments = new JLabel("Payments");
		lblPayments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_Fees af= new Add_Fees();
				af.setVisible(true);
			}
		});
		lblPayments.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPayments.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPayments.setIcon(new ImageIcon(Main_Window.class.getResource("/images/toolPayments.png")));
		lblPayments.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPayments.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPayments.setBounds(452, 33, 62, 66);
		contentPane.add(lblPayments);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 1354, 691);
		contentPane.add(bg);
		bg.setIcon(new ImageIcon(Main_Window.class.getResource("/images/Bg.png")));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
