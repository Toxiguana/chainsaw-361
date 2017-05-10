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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.alee.laf.WebLookAndFeel;

public class GUI extends JFrame {
	Thread runTime;
	GUI g;
	ChronoTimer c;
	Thread runTimeGroup;
	ArrayList<Racer> runArr = new ArrayList<>();
	private boolean group=true;
	// function button variables
	private JButton btnBack;
	private JButton btnEnter;
	private JButton btnSwap;
	private JButton btnPower;
	// textbox variables
	private JTextArea txtFinish;
	private JTextArea txtRun;
	private JTextArea txtQueue;
	private JTextField textTime;
	// Channel Labels
	private JLabel lblStart;
	private JLabel lblEnableisable1;
	private JLabel lblFinish;
	private JLabel lblEnableDisable2;
	// channel 1 variables
	private JLabel lblChan1;
	private JButton btnTrigChan1;
	private JToggleButton tglChan1;
	// channel 2 variables
	private JLabel lblchan2;
	private JButton btnTrigChan2;
	private JToggleButton tglChan2;
	// channel 3 variables
	private JLabel lblChan3;
	private JButton btnTrigChan3;
	private JToggleButton tglChan3;
	// channel 4 variables
	private JLabel lblChan4;
	private JButton btnTrigChan4;
	private JToggleButton tglChan4;
	// channel 5 variables
	private JLabel lblChan5;
	private JButton btnTrigChan5;
	private JToggleButton tglChan5;
	// channel 6 variables
	private JLabel lblChan6;
	private JButton btnTrigChan6;
	private JToggleButton tglChan6;
	// channel 7 variables
	private JLabel lblChan7;
	private JButton btnTrigChan7;
	private JToggleButton tglChan7;
	// channel 8 variables
	private JButton btnTrigChan8;
	private JToggleButton tglChan8;
	// numpad variables
	private JLabel lblChan8;
	private JButton btnNum0;
	private JButton btnNum1;
	private JButton btnNum2;
	private JButton btnNum3;
	private JButton btnNum4;
	private JButton btnNum5;
	private JButton btnNum6;
	private JButton btnNum7;
	private JButton btnNum8;
	private JButton btnNum9; 
	private JTextField numTxtFld; 
	private JTextArea printTxt;
	private JButton btnDnf;
	private JButton btnCancel;
	private JLabel lblRun_1;
	private JButton btnSetGroupNumber;
	private JTextField textFieldExport;
	 /**
	 * Create the frame.
	 */
	// ChronoTimer c=new ChronoTimer();
	public GUI(ChronoTimer _c) {
		c = _c;
		g = this;
		UIManager s = new UIManager();

		try {
			UIManager.setLookAndFeel(new WebLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Time t = new Time();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 500, 600, 500);
		setTitle("CHRONOTIMER 1909");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.darkGray);
		btnSwap = new JButton("Swap");
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("SWAP");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (c.getEventType() == 1) {
					Queue<Racer> run = new LinkedList<Racer>(c.racerRun1);
					if (run.size() >= 2) {
						runArr = null;
						runArr = new ArrayList<Racer>();
						while (!run.isEmpty()) {
							Racer r = run.poll();
							runArr.add(r);
						}
						if (runTime.isAlive()) {
							runTime.interrupt();
							runTime = null;
							runTime = new Thread(new RunTime(g, runArr));
							runTime.start();
						}
					}
				}
			}
		});
		btnSwap.setBounds(0, 305, 117, 29);
		getContentPane().add(btnSwap);

		lblStart = new JLabel("Start");
		lblStart.setForeground(Color.WHITE);
		lblStart.setBounds(187, 47, 34, 16);
		getContentPane().add(lblStart);

		lblEnableisable1 = new JLabel("Enable/Disable");
		lblEnableisable1.setForeground(Color.WHITE);
		lblEnableisable1.setBounds(140, 73, 95, 16);
		getContentPane().add(lblEnableisable1);

		lblChan1 = new JLabel("1");
		lblChan1.setForeground(Color.WHITE);
		lblChan1.setBounds(239, 26, 18, 16);
		getContentPane().add(lblChan1);

		lblChan3 = new JLabel("3");
		lblChan3.setForeground(Color.WHITE);
		lblChan3.setBounds(280, 26, 18, 16);
		getContentPane().add(lblChan3);

		lblChan5 = new JLabel("5");
		lblChan5.setForeground(Color.WHITE);
		lblChan5.setBounds(321, 26, 18, 16);
		getContentPane().add(lblChan5);

		lblChan7 = new JLabel("7");
		lblChan7.setForeground(Color.WHITE);
		lblChan7.setBounds(362, 26, 18, 16);
		getContentPane().add(lblChan7);

		lblFinish = new JLabel("Finish");
		lblFinish.setForeground(Color.WHITE);
		lblFinish.setBounds(182, 135, 42, 14);
		getContentPane().add(lblFinish);

		lblEnableDisable2 = new JLabel("Enable/Disable");
		lblEnableDisable2.setForeground(Color.WHITE);
		lblEnableDisable2.setBounds(140, 161, 95, 16);
		getContentPane().add(lblEnableDisable2);

		lblchan2 = new JLabel("2");
		lblchan2.setForeground(Color.WHITE);
		lblchan2.setBounds(239, 114, 18, 16);
		getContentPane().add(lblchan2);

		lblChan4 = new JLabel("4");
		lblChan4.setForeground(Color.WHITE);
		lblChan4.setBounds(280, 114, 18, 16);
		getContentPane().add(lblChan4);

		lblChan6 = new JLabel("6");
		lblChan6.setForeground(Color.WHITE);
		lblChan6.setBounds(321, 114, 18, 16);
		getContentPane().add(lblChan6);

		lblChan8 = new JLabel("8");
		lblChan8.setForeground(Color.WHITE);
		lblChan8.setBounds(362, 114, 18, 16);
		getContentPane().add(lblChan8);

		txtQueue = new JTextArea();
		txtQueue.setEditable(false);
		txtQueue.setBounds(171, 224, 230, 58);
		getContentPane().add(txtQueue);
		
		btnTrigChan1 = new JButton("");
		btnTrigChan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 1");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (c.getEnabled(0, 0)) {
					if (c.getEventType() == 1) {
						// updating queue
						Queue<Racer> tmp = new LinkedList<Racer>(c.racerQueue1);
						int num = 1;
						txtQueue.setText("");
						if (!tmp.isEmpty()) {
							while (num <= 3) {
								Racer r = tmp.poll();
								num++;
								if (r != null) {
									txtQueue.append("NUM " + r.getNum() + "\n");
								}

							}
						}
						Queue<Racer> run = new LinkedList<Racer>(c.racerRun1);
						runArr = null;
						runArr = new ArrayList<Racer>();
						while (!run.isEmpty()) {
							Racer r = run.poll();
							runArr.add(r);
						}
						// start thread if not started
						if (runTime == null) {
							runTime = new Thread(new RunTime(g, runArr));
							runTime.start();
						} else {
							// if thread is running stop thread and restart with
							// new runArr
							if (runTime.isAlive()) {
								runTime.interrupt();
								runTime = null;
								//txtRun.setText("");("");
								runTime = new Thread(new RunTime(g, runArr));
								runTime.start();
							}
						}
					}
					if (c.getEventType() == 2) {
						// updating queue
						Queue<Racer> queue1 = new LinkedList<Racer>(c.racerQueue1);
						Queue<Racer> queue2 = new LinkedList<Racer>(c.racerQueue2);
						txtQueue.setText("");
						Racer r1 = queue1.poll();
						Racer r2 = queue2.poll();
						if (r1 != null) {
							txtQueue.append("NUM " + r1.getNum() + "\n");
						}
						if (r2 != null) {
							txtQueue.append("NUM " + r2.getNum() + "\n");
						}
						// updating runArr
						Queue<Racer> run1 = new LinkedList<Racer>(c.racerRun1);
						Queue<Racer> run2 = new LinkedList<Racer>(c.racerRun2);
						runArr = null;
						runArr = new ArrayList<Racer>();
						while (!run1.isEmpty() || !run2.isEmpty()) {
							Racer racer1 = run1.poll();
							Racer racer2 = run2.poll();
							if (racer1 != null) {
								runArr.add(racer1);
							}
							if (racer2 != null) {
								runArr.add(racer2);
							}
						}
						// if thread is null start thread
						if (runTime == null) {
							runTime = new Thread(new RunTime(g, runArr));
							runTime.start();
						}
						// if thread is running stop thread and restart with new
						// runArr
						else {
							if (runTime.isAlive()) {
								runTime.interrupt();
								runTime = null;
								//txtRun.setText("");("");
								runTime = new Thread(new RunTime(g, runArr));
								runTime.start();
							}
						}
					}
					if(c.getEventType()==4){
						if(runTimeGroup==null){
							runTimeGroup=new Thread(new RuntimeGroup(g,c));
							runTimeGroup.start();
						}
					}
				if(c.getEventType()==5){
						txtQueue.setText("");
						//adding racers to runArr for updating textBox
						Racer[]run=c.racerRunPARGRP.clone();
						runArr = null;
						runArr = new ArrayList<Racer>();
						for(Racer r:run){
							if(r!=null){
							runArr.add(r);
							}
						}
						// start thread if not started
						if (runTime == null) {
							runTime = new Thread(new RunTime(g, runArr));
							runTime.start();
						}
						 else {
							// if thread is running stop thread and restart with
							if (runTime.isAlive()) {
								runTime.interrupt();
								runTime = null;
								//txtRun.setText("");("");
								runTime = new Thread(new RunTime(g, runArr));
								runTime.start();
								// clear finish display
								txtFinish.setText("");
								Queue<Racer> finish = new LinkedList<Racer>(c.racerFinish2);
								// Setting Finish Display
								Object[] finishArr = finish.toArray();
								if(finishArr.length>=1){
								txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
										+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
								
								}
								}

							
									}
							}
				}
			}
		});
		btnTrigChan1.setBounds(233, 47, 42, 26);
		getContentPane().add(btnTrigChan1);

		btnTrigChan2 = new JButton("");
		btnTrigChan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 2");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (c.getEnabled(1, 0)) {
					if (c.getEventType() == 1) {
						// updating racing queue display
						Queue<Racer> tmp = new LinkedList<Racer>(c.racerQueue1);
						int num = 1;
						txtQueue.setText("");
						if (!tmp.isEmpty()) {
							while (num <= 3) {
								Racer r = tmp.poll();
								num++;
								if (r != null) {
									txtQueue.append("NUM " + r.getNum() + "\n");
								}

							}
						}
						// clear finish display
						txtFinish.setText("");
						Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
						// Setting Finish Display
						Object[] finishArr = run.toArray();
						txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
								+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
						// Resetting Racer ArrayList
						while (!run.isEmpty()) {
							Racer r = run.poll();
							if (runArr.contains(r)) {
								int index = runArr.indexOf(r);
								runArr.remove(index);
							}
						}

						// Restarting Thread
						if (runTime != null) {
							if (runTime.isAlive()) {
									runTime.interrupt();
									runTime = null;
									//txtRun.setText("");("");
									runTime = new Thread(new RunTime(g, runArr));
									runTime.start();
								}
							}
						}
					}
					if (c.getEventType() == 2) {
						// updating queue
						Queue<Racer> queue1 = new LinkedList<Racer>(c.racerQueue1);
						Queue<Racer> queue2 = new LinkedList<Racer>(c.racerQueue2);
						txtQueue.setText("");
						Racer r1 = queue1.poll();
						Racer r2 = queue2.poll();
						if (r1 != null) {
							txtQueue.append("NUM " + r1.getNum() + "\n");
						}
						if (r2 != null) {
							txtQueue.append("NUM" + r2.getNum() + "\n");
						}
						txtFinish.setText("");
						Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
						// Setting Finish Display
						Object[] finishArr = run.toArray();
						txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
								+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F \n");
						if (finishArr.length >= 2) {
							txtFinish.append(+((Racer) finishArr[finishArr.length - 2]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 2]).getElapsedTime() + " F");
						}
						// Resetting Racer ArrayList
						while (!run.isEmpty()) {
							Racer r = run.poll();
							if (runArr.contains(r)) {
								int index = runArr.indexOf(r);
								runArr.remove(index);
							}
						}
						// Restarting Thread
						if (runTime != null) {
							if (runTime.isAlive()) {
								runTime.interrupt();
								runTime = null;
								//txtRun.setText("");("");
								runTime = new Thread(new RunTime(g, runArr));
								runTime.start();
							}
						}
					}
					if(c.getEventType()==4){
						txtFinish.setText("");
						Queue<Racer> run = new LinkedList<Racer>(c.racerFinish1);
						// Setting Finish Display
						Object[] finishArr = run.toArray();
						txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
								+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
						txtQueue.setText("Number of Racers at Finish "+c.racerFinish1.size());
						
					}
					if(c.getEventType()==5){
								// clear finish display
								txtFinish.setText("");
								Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
								// Setting Finish Display
								if(run.size()>=1){
								Object[] finishArr = run.toArray();
								txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
										+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
								}
								// Resetting Racer ArrayList
								while (!run.isEmpty()) {
									Racer r = run.poll();
									if (runArr.contains(r)) {
										int index = runArr.indexOf(r);
										runArr.remove(index);
									}
								}

								// Restarting Thread
								if (runTime != null) {
									if (runTime.isAlive()) {
											runTime.interrupt();
											runTime = null;
											//txtRun.setText("");("");
											runTime = new Thread(new RunTime(g, runArr));
											runTime.start();
										}
									}
					}
			}
			
		});
		btnTrigChan2.setBounds(233, 135, 42, 26);
		getContentPane().add(btnTrigChan2);

		btnTrigChan3 = new JButton("");
		btnTrigChan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 3");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (c.getEnabled(0, 1)) {
					if (c.getEventType() == 2) {
						// updating queue
						Queue<Racer> queue1 = new LinkedList<Racer>(c.racerQueue1);
						Queue<Racer> queue2 = new LinkedList<Racer>(c.racerQueue2);
						txtQueue.setText("");
						Racer r1 = queue1.poll();
						Racer r2 = queue2.poll();
						if (r1 != null) {
							txtQueue.append("NUM " + r1.getNum() + "\n");
						}
						if (r2 != null) {
							txtQueue.append("NUM " + r2.getNum() + "\n");
						}

						// updating runArr
						Queue<Racer> run1 = new LinkedList<Racer>(c.racerRun1);
						Queue<Racer> run2 = new LinkedList<Racer>(c.racerRun2);
						runArr = null;
						runArr = new ArrayList<Racer>();
						while (!run1.isEmpty() || !run2.isEmpty()) {
							Racer racer1 = run1.poll();
							Racer racer2 = run2.poll();
							if (racer1 != null) {
								runArr.add(racer1);
							}
							if (racer2 != null) {
								runArr.add(racer2);
							}
						}
						// if thread is null start thread
						if (runTime == null) {
							runTime = new Thread(new RunTime(g, runArr));
							runTime.start();
						}
						// if thread is running stop thread and restart with new
						// runArr
						else {
							if (runTime.isAlive()) {
								runTime.interrupt();
								runTime = null;
								//txtRun.setText("");("");
								runTime = new Thread(new RunTime(g, runArr));
								runTime.start();
							}
						}
					}
					if(c.getEventType()==5){
							// clear finish display
							txtFinish.setText("");
							Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
							// Setting Finish Display
							Object[] finishArr = run.toArray();
							txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
							// Resetting Racer ArrayList
							while (!run.isEmpty()) {
								Racer r = run.poll();
								if (runArr.contains(r)) {
									int index = runArr.indexOf(r);
									runArr.remove(index);
								}
							}

							// Restarting Thread
							if (runTime != null) {
								if (runTime.isAlive()) {
									if (runArr.isEmpty()) {
										runTime.interrupt();
										runTime=null;
										//txtRun.setText("");("");
									} else {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
										runTime = new Thread(new RunTime(g, runArr));
										runTime.start();
									}
								}
						}
					}
				}
			}
		});
		btnTrigChan3.setBounds(274, 47, 42, 26);
		getContentPane().add(btnTrigChan3);

		btnTrigChan4 = new JButton("");
		btnTrigChan4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 4");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(c.getEnabled(1, 1)){
				if (c.getEventType() == 2) {
					// updating queue
					txtQueue.setText("");
					Queue<Racer> tmp1 = new LinkedList<Racer>(c.racerQueue1);
					Queue<Racer> tmp2 = new LinkedList<Racer>(c.racerQueue2);
					if (!tmp1.isEmpty()) {
						txtQueue.append("NUM " + tmp1.peek().getNum() + "\n");
					}
					if (!tmp2.isEmpty()) {
						txtQueue.append("NUM " + tmp2.peek().getNum());
					}
					// updating finish display
					txtFinish.setText("");
					Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
					// Setting Finish Display
					Object[] finishArr = run.toArray();
					txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
							+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F \n");
					if (finishArr.length >= 2) {
						txtFinish.append(+((Racer) finishArr[finishArr.length - 2]).getNum() + " "
								+ ((Racer) finishArr[finishArr.length - 2]).getElapsedTime() + " F");
					}
					// Resetting Racer ArrayList
					while (!run.isEmpty()) {
						Racer r = run.poll();
						if (runArr.contains(r)) {
							int index = runArr.indexOf(r);
							runArr.remove(index);
						}
					}
					// Resetting Racer ArrayList
					while (!run.isEmpty()) {
						Racer r = run.poll();
						if (runArr.contains(r)) {
							int index = runArr.indexOf(r);
							runArr.remove(index);
						}
					}
					// Restarting Thread
					if (runTime != null) {
						if (runTime.isAlive()) {
							runTime.interrupt();
							runTime = null;
							//txtRun.setText("");("");
							runTime = new Thread(new RunTime(g, runArr));
							runTime.start();
						}
					}
				}
				if(c.getEventType()==5){
							// clear finish display
							txtFinish.setText("");
							Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
							// Setting Finish Display
							Object[] finishArr = run.toArray();
							txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
							// Resetting Racer ArrayList
							while (!run.isEmpty()) {
								Racer r = run.poll();
								if (runArr.contains(r)) {
									int index = runArr.indexOf(r);
									runArr.remove(index);
								}
							}

							// Restarting Thread
							if (runTime != null) {
								if (runTime.isAlive()) {
									if (runArr.isEmpty()) {
										runTime.interrupt();
										runTime=null;
										//txtRun.setText("");("");
									} else {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
										runTime = new Thread(new RunTime(g, runArr));
										runTime.start();
									}
								}
					}
				}
				}
			}
		});
		btnTrigChan4.setBounds(274, 135, 42, 26);
		getContentPane().add(btnTrigChan4);

		btnTrigChan5 = new JButton("");
		btnTrigChan5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 5");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (c.getEnabled(0, 2)) {
					if (c.getEventType() == 5) {
							// clear finish display
							txtFinish.setText("");
							Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
							// Setting Finish Display
							Object[] finishArr = run.toArray();
							txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
							// Resetting Racer ArrayList
							while (!run.isEmpty()) {
								Racer r = run.poll();
								if (runArr.contains(r)) {
									int index = runArr.indexOf(r);
									runArr.remove(index);
								}
							}

							// Restarting Thread
							if (runTime != null) {
								if (runTime.isAlive()) {
									if (runArr.isEmpty()) {
										runTime = null;
										//txtRun.setText("");("");
									} else {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
										runTime = new Thread(new RunTime(g, runArr));
										runTime.start();
									}
								}
							}
						}
				}
			}
		});
		btnTrigChan5.setBounds(315, 47, 42, 26);
		getContentPane().add(btnTrigChan5);

		btnTrigChan6 = new JButton("");
		btnTrigChan6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 6");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				if (c.getEnabled(1, 2)) {
					if (c.getEventType() == 5) {
							// clear finish display
							txtFinish.setText("");
							Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
							// Setting Finish Display
							Object[] finishArr = run.toArray();
							txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
							// Resetting Racer ArrayList
							while (!run.isEmpty()) {
								Racer r = run.poll();
								if (runArr.contains(r)) {
									int index = runArr.indexOf(r);
									runArr.remove(index);
								}
							}

							// Restarting Thread
							if (runTime != null) {
								if (runTime.isAlive()) {
									if (runArr.isEmpty()) {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
									} else {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
										runTime = new Thread(new RunTime(g, runArr));
										runTime.start();
									}
								}
						}
					}
				}
				
			}
		});
		btnTrigChan6.setBounds(315, 135, 42, 26);
		getContentPane().add(btnTrigChan6);

		btnTrigChan7 = new JButton("");
		btnTrigChan7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 7");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (c.getEnabled(0, 3)) {
					if (c.getEventType() == 5) {
							// clear finish display
							txtFinish.setText("");
							Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
							// Setting Finish Display
							Object[] finishArr = run.toArray();
							txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
							// Resetting Racer ArrayList
							while (!run.isEmpty()) {
								Racer r = run.poll();
								if (runArr.contains(r)) {
									int index = runArr.indexOf(r);
									runArr.remove(index);
								}
							}

							// Restarting Thread
							if (runTime != null) {
								if (runTime.isAlive()) {
									if (runArr.isEmpty()) {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
									} else {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
										runTime = new Thread(new RunTime(g, runArr));
										runTime.start();
									}
								}
							}
					}
				}
			}
		});
		btnTrigChan7.setBounds(356, 47, 42, 26);
		getContentPane().add(btnTrigChan7);

		btnTrigChan8 = new JButton("");
		btnTrigChan8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TRIG 8");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (c.getEnabled(1, 3)) {
					if (c.getEventType() == 5) {
							// clear finish display
							txtFinish.setText("");
							Queue<Racer> run = new LinkedList<Racer>(c.racerFinish2);
							// Setting Finish Display
							Object[] finishArr = run.toArray();
							txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
							// Resetting Racer ArrayList
							while (!run.isEmpty()) {
								Racer r = run.poll();
								if (runArr.contains(r)) {
									int index = runArr.indexOf(r);
									runArr.remove(index);
								}
							}

							// Restarting Thread
							if (runTime != null) {
								if (runTime.isAlive()) {
									if (runArr.isEmpty()) {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
									} else {
										runTime.interrupt();
										runTime = null;
										//txtRun.setText("");("");
										runTime = new Thread(new RunTime(g, runArr));
										runTime.start();
									}
								}
							}
						}
				}
			}
		});
		btnTrigChan8.setBounds(356, 135, 42, 26);
		getContentPane().add(btnTrigChan8);

		tglChan1 = new JToggleButton("");
		tglChan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 1");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(0, 0)) {
					tglChan1.setSelected(false);
				}
			}

		});
		tglChan1.setBounds(243, 74, 18, 26);
		getContentPane().add(tglChan1);

		tglChan2 = new JToggleButton("");
		tglChan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 2");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(1, 0)) {
					tglChan2.setSelected(false);
				}
			}
		});
		tglChan2.setBounds(243, 162, 18, 26);
		getContentPane().add(tglChan2);

		tglChan3 = new JToggleButton("");
		tglChan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 3");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(0, 1)) {
					tglChan3.setSelected(false);
				}
			}
		});
		tglChan3.setBounds(284, 73, 18, 26);
		getContentPane().add(tglChan3);

		tglChan4 = new JToggleButton("");
		tglChan4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 4");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(1, 1)) {
					tglChan4.setSelected(false);
				}
			}
		});
		tglChan4.setBounds(284, 162, 18, 26);
		getContentPane().add(tglChan4);

		tglChan5 = new JToggleButton("");
		tglChan5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 5");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(0, 2)) {
					tglChan5.setSelected(false);
				}
			}
		});
		tglChan5.setBounds(325, 73, 18, 26);
		getContentPane().add(tglChan5);

		tglChan6 = new JToggleButton("");
		tglChan6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 6");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(1, 2)) {
					tglChan6.setSelected(false);
				}
			}
		});
		tglChan6.setBounds(325, 162, 18, 26);
		getContentPane().add(tglChan6);

		tglChan7 = new JToggleButton("");
		tglChan7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 7");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(0, 3)) {
					tglChan7.setSelected(false);
				}
			}
		});
		tglChan7.setBounds(366, 73, 18, 26);
		getContentPane().add(tglChan7);

		tglChan8 = new JToggleButton("");
		tglChan8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("TOG 8");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!c.getEnabled(1, 3)) {
					tglChan8.setSelected(false);
				}
			}
		});
		tglChan8.setBounds(366, 161, 18, 26);
		getContentPane().add(tglChan8);

		btnNum1 = new JButton("1");
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "1");
			}
		});
		btnNum1.setBounds(461, 212, 41, 36);
		getContentPane().add(btnNum1);

		btnNum2 = new JButton("2");
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "2");
			}
		});
		btnNum2.setBounds(501, 212, 41, 36);
		getContentPane().add(btnNum2);

		btnNum3 = new JButton("3");
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "3");
			}
		});
		btnNum3.setBounds(541, 212, 41, 36);
		getContentPane().add(btnNum3);

		btnNum4 = new JButton("4");
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "4");
			}
		});
		btnNum4.setBounds(461, 247, 41, 36);
		getContentPane().add(btnNum4);

		btnNum5 = new JButton("5");
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "5");
			}
		});
		btnNum5.setBounds(501, 247, 41, 36);
		getContentPane().add(btnNum5);

		btnNum6 = new JButton("6");
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "6");
			}
		});
		btnNum6.setBounds(541, 247, 41, 36);
		getContentPane().add(btnNum6);

		btnNum7 = new JButton("7");
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "7");
			}
		});
		btnNum7.setBounds(461, 282, 41, 36);
		getContentPane().add(btnNum7);

		btnNum8 = new JButton("8");
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "8");
			}
		});
		btnNum8.setBounds(501, 282, 41, 36);
		getContentPane().add(btnNum8);

		btnNum9 = new JButton("9");
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "9");
			}
		});
		btnNum9.setBounds(541, 282, 41, 36);
		getContentPane().add(btnNum9);

		btnBack = new JButton("-");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!numTxtFld.getText().equals("")) {
					numTxtFld.setText(numTxtFld.getText().substring(0, numTxtFld.getText().length() - 1));
				}
			}
		});
		btnBack.setBounds(461, 317, 41, 36);
		getContentPane().add(btnBack);

		btnNum0 = new JButton("0");
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numTxtFld.setText(numTxtFld.getText() + "0");
			}
		});
		btnNum0.setBounds(501, 317, 41, 36);
		getContentPane().add(btnNum0);

		btnEnter = new JButton("+");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!numTxtFld.getText().equals("")) {
					if (c.getEventType() == 1 || c.getEventType() == 2) {
						try {
							c.sendCommand("NUM " + numTxtFld.getText());
							numTxtFld.setText("");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else if (c.getEventType() == 4) {
						try {
							c.sendCommand("GROUP " + numTxtFld.getText());
							numTxtFld.setText("");

						} catch (IOException e1) {
							e1.printStackTrace();
						}
						txtQueue.setText("Number of Racers at Finish " + c.racerFinish1.size());
					}
					if (c.getEventType() == 1) {
						txtQueue.setText("");
						Queue<Racer> tmp = new LinkedList<Racer>(c.racerQueue1);
						int num = 1;
						for (Racer r : tmp) {
							if (num <= 3) {
								num++;
								txtQueue.append("NUM " + r.getNum() + "\n");
							} else {
								break;
							}
						}
					}
					if (c.getEventType() == 2) {
						txtQueue.setText("");
						Queue<Racer> tmp1 = new LinkedList<Racer>(c.racerQueue1);
						Queue<Racer> tmp2 = new LinkedList<Racer>(c.racerQueue2);
						if (!tmp1.isEmpty()) {
							txtQueue.append("NUM " + tmp1.poll().getNum() + "\n");
						}
						if (!tmp2.isEmpty()) {
							txtQueue.append("NUM " + tmp2.poll().getNum());
						}
					}
					if (c.getEventType() == 5) {
						try {
							c.sendCommand("NUM " + numTxtFld.getText());
							numTxtFld.setText("");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						int rowCount = 0;
						int num = 0;
						txtQueue.setText("");
						Queue<Racer> tmp1 = new LinkedList<Racer>(c.racerQueue1);
						while (!tmp1.isEmpty()) {
							Racer r=tmp1.poll();
							if (num <= 7) {
								if (rowCount <= 2) {
									txtQueue.append("NUM " + r.getNum() + "     ");
									rowCount++;
									num++;
								} else {
									rowCount = 0;
									txtQueue.append("\n");
									txtQueue.append("NUM " + r.getNum() + "     ");
									rowCount++;
									num++;
								}
							}
						}
					}
				}
			}
		});
		btnEnter.setBounds(541, 317, 41, 36);
		getContentPane().add(btnEnter);

		JTextPane txtpnStuff = new JTextPane();
		txtpnStuff.setText("stuff");
		txtpnStuff.setForeground(Color.WHITE);
		txtpnStuff.setBounds(567, 26, -127, 123);
		getContentPane().add(txtpnStuff);

		numTxtFld = new JTextField();
		numTxtFld.setEditable(false);
		numTxtFld.setBounds(452, 182, 130, 26);
		getContentPane().add(numTxtFld);
		numTxtFld.setColumns(10);

		JLabel lblAddRacer = new JLabel("Add Racer:");
		lblAddRacer.setForeground(Color.WHITE);
		lblAddRacer.setBounds(452, 165, 80, 16);
		getContentPane().add(lblAddRacer);

		JLabel lblQueue = new JLabel("Queue");
		lblQueue.setForeground(Color.WHITE);
		lblQueue.setBounds(171, 205, 61, 16);
		getContentPane().add(lblQueue);

		JLabel lblRunningfinalTime = new JLabel("Running/Final Time");
		lblRunningfinalTime.setForeground(Color.WHITE);
		lblRunningfinalTime.setBounds(187, 291, 129, 16);
		getContentPane().add(lblRunningfinalTime);
		JButton btnPower = new JButton("Power");
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglChan1.isSelected()) {
					tglChan1.setSelected(false);
				}
				if (tglChan2.isSelected()) {
					tglChan2.setSelected(false);
				}
				if (tglChan3.isSelected()) {
					tglChan3.setSelected(false);
				}
				if (tglChan4.isSelected()) {
					tglChan4.setSelected(false);
				}
				if (tglChan5.isSelected()) {
					tglChan5.setSelected(false);
				}
				if (tglChan6.isSelected()) {
					tglChan6.setSelected(false);
				}
				if (tglChan7.isSelected()) {
					tglChan7.setSelected(false);
				}
				if (tglChan8.isSelected()) {
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
		btnPower.setBounds(0, 6, 117, 29);
		getContentPane().add(btnPower);

		printTxt = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(printTxt);
		printTxt.setEditable(false);
		scrollPane.setBounds(422, 47, 145, 109);
		getContentPane().add(scrollPane);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> arr = c.printGUI();
				if (arr != null) {
					for (int i = 0; i < arr.size(); i++) {
						printTxt.append(arr.get(i) + "\n");
					}
				}
				try {
					c.sendCommand("PRINT " + (c.getRunNum() - 1));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(477, 6, 117, 29);
		getContentPane().add(btnPrint);

		txtFinish = new JTextArea();
		txtFinish.setEditable(false);
		txtFinish.setBounds(187, 315, 200, 38);
		getContentPane().add(txtFinish);

		txtRun = new JTextArea();
		txtRun.setEditable(false);
		txtRun.setBounds(187, 352, 200, 88);
		getContentPane().add(txtRun);

		JLabel lblEventType = new JLabel("Event Type:");
		lblEventType.setForeground(Color.WHITE);
		lblEventType.setBounds(0, 47, 85, 16);
		getContentPane().add(lblEventType);

		JButton btnInd = new JButton("IND");
		btnInd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("EVENT IND");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnInd.setBounds(0, 60, 117, 29);
		getContentPane().add(btnInd);

		JButton btnParind = new JButton("PARIND");
		btnParind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("EVENT PARIND");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnParind.setBounds(0, 85, 117, 29);
		getContentPane().add(btnParind);

		JButton btnPargrp = new JButton("PARGRP");
		btnPargrp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("EVENT PARGRP");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPargrp.setBounds(0, 110, 117, 29);
		getContentPane().add(btnPargrp);

		JButton btnGrp = new JButton("GRP");
		btnGrp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("EVENT GRP");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGrp.setBounds(0, 135, 117, 29);
		getContentPane().add(btnGrp);

		JLabel lblRun = new JLabel("Run:");
		lblRun.setForeground(Color.WHITE);
		lblRun.setBounds(0, 161, 85, 16);
		getContentPane().add(lblRun);

		JButton btnNewRun = new JButton("New Run");
		btnNewRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("NEWRUN");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewRun.setBounds(0, 175, 117, 29);
		getContentPane().add(btnNewRun);

		JButton btnEndRun = new JButton("End Run");
		btnEndRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglChan1.isSelected()) {
					tglChan1.setSelected(false);
				}
				if (tglChan2.isSelected()) {
					tglChan2.setSelected(false);
				}
				if (tglChan3.isSelected()) {
					tglChan3.setSelected(false);
				}
				if (tglChan4.isSelected()) {
					tglChan4.setSelected(false);
				}
				if (tglChan5.isSelected()) {
					tglChan5.setSelected(false);
				}
				if (tglChan6.isSelected()) {
					tglChan6.setSelected(false);
				}
				if (tglChan7.isSelected()) {
					tglChan7.setSelected(false);
				}
				if (tglChan8.isSelected()) {
					tglChan8.setSelected(false);
				}
				try {
					c.sendCommand("ENDRUN");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//txtRun.setText("");("");
				txtQueue.setText("");
				txtFinish.setText("");
			}
		});
		btnEndRun.setBounds(0, 200, 117, 29);
		getContentPane().add(btnEndRun);

		JLabel lblRacer = new JLabel("Racer:");
		lblRacer.setForeground(Color.WHITE);
		lblRacer.setBounds(0, 225, 85, 16);
		getContentPane().add(lblRacer);

		btnDnf = new JButton("DNF");
		btnDnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("DNF");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(c.getEventType()==1){
					Queue<Racer> tmp = new LinkedList<Racer>(c.racerQueue1);
					int num = 1;
					txtQueue.setText("");
					if (!tmp.isEmpty()) {
						while (num <= 3) {
							Racer r = tmp.poll();
							num++;
							if (r != null) {
								txtQueue.append("NUM " + r.getNum() + "\n");
							}
						}
					}
					Queue<Racer> run = new LinkedList<Racer>(c.racerRun1);
					runArr = null;
					runArr = new ArrayList<Racer>();
					while (!run.isEmpty()) {
						Racer r = run.poll();
						runArr.add(r);
					}
					// start thread if not started
					if (runTime != null) {
						if (runTime.isAlive()) {
							runTime.interrupt();
							runTime = null;
							runTime = new Thread(new RunTime(g, runArr));
							runTime.start();
						}
						// clear finish display
						txtFinish.setText("");
						Queue<Racer> finish = new LinkedList<Racer>(c.racerFinish2);
						// Setting Finish Display
						Object[] finishArr = finish.toArray();
						txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
								+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
						if (runArr.size() == 0) {
							//txtRun.setText("");("");
						}
					}
				}
					if(c.getEventType()==4){
						if (runTimeGroup != null) {
							// clear finish display
							txtFinish.setText("");
							Queue<Racer> finish = new LinkedList<Racer>(c.racerFinish1);
							// Setting Finish Display
							Object[] finishArr = finish.toArray();
							txtFinish.append(+((Racer) finishArr[finishArr.length - 1]).getNum() + " "
									+ ((Racer) finishArr[finishArr.length - 1]).getElapsedTime() + " F");
							txtQueue.setText("Number of Racers at Finish " + c.racerFinish1.size());

						}
					}
			}
		});
		btnDnf.setBounds(0, 240, 117, 29);
		getContentPane().add(btnDnf);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.sendCommand("CANCEL");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(c.getEventType()==1){
					if(runTime!=null){
						runTime.interrupt();
						if(runArr.size()>0){
						runArr.remove(0);
						}
						runTime=null;
						runTime=new Thread(new RunTime(g,runArr));
						runTime.start();
						
					}
				if(runArr.size()==0){
					//txtRun.setText("");("");
				}
					Queue<Racer> tmp = new LinkedList<Racer>(c.racerQueue1);
					int num = 1;
					txtQueue.setText("");
					if (!tmp.isEmpty()) {
						while (num <= 3) {
							Racer r = tmp.poll();
							num++;
							if (r != null) {
								txtQueue.append("NUM " + r.getNum() + "\n");
							}
						}
					}
				}
			}
		});
		btnCancel.setBounds(0, 265, 117, 29);
		getContentPane().add(btnCancel);

		lblRun_1 = new JLabel("Run:");
		lblRun_1.setForeground(Color.WHITE);
		lblRun_1.setBounds(0, 291, 85, 16);
		getContentPane().add(lblRun_1);

		btnSetGroupNumber = new JButton("Set Group Number");
		btnSetGroupNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.getEventType() == 4||c.getEventType()==0) {
					if (!numTxtFld.getText().equals("")) {
						try {
							c.sendCommand("GROUP " + numTxtFld.getText());
							numTxtFld.setText("");
							txtQueue.setText("Number of Racers at Finish " + c.racerFinish1.size());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSetGroupNumber.setBounds(449, 357, 145, 29);
		getContentPane().add(btnSetGroupNumber);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!numTxtFld.getText().equals("")) {
					String res=numTxtFld.getText();
					c.sendCommand("CLR "+res);
					numTxtFld.setText("");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnClear.setBounds(465, 384, 117, 29);
		getContentPane().add(btnClear);
		
		textTime = new JTextField();
		textTime.setBounds(10, 347, 130, 26);
		getContentPane().add(textTime);
		textTime.setColumns(10);
		
		JLabel lblhoursminutesseconds = new JLabel("(Hours:Minutes:Seconds)");
		lblhoursminutesseconds.setForeground(Color.WHITE);
		lblhoursminutesseconds.setBounds(0, 336, 156, 16);
		getContentPane().add(lblhoursminutesseconds);
		
		JButton btnSetTime = new JButton("Set Time");
		btnSetTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textTime.getText().equals("")){
					String send=textTime.getText();
					try {
						c.sendCommand("TIME "+send);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textTime.setText("");
				}
			}
		});
		btnSetTime.setBounds(0, 373, 117, 29);
		getContentPane().add(btnSetTime);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(!textFieldExport.getText().equals("")){
					String res=textFieldExport.getText();
					c.sendCommand("EXPORT "+res);
					textFieldExport.setText("");
				}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExport.setBounds(0, 397, 117, 29);
		getContentPane().add(btnExport);
		
		textFieldExport = new JTextField();
		textFieldExport.setColumns(10);
		textFieldExport.setBounds(90, 425, 50, 26);
		getContentPane().add(textFieldExport);
		
		JLabel lblRunNumber = new JLabel("Run Number:");
		lblRunNumber.setForeground(Color.WHITE);
		lblRunNumber.setBounds(0, 430, 85, 16);
		getContentPane().add(lblRunNumber);
	}

	public void updateTime(ArrayList<Racer> run) {
		runArr = run;
		if(run.size()>=0){
		try{txtRun.setText("");
		}catch(Exception ex){
		}
		}
		if (c.getEventType() == 1 || c.getEventType() == 2||c.getEventType()==5) {
			int num=1;
			if(run.size()>=1){
			for (int i = 0; i < run.size(); i++) {
				if(num<=5){
				num++;
				Racer r = run.get(i);
				try{txtRun.append(r.getOutput() + " R" + "\n");
				}
				catch(Exception ex){
				}
				}
			}
			}
		}

	}
	public void updateTimeGroup(String output){
		if(c.getEventType()!=0){
		//txtRun.setText("");("");
		txtRun.append(output);
		}
		else{
			txtRun.setText("");
			runTimeGroup.interrupt();
			runTimeGroup=null;
		}
	}
	public void resetTextBox(){
		txtRun.setText("");
	}
	}
	
