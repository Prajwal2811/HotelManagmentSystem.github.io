package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
        JLabel l1,l2,l3,l4,l5,l6l7;
        JRadioButton r1,r2;
        JButton b1,b2;
        JTextField t1,t2,t3,t4,t5;
        JComboBox c1,c2;

    AddDriver(){
        setBounds(325,200,870,450);
        setVisible(true);
        setLayout(null);
        setTitle("Add Driver");


        JLabel title = new JLabel("Add Driver");
        title.setBounds(345,12,150,30);
        title.setFont(new Font("serif",Font.PLAIN,25));
        add(title);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(70,50,150,50);
        l1.setFont(new Font("serif",Font.PLAIN,17));
        add(l1);

        JTextField t1 =new JTextField();
        t1.setBounds(180,65,150,25);
        add(t1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(70,85,150,50);
        l2.setFont(new Font("serif",Font.PLAIN,17));
        add(l2);

        JTextField t2 =new JTextField();
        t2.setBounds(180,95,150,25);
        add(t2);




        JLabel l3 = new JLabel("Gender");
        l3.setBounds(70,120,150,50);
        l3.setFont(new Font("serif",Font.PLAIN,17));
        add(l3);

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(180,130,60,30);
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("serif",Font.PLAIN,17));
        add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(255,130,75,30);
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("serif",Font.PLAIN,17));
        add(r2);

        JLabel l4 = new JLabel("Car Company");
        l4.setBounds(70,155,150,50);
        l4.setFont(new Font("serif",Font.PLAIN,17));
        add(l4);

        JTextField t3 =new JTextField();
        t3.setBounds(180,170,150,25);
        add(t3);


        JLabel l5 = new JLabel("Car Model");
        l5.setBounds(70,190,150,50);
        l5.setFont(new Font("serif",Font.PLAIN,17));
        add(l5);

        JTextField t4 =new JTextField();
        t4.setBounds(180,205,150,25);
        add(t4);

        JLabel l6 = new JLabel("Available");
        l6.setBounds(70,225,150,50);
        l6.setFont(new Font("serif",Font.PLAIN,17));
        add(l6);


        JComboBox<String> c1 = new JComboBox<String>(new String[]{"Available","Busy"});
        c1.setBounds(180,240,150,25);
        c1.setFont(new Font("serif",Font.PLAIN,17));
        add(c1);



        JLabel l7 = new JLabel("Location");
        l7.setBounds(70,260,150,50);
        l7.setFont(new Font("serif",Font.PLAIN,17));
        add(l7);

        JTextField t5 =new JTextField();
        t5.setBounds(180,275,150,25);
        add(t5);


        JButton b1 = new JButton("Add Driver");
        b1.setBounds(540,375,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);


        JButton b2 = new JButton("Cancel");
        b2.setBounds(700,375,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/driver.jpeg"));
        Image img1 =img.getImage().getScaledInstance(490,300,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l8 = new JLabel(img2);
        l8.setBounds(350,50,450,300);
        add(l8);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name = t1.getText();
            String age = t2.getText();
            String company= t3.getText();
            String model = t4.getText();
            String available = (String) c1.getSelectedItem();
            String location = t5.getText();

            String gender =null;
            if(r1.isSelected()){
                gender = "Male";
            } else if (r2.isSelected()){
                gender = "Female";
            }

            Conn c = new Conn();
            try{
                String str = "insert into room values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver added Successfully.");
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        } else if(ae.getSource()==b2){
            System.exit(0);
            new Reception().setVisible(true);
        }
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new AddDriver().setVisible(true);
        
    }
}

