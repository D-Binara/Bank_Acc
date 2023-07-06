import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter your Account Number");
        Scanner x = new Scanner(System.in);
        int acc = x.nextInt();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();


            String database_name = "bank_db";
            String database_host = "localhost";
            String database_port = "3306";
            String username = "root";
            String password = "";

            String url = "jdbc:mysql://"+database_host+":"+database_port+"/"+database_name;


            Connection conn =DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from user where account_number="+acc+"");

            while (rs.next()) {
                int acc_no = rs.getInt("account_number");
                String name =rs.getString("name");
                float balance =rs.getInt("Balance");
                System.out.println("Account Number ="+acc_no);
                System.out.println("Name ="+name);

                Bank acc1 = new Bank(10);
                acc1.interestcal(balance);

            }



            rs.close();stmt.close();conn.close();






        }catch (Exception e){
            System.out.println(""+e);
        }


    }
}