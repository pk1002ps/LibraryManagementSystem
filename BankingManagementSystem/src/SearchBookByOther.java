import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SearchBookByOther extends JPanel implements ItemListener,ActionListener
{
	JComboBox<String> box1;
	JLabel l,l1;
	JTextField t1;
	JButton b1;
	 String item;
	 String itemname;
	public SearchBookByOther()
	{
		setLayout(new FlowLayout());
		setSize(400, 300);
		String str[]={"Select","Category","AuthorName","Publication","Subject"};
		
		box1=new JComboBox<String>(str);	
		
		l=new JLabel("Search Book BY:");
		add(l);
		add(box1);
	    
		box1.addItemListener(this);
			
		l1=new JLabel("Enter value:");
		t1=new JTextField(20);
		
		
		
		b1=new JButton("search");
		
		b1.addActionListener(this);
		t1.setVisible(false);
		l1.setVisible(false);
		add(l1);add(t1);add(b1);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==b1)
		{
		  itemname=t1.getText();
		  itemname=itemname.trim();
		  System.out.println(itemname);
		  if(itemname.length()==0)
		  {
			  JOptionPane.showMessageDialog(this,"Please Enter Correct Value!\n","Error",JOptionPane.ERROR_MESSAGE);
		  }
		  
		  else
		  {
			  
			 SearchRecord obj=new SearchRecord(item,itemname);
			 obj.setVisible(true);
		}
		  }
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
	     item=(String)arg0.getItem();
	     if(item.equalsIgnoreCase("select"))
	     {
	    	 t1.setVisible(false);
	    	 l1.setVisible(false);
	     }
	     else
	     {
	    t1.setVisible(true);
	    l1.setVisible(true);
	     }	      
	}
}