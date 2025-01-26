import java.sql.*;
import java.util.Scanner;

public class InsertPrep {
    public static void main(String[] args) throws ClassNotFoundException {

        // Creating connection using these 3 parameters
        // Mydatabase is the name of db we created
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Tejasvi2022";
        // retrive data from single & multiple placemholder
        String query = "INSERT INTO emp(id, name, job_title,salary) VALUES(? ,?, ?, ?) ";

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

            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            String name = sc.nextLine();
            String job_title = sc.nextLine();
            Double salary = sc.nextDouble();

            // using prepared statement instead of normal statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            // 2 arg : position and value
            preparedStatement.setInt(1, id);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, job_title);
            preparedStatement.setDouble(1, salary);

            int rowsaffected = preparedStatement.executeUpdate();
            if (rowsaffected > 0) {
                System.out.println("Data inserted");
            } else {
                System.out.println("data insertion failed");
            }
            preparedStatement.close();
            con.close();
            System.out.println("connection closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
