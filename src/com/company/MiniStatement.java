package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame  {
    String pinnumber;

    public  MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        this.pinnumber=pinnumber;



        JLabel mini = new JLabel();
        mini.setBounds(20,60,400,230);

        add(mini);


        JLabel bank = new JLabel("State Bank Of India");
        bank.setBounds(100,20,200,20);
        bank.setFont(new Font("Raleway",Font.BOLD,20));
       //bank.setForeground(Color.WHITE);
        add(bank);

        JLabel balance = new JLabel();
        balance.setBounds(20,200,300,20);
        add(balance);

        JLabel card = new JLabel();
        card.setBounds(30,70,300,25);
        add(card);



        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number"+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12));

            }

        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Conn conn = new Conn();
            int bal =0;
            ResultSet rs1 = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs1.next())
            {
                mini.setText(mini.getText() + "<html> " + rs1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount") + "<br><br></html>");

                if (rs1.getString("type").equals("Deposit")){

                    bal += Integer.parseInt(rs1.getString("amount"));
                }
                else {
                    bal -=Integer.parseInt(rs1.getString("amount"));
                }

            //APPEND
            }

            balance.setText("Your Current Account Balance is :"+bal );
        }catch (Exception e){
            System.out.println(e);
        }


        setSize(400,600);
        setLocation(20,20);
        setVisible(true);

    }



    public static void main(String[] args) {
        new MiniStatement("");
    }
}
