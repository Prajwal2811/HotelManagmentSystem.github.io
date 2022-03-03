package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
        JLabel l1,l2,l3,l4,l5,l6,l7;
        JButton b1,b2,b3;
        JTextField t1,t2,t3,t4,t5,t6;
        Choice c1;

    UpdateCheck() {
        setBounds(325, 135, 870, 550);
        setVisible(true);
        setLayout(null);
        setTitle("Updated Check In Status");


        JLabel l1 = new JLabel("Check in Details");
        l1.setBounds(345, 12, 800, 30);
        l1.setFont(new Font("serif", Font.PLAIN, 25));
        add(l1);



        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(40, 60, 120, 30);
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception e){
                c1.setBounds(175, 65, 180, 25);
                add(c1);
        }


        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(40, 110, 120, 30);
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        add(l3);

        JTextField t2 = new JTextField();
        t2.setBounds(175, 115, 180, 25);
        add(t2);



        JLabel l4 = new JLabel("Name");
        l4.setBounds(40, 160, 120, 30);
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        add(l4);

        JTextField t3 = new JTextField();
        t3.setBounds(175, 165, 180, 25);
        add(t3);




        JLabel l5 = new JLabel("Check In");
        l5.setBounds(40, 210, 120, 30);
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        add(l5);

        JTextField t4 = new JTextField();
        t4.setBounds(175, 215, 180, 25);
        add(t4);




        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(40, 260, 120, 30);
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        add(l6);

        JTextField t5 = new JTextField();
        t5.setBounds(175, 265, 180, 25);
        add(t5);



        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(40, 310, 120, 30);
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        add(l7);

        JTextField t6 = new JTextField();
        t6.setBounds(175, 315, 180, 25);
        add(t6);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/updateroomstatus.jpg"));
        Image img1 =img.getImage().getScaledInstance(490,300,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l8 = new JLabel(img2);
        l8.setBounds(390,65,450,300);
        add(l8);

        JButton b1 =new JButton("Check");
        b1.setBounds(360,420,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        JButton b2 =new JButton("Update");
        b2.setBounds(270,465,150,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        JButton b3 =new JButton("Back");
        b3.setBounds(440,465,150,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==b1){
                try{
                    String room=null;
                    String deposit=null;
                    int amountPaid;
                    String price=null;

                    Conn c = new Conn();
                    String id = c1.getSelectedItem();
                    String str = "select * from customer where number = '"+id+"'" ;
                    ResultSet rs = c.s.executeQuery(str);
                    while(rs.next()){
                        t1.setText(rs.getString("room"));
                        t2.setText(rs.getString("name"));
                        t3.setText(rs.getString("status"));
                        t4.setText(rs.getString("deposit"));
                        room = rs.getString("room");
                        deposit = rs.getString("deposit");

                    }
                    ResultSet rs2 = c.s.executeQuery("select * from room where room = '"+room+"'");
                    while (rs2.next()){
                        price = rs2.getString("price");
                        amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                        t5.setText(Integer.toString(amountPaid));
                    }
                } catch (Exception e){

                }

            } else  if(ae.getSource()==b2){

            }else  if(ae.getSource()==b3){
                new Reception().setVisible(true);
            }
            this.setVisible(false);
    }



    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }
    }
