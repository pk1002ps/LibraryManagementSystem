import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JOptionPane;


public class DemoDB 
{
	Connection con;
	ResultSet res;
	String query;
	ResultSetMetaData rsmd;
	int colcount;
	public DemoDB(String query) 
	{
	  DBInfo obj=new DBInfo();
	  con=obj.getConn();
	  this.query=query;
	  System.out.println(query);
	}
   public Vector<String> getTableHeader()
   {
	   Vector<String> header=new Vector<>();
	   try
	   {
	   PreparedStatement ps=con.prepareStatement(query);
	   res=ps.executeQuery();
	   rsmd=res.getMetaData();
	   
	   colcount=rsmd.getColumnCount();//total no of columns in database
	   for(int i=1;i<=colcount;i++)
	   {
		//adding columns name into vector
		   header.add(rsmd.getColumnName(i));
	  	   
	   }	   
	   res.close();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
	   return header;
   }
   public Vector<Vector<String>>  getTableRecords()
   {
	   int k=0;
	   Vector<Vector<String>> completeRecords=new Vector<>();//this is to store complete database recods in form of vector
	   try
	   {
		   PreparedStatement ps=con.prepareStatement(query);
		   res=ps.executeQuery();
	     while(res.next())
	      {
		    Vector<String> singleRow=new Vector<>();
		    for(int i=1;i<=colcount;i++)
		    {
		    
		      singleRow.add(res.getString(i));
		      
		    }		    
		    completeRecords.add(singleRow);
		    k++;
	      }	
	     
	     System.out.println(k);
	     
	     res.close();	     
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return completeRecords;
   }
}
