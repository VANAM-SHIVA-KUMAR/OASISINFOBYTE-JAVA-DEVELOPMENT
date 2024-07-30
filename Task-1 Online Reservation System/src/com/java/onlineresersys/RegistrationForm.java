package com.java.onlineresersys;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textemail;
	private JTextField textmnumber;
	private JTextField textDoB;
	private JTextField date;
	private JTextField TrainNumber;
	private JTextField TrainName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 25, 403, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 65, 86, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(20, 99, 86, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mobile Number");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(20, 133, 86, 23);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Date-of-Birth");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(20, 167, 86, 23);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Gender");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(20, 202, 86, 23);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Departure Station");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(20, 236, 86, 23);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Arraival Station");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(20, 270, 86, 23);
		contentPane.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_7 = new JLabel("Date");
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_7.setBounds(20, 304, 86, 23);
		contentPane.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8 = new JLabel("Class");
		lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_8.setBounds(20, 338, 86, 23);
		contentPane.add(lblNewLabel_1_8);

		textname = new JTextField();
		textname.setToolTipText("John wick");
		textname.setBounds(143, 66, 249, 20);
		contentPane.add(textname);
		textname.setColumns(10);

		textemail = new JTextField();
		textemail.setToolTipText("example@gmail.com");
		textemail.setColumns(10);
		textemail.setBounds(143, 100, 249, 20);
		contentPane.add(textemail);

		textmnumber = new JTextField();
		textmnumber.setColumns(10);
		textmnumber.setBounds(143, 134, 249, 20);
		contentPane.add(textmnumber);

		textDoB = new JTextField();
		textDoB.setColumns(10);
		textDoB.setBounds(143, 168, 249, 20);
		textDoB.setToolTipText("yyyy/mm/dd");
		contentPane.add(textDoB);

		JComboBox comboBoxgender = new JComboBox();
		comboBoxgender.setBounds(143, 202, 249, 22);
		contentPane.add(comboBoxgender);
		comboBoxgender.addItem("Male");
		comboBoxgender.addItem("Female");
		comboBoxgender.addItem("Non-binary");

		JComboBox comboBoxgenderD = new JComboBox();
		comboBoxgenderD.setBounds(143, 236, 249, 22);
		contentPane.add(comboBoxgenderD);
		comboBoxgenderD.addItem("Mumbai");
		comboBoxgenderD.addItem("Delhi");
		comboBoxgenderD.addItem("Kolkata");
		comboBoxgenderD.addItem("Chandigarh");

		JComboBox comboBoxgenderA = new JComboBox();
		comboBoxgenderA.setBounds(143, 270, 249, 22);
		contentPane.add(comboBoxgenderA);
		comboBoxgenderA.addItem("Hyderabad");
		comboBoxgenderA.addItem("Chennai");
		comboBoxgenderA.addItem("Bengaluru");
		comboBoxgenderA.addItem("Pune");

		JRadioButton A = new JRadioButton("A");
		A.setBounds(143, 338, 40, 23);
		contentPane.add(A);

		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(212, 338, 40, 23);
		contentPane.add(rdbtnB);

		JRadioButton A_1_1 = new JRadioButton("C");
		A_1_1.setBounds(297, 338, 40, 23);
		contentPane.add(A_1_1);

		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
							"system");
					PreparedStatement pstmt = conn.prepareStatement(
							"INSERT INTO users (name, email, mobile_number, date_of_birth, gender, departure_station, arrival_station,date,class, pnr_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
					pstmt.setString(1, textname.getText());
					pstmt.setString(2, textemail.getText());
					pstmt.setString(3, textmnumber.getText());
					pstmt.setString(4, textDoB.getText());
					pstmt.setString(5, comboBoxgender.getSelectedItem().toString());
					pstmt.setString(6, comboBoxgenderD.getSelectedItem().toString());
					pstmt.setString(7, comboBoxgenderA.getSelectedItem().toString());
					pstmt.setString(8, date.getText());
					if (A.isSelected()) {
						pstmt.setString(9, "A");
					} else if (rdbtnB.isSelected()) {
						pstmt.setString(9, "B");
					} else if (A_1_1.isSelected()) {
						pstmt.setString(9, "C");
					}
					// Generate a random PNR number
					Random rand = new Random();
					int pnrNumber = rand.nextInt(900000) + 100000;
					pstmt.setString(10, Integer.toString(pnrNumber));
					int rowsInserted = pstmt.executeUpdate();
					if (rowsInserted > 0) {
						dispose();
						JOptionPane.showMessageDialog(null, "User registered successfully! PNR number: " + pnrNumber);
					}
					pstmt.close();
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}
		});

		Register.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Register.setBounds(187, 487, 89, 23);
		contentPane.add(Register);

		date = new JTextField();
		date.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		date.setBounds(143, 305, 249, 20);
		contentPane.add(date);
		date.setColumns(10);
		date.setToolTipText("yyyy/mm/dd");

		JLabel lblNewLabel_1_8_1 = new JLabel("Train Number");
		lblNewLabel_1_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_8_1.setBounds(20, 372, 86, 23);
		contentPane.add(lblNewLabel_1_8_1);

		JLabel lblNewLabel_1_8_1_1 = new JLabel("Train Name");
		lblNewLabel_1_8_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_8_1_1.setBounds(20, 406, 86, 23);
		contentPane.add(lblNewLabel_1_8_1_1);

		TrainNumber = new JTextField();
		TrainNumber.setToolTipText("");
		TrainNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		TrainNumber.setColumns(10);
		TrainNumber.setBounds(143, 368, 249, 20);
		contentPane.add(TrainNumber);
		TrainNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
							"system");
					PreparedStatement pstmt = conn
							.prepareStatement("SELECT train_name FROM train WHERE train_number = ?");
					pstmt.setString(1, TrainNumber.getText());
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						TrainName.setText(rs.getString("train_name"));
					} else {
						TrainName.setText("");
					}
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		TrainName = new JTextField();
		TrainName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		TrainName.setColumns(10);
		TrainName.setBounds(143, 407, 249, 20);
		contentPane.add(TrainName);
	}
}
