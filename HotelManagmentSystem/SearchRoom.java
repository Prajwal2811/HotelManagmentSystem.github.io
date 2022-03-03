package HotelManagmentSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class SearchRoom extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JButton b1, b2;
    JComboBox c1, c2;
    JRadioButton r1, r2;
    JCheckBox cb1;
    JTable t1;

    SearchRoom() {
        setBounds(325, 135, 870, 550);
        setVisible(true);
        setLayout(null);
        setTitle("Search Room");

        JTable t1 = new JTable();
        t1.setBounds(10,100,830,350);
        add(t1);

        JLabel l1 = new JLabel("Search For Room");
        l1.setBounds(345,12,800,30);
        l1.setFont(new Font("serif",Font.PLAIN,25));
        add(l1);

        JLabel l2 = new JLabel("Room Bed Type");
        l2.setBounds(40,50,800,30);
        l2.setFont(new Font("serif",Font.PLAIN,17));
        add(l2);


        JComboBox c1 = new JComboBox<>(new String[]{"Single Bed","Double Bed"});
        c1.setBounds(180,55,180,28);
        c1.setFont(new Font("serif",Font.PLAIN,15));
        c1.setBackground(Color.WHITE);
        add(c1);



        JCheckBox cb1 = new JCheckBox("Only display available");
        cb1.setBounds(560,55,180,28);
        cb1.setFont(new Font("serif",Font.PLAIN,15));
        add(cb1);



        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(20,10,120,20);
        t1.add(l3);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(190,10,120,20);
        t1.add(l4);

        JLabel l5 = new JLabel("Room Status");
        l5.setBounds(360,10,120,20);
        t1.add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setBounds(530,10,120,20);
        t1.add(l6);

        JLabel l7 = new JLabel("Bed Type");
        l7.setBounds(700,10,120,20);
        t1.add(l7);




        JButton b1 =new JButton("Submit");
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
                String str = "select * from room where type = '"+c1.getSelectedItem()+"'";
                String str2 = "select * from room where available =''Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                Conn c = new Conn();

                if(cb1.isSelected()){
                    ResultSet rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else  if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }


}