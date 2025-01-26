// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.sql.*;

// // GIVE DATA OF ONE SINGLE IMAGE IN BYTE FORMAT
// public class Image_Handling {
//     public static void main(String[] args) throws ClassNotFoundException {

//         // Creating connection using these 3 parameters
//         // mydatabase is the name of db we created
//         String url = "jdbc:mysql://localhost:3306/mydatabase";
//         String username = "root";
//         String password = "Tejasvi2022";
//         String image_path = "C:\\Users\\Tejasvi\\OneDrive\\Desktop\\JDBC\\Img_Handling.java\\Image\\img.jpg";
//         inserting data in img table in img data field 
//         String query = "INSERT INTO image_table(image_data) VALUES(?)";

//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             System.out.println("Drivers loaded succesfully");
//         } catch (ClassNotFoundException e) {
//             System.out.println(e.getMessage());
//         }

//         try {
//             // driver manager ke pass ek method hai getconnection wo 3 param/arg leta hai
//             // and create connection and store it in instance, wo instance hoga connection
//             // interface ka ie con
//             Connection con = DriverManager.getConnection(url, username, password);
//             System.out.println("connection established successfully!");

//             FileInputStream fileInputStream = new FileInputStream(image_path);
//             byte[] imageData = new byte[fileInputStream.available()];
//             fileInputStream.read(imageData);
//             PreparedStatement preparedStatement = con.prepareStatement(query);
//             preparedStatement.setBytes(1, imageData);

//             int affectedRows = preparedStatement.executeUpdate();
//             if(affectedRows>0){
//                 System.out.println("Img inserted successfully!!");
//             }
//             else{
//                 System.out.println("Img not inserted");
//             }

//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } catch(FileNotFoundException e){
//             throw new RuntimeException(e);
//         } catch(IOException e){
//             throw new RuntimeException(e);
//         }
//     }
// }




// ---ABHI IMG DATA DB KE ANDR JA CHUKA HAI--
// NOW, DB SE IMG NIKALNA HAI OR FOLDER MAI DALNA HAI




import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

// GIVE DATA OF ONE SINGLE IMAGE IN BYTE FORMAT
public class Image_Handling {
    public static void main(String[] args) throws ClassNotFoundException {

        // Creating connection using these 3 parameters
        // mydatabase is the name of db we created
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Tejasvi2022";
        String folder_path = "C:\\Users\\Tejasvi\\OneDrive\\Desktop\\JDBC\\Img_Handling.java\\Image\\img.jpg";
        // query for retrieveing data from img table
        String query = "SELECT image_data from image_table where image_id (?)";
        
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

            // using fileOutput stream
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                byte[] image_data = resultSet.getBytes("image_data");
                // img ka naam concaneta with img
                String image_path = folder_path + "img.jpg";
                FileOutputStream outputStream = new FileOutputStream(image_path);
            }else{
                System.out.println("img not found");
            }
            
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

