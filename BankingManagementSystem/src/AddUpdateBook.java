import javax.swing.JPanel;
import javax.swing.JTabbedPane;


@SuppressWarnings("serial")
public class AddUpdateBook extends JPanel
{
	JTabbedPane pane;
	AddBook2 add;
	UpdateBook update;
	
	
	public AddUpdateBook()
	{
		pane=new JTabbedPane();
		add=new AddBook2();
		update=new UpdateBook();
		
		
		pane.addTab("Add Book", add);
		pane.addTab("Update Book", update);
		
		add(pane);
	}

}
