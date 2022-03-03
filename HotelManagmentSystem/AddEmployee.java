package HotelManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton r1, r2;
    JComboBox c1;
    JLabel l1, l2, l3;
    JButton b1;

    AddEmployee() {
        setBounds(325, 200, 870, 450);
        setVisible(true);
        setLayout(null);
        setTitle("Add Employee");


        JLabel name = new JLabel("Name");
        name.setBounds(40, 35, 120, 30);
        name.setFont(new Font("serif", Font.PLAIN, 17));
        add(name);

        JTextField t1 = new JTextField();
        t1.setBounds(135, 42, 180, 25);
        add(t1);


        JLabel age = new JLabel("Age");
        age.setBounds(40, 75, 120, 30);
        age.setFont(new Font("serif", Font.PLAIN, 17));
        add(age);

        JTextField t2 = new JTextField();
        t2.setBounds(135, 80, 180, 25);
        add(t2);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(40, 110, 120, 30);
        gender.setFont(new Font("serif", Font.PLAIN, 17));
        add(gender);

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(135, 110, 95, 30);
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("serif", Font.PLAIN, 17));
        add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(230, 110, 95, 30);
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("serif", Font.PLAIN, 17));
        add(r2);

        JLabel job = new JLabel("Job");
        job.setBounds(40, 145, 120, 30);
        job.setFont(new Font("serif", Font.PLAIN, 17));
        add(job);

        String[] str = {"Front Desk Clerks", "Housekeeping", "Room Service", "Waiter/Waitress", "Kitchen Staff", "Housekeeping Supervisor", "Hotel Manager", "Executive Chef"};
        JComboBox c1 = new JComboBox<>(str);
        c1.setBounds(135, 145, 180, 30);
        c1.setBackground(Color.WHITE);
        add(c1);


        JLabel salary = new JLabel("Salary");
        salary.setBounds(40, 180, 120, 30);
        salary.setFont(new Font("serif", Font.PLAIN, 17));
        add(salary);

        JTextField t3 = new JTextField();
        t3.setBounds(135, 185, 180, 25);
        add(t3);


        JLabel phone_no = new JLabel("Phone");
        phone_no.setBounds(40, 215, 120, 30);
        phone_no.setFont(new Font("serif", Font.PLAIN, 17));
        add(phone_no);

        JTextField t4 = new JTextField();
        t4.setBounds(135, 218, 180, 25);
        add(t4);


        JLabel adhar_no = new JLabel("Adhar No");
        adhar_no.setBounds(40, 250, 120, 30);
        adhar_no.setFont(new Font("serif", Font.PLAIN, 17));
        add(adhar_no);

        JTextField t5 = new JTextField();
        t5.setBounds(135, 255, 180, 25);
        add(t5);


        JLabel email_id = new JLabel("Email Id");
        email_id.setBounds(40, 285, 120, 30);
        email_id.setFont(new Font("serif", Font.PLAIN, 17));
        add(email_id);

        JTextField t6 = new JTextField();
        t6.setBounds(135, 290, 180, 25);
        add(t6);




        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("HotelManagmentSystem/icon/staff1.jpeg"));
        Image img1 = img.getImage().getScaledInstance(490, 300, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel l1 = new JLabel(img2);
        l1.setBounds(350, 50, 450, 300);
        add(l1);


        JLabel l2 = new JLabel("Add Employee Details");
        l2.setBounds(480, 5, 500, 40);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif", Font.PLAIN, 26));
        add(l2);


        JButton b1 = new JButton("Submit");
        b1.setBounds(660, 375, 150, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
            String name = t1.getText();
            String age = t2.getText();
            String salary = t3.getText();
            String phone_no = t4.getText();
            String adhar_no = t5.getText();
            String email_id = t6.getText();
            String gender = null;

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String job = (String) c1.getSelectedItem();
            Conn c = new Conn();
            String str = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone_no + "','" + adhar_no + "','" + email_id + "')";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Employee Added.");
//                this.setVisible(false);
            } catch (Exception e2) {
                System.out.print(e2);
                e2.printStackTrace();
            }
        }

    public static void main(String[] args) throws Exception {
        new AddEmployee().setVisible(true);
    }
}


