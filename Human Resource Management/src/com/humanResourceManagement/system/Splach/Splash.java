package com.humanResourceManagement.system.Splach;

import com.sun.jdi.event.ThreadStartEvent;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    public Splash(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/hrm.png"));
        Image i2=i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        setSize(800,700);
        setLocation(500,50);
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
