package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import  java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nametf,fnametf,emailtf,addresstf,citytf,statetf, pincodetf;
    JButton next;
    JRadioButton gr,fr,yr,nr;
    JDateChooser jd;

    SignUpOne(){

        setLayout(null);

        Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000l) + 1000l);


        JLabel formno = new JLabel("APPLICATION FORM NO : "+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personaldetail = new JLabel("Page 1: Personal Details");
        personaldetail.setFont(new Font("Raleway",Font.BOLD,30));
        personaldetail.setBounds(260,80,400,35);
        add(personaldetail);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(130,160,100,30);
        add(name);
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway",Font.BOLD,16));
        nametf.setBounds(300,160,250,30);

        add(nametf);

        JLabel fname = new JLabel("Father Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(130,210,180,30);
        add(fname);

        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway",Font.BOLD,16));
        fnametf.setBounds(300,210,250,30);
        add(fnametf);

        JLabel dob = new JLabel("Date Of Barth  : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(130,260,190,30);
        add(dob);

        jd = new JDateChooser();
        jd.setBounds(300,260,250,30);
        jd.setForeground(new Color(105,105,105));
        add(jd);


        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(130,310,130,30);
        add(gender);
        gr = new JRadioButton("Male");
        gr.setBounds(300,310,60,30);
        gr.setBackground(Color.WHITE);
        add(gr);


        fr = new JRadioButton("Female");
        fr.setBounds(450,310,100,30);
        fr.setBackground(Color.WHITE);
        add(fr);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(gr);
        gendergroup.add(fr);

        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(130,360,100,30);
        add(email);
        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway",Font.BOLD,16));
        emailtf.setBounds(300,360,250,30);
        add(emailtf);

        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(130,410,200,30);
        add(marital);

        yr = new JRadioButton("YES");
        yr.setBounds(300,410,60,30);
        yr.setBackground(Color.WHITE);
        add(yr);


        nr = new JRadioButton("NO");
        nr.setBounds(450,410,100,30);
        nr.setBackground(Color.WHITE);
        add(nr);
        ButtonGroup maritalgropu = new ButtonGroup();
        maritalgropu.add(yr);
        maritalgropu.add(nr);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(130,460,200,30);
        add(address);
        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway",Font.BOLD,16));
        addresstf.setBounds(300,460,250,30);
        add(addresstf);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(130,510,200,30);
        add(city);
        citytf = new JTextField();
        citytf.setFont(new Font("Raleway",Font.BOLD,16));
        citytf.setBounds(300,510,250,30);
        add(citytf);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(130,560,200,30);
        add(state);
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway",Font.BOLD,16));
        statetf.setBounds(300,560,250,30);
        add(statetf);


        JLabel pincode = new JLabel("PinCode : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(130,610,200,30);
        add(pincode);
        pincodetf = new JTextField();
        pincodetf.setFont(new Font("Raleway",Font.BOLD,16));
        pincodetf.setBounds(300,610,250,30);
        add(pincodetf);

        next = new JButton("Next");
        next.setBounds(350,660,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);





        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){

        String formno = ""+ random;
        String name = nametf.getText();
        String fname = fnametf.getText();
        String dob = ((JTextField) jd.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (gr.isSelected()){

            gender="Male";
        }
        else if (fr.isSelected()){
            gender="Female";
        }

        String email = emailtf.getText();
        String marital = null;
        if (yr.isSelected()){
            marital="YES";
        }
        else if (nr.isSelected()){
            marital="NO";
        }
        String address = addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pincode= pincodetf.getText();

            try {
                if(name.equals(" ")){
                    JOptionPane.showMessageDialog(null,"Please Enter the name");
                }

                else{

                    Conn c= new Conn();
                    String query="insert into signup values('"+formno+"','"+name+"', '"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new SignUpTwo(formno).setVisible(true);

                }


            }catch (Exception e ){
                System.out.println(e);

            }

    }
    public static void main(String args[]){

         new SignUpOne();


    }
}
