import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class Student extends JFrame implements ActionListener
{
	JFrame frm;
	JMenuBar mb;
	JMenu menu1,menu2;
	JMenuItem m1,m2,m3,m4;
	JSplitPane splitpane;
	StudentToolBar stoolbar;
	StudentHomePage studenthomepage;
	public Student(String str,JFrame frm)
	{
		super(str);
		setLayout(new FlowLayout());
		setSize(700, 500);
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.frm=frm;
		mb=new JMenuBar();
		setJMenuBar(mb);
		menu1=new JMenu("File");
		mb.add(menu1);
		m1=new JMenuItem("Search Book");
    	
    	m2=new JMenuItem("Book List");
    	m3=new JMenuItem("Logout");
    	
    	
    	menu1.add(m1);
    	m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
    	menu1.addSeparator();
    	menu1.add(m2);
    	m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
    	menu1.addSeparator();
    	menu1.add(m3);
    	m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
    	
    	menu2=new JMenu("Help");
    	mb.add(menu2);
    	m4=new JMenuItem("About");
    	menu2.add(m4);
    	m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
    	
    	add(new JLabel(new ImageIcon("employee.png")));
    	m1.addActionListener(this);
    	m2.addActionListener(this);
    	m3.addActionListener(this);
    	m4.addActionListener(this);
    	
    	//create JSplitPane
    			splitpane =new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    			splitpane.setEnabled(false);
    			
    			stoolbar=new StudentToolBar();
    			studenthomepage=new StudentHomePage();
    			splitpane.setLeftComponent(stoolbar);
    			splitpane.setRightComponent(studenthomepage);
    			//splitpane.setRightComponent(new AdminRightSide());
    			add(splitpane);
    			
    			 //toolbar.b1.addActionListener(this);
    			stoolbar.b1.addActionListener(this);
    			stoolbar.b2.addActionListener(this);
    			stoolbar.b3.addActionListener(this);
    			stoolbar.b4.addActionListener(this);    		
    	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==m1)
		{
			splitpane.setRightComponent(new Search_Book());
		}
		if(e.getSource()==m2)
		{
			BookList bl=new BookList();
			 //pane.setRightComponent(bl);
		     bl.setVisible(true);
		}
		if(e.getSource()==m3)
	      {
	        frm.setVisible(true);
	        dispose();
	      }
		if(e.getSource()==m4)
		{		
		AdminAbout abt=new AdminAbout("About");
		abt.setVisible(true);
		}
		if(e.getSource()==stoolbar.b1)
		{
			splitpane.setRightComponent(studenthomepage);
		}
		if(e.getSource()==stoolbar.b2)
		{
			splitpane.setRightComponent(new Search_Book());
		}
		if(e.getSource()==stoolbar.b3)
		{
			BookList bl=new BookList();
			 //pane.setRightComponent(bl);
		     bl.setVisible(true);
		}
		if(e.getSource()==stoolbar.b4)
		{
			frm.setVisible(true);
			dispose();
		}
	}
	
}
