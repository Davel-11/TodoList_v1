package models;

public class modelsetget {

    private int id;
    private String importance;
    private String task;
    private String todo;
    private String details;
    private float budget;
    private String edate;
    private boolean complete;
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setImportance(String importance){
        this.importance = importance;
    }   
    public String getImportance(){
        return importance;
    }
    
    public void setTask(String task){
        this.task = task;
    }
    public String getTask(){
       return task; 
    }
    
    public void setTodo(String todo){
        this.todo = todo;
    }
    public String getTodo(){
        return todo;
    }
    
    public void setDetails(String details){
        this.details = details;
    }
    public String getDetails(){
        return details;
    }
    
    public void setBudget(float budget){
        this.budget = budget;
    }
    public float getBudget(){
        return budget;
    }
    
    public void setEdate(String edate){
        this.edate = edate;
    }
    public String getEdate(){
        return edate;
    }
    
    public void setComplete(boolean complete){
        this.complete = complete;        
    }
    public boolean getComplete(){
        return complete;
    }
    
}
