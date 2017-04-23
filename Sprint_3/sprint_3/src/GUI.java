import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.BoundedRangeModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JScrollPane;

public class GUI extends JFrame {
	private JTextField numTxtFld;

	/**
	 * Create the frame.
	 */
//	ChronoTimer c=new ChronoTimer();
	public GUI(ChronoTimer _c) {
		ChronoTimer c=_c;

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 500, 600, 500);
		setTitle("CHRONOTIMER 1909");
		getContentPane().setLayout(null);
		
		JButton btnSwap = new JButton("Swap");
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSwap.setBounds(6, 421, 117, 29);
		getContentPane().add(btnSwap);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(187, 47, 34, 16);
		getContentPane().add(lblStart);
		
		JLabel lblEnabledisable = new JLabel("Enable/Disable");
		lblEnabledisable.setBounds(136, 73, 95, 16);
		getContentPane().add(lblEnabledisable);
		
		JLabel labelChan1 = new JLabel("1");
		labelChan1.setBounds(239, 26, 18, 16);
		getContentPane().add(labelChan1);
		
		JLabel labelChan3 = new JLabel("3");
		labelChan3.setBounds(280, 26, 18, 16);
		getContentPane().add(labelChan3);
		
		
		JLabel labelChan5 = new JLabel("5");
		labelChan5.setBounds(321, 26, 18, 16);
		getContentPane().add(labelChan5);
		
		JLabel labelChan7 = new JLabel("7");
		labelChan7.setBounds(362, 26, 18, 16);
		getContentPane().add(labelChan7);
		
		JLabel lblFinish = new JLabel("Finish");
		lblFinish.setBounds(182, 135, 42, 14);
		getContentPane().add(lblFinish);
		
		JLabel labelchan1 = new JLabel("Enable/Disable");
		labelchan1.setBounds(136, 161, 95, 16);
		getContentPane().add(labelchan1);
		
		JLabel lblchan2 = new JLabel("2");
		lblchan2.setBounds(239, 114, 18, 16);
		getContentPane().add(lblchan2);
		
		JLabel lblChan3 = new JLabel("4");
		lblChan3.setBounds(280, 114, 18, 16);
		getContentPane().add(lblChan3);
		
		JLabel lblChan6 = new JLabel("6");
		lblChan6.setBounds(321, 114, 18, 16);
		getContentPane().add(lblChan6);
		
		JLabel lblChan8 = new JLabel("8");
		lblChan8.setBounds(362, 114, 18, 16);
		getContentPane().add(lblChan8);
		
		JButton btnTrigChan1 = new JButton("");
		btnTrigChan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 1");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan1.setBounds(233, 47, 42, 26);
		getContentPane().add(btnTrigChan1);
		
		JButton btnTrigChan2 = new JButton("");
		btnTrigChan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 2");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan2.setBounds(233, 135, 42, 26);
		getContentPane().add(btnTrigChan2);
		
		JButton btnTrigChan3 = new JButton("");
		btnTrigChan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 3");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan3.setBounds(274, 47, 42, 26);
		getContentPane().add(btnTrigChan3);
		
		JButton btnTrigChan4 = new JButton("");
		btnTrigChan4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 4");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan4.setBounds(274, 135, 42, 26);
		getContentPane().add(btnTrigChan4);
		
		JButton btnTrigChan5 = new JButton("");
		btnTrigChan5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 5");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan5.setBounds(315, 47, 42, 26);
		getContentPane().add(btnTrigChan5);
		
		JButton btnTrigChan6 = new JButton("");
		btnTrigChan6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 6");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan6.setBounds(315, 135, 42, 26);
		getContentPane().add(btnTrigChan6);
		
		JButton btnTrigChan7 = new JButton("");
		btnTrigChan7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 7");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan7.setBounds(356, 47, 42, 26);
		getContentPane().add(btnTrigChan7);
		
		JButton btnTrigChan8 = new JButton("");
		btnTrigChan8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 8");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrigChan8.setBounds(356, 135, 42, 26);
		getContentPane().add(btnTrigChan8);
		

