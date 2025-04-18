package com.saurabhaneja.operation;

import com.saurabhaneja.jdbc.connect;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;
    public PinChange(String pin){
        this.pin = pin;

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("Osward", Font.BOLD, 25));
        l1.setForeground(Color.BLACK);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("Osward", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("Osward", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 20));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 20));

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b1.setBackground(new Color(218, 210, 211));
        b2.addActionListener(this);
        b2.setBackground(new Color(218, 210, 211));

        setLayout(null);

        l1.setBounds(150,50,300,35);
        add(l1);

        l2.setBounds(80,150,150,35);
        add(l2);

        l3.setBounds(80,220,200,35);
        add(l3);

        t1.setBounds(270,150,210,30);
        add(t1);

        t2.setBounds(270,220,210,30);
        add(t2);

        b1.setBounds(330,288,150,30);
        add(b1);

        b2.setBounds(330,333,150,30);
        add(b2);

        getContentPane().setBackground(Color.WHITE);
        setSize(560,480);
        setLocation(100,50);
//        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        try{
            String npin = t1.getText();
            String rpin = t2.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }

                connect c1 = new connect();
                String q1 = "update bank set Pin = '"+rpin+"' where Pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signupthree set Pin = '"+rpin+"' where Pin = '"+pin+"' ";

                c1.statement.executeUpdate(q1);
                c1.statement.executeUpdate(q2);
                c1.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }else if(ae.getSource()==b2){
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args){
//        new PinChange("").setVisible(true);
//    }
}
