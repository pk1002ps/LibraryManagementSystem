import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
@SuppressWarnings("serial")
public class BookList extends JFrame
{
	public BookList()
	{
		setSize(getToolkit().getScreenSize());
		
		String query="select * from book";
		
		BookListDB obj=new BookListDB(query);
		
		Vector<String>  header=obj.getTableHeader();
		JTable jTable=new JTable(obj.getTableRecords(),header);
		JScrollPane pane=new JScrollPane(jTable);
		add(pane);		
	}
	
}