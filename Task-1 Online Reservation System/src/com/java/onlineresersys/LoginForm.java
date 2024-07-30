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

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setBounds(41, 21, 166, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 112, 61, 38);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setBounds(10, 63, 61, 38);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setBounds(81, 72, 155, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(81, 121, 155, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("Log-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
							"system");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("Select*from login_info where Username='" + textField.getText()
							+ "' and password='" + textField_1.getText().toString() + "'");
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Sucessfull!");
						dispose();
						RegistrationForm Registrationform = new RegistrationForm();
						Registrationform.setVisible(true);
					} else
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
					conn.close();
				} catch (Exception k) {
					System.out.println(k.toString());
					System.exit(ABORT);
				}
			}
		});
		btnNewButton.setBounds(23, 187, 89, 23);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sign-up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignupForm signup = new SignupForm();
				signup.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(131, 187, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnCancellation = new JButton("Cancellation");
		btnCancellation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CancellationForm cancel = new CancellationForm();
				cancel.setVisible(true);
			}
		});
		btnCancellation.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCancellation.setBounds(52, 227, 140, 23);
		contentPane.add(btnCancellation);
	}
}
