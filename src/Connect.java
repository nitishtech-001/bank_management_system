import java.sql.*;

public class Connect {
    Connection c = null;
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
    public void disconnect(){
        if(c != null){
            try{
                c.close();
            }catch(SQLException error){
                System.out.println("Error closing Database : "+error.getMessage());
            }
        }
    }
    
}
