import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        // creating connection using these 3 parameters
        // mydatabase is the name of db we created
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Tejasvi2022";
        String query = "Select * from emp";
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

            // jo bhi instance aap use krre ho wo apne last ke instance ko use kra hai
            // eg.stmt use krra hai con ko, rs use stmt
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println("ID" + id);
                System.out.println("Name" + name);
                System.out.println("Job Title" + job_title);
                System.out.println("Salary" + salary);
            }

            // closing
            rs.close();
            stmt.close();
            con.close();
            System.out.println("connection closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}