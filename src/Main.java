import java.sql.*;
public class Main {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "jdbc:mysql:// DESKTOP-N0DB5HU:3306/Bank_Details";
            Connection conn =DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from user");

            rs.close();stmt.close();conn.close();

        }catch (Exception e){
            System.out.println(""+e);
        }

        System.out.println("Enter your Account Number");



        Bank acc1 = new Bank(10);
        acc1.interestcal(1000);

        Bank acc2 = new Bank(10);
        acc2.interestcal(2000);



    }
}