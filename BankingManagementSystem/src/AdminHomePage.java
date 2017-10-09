import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class AdminHomePage extends JPanel
{
	public AdminHomePage()
	{

		   ImageIcon img=new ImageIcon("lib.jpg");
		   JLabel l=new JLabel(img);
		   add(l);
	}

}
