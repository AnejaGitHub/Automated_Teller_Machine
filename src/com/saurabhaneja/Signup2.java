package com.saurabhaneja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
//    Random ran = new Random();
//    long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
    JLabel religion, catagory, income, education, occupation, panNu, aadharNu, srCitizen, existingAcc;
    JComboBox religionCombo, catagoryCombo, incomeCombo, educationCombo, occupationCombo;
    JTextField panNuTF, aadharNuTF;
    JRadioButton syes, sno,eyes, eno;
    JButton back, next;
    String appNu;

    Signup2(String appNo) {
        int x1 = 110, x2 = 340;
        appNu = appNo;
        setTitle("New Account Application");

//        JLabel header = new JLabel("Page 2: Additional Details");
//        header.setFont(new Font("Osward", Font.BOLD, 30));
//        header.setBounds(200, 20, 450, 30);
//        add(header);

        JLabel page2 = new JLabel("Page 2: Additional Details");
        page2.setFont(new Font("Osward", Font.BOLD, 20));
        page2.setBounds(270, 70, 350, 30);
        add(page2);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(x1, 120, 100, 20);
        add(religion);

        String religionA[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionCombo = new JComboBox(religionA);
        religionCombo.setBackground(Color.WHITE);
        religionCombo.setFont(new Font("Arial", Font.BOLD, 15));
        religionCombo.setBounds(x2, 120, 350, 30);
        add(religionCombo);

        catagory = new JLabel("Catagory:");
        catagory.setFont(new Font("Raleway", Font.BOLD, 20));
        catagory.setBounds(x1, 170, 150, 20);
        add(catagory);

        String categoryA[] = {"General","OBC","SC","ST","Other"};//        religionCombo = new JComboBox(religionA);
        catagoryCombo = new JComboBox(categoryA);
        catagoryCombo.setBackground(Color.WHITE);
        catagoryCombo.setFont(new Font("Arial", Font.BOLD, 15));
        catagoryCombo.setBounds(x2, 170, 350, 30);
        add(catagoryCombo);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(x1, 220, 150, 20);
        add(income);

        String incomeA[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeCombo = new JComboBox(incomeA);
        incomeCombo.setBackground(Color.WHITE);
        incomeCombo.setFont(new Font("Arial", Font.BOLD, 15));
        incomeCombo.setBounds(x2, 220, 350, 30);
        add(incomeCombo);

        education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(x1, 270, 150, 20);
        add(education);

        String educationA[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationCombo = new JComboBox(educationA);
        educationCombo.setBackground(Color.WHITE);
        educationCombo.setFont(new Font("Arial", Font.BOLD, 15));
        educationCombo.setBounds(x2, 270, 350, 30);
        add(educationCombo);

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(x1, 320, 150, 20);
        add(occupation);

        String occupationA[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationCombo = new JComboBox(occupationA);
        occupationCombo.setBackground(Color.WHITE);
        occupationCombo.setFont(new Font("Arial", Font.BOLD, 15));
        occupationCombo.setBounds(x2, 320, 350, 30);
        add(occupationCombo);

        panNu = new JLabel("Pan Number:");
        panNu.setFont(new Font("Raleway", Font.BOLD, 20));
        panNu.setBounds(x1, 370, 150, 20);
        add(panNu);

        panNuTF = new JTextField(15);
        panNuTF.setFont(new Font("Arial", Font.BOLD, 15));
        panNuTF.setBounds(x2, 370, 350, 30);
        add(panNuTF);

        aadharNu = new JLabel("Adhar Number:");
        aadharNu.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNu.setBounds(x1, 420, 150, 20);
        add(aadharNu);

        aadharNuTF = new JTextField(15);
        aadharNuTF.setFont(new Font("Arial", Font.BOLD, 15));
        aadharNuTF.setBounds(x2, 420, 350, 30);
        add(aadharNuTF);

        srCitizen = new JLabel("Senior Citizen:");
        srCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        srCitizen.setBounds(x1, 470, 150, 20);
        add(srCitizen);

        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Raleway", Font.BOLD, 15));
        syes.setBackground(Color.WHITE);
        syes.setBounds(x2, 470, 100, 30);
        add(syes);
        sno = new JRadioButton("No");
        sno.setFont(new Font("Raleway", Font.BOLD, 15));
        sno.setBackground(Color.WHITE);
        sno.setBounds(x2+120, 470, 100, 30);
        add(sno);
        ButtonGroup genderGp = new ButtonGroup();
        genderGp.add(syes);
        genderGp.add(sno);

        existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAcc.setBounds(x1, 520, 200, 20);
        add(existingAcc);

        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway", Font.BOLD, 15));
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(x2, 520, 100, 30);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway", Font.BOLD, 15));
        eno.setBackground(Color.WHITE);
        eno.setBounds(x2+120, 520, 100, 30);
        add(eno);
        ButtonGroup existAccgp = new ButtonGroup();
        existAccgp.add(eyes);
        existAccgp.add(eno);

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
        String Religion = (String)religionCombo.getSelectedItem();
        String Category = (String)catagoryCombo.getSelectedItem();
        String Income = (String)incomeCombo.getSelectedItem();
        String Education = (String)educationCombo.getSelectedItem();
        String Occupation = (String)occupationCombo.getSelectedItem();

        String Pan = panNuTF.getText();
        String Aadhar = aadharNuTF.getText();

        String Scitizen = "";
        if(syes.isSelected()){
            Scitizen = "Yes";
        }
        else if(sno.isSelected()){
            Scitizen = "No";
        }

        String Existaccount = "";
        if(eyes.isSelected()){
            Existaccount = "Yes";
        }else if(eno.isSelected()){
            Existaccount = "No";
        }

        try{
            if (event.getSource() == back){
                new Signup().setVisible(true);
                setVisible(false);
            } else if (event.getSource() == next){
                if(Religion.equals("") || Category.equals("")
                        || Income.equals("") || Education.equals("")
                        || Occupation.equals("") || Pan.equals("")
                        || Aadhar.equals("") || Scitizen.equals("")
                        || Existaccount.equals("") ){

                    JOptionPane.showMessageDialog(null, "All fields are required");
                } else{
                    connect c1 = new connect();
                    String q1 = "insert into signuptwo values('"+appNu+"','"+Religion+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+Pan+"','"+Aadhar+"','"+Scitizen+"','"+Existaccount+"')";
                    c1.statement.executeUpdate(q1);

                    new Signup3(appNu).setVisible(true);
                    setVisible(false);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Signup2("");
    }
}
