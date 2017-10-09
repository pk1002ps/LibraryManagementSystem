import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class AdminRightSide extends JPanel
{
	public AdminRightSide()
	{
		ImageIcon img=new ImageIcon("lib.jpg");
		JLabel lbl=new JLabel(img);
		add(lbl);
	}
}
