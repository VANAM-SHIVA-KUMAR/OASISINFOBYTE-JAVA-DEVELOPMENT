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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class CancellationForm extends JFrame {

	private JPanel contentPane;
	private JTextField pnrNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancellationForm frame = new CancellationForm();
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
	public CancellationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("PNR Number");
		lblNewLabel_1.setBounds(30, 54, 66, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Cancellation Form");
		lblNewLabel.setBounds(153, 11, 132, 21);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JTextPane infotext = new JTextPane();
		infotext.setBounds(153, 100, 223, 272);
		contentPane.add(infotext);

		pnrNumber = new JTextField();
		pnrNumber.setBounds(153, 51, 145, 20);
		contentPane.add(pnrNumber);
		pnrNumber.setColumns(10);
		pnrNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
							"system");
					String pnrNumberT = pnrNumber.getText();
					String query = "SELECT * FROM users WHERE pnr_number = ?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, pnrNumberT);
					ResultSet rs = pstmt.executeQuery();

					if (rs.next()) {
						String name = rs.getString("name");
						String email = rs.getString("email");
						String mobileNumber = rs.getString("mobile_number");
						String dateOfBirth = rs.getString("date_of_birth");
						String gender = rs.getString("gender");
						String departureStation = rs.getString("departure_station");
						String arrivalStation = rs.getString("arrival_station");
						String date = rs.getString("date");
						String travelClass = rs.getString("class");

//						infoString.setContentType("text/html");
//						String infoString = "<html>Name: %s<br>Email: %s<br>Mobile Number: %s<br>Date of Birth: %s<br>Gender: %s<br>Departure Station: %s<br>Arrival Station: %s<br>Date: %s<br>Class: %s";
//						infoString = String.format(infoString, name, email, mobileNumber, dateOfBirth, gender,
//								departureStation, arrivalStation, date, travelClass);
//						JTextPane textFi = new JTextPane();

						infotext.setContentType("text/html");
						String formattedText = String.format(
								"<html>Name: %s<br>Email: %s<br>Mobile Number: %s<br>Date of Birth: %s<br>Gender: %s<br>Departure Station: %s<br>Arrival Station: %s<br>Date: %s<br>Class: %s</html>",
								name, email, mobileNumber, dateOfBirth, gender, departureStation, arrivalStation, date,
								travelClass);
						infotext.setText(formattedText);

					} else {
						infotext.setText("No information found for PNR number " + pnrNumber.getText());
					}

					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});

		JLabel lblNewLabel_2 = new JLabel("Details");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(30, 100, 46, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Confirm Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
							"system");
					String pnrNumberT = pnrNumber.getText();
					String query = "DELETE FROM users WHERE pnr_number = ?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, pnrNumberT);
					int rowsDeleted = pstmt.executeUpdate();

					if (rowsDeleted > 0) {
						JOptionPane.showMessageDialog(null,
								"Booking for PNR number " + pnrNumber + " has been cancelled.");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No booking found for PNR number " + pnrNumber.getText());
					}

					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(174, 406, 124, 23);
		contentPane.add(btnNewButton);

	}
}
