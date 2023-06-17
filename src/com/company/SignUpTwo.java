package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import  java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener {
    JComboBox relig ,catago,inco,educate,occupat;
    JTextField pantf,adhartf;
    JRadioButton exty,extn,seniory,seniorn;
    JButton next;
    String formno;

    SignUpTwo(String formno){

        this.formno=formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM -- PAGE-2");
        JLabel additionaldetail = new JLabel("Page -2 : Additional Details");
        additionaldetail.setFont(new Font("Raleway",Font.BOLD,30));
        additionaldetail.setBounds(220,55,400,40);
        add(additionaldetail);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(140,130,130,30);
        add(religion);

        String valreligion[] ={"Hindu","Muslim","Sikh","Christian"};
        relig = new JComboBox(valreligion);
        relig.setBounds(300,130,300,30);
        relig.setBackground(Color.WHITE);
        add(relig);

        JLabel catagory = new JLabel("Catagory :");
        catagory.setBounds(140,180,150,30);
        catagory.setFont(new Font("Raleway",Font.BOLD,20));
        add(catagory);

        String valcatagory[]={"General","OBC","SC","ST","Other"};
        catago = new JComboBox(valcatagory);
        catago.setBackground(Color.WHITE);
        catago.setBounds(300,180,300,30);
        add(catago);

        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(140,230,150,30);
        add(income);

        String valincome[]={"Null","<150000","<250000","<500000","upto 1000000"};
        inco = new JComboBox(valincome);
        inco.setBounds(300,230,300,30);
        inco.setBackground(Color.WHITE);
        add(inco);


        JLabel qualification = new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(140,275,150,30);
        add(qualification);

        String education[]={"Non","under-Graduate","Post-Graduate","Doctrate","Other"};
        educate = new JComboBox(education);
        educate.setBackground(Color.WHITE);
        educate.setBounds(300,275,300,30);
        add(educate);


        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(140,320,150,30);
        add(occupation);

        String occu[]={"Student","Bussiness","Employee","Retair-Employee"};
        occupat = new JComboBox(occu);
        occupat.setBounds(300,320,300,30);
        occupat.setBackground(Color.WHITE);
        add(occupat);

        JLabel panno = new JLabel("PAN NO :");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(140,365,200,30);
        add(panno);


        pantf = new JTextField();
        pantf.setBounds(300,365,300,30);
        pantf.setFont(new Font("Raleway",Font.BOLD,15));
        add(pantf);


        JLabel adharno = new JLabel("Adhar No :");
        adharno.setFont(new Font("Raleway",Font.BOLD,20));
        adharno.setBounds(140,410,160,30);
        add(adharno);

        adhartf = new JTextField();
        adhartf.setBounds(300,410,300,30);
        adhartf.setFont(new Font("Raleway",Font.BOLD,15));
        add(adhartf);

        JLabel seniorc = new JLabel("Senior Citizen :");
        seniorc.setFont(new Font("Raleway",Font.BOLD,20));
        seniorc.setBounds(140,455,150,30);
        add(seniorc);

        seniory = new JRadioButton("YES");
        seniory.setBackground(Color.WHITE);
        seniory.setBounds(350,455,100,30);
        add(seniory);

        seniorn = new JRadioButton("NO");
        seniorn.setBackground(Color.WHITE);
        seniorn.setBounds(450,455,100,30);
        add(seniorn);
        ButtonGroup seniorbutton = new ButtonGroup();
        seniorbutton.add(seniory);
        seniorbutton.add(seniorn);



        JLabel existingacc = new JLabel("Existing Account :");
        existingacc.setBounds(140,500,200,30);
        existingacc.setFont(new Font("Raleway",Font.BOLD,20));
        add(existingacc);

        exty = new JRadioButton("YES");
        exty.setBackground(Color.WHITE);
        exty.setBounds(350,500,100,30);
        add(exty);

        extn = new JRadioButton("NO");
        extn.setBackground(Color.WHITE);
        extn.setBounds(450,500,100,30);
        add(extn);
        ButtonGroup existaccbutton = new ButtonGroup();
        existaccbutton.add(exty);
        existaccbutton.add(extn);

        next = new JButton("Next");
        next.setBounds(350,570,100,30);
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

        String sreligon = (String) relig.getSelectedItem();
        String scatagory = (String) catago.getSelectedItem();
        String sincome = (String) inco.getSelectedItem();
        String seducate =(String) educate.getSelectedItem();
        String soccupation=(String) occupat.getSelectedItem();
        String spannumber= pantf.getText();
        String sadharnumber = adhartf.getText();
        String seniorcitz=null;
        if (seniory.isSelected()){
            seniorcitz="YES";
        }
        else if (seniorn.isSelected()){
            seniorcitz="NO";
        }

        String existaccount=null;
        if (exty.isSelected()){
            existaccount="YES";
        }
        else if (extn.isSelected()){
            existaccount="NO";

        }


    try {
        Conn c= new Conn();
        String query="insert into signuptwo values('"+sreligon+"','"+scatagory+"','"+sincome+"','"+seducate+"','"+soccupation+"','"+spannumber+"','"+sadharnumber+"','"+seniorcitz+"','"+existaccount+"')";
        c.s.executeUpdate(query);

        setVisible(false);
        new SignUpThree(formno).setVisible(true);


    }catch (Exception e){
        System.out.println(e);
    }

    }


public static void main(String args[]){
    new SignUpTwo("");

}

}
