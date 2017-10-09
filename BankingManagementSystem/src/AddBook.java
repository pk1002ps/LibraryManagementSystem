import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AddBook extends javax.swing.JPanel implements ActionListener,ItemListener
{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t5,t7,t8;
	JButton b1,b2;
	
	JComboBox<String>c4;
	JComboBox<String>c6;
	String s1="";
	String s2="";
	public AddBook()
	{
		
		l1=new JLabel("Book Title");
		l1.setBounds(125, 90, 100, 20);
		
		t1=new JTextField(25);
		t1.setBounds(225, 90, 100, 20);
		
		l2=new JLabel("Author");
		l2.setBounds(350, 90, 100, 20);
		
		l3=new JLabel("Publication");
		l3.setBounds(125, 115, 100, 20);
		
		t3=new JTextField(20);
		t3.setBounds(225, 115, 100, 20);
		
		l4=new JLabel("Subject");
		l4.setBounds(350, 115, 100, 20);
		
		String item1[]={"Select","Android","C","C++","English","Embedded System","Algorithms"
				,"Html","Java","Database","Mathematics","Software Engineering","Theory of Computer Science"};
		
		c4=new JComboBox<String>(item1);
		c4.setBounds(225, 140, 100, 20);
		
		l5=new JLabel("ISBN");
		l5.setBounds(125,140,100, 20);
		
		t5=new JTextField(15);
		t5.setBounds(435, 165, 100, 20);
		
		
		l6=new JLabel("Category");
		l6.setBounds(350, 140, 100, 20);
		 
		String item2[]={"Select","Civil Engineering","Computer Science","Electrical","Electronics & Comm.","Information Tech.","Mechanical"};
		c6=new JComboBox<String>(item2);
		c6.setBounds(435, 165, 100, 20);
		
		
		l7=new JLabel("Price");
		l7.setBounds(125, 165, 100, 20);
		
		t7=new JTextField(15);
		t7.setBounds(225, 165, 100, 20);
		
		l8=new JLabel("Quantity");
		l8.setBounds(350, 165, 70, 20);
		
		b1=new JButton("Save");
		b1=new JButton(new ImageIcon("save.jpg"));
		b1.setBounds(270,280, 80, 30);
		
		b2=new JButton("Reset");
		b2=new JButton(new ImageIcon("reset.jpg"));
		b2.setBounds(370, 280,80,30);
		
		add(l1);add(t1);add(l2);add(t2);add(l3);add(t3);add(l4);add(c4);add(l5);
		add(t5);add(l6);add(c6);add(l7);add(t7);add(l8);add(t8);
		add(b1);add(b2); 
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		c4.addItemListener(this);
		c6.addItemListener(this);
		
		 GetValuesFromDB obj=new GetValuesFromDB();
	     Vector<String> subjects=obj.getAllSubjects();
	     Vector<String> category=obj.getAllSubjects();
	     c4.setModel(new DefaultComboBoxModel<>(subjects));
	     c6.setModel(new DefaultComboBoxModel<>(category));
	     
	}
	
	@Override
	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getSource()==c4)
		{
		 s1=(String)c4.getSelectedItem();

		//System.out.println("str is:"+str);
		}
		if(ie.getSource()==c6)
		{
		s2=(String)c6.getSelectedItem();
		//System.out.println("str1 is:"+str1);
		}		
				
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		int i=0;
		
		if(ae.getSource()==b1)
		{
			DBInfo obj=new DBInfo();
			Connection con=obj.getConn();
			String str1=t1.getText();
			String str2=t2.getText();
			String str3=t3.getText();
			String str4=t5.getText();
			String str5=t7.getText();
			
			String str6=t8.getText();
			
			int n=(int)(Math.random()*1000000);
			String intitalValue=s2.substring(0,3);
			  
			String bookid=intitalValue+n;
			System.out.println(bookid);
			
			if(str1.length()==0 || str2.length()==0  )
			{
				JOptionPane.showMessageDialog(this,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
			String query="Insert into login values(?,?,?,?,?,?,?,?)";
			try 
			{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, str1);
				ps.setString(2, str2);
				ps.setString(3,str3);
				ps.setString(4,s1);
				ps.setString(5,str4);
				ps.setString(6,s2);
				ps.setString(7,str5);
				ps.setString(8,str6);
					
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
				JOptionPane.showMessageDialog(this,"Book Added Successfully", "Save",JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
				
				t2.setText("");
				t3.setText("");
				t5.setText("");
				t7.setText("");
				t8.setText("");
				c4.setSelectedIndex(0);
				c6.setSelectedIndex(0);
			}
			else
			  {
				  JOptionPane.showMessageDialog(this, "Book didn't added", "Error", JOptionPane.ERROR_MESSAGE);
				  
			  }
		}
	}
	if(ae.getSource()==b2)
	{
		t1.setText("");
		
		t2.setText("");
		t3.setText("");
		t5.setText("");
		t7.setText("");
		t8.setText("");
		c4.setSelectedIndex(0);
		c6.setSelectedIndex(0);
		
	}
	}
	}