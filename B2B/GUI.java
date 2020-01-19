
package B2B;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
/*public class B2BGUI {

/*public static void main(String args[]){
GUI gui = new GUI();
gui.login();

}

}
 */
public class GUI {
	private JFrame frame;
	GUI()
	{
		//Creating the Frame
		frame = new JFrame("Invoice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

	}
	void login()
	{
		//Creating the panel at bottom and adding components
		JPanel panel = new JPanel(); // the panel is not visible in output
		JLabel label = new JLabel("Enter Invoice ID");
		JTextField tf = new JTextField(10); // accepts upto 10 characters

		JButton getInvoice = new JButton("GetInvoice");
		getInvoice.addActionListener(new FetchInvoice(frame, tf,panel));

		JButton newInvoice = new JButton("New");
		newInvoice.addActionListener(new NewInvoice(panel));


		panel.add(label); // Components Added using Flow Layout
		panel.add(tf);
		panel.add(getInvoice);
		panel.add(newInvoice);

		// Text Area at the Center
		JTextArea ta = new JTextArea();

		//Adding Components to the frame.
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		//frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.getContentPane().add(BorderLayout.CENTER, ta);
		frame.setVisible(true);

	}
}

class NewInvoice implements ActionListener{
	JPanel panel;

	NewInvoice(JPanel panel){
		this.panel=panel;
	}

	public void actionPerformed(ActionEvent e)
	{
		/* Create a new Invoice */
		JTextField tf = new JTextField(10);
		JButton addItem = new JButton("AddItem");
		this.setupNewInvoice();
	}

	void setupNewInvoice(){

	}
}


class FetchInvoice implements ActionListener{
	JFrame frame;
	JTextField tf;
	JPanel panel;
	FetchInvoice(JFrame frame, JTextField tf, JPanel panel){
		this.frame = frame;
		this.tf=tf;
		this.panel= panel;
	}
	public void actionPerformed(ActionEvent e)
	{
		/* Fetch an existing invoice */
		if(this.tf.getText().length() == 0)
		{
			JOptionPane.showMessageDialog(this.frame,"Enter Invoice ID.","Error",JOptionPane.ERROR_MESSAGE);    
		}
		else
		{
			//	ResultSet rs=st.executeQuery("select * from invoice where InvoiceID="+tf.getText());
			//ResultSet rs = (new DerbyObject().fetch(Double.parseDouble(tf.getText())));
			try {
				
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				
				Connection con=DriverManager.getConnection("jdbc:derby:zadb;create=true"); // Connect to the database.
				
				//Statement st=con.createStatement();
				PreparedStatement ps3=con.prepareStatement("select * from invoice where InvoiceID="+tf.getText());
				ResultSet rs=ps3.executeQuery();
				

				
				
				
				while(rs.next())
				{
					/*Invoice inv= new Invoice(Double.parseDouble(rs.getString(1)),(String)rs.getString(2),(String)rs.getString(3));
					inv.eInvState = InvState.valueOf(rs.getString(4));
					inv.setInvDate((Date)new SimpleDateFormat("dd-MM-yyyy").parse(rs.getString(5)));
					inv.setEndDate((Date)new SimpleDateFormat("dd-MM-yyyy").parse(rs.getString(6)));
					//TransDetail transDetail;*/
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
					JLabel label = new JLabel("My label");

					label.setText("<html>This is a<br>multline label!<br> Try it yourself!</html>");
					this.panel.add(label);
					this.frame.add(label);
				}
				}catch(Exception exc) {System.out.println("Exception "+exc.getMessage() );}
		}

	}
}