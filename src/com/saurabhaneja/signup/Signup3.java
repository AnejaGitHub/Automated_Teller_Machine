package com.saurabhaneja.signup;

import com.saurabhaneja.jdbc.connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener{
    JLabel accType, cardNu,pin,services;
    JButton submit,cancel;
    JRadioButton savingAcc,fdAcc,currentAcc;
    JCheckBox atmCard, internetBanking, mobileBanking, emailandsmsAlert, chequeBook;
    String appNu;

    Signup3(String appNo){
        appNu = appNo;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        int x1 = 140, x2 = 450;

        JLabel page3 = new JLabel("Page 3: Account Details");
        page3.setFont(new Font("Osward", Font.BOLD, 25));
        page3.setBounds(280, 30, 450, 40);
        add(page3
        );

        accType = new JLabel("Account Type:");
        accType.setFont(new Font("Osward", Font.BOLD, 28));
        accType.setBounds(x1, 80, 450, 40);
        add(accType);

        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        savingAcc.setBackground(Color.WHITE);
        savingAcc.setBounds(x1, 130, 150, 30);
        add(savingAcc);
        fdAcc = new JRadioButton("Fixed Deposite Account");
        fdAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        fdAcc.setBackground(Color.WHITE);
        fdAcc.setBounds(x1+170, 130, 200, 30);
        add(fdAcc);
        currentAcc = new JRadioButton("Current Account");
        currentAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        currentAcc.setBackground(Color.WHITE);
        currentAcc.setBounds(x1+380, 130, 150, 30);
        add(currentAcc);
        ButtonGroup accountGp = new ButtonGroup();
        accountGp.add(savingAcc);
        accountGp.add(fdAcc);
        accountGp.add(currentAcc);

        cardNu = new JLabel("Card No: ");
        cardNu.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNu.setBounds(x1, 180, 200, 30);
        add(cardNu);
        JLabel cardNucaption = new JLabel("Your 16 digit Card Number");
        cardNucaption.setFont(new Font("Raleway", Font.BOLD, 11));
        cardNucaption.setBounds(x1, 215, 200, 12);
        add(cardNucaption);

        JLabel cardTextField = new JLabel("XXXX XXXX XXXX 7331");
        cardTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        cardTextField.setBounds(x2, 180, 500, 30);
        add(cardTextField);

        pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(x1, 250, 200, 30);
        add(pin);
        JLabel pincaption = new JLabel("Your 4 digit password");
        pincaption.setFont(new Font("Raleway", Font.BOLD, 11));
        pincaption.setBounds(x1, 285, 200, 12);
        add(pincaption);

        JLabel pinTextField = new JLabel("XXXX");
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinTextField.setBounds(x2, 250, 300, 30);
        add(pinTextField);

        services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 28));
        services.setBounds(x1, 320, 300, 30);
        add(services);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCard.setBounds(x1, 370, 200, 30);
        add(atmCard);
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBounds(x2, 370, 350, 30);
        add(internetBanking);
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBounds(x1, 420, 200, 30);
        add(mobileBanking);
        emailandsmsAlert = new JCheckBox("Email & SMS Alerts");
        emailandsmsAlert.setBackground(Color.WHITE);
        emailandsmsAlert.setFont(new Font("Raleway", Font.BOLD, 16));
        emailandsmsAlert.setBounds(x2, 420, 350, 30);
        add(emailandsmsAlert);
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBounds(x1, 470, 200, 30);
        add(chequeBook);

        JCheckBox c7 = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 13));
        c7.setBounds(x1, 520, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.setBounds(x1+80, 570, 100, 30);
        submit.setBorderPainted(false);
        submit.setFocusPainted(false);
        add(submit);
        submit.addActionListener(this);

        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        cancel.setBounds(x2+10, 570, 100, 30);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        add(cancel);
        cancel.addActionListener(this);

        //put it in the end to render full content fast
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,670);
        setLocation(200,20);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent event){
        String atype = "";
        if(savingAcc.isSelected()){
            atype = "Saving Account";
        }
        else if(fdAcc.isSelected()){
            atype = "Fixed Deposit Account";
        }
        else if(currentAcc.isSelected()){
            atype = "Current Account";
        }
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if(atmCard.isSelected()){
            facility = facility + " ATM Card";
        }
        if(internetBanking.isSelected()){
            facility = facility + " Internet Banking";
        }
        if(mobileBanking.isSelected()){
            facility = facility + " Mobile Banking";
        }
        if(emailandsmsAlert.isSelected()){
            facility = facility + " EMAIL Alerts";
        }
        if(chequeBook.isSelected()){
            facility = facility + " Cheque Book";
        }
//        JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);

        try{
            if(event.getSource()==submit){

                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    connect c1 = new connect();
                    String q1 = "insert into signupthree values('"+appNu+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";
                    String q2 = "insert into login values('"+appNu+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);

                    //new Deposit(pin).setVisible(true);
                    setVisible(false);
                }

            }else if(event.getSource()==cancel){
                System.exit(0);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new Signup3("");
//    }
}

