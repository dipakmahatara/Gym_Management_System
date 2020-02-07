package classes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

	public class Loading_Progress extends JFrame implements Runnable{
		JProgressBar progressBar;
		int i=0;
		Thread th;
		private JFrame frame;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		 
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(Loading_Progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(Loading_Progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(Loading_Progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(Loading_Progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Loading_Progress window = new Loading_Progress();
						window.frame.setVisible(true);
						window.iterate();
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public Loading_Progress() {
			super("Loading");
			initialize();
			th= new Thread((Runnable)this);
			
			
			
		}
		public void iterate()
		{
			setVisible(false);
			th.start();
		}
		public void run()
		{
			try{
				for (int j = 1; j < 200; j++) {
			
				i=i+1;
				int m= progressBar.getMaximum();
				int v= progressBar.getValue();
				if(v<m)
				{
					progressBar.setValue(progressBar.getValue()+1);
				}
				else {
					j=201;
					frame.setVisible(false);
					Login lg= new Login();
					lg.setVisible(true);
		
					}Thread.sleep(50);
				
			}
		}catch(Exception e)
			{
			System.out.println("Exception: "+e);
			}
		

	}

		/**
		 * Initialize the contents of the frame.
		 */
		public void initialize() {
			frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(430, 200, 547, 342);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			progressBar = new JProgressBar();
			progressBar.setForeground(Color.BLUE);
			progressBar.setBackground(Color.WHITE);
			progressBar.setBounds(0, 289, 545, 26);
			frame.getContentPane().add(progressBar);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Loading_Progress.class.getResource("/images/Progress Bar.png")));
			label.setBounds(0, 0, 543, 302);
			frame.getContentPane().add(label);
		}
	}
