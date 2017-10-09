import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class StudentRightSide extends JPanel
{
	public StudentRightSide()
	{
		ImageIcon img=new ImageIcon("lib.jpg");
		JLabel lbl=new JLabel(img);
		add(lbl);
	}

}
