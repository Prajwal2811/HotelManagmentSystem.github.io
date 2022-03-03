package HotelManagmentSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Departments extends JFrame implements ActionListener {
    JButton b1,b2;
    JTable t1;

    Departments() {
        setBounds(325, 135, 870, 550);
        setVisible(true);
        setLayout(null);
        setTitle("Departments");



        JTable t1 = new JTable();
        t1.setBounds(10,100,830,350);
        add(t1);

        JLabel l1 = new JLabel("Departments");
        l1.setBounds(345,12,800,40);
        l1.setFont(new Font("serif",Font.PLAIN,25));
        add(l1);



        JLabel l3 = new JLabel("Department");
        l3.setBounds(20,10,120,20);
        t1.add(l3);

        JLabel l4 = new JLabel("Budget");
        l4.setBounds(150,10,120,20);
        t1.add(l4);


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


        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try{
                String str = "select * from driver where department";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }
        }else  if(ae.getSource()==b2){
            new Reception().setVisible(true);
        }
        this.setVisible(false);

    }

    public static void main(String[] args) {
        new Departments().setVisible(true);
    }


}
