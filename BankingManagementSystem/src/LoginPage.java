import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener
{
	JLabel l1,l2;
	
	JTextField t1;
	
	JPasswordField p1;
	JButton b1,b2;
	
	public LoginPage(String Login)
	{
		super(Login);
		setSize(250, 230);
		setLayout(new FlowLayout());
		setLocationRelativeTo(this);
		setResizable(false);
		getContentPane().setBackground(Color.orange);
		JLabel l=new JLabel(new ImageIcon("login.gif"));
		add(l);
		b1=new JButton("Login");
		b2=new JButton("Reset");
		t1=new JTextField(10);
		p1=new JPasswordField(10);
		l1=new JLabel("Username");
		l2=new JLabel("Password");
		
		add(l1);add(t1);add(l2);add(p1);add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	 @Override
		public void actionPerformed(ActionEvent e) 
		   {
			
			if(e.getSource()==b2)
			{
				t1.setText("");
				p1.setText("");
			}
			if(e.getSource()==b1)
			{
				String str1=t1.getText();
				String str2=p1.getText();
				String typeDB="";
				int i=0;
				
				
				if(str1.length()==0||str2.length()==0)
				{
					JOptionPane.showMessageDialog(this, "Please Fill All The Fields!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				
				
				//------------------database connectivity----------------
				DBInfo obj=new DBInfo();
				Connection con=obj.getConn();
				String query="select * from login";
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						String userDB=res.getString(1);
						String passDB=res.getString(2);
						typeDB=res.getString(3);
						
						if(str1.equals(userDB)  && str2.equals(passDB))
						{
					      i=1;
					      break;
				  		}
					}
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
								
				if(i==0)
				{
		JOptionPane.showMessageDialog(this, "Wrong username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
		        t1.setText("");
		        p1.setText("");
		
				}
				if(i==1)
				{
					if(typeDB.equalsIgnoreCase("Admin"))
					{
						t1.setText("");
						p1.setText("");
						Admin admin=new Admin("Admin", this);
						
						admin.setVisible(true);
						setVisible(false);
					  	
					}
					
					if(typeDB.equalsIgnoreCase("Student"))
					{
						t1.setText("");
						p1.setText("");
					    Student s=new Student("Student page",this);
						s.setVisible(true);
						setVisible(false);
						
					}
					
				}
			}
		   }
		   }
	public static void main(String[] args) 
	{
		LoginPage lp=new LoginPage("Login");
		lp.setVisible(true);

	}

}
