package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,chpin;
    JButton change ,back;
    String pinnumber;
    public PinChange(String pinnumber){
    setLayout(null);
    this.pinnumber=pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(800,760,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,750);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(214,245,500,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(text);


        JLabel newpinlevel = new JLabel("New Pin : ");
        newpinlevel.setBounds(150,280,150,25);
        newpinlevel.setFont(new Font("Raleway",Font.BOLD,16));
        newpinlevel.setForeground(Color.WHITE);
        image.add(newpinlevel);

        pin = new JPasswordField();
        pin.setBounds(310,280,150,25);
        image.add(pin);

        JLabel renewpinlevel = new JLabel("Re_Enter New Pin : ");
        renewpinlevel.setBounds(150,310,250,25);
        renewpinlevel.setFont(new Font("Raleway",Font.BOLD,16));
        renewpinlevel.setForeground(Color.WHITE);
        image.add(renewpinlevel);

        chpin = new JPasswordField();
        chpin.setBounds(310,310,150,25);
        image.add(chpin);


        change=new JButton("Change");
        change.setBounds(310,404,150,25);
        change.setFont(new Font("Raleway",Font.BOLD,15));
        change.addActionListener(this);
        image.add( change);

        back=new JButton("Back");
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

        if (ae.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = chpin.getText();
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN Doesn't Match");
                    return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Entered The New PIN");
                    return;
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Entered Re-PIN Doesn't Match");
                    return;
                }
                Conn conn=new Conn();
                String query1="update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query2="update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query3="update signupthree  set pin = '"+rpin+"' where pin ='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Change Successfully");
                setVisible(false);
                new  Transaction(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {

        new PinChange("").setVisible(true);
    }

}
