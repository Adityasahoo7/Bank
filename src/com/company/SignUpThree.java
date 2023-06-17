package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import  java.awt.event.*;

public class SignUpThree extends JFrame implements ActionListener{


    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit , cancel;
    String formno;
    SignUpThree(String formno){

        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page :3 Account Details");
        l1.setBounds(210,50,600,40);
        l1.setFont(new Font("Raleway",Font.BOLD,30));
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setBounds(120,120,250,30);
        type.setFont(new Font("Raleway",Font.BOLD,20));
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setBounds(130,160,200,20);
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        add(r1);

        r2 =new JRadioButton("Fixed Deposite Account");
        r2.setBounds(390,160,300,20);
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        add(r2);

        r3 =new JRadioButton("Current Account");
        r3.setBounds(130,200,250,20);
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        add(r3);

        r4=new JRadioButton("Recurring Deposite Account");
        r4.setBounds(390,200,300,20);
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        add(r4);
        ButtonGroup accounttype = new ButtonGroup();
        accounttype.add(r1);
        accounttype.add(r2);
        accounttype.add(r3);
        accounttype.add(r4);


        JLabel cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(120,250,200,30);
        add(cardno);
        JLabel carddetail =new JLabel("Your 16 Digit Card Number");
        carddetail.setBounds(120,280,250,20);
        carddetail.setFont(new Font("Raleway",Font.BOLD,9));
        add(carddetail);

        JLabel cardnogenerate = new JLabel("XXXX-XXXX-XXXX-6260");
        cardnogenerate.setFont(new Font("Raleway",Font.BOLD,20));
        cardnogenerate.setBounds(340,250,400,30);
        add(cardnogenerate);


        JLabel pin= new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(120,320,100,30);
        add(pin);

        JLabel pindetail = new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,9));
        pindetail.setBounds(120,350,200,20);
        add(pindetail);


        JLabel pinno = new JLabel("XXXX");
        pinno.setBounds(340,320,300,30);
        pinno.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinno);

        JLabel service = new JLabel("Service Required");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(120,390,250,30);
        add(service);

        c1= new JCheckBox("ATM CARD");
        setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(140,430,160,30);
        add(c1);

        c2= new JCheckBox("Internet Banking");
        setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(300,430,200,30);
        add(c2);

        c3= new JCheckBox("Mobile Banking");
        setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(140,470,160,30);
        add(c3);

        c4= new JCheckBox("SMS Alerts");
        setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(300,470,200,30);
        add(c4);

        c5= new JCheckBox("Check Book");
        setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(140,510,160,30);
        add(c5);

        c6= new JCheckBox("E-Statement");
        setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(300,510,200,30);
        add(c6);

        c7= new JCheckBox("I hereby declares that the above entred details are correct to the best off my knowledge");
        setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,13));
        c7.setBounds(120,570,700,30);
        add(c7);

        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setBounds(250,630,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setBounds(440,630,100,30);
        cancel.addActionListener(this);
        add(cancel);










        setSize(850,820);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==submit){
            String accounttype= null;
                if (r1.isSelected()){
                    accounttype="Saving Account";
                }
                else if (r2.isSelected()){
                    accounttype="Fixed Deposit Account";
                }
                else if(r3.isSelected()){
                    accounttype="Current Account";
                }
                else if(r4.isSelected()){
                    accounttype="Recuring Deposit Account";

                }
                Random random = new Random();
                String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)) + 50406260L;

                String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L) ;
                String facility ="";
                if (c1.isSelected()){
                    facility="Atm Card";
                }
                else  if (c2.isSelected()){
                    facility="Internet Banking";
                }
                else if (c3.isSelected()){
                    facility="Mobile Banking";
                }
                else if (c4.isSelected()){
                    facility="SMS Alerts";
                }
                else if (c5.isSelected()){
                        facility="Check Book";
                    }
                else if (c6.isSelected()){
                    facility="E-Statement";
                }




            try {

                if (accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                else {
                    Conn conn = new Conn();
                    String query = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"'    )" ;
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+ cardnumber + "\n Pin: "+ pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);



                }

            }catch (Exception e){
                System.out.println(e);
            }



        }
        else if (ae.getSource() ==cancel ){
            setVisible(false);
            new Login().setVisible(true);
        }

    }

    public static void main (String args[]){
        new SignUpThree("");

    }
}
