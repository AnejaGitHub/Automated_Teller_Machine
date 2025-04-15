package com.saurabhaneja.operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdraw, statements, balanceEnquiry, pinChange, exit;
    String pin ;
    public Transactions(String pin) {
        this.pin = pin;
        int x1 = 50, x2 = 400, w = 250;
        setTitle("Transaction");

        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(150, 50, 450, 30);
        add(text);

        deposit = new JButton("Deposit");
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setBorderPainted(false);
        deposit.setFocusPainted(false);
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(x1, 140, w, 40);
        add(deposit);
        deposit.addActionListener(this);

        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBorderPainted(false);
        withdraw.setFocusPainted(false);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 25));
        withdraw.setBounds(x2, 140, w, 40);
        add(withdraw);
        withdraw.addActionListener(this);

        statements = new JButton("Statements");
        statements.setBackground(Color.BLACK);
        statements.setForeground(Color.WHITE);
        statements.setBorderPainted(false);
        statements.setFocusPainted(false);
        statements.setFont(new Font("Raleway", Font.BOLD, 20));
        statements.setBounds(x1, 200, w, 40);
        add(statements);
        statements.addActionListener(this);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBackground(Color.BLACK);
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.setBorderPainted(false);
        balanceEnquiry.setFocusPainted(false);
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 20));
        balanceEnquiry.setBounds(x2, 200, w, 40);
        add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);

        pinChange = new JButton("Pin Change");
        pinChange.setBackground(Color.BLACK);
        pinChange.setForeground(Color.WHITE);
        pinChange.setBorderPainted(false);
        pinChange.setFocusPainted(false);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 20));
        pinChange.setBounds(x1, 260, w, 40);
        add(pinChange);
        pinChange.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.setFont(new Font("Raleway", Font.BOLD, 20));
        exit.setBounds(x2, 450, w, 40);
        add(exit);
        exit.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(710, 550);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if(event.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pin).setVisible(true);
        } else if(event.getSource() == statements){
            setVisible(false);
            new Statements(pin).setVisible(true);
        } else if(event.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if(event.getSource() == pinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        } else if(event.getSource() == exit){
            System.exit(0);
        }

    }

//    public static void main(String[] args) {
//        new Transactions("");
//    }
}
