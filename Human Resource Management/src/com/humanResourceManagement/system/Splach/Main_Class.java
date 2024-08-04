package com.humanResourceManagement.system.Splach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {

    JButton addButton;
    Main_Class(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/loginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(750,430,Image.SCALE_DEFAULT);

        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,750,430);
        add(img);

        //heading
        JLabel heading=new JLabel("Human Resource Management");
        heading.setBounds(120 ,120,600,50);
        heading.setFont(new Font("Raleway",Font.BOLD,35));
        img.add(heading);

        addButton=new JButton("Add Employee");
        addButton.setBounds(300,200,150,40);
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.black);
        addButton.addActionListener(this);
        img.add(addButton);

        setSize(750,430);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
          new Main_Class();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton){
            new AddEmployee();
            this.dispose();
        }
    }
}
