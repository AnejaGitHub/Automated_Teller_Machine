package com.saurabhaneja.signup;
// Personal Details
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.saurabhaneja.login.Login;
import com.saurabhaneja.jdbc.connect;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame  implements ActionListener {

    Random ran = new Random();
    long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
    JLabel name, fName, DOB, gender, email, marital, address, city, state, pinCode;
    JTextField nameTF, fNameTF, emailTF, addressTF, cityTF, stateTF, pincodeTF;
    JRadioButton male, female, gOther, married, unmarried, mOther;
    JButton back,next;
    JDateChooser date;

    public Signup() {
        int x1 = 120, x2 = 320;

        setTitle("New Account Application");

        JLabel header = new JLabel("Application No. " + random );
        header.setFont(new Font("Osward", Font.BOLD, 40));
        header.setBounds(200, 20, 450, 40);
        add(header);

        JLabel page1 = new JLabel("Page 1: Personal Details");
        page1.setFont(new Font("Osward", Font.BOLD, 20));
        page1.setBounds(270, 70, 350, 30);
        add(page1);

        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(x1, 120, 100, 20);
        add(name);

        nameTF = new JTextField(15);
        nameTF.setFont(new Font("Arial", Font.BOLD, 15));
        nameTF.setBounds(x2, 120, 350, 30);
        add(nameTF);

        fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(x1, 170, 150, 20);
        add(fName);

        fNameTF = new JTextField(15);
        fNameTF.setFont(new Font("Arial", Font.BOLD, 15));
        fNameTF.setBounds(x2, 170, 350, 30);
        add(fNameTF);

        DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(x1, 220, 150, 20);
        add(DOB);

        date = new JDateChooser();
        date.setBounds(x2, 220, 350, 30);
        add(date);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(x1, 270, 150, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        male.setBackground(Color.WHITE);
        male.setBounds(x2, 270, 100, 30);
        add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        female.setBackground(Color.WHITE);
        female.setBounds(x2+120, 270, 100, 30);
        add(female);
        gOther = new JRadioButton("Other");
        gOther.setFont(new Font("Raleway", Font.BOLD, 15));
        gOther.setBackground(Color.WHITE);
        gOther.setBounds(x2+240, 270, 100, 30);
        add(gOther);
        ButtonGroup genderGp = new ButtonGroup();
        genderGp.add(male);
        genderGp.add(female);
        genderGp.add(gOther);

        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(x1, 320, 150, 20);
        add(email);

        emailTF = new JTextField(15);
        emailTF.setFont(new Font("Arial", Font.BOLD, 15));
        emailTF.setBounds(x2, 320, 350, 30);
        add(emailTF);

        marital = new JLabel("Marital Status");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(x1, 370, 150, 20);
        add(marital);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 15));
        married.setBackground(Color.WHITE);
        married.setBounds(x2, 370, 100, 30);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(x2+120, 370, 100, 30);
        add(unmarried);
        mOther = new JRadioButton("Other");
        mOther.setFont(new Font("Raleway", Font.BOLD, 15));
        mOther.setBackground(Color.WHITE);
        mOther.setBounds(x2+240, 370, 100, 30);
        add(mOther);
        ButtonGroup maritalGp = new ButtonGroup();
        maritalGp.add(married);
        maritalGp.add(unmarried);
        maritalGp.add(mOther);

        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(x1, 420, 150, 20);
        add(address);

        addressTF = new JTextField(15);
        addressTF.setFont(new Font("Arial", Font.BOLD, 15));
        addressTF.setBounds(x2, 420, 350, 30);
        add(addressTF);

        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(x1, 470, 150, 20);
        add(city);

        cityTF = new JTextField(15);
        cityTF.setFont(new Font("Arial", Font.BOLD, 15));
        cityTF.setBounds(x2, 470, 350, 30);
        add(cityTF);

        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(x1, 520, 150, 20);
        add(state);

        stateTF = new JTextField(15);
        stateTF.setFont(new Font("Arial", Font.BOLD, 15));
        stateTF.setBounds(x2, 520, 350, 30);
        add(stateTF);

        pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(x1, 570, 150, 20);
        add(pinCode);

        pincodeTF = new JTextField(15);
        pincodeTF.setFont(new Font("Arial", Font.BOLD, 15));
        pincodeTF.setBounds(x2, 570, 350, 30);
        add(pincodeTF);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.setBounds(x1, 620, 75, 30);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        add(back);
        back.addActionListener(this);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 15));
        next.setBounds(x2+275, 620, 75, 30);
        next.setBorderPainted(false);
        next.setFocusPainted(false);
        add(next);
        next.addActionListener(this);

        //put it in the end to render full content fast
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(770,720);
        setLocation(200,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String appno = "" + random;
        String Name = nameTF.getText();
        String FName = fNameTF.getText();
        String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
        // Convert "Mar 22, 2000" to "2000-03-22"
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");  // Input format
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");   // MySQL format
        String Gender = "";
        if(male.isSelected()){
            Gender = "Male";
        } else if(female.isSelected()){
            Gender = "Female";
        } else if(gOther.isSelected()){
            Gender = "Other";
        }
        String Email = emailTF.getText();
        String Marital = "";
        if(married.isSelected()){
            Marital = "Married";
        } else if(unmarried.isSelected()){
            Marital = "Single";  // ✅ Match ENUM value
        } else if(mOther.isSelected()){
            Marital = "Divorced";  // ✅ Match ENUM value
        }

        String Address = addressTF.getText();
        String City = cityTF.getText();
        String State = stateTF.getText();
        String PinCode = pincodeTF.getText();

        try{
            Date parsedDate = inputFormat.parse(dob);  // Convert to Date object
            dob = outputFormat.format(parsedDate);
            if (event.getSource() == back){
                new Login().setVisible(true);
                setVisible(false);
            } else if (event.getSource() == next){
                if(Name.equals("") || FName.equals("")
                        || dob.equals("") || Gender.equals("")
                        || Email.equals("") || Marital.equals("")
                        || Address.equals("") || City.equals("")
                        || State.equals("") || PinCode.equals("") ){

                    JOptionPane.showMessageDialog(null, "All fields are required");
                } else{
                    connect c1 = new connect();
                    String q1 = "insert into personaldetails values('"+appno+"','"+Name+"','"+FName+"','"+dob+"','"+Gender+"','"+Email+"','"+Marital+"','"+Address+"','"+City+"','"+State+"','"+PinCode+"')";
                    c1.statement.executeUpdate(q1);

                    new Signup2(appno).setVisible(true);
                    setVisible(false);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
//    public static void main(String[] args) {
//        new Signup();
//    }
}
