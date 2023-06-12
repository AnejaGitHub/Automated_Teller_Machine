package com.saurabhaneja;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    Deposit(String pin){
        this.pin = pin;

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Osward", Font.BOLD, 20));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 20));

        b1 = new JButton("DEPOSIT");
        b1.setBackground(new Color(218, 210, 211));
        b2 = new JButton("BACK");
        b2.setBackground(new Color(218, 210, 211));

        setLayout(null);

        l1.setBounds(70,50,450,35);
        add(l1);

        t1.setBounds(100,130,350,30);
        add(t1);

        b1.setBounds(200,220,150,35);
        add(b1);

        b2.setBounds(200,270,150,35);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(550,450);
        setLocation(200,50);
//        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    connect c1 = new connect();
                    c1.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
