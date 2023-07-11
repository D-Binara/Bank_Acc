import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //get user account number
        System.out.println("Enter your Account Number");
        Scanner x = new Scanner(System.in);
        int acc = x.nextInt();

        //get user password
        System.out.println("Enter your password");
        Scanner y = new Scanner(System.in);
        String pass = y.next();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String database_name = "bank_db";
            String database_host = "localhost";
            String database_port = "3306";
            String username = "root";
            String password = "";

            String url = "jdbc:mysql://"+database_host+":"+database_port+"/"+database_name;

            //Connect to database
            Connection conn =DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();

            ResultSet check_acc_no  = stmt.executeQuery("select * from user where account_number=" + acc + "");

            ResultSet rs = stmt.executeQuery("select * from user where account_number=" + acc + "");

            while (rs.next()) {
                String password1 = rs.getString("password");
                //check password
                if (password1.equals(pass)) {
                    int acc_no = rs.getInt("account_number");
                    String name = rs.getString("name");
                    float deposit = rs.getInt("Balance");
                    System.out.println("Account Number =" + acc_no);
                    System.out.println("Name =" + name);

                    //To call the Bank class
                    Bank acc1 = new Bank(10);
                    acc1.interestcal(deposit);
                } else {
                    System.out.println("Wrong password");
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        }catch (Exception e){
            System.out.println(""+e);
        }

        System.out.println("Do you want to continue process");
        Scanner ans= new Scanner(System.in);
        String answer = ans.next();

        if(answer.equals(answer)){

        }


    }
}