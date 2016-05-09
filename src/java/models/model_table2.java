package models;
import java.sql.SQLException;

import java.util.LinkedList;

public class model_table2 extends model_database_con {
    
      public LinkedList<modelsetget> getTasks(String UserInfo) throws SQLException
    
      {
         LinkedList<modelsetget> ltasks = new LinkedList<modelsetget>();
         
         try {                
                con();
                st = conexion.createStatement();
                rs  = st.executeQuery("select * from table2 WHERE userinfo='"+UserInfo+"' ");

                while (rs.next()){
                    modelsetget datos = new modelsetget();
                    datos.setId(rs.getInt("id"));
                    datos.setImportance(rs.getString("important"));
                    datos.setTask(rs.getString("task"));
                    datos.setTodo(rs.getString("todo"));
                    datos.setDetails(rs.getString("details"));
                    datos.setBudget(rs.getFloat("budget"));
                    datos.setEdate(rs.getString("edate"));
                    datos.setComplete(rs.getBoolean("complete"));
                    ltasks.add(datos);
                }
                
                rs.close();
                st.close();
                dis();
         }catch (Exception e){
            e.printStackTrace();
         }         
         return ltasks;
      }        
      
      public LinkedList<modelsetget> getTasksF(String UserInfo, String task) throws SQLException
    
      {
         LinkedList<modelsetget> ltasks = new LinkedList<modelsetget>();
         
         try {
                con();
                st = conexion.createStatement();
                rs  = st.executeQuery("select * from table2 WHERE userinfo='"+UserInfo+"' and task='"+task+"' ");

                while (rs.next()){
                    modelsetget datos = new modelsetget();
                    datos.setId(rs.getInt("id"));
                    datos.setImportance(rs.getString("important"));
                    datos.setTask(rs.getString("task"));
                    datos.setTodo(rs.getString("todo"));
                    datos.setDetails(rs.getString("details"));
                    datos.setBudget(rs.getFloat("budget"));
                    datos.setEdate(rs.getString("edate"));
                    datos.setComplete(rs.getBoolean("complete"));
                    ltasks.add(datos);
                }
                
                rs.close();
                st.close();
                dis();
                
         }catch (Exception e){
            e.printStackTrace();
         }         
         return ltasks;
      }     
      
      public LinkedList<modelsetget> Edit(String UserInfo, int id) throws SQLException
    
      {
         LinkedList<modelsetget> pre_list = new LinkedList<modelsetget>();
         
         try {
                con();
                st = conexion.createStatement();
                rs  = st.executeQuery("SELECT * FROM table2 WHERE userinfo='"+UserInfo+"' AND id='"+id+"' ");

                while (rs.next()){
                    modelsetget datos = new modelsetget();
                    datos.setId(rs.getInt("id"));
                    datos.setImportance(rs.getString("important"));
                    datos.setTask(rs.getString("task"));
                    datos.setTodo(rs.getString("todo"));
                    datos.setDetails(rs.getString("details"));
                    datos.setBudget(rs.getFloat("budget"));
                    datos.setEdate(rs.getString("edate"));
                    datos.setComplete(rs.getBoolean("complete"));
                    pre_list.add(datos);
                }
                rs.close();
                st.close();
                dis();
         }catch (Exception e){
            e.printStackTrace();
         }         
         return pre_list;
      }  
      
}
