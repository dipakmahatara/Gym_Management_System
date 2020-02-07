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

public class User_Frame extends JFrame {

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
					User_Frame frame = new User_Frame();
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
	public User_Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Window.class.getResource("/images/gymm.png")));
		setTitle("Deep Gym Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 0, 0));
		menuBar.setBackground(Color.CYAN);
		menuBar.setForeground(Color.ORANGE);
		menuBar.setBounds(0, 0, 1354, 33);
		contentPane.add(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnHome.setIcon(new ImageIcon(Main_Window.class.getResource("/images/home.png")));
		menuBar.add(mnHome);
		
		JMenu mnEdit = new JMenu("Members");
		mnEdit.setIcon(new ImageIcon(Main_Window.class.getResource("/images/member.png")));
		menuBar.add(mnEdit);
		
		JMenuItem mntmSearchMember = new JMenuItem("Search Member");
		mntmSearchMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Member sr= new Search_Member();
				sr.setVisible(true);
				
			}
		});
		
		JMenuItem mntmViewMembers = new JMenuItem("Show all members");
		mntmViewMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Show_All sall=new Show_All();
				sall.btnDelete.setEnabled(false);
				sall.btnNew.setEnabled(false);
				sall.btnUpdate.setEnabled(false);
				sall.show();
			}
		});
		mntmViewMembers.setIcon(new ImageIcon(Main_Window.class.getResource("/images/show all.png")));
		mnEdit.add(mntmViewMembers);
		mntmSearchMember.setIcon(new ImageIcon(Main_Window.class.getResource("/images/search member.png")));
		mnEdit.add(mntmSearchMember);
		
		JMenu mnPayments = new JMenu("Fees");
		mnPayments.setIcon(new ImageIcon(Main_Window.class.getResource("/images/fees.png")));
		menuBar.add(mnPayments);
		
		JMenuItem mntmFeeInfo = new JMenuItem("fee info Details");
		mntmFeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Fee view_fwe=new View_Fee();
				view_fwe.show();
			}
		});
		mntmFeeInfo.setIcon(new ImageIcon(Main_Window.class.getResource("/images/fee info.png")));
		mnPayments.add(mntmFeeInfo);
		
		JMenu mnFees = new JMenu("Payments");
		mnFees.setIcon(new ImageIcon(Main_Window.class.getResource("/images/paymente.png")));
		menuBar.add(mnFees);
		
		
		
		JMenuItem mntmAddFee = new JMenuItem("Pay your Payment");
		mntmAddFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Fees af= new Add_Fees();
				af.setVisible(true);
			}
		});
		mntmAddFee.setIcon(new ImageIcon(Main_Window.class.getResource("/images/add fee.png")));
		mnFees.add(mntmAddFee);
		
		JMenu mnProducts = new JMenu("Products");
		mnProducts.setIcon(new ImageIcon(Main_Window.class.getResource("/images/product.png")));
		menuBar.add(mnProducts);
		
		JMenuItem mntmSell = new JMenuItem("Buy");
		mntmSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sell_Product sp= new Sell_Product();
				sp.setVisible(true);
			}
		});
		
		JMenuItem mntmShowAll = new JMenuItem("Show All");
		mntmShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Show_All_Product sapp=new Show_All_Product();
				sapp.show();
			}
		});
		mntmShowAll.setIcon(new ImageIcon(Main_Window.class.getResource("/images/show.png")));
		mnProducts.add(mntmShowAll);
		mntmSell.setIcon(new ImageIcon(Main_Window.class.getResource("/images/sell.png")));
		mnProducts.add(mntmSell);
		
		JMenuItem mntmRefresh_1 = new JMenuItem("Refresh");
		mntmRefresh_1.setIcon(new ImageIcon(Main_Window.class.getResource("/images/refresh.png")));
		mnProducts.add(mntmRefresh_1);
		
		JMenu mnHistory = new JMenu("History");
		mnHistory.setEnabled(false);
		mnHistory.setIcon(new ImageIcon(Main_Window.class.getResource("/images/history.png")));
		menuBar.add(mnHistory);
		
		JMenuItem mntmLatest = new JMenuItem("Show history");
		mntmLatest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				History history= new History();
				history.show();
			}
		});
		mntmLatest.setIcon(new ImageIcon(Main_Window.class.getResource("/images/latest history.png")));
		mnHistory.add(mntmLatest);
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.setIcon(new ImageIcon(Main_Window.class.getResource("/images/refresh.png")));
		mnHistory.add(mntmRefresh);
		
		JMenu mnNewMenu = new JMenu("Reports");
		mnNewMenu.setEnabled(false);
		mnNewMenu.setIcon(new ImageIcon(Main_Window.class.getResource("/images/report.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmViewReports = new JMenuItem("view reports");
		mntmViewReports.setIcon(new ImageIcon(Main_Window.class.getResource("/images/view reports.png")));
		mnNewMenu.add(mntmViewReports);
		
		JMenu mnNewMenu_2 = new JMenu("Enquiry");
		mnNewMenu_2.setIcon(new ImageIcon(Main_Window.class.getResource("/images/enquiry.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmGenrealEnquiry = new JMenuItem("Add Genreal Enquiry");
		mntmGenrealEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Enquiry adw=new Add_Enquiry();
				adw.show();
				
			}
		});
		mntmGenrealEnquiry.setIcon(new ImageIcon(Main_Window.class.getResource("/images/enquiry1.png")));
		mnNewMenu_2.add(mntmGenrealEnquiry);
		
		JMenu mnFile = new JMenu("Utility");
		mnFile.setIcon(new ImageIcon(Main_Window.class.getResource("/images/file.png")));
		mnFile.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		menuBar.add(mnFile);
		
		JMenuItem mntmUpdateVersion = new JMenuItem("Update (Current version 1.1)");
		mntmUpdateVersion.setIcon(new ImageIcon(Main_Window.class.getResource("/images/update_version.png")));
		mnFile.add(mntmUpdateVersion);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
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
		mntmNotepad.setIcon(new ImageIcon(Main_Window.class.getResource("/images/notepad.png")));
		mnFile.add(mntmNotepad);
		
		JMenu mnNewMenu_3 = new JMenu("Help");
		mnNewMenu_3.setIcon(new ImageIcon(Main_Window.class.getResource("/images/help.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				About about= new About();
				about.setVisible(true);
			}
		});
		mntmAbout.setIcon(new ImageIcon(Main_Window.class.getResource("/images/if_question_8677.gif")));
		mnNewMenu_3.add(mntmAbout);
		
		JMenuItem mntmHoeTo = new JMenuItem("Hoe To..?");
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
		mnNewMenu_1.setIcon(new ImageIcon(Main_Window.class.getResource("/images/account.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
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
		mntmUpdateAccount.setIcon(new ImageIcon(Main_Window.class.getResource("/images/change password.png")));
		mnNewMenu_1.add(mntmUpdateAccount);
		
		JLabel lblCurretntDateAnd = new JLabel("Curretnt Date and Time");
		lblCurretntDateAnd.setFont(new Font("Vani", Font.BOLD, 13));
		lblCurretntDateAnd.setBounds(920, 657, 167, 23);
		contentPane.add(lblCurretntDateAnd);
		
		JLabel Datetime = new JLabel("");
		Datetime.setFont(new Font("Yu Mincho Light", Font.BOLD, 12));
		Date localdate= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat();
		Datetime.setText(sdf.format(localdate));
		System.out.println(localdate);
		Datetime.setBounds(1122, 657, 195, 16);
		contentPane.add(Datetime);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 1354, 691);
		contentPane.add(bg);
		bg.setIcon(new ImageIcon(Main_Window.class.getResource("/images/DSPG Bg.png")));
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
