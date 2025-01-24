import java.sql.*;

public class Insert {
    public static void main(String[] args) throws ClassNotFoundException {

        // creating connection using these 3 parameters
        // mydatabase is the name of db we created
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Tejasvi2022";
        String query = "INSERT INTO emp(id, name, job_title, salary) VALUES(4, 'Ro', 'UI', 8000)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded succesfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            // driver manager ke pass ek method hai getconnection wo 3 param/arg leta hai
            // and create connection and store it in instance, wo instance hoga connection
            // interface ka ie con
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connection established successfully!");
            Statement stmt = con.createStatement();

            int rowsaffected = stmt.executeUpdate(query);
            if (rowsaffected > 0) {
                System.out.println("Insert successfully" + rowsaffected + "rows affected");
            } else {
                System.out.println("Insertion failed");
            }
            // closing
            stmt.close();
            con.close();
            System.out.println("connection closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
