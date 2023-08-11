import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        boolean stop = false;
        while (!stop) {

            System.out.println("Sign in (1) Or Sign Up (2)");
            System.out.println("(Enter 1 or 2)");
            Scanner sign = new Scanner(System.in);
            String log = sign.next();

            if (log.equals("1")) {

                //get user account number

                System.out.println("Enter your Account Number");

                Scanner x = new Scanner(System.in);
                int acc = x.nextInt();

                //get user password
                Scanner y = new Scanner(System.in);
                System.out.println("Enter your password");
                String pass = y.next();


                try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

                    String database_name = "bank_db";
                    String database_host = "localhost";
                    String database_port = "3306";
                    String username = "root";
                    String password = "";

                    String url = "jdbc:mysql://" + database_host + ":" + database_port + "/" + database_name;

                    //Connect to database
                    Connection conn = DriverManager.getConnection(url, username, password);

                    Statement stmt = conn.createStatement();

                    ResultSet check_acc_no = stmt.executeQuery("select * from user where account_number=" + acc + "");

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


                } catch (Exception e) {
                    System.out.println("" + e);
                }

                //Print bank statement
                System.out.println("Do you want bank statement");
                Scanner inp = new Scanner(System.in);
                String b_stat = inp.next();

                if(b_stat.equalsIgnoreCase("yes")) {
                    PrintStatment stat = new PrintStatment();
                    stat.print();
                }

                //sign in again
                System.out.println("Do you want to sign in again(yes or No)");
                Scanner ans = new Scanner(System.in);
                String answer = ans.next();

                if (answer.equalsIgnoreCase("yes")) {
                    stop = false;
                } else {
                    stop = true;
                    System.out.println("Thank You.Come again");
                }

            } else {
                //insert details into database
                System.out.println("Enter Your Name");
                Scanner nm = new Scanner(System.in);
                String name = nm.next();
                System.out.println("Enter new Password");
                String password = nm.next();
                ConnectDB bin = new ConnectDB();
                bin.getconnection(name,password);
            }
        }
    }
}