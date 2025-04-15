package com.saurabhaneja.login;

import com.saurabhaneja.operation.Transactions;
import com.saurabhaneja.jdbc.connect;
import com.saurabhaneja.signup.Signup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel text, cardNo, pin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton signin, clear, signup;

    public Login() {
        setTitle("Developer Bank");



//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l11 = new JLabel(i3);
//        l11.setBounds(70, 10, 100, 100);
//        add(l11);

        text = new JLabel("Welcome To Bank");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 450, 40);
        add(text);

        cardNo = new JLabel("Card No: ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(125, 150, 375, 30);
        add(cardNo);

        cardTextField = new JTextField(15);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
        cardTextField.setBounds(300, 150, 230, 30);
        add(cardTextField);

        pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125, 220, 375, 30);
        add(pin);

        pinTextField = new JPasswordField(15);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 15));
        pinTextField.setBounds(300, 220, 230, 30);
        add(pinTextField);

        signin = new JButton("Sign IN");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("Arial", Font.BOLD, 15));
        signin.setBounds(300, 300, 100, 30);
        signin.setBorderPainted(false);
        signin.setFocusPainted(false);
        add(signin);
        signin.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.setBounds(430, 300, 100, 30);
        clear.setBorderPainted(false);
        clear.setFocusPainted(false);
        add(clear);
        clear.addActionListener(this);

        signup = new JButton("Sign Up");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Arial", Font.BOLD, 15));
        signup.setBounds(300, 350, 230, 30);
        signup.setBorderPainted(false);
        signup.setFocusPainted(false);
        add(signup);
        signup.addActionListener(this);


        //put it in the end to render full content fast
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,480);
        setLocation(250,100);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource() == signin){
                connect c1 = new connect();
                if (c1.statement == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed!");
                    return;
                }
                String Cardno  = cardTextField.getText();
                String Pin  = pinTextField.getText();
                String q  = "select * from login where cardno = '"+Cardno+"' and pin = '"+Pin+"'";

                ResultSet rs = c1.statement.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(Pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } else if (event.getSource() == clear){
                cardTextField.setText("");
                pinTextField.setText("");
            } else if (event.getSource() == signup){
//                setVisible(false);
                new Signup().setVisible(true); // personal details
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new Login();
//    }
}
