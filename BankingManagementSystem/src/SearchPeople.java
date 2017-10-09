import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class SearchPeople extends javax.swing.JPanel implements ActionListener,FocusListener
{
	int success=0;
	int blank=0;
	int invalid=0;
	 public void focusGained(FocusEvent arg0)
	 {	
		 
	 }
	 public void focusLost(FocusEvent arg0) 
	    {
	       if(arg0.getSource()==jTextField1)
	       {
	    	   String str1=jTextField1.getText();
	    	   if(str1.length()==0)
	    	   {
	    		   JOptionPane.showMessageDialog(this,"Please Enter the USN No.!",
	    				   "Error",JOptionPane.ERROR_MESSAGE);
	    		   blank++;
	    	   }
	    	   else
	    	   {
	    	   String query="select * from login where USNNo=?";
	    	   DBInfo obj=new DBInfo();
	    	   Connection con=obj.getConn();
	    	   try
	    	   {
	    		   PreparedStatement ps=con.prepareStatement(query);
	    		   ps.setString(1, str1);
	    		   ResultSet res=ps.executeQuery();
	    		   res.next();
	    		   jTextField2.setText(res.getString(1));
	    		   jTextField3.setText(res.getString(2));
	    		   jTextField4.setText(res.getString(3));
	    		   jTextField5.setText(res.getString(4));
	    		   jTextField6.setText(res.getString(5));
	    		   jTextField7.setText(res.getString(6));
	    		   jTextField8.setText(res.getString(7));
	    		   jTextField9.setText(res.getString(8));
	    		   jTextField10.setText(res.getString(9));
	    		   jTextField11.setText(res.getString(10));
	    		   jTextField12.setText(res.getString(11));
	    		   jTextField13.setText(res.getString(12));
	    		   jTextField14.setText(res.getString(13));
	    		   jTextField15.setText(res.getString(14));
	    		   jTextField16.setText(res.getString(15));
	    		   jTextField17.setText(res.getString(16));
	    		   success++;
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	    	   if(success==0)
		       {
		    		   JOptionPane.showMessageDialog(this,"Entered USN No. is Invalid!",
		    				   "Error",JOptionPane.ERROR_MESSAGE);
		    		   jTextField1.setText("");
		    		   invalid++;
		       }
	    	   }
	    	   }
	    }
	    
		public void actionPerformed(ActionEvent arg0) 
		{
			int m=0;
			if(arg0.getSource()==jButton3)
			{
				String str1=jTextField1.getText();
				if((str1.length())==0)
				{
				JOptionPane.showMessageDialog(this,"Please Enter the USN No.!",
	    				   "Error",JOptionPane.ERROR_MESSAGE);
				}else
				{
				jTextField17.setEditable(true);jTextField2.setEditable(true);
			     jTextField3.setEditable(true);jTextField4.setEditable(false);
			     jTextField5.setEditable(false);jTextField6.setEditable(true);
			     jTextField7.setEditable(true);jTextField8.setEditable(true);
			     jTextField9.setEditable(true);jTextField10.setEditable(true);
			     jTextField11.setEditable(true);jTextField12.setEditable(true);
			     jTextField13.setEditable(true);jTextField14.setEditable(true);
			     jTextField15.setEditable(true);jTextField16.setEditable(true);
			}
			}
			if(arg0.getSource()==jButton4)
			{
				String str1=jTextField1.getText();
				if((str1.length())==0)
				{
				JOptionPane.showMessageDialog(this,"Please Enter the USN No.!",
	    				   "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				String un=jTextField2.getText();
				String pass=jTextField3.getText();
				String title=jTextField6.getText();
				String fn=jTextField7.getText();
				String ln=jTextField8.getText();
				String gender=jTextField9.getText();
				String dob=jTextField10.getText();
				String fathern=jTextField11.getText();
				String adl1=jTextField12.getText();
				String adl2=jTextField13.getText();
				String ci=jTextField14.getText();
				String stat=jTextField15.getText();
				String pin=jTextField16.getText();
				String cont=jTextField17.getText();
				
				DBInfo obj=new DBInfo();
		    	Connection con=obj.getConn();
				String query0="update login set Username='"+un+"',Password='"+pass+"',Title='"+title+"',FIRST_NAME='"+fn+"',LAST_NAME='"+ln+"',GENDER='"+gender+"',DateOfBirth='"+dob+"',FatherName='"+fathern+"',AddressLine1='"+adl1+"',AddressLine2='"+adl2+"',City='"+ci+"',State='"+stat+"',PinCode='"+pin+"',ContactNo='"+cont+"'where USNNo='"+str1+"'";
			System.out.println(query0);
			try
	    	{
				
	    	PreparedStatement ps5=con.prepareStatement(query0);
	    	ps5.executeUpdate();
	    	m++;
	    	}
	    	catch(Exception e1)
	    	{
	    		e1.printStackTrace();
	    	}
			if(m!=0)
			{
				JOptionPane.showMessageDialog(this,"User Updated Successfully..", "Updated", JOptionPane.INFORMATION_MESSAGE);
				jTextField1.setText("");jTextField2.setText("");
				  jTextField3.setText("");jTextField4.setText("");
				  jTextField5.setText("");jTextField6.setText("");
				  jTextField7.setText("");jTextField8.setText("");
				  jTextField9.setText("");jTextField10.setText("");
				  jTextField11.setText("");jTextField12.setText("");
				  jTextField13.setText("");jTextField14.setText("");
				  jTextField15.setText("");jTextField16.setText("");
				  jTextField17.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "User could not be Updated!!!", "Error", JOptionPane.ERROR_MESSAGE);
			}
				}
			}
			
			if(arg0.getSource()==jButton2)
			{
				  jTextField1.setText("");jTextField2.setText("");
				  jTextField3.setText("");jTextField4.setText("");
				  jTextField5.setText("");jTextField6.setText("");
				  jTextField7.setText("");jTextField8.setText("");
				  jTextField9.setText("");jTextField10.setText("");
				  jTextField11.setText("");jTextField12.setText("");
				  jTextField13.setText("");jTextField14.setText("");
				  jTextField15.setText("");jTextField16.setText("");
				  jTextField17.setText("");
			}
			if(arg0.getSource()==jButton1)
			{	
				System.out.println("Search button clicked");
					String str1=jTextField1.getText();
					if((str1.length())==0)
					{
					JOptionPane.showMessageDialog(this,"Please Enter the USN No.!",
		    				   "Error",JOptionPane.ERROR_MESSAGE);
					}
				else
				{
					
				}
				}				
			}
		
		 public SearchPeople() 
		 {
		     
			 initComponents();
			 jButton1.addActionListener(this);
		     jButton2.addActionListener(this);
		     jButton3.addActionListener(this);
		     jButton4.addActionListener(this);
		     jTextField1.addFocusListener(this);		     
		     
		     jTextField17.setEditable(false);jTextField2.setEditable(false);
		     jTextField3.setEditable(false);jTextField4.setEditable(false);
		     jTextField5.setEditable(false);jTextField6.setEditable(false);
		     jTextField7.setEditable(false);jTextField8.setEditable(false);
		     jTextField9.setEditable(false);jTextField10.setEditable(false);
		     jTextField11.setEditable(false);jTextField12.setEditable(false);
		     jTextField13.setEditable(false);jTextField14.setEditable(false);
		     jTextField15.setEditable(false);jTextField16.setEditable(false);
		    }

		 /** This method is called from within the constructor to
		     * initialize the form.
		     * WARNING: Do NOT modify this code. The content of this method is
		     * always regenerated by the Form Editor.
		     */
		    @SuppressWarnings("unchecked")
		    // <editor-fold defaultstate="collapsed" desc="Generated Code">
		    private void initComponents() 
		    {
		        jLabel1 = new javax.swing.JLabel();
		        jTextField1 = new javax.swing.JTextField();
		        jButton1 = new javax.swing.JButton();
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
		        jLabel9 = new javax.swing.JLabel();
		        jTextField9 = new javax.swing.JTextField();
		        jLabel10 = new javax.swing.JLabel();
		        jTextField10 = new javax.swing.JTextField();
		        jLabel11 = new javax.swing.JLabel();
		        jTextField11 = new javax.swing.JTextField();
		        jLabel12 = new javax.swing.JLabel();
		        jTextField12 = new javax.swing.JTextField();
		        jLabel13 = new javax.swing.JLabel();
		        jTextField13 = new javax.swing.JTextField();
		        jLabel14 = new javax.swing.JLabel();
		        jTextField14 = new javax.swing.JTextField();
		        jLabel15 = new javax.swing.JLabel();
		        jTextField15 = new javax.swing.JTextField();
		        jLabel16 = new javax.swing.JLabel();
		        jTextField16 = new javax.swing.JTextField();
		        jLabel17 = new javax.swing.JLabel();
		        jTextField17 = new javax.swing.JTextField();
		        jButton2 = new javax.swing.JButton();
		        jLabel18 = new javax.swing.JLabel();
		        jButton3 = new javax.swing.JButton();
		        jButton4 = new javax.swing.JButton();
		        
		        jLabel1.setText("Enter USN No."); // NOI18N
		        jLabel1.setName("jLabel1"); // NOI18N

		        
		        jTextField1.setName("jTextField1"); // NOI18N

		        jButton1.setText("SEARCH"); // NOI18N
		        jButton1.setName("jButton1"); // NOI18N

		        jLabel2.setText("Username"); // NOI18N
		        jLabel2.setName("jLabel2"); // NOI18N

		        
		        jTextField2.setName("jTextField2"); // NOI18N

		        jLabel3.setText("Password"); // NOI18N
		        jLabel3.setName("jLabel3"); // NOI18N

		        
		        jTextField3.setName("jTextField3"); // NOI18N

		        jLabel4.setText("UserType"); // NOI18N
		        jLabel4.setName("jLabel4"); // NOI18N

		        
		        jTextField4.setName("jTextField4"); // NOI18N

		        jLabel5.setText("USN No."); // NOI18N
		        jLabel5.setName("jLabel5"); // NOI18N

		       
		        jTextField5.setName("jTextField5"); // NOI18N

		        jLabel6.setText("Title"); // NOI18N
		        jLabel6.setName("jLabel6"); // NOI18N

		        
		        jTextField6.setName("jTextField6"); // NOI18N

		        jLabel7.setText("First Name"); // NOI18N
		        jLabel7.setName("jLabel7"); // NOI18N

		       
		        jTextField7.setName("jTextField7"); // NOI18N

		        jLabel8.setText("Last Name"); // NOI18N
		        jLabel8.setName("jLabel8"); // NOI18N

		        
		        jTextField8.setName("jTextField8"); // NOI18N

		        jLabel9.setText("Gender"); // NOI18N
		        jLabel9.setName("jLabel9"); // NOI18N

		       
		        jTextField9.setName("jTextField9"); // NOI18N

		        jLabel10.setText("DOB(dd/mm/yy)"); // NOI18N
		        jLabel10.setName("jLabel10"); // NOI18N

		        
		        jTextField10.setName("jTextField10"); // NOI18N

		        jLabel11.setText("Father's Name"); // NOI18N
		        jLabel11.setName("jLabel11"); // NOI18N

		       
		        jTextField11.setName("jTextField11"); // NOI18N

		        jLabel12.setText("Address Line1"); // NOI18N
		        jLabel12.setName("jLabel12"); // NOI18N

		        
		        jTextField12.setName("jTextField12"); // NOI18N

		        jLabel13.setText("Address Line2"); // NOI18N
		        jLabel13.setName("jLabel13"); // NOI18N

		        
		        jTextField13.setName("jTextField13"); // NOI18N

		        jLabel14.setText("City"); // NOI18N
		        jLabel14.setName("jLabel14"); // NOI18N

		       
		        jTextField14.setName("jTextField14"); // NOI18N

		        jLabel15.setText("State"); // NOI18N
		        jLabel15.setName("jLabel15"); // NOI18N

		       
		        jTextField15.setName("jTextField15"); // NOI18N

		        jLabel16.setText("Pincode"); // NOI18N
		        jLabel16.setName("jLabel16"); // NOI18N

		        
		        jTextField16.setName("jTextField16"); // NOI18N

		        jLabel17.setText("Contact No."); // NOI18N
		        jLabel17.setName("jLabel17"); // NOI18N

		        
		        jTextField17.setName("jTextField17"); // NOI18N

		        jButton2.setText("RESET"); // NOI18N
		        jButton2.setName("jButton2"); // NOI18N

		        jLabel18.setText("                 SEARCH/UPDATE USER"); // NOI18N
		        jLabel18.setName("jLabel18"); // NOI18N

		        jButton3.setText("Update??"); // NOI18N
		        jButton3.setName("jButton3"); // NOI18N

		        jButton4.setText("SAVE"); // NOI18N
		        jButton4.setName("jButton4"); // NOI18N

		        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
		        this.setLayout(mainPanelLayout);
		        mainPanelLayout.setHorizontalGroup(
		            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(mainPanelLayout.createSequentialGroup()
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(mainPanelLayout.createSequentialGroup()
		                        .addGap(86, 86, 86)
		                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addGap(18, 18, 18)
		                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addGap(58, 58, 58)
		                        .addComponent(jButton1)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
		                    .addGroup(mainPanelLayout.createSequentialGroup()
		                        .addGap(50, 50, 50)
		                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                            .addComponent(jTextField16)
		                            .addComponent(jTextField14)
		                            .addComponent(jTextField12)
		                            .addComponent(jTextField10)
		                            .addComponent(jTextField8)
		                            .addComponent(jTextField6)
		                            .addComponent(jTextField4)
		                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
		                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
		                        .addGap(41, 41, 41)
		                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                            .addGroup(mainPanelLayout.createSequentialGroup()
		                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                                    .addComponent(jTextField17)
		                                    .addComponent(jTextField15)
		                                    .addComponent(jTextField13)
		                                    .addComponent(jTextField11)
		                                    .addComponent(jTextField9)
		                                    .addComponent(jTextField7)
		                                    .addComponent(jTextField5)
		                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
		                            .addComponent(jButton4))))
		                .addGap(26, 26, 26))
		            .addGroup(mainPanelLayout.createSequentialGroup()
		                .addGap(214, 214, 214)
		                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addContainerGap(206, Short.MAX_VALUE))
		        );
		        mainPanelLayout.setVerticalGroup(
		            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(mainPanelLayout.createSequentialGroup()
		                .addGap(7, 7, 7)
		                .addComponent(jLabel18)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jButton1)
		                    .addComponent(jButton2))
		                .addGap(18, 18, 18)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(jLabel12)
		                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(jLabel13)
		                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(jLabel14)
		                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(jLabel15)
		                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(jLabel16)
		                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(jLabel17)
		                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
		                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jButton3)
		                    .addComponent(jButton4))
		                .addGap(25, 25, 25))
		        );
		    }// </editor-fold>

		    // Variables declaration - do not modify
		    private javax.swing.JButton jButton1;
		    private javax.swing.JButton jButton2;
		    private javax.swing.JButton jButton3;
		    private javax.swing.JButton jButton4;
		    private javax.swing.JLabel jLabel1;
		    private javax.swing.JLabel jLabel10;
		    private javax.swing.JLabel jLabel11;
		    private javax.swing.JLabel jLabel12;
		    private javax.swing.JLabel jLabel13;
		    private javax.swing.JLabel jLabel14;
		    private javax.swing.JLabel jLabel15;
		    private javax.swing.JLabel jLabel16;
		    private javax.swing.JLabel jLabel17;
		    private javax.swing.JLabel jLabel18;
		    private javax.swing.JLabel jLabel2;
		    private javax.swing.JLabel jLabel3;
		    private javax.swing.JLabel jLabel4;
		    private javax.swing.JLabel jLabel5;
		    private javax.swing.JLabel jLabel6;
		    private javax.swing.JLabel jLabel7;
		    private javax.swing.JLabel jLabel8;
		    private javax.swing.JLabel jLabel9;
		    private javax.swing.JTextField jTextField1;
		    private javax.swing.JTextField jTextField10;
		    private javax.swing.JTextField jTextField11;
		    private javax.swing.JTextField jTextField12;
		    private javax.swing.JTextField jTextField13;
		    private javax.swing.JTextField jTextField14;
		    private javax.swing.JTextField jTextField15;
		    private javax.swing.JTextField jTextField16;
		    private javax.swing.JTextField jTextField17;
		    private javax.swing.JTextField jTextField2;
		    private javax.swing.JTextField jTextField3;
		    private javax.swing.JTextField jTextField4;
		    private javax.swing.JTextField jTextField5;
		    private javax.swing.JTextField jTextField6;
		    private javax.swing.JTextField jTextField7;
		    private javax.swing.JTextField jTextField8;
		    private javax.swing.JTextField jTextField9;
		    // End of variables declaration
}
