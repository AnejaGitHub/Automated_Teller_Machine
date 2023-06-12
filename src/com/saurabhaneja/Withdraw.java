package com.saurabhaneja;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    Withdraw(String pin){
        this.pin = pin;
        int x = 100;

        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
//        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Osward", Font.BOLD, 20));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(new Font("Osward", Font.BOLD, 15));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b1.setBackground(new Color(218, 210, 211));
        b2 = new JButton("BACK");
        b2.setBackground(new Color(218, 210, 211));

        l1.setBounds(100,150,400,20);
        add(l1);

        l2.setBounds(100,200,400,20);
        add(l2);

        t1.setBounds(100,280,330,30);
        add(t1);

        b1.setBounds(200,350,150,35);
        add(b1);

        b2.setBounds(200,440,150,35);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(560,580);
        setLocation(100,50);
//        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    connect c1 = new connect();

                    ResultSet rs = c1.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c1.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }

    }



    public static void main(String[] args){
        new Withdraw("").setVisible(true);
    }
}
