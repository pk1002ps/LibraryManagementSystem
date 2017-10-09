import javax.swing.JPanel;
import javax.swing.JTabbedPane;


@SuppressWarnings("serial")
public class Delete_Book extends JPanel
{
	JTabbedPane pane;
	DeleteBook deletebook;
	public Delete_Book()
	{
		pane=new JTabbedPane();
		deletebook=new DeleteBook();
		pane.addTab("Delete Book", deletebook);
		add(pane);
		
	}

}
