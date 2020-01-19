package B2B;

import java.sql.*;

public class DerbyObject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); //  Register and load the driver, package inside derby jar file
		Connection con=DriverManager.getConnection("jdbc:derby:zadb;create=true"); // Connect to the database.

		System.out.println("Connected Successfully...");
		/*
Statement st=con.createStatement(); // Statement or PrepareStatement
//st.execute("create table invoice(InvoiceID DOUBLE PRECISION,SellerName varchar(50),Buyername varchar(50),InvState INTEGER,InvDate varchar(12),EndDate varchar(12),eTransType INTEGER,sBankName varchar(50),sTransId varchar(30) )");
st.execute("insert into invoice values(111234567,'Sell10','BUy10',6,'19-01-2020','19-01-2020',1,'ICICI','TransID10')");
st.execute("insert into invoice values(12345678,'Sell2','BUy2',6,'18-01-2020','18-01-2020',1,'ICICI','TransID2')");
st.execute("insert into invoice values(123456789,'Sell3','BUy3',6,'17-01-2020','17-01-2020',1,'ICICI','TransID3')");
st.execute("insert into invoice values(1234567891,'Sell4','BUy4',6,'16-01-2020','16-01-2020',1,'ICICI','TransID4')");
st.execute("insert into invoice values(12345678912,'Sell5','BUy5',6,'15-01-2020','15-01-2020',1,'ICICI','TransID5')");
st.execute("insert into invoice values(123456789123,'Sell6','BUy6',6,'14-01-2020','14-01-2020',1,'ICICI','TransID6')");
st.execute("insert into invoice values(1234567891234,'Sell7','BUy7',6,'13-01-2020','13-01-2020',1,'ICICI','TransID7')");
st.execute("insert into invoice values(12345678912345,'Sell8','BUy8',6,'12-01-2020','12-01-2020',1,'ICICI','TransID8')");
st.execute("insert into invoice values(123456789123456,'Sell9','BUy9',6,'11-01-2020','11-01-2020',1,'ICICI','TransID9')");
		 */

		//st.execute("insert into invoice values('Karthik','CSE')");
		/*Statement st=con.createStatement(); // Statement or PrepareStatement
st.execute("create table Profile(Name varchar(50),Addr Varchar(100),)");
st.execute("insert into invoice values(111234567,'Sell10','BUy10',6,'19-01-2020','19-01-2020',1,'ICICI','TransID10')");
st.execute("insert into invoice values(12345678,'Sell2','BUy2',6,'18-01-2020','18-01-2020',1,'ICICI','TransID2')");
st.execute("insert into invoice values(123456789,'Sell3','BUy3',6,'17-01-2020','17-01-2020',1,'ICICI','TransID3')");
st.execute("insert into invoice values(1234567891,'Sell4','BUy4',6,'16-01-2020','16-01-2020',1,'ICICI','TransID4')");
st.execute("insert into invoice values(12345678912,'Sell5','BUy5',6,'15-01-2020','15-01-2020',1,'ICICI','TransID5')");
st.execute("insert into invoice values(123456789123,'Sell6','BUy6',6,'14-01-2020','14-01-2020',1,'ICICI','TransID6')");
st.execute("insert into invoice values(1234567891234,'Sell7','BUy7',6,'13-01-2020','13-01-2020',1,'ICICI','TransID7')");
st.execute("insert into invoice values(12345678912345,'Sell8','BUy8',6,'12-01-2020','12-01-2020',1,'ICICI','TransID8')");
st.execute("insert into invoice values(123456789123456,'Sell9','BUy9',6,'11-01-2020','11-01-2020',1,'ICICI','TransID9')");
		 */
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from invoice");

		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
		}
		/*
PreparedStatement ps=con.prepareStatement("insert into student values(?,?)");
PreparedStatement ps1=con.prepareStatement("create table student(Name varchar(10) NOT NULL,Branch varchar(10),PRIMARY KEY(Name))");
PreparedStatement ps2=con.prepareStatement("drop table student");
ps2.executeUpdate();
ps1.executeUpdate();
ps.setString(1, "Guna");
ps.setString(2, "EEE");
int i=ps.executeUpdate();
System.out.println(i+" record inserted successfully");
ps.setString(1, "Rajesh");
ps.setString(2, "ECE");
int i1=ps.executeUpdate();
ps.setString(1, "Karthik");
ps.setString(2, "EEE");
int i2=ps.executeUpdate();
PreparedStatement ps3=con.prepareStatement("Select * from student");
ResultSet rs1=ps3.executeQuery();
while(rs1.next())
{
System.out.println(rs1.getString("Name")+" "+rs1.getString("branch"));
}*/
	}

	public ResultSet fetch (double dInv)
	{
		try {
			Connection con=DriverManager.getConnection("jdbc:derby:zadb;create=true");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from invoice where InvoiceID="+dInv);
			return rs;
		} catch (Exception e) {
			return null;
		}
	}
}