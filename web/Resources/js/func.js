$(document).ready(function() 
    { 
        $("#myTable").tablesorter(); 
    } 
); 
    
    
function deleting(url)

{
    if(confirm("Delete this Task?"))
    {
        window.location=url;
    }
}

