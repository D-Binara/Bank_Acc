import java.sql.*;

public class ConnectDB {

    public void getconnection(String Name) {
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

            ResultSet Enter = stmt.executeQuery("Insert into user (name) values ("+Name+")");

            while (Enter.next()) {
                System.out.println("Your account create correctly");
            }

            Enter.close();
            stmt.close();
            conn.close();


        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}