import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class AddBook2 extends javax.swing.JPanel implements ActionListener,ItemListener 
{

    int i=0;
    String subject;
    String category;
    boolean flag=true;
    @Override
    public void itemStateChanged(ItemEvent arg0) 
    {
    	System.out.println("we are in itemstatemchanged");
    	if(arg0.getSource()==jComboBox1)
    	{
          subject=(String)arg0.getItem();
          if(subject==null)
          {
        	  flag=false;
          }
          System.out.print("subject="+subject);
    	}
    	
    	if(arg0.getSource()==jComboBox2)
    	{
    		category=(String)arg0.getItem();
    		if(category==null)
    		{
    			flag=false;
    		}
    		System.out.println("category="+category);
    	}    	
    }
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==jButton1 && flag==true)
		{
	  DBInfo obj=new DBInfo();
	  Connection con=obj.getConn();
	  String title=jTextField1.getText();
	  String author=jTextField2.getText();
	  String publication=jTextField3.getText();
	 
	  String isbn=jTextField4.getText();
	  String price=jTextField5.getText();
	  String quantity=jTextField6.getText();	  
	  
	  title = title.trim();
	  author = author.trim();
	  publication = publication.trim();
	  isbn = isbn.trim();
	  price = price.trim();
	  quantity = quantity.trim();
	  
	  System.out.println(category + " "+ subject);
	  
	  if(title.length()==0||author.length()==0||publication.length()==0||isbn.length()==0
			  ||price.length()==0||quantity.length()==0||subject.equals("--Select--")||category.equals("--Select--"))
	  {
		  JOptionPane.showMessageDialog(this,"Please Fill all the Fields!",
				  "Error", JOptionPane.ERROR_MESSAGE);
	  }
	  else
	  {
	  String query="insert into book values(?,?,?,?,?,?,?,?,?)";
	  int i=(int)(Math.random()*1000000);
	  String initialValue=category.substring(0,3);
	  
	  String bookid=initialValue+i;
	  System.out.println(bookid);
		  try
		  {
              PreparedStatement ps=con.prepareStatement(query);	
              ps.setString(1, bookid);
              ps.setString(2, title);
              ps.setString(3, author);
              ps.setString(4, publication);
              ps.setString(5, subject);
              ps.setString(6, isbn);
              ps.setString(7, category);
              ps.setInt(8, Integer.parseInt(price));
              ps.setInt(9,Integer.parseInt(quantity));
              i=ps.executeUpdate();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  if(i==1)
		  {
			  JOptionPane.showMessageDialog(this, "Book added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
			  jTextField1.setText("");
			  jTextField2.setText("");
			  jTextField3.setText("");
			  jTextField4.setText("");
			  jTextField5.setText("");
			  jTextField6.setText("");	
			 
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(this,"    Book didn't added!\n     Incorrecct Data!", "Error", JOptionPane.ERROR_MESSAGE);
			  
		  }
	
		}}
		if(arg0.getSource()==jButton2)
		{
			  jTextField1.setText("");
			  jTextField2.setText("");
			  jTextField3.setText("");
			  jTextField4.setText("");
			  jTextField5.setText("");
			  jTextField6.setText("");
		}
		}
		
	 @SuppressWarnings("unchecked")
	public AddBook2() 
	 {
	     
		 initComponents();
		 jButton1.addActionListener(this);
	     jButton2.addActionListener(this);
	     jComboBox1.addItemListener(this);
	     jComboBox2.addItemListener(this);
	          
	     GetValuesFromDB obj=new GetValuesFromDB();
	     Vector<String> subjects=obj.getAllSubjects();
	     jComboBox1.setModel(new DefaultComboBoxModel<>(subjects));
	     Vector<String> categories=obj.getAllCategories();
	     jComboBox2.setModel(new DefaultComboBoxModel<>(categories));
	     
	    }
	

/** This method is called from within the constructor to
 * initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is
 * always regenerated by the Form Editor.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
// <editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents()
{

  
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jTextField3 = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jComboBox1 = new javax.swing.JComboBox();
    jLabel5 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jComboBox2 = new javax.swing.JComboBox();
    jLabel7 = new javax.swing.JLabel();
    jTextField5 = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    jTextField6 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
  
    

   


    jLabel1.setText("Book Title"); // NOI18N
    jLabel1.setName("jLabel1"); // NOI18N

   
    jTextField1.setName("jTextField1"); // NOI18N

    jLabel2.setText("Author"); // NOI18N
    jLabel2.setName("jLabel2"); // NOI18N

    
    jTextField2.setName("jTextField2"); // NOI18N

    jLabel3.setText("Publication"); // NOI18N
    jLabel3.setName("jLabel3"); // NOI18N

    
    jTextField3.setName("jTextField3"); // NOI18N

    jLabel4.setText("Subject"); // NOI18N
    jLabel4.setName("jLabel4"); // NOI18N

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    jComboBox1.setName("jComboBox1"); // NOI18N

    jLabel5.setText("ISBN"); // NOI18N
    jLabel5.setName("jLabel5"); // NOI18N

    
    jTextField4.setName("jTextField4"); // NOI18N

    jLabel6.setText("Category"); // NOI18N
    jLabel6.setName("jLabel6"); // NOI18N

    jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    jComboBox2.setName("jComboBox2"); // NOI18N

    jLabel7.setText("Price"); // NOI18N
    jLabel7.setName("jLabel7"); // NOI18N

    
    jTextField5.setName("jTextField5"); // NOI18N

    jLabel8.setText("Quantity"); // NOI18N
    jLabel8.setName("jLabel8"); // NOI18N

    
    jTextField6.setName("jTextField6"); // NOI18N

    jButton1.setText("SAVE"); // NOI18N
    jButton1.setName("jButton1"); // NOI18N

    jButton2.setText("RESET"); // NOI18N
    jButton2.setName("jButton2"); // NOI18N

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
   this.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(67, 67, 67)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jTextField5)
                .addComponent(jTextField4)
                .addComponent(jTextField3)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
            .addGap(32, 32, 32)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(37, 37, 37)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jTextField6)
                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
            .addGap(79, 79, 79))
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(194, 194, 194)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26)
            .addComponent(jButton2)
            .addContainerGap(171, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(38, 38, 38)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(115, Short.MAX_VALUE))
    );
}// </editor-fold>

// Variables declaration - do not modify
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
@SuppressWarnings("rawtypes")
private javax.swing.JComboBox jComboBox1;
@SuppressWarnings("rawtypes")
private javax.swing.JComboBox jComboBox2;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JLabel jLabel8;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
private javax.swing.JTextField jTextField3;
private javax.swing.JTextField jTextField4;
private javax.swing.JTextField jTextField5;
private javax.swing.JTextField jTextField6;
@SuppressWarnings("unused")
private javax.swing.JPanel mainPanel;
@SuppressWarnings("unused")
private javax.swing.JMenuBar menuBar;
@SuppressWarnings("unused")
private javax.swing.JProgressBar progressBar;
@SuppressWarnings("unused")
private javax.swing.JLabel statusAnimationLabel;
@SuppressWarnings("unused")
private javax.swing.JLabel statusMessageLabel;
@SuppressWarnings("unused")
private javax.swing.JPanel statusPanel;
// End of variables declaration
}