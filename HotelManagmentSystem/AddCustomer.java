package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5;
    JComboBox cb1,cb2;
    JRadioButton r1,r2;


    AddCustomer(){
        setBounds(325,135,870,550);
        setVisible(true);
        setLayout(null);
        setTitle("Add Customer");

        JLabel l1 = new JLabel("New Customer Details");
        l1.setBounds(480, 5, 500, 40);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("serif", Font.PLAIN, 26));
        add(l1);

        JLabel id = new JLabel("Id");
        id.setBounds(40, 35, 120, 30);
        id.setFont(new Font("serif", Font.PLAIN, 17));
        add(id);

        String[] str = {"Passport","Adhar Card","Voter Id","PAN Card","Driving License"};
        JComboBox cb1 = new JComboBox<>(str);
        cb1.setBounds(175, 35, 180, 26);
        cb1.setBackground(Color.WHITE);
        add(cb1);


        JLabel number = new JLabel("Id Number");
        number.setBounds(40, 75, 150, 30);
        number.setFont(new Font("serif", Font.PLAIN, 17));
        add(number);

        JTextField t1 = new JTextField();
        t1.setBounds(175, 80, 180, 25);
        add(t1);

        JLabel name = new JLabel("Name");
        name.setBounds(40, 115, 120, 30);
        name.setFont(new Font("serif", Font.PLAIN, 17));
        add(name);

        JTextField t2 = new JTextField();
        t2.setBounds(175, 125, 180, 25);
        add(t2);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(40, 155, 120, 30);
        gender.setFont(new Font("serif", Font.PLAIN, 17));
        add(gender);

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(175, 155, 75, 30);
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("serif", Font.PLAIN, 17));
        add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(255, 155, 95, 30);
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("serif", Font.PLAIN, 17));
        add(r2);

        JLabel country= new JLabel("Country");
        country.setBounds(40, 195, 120, 30);
        country.setFont(new Font("serif", Font.PLAIN, 17));
        add(country);

        JTextField t3 = new JTextField();
        t3.setBounds(175, 200, 180, 25);
        add(t3);


        JLabel room_number = new JLabel("Room Number");
        room_number.setBounds(40, 235, 200, 26);
        room_number.setFont(new Font("serif", Font.PLAIN, 17));
        add(room_number);

        String[] str1 = {"101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120"};
        JComboBox c2 = new JComboBox<>(str1);
        c2.setBounds(175, 240, 180, 26);
        c2.setBackground(Color.WHITE);
        add(c2);


        JLabel contact = new JLabel("Checked In");
        contact.setBounds(40, 275, 120, 30);
        contact.setFont(new Font("serif", Font.PLAIN, 17));
        add(contact);

        JTextField t4 = new JTextField();
        t4.setBounds(175, 283, 180, 25);
        add(t4);


        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(40, 310, 120, 30);
        deposit.setFont(new Font("serif", Font.PLAIN, 17));
        add(deposit);

        JTextField t5 = new JTextField();
        t5.setBounds(175, 320, 180, 25);
        add(t5);


        JButton b1 =new JButton("Add");
        b1.setBounds(270,365,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        JButton b2 =new JButton("Back");
        b2.setBounds(440,365,150,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/customer.jpeg"));
        Image img1 = img.getImage().getScaledInstance(350, 300, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l2 = new JLabel(img2);
        l2.setBounds(375, 50, 450, 300);
        add(l2);

        getContentPane().setBackground(Color.WHITE);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String id = (String) cb1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()){
                gender = "Female";
            }
            String country = t3.getText();
            String room = (String) cb2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();

            String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + status + "','" + deposit + "')";
            String str1 = "update room set available = 'Occupied' where room = '"+room+"'";
                try {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate(str);
                    c1.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "New Customer Added.");
                    new Reception().setVisible(true);
                    this.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                }
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
        }
        this.setVisible(false);

    }



    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }
}
