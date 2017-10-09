import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Admin extends JFrame implements ActionListener
{
	JFrame frm;
	JMenuBar mb;
	JMenu menu1,menu2,menu3;
	JMenuItem m1,m2,m3,m4,m5,m50,m6,m7,m8,m9,m10,m11,m12;
	JSplitPane pane;
	AdminToolBar toolbar;
	AdminHomePage homepage;
	
public Admin(String str,JFrame frm)
{
	super(str);
	//setLayout(new FlowLayout());
	setSize(700, 500);
	setLocationRelativeTo(this);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	//getContentPane().setBackground(Color.red);
	this.frm=frm;
	mb=new JMenuBar();
	setJMenuBar(mb);
	
	menu1=new JMenu("File");
	mb.add(menu1);
	
	m1=new JMenuItem("Create New Account");
	m2=new JMenuItem("Add/Update Books");
	m3=new JMenuItem("Search Book");
	m4=new JMenuItem("Delete Book");
	m5=new JMenuItem("Issue Books");
	m50=new JMenuItem("Submit Book");
	m6=new JMenuItem("Books List");
	m7=new JMenuItem("Search Student");
	m8=new JMenuItem("Logout");
	m9=new JMenuItem("About");
	
	menu1.add(m1);
	m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m2);
	m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m3);
	m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m4);
	m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m5);
	m5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m50);
	m50.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m6);
	m6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m7);
	m7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
	menu1.addSeparator();
	menu1.add(m8);
	m8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	
	menu3=new JMenu("Add");
	mb.add(menu3);
	m10=new JMenuItem("Add Category");
	m11=new JMenuItem("Add Subject");
	m12=new JMenuItem("Add Publication");
	mb.add(menu3);
	
	menu3.add(m10);
	m10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	menu3.addSeparator();
	menu3.add(m11);
	m11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
	menu3.addSeparator();
	menu3.add(m12);
	m12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		
	menu2=new JMenu("Help");
	mb.add(menu2);
	
	menu2.add(m9);
	m9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
	
	add(new JLabel(new ImageIcon("admin.png")));
	//m7.addActionListener(this);
	
	m1.addActionListener(this);
	m2.addActionListener(this);
	m3.addActionListener(this);
	m4.addActionListener(this);
	m5.addActionListener(this);
	m50.addActionListener(this);
	m6.addActionListener(this);
	m7.addActionListener(this);
	m8.addActionListener(this);
	m9.addActionListener(this);
	m10.addActionListener(this);
	m11.addActionListener(this);
	m12.addActionListener(this);

	//create JSplitPane
		pane =new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		pane.setEnabled(false);
		
		toolbar=new AdminToolBar();
		homepage=new AdminHomePage();
		pane.setLeftComponent(toolbar);
		//pane.setRightComponent(new AdminRightSide());
		pane.setRightComponent(homepage);
		add(pane);
		
		toolbar.b1.addActionListener(this);
		toolbar.b2.addActionListener(this);
		toolbar.b3.addActionListener(this);
		toolbar.b4.addActionListener(this);
		toolbar.b5.addActionListener(this);
		
		toolbar.b6.addActionListener(this);
		toolbar.b60.addActionListener(this);
		toolbar.b7.addActionListener(this);
		toolbar.b8.addActionListener(this);
		toolbar.b9.addActionListener(this);
			
}
String query;
String value;
@Override
public void actionPerformed(ActionEvent ae)
{
	int s=0;int r=0;int t=0;
	// TODO Auto-generated method stub
	if(ae.getSource()==m1)
	{

  	  Reg reg=new Reg("Registration Page");
  	  pane.setRightComponent(reg);
  	  
	}
	
	if(ae.getSource()==m2)
    {
		pane.setRightComponent(new AddUpdateBook());
      AddUpdateBook aub=new AddUpdateBook();
     pane.setRightComponent(aub);      
    }		
	if(ae.getSource()==m3)
	{
		pane.setRightComponent(new Search_Book());
	}
	if(ae.getSource()==m4)
	{
		pane.setRightComponent(new DeleteBook());
	}
	if(ae.getSource()==m5)
	{
		  IssueBook issuebook=new IssueBook("Issue Book");
	  	  pane.setRightComponent(issuebook);
	}
	if(ae.getSource()==m50)
	{
		SubmitBook submitbook=new SubmitBook("Submit Book");
		pane.setRightComponent(submitbook);
	}
	if(ae.getSource()==m6)
	{
		BookList bl=new BookList();
		 //pane.setRightComponent(bl);
	     bl.setVisible(true);
	}
	if(ae.getSource()==m7)
	{
		SearchPeople sp=new SearchPeople();
		pane.setRightComponent(sp);
	}

	if(ae.getSource()==m8)
    {
      frm.setVisible(true);
      dispose();
      
    }
	if(ae.getSource()==m9)
	{
		AdminAbout abt=new AdminAbout("About");
		abt.setVisible(true);
	}
	
	if(ae.getSource()==m10)
	{
	value=JOptionPane.showInputDialog(this, "Enter New Category");
	value=value.trim();
	if(value.length()!=0)
	{
		DBInfo db=new DBInfo();
		Connection con=db.getConn();
		String query10="select * from category";
		try
		{
			PreparedStatement ps=con.prepareStatement(query10);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{				
				String cat=res.getString(2);				
				if(value.equalsIgnoreCase(cat))
				{
			      s=1;
			      break;
		  		}
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		if(s==0)
		{		
	query="insert into category(category) value(?)";
	insertValue();	
	JOptionPane.showMessageDialog(this,"New Category added Successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
	}
	else
	{
		JOptionPane.showMessageDialog(this,"Entered Category Already Exists....!\n           Try again later...","Error",JOptionPane.ERROR_MESSAGE);
	m10.setVisible(true);
	}
	}
	else
		{
		JOptionPane.showMessageDialog(this,"Please Enter Valid category!!\n           Try again later...","Error",JOptionPane.ERROR_MESSAGE);
		}
		}
	if(ae.getSource()==m11)
	{
	value=JOptionPane.showInputDialog(this, "Enter New Subject");
	value=value.trim();
	if(value.length()!=0)
	{
		DBInfo db=new DBInfo();
		Connection con=db.getConn();
		String query10="select * from subject";
		try
		{
			PreparedStatement ps=con.prepareStatement(query10);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{				
				String cat=res.getString(2);				
				if(value.equalsIgnoreCase(cat))
				{
			      r=1;
			      break;
		  		}
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		if(r==0)
		{		
	query="insert into subject(subject) value(?)";
	insertValue();
	JOptionPane.showMessageDialog(this,"New Subject added Successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
	}
	else
	{
		JOptionPane.showMessageDialog(this,"This Subject is Already Exists...!\n           Try again later...","Error",JOptionPane.ERROR_MESSAGE);
	m11.setVisible(true);
	}
	}
	else
	{
		JOptionPane.showMessageDialog(this,"Please Enter a valid Subject...!\n           Try again later...","Error",JOptionPane.ERROR_MESSAGE);
	}
	}
	if(ae.getSource()==m12)
	{
	value=JOptionPane.showInputDialog(this, "Enter New Publication");
	value=value.trim();
	if(value.length()!=0)
	{
		DBInfo db=new DBInfo();
		Connection con=db.getConn();
		String query10="select * from publication";
		try
		{
			PreparedStatement ps=con.prepareStatement(query10);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{				
				String cat=res.getString(2);				
				if(value.equalsIgnoreCase(cat))
				{
			      t=1;
			      break;
		  		}
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		if(t==0)
		{			
	query="insert into publication(publication) value(?)";
	insertValue();
	JOptionPane.showMessageDialog(this, "New Publication added Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
	}
	else
	{
		JOptionPane.showMessageDialog(this, "This Publication Already Exists...!","Error",JOptionPane.ERROR_MESSAGE);
	}
	}
	else
	{
		JOptionPane.showMessageDialog(this,"Please Enter valid Publication!\n           Try again later...","Error",JOptionPane.ERROR_MESSAGE);
	}
	}
	
	
	
	 if(ae.getSource()==toolbar.b1)
     {
		 System.out.println("Home clicked");
   	  pane.setRightComponent(homepage);
   	  
     }
	 if(ae.getSource()==toolbar.b2)
	 {
		 Reg reg=new Reg("Registration Page");
	  	  pane.setRightComponent(reg);
	 }
	 if(ae.getSource()==toolbar.b3)
	 {
		 pane.setRightComponent(new AddUpdateBook());
	      AddUpdateBook aub=new AddUpdateBook();
	     pane.setRightComponent(aub);
	 }
	 if(ae.getSource()==toolbar.b4)
	 {
		 pane.setRightComponent(new Search_Book());
	 }
	 if(ae.getSource()==toolbar.b5)
	 {
		 pane.setRightComponent(new DeleteBook());
	 }
	 if(ae.getSource()==toolbar.b6)
	 {
		 IssueBook issuebook=new IssueBook("Issue Book");
	  	 pane.setRightComponent(issuebook);
	 }
	 if(ae.getSource()==toolbar.b60)
	 {
		 SubmitBook submitbook=new SubmitBook("Submit Book");
			pane.setRightComponent(submitbook);
	 }
	 if(ae.getSource()==toolbar.b7)
	 {
		 BookList bl=new BookList();
		 //pane.setRightComponent(bl);
	     bl.setVisible(true);
	 }
	 if(ae.getSource()==toolbar.b8)
	 {
		pane.setRightComponent(new SearchPeople()); 
	 }
	 if(ae.getSource()==toolbar.b9)
	 {
		 frm.setVisible(true);
		 dispose();
	
	 }
}	

public void insertValue()
{
	 DBInfo obj=new DBInfo();
     Connection con=obj.getConn();
     try
     {
   	  PreparedStatement ps=con.prepareStatement(query);
   	  ps.setString(1,value);
   	  ps.executeUpdate();
     }
     catch(Exception e)
     {
   	  e.printStackTrace();
     }
     
}
}
