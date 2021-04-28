import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class GUI_SystemInterface {
	private JTextField txtDoctorFirstName;
	private JTextField txt_DoctorID;
	private JTextField txtDoctorLastName;
	private JTextField txt_Category;
	private JTextField txt_ClearanceLevel;
	
	public GUI_SystemInterface(int getDoctorID_Parameter) {
		/*
		 * Create Frame
		 */
		JFrame frame = new JFrame();
		
		/*
		 * Frame Properties
		 */	
		frame.setTitle("Mentcare System");
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		/*
		 * Create Components
		 */
		JPanel Panel_Title = new JPanel();
		JPanel Panel_DoctorInfo = new JPanel();
		
		JLabel lbl_TitleLabel = new JLabel("Mentcare System");
		JLabel lbl_DoctorInfo = new JLabel("     Doctor:         ");
		JLabel lbl_Date = new JLabel("        Date:     ");
		
		/*
		 * Add Components To Frame
		 */
		frame.getContentPane().add(Panel_Title, BorderLayout.NORTH);
		
		/*
		 * Panel Properties
		 */
		// Panel_Title
		Panel_Title.setLayout(new BorderLayout(0, 0));
		
		// Panel_DoctorInfo
		Panel_DoctorInfo.setLayout(new GridLayout(5, 0, 0, 2));
		
		/*
		 * Add Components To Panels
		 */
		// Panel_Title
		Panel_Title.add(lbl_TitleLabel, BorderLayout.NORTH);
		Panel_Title.add(lbl_DoctorInfo, BorderLayout.WEST);
		Panel_Title.add(lbl_Date, BorderLayout.EAST);
		Panel_Title.add(Panel_DoctorInfo, BorderLayout.CENTER);
		
		// Panel_DoctorInfo
		Panel_DoctorInfo.add(txt_DoctorID);
		Panel_DoctorInfo.add(txtDoctorFirstName);
		Panel_DoctorInfo.add(txtDoctorLastName);
		Panel_DoctorInfo.add(txt_Category);
		Panel_DoctorInfo.add(txt_ClearanceLevel);
		
		
		/*
		 * Components Properties 
		 */
		// lbl_TitleLabel
		lbl_TitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lbl_TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);		
		
		// lbl_DoctorInfo
		lbl_DoctorInfo.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_DoctorInfo.setHorizontalAlignment(SwingConstants.TRAILING);
	
		// lbl_Date
		lbl_Date.setFont(new Font("Arial", Font.PLAIN, 19));

		// txt_DoctorID
		txt_DoctorID = new JTextField();
		txt_DoctorID.setEditable(false);
		txt_DoctorID.setColumns(10);
		
		// txtDoctorFirstName
		txtDoctorFirstName = new JTextField();
		txtDoctorFirstName.setEditable(false);
		txtDoctorFirstName.setColumns(10);
		
		// txtDoctorLastName
		txtDoctorLastName = new JTextField();
		txtDoctorLastName.setEditable(false);
		txtDoctorLastName.setColumns(10);
		
		// txt_Category
		txt_Category = new JTextField();
		txt_Category.setEditable(false);
		txt_Category.setEnabled(false);
		txt_Category.setColumns(10);
		
		// txt_ClearanceLevel
		txt_ClearanceLevel = new JTextField();
		txt_ClearanceLevel.setEditable(false);
		txt_ClearanceLevel.setEnabled(false);
		txt_ClearanceLevel.setColumns(10);
	
		/*
		 * Functionality
		 */

	}
}
