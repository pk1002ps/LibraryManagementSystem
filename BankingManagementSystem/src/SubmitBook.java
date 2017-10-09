import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;


public class SubmitBook extends javax.swing.JPanel implements ActionListener,FocusListener
{int i=0;
int a=0;
int b=0;
int book=0;
int quant=0;
int usn=0;
int u=0;
int check=0;
int w=0;int q=0;int e=0;int c=0;
String str3;
public void focusGained(FocusEvent arg0)
{
	
}
 public void focusLost(FocusEvent arg0) 
    {
	 if(arg0.getSource()==jTextField2)
       {
    	   String str1=jTextField1.getText();
    	   String str2=jTextField2.getText();
    	   str1=str1.trim();
    	   str2=str2.trim();
    	   if(str1.length()==0 || str2.length()==0)
    	   {
    		JOptionPane.showMessageDialog(this,"Please fill both fields!","Error",JOptionPane.ERROR_MESSAGE);   
    	   a++;
    	   }
    	   else
    	   {
    		   String query1="select * from login where usnno=?";
    		   //System.out.println(query1);
    		   DBInfo obj=new DBInfo();
    		   Connection con=obj.getConn();
    		   try
    		   {
    		   PreparedStatement ps=con.prepareStatement(query1);
    		   ps.setString(1,str1);
    		   ResultSet res=ps.executeQuery();
    		   while(res.next())
    		   {
    			   String usnno=res.getString("usnno");
    			   if(usnno.equals(str1))
    			   {
    				   usn++;
    				   jTextField10.setText(res.getString(4));
    			   }
    		   }
    		   }
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }	    		   
    		   
    	   String query="select * from book where bookid=?";
    	   try
    	   {
    		   
    		   PreparedStatement ps=con.prepareStatement(query);
    		   ps.setString(1,str2);
    		   ResultSet res=ps.executeQuery();
    		   while(res.next())
    		   {
    			   String bi=res.getString("bookid");
    			   str3=res.getString("quantity");
    			   if(bi.equals(str2))
    			   {	  
    				   book++;

    		   jTextField3.setText(res.getString(6));
    		   jTextField4.setText(res.getString(2));
    		   jTextField5.setText(res.getString(3));
    		   jTextField6.setText(res.getString(5));
    		   jTextField7.setText(res.getString(4));
    		   jTextField8.setText(res.getString(7));
    		   jTextField9.setText(res.getString(9));
    			}	    		   
    		   }
    		   //System.out.println(book);
			   if(usn==0&&book==0)
		       {
		    	   JOptionPane.showMessageDialog(this,"Entered  USN No and BookID is Wrong!","Error",JOptionPane.ERROR_MESSAGE);  
		       q++;}else
		    	   if(usn==0 && q==0)
		    	   {
		    		   JOptionPane.showMessageDialog(this,"Entered  USN No is Wrong!","Error",JOptionPane.ERROR_MESSAGE);    
		    	   w++;}else
		    		   if(book==0 && w==0 && q==0)
		    		   {
		    			   JOptionPane.showMessageDialog(this,"Entered BookID is Wrong!","Error",JOptionPane.ERROR_MESSAGE);  
		    		   e++;}
    		   
    	   }
    	   catch(Exception e)
    	   {
    		   e.printStackTrace();
    	   }	       
    	   }
       }
    }
    
	public void actionPerformed(ActionEvent arg0) 
	{	
		String date1 = null;
		String timeStamp;
		Date iss=null;
		Date sub=null;
		String str1=jTextField1.getText();
		str1=str1.trim();
		String str2=jTextField2.getText();
		//String str3=jTextField9.getText();
		System.out.println("total Books:="+str3);			
		str2=str2.trim();
		if(arg0.getSource()==jButton1)
		{
			if(str1.length()==0||str2.length()==0)
			{
				JOptionPane.showMessageDialog(this,"Please fill both fields!","Error",JOptionPane.ERROR_MESSAGE);  
			c++;
			}

	    	   else
	    	   {
	    		   String query="select * from login where usnno=?";
	    		   
	    		   
	    		   //String query3="update book set Quantity='"+quant1+"' where BookID='"+bookid+"' ";
	    		   
	    		   DBInfo obj=new DBInfo();
	    		   Connection con=obj.getConn();
	    		   try
	    		   {
	    		   PreparedStatement ps=con.prepareStatement(query);
	    		   ps.setString(1,str1);
	    		   ResultSet res=ps.executeQuery();
	    		   while(res.next())
	    		   {
	    			   String usnno=res.getString("usnno");
	    			   System.out.println(usnno);
	    			   if(usnno.equals(str1))
	    			   {
	    				   usn++;
	    				   jTextField10.setText(res.getString(4));
	    			   }
	    		   }		    		   
	    		   }
		    	   catch(Exception e)
		    	   {
		    		   e.printStackTrace();
		    	   }
	    	   
		
			if(usn==0)
    		   {
    			   JOptionPane.showMessageDialog(this,"Entered  USN No. is Wrong!!","Error",JOptionPane.ERROR_MESSAGE);  
 			       
    		   }
			else
			{
			System.out.println("Submit Button clicked");
			String USN=jTextField1.getText();
			String bookid=jTextField2.getText();
			
			String query1="select * from issuebooks";
			
			try
			{
				PreparedStatement ps1=con.prepareStatement(query1);
				ResultSet res=ps1.executeQuery();
				while(res.next())
				{
					String us=res.getString(1);
					String bi=res.getString(3);
					 
					if(str1.equals(us)  && str2.equals(bi))
					{
						check=1;
						
			  		}
				}
					if(check==0)	
					{
						JOptionPane.showMessageDialog(this,"This book is not Issued on this ID!!","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			
			if(check!=0)
			{ 
				String query5="Select *from issuebooks where USN_No='"+str1+"' and BOOK_ID='"+str2+"'";
				System.out.println(query5);
				try
				{
				PreparedStatement ps10=con.prepareStatement(query5);			      
				ResultSet res=ps10.executeQuery();
				while(res.next())
				{				
				 date1=res.getString(9);
				
				System.out.println("time:"+date1);
				
				}
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}				
				String query2="Delete from issuebooks where USN_No='"+str1+"' and BOOK_ID='"+str2+"'";
				  try
				  {
		              PreparedStatement ps=con.prepareStatement(query2);
		      
		              ps.executeUpdate();
		              i++;
		             
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
				  if(i!=0)
				  {		
					  quant=Integer.parseInt(str3);
					  System.out.println("previous quantity:="+quant);
					   quant=Integer.parseInt(str3)+1;
					  System.out.println("Now avl books:="+quant);
					  
					   
					   timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
					   System.out.println(timeStamp);
					   //Difference between dates
					   
					   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				 
						try {
							iss = format.parse(date1);
							sub = format.parse(timeStamp);
							
							long diff = sub.getTime() - iss.getTime();
							long diffDays = diff / (24 * 60 * 60 * 1000);
				 
							System.out.println(diffDays + " days");
							int m=(int)diffDays;
							System.out.print(m + " days");
							int v=m-15;
							if(v<=0)
							{
								JOptionPane.showMessageDialog(this,"              No Fine","Confirmation",JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(this,"              Rs. "+v+" Fined..","Warning",JOptionPane.WARNING_MESSAGE);
							}
				 
						} catch (Exception e)
						{
							e.printStackTrace();
						}		  
					  
					  JOptionPane.showMessageDialog(this, "Book has been Submitted...", "Success", JOptionPane.INFORMATION_MESSAGE);
					  jTextField1.setText("");
					  jTextField2.setText("");
					  jTextField3.setText("");
					  jTextField4.setText("");
					  jTextField5.setText("");
					  jTextField6.setText("");
					  jTextField7.setText("");
					  jTextField8.setText("");		  
					  
					  String quant1=String.valueOf(quant);
					  String query3="update book set Quantity='"+quant1+"' where BookID='"+bookid+"' ";
					  System.out.println(query3);
					  
				    	try
				    	{
				    	PreparedStatement ps1=con.prepareStatement(query3);					    	
				    	ps1.executeUpdate();
				    	}
				    	catch(Exception e1)
				    	{
				    		e1.printStackTrace();
				    	}						  
					  }  
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(this, "Book didn't Submitted", "Error", JOptionPane.ERROR_MESSAGE);
					  jTextField1.setText("");
					  jTextField2.setText("");
					  jTextField3.setText("");
					  jTextField4.setText("");
					  jTextField5.setText("");
					  jTextField6.setText("");
					  jTextField7.setText("");
					  jTextField8.setText("");	
				  }
		}
		}
	    }
			book=0;usn=0;
			a=0;q=0;w=0;
			e=0;
		
				  if(arg0.getSource()==jButton2)
					{
						  jTextField1.setText("");
						  jTextField2.setText("");
						  jTextField3.setText("");
						  jTextField4.setText("");
						  jTextField5.setText("");
						  jTextField6.setText("");
						  jTextField7.setText("");
						  jTextField8.setText("");
					}
		}
	
	 public SubmitBook(String str) 
	 {
	     
		 initComponents();
		 jButton1.addActionListener(this);
	     jButton2.addActionListener(this);
	     jTextField1.addActionListener(this);
	     jTextField2.addFocusListener(this);
	     
	     jTextField3.setEditable(false);
	     jTextField4.setEditable(false);
	     jTextField5.setEditable(false);
	     jTextField6.setEditable(false);
	     jTextField7.setEditable(false);
	     jTextField8.setEditable(false);
	    }




/** This method is called from within the constructor to
* initialize the form.
* WARNING: Do NOT modify this code. The content of this method is
* always regenerated by the Form Editor.
*/

//<editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents() {

jLabel1 = new javax.swing.JLabel();
jTextField1 = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
jTextField2 = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
jTextField3 = new javax.swing.JTextField();
jLabel4 = new javax.swing.JLabel();
jTextField4 = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
jTextField5 = new javax.swing.JTextField();
jLabel6 = new javax.swing.JLabel();
jTextField6 = new javax.swing.JTextField();
jLabel7 = new javax.swing.JLabel();
jTextField7 = new javax.swing.JTextField();
jLabel8 = new javax.swing.JLabel();
jTextField8 = new javax.swing.JTextField();
jTextField9 = new javax.swing.JTextField();
jTextField10 = new javax.swing.JTextField();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();


jLabel1.setText("Enter USN No."); // NOI18N
jLabel1.setName("jLabel1"); // NOI18N


jTextField1.setName("jTextField1"); // NOI18N

jLabel2.setText("Enter Book ID"); // NOI18N
jLabel2.setName("jLabel2"); // NOI18N


jTextField2.setName("jTextField2"); // NOI18N

jLabel3.setText("ISBN No."); // NOI18N
jLabel3.setName("jLabel3"); // NOI18N


jTextField3.setName("jTextField3"); // NOI18N

jLabel4.setText("Book Title"); // NOI18N
jLabel4.setName("jLabel4"); // NOI18N


jTextField4.setName("jTextField4"); // NOI18N

jLabel5.setText("Author"); // NOI18N
jLabel5.setName("jLabel5"); // NOI18N


jTextField5.setName("jTextField5"); // NOI18N

jLabel6.setText("Subject"); // NOI18N
jLabel6.setName("jLabel6"); // NOI18N


jTextField6.setName("jTextField6"); // NOI18N

jLabel7.setText("Publication"); // NOI18N
jLabel7.setName("jLabel7"); // NOI18N


jTextField7.setName("jTextField7"); // NOI18N

jLabel8.setText("Category"); // NOI18N
jLabel8.setName("jLabel8"); // NOI18N


jTextField8.setName("jTextField8"); // NOI18N
jTextField9.setName("jTextField9");
jTextField10.setName("jTextField10");

jButton1.setText("Submit"); // NOI18N
jButton1.setName("jButton1"); // NOI18N

jButton2.setText("RESET"); // NOI18N
jButton2.setName("jButton2"); // NOI18N

javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
this.setLayout(mainPanelLayout);
mainPanelLayout.setHorizontalGroup(
    mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(mainPanelLayout.createSequentialGroup()
        .addGap(32, 32, 32)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(30, 30, 30)))
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addGap(103, 103, 103))))
    .addGroup(mainPanelLayout.createSequentialGroup()
        .addGap(188, 188, 188)
        .addComponent(jButton1)
        .addGap(37, 37, 37)
        .addComponent(jButton2)
        .addContainerGap(204, Short.MAX_VALUE))
);
mainPanelLayout.setVerticalGroup(
    mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(mainPanelLayout.createSequentialGroup()
        .addGap(34, 34, 34)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(44, 44, 44)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jButton1)
            .addComponent(jButton2))
        .addContainerGap(46, Short.MAX_VALUE))
);


}// </editor-fold>

//Variables declaration - do not modify
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JLabel jLabel8;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
private javax.swing.JTextField jTextField3;
private javax.swing.JTextField jTextField4;
private javax.swing.JTextField jTextField5;
private javax.swing.JTextField jTextField6;
private javax.swing.JTextField jTextField7;
private javax.swing.JTextField jTextField8;
private javax.swing.JTextField jTextField9;
private javax.swing.JTextField jTextField10;

}