		JToggleButton tglChan1 = new JToggleButton("");
		tglChan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 1");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(0, 0)){
					tglChan1.setSelected(false);
				}
			}
			
		});
		tglChan1.setBounds(243, 74, 18, 26);
		getContentPane().add(tglChan1);
		
		JToggleButton tglChan2 = new JToggleButton("");
		tglChan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 2");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(1, 0)){
					tglChan2.setSelected(false);
				}
			}
		});
		tglChan2.setBounds(243, 162, 18, 26);
		getContentPane().add(tglChan2);
		
		JToggleButton tglChan3 = new JToggleButton("");
		tglChan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 3");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(0, 1)){
					tglChan3.setSelected(false);
				}
			}
		});
		tglChan3.setBounds(284, 73, 18, 26);
		getContentPane().add(tglChan3);
		
		JToggleButton tglChan4 = new JToggleButton("");
		tglChan4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 4");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(1, 1)){
					tglChan4.setSelected(false);
				}
			}
		});
		tglChan4.setBounds(284, 162, 18, 26);
		getContentPane().add(tglChan4);
		
		JToggleButton tglChan5 = new JToggleButton("");
		tglChan5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 5");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(0, 2)){
					tglChan5.setSelected(false);
				}
			}
		});
		tglChan5.setBounds(325, 73, 18, 26);
		getContentPane().add(tglChan5);
		
		JToggleButton tglChan6 = new JToggleButton("");
		tglChan6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 6");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(1, 2)){
					tglChan6.setSelected(false);
				}
			}
		});
		tglChan6.setBounds(325, 162, 18, 26);
		getContentPane().add(tglChan6);
		
		JToggleButton tglChan7 = new JToggleButton("");
		tglChan7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 7");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(0, 3)){
					tglChan7.setSelected(false);
				}
			}
		});
		tglChan7.setBounds(366, 73, 18, 26);
		getContentPane().add(tglChan7);
		
		JToggleButton tglChan8 = new JToggleButton("");
		tglChan8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 8");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!c.getEnabled(1, 3)){
					tglChan8.setSelected(false);
				}
			}
		});
		tglChan8.setBounds(366, 161, 18, 26);
		getContentPane().add(tglChan8);
		
		JButton btnNum1 = new JButton("1");
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"1");
			}
		});
		btnNum1.setBounds(469, 215, 34, 36);
		getContentPane().add(btnNum1);
		
		JButton btnNum2 = new JButton("2");
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"2");
			}
		});
		btnNum2.setBounds(501, 215, 34, 36);
		getContentPane().add(btnNum2);
		
		JButton btnNum3 = new JButton("3");
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"3");
			}
		});
		btnNum3.setBounds(533, 215, 34, 36);
		getContentPane().add(btnNum3);
		
		JButton btnNum4 = new JButton("4");
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"4");
			}
		});
		btnNum4.setBounds(469, 246, 34, 36);
		getContentPane().add(btnNum4);
		
		JButton btnNum5 = new JButton("5");
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"5");
			}
		});
		btnNum5.setBounds(501, 246, 34, 36);
		getContentPane().add(btnNum5);
		
		JButton btnNum6 = new JButton("6");
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"6");
			}
		});
		btnNum6.setBounds(533, 246, 34, 36);
		getContentPane().add(btnNum6);
		
		JButton btnNum7 = new JButton("7");
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"7");
			}
		});
		btnNum7.setBounds(469, 276, 34, 36);
		getContentPane().add(btnNum7);
		
		JButton btnNum8 = new JButton("8");
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"8");
			}
		});
		btnNum8.setBounds(501, 276, 34, 36);
		getContentPane().add(btnNum8);
		
		JButton btnNum9 = new JButton("9");
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"9");
			}
		});
		btnNum9.setBounds(533, 276, 34, 36);
		getContentPane().add(btnNum9);
		
		JButton btnBack = new JButton("-");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!numTxtFld.getText().equals("")){
					numTxtFld.setText(numTxtFld.getText().substring(0,numTxtFld.getText().length()-1));
				}
			}
		});
		btnBack.setBounds(469, 307, 34, 36);
		getContentPane().add(btnBack);
		
		JButton btnNum0 = new JButton("0");
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText()+"0");
			}
		});
		btnNum0.setBounds(501, 307, 34, 36);
		getContentPane().add(btnNum0);
		
		JButton btnEnter = new JButton("+");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("NUM "+numTxtFld.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				numTxtFld.setText("");
			}
		});
		btnEnter.setBounds(533, 307, 34, 36);
		getContentPane().add(btnEnter);
		
		JTextPane txtpnStuff = new JTextPane();
		txtpnStuff.setText("stuff");
		txtpnStuff.setForeground(Color.WHITE);
		txtpnStuff.setBounds(567, 26, -127, 123);
		getContentPane().add(txtpnStuff);
		
		numTxtFld = new JTextField();
		numTxtFld.setEditable(false);
		numTxtFld.setBounds(452, 187, 130, 26);
		getContentPane().add(numTxtFld);
		numTxtFld.setColumns(10);
		
		JLabel lblAddRacer = new JLabel("Add Racer:");
		lblAddRacer.setBounds(452, 172, 80, 16);
		getContentPane().add(lblAddRacer);
		
		
		
		JLabel lblPrinter = new JLabel("Printer");
		lblPrinter.setBounds(442, 26, 61, 16);
		getContentPane().add(lblPrinter);
		
		JTextArea txtQueue = new JTextArea();
		txtQueue.setEditable(false);
		txtQueue.setBounds(187, 224, 200, 58);
		getContentPane().add(txtQueue);
		
		JTextArea txtRun = new JTextArea();
		txtRun.setEditable(false);
		txtRun.setBounds(187, 316, 200, 123);
		getContentPane().add(txtRun);
		
		JLabel lblQueue = new JLabel("Queue");
		lblQueue.setBounds(187, 207, 61, 16);
		getContentPane().add(lblQueue);
		
		JLabel lblRunningfinalTime = new JLabel("Running/Final TIme");
		lblRunningfinalTime.setBounds(187, 296, 129, 16);
		getContentPane().add(lblRunningfinalTime);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEventType = new JMenu("Event Type");
		menuBar.add(mnEventType);
		
		JMenuItem mntmInd = new JMenuItem("Individual");
		mntmInd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("EVENT IND");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		mnEventType.add(mntmInd);
		
		JMenuItem mntmParallel = new JMenuItem("Parallel Individual");
		mntmParallel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("EVENT PARIND");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		mnEventType.add(mntmParallel);
		
		JMenuItem mntmGroup = new JMenuItem("Group");
		mntmGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("EVENT GRP");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		mnEventType.add(mntmGroup);
		
		JMenu mnRun = new JMenu("Run");
		menuBar.add(mnRun);
		
		JMenuItem mntmNewrun = new JMenuItem("NewRun");
		mntmNewrun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("NEWRUN");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRun.add(mntmNewrun);
		
		JMenuItem mntmEndrun = new JMenuItem("EndRun");
		mntmEndrun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("ENDRUN");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRun.add(mntmEndrun);
		JButton btnPower = new JButton("Power");
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglChan1.isSelected()){
					tglChan1.setSelected(false);
				}
				if(tglChan2.isSelected()){
					tglChan2.setSelected(false);
				}
				if(tglChan3.isSelected()){
					tglChan3.setSelected(false);
				}
				if(tglChan4.isSelected()){
					tglChan4.setSelected(false);
				}
				if(tglChan5.isSelected()){
					tglChan5.setSelected(false);
				}
				if(tglChan6.isSelected()){
					tglChan6.setSelected(false);
				}
				if(tglChan7.isSelected()){
					tglChan7.setSelected(false);
				}
				if(tglChan8.isSelected()){
					tglChan8.setSelected(false);
				}
					try {
						c.sendCommand("POWER");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnPower.setBounds(6, 6, 117, 29);
		getContentPane().add(btnPower);
		JTextArea printTxt=new JTextArea();
		printTxt.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(printTxt);
		scrollPane.setBounds(452, 48, 115, 113);
		getContentPane().add(scrollPane);
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTxt.setText(printTxt.getText()+"/n"+c.printGUI());
			}
		});
		btnPrint.setBounds(477, 6, 117, 29);
		getContentPane().add(btnPrint);
		
	
	}
}
