package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    String pinnumber;

    public Deposit(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(800,760,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);

        JLabel text = new JLabel("Enter The Amount You Want To Deposit");
        text.setBounds(155,250,450,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(195,290,200,25);
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(310,404,150,25);
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);


        back=new JButton("Back");
        back.setBounds(310,433,150,25);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);

        setSize(800,750);
        setLocation(300,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==deposit){
        String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount");
            }
            else {
                try {
                    Conn conn= new Conn();
                    String query ="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposit Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }

            }

        }
        else if (ae.getSource()==back){
            setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
