package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField t1, t2;
    JLabel l1, l2;
    JButton b1,b2;

    Login(){

        setLayout(null);
        setBounds(500,300,600,250);
        setVisible(true);
        setTitle("Login Page");

        JLabel l1 = new JLabel("User name ");
        l1.setBounds(20,20,100,30);
        add(l1);

        JLabel l2 = new JLabel("Password ");
        l2.setBounds(20,60,100,30);
        add(l2);

        JTextField t1= new JTextField();
        t1.setBounds(150,20,170,30);
        add(t1);

        JTextField t2= new JPasswordField();
        t2.setBounds(150,60,170,30);
        add(t2);

        JButton b1= new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,150,100,30);
        b1.addActionListener(this);
        add(b1);

        JButton b2= new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(160,150,100,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon img;
        img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/login.jpeg"));
        Image img2 =img.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel l3 = new JLabel(img3);
        l3.setBounds(340,10,250,200);
        add(l3);

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username = t1.getText();
            String password = t2.getText();
            Conn c = new Conn();
            String str = "select * from login where username = '"+username+"' and password = '"+password+"'";
            try{
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Invailid username and password");
                    this.setVisible(false);
                }
            } catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==b2){
            System.exit(0);
        }
    }



    public static void main(String[] args) {
        new Login();
    }
}
