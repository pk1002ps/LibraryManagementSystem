import javax.swing.JPanel;
import javax.swing.JTabbedPane;


@SuppressWarnings("serial")
public class Search_Book  extends JPanel
{
	JTabbedPane pane;
	SearchBook search;
	SearchBookByOther bookByOther;
	
	public Search_Book()
	{
		pane=new JTabbedPane();
		
		search=new SearchBook();
		bookByOther=new SearchBookByOther();
		
		pane.addTab("Search Book By ID", search);
		pane.addTab("Search Book By Other", bookByOther);
		add(pane);
		
	}

}
