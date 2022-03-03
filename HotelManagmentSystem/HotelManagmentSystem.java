package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagmentSystem extends JFrame implements ActionListener {
    HotelManagmentSystem() {
        setBounds(325,135,870,550);
        setTitle("Welcome....!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/entrance1.jpeg"));
//        Image img1 = img.getImage().getScaledInstance(1200,850,Image.SCALE_DEFAULT);
        Image img1 =img.getImage().getScaledInstance(870,550,Image.SCALE_DEFAULT);

        JLabel l1 = new JLabel(img);
        l1.setBounds(0, 0, 870, 800);
        add(l1);


        JLabel l2 = new JLabel("Welcome To Dine Out Group");
        l2.setBounds(200, 200, 800, 70);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.PLAIN, 35));
        l1.add(l2);


        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(700,475,100,30);
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true);


        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            l2.setVisible(true);
            try {
                Thread.sleep(900);
            } catch (Exception e) {
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagmentSystem();
    }


}
