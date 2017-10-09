import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class AdminToolBar extends JPanel
{
	JToolBar bar=new JToolBar();
	JButton b1,b2,b3,b4,b5,b6,b60,b7,b8,b9;
public AdminToolBar()
{
	setLayout(new FlowLayout());
	b1=new JButton(new ImageIcon("h.png"));
	b2=new JButton(new ImageIcon("createaccount.png"));
	b3=new JButton(new ImageIcon("addbook.png"));
	b4=new JButton(new ImageIcon("booksearch.png"));
	b5=new JButton(new ImageIcon("deletebook.png"));
	
	b6=new JButton(new ImageIcon("issue.png"));
	b60=new JButton(new ImageIcon("s4.png"));
	b7=new JButton(new ImageIcon("Books.png"));
	b8=new JButton(new ImageIcon("search.png"));
	b9=new JButton(new ImageIcon("lgout.png"));
	
	bar.setEnabled(false);
	bar.add(b1);
	bar.add(b2);
	bar.add(b3);
	bar.add(b4);
	bar.add(b5);bar.add(b6);bar.add(b60);bar.add(b7);bar.add(b8);bar.add(b9);
	add(bar);
	
	b1.setToolTipText("Home");
	b2.setToolTipText("Create New Account");
	b3.setToolTipText("Add/Update Book");
	b4.setToolTipText("Search Book");
	b5.setToolTipText("Delete Book");	
	b6.setToolTipText("Issue Books");
	b60.setToolTipText("Submit Book");
	b7.setToolTipText("Books List");
	b8.setToolTipText("Search User");
	b9.setToolTipText("Logout");

}
}
