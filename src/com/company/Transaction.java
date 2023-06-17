package com.company;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,cashwithd,fastcash,ministat,pinchange,balanceinqu,exit;
    String pinnumber;
    Transaction(String pinnumber){

        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(174,238,500,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(142,347,130,25);
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(142,377,130,25);
        fastcash.setFont(new Font("Raleway",Font.BOLD,15));
        fastcash.addActionListener(this);
        image.add(fastcash);
        pinchange=new JButton("Pin Change");
        pinchange.setFont(new Font("Raleway",Font.BOLD,15));
        pinchange.setBounds(142,407,130,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        cashwithd=new JButton("Cash Withdrawl");
        cashwithd.setBounds(310,347,150,25);
        cashwithd.setFont(new Font("Raleway",Font.BOLD,15));
        cashwithd.addActionListener(this);
        image.add(cashwithd);

        ministat=new JButton("Mini Statement");
        ministat.setBounds(310,376,150,25);
        ministat.setFont(new Font("Raleway",Font.BOLD,15));
        ministat.addActionListener(this);
        image.add(ministat);

        balanceinqu=new JButton("Balance Enquiry");
        balanceinqu.setBounds(310,404,150,25);
        balanceinqu.setFont(new Font("Raleway",Font.BOLD,15));
        balanceinqu.addActionListener(this);
        image.add( balanceinqu);

        exit=new JButton("Exit");
        exit.setBounds(310,433,150,25);
        exit.setFont(new Font("Raleway",Font.BOLD,15));
        exit.addActionListener(this);
        image.add(exit);




        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==exit){
            System.exit(0);
        }
        else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==cashwithd){
            setVisible(false);
            new  Withdrawl(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==fastcash){

            setVisible(false);
             new  FastCash(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else  if (ae.getSource()==balanceinqu){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else  if (ae.getSource()==ministat){

            new MiniStatement(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
