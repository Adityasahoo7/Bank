package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    public BalanceEnquiry(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(800,760,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);

        back=new JButton("Back");
        back.setBounds(360,433,100,25);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);

        Conn conn= new Conn();
        int balance=0 ;
        try {

            ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");

            while (rs.next()) {

                if (rs.getString("type").equals("Deposit")) {

                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current Account Balance ");
        text.setBounds(150,238,500,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(text);
        JLabel text1 = new JLabel("Rs : "+balance );
        text1.setBounds(170,270,500,25);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(text1);

        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
       new  BalanceEnquiry("");
    }
}
