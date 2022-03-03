package HotelManagmentSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUpService extends JFrame implements ActionListener {
    Choice c1;
    JButton b1,b2;
    JTable t1;

    PickUpService() {
        setBounds(325, 135, 870, 550);
        setVisible(true);
        setLayout(null);
        setTitle("Pick Up Service");



        JTable t1 = new JTable();
        t1.setBounds(10,100,830,350);
        add(t1);

        JLabel l1 = new JLabel("Pick Up Service");
        l1.setBounds(345,12,800,40);
        l1.setFont(new Font("serif",Font.PLAIN,25));
        add(l1);

        JLabel l2 = new JLabel("Type of Car");
        l2.setBounds(40,65,100,30);
        l2.setFont(new Font("serif",Font.PLAIN,17));
        add(l2);


        JLabel l3 = new JLabel("Name");
        l3.setBounds(20,10,120,20);
        t1.add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(150,10,120,20);
        t1.add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(260,10,120,20);
        t1.add(l5);

        JLabel l6 = new JLabel("Car");
        l6.setBounds(380,10,120,20);
        t1.add(l6);

        JLabel l7 = new JLabel("Model");
        l7.setBounds(480,10,120,20);
        t1.add(l7);

        JLabel l8 = new JLabel("Availability");
        l8.setBounds(600,10,120,20);
        t1.add(l8);

        JLabel l9 = new JLabel("Location");
        l9.setBounds(730,10,120,20);
        t1.add(l9);


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


        Choice c1 = new Choice();
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("model"));
            }
        }catch (Exception e){

        }
        c1.setBounds(180,70,500,30);
        add(c1);



        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try{
                String str = "select * from driver where model = '"+c1.getSelectedItem()+"'";
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
        new PickUpService().setVisible(true);
    }


}
