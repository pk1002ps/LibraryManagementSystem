import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class DeleteBook extends javax.swing.JPanel implements FocusListener,ActionListener
{
	 String str1;
	 int j=0;
	 int k=0;
	 int m=0;
@Override
public void focusGained(FocusEvent arg0) 
{
			// TODO Auto-generated method stub
			
}
@Override
	public void focusLost(FocusEvent arg0) 
	{
	    str1=jTextField9.getText();
	   if(str1.length()==0 || str1==null)
	   {
		   JOptionPane.showMessageDialog(this,"Please enter BookID1!","Error",JOptionPane.ERROR_MESSAGE);
	   j++;}
	   else
	   {
	   DBInfo obj=new DBInfo();
	   Connection con=obj.getConn();
	   String query="select * from book where bookid=?";
	   try
	   {
		 PreparedStatement ps=con.prepareStatement(query);
		 ps.setString(1, str1);
		 ResultSet res=ps.executeQuery();
		 res.next();
		   String title=res.getString(2);
		   String author=res.getString(3);
		   String publication=res.getString(4);
		   String subject=res.getString(5);
		   String isbn=res.getString(6);
		   String category=res.getString(7);
		   String price=res.getString(8);
		   String quantity=res.getString(9);
		   k++;
		   
		   
		   jTextField1.setText(title);
		   jTextField2.setText(author);
		   jTextField3.setText(publication);
		   jTextField4.setText(subject);
		   jTextField5.setText(isbn);
		   jTextField6.setText(category);
		   jTextField7.setText(price);
		   jTextField8.setText(quantity);		   
		   
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
	   if(k==0 && j!=0)
		   JOptionPane.showMessageDialog(this,"       Invalid BookID!\nPlease Enter valid BookID!","Error",JOptionPane.ERROR_MESSAGE);
        m++;
        }}
 @Override
public void actionPerformed(ActionEvent e) 
 {
    if(e.getSource()==jButton2)
    {
    	 jTextField1.setText(null);jTextField2.setText(null);jTextField3.setText(null);
        	jTextField4.setText(null);jTextField5.setText(null);jTextField6.setText(null);
        	jTextField7.setText(null);jTextField8.setText(null);
        	jTextField9.setText(null);
    }
    if(e.getSource()==jButton1)
    {    	
    		int i=0;
    		if(j!=0)
    		{
    			
    		}
    		else
    		{
    		 str1=jTextField9.getText();
    		   if(str1.length()==0 || str1==null)
    		   {
    			   JOptionPane.showMessageDialog(this, "   Please enter BookID2!", "Error", JOptionPane.ERROR_MESSAGE);
    		   }
    		   
    		   else
    		   {
    	
    	String query="delete from book where bookid=?";
    	DBInfo obj=new DBInfo();
    	Connection con=obj.getConn();
    	try
    	{
    	PreparedStatement ps=con.prepareStatement(query);
    	ps.setString(1,str1);
    	i=ps.executeUpdate();
    	}
    	
    	catch(Exception e1)
    	{
    		e1.printStackTrace();
    	}
    	if(i==1)
    	{
    		JOptionPane.showMessageDialog(this, "Book deleted Successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
    		 jTextField1.setText(null);jTextField2.setText(null);jTextField3.setText(null);
         	jTextField4.setText(null);jTextField5.setText(null);jTextField6.setText(null);
         	jTextField7.setText(null);jTextField8.setText(null);
         	jTextField9.setText(null);
    	}
    	if(i==0)
    	{
    		JOptionPane.showMessageDialog(this, "Book could not be deleted!\nPlease Enter a valid BookID!", "Unsuccessfull!", JOptionPane.ERROR_MESSAGE);
    	}
    }}
}}
    public DeleteBook() 
    {
        initComponents();
        jButton2.addActionListener(this);
        jTextField9.addFocusListener(this);
        jButton1.addActionListener(this);
        
    }   
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();

        jLabel1.setText("Book title");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Publication");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("ISBN");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText("Price");
        jLabel4.setName("jLabel4"); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setName("jTextField1"); // NOI18N

        jTextField2.setEditable(false);
        jTextField2.setName("jTextField2"); // NOI18N

        jTextField3.setEditable(false);
        jTextField3.setName("jTextField3"); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setName("jTextField4"); // NOI18N

        jLabel5.setText("AuthorName");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText("Subject");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText("Category");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText("Quantity");
        jLabel8.setName("jLabel8"); // NOI18N

        jButton1.setText("DELETE");
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setText("RESET");
        jButton2.setName("jButton2"); // NOI18N

        jTextField5.setEditable(false);
        jTextField5.setName("jTextField5"); // NOI18N

        jTextField6.setEditable(false);
        jTextField6.setName("jTextField6"); // NOI18N

        jTextField7.setEditable(false);
        jTextField7.setName("jTextField7"); // NOI18N

        jTextField8.setEditable(false);
        jTextField8.setName("jTextField8"); // NOI18N

        jLabel9.setText("Enter Book ID");
        jLabel9.setName("jLabel9"); // NOI18N

        jTextField9.setName("jTextField9"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(254, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration
}
