package com.humanResourceManagement.system.Splach;

import javax.swing.*;
import java.awt.*;

public class ConfirmationPage extends JFrame {

    public ConfirmationPage() {

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/loginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);

        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,600,350);
        add(img);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/check.png"));
        Image i22=i11.getImage().getScaledInstance(150,200,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image1=new JLabel(i33);
        image1.setBounds(220,10,150,200);
        img.add(image1);

        //heading
        JLabel heading=new JLabel("Your Selected Slot has been confirmed");
        heading.setBounds(50 ,210,600,50);
        heading.setFont(new Font("Raleway",Font.BOLD,27));
        img.add(heading);


        setSize(600,350);
        setLocation(480,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
       new ConfirmationPage();
    }
}
