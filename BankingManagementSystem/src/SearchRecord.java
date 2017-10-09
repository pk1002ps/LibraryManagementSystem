import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
@SuppressWarnings("serial")
public class SearchRecord extends JFrame
{
	int i=0;
	public SearchRecord(String item,String itemname)
	{
		
		setSize(getToolkit().getScreenSize());
		
		String query="select * from book where "+item+"='"+itemname+"'";
		
		DemoDB obj=new DemoDB(query);
		Vector<String>  header=obj.getTableHeader();
		JTable jTable=new JTable(obj.getTableRecords(),header);
		JScrollPane pane=new JScrollPane(jTable);
		add(pane);		
		
	}
	
}