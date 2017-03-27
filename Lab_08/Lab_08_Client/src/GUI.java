import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

   private JPanel contentPane;
   private JPanel panel;
   private JTextArea txtrLastName;
   private JTextField textField;
   private JTextArea txtrFirstName;
   private JTextField textField_1;
   private JTextArea txtrDepartment;
   private JTextField textField_2;
   private JTextArea txtrPhoneNumber;
   private JTextField textField_3;
   private final ButtonGroup buttonGroup = new ButtonGroup();
//   private Employee returnEm = null;
//   private boolean newEm = false;
   private ArrayList<Employee> returnEm = new ArrayList<>();
   private Client c = new Client();

   /**
   * Launch the application.
   */
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                  
//                   frame.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }

   /**
   * Create the frame.
   */
   public GUI() {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 450, 300);
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       setContentPane(contentPane);
       contentPane.setLayout(new GridLayout(0, 1, 0, 0));
      
       panel = new JPanel();
       contentPane.add(panel);
       panel.setLayout(null);
      
       txtrFirstName = new JTextArea();
       txtrFirstName.setEditable(false);
       txtrFirstName.setBounds(17, 4, 100, 22);
       txtrFirstName.setText("First Name: ");
       panel.add(txtrFirstName);
      
       textField = new JTextField();
       textField.setBounds(127, 6, 86, 20);
       panel.add(textField);
       textField.setColumns(10);
      
       txtrLastName = new JTextArea();
       txtrLastName.setEditable(false);
       txtrLastName.setBounds(218, 5, 92, 22);
       txtrLastName.setText("Last Name: ");
       panel.add(txtrLastName);
      
       textField_1 = new JTextField();
       textField_1.setBounds(315, 6, 86, 20);
       panel.add(textField_1);
       textField_1.setColumns(10);
      
       txtrDepartment = new JTextArea();
       txtrDepartment.setEditable(false);
       txtrDepartment.setBounds(17, 37, 100, 22);
       txtrDepartment.setText("Department: ");
       panel.add(txtrDepartment);
      
       textField_2 = new JTextField();
       textField_2.setBounds(127, 37, 86, 20);
       panel.add(textField_2);
       textField_2.setColumns(10);
      
       txtrPhoneNumber = new JTextArea();
       txtrPhoneNumber.setEditable(false);
       txtrPhoneNumber.setBounds(218, 37, 92, 22);
       txtrPhoneNumber.setText("Phone: ");
       panel.add(txtrPhoneNumber);
      
       textField_3 = new JTextField();
       textField_3.setBounds(315, 37, 86, 20);
       panel.add(textField_3);
       textField_3.setColumns(10);
      
       JTextArea txtrGender = new JTextArea();
       txtrGender.setEditable(false);
       txtrGender.setText("Gender: ");
       txtrGender.setBounds(17, 70, 100, 22);
       panel.add(txtrGender);
      
       final JRadioButton rdbtnMale = new JRadioButton("Male");
       buttonGroup.add(rdbtnMale);
       rdbtnMale.setSelected(true);
       rdbtnMale.setBounds(127, 70, 86, 23);
       panel.add(rdbtnMale);
      
       final JRadioButton rdbtnFemale = new JRadioButton("Female");
       buttonGroup.add(rdbtnFemale);
       rdbtnFemale.setBounds(218, 70, 92, 23);
       panel.add(rdbtnFemale);
      
       JRadioButton rdbtnOther = new JRadioButton("Other");
       buttonGroup.add(rdbtnOther);
       rdbtnOther.setBounds(315, 70, 86, 23);
       panel.add(rdbtnOther);
      
       JTextArea txtrTitle = new JTextArea();
       txtrTitle.setEditable(false);
       txtrTitle.setText("Title: ");
       txtrTitle.setBounds(17, 110, 100, 22);
       panel.add(txtrTitle);
      
       Object[] titles = {"Mr.", "Ms.", "Mrs.", "Dr.", "Col.", "Prof."};
       final JList list = new JList(titles);
       list.setBounds(127, 110, 274, 119);
       panel.add(list);
      
       JButton btnSubmit = new JButton("Submit");
       btnSubmit.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
              
               String lastName, firstName, department, phone, gender, title;
               firstName = textField.getText();
               lastName = textField_1.getText();
               department = textField_2.getText();
               phone = textField_3.getText();
               if(rdbtnMale.isSelected()){
                   gender = "Male";
               }
               else if(rdbtnFemale.isSelected()){
                   gender = "Female";
               }
               else gender = "Other";
               title = (String) list.getSelectedValue();
               
//               newEm = true;
               System.out.println("sub - changed to newEm");
               Employee e = new Employee(firstName, lastName, department, phone, gender, title);
               returnEm.add(e);
               
               
               textField.setText("");
               textField_1.setText("");
               textField_2.setText("");
               textField_3.setText("");
               rdbtnMale.setSelected(true);
               rdbtnFemale.setSelected(false);
               rdbtnOther.setSelected(false);
           }
       });
       btnSubmit.setBounds(10, 143, 89, 23);
       panel.add(btnSubmit);
      
       JButton btnExit = new JButton("Exit");
       btnExit.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.out.println("exit - changed to newEm");

//        	   newEm = true;
//              returnEm = null;
               c.em = returnEm;
//               frame.setVisible(false);
               
//               panel.setVisible(false);
           }
       });
       btnExit.setBounds(10, 177, 89, 23);
       panel.add(btnExit);
   }

 
   public ArrayList<Employee> getReturnEm(){
//	   newEm = false;
       System.out.println("gre called");

	   return returnEm;
   }
//   
//   public boolean getNewEm(){
//	   return newEm;
//   }
}
