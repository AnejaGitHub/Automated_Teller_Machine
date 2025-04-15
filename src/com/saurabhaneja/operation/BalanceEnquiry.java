package com.saurabhaneja.operation;

import com.saurabhaneja.jdbc.connect;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    public BalanceEnquiry(String pin) {
        this.pin = pin;

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l3 = new JLabel(i3);
//        l3.setBounds(0, 0, 960, 1080);
//        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Osward", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(100, 100, 400, 35);
        add(l1);

        b1.setBounds(190, 200, 150, 35);
        add(b1);
        int balance = 0;
        try {
            connect c1 = new connect(); // Assuming this is your DB connection class

            // ✅ Secure Query Using PreparedStatement
            String query = "SELECT Type, Amount FROM bank WHERE Pin = ?";
            PreparedStatement pstmt = c1.connection.prepareStatement(query);
            pstmt.setString(1, pin);
            ResultSet rs = pstmt.executeQuery();

            // ✅ Correctly Fetching Balance
            while (rs.next()) {
                String type = rs.getString("Type");
                BigDecimal amount = rs.getBigDecimal("Amount"); // Using correct data type

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount.intValueExact(); // Correct conversion
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    balance -= amount.intValueExact();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching balance: " + e);
        }

        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(560,580);
        setLocation(100,50);
//        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

//    public static void main(String[] args) {
//        new BalanceEnquiry("").setVisible(true);
//    }
}
