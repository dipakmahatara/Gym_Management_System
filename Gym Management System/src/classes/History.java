package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	private JPanel contentPane;
	private JTable History_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
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
	public void Get_History()
	{
		String sql="Select id as'ID',date as'Date and Time ',task as 'Task' from history";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
         //   rs.next();
            History_Table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
	}
	
	public History() {
		setTitle("Gym || History");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 60, 1360, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1344, 54);
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLatest = new JButton("Latest");
		btnLatest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con=Connect.connectDb();
					String sql="Select id as'ID',date as'Date',task as 'Task' from history order by id desc";
			       			        	con=Connect.connectDb();
			            pst=con.prepareStatement(sql);
			            rs=pst.executeQuery();
			         //   rs.next();
			            History_Table.setModel(DbUtils.resultSetToTableModel(rs));
			                  
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
			
		});
		btnLatest.setIcon(new ImageIcon(History.class.getResource("/images/latest history.png")));
		btnLatest.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLatest.setBounds(37, 11, 103, 32);
		panel.add(btnLatest);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Get_History();
			}
		});
		btnRefresh.setIcon(new ImageIcon(History.class.getResource("/images/refresh.png")));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(166, 11, 103, 32);
		panel.add(btnRefresh);
		
		JButton btnClearAll = new JButton("Clear all");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=Connect.connectDb();
					String sql = "TRUNCATE history";
					pst=con.prepareStatement(sql);
					pst.executeUpdate(sql);
					
					if(pst.execute())
					{
						JOptionPane.showMessageDialog(History_Table, "Sorry history isnot cleared");
					}
					else
					{
						JOptionPane.showMessageDialog(History_Table, "All history is cleared");
					}
					
					
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		btnClearAll.setIcon(new ImageIcon(History.class.getResource("/images/clear all.png")));
		btnClearAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClearAll.setBounds(404, 11, 103, 32);
		panel.add(btnClearAll);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=Connect.connectDb();
					int row= History_Table.getSelectedRow();
					if(row>0)
					{
						String table_click=History_Table.getModel().getValueAt(row,0).toString();
					
					String sql="Delete from history where id='"+table_click+"'";
					pst=con.prepareStatement(sql);
					if(pst.execute())
					{
						JOptionPane.showMessageDialog(History_Table, "Sorry history isnot cleared");
					}
					else
					{
						JOptionPane.showMessageDialog(History_Table, "Selected history is cleared");
					}
					}
					else {
						JOptionPane.showMessageDialog(History_Table, "Pleasse select any history");
						
						
					}
					
					
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		btnClear.setIcon(new ImageIcon(History.class.getResource("/images/clear history.png")));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(279, 12, 103, 31);
		panel.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 1344, 508);
		contentPane.add(scrollPane);
		
		History_Table = new JTable();
		History_Table.setShowVerticalLines(false);
		History_Table.setShowHorizontalLines(false);
		History_Table.setBorder(null);
		scrollPane.setViewportView(History_Table);
		History_Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Id", "New column", "New column"
			}
		));
		Get_History();
	}
}
