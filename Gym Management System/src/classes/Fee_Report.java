package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class Fee_Report extends JFrame {
	

	private JPanel contentPane;

	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fee_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fee_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fee_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fee_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee_Report frame = new Fee_Report();
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
	public void get_Fee_Rep()
	{
		try {
	    DefaultPieDataset dataset = new DefaultPieDataset( );
	    dataset.setValue("Total Registration Income", 10560);
	    dataset.setValue("Total Fee Income", 35656);
	    dataset.setValue("Expenditure", 4056);
	 
	    
	      
	      JFreeChart chart = ChartFactory.createPieChart(
	         "Fee Report",   // chart title           
	         dataset,          // data           
	         true,             // include legend          
	         true,           
	         false );

	      int width = 560;    /* Width of the image */
	      int height = 370;   /* Height of the image */ 
	  	ChartFrame frame=new ChartFrame("Deep Da Gym ||Reports ", chart);
	  	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.setLocationRelativeTo(this);
		frame.getChartPanel().setLayout(null);
	    File pieChart = new File( "Fee_Reports.jpeg" );
	    ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public Fee_Report() {
		this.dispose();
		get_Fee_Rep();
			
		
	}
}
