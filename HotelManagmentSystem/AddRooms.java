package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;

    AddRooms(){
        setTitle("Add Rooms");
        setLayout(null);
        setBounds(325,200,870,450);
        setVisible(true);

        JLabel l1 = new JLabel("Add Rooms");
        l1.setBounds(150,8,150,70);
        l1.setFont(new Font("serif",Font.BOLD,25));
        l1.setForeground(Color.BLACK);
        add(l1);

        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(35,50,150,70);
        l2.setFont(new Font("serif",Font.PLAIN,18));
        add(l2);

        JTextField t1 = new JTextField();
        t1.setBounds(180,75,200,30);
        add(t1);

        JLabel l3 = new JLabel("Available Rooms");
        l3.setBounds(35,100,150,70);
        l3.setFont(new Font("serif",Font.PLAIN,18));
        add(l3);

        JComboBox c1 = new JComboBox(new String[]{"Available","Occupied"});
        c1.setBounds(180,125,200,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel l4 = new JLabel("Cleaning Status");
        l4.setBounds(35,150,150,70);
        l4.setFont(new Font("serif",Font.PLAIN,18));
        add(l4);

        JComboBox c2 = new JComboBox(new String[]{"Clean","Dirty"});
        c2.setBounds(180,175,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);


        JLabel l5 = new JLabel("Price");
        l5.setBounds(35,200,150,70);
        l5.setFont(new Font("serif",Font.PLAIN,18));
        add(l5);

        JTextField t2 = new JTextField();
        t2.setBounds(180,225,200,30);
        add(t2);

        JLabel l6 = new JLabel("Bed Type");
        l6.setBounds(35,250,150,70);
        l6.setFont(new Font("serif",Font.PLAIN,18));
        add(l6);

        JComboBox c3 = new JComboBox(new String[]{"Single Bed","Double Bed"});
        c3.setBounds(180,275,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);

        JButton b1 = new JButton("Add Rooms");
        b1.setBounds(550,375,120,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        JButton b2 = new JButton("Cancel");
        b2.setBounds(700,375,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);


        ImageIcon img = new ImageIcon((ClassLoader.getSystemResource("HotelManagmentSystem/icon/room1.jpeg")));
        Image img1 = img.getImage().getScaledInstance(490,300,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        l1 = new JLabel(img2);
        l1.setBounds(395,45,450,300);
        add(l1);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room_number = t1.getText();
            String available = (String) c1.getSelectedItem();
            String cl_status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String bed_type = (String) c3.getSelectedItem();
            Conn c = new Conn();
            try{
                String str = "insert into room values('"+room_number+"','"+available+"','"+cl_status+"','"+price+"','"+bed_type+"')";
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Room added");
                this.setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(ae.getSource()==b2){
//            System.exit(0);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
