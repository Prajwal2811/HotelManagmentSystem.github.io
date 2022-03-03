package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    Reception(){
        setBounds(325,135,870,550);
        setVisible(true);
        setLayout(null);
        setTitle("RECEPTION");

        b1 = new JButton("New Customer");
        b1.setBounds(20,20,175,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Rooms");
        b2.setBounds(20,60,175,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Departments");
        b3.setBounds(20,100,175,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);


        b4 = new JButton("All Employee Info");
        b4.setBounds(20,140,175,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Customer Info");
        b5.setBounds(20,180,175,30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBounds(20,220,175,30);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBounds(20,260,175,30);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Check Status");
        b8.setBounds(20,300,175,30);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBounds(20,340,175,30);
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        add(b9);

        b10 = new JButton("Pick up Service");
        b10.setBounds(20,380,175,30);
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.addActionListener(this);
        add(b10);

        b11 = new JButton("Search Room");
        b11.setBounds(20,420,175,30);
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.addActionListener(this);
        add(b11);

        b12 = new JButton("Log Out");
        b12.setBounds(20,460,175,30);
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(this);
        add(b12);


        ImageIcon img = new ImageIcon((ClassLoader.getSystemResource("HotelManagmentSystem/icon/reception.jpeg")));
        Image img1 =img.getImage().getScaledInstance(600,490,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l2 = new JLabel(img);
        l2.setBounds(225,0,600,500);
        add(l2);

        getContentPane().setBackground(Color.WHITE);


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==b1){
                new AddCustomer().setVisible(true);
//               this.setVisible(false);
            } else if(ae.getSource()==b2){
                new RoomStatus().setVisible(true);
//               this.setVisible(false);
            }else if(ae.getSource()==b3){
                new Departments().setVisible(true);
//                this.setVisible(false);
            }else if(ae.getSource()==b4){
                new EmployeeInfo().setVisible(true);
//                this.setVisible(false);
            }else if(ae.getSource()==b5){
                new CustomerInfo().setVisible(true);
//               this.setVisible(false);
            }else if(ae.getSource()==b6){
                new ManagerInfo().setVisible(true);
//               this.setVisible(false);
            }else if(ae.getSource()==b7){
                new CheckOut().setVisible(true);
//                this.setVisible(false);
            }else if(ae.getSource()==b8){
                new UpdateCheck().setVisible(true);
//                this.setVisible(false);
            }else if(ae.getSource()==b9){
                new UpdateRoom().setVisible(true);
//                this.setVisible(false);
            }else if(ae.getSource()==b10){
                new PickUpService().setVisible(true);
//                this.setVisible(false);
            }else if(ae.getSource()==b11){
                new SearchRoom().setVisible(true);
//                this.setVisible(false);
            }else if(ae.getSource()==b12){
                setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }


}
















