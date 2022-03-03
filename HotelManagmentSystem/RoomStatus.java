package HotelManagmentSystem;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class RoomStatus extends JFrame implements ActionListener {
    JTable t1;
    JButton b1, b2;

    RoomStatus() {
        setBounds(325, 135, 870, 550);
        setVisible(true);
        setLayout(null);
        setTitle("Room Status");

        JTable t1 = new JTable();
        t1.setBounds(10,10,450,440);
        add(t1);


        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(15,10,120,20);
        t1.add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(115,10,120,20);
        t1.add(l2);

        JLabel l3 = new JLabel("Clean Status");
        l3.setBounds(205,10,120,20);
        t1.add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(305,10,120,20);
        t1.add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(380,10,120,20);
        t1.add(l5);


        ImageIcon img = new ImageIcon((ClassLoader.getSystemResource("HotelManagmentSystem/icon/room.jpeg")));
        Image img1 = img.getImage().getScaledInstance(375,440,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l6 = new JLabel(img2);
        l6.setBounds(425,6,450,450);
        add(l6);


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

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try{
                Conn c = new Conn();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
        }
        this.setVisible(false);
    }


    public static void main(String[] args) {

        new RoomStatus().setVisible(true);
    }
}