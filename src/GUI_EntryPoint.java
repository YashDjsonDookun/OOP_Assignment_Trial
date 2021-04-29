import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class GUI_EntryPoint {
	public GUI_EntryPoint() {
		/*
		 * Create Frame
		 */
		JFrame frame = new JFrame();

		/*
		 * Frame Properties
		 */
		frame.setTitle("Mentcare System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);
		frame.setSize(1172, 761);
		frame.setMinimumSize(new Dimension(664, 508));
		frame.getContentPane().setLayout(new GridLayout(5, 1, 0, 15));
		
		/*
		 * Create Components
		 */
		JLabel lbl_MentcareSystem = new JLabel("MENTCARE SYSTEM");
		JLabel lbl_useSystemAs = new JLabel("Use System As:");
		JButton btnAdministrator = new JButton("Administrator");
		JButton btnDoctor = new JButton("Doctor");
		JButton btnMedicReceptionist = new JButton("Medical Receptionist");
		
		/*
		 * Add Components To Frame
		 */
		Component[] entryPointComponents = {lbl_MentcareSystem,lbl_useSystemAs, btnAdministrator, btnDoctor, btnMedicReceptionist};
		
		for (int i = 0; i < entryPointComponents.length; i++) {
			frame.getContentPane().add(entryPointComponents[i]);
		}
		
		/*
		 * lbl_MentcareSystem Properties
		 */
		lbl_MentcareSystem.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_MentcareSystem.setHorizontalAlignment(SwingConstants.CENTER);
		
		/*
		 * lbl_useSystemAs Properties
		 */	
		lbl_useSystemAs.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_useSystemAs.setFont(new Font("Arial", Font.PLAIN, 20));
		
		/*
		 * btnAdministrator Properties 
		 */
		btnAdministrator.setFont(new Font("Arial", Font.BOLD, 23));
		
		/*
		 * btnDoctor Properties
		 */
		btnDoctor.setFont(new Font("Arial", Font.BOLD, 23));
			
		/*
		 * btnMedicReceptionist Properties
		 */
		btnMedicReceptionist.setFont(new Font("Arial", Font.BOLD, 23));
		
		/*
		 * Functionality
		 */
		//btnAdministrator
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					OopsMessage(frame);
				}
			});
		//btnDoctor
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					OpenDoctor(frame);
				}
			});
		//btnMedicReceptionist
		btnMedicReceptionist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					OopsMessage(frame);
				}
			});
	}
	
	/* DOCTOR */
	void OpenDoctor(JFrame frame) {
		String input_DocID = JOptionPane.showInputDialog(frame,"Enter Your DoctorID:");
		
		try{
			int input_DocID_int = Integer.parseInt(input_DocID);
			Boolean notFoundFlag = false;
			try {
				// Query String
				String query = "SELECT doctorId FROM `doctors` WHERE doctorID='" + input_DocID_int + "';";
				// Open Connection to Database
				ConnectDatabase.DB_Connect();
				ResultSet rs;
				Statement st = ConnectDatabase.conn.createStatement();
				rs = st.executeQuery(query);
				// if DoctorID in Database
				while(rs.next()) {
					if (rs.getInt(1)>0) {
				    	  notFoundFlag = !notFoundFlag;
				    	  //Close this window
				    	  frame.dispose();
				    	  // Open new Window
				    	  new GUI_SystemInterface(input_DocID);
				    	  // Close Database Connection
				    	  ConnectDatabase.DB_Close_Connection(ConnectDatabase.conn, rs, st);
				    	  break;
				      }
				}
				//If doctorID not Found in Database
				if(!notFoundFlag) {
					// Close Database Connection
					ConnectDatabase.DB_Close_Connection(ConnectDatabase.conn, rs, st);
					IdNotFound(frame);
				}
			}
			catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, "Oops, Cannot communticate with Database (Table `doctors`)");
			}
		}
		catch (NumberFormatException e) {
			// Invalid ID input
			InvalidID(frame);
		}
	}
	
	/* Oops Message */
	void OopsMessage(JFrame frame) {
		JOptionPane.showMessageDialog(frame,"Work in Progress...\nThis System is currently only for Doctors. Thank You!","Oops!", JOptionPane.WARNING_MESSAGE);
	}
	
	/* IdNotFound Message */
	void IdNotFound(JFrame frame) {
		JOptionPane.showMessageDialog(frame,"Doctor ID Not Found in Doctor's Database.!\nPlease Try Again","ID Not Found!", JOptionPane.ERROR_MESSAGE);
	}
	
	/* Invalid Message */
	public static void InvalidID(JFrame frame) {
		JOptionPane.showMessageDialog(frame,"Invalid ID\nID should only contain numbers!","Error!", JOptionPane.ERROR_MESSAGE);
	}
}
