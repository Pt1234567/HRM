package com.humanResourceManagement.system.Splach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tUserName;
    JPasswordField passwordField;

    JButton login,back;
    Login(){

        //JFrame is used for displaying images on frame
        JLabel userName=new JLabel("UserName");
        userName.setBounds(40,20,100,30);
        add(userName);

        tUserName=new JTextField();
        tUserName.setBounds(150,20,150,30);
        add(tUserName);

        JLabel passWord=new JLabel("PassWord");
        passWord.setBounds(40,70,100,30);
        add(passWord);

        passwordField=new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        add(passwordField);

        login=new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back=new JButton("Back");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));
        Image i22=i11.getImage().getScaledInstance(150,200,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image1=new JLabel(i33);
        image1.setBounds(370,20,150,200);
        add(image1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/loginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,600,300);
        add(image);

        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){

            try{

                String username=tUserName.getText();
                String password=passwordField.getText();

                conn connect=new conn();

                String query="select * from users where username='"+username+"' and password='"+password+"'";
                ResultSet resultSet=connect.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_Class();
                }else{
                   JOptionPane.showMessageDialog(null,"Invalid  username or password");
                }

            }catch (Exception a){
                a.printStackTrace();
            }

        }else if(e.getSource()==back){
            System.exit(90);
        }
    }
}
