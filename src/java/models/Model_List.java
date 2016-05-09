package models;

import java.sql.SQLException;
import java.util.ArrayList;


public class Model_List extends model_database_con {       
   
  
   
    public void add(String UserInfo, String item) throws SQLException 
    {           
         try {
            con();
            String sql= "INSERT INTO table1 (userinfo, list) VALUES (?,?)";
            pst = conexion.prepareStatement(sql);
            pst.setString(1, UserInfo);
            pst.setString(2, item);
            pst.executeUpdate();                
         
         } finally {          
             try {pst.close(); } catch (Exception e) { }
             try {dis(); } catch (Exception e) { }             
         }        
    }      
    
    public void removeItem(String UserInfo, int iditem) throws SQLException  
    {
        try {
            con();
            String sql = "DELETE FROM table1 WHERE userinfo='"+UserInfo+"' AND id='"+iditem+"' ";
            st = conexion.createStatement();
            st.executeUpdate(sql);            
        } finally  {
            try {st.close(); } catch (Exception e) { }
            try {dis(); } catch (Exception e) { } 
        }
    }
    
     public ArrayList<Object>getList(String UserInfo) throws SQLException 
    {
        try {            
            con();
            String sql = "SELECT list From table1 WHERE userinfo='"+UserInfo+"' ";
            st = conexion.createStatement();
            rs = st.executeQuery(sql);

            ArrayList<Object> listofitems = new ArrayList<Object>();                 

            while(rs.next())
            {                       
                listofitems.add(rs.getString(1));
            }
            return listofitems;
            
        } finally {            
            try {rs.close(); } catch (Exception e) { }
            try {st.close(); } catch (Exception e) { }
            try {dis(); } catch (Exception e) { }   
        }                                     
    }
     
     
     public ArrayList<Object>getIDs(String UserInfo) throws SQLException 
    {
         try {
            con();
            String sql = "SELECT id From table1 WHERE userinfo='"+UserInfo+"' ";
            st = conexion.createStatement();
            rs = st.executeQuery(sql);

            ArrayList<Object> listofitems = new ArrayList<Object>();                 

            while(rs.next())
            {                       
                listofitems.add(rs.getInt(1));
            }       
            return listofitems;
            
         } finally {
             
            try {rs.close(); } catch (Exception e) { }
            try {st.close(); } catch (Exception e) { }
            try {dis(); } catch (Exception e) { }   
         }
    }
     
    
    
}
