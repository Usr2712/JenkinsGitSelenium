package CommonMethods;

import java.sql.*;

public class Common {

   public String DeviceName;


   static String username = "root";

   String dbUrl = "jdbc:mysql://localhost:3306/logindetails?autoReconnect=true&useSSL=false";
   //Database Password
   static String password = "Usr@2712";

   //Query to Execute
   static String query = "Select *from usercreds;";

   // Connection object
   static Connection con = null;
   // Statement object
   private static Statement stmt;

   static String UserNameinDB;
   static String PasswordinDb;


   public void setUp() throws SQLException, ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");


      //Create Connection to DB
      Connection con = DriverManager.getConnection(dbUrl,username,password);

      //Create Statement Object
      Statement stmt = con.createStatement();

      // Execute the SQL Query. Store results in ResultSet
      ResultSet rs= stmt.executeQuery(query);

      // While Loop to iterate through all data and print results
      while (rs.next()){
         String User = rs.getString(1);
         String Pass = rs.getString(2);

         UserNameinDB = rs.getString(1);
         PasswordinDb = rs.getString(2);
      }
      // closing DB Connection
      con.close();
   }
}
