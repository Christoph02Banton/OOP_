// Author/Name: Christoph Banton 
// ID Number: 2100760
// Module: Object Oritented Programming
// Date: November 7, 2022
// Description: Creating Login Screen for Users

package guiPKG.screens;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import models.Admin;
import models.User;
import java.awt.*;
import models.Staff;
import models.Student;

public class LoginScreen implements ActionListener { // Initializing of Login Screen

	private static JPanel mainPanel;
	private JPanel actionMenu;
	private static JLabel title;
	private static JTextField userText;
	private static JPasswordField passText;
	private static JButton loginBtn;
	private static JLabel apptitle, UserLabel, passLabel;
	private JFrame frame;

	public LoginScreen(JFrame frame) {
		initializeComponents(frame);
		addComponentsToPanel();
		setWindowProperties();
		registerListeners();
	}

	private void initializeComponents(JFrame frame) {
		// Setting frame properties
		this.frame = frame;

		mainPanel = new JPanel(); // Setting Frame background and size
		mainPanel.setSize(1000, 1000);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.darkGray);

		apptitle = new JLabel("Home & Away Institute"); // Setting Frame Labels along with font size and colour
		apptitle.setFont(new Font("Arial", Font.BOLD, 40));
		apptitle.setForeground(Color.black);
		apptitle.setBounds(175, 100, 500, 50);

		title = new JLabel("Login"); // Setting frame label along with font size and colour
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setForeground(Color.black);
		title.setBounds(175, 200, 100, 50);

		UserLabel = new JLabel("USER ID"); // Setting frame label along with font size and colour
		UserLabel.setBounds(250, 250, 100, 25);
		UserLabel.setFont(new Font("Arial", Font.BOLD, 15));
		UserLabel.setForeground(Color.black);

		userText = new JTextField(20); // Setting text field
		userText.setBounds(250, 275, 300, 25);
		userText.setFont(new Font("Arial", Font.BOLD, 12));
		userText.setForeground(Color.black);

		passLabel = new JLabel("PASSWORD"); // Setting frame label along with font size and colour
		passLabel.setBounds(250, 300, 100, 25);
		passLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passLabel.setForeground(Color.black);

		passText = new JPasswordField(); // Setting password field in the frame
		passText.setBounds(250, 325, 300, 25);

		loginBtn = new JButton("Login"); // Setting frame button along with font size and colour
		loginBtn.setBorder(null);
		loginBtn.setBackground(Color.ORANGE);
		loginBtn.setLayout(new GridBagLayout());
		loginBtn.setSize(75, 25);

		actionMenu = new JPanel();
		// actionMenu.setBackground(Color.darkGray);
		actionMenu.setMaximumSize(new Dimension(550, 32767));
		actionMenu.setPreferredSize(new Dimension(400, 400));

		GroupLayout actionMenuLayout = new GroupLayout(actionMenu);
		actionMenu.setLayout(actionMenuLayout);
		actionMenuLayout.setHorizontalGroup(
				actionMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(actionMenuLayout.createSequentialGroup()
								.addGap(100, 100, 100)
								.addGroup(actionMenuLayout
										.createParallelGroup(
												GroupLayout.Alignment.TRAILING,
												false)
										.addComponent(UserLabel,
												GroupLayout.DEFAULT_SIZE,
												150,
												Short.MAX_VALUE)
										.addComponent(userText,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(passLabel,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(passText,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										// .addGap(150, 150, 150)
										.addComponent(loginBtn,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(30, 30, 30))

								.addContainerGap(25, Short.MAX_VALUE)));
		actionMenuLayout.setVerticalGroup(
				actionMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(actionMenuLayout.createSequentialGroup()
								.addGap(200, 200, 200)
								.addComponent(UserLabel, GroupLayout.PREFERRED_SIZE,
										25,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(userText, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(100, 100, 100)
								.addComponent(passLabel, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addComponent(passText,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(180, 180, 180)
								.addComponent(loginBtn,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(150, Short.MAX_VALUE)));
	}

	public void addComponentsToPanel() {
		mainPanel.add(apptitle);
		// mainPanel.add(title);
		// mainPanel.add(UserLabel);
		// mainPanel.add(userText);
		// mainPanel.add(passLabel);
		// mainPanel.add(passText);
		// mainPanel.add(loginBtn);
	}

	// Setting properties of the login screen frame
	public void setWindowProperties() {
		frame.pack();
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.getContentPane().add(actionMenu, BorderLayout.WEST);
		frame.setBackground(Color.DARK_GRAY);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
 
	// Register button listeners in this class
	public void registerListeners() {
		loginBtn.addActionListener(this);
	}

	public boolean validateFields() { // Checking if password field is empty
		return userText.getText().isEmpty() || passText.getPassword().length == 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userNmIn = userText.getText();
		String userPassIn = new String(passText.getPassword());

		if (e.getSource().equals(loginBtn)) {
			if (!validateFields()) {
				User user;
				user = new Staff();
				boolean verify = user.verifyLogin(userNmIn, userPassIn);
				if (verify == true) {
					mainPanel.setVisible(false);
					actionMenu.setVisible(false);
					new StaffScreen(frame);
				} else {
					user = new Student();
					verify = user.verifyLogin(userNmIn, userPassIn);
					if (verify == true) {
						mainPanel.setVisible(false);
						actionMenu.setVisible(false);
						new StudentScreen(frame,userNmIn); 
					} else {
						user = new Admin();
						verify = user.verifyLogin(userNmIn, userPassIn);
						if (verify == true) {
							mainPanel.setVisible(false);
							actionMenu.setVisible(false);
							new AdminScreen(frame);

						} else {
							JOptionPane.showMessageDialog(null, "Login failed. Try Again", "Invalid Credentials",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "One or more fields Empty", "Missing Information",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}
}

// else if(verify==false){JOptionPane.showMessageDialog(null,"Login failed. Try
// Again","Invalid Credentials",JOptionPane.ERROR_MESSAGE);

// * else if(verify studentLogin == true){
// * mainPanel.setVisible(false); //removing login panel
// * //add student panel to frame by doing
// * //new StudentScreen(frame); where student screen would now display all
// * necessary
// * // attributes on it's panel which it adds to the frame passed to it
// *
// * }
// removing login panel
// add staff panel to frame by doing
// new StaffScreen(frame); where staff screen would now display all necessary
// attributes on it's panel which it adds to the frame passed to it

// Staff.stfMenu();