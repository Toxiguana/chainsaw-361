

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alee.laf.WebLookAndFeel;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUI_Back extends JFrame {
	//channel labels
	private JLabel lblChan;
	private JLabel labelChan1;
	private JLabel labelChan2;
	private JLabel labelChan3;
	private JLabel labelChan4;
	private JLabel labelChan5;
	private JLabel labelChan6;
	private JLabel labelChan7;
	private JLabel labelChan8;
	private JRadioButton radiobuttonChan1;
	private JRadioButton radioButtonChan2;
	private JRadioButton radioButtonChan3;
	private JRadioButton radioButtonChan4;
	private JRadioButton radioButtonChan5;
	private JRadioButton radioButtonChan6;
	private JRadioButton radioButtonChan7;
	private JRadioButton radioButtonChan8;
	private JComboBox sensorType;
	String[]sensors={"","Button","Electric Eye","Gate","Pad"};
	ChronoTimer c;
	public GUI_Back(ChronoTimer _c) {
		c=_c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 150);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.darkGray);
		UIManager s=new UIManager();

	    try 
	    {
	    	UIManager.setLookAndFeel ( new WebLookAndFeel ());
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	    
	    sensorType = new JComboBox(sensors);
		sensorType.setBounds(218, 22, 126, 27);
		getContentPane().add(sensorType);

		radiobuttonChan1 = new JRadioButton("");
		radiobuttonChan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radiobuttonChan1.isSelected() == true) {
					try {
						c.sendCommand("CONN 1");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					try {
						c.sendCommand("DISC 1");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(c.connected[0][0]==null){
					radiobuttonChan1.setSelected(false);
				}
			}
		});
		radiobuttonChan1.setBounds(60, 26, 28, 23);
		getContentPane().add(radiobuttonChan1);
		
		lblChan = new JLabel("CHAN");
		lblChan.setForeground(Color.WHITE);
		lblChan.setBounds(6, 6, 61, 16);
		getContentPane().add(lblChan);
		
		labelChan1 = new JLabel("1");
		labelChan1.setForeground(Color.WHITE);
		labelChan1.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan1.setBounds(60, 6, 29, 16);
		getContentPane().add(labelChan1);
		
		radioButtonChan3 = new JRadioButton("");
		radioButtonChan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonChan3.isSelected() == true) {
					try {
						c.sendCommand("CONN 3");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						c.sendCommand("DISC 3");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (c.connected[0][1] == null) {
					radioButtonChan3.setSelected(false);
				}
			}
		});
		radioButtonChan3.setBounds(95, 26, 28, 23);
		getContentPane().add(radioButtonChan3);
		
		labelChan3 = new JLabel("3");
		labelChan3.setForeground(Color.WHITE);
		labelChan3.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan3.setBounds(95, 6, 29, 16);
		getContentPane().add(labelChan3);
		
		radioButtonChan5 = new JRadioButton("");
		radioButtonChan5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonChan5.isSelected() == true) {
					try {
						c.sendCommand("CONN 5");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					try {
						c.sendCommand("DISC 5");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(c.connected[0][2]==null){
					radioButtonChan5.setSelected(false);
				}
			}
		});
		radioButtonChan5.setBounds(130, 26, 28, 23);
		getContentPane().add(radioButtonChan5);
		
		labelChan5 = new JLabel("5");
		labelChan5.setForeground(Color.WHITE);
		labelChan5.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan5.setBounds(130, 6, 29, 16);
		getContentPane().add(labelChan5);
		
		radioButtonChan7 = new JRadioButton("");
		radioButtonChan7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonChan7.isSelected() == true) {
					try {
						c.sendCommand("CONN 7");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					try {
						c.sendCommand("DISC 7");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(c.connected[0][3]==null){
					radioButtonChan7.setSelected(false);
				}
			}
		});
		radioButtonChan7.setBounds(165, 26, 28, 23);
		getContentPane().add(radioButtonChan7);
		
		labelChan7 = new JLabel("7");
		labelChan7.setForeground(Color.WHITE);
		labelChan7.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan7.setBounds(165, 6, 29, 16);
		getContentPane().add(labelChan7);
		
		radioButtonChan2 = new JRadioButton("");
		radioButtonChan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonChan2.isSelected() == true) {
					try {
						c.sendCommand("CONN 2");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					try {
						c.sendCommand("DISC 2");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(c.connected[1][0]==null){
					radioButtonChan7.setSelected(false);
				}
			}
		});
		radioButtonChan2.setBounds(60, 61, 28, 23);
		getContentPane().add(radioButtonChan2);
		
		labelChan2 = new JLabel("2");
		labelChan2.setForeground(Color.WHITE);
		labelChan2.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan2.setBounds(59, 47, 29, 16);
		getContentPane().add(labelChan2);
		
		radioButtonChan4 = new JRadioButton("");
		radioButtonChan4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonChan4.isSelected() == true) {
					try {
						c.sendCommand("CONN 4");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					try {
						c.sendCommand("DISC 4");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(c.connected[1][1]==null){
					radioButtonChan7.setSelected(false);
				}
			}
		});
		radioButtonChan4.setBounds(95, 61, 28, 23);
		getContentPane().add(radioButtonChan4);
		
		labelChan4 = new JLabel("4");
		labelChan4.setForeground(Color.WHITE);
		labelChan4.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan4.setBounds(95, 47, 29, 16);
		getContentPane().add(labelChan4);
		
		radioButtonChan6 = new JRadioButton("");
		radioButtonChan6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonChan6.isSelected() == true) {
					try {
						c.sendCommand("CONN 6");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					try {
						c.sendCommand("DISC 6");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(c.connected[1][2]==null){
					radioButtonChan7.setSelected(false);
				}
			}
		});
		radioButtonChan6.setBounds(130, 61, 28, 23);
		getContentPane().add(radioButtonChan6);
		
		labelChan6 = new JLabel("6");
		labelChan6.setForeground(Color.WHITE);
		labelChan6.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan6.setBounds(130, 47, 29, 16);
		getContentPane().add(labelChan6);
		
		radioButtonChan8 = new JRadioButton("");
		radioButtonChan8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonChan8.isSelected() == true) {
					try {
						c.sendCommand("CONN 8");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				else {
					try {
						c.sendCommand("DISC 8");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(c.connected[1][3]==null){
					radioButtonChan7.setSelected(false);
				}
			}
		});
		radioButtonChan8.setBounds(165, 61, 28, 23);
		getContentPane().add(radioButtonChan8);
		
		labelChan8 = new JLabel("8");
		labelChan8.setForeground(Color.WHITE);
		labelChan8.setHorizontalAlignment(SwingConstants.CENTER);
		labelChan8.setBounds(165, 47, 29, 16);
		getContentPane().add(labelChan8);
		
		
	}
}
