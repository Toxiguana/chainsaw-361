import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textNum;
	private JTextField textLastName;
	private JTextField textFirstName;
	private JTextField textTime;
	private JLabel lblBIbNumber;
	private JLabel lblLastName;
	private JLabel lblFirstInitial;
	private JLabel lblTime;
	private JLabel lblTimeFormat;
	private JButton btnSubmit;
	private JButton btnExit;
	private JButton btnPrint;
	private JButton btnClear;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 245);
		getContentPane().setLayout(null);
		
		lblBIbNumber = new JLabel("Bib Number:");
		lblBIbNumber.setBounds(22, 20, 86, 16);
		getContentPane().add(lblBIbNumber);
		
		textNum = new JTextField();
		textNum.setBounds(102, 17, 130, 26);
		getContentPane().add(textNum);
		textNum.setColumns(10);
		
		lblLastName= new JLabel("Last Name:");
		lblLastName.setBounds(22, 48, 72, 16);
		getContentPane().add(lblLastName);
		
		textLastName = new JTextField();
		textLastName.setBounds(102, 45, 130, 26);
		getContentPane().add(textLastName);
		textLastName.setColumns(10);
		
		lblFirstInitial = new JLabel("First Intial:");
		lblFirstInitial.setBounds(22, 76, 72, 16);
		getContentPane().add(lblFirstInitial);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(102, 73, 130, 26);
		getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		lblTime = new JLabel("Time:");
		lblTime.setBounds(22, 104, 61, 16);
		getContentPane().add(lblTime);
		
		textTime = new JTextField();
		textTime.setBounds(103, 99, 130, 26);
		getContentPane().add(textTime);
		textTime.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName=textFirstName.getText();
				String lastName=textLastName.getText();
				String runnerNum=textNum.getText();
				String time=textTime.getText();
				Racer r=new Racer(firstName,lastName,runnerNum,time);
				sendData(r,"Add ");
				textFirstName.setText("");
				textLastName.setText("");
				textNum.setText("");
				textTime.setText("");
			}
		});
		btnSubmit.setBounds(204, 141, 117, 29);
		getContentPane().add(btnSubmit);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(204, 166, 117, 29);
		getContentPane().add(btnExit);
		
		lblTimeFormat = new JLabel("(Hours:Minutes:Seconds)");
		lblTimeFormat.setBounds(87, 122, 200, 16);
		getContentPane().add(lblTimeFormat);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendData(null, "Print ");
			}
		});
		btnPrint.setBounds(87, 141, 117, 29);
		getContentPane().add(btnPrint);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendData(null,"Clear ");
			}
		});
		btnClear.setBounds(87, 166, 117, 29);
		getContentPane().add(btnClear);
		setTitle("Racer");
	}
	public void sendData(Racer r, String command){
		   Client c = new Client();
		   c.sendData(r, command);
	   }
	 public static void main(String []args){
		   GUI g = new GUI();
		   g.setVisible(true);
	   }
}
