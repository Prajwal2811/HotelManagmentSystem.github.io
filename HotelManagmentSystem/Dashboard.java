package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem mi1,mi2,mi3,mi4;

    Dashboard(){
        setTitle("Welcome to Dashboard....!!");
        setLayout(null);
        setBounds(90,70,1300,680);
        setVisible(true);

        JMenuBar mb = new JMenuBar();
        add(mb);

        JMenu m1 = new JMenu("HOTEL MANAGMENT  ");
        m1.setForeground(Color.BLACK);
        mb.add(m1);

        JMenu m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLACK);
        mb.add(m2);

        JMenuItem mi1=new JMenuItem("RECEPTION");
        mi1.addActionListener(this);
        m1.add(mi1);

        JMenuItem mi2=new JMenuItem("ADD EMPLOYEE");
        mi2.addActionListener(this);
        m2.add(mi2);

        JMenuItem mi3=new JMenuItem("ADD ROOMS");
        mi3.addActionListener(this);
        m2.add(mi3);

        JMenuItem mi4=new JMenuItem("ADD DRIVER");
        mi4.addActionListener(this);
        m2.add(mi4);

        mb.setBounds(0,2,1300,30);


        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/building2.jpeg"));
        Image img1 = img.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l1 = new JLabel(img2);
        l1.setBounds(0,0,1300,650);
        add(l1);


        JLabel l2 = new JLabel("THE DINE OUT WELCOMES YOU...!!!");
        l2.setBounds(300,55,1000,40);
        l2.setFont(new Font("serif", Font.PLAIN, 38));
        l2.setForeground(Color.BLACK);
        l2.setBackground(Color.DARK_GRAY);
        l1.add(l2);


        setVisible(true);
        setLayout(null);
    }

    public void actionPerformed(ActionEvent ae){
        switch (ae.getActionCommand()) {
            case "RECEPTION" -> new Reception().setVisible(true);
            case "ADD EMPLOYEE" -> new AddEmployee().setVisible(true);
            case "ADD ROOMS" -> new AddRooms().setVisible(true);
            case "ADD DRIVER" -> new AddDriver().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
