import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Reg extends JPanel implements ActionListener,ItemListener
{ int user=0;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	JTextField t1,t4,t6,t7,t9,t10,t11,t12,t13,t14,t15,t16;
	JPasswordField p;
	JButton b1,b2;
	JComboBox<String> c;
	JComboBox<String>c1;
	JComboBox<String>c2;
	String s1="";
	String s2="";
	String s3="";
	public Reg(String str)
	{
		
		setLayout(null);
		JLabel l=new JLabel(new ImageIcon("reghere.jpg"));
		l.setBounds(250, 20, 200, 50);
		add(l);
				
		l1=new JLabel("Username");
		l1.setBounds(125, 90, 100, 20);
		
		t1=new JTextField(15);
		t1.setBounds(225, 90, 100, 20);
		
		l2=new JLabel("Password");
		l2.setBounds(350, 90, 100, 20);
		
		p=new JPasswordField(15);
		p.setBounds(435, 90, 100, 20);
		
		l3=new JLabel("User Type");
		l3.setBounds(125, 115, 100, 20);
		
		String item[]={"Select","Admin","Student"};
        c=new JComboBox<String>(item);
		c.setBounds(225, 115, 100, 20);
		
		l4=new JLabel("USN No.");
		l4.setBounds(350, 115, 100, 20);
		
		t4=new JTextField(15);
		t4.setBounds(435, 115, 100, 20);
		
		l16=new JLabel("Title");
		l16.setBounds(125,140,100, 20);
		
		String item1[]={"Select","Mr.","Mrs."};
		c1=new JComboBox<String>(item1);
		c1.setBounds(225, 140, 100, 20);
		
		l5=new JLabel("First Name");
		l5.setBounds(350, 140, 100, 20);
		 
		t6=new JTextField(15);
		t6.setBounds(435, 140, 100, 20);
		
		l6=new JLabel("Last Name");
		l6.setBounds(125, 165, 100, 20);
		
		t7=new JTextField(15);
		t7.setBounds(225, 165, 100, 20);
		
		l7=new JLabel("Gender");
		l7.setBounds(350, 165, 70, 20);
		
		String item2[]={"Select","Male","Female"};
		c2=new JComboBox<String>(item2);
		c2.setBounds(435, 165, 100, 20);
		
		l8=new JLabel("DOB(dd/mm/yyyy)");
		l8.setBounds(125, 190, 100, 20);
		
		t9=new JTextField(15);
		t9.setBounds(225, 190, 100, 20);
		
		l9=new JLabel("Father's Name");
		l9.setBounds(350, 190, 100, 20);
		
		t10=new JTextField(15);
		t10.setBounds(435, 190, 100, 20);
		 
		l10=new JLabel("Address Line1");
		l10.setBounds(125, 215, 100, 20);
		 
		t11=new JTextField(15);
		t11.setBounds(225, 215, 100, 20);
		
		l11=new JLabel("Address Line2");
		l11.setBounds(350, 215, 100, 20);
		 
		t12=new JTextField(15);
		t12.setBounds(435, 215, 100, 20);
		
		l12=new JLabel("City");
		l12.setBounds(125, 240, 100, 20);
		 
		t13=new JTextField(15);
		t13.setBounds(225,240, 100, 20);
		
		l13=new JLabel("State");
		l13.setBounds(350, 240, 100, 20);
		
		t14=new JTextField(15);
		t14.setBounds(435, 240, 100, 20);
		
		l14=new JLabel("Pin Code");
		l14.setBounds(125,265, 100, 20);
		
		t15=new JTextField(15);
		t15.setBounds(225, 265, 100, 20);
		
		l15=new JLabel("Contact No.");
		l15.setBounds(350, 265, 100, 20);
		
		t16=new JTextField(15);
		t16.setBounds(435, 265, 100, 20);
		
		b1=new JButton("Sign Up");
		b1=new JButton(new ImageIcon("signup.png"));
		b1.setBounds(270,310, 80, 30);
		
		b2=new JButton("Reset");
		b2=new JButton(new ImageIcon("reset.jpg"));
		b2.setBounds(370, 310,80,30);
		
		add(l1);add(t1);add(l2);add(p);add(l3);add(c);add(l4);add(t4);add(l16);
		add(c1);add(l5);
		add(t6);add(l6);add(t7);add(l7);add(c2);add(l8);add(t9);add(l9);add(t10);
		add(l10);add(t11);add(l11);add(t12);add(l12);
		add(t13);add(l13);add(t14);add(l14);add(t15);add(l15);add(t16);
		add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		c.addItemListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
	}
		
		@SuppressWarnings("unused")
		private Component getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
			public void itemStateChanged(ItemEvent ie) 
		   {
			if(ie.getSource()==c)
			{
			 s1=(String)c.getSelectedItem();
	
			//System.out.println("str is:"+str);
			}
			if(ie.getSource()==c1)
			{
			s2=(String)c1.getSelectedItem();
			//System.out.println("str1 is:"+str1);
			}
			if(ie.getSource()==c2)
			{			
			s3=(String)c2.getSelectedItem();
			//System.out.println("str2 is:"+str2);
			}
			}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		int i=0;

		if(ae.getSource()==b1)
		{
			String str1=t1.getText();
			String str2=p.getText();
			
			String str3=t4.getText();
			String str4=t6.getText();
			String str5=t7.getText();
			
			String str6=t9.getText();
			String str7=t10.getText();
			String str8=t11.getText();
			String str9=t12.getText();
			String str10=t13.getText();
			String str11=t14.getText();
			String str12=t15.getText();
			String str13=t16.getText();
			if(s1.length()==0||s2.length()==0||s3.length()==0||str1.length()==0 || 
				str2.length()==0|| str3.length()==0 || str4.length()==0||
				str5.length()==0|| str6.length()==0 || str7.length()==0|| str8.length()==0||
				str9.length()==0|| str10.length()==0|| str11.length()==0|| str12.length()==0||
				str13.length()==0)
			{
				JOptionPane.showMessageDialog(this,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
			
			String query1="Select * from login where Username=? ";
			DBInfo obj=new DBInfo();
			Connection con=obj.getConn();
			System.out.println(query1);
			try
			{
				PreparedStatement ps1=con.prepareStatement(query1);
				ps1.setString(1, str1);
				ResultSet res=ps1.executeQuery();
	    		   while(res.next())
	    		   {
	    			   String username=res.getString("Username");
	    			   System.out.println(username);
	    			   if(username.equals(str1))
	    			   {
	    				   user++;
	    				   //jTextField10.setText(res.getString(4));
	    			   }
	    		   }		    		   
			}
			catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
			if(user!=0)
			{
				JOptionPane.showMessageDialog(this,"Entered  Username already exist!!","Error",JOptionPane.ERROR_MESSAGE);  
				t1.setText("");
				p.setText("");
				t4.setText("");
				t6.setText("");
				t7.setText("");
				t9.setText("");
				t10.setText("");
				t11.setText("");
				t12.setText("");
				t13.setText("");
				t14.setText("");
				t15.setText("");
				t16.setText("");
				c.setSelectedIndex(0);
				c1.setSelectedIndex(0);
				c2.setSelectedIndex(0);
			}
			else			
			{
			String query="Insert into login values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try 
			{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, str1);
				ps.setString(2, str2);
				ps.setString(3,s1 );
				ps.setString(4,str3);
				ps.setString(5,s2);
				ps.setString(6, str4);
				ps.setString(7, str5);
				ps.setString(8,s3 );
				ps.setString(9, str6);
				ps.setString(10, str7);
				ps.setString(11, str8);
				ps.setString(12, str9);
				ps.setString(13, str10);
				ps.setString(14, str11);
				ps.setString(15, str12);
				ps.setString(16, str13);
					
				ps.executeUpdate();
				i++;
			
			} 
			catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(i!=0)
			{
				JOptionPane.showMessageDialog(this,"Registration Done Successfully", "Registration Done",JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
				p.setText("");
				t4.setText("");
				t6.setText("");
				t7.setText("");
				t9.setText("");
				t10.setText("");
				t11.setText("");
				t12.setText("");
				t13.setText("");
				t14.setText("");
				t15.setText("");
				t16.setText("");
				c.setSelectedIndex(0);
				c1.setSelectedIndex(0);
				c2.setSelectedIndex(0);
			}
			if(i==0)
			{
				JOptionPane.showMessageDialog(this,"Entered Information Type is Invalid!\nPlease Enter " +
						"Valid Information.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	if(ae.getSource()==b2)
	{
		t1.setText("");
		p.setText("");
		t4.setText("");
		t6.setText("");
		t7.setText("");
		t9.setText("");
		t10.setText("");
		t11.setText("");
		t12.setText("");
		t13.setText("");
		t14.setText("");
		t15.setText("");
		t16.setText("");
		c.setSelectedIndex(0);
		c1.setSelectedIndex(0);
		c2.setSelectedIndex(0);
		
	}
	}
	}
}