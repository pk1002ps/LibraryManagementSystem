import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class GetValuesFromDB 
{
	Connection con;
	ResultSet res;
	String query;
     public GetValuesFromDB()
     {
    	 DBInfo obj=new DBInfo();
    	 con=obj.getConn();
    	 
     }
     public Vector<String> getAllSubjects()
     {
    	 Vector<String> vector=new Vector<>();
    	 query="select subject from subject";
    	 try
    	 {
    		 PreparedStatement ps=con.prepareStatement(query);
    		 res=ps.executeQuery();
    		 while(res.next())
    		 {
    			 String name=res.getString(1);
    			 vector.add(name);
    		 }
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
          return vector;
    			 
    	 
     }
	public Vector<String> getAllCategories() 
	{
		Vector<String> vector=new Vector<>();
		query="select category from category";
		try
   	 {
   		 PreparedStatement ps=con.prepareStatement(query);
   		 res=ps.executeQuery();
   		 while(res.next())
   		 {
   			 String name=res.getString(1);
   			 vector.add(name);
   		 }
   	 }
   	 catch(Exception e)
   	 {
   		 e.printStackTrace();
   	 }
         return vector;
	}
}
