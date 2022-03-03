package HotelManagmentSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class EmployeeInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;

    EmployeeInfo(){
        setBounds(325, 135, 870, 550);
        setVisible(true);
        setLayout(null);
        setTitle("Employee Information");


        JTable t1 = new JTable();
        t1.setBounds(10,10,835,440);
        add(t1);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(20,10,120,20);
        t1.add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(125,10,120,20);
        t1.add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(225,10,120,20);
        t1.add(l3);

        JLabel l4 = new JLabel("Department");
        l4.setBounds(325,10,120,20);
        t1.add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(430,10,120,20);
        t1.add(l5);

        JLabel l6 = new JLabel("Phone NO.");
        l6.setBounds(525,10,120,20);
        t1.add(l6);

        JLabel l7 = new JLabel("Adhar No.");
        l7.setBounds(625,10,120,20);
        t1.add(l7);

        JLabel l8 = new JLabel("Email Id");
        l8.setBounds(725,10,120,20);
        t1.add(l8);

        JButton b1 =new JButton("Load Data");
        b1.setBounds(270,465,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        JButton b2 =new JButton("Back");
        b2.setBounds(440,465,150,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

//        getContentPane().setBackground(Color.WHITE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try{
                Conn c = new Conn();
                String str = "select * from employee";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e1){
                System.out.println(e1);
            }
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
        }
         this.setVisible(false);
    }

    public static void main(String[] args) {
        new EmployeeInfo().setVisible(true);
    }
}
