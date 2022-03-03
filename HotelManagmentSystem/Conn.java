package HotelManagmentSystem;
import java.sql.*;


public class Conn {
    Connection c;
    Statement s;

    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://projecthms","root","2811");
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }

}
