package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener{
    JLabel l1, l2, l3;
    JButton b1, b2,b3;
    JTextField t1, t2;

    Choice c1;


    CheckOut() {
        setBounds(325, 250, 870, 350);
        setVisible(true);
        setLayout(null);
        setTitle("Check Out");


        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(345, 12, 800, 30);
        l1.setFont(new Font("serif", Font.PLAIN, 25));
        add(l1);


        JLabel l2 = new JLabel("Customer Id");
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
        } catch (Exception e){

        }
        c1.setBounds(180,65,180,60);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(40, 120, 120, 26);
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        add(l3);

        JTextField t1 = new JTextField();
        t1.setBounds(180,125,180,25);
        add(t1);


        JButton b1 =new JButton("Check Out");
        b1.setBounds(50,215,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);


        JButton b2 =new JButton("Back");
        b2.setBounds(240,215,150,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        ImageIcon img = new ImageIcon((ClassLoader.getSystemResource("HotelManagmentSystem/icon/tick.png")));
        Image img1 = img.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JButton b3 = new JButton(img2);
        b3.setBounds(373,66,20,20);
        b3.setLayout(null);
        add(b3);

        ImageIcon img3 = new ImageIcon((ClassLoader.getSystemResource("HotelManagmentSystem/icon/checkout1.jpg")));
        Image img4 = img3.getImage().getScaledInstance(415,250,Image.SCALE_DEFAULT);
        ImageIcon img5 = new ImageIcon(img4);
        l1 = new JLabel(img5);
        l1.setBounds(355,10,500,300);
        add(l1);


        getContentPane().setBackground(Color.WHITE);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str1 = "delete from customer where number = '"+id+"'";
            String str2 = "update from set available = 'Available' where room = '"+room+"'";
            Conn c = new Conn();
            try {
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Check Out Done");
                new Reception().setVisible(true);
//                this.setVisible(false);
            } catch (Exception e){

            }
        }else  if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }else  if(ae.getSource()==b3){
            Conn c = new Conn();
            String id = c1.getSelectedItem();
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                }
            } catch (Exception e){
                System.out.println(e);
            }
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }
}
