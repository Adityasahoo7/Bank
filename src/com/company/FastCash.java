package com.company;


import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import  java.awt.event.*;
import java.sql.ResultSet;
import  java.util.Date;
import java.sql.SQLOutput;

public class FastCash extends  JFrame implements ActionListener{
    JButton hundred,fivehund,thousand,twothou,fivethou,tenthou,back;
    String pinnumber;
    public FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(174,238,500,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        hundred=new JButton("Rs 100");
        hundred.setBounds(142,347,130,25);
        hundred.setFont(new Font("Raleway",Font.BOLD,15));
        hundred.addActionListener(this);
        image.add(hundred);
        fivehund=new JButton("Rs 500");
        fivehund.setBounds(142,377,130,25);
        fivehund.setFont(new Font("Raleway",Font.BOLD,15));
        fivehund.addActionListener(this);
        image.add(fivehund);
        thousand=new JButton("Rs 1000");
        thousand.setFont(new Font("Raleway",Font.BOLD,15));
        thousand.setBounds(142,407,130,25);
        thousand.addActionListener(this);
        image.add(thousand);

        twothou=new JButton("Rs 2000");
        twothou.setBounds(310,347,150,25);
        twothou.setFont(new Font("Raleway",Font.BOLD,15));
        twothou.addActionListener(this);
        image.add(twothou);

        fivethou=new JButton("Rs 5000");
        fivethou.setBounds(310,376,150,25);
        fivethou.setFont(new Font("Raleway",Font.BOLD,15));
        fivethou.addActionListener(this);
        image.add(fivethou);

        tenthou=new JButton("Rs 10000");
        tenthou.setBounds(310,404,150,25);
        tenthou.setFont(new Font("Raleway",Font.BOLD,15));
        tenthou.addActionListener(this);
        image.add( tenthou);

        back=new JButton("BACK");
        back.setBounds(310,433,150,25);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);




        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);




    }


    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else {
            String amount =((JButton)ae.getSource()).getText().substring(3);

                Conn conn= new Conn();
                try {

                    ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance=0 ;
                    while (rs.next()){

                        if (rs.getString("type").equals("Deposit")){

                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else {
                            balance -=Integer.parseInt(rs.getString("amount"));
                        }
                        if (ae.getSource()!=back && balance < Integer.parseInt(rs.getString("amount"))){
                            JOptionPane.showMessageDialog(null,"Insufficient balance");
                            return;


                        }
                        Date date=new Date();
                        String query = "Insert into bank values ('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);

                    }
                }catch (Exception e ) {
                    System.out.println(e);
                }




        }

        }


    public static void main(String[] args) {
        new FastCash("");
    }

}
