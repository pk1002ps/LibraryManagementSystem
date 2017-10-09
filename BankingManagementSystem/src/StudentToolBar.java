import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class StudentToolBar extends JPanel
{
	JToolBar bar=new JToolBar();
	JButton b1,b2,b3,b4;


public StudentToolBar()
{
	setLayout(new FlowLayout());
	b1=new JButton(new ImageIcon("h.png"));
	b2=new JButton(new ImageIcon("booksearch.png"));
	b3=new JButton(new ImageIcon("Books.png"));
	b4=new JButton(new ImageIcon("lgout.png"));
	
	bar.setEnabled(false);
	bar.add(b1);
	bar.add(b2);
	bar.add(b3);
	bar.add(b4);
	add(bar);
	
	b1.setToolTipText("Home");
	b2.setToolTipText("Search Book");
	b3.setToolTipText("Book List");
	b4.setToolTipText("Logout");
}
}