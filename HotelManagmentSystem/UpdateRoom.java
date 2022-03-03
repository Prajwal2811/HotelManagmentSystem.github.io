package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1,t2,t3;

    UpdateRoom(){
        setBounds(325, 135, 870, 550);
        setVisible(true);
        setLayout(null);
        setTitle("Updated Rooms Status");


        JLabel l1 = new JLabel("Update Room Status");
        l1.setBounds(345,12,800,30);
        l1.setFont(new Font("serif",Font.PLAIN,25));
        add(l1);

        JLabel l2 = new JLabel("Guest Id");
        l2.setBounds(40, 70, 120, 30);
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
            e.printStackTrace();
        }
        c1.setBounds(175,75,180,25);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(40, 130, 150, 30);
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        add(l3);

        JTextField t1 = new JTextField();
        t1.setBounds(175, 135, 180, 25);
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(40, 190, 150, 30);
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        add(l4);

        JTextField t2 = new JTextField();
        t2.setBounds(175, 195, 180, 25);
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(40, 250, 150, 30);
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        add(l5);

        JTextField t3 = new JTextField();
        t3.setBounds(175, 260, 180, 25);
        add(t3);



        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/updateroom.jpeg"));
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
                String room_no = null;
                String str = c1.getSelectedItem();
                Conn c = new Conn();
                try {
                    ResultSet rs = c.s.executeQuery("select * from customer where number = '"+str+"'");
                    while (rs.next()) {
                        t1.setText(rs.getString("room_no"));
                        room_no = rs.getString("room_no");
                    }
                    ResultSet rs1 = c.s.executeQuery("select * from room_no where number = '"+room_no+"'");

                    while(rs1.next()) {
                        t2.setText(rs1.getString("available"));
                        t3.setText(rs1.getString("status"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if(ae.getSource()==b2){
                    try{
                        Conn c = new Conn();
                        String room = t1.getText();
                        String available = t2.getText();
                        String status = t3.getText();

                        String str = "update room set available'"+available+"', status = '"+status+"' where room '"+room+"'";
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Room Updated Successfully.");
                        new Reception().setVisible(true);
                        this.setVisible(false);
                    }catch (Exception e){
                        System.out.println(e);
                    }
            }else if(ae.getSource()==b3){
                new Reception().setVisible(true);
            }
                this.setVisible(false);
    }

    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }


}
