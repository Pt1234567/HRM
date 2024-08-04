package com.humanResourceManagement.system.Splach;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    // Swing components
     JLabel labelUser, labelPassword;
     JTextField textUser;
     JPasswordField textPassword;
    JButton btnLogin;
    JButton btnSignUp;
    Random ran=new Random();
    int id= ran.nextInt(999999);

    public SignUp() {
// Add background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);

// Set up the frame
        JLabel heading = new JLabel("Sign Up");
        heading.setBounds(200, 20, 200, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 28));
        img.add(heading);

// Create components
        JLabel labelUser = new JLabel("Username/Email:");
        labelUser.setBounds(100, 100, 150, 30);
        labelUser.setFont(new Font("SansSerif", Font.BOLD, 18));
        img.add(labelUser);

         textUser = new JTextField();
        textUser.setBounds(260, 100, 200, 30);
        textUser.setBackground(new Color(223, 242, 249));
        img.add(textUser);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(100, 150, 150, 30);
        labelPassword.setFont(new Font("SansSerif", Font.BOLD, 18));
        img.add(labelPassword);

         textPassword = new JPasswordField();
        textPassword.setBounds(260, 150, 200, 30);
        textPassword.setBackground(new Color(223, 242, 249));
        img.add(textPassword);

        // Create buttons
         btnSignUp = new JButton("Sign Up");
        btnSignUp.setBackground(Color.black);
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBounds(180, 200, 100, 30);
        btnSignUp.addActionListener(this);
        img.add(btnSignUp);

         btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.black);
        btnLogin.setForeground(Color.white);
        btnLogin.setBounds(320, 200, 100, 30);
        btnLogin.addActionListener(this);
        img.add(btnLogin);

// Set frame properties
        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get user input
        String username = textUser.getText();
        String password = new String(textPassword.getPassword());

        // Save data to database
        if(e.getSource()==btnSignUp)saveToDatabase(username, password);
        else if(e.getSource()==btnLogin)new Login();
    }

    private void saveToDatabase(String username, String password) {

        try {
            conn connect = new conn();

            // Ensure the users table exists
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(255) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL" +
                    ");";
            connect.statement.executeUpdate(createTableQuery);

            // Check if the username already exists
            String checkUserQuery = "SELECT COUNT(*) FROM users WHERE username = ?";
            PreparedStatement checkStmt = connect.connection.prepareStatement(checkUserQuery);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                // User already exists
                JOptionPane.showMessageDialog(null, "User is already registered. Please log in.");
            } else {
                // Insert new user into the table
                String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
                PreparedStatement insertStmt = connect.connection.prepareStatement(insertUserQuery);
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "User registered successfully. You can now log in.");
                new Login();
                this.dispose(); // Close the current window
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SignUp();
    }
}

