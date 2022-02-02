package mart;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class customers {
 
	String first_name, last_name, email, address;
	int mobile, c_id;
    public Int getCid() {
		return c_id;
	}
	public void setCid(String c_id) {
		this.c_id = c_id;
	}
	public String getFirstname() {
		return first_name;
	}
	public void setFirstname(String first_name) {
		this.first_name = first_name;
	}
	public String getLastname() {
		return last_name;
	}
	public void setLastname(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public void addCustomer()
	{
		System.out.println("Enter Customer Details : ");
		Scanner input = new Scanner(System.in);
        System.out.print("id:-");
         setCid(input.nextInt());
        System.out.print("First Name:-");
        setFirstname(input.nextLine());
        System.out.print("Last Name:-");
        setLastname(input.nextLine());
        System.out.print("Email:-");
        setEmail(input.nextLine());
        System.out.print("Address:-");
        setAddress(input.nextLine());
        System.out.print("Mobile Number:-");
        setMobile(input.nextInt());
        try {
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:BAJAJCS1/bajaj123@localhost:1521");
			PreparedStatement stmt= con.prepareStatement("insert into Customers values(?,?,?,?,?,?)");
			stmt.setString(1,getCid());
			stmt.setString(2,getFirstname());
			stmt.setString(3,getLastname());
			stmt.setString(4,getEmail());
			stmt.setString(5,getAddress());
			stmt.setInt(6,getMobile());
			int i=stmt.executeUpdate();
			con.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	System.out.println("Customer Added...");
        }
	}
	public void existCustomer()
	{
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:BAJAJCS1/bajaj123@localhost:1521");
		    Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from Customers");
			 System.out.println("--------------------------------------------------------------------------------");
             System.out.println("id      First_Name     Last_Name     Email     Address     Mobile");
             System.out.println("--------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getInt(6));
				System.out.println("--------------------------------------------------------------------------------------------------------");
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			System.out.println("Existing Customer's in the Mart");
		}
		
	}
    
}
}
