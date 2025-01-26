import java.sql.*;

public class PreparedST {
    public static void main(String[] args) throws ClassNotFoundException {

        // Creating connection using these 3 parameters
        // mydatabase is the name of db we created
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Tejasvi2022";
        // retrive data from single & multiple placemholder
        String query = "Select * from emp where name=? AND job_title=?";

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

            // using prepared statement instead of normal statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            // 2 arg : position and value
            preparedStatement.setString(1, "hemant");
            preparedStatement.setString(2, "Full stack dev");
            // retrieve data and hold in resultset
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID" + id);
                System.out.println("NAME" + name);
                System.out.println("JOB TITLE" + job_title);
                System.out.println("SALARY" + salary);
            }
            resultSet.close();
            con.close();
            System.out.println("connection closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
