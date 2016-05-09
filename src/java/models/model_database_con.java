package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class model_database_con {

    
    Connection conexion = null;    
    String host,user,db,pass = null;
    PreparedStatement pst = null;
    Statement st = null;    
    ResultSet rs = null;
    
    
    public model_database_con ()
    {
        
        //.host = "localhost";
        //this.db = "todo";
        //this.user = "root";
        //this.pass = "";   
                
        this.host = "localhost:3306";
        this.db = "xspacein_todo";
        this.user = "xspacein_user";
        this.pass = "Test2020";        
        
    }
    
    public void con() throws SQLException //connection to the data Base
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion =DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.db,this.user,this.pass);
                    
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }        
    }
    
    public void dis() throws SQLException{
        conexion.close();
        
    }
    
}
