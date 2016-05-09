package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class modelusers extends model_database_con {
     
    
    public String addNewUser(String nom, String email, String pass)throws SQLException {
        
        con();
        String sql = "INSERT INTO table_users (nom, email, pass) VALUES (?, ?, ?)";
        String sql2 = "SELECT email FROM table_users";
        
        st = conexion.createStatement();
        rs = st.executeQuery(sql2);
        
        Boolean boo = null;
        Boolean boo2 = true;
        
        ArrayList<Object> list1 = new ArrayList<Object>();
        
        while(rs.next()){
            list1.add(rs.getString(1));
        }
        
        Iterator it = list1.iterator();
        
        while(it.hasNext()){
            Object element = it.next();
            if(element.equals(email)){
                boo = true;
            }             
        }
        
        if ( boo == boo2 ) {
             String Existing = "This User Already Exist"; 
             return Existing;
        } else {
            pst = conexion.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, email);
            pst.setString(3, pass);        
            pst.executeUpdate();
            
            pst.close();
            dis();
            
            st.close();
            rs.close();
            dis();
            
            String Existing = "Account was Successfully Created"; 
            return Existing;
            
        }                      
    }
    
    public Boolean Loggin(String email, String pass) throws SQLException {
        
        Boolean accessing=null;
        con();
        String sql = "SELECT email,pass FROM table_users WHERE email='"+email+"' AND pass='"+pass+"' ";
        st = conexion.createStatement();
        rs = st.executeQuery(sql);
        
       if(rs.next()){
            accessing = true;  
        } else {
            accessing = false;
        }
        
        rs.close();
        st.close();
        dis();
        return accessing;
    }
    
}

