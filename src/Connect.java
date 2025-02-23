import java.sql.*;

public class Connect {
    Connection c;
    Statement s;
    Connect(){
        try {
            // there is no need for creating the register
            // Class.forName(com.mysql.cj.jdbc.Driver);
            // getting connection stringl
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management_system","root","Mysql@8789#123");

            // create a statement
            s = c.createStatement();
            
            //
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
