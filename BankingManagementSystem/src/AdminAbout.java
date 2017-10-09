import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class AdminAbout extends JFrame
{	
	public AdminAbout(String str)
  	{
		super(str);
		setSize(535,397);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		ImageIcon img=new ImageIcon("abt.jpg");
		   JLabel l=new JLabel(img);
		   add(l);
		setVisible(true);
		setResizable(false);
		}

}
