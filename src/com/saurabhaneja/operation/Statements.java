package com.saurabhaneja.operation;

import com.saurabhaneja.jdbc.connect;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;

public class Statements extends JFrame implements ActionListener{

    JButton b1, b2;
    JLabel l1;
    String pin;
    public Statements(String pin){

        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);

        l1 = new JLabel("");

        JLabel l2 = new JLabel("Your Lovely Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        this.pin = pin;
        try{
            connect c = new connect();
            ResultSet rs = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}

        try{
            BigDecimal balance = BigDecimal.valueOf(0);
            connect c1  = new connect();
            ResultSet rs = c1.statement.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance = balance.add(rs.getBigDecimal("Amount"));
                }else{
                    balance = balance.subtract(rs.getBigDecimal("Amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);

        l1.setPreferredSize(new Dimension(700,700));
        JScrollPane pane = new JScrollPane(l1);
        pane.setPreferredSize(new Dimension(550, 550));
        JOptionPane.showMessageDialog(null, pane, "All transactions", JOptionPane.INFORMATION_MESSAGE);
        l1.setBounds(20, 140, 400, 200);
        add(l1);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new Transactions(pin).setVisible(true);
    }

//    public static void main(String[] args){
//        new Statements("").setVisible(true);
//    }

}
