package Mini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.Query;

/**
 *
 * @author 1bestcsharp.blogspot.com
 */
public class MyQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aman", "root","password");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Product2> BindTable(){
        
   ArrayList<Product2> list = new ArrayList<Product2>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT `P_ID`, `P_Name`, `Price`,`Qty`, `P_Image`, `Description` , `Category` FROM `product`");
   
   Product2 p;
   while(rs.next()){
	   p = new Product2(
			   rs.getInt("P_ID"),
			   rs.getString("P_Name"),
			   rs.getDouble("Price"),
			   rs.getInt("Qty"),
			   rs.getBytes("P_Image"),
			   rs.getString("Description"),
			   rs.getInt("Category")
		   );
	   
	   list.add(p);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return list;
   }
}
