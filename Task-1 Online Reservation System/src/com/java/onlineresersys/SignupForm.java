package com.java.onlineresersys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SignupForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textnewpass;
	private JTextField textuser_1;
	private JTextField textemail;
	private JTextField textconpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupForm frame = new SignupForm();
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
	public SignupForm() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign-up Page");
		lblNewLabel.setBounds(74, 21, 166, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);

		JLabel pass = new JLabel("<html>New<br>Password</html>");
		pass.setBounds(10, 134, 61, 29);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(pass);

		JLabel user = new JLabel("User Name");
		user.setBounds(10, 63, 61, 29);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(user);

		textuser_1 = new JTextField();
		textuser_1.setBounds(81, 67, 159, 20);
		textuser_1.setColumns(10);
		contentPane.add(textuser_1);

		JLabel email = new JLabel("E-mail");
		email.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		email.setBounds(10, 94, 61, 40);
		contentPane.add(email);

		textnewpass = new JTextField();
		textnewpass.setColumns(10);
		textnewpass.setBounds(81, 138, 159, 20);
		contentPane.add(textnewpass);

		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(81, 104, 159, 20);
		contentPane.add(textemail);

		JLabel copass = new JLabel("<html>Confirm<br>Password</html>");
		copass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		copass.setBounds(10, 159, 61, 40);
		contentPane.add(copass);

		textconpass = new JTextField();
		textconpass.setColumns(10);
		textconpass.setBounds(81, 169, 159, 20);
		contentPane.add(textconpass);

		JButton signup_1 = new JButton("Create Account");
		signup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textuser_1.getText();
				String email = textemail.getText();
				String password = textnewpass.getText();
				String confirmPassword = textconpass.getText();

				if (username.equals("") || password.equals("") || confirmPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter all fields");
				} else if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null, "Passwords do not match");
				} else {
					try {
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
								"system");
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM login_info WHERE Username='" + username + "'");
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Username already exists");
						} else {
							String sql = "INSERT INTO login_info (Username, password, email) VALUES ('" + username
									+ "', '" + password + "', '" + email + "')";
							int rowsInserted = stmt.executeUpdate(sql);
							if (rowsInserted == 1) {
								JOptionPane.showMessageDialog(null, "Account Creation successful!");
								dispose();
								LoginForm login = new LoginForm();
								login.setVisible(true);
							}
						}
						conn.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		signup_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		signup_1.setBounds(81, 210, 159, 23);
		contentPane.add(signup_1);

	}
}
