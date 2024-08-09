package com.humanResourceManagement.system.Splach;

import com.sun.jdi.event.ThreadStartEvent;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    public Splash(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,500);
        add(image);

        setSize(700,500);
        setLocation(480,150);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(3000);
            setVisible(false);
            new SignUp();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Splash splash = new Splash();
    }

}
