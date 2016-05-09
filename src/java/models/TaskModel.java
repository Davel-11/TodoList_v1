package models;

import java.sql.*;
import java.util.ArrayList;

public class TaskModel extends model_database_con {   
     
    //done
    public void addNewTask(String UserInfo, String importance, String task, String todo, String details, Float budget, Date edate)throws SQLException 
    {
        con();
        String sql = "INSERT INTO table2 (userinfo, important, task, todo, details, budget, edate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        pst = conexion.prepareStatement(sql);
        pst.setString(1, UserInfo);
        pst.setString(2, importance);
        pst.setString(3,task);
        pst.setString(4,todo);
        pst.setString(5, details);
        pst.setFloat(6, budget);        
        pst.setDate(7, edate);        
        pst.executeUpdate(); 
               
        pst.close();
        dis();
    }
    
    //done
    public void deleteTask(String UserInfo, int id) throws SQLException {
        con();
        String sql = "delete from table2 where userinfo='"+UserInfo+"' AND id = '"+id+"' "; 
        st = conexion.createStatement();
        st.executeUpdate(sql);
        
        st.close();
        dis();
    }
    
    //done
    public void editTask(int id, String importance, String task, String todo, String details, Float budget, Date edate) throws SQLException {
        con();
        String sql = "UPDATE table2 SET  important = ?, task = ?, todo = ?, details = ?, budget = ?, edate = ? WHERE id='"+id+"' ";
        
        PreparedStatement pst = conexion.prepareStatement(sql);
        pst.setString (1, importance);
        pst.setString(2, task);
        pst.setString(3, todo);
        pst.setString(4, details);
        pst.setFloat(5, budget);
        pst.setDate(6, edate);
        
        pst.executeUpdate();
        
        pst.close();
        dis();
    } 

    public ArrayList<Object>CurrentTask(String UserInfo) throws SQLException {
       con();
       String sql = "SELECT task FROM table2 WHERE userinfo='"+UserInfo+"' GROUP BY task";
       st = conexion.createStatement();
       rs = st.executeQuery(sql);
       
       ArrayList<Object> currentTaskL = new ArrayList<Object>();
       
       while (rs.next()){
         currentTaskL.add(rs.getString(1));
       }
       
       rs.close();
       st.close();
       dis();
       return currentTaskL;
   }
    
}
