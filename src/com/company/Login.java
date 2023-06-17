package com.company;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField ctf;
    JPasswordField ptf;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl= new JLabel(i3);
        jl.setBounds(100,30,90,90);
        add(jl);


        JLabel text = new JLabel("WELCOME TO ATM ");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,60,400,40);
        add(text);


        JLabel cardno = new JLabel("CARD NO : ");
        cardno.setFont(new Font("Osward",Font.BOLD,27));
        cardno.setBounds(140,170,160,40);
        add(cardno);

        ctf =new JTextField();
        ctf.setBounds(320,180,250,30);
        ctf.setFont(new Font("Arial",Font.BOLD,15));
        add(ctf);


        JLabel pin = new JLabel("PIN NO : ");
        pin.setFont(new Font("Osward",Font.BOLD,27 ));
        pin.setBounds(140,240,160,40);
        add(pin);


        ptf =new JPasswordField();
        ptf.setBounds(320,250,250,30);
        ptf.setFont(new Font("Arial",Font.BOLD,15));
        add(ptf);

        login = new JButton("SIGN IN");
        login.setBounds(320,325,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(460,325,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


         signup = new JButton("SIGN UP");
        signup.setBounds(390,380,100,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(ColorUIResource.white);

        setSize(850,500);
        setVisible(true);
        setLocation(300,130);



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){

           Conn conn=new Conn();
           String cardnumber=ctf.getText();
           String pinnumber=ptf.getText();
           String query = "Select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
           try {
               ResultSet rs = conn.s.executeQuery(query);
               if (rs.next()){

                   setVisible(false);
                   new Transaction(pinnumber).setVisible(true);
               }
               else {
                   JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin ");
               }

           }catch (Exception e){
               System.out.println(e);
           }
        }
        else if(ae.getSource()==clear){
            ctf.setText("");
            ptf.setText("");

        }
        else if(ae.getSource()==signup){
        setVisible(false);
        new SignUpOne().setVisible(true);
        }



    }
    public static void main(String args[]){

       Login l = new Login();
    }

}
