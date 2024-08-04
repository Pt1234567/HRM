package com.humanResourceManagement.system.Splach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran=new Random();
    int id=ran.nextInt(999999);
    JTextField firstName;
    JTextField lastName;
    JTextField emailId;
    JTextField address;
    JTextField phone;
    JTextField preferredRole;
    JTextField linkedInProfileUrl;
    JComboBox Boxeducation;
    JButton add;
    JButton back;
    public AddEmployee(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/loginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);

        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,900,700);
        add(img);

        //heading
        JLabel heading =new JLabel("Add Employee Detail");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,33));
        img.add(heading);

        //FirstName
        JLabel firstName1=new JLabel("First Name");
        firstName1.setBounds(50,150,150,30);
        firstName1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(firstName1);

        firstName=new JTextField();
        firstName.setBounds(200,150,150,30);
        firstName.setBackground(new Color(223,242,249));
        img.add(firstName);

        //LastName
        JLabel last=new JLabel("Last Name");
        last.setBounds(400,150,150,30);
        last.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(last);

        lastName=new JTextField();
        lastName.setBounds(600,150,150,30);
        lastName.setBackground(new Color(223,242,249));
        img.add(lastName);

        //Email Id
        JLabel emailId1=new JLabel("Email Id");
        emailId1.setBounds(50,200,150,30);
        emailId1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(emailId1);

        emailId=new JTextField();
        emailId.setBounds(200,200,150,30);
        emailId.setBackground(new Color(223,242,249));
        img.add(emailId);

        //Address
        JLabel address1=new JLabel("Address");
        address1.setBounds(400,200,150,30);
        address1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(address1);

        address=new JTextField();
        address.setBounds(600,200,150,30);
        address.setBackground(new Color(223,242,249));
        img.add(address);

        //Education
        JLabel education=new JLabel("Education");
        education.setBounds(50,250,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(education);

        String items []={"B.Tech","BCA","BBA","MBA","M.Tech","PHD"};
        Boxeducation=new JComboBox<>(items);
        Boxeducation.setBackground(new Color(230,242,249));
        Boxeducation.setBounds(200,250,150,30);
        img.add(Boxeducation);

        //Phone Number
        JLabel phone1=new JLabel("Phone Number");
        phone1.setBounds(400,250,150,30);
        phone1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(phone1);

        phone=new JTextField();
        phone.setBounds(600,250,150,30);
        phone.setBackground(new Color(223,242,249));
        img.add(phone);

        //LinkedIn
        JLabel url=new JLabel("LinkedIn Url");
        url.setBounds(50,300,150,30);
        url.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(url);

        linkedInProfileUrl=new JTextField();
        linkedInProfileUrl.setBounds(200,300,150,30);
        linkedInProfileUrl.setBackground(new Color(223,242,249));
        img.add(linkedInProfileUrl);

        //Role
        JLabel role=new JLabel("Preferred Role");
        role.setBounds(400,300,150,30);
        role.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(role);

        preferredRole=new JTextField();
        preferredRole.setBounds(600,300,150,30);
        preferredRole.setBackground(new Color(223,242,249));
        img.add(preferredRole);


        //add button
        add=new JButton("Add Employee");
        add.setBounds(250,400,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        img.add(add);

        //back button
        back=new JButton("Back");
        back.setBounds(450,400,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        img.add(back);

        setSize(900,700);
        setLocation(300,50);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        AddEmployee addEmployee = new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            //add in database
            String firstn=firstName.getText();
            String lastn=lastName.getText();
            String addre=address.getText();
            String email=emailId.getText();
            String number=phone.getText();
            String prefered=preferredRole.getText();
            String linkedurl=linkedInProfileUrl.getText();
            String  education=(String)Boxeducation.getSelectedItem();

             try{

                 conn connect =new conn();
                 // Create table if it doesn't exist
                 String createTableQuery = "CREATE TABLE IF NOT EXISTS employees (" +
                         "id INT PRIMARY KEY, " +
                         "first_name VARCHAR(255), " +
                         "last_name VARCHAR(255), " +
                         "email VARCHAR(255), " +
                         "address TEXT, " +
                         "phone VARCHAR(20), " +
                         "preferred_role VARCHAR(255), " +
                         "linkedin_profile_url VARCHAR(255), " +
                         "education TEXT" +
                         ");";
                 Statement statement = connect.connection.createStatement();
                 statement.executeUpdate(createTableQuery);

                 // Insert data into the table
                 String insertQuery = "INSERT INTO employees (id, first_name, last_name, email, address, phone, preferred_role, linkedin_profile_url, education) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                 PreparedStatement preparedStatement = connect.connection.prepareStatement(insertQuery);
                 preparedStatement.setInt(1, id);
                 preparedStatement.setString(2, firstn);
                 preparedStatement.setString(3, lastn);
                 preparedStatement.setString(4, email);
                 preparedStatement.setString(5, addre);
                 preparedStatement.setString(6, number);
                 preparedStatement.setString(7, prefered);
                 preparedStatement.setString(8, linkedurl);
                 preparedStatement.setString(9, education);

                 preparedStatement.executeUpdate();
                 JOptionPane.showMessageDialog(null,"Details added successfully");
                 setVisible(false);
                 //goto dashboard
                 new Main_Class();

             }catch (Exception a){
                 a.printStackTrace();
             }

        }else if(e.getSource()==back){
            new Main_Class();
        }
    }
}
