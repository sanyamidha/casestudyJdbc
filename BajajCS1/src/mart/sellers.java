package mart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class sellers 
{
	String  s_name, s_address, services, s_email ;
	int s_id;
    public int getSid() {
		return s_id;
	}

	public void setSid(int s_id) {
		this.s_id = s_id;
	}

	public String getSname() {
		return s_name;
	}

	public void setSname(String s_name) {
		this.s_name = s_name;
	}

	public String getSaddress() {
		return s_address;
	}

	public void setSaddress(String s_address) {
		this.s_address = s_address;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getSemail() {
		return s_email;
	}

	public void setSemail(String s_email) {
		this.s_email = s_email;
	}

	
	
	
   public void addSeller()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        setSid( input.nextInt());
        input.nextLine();
        System.out.print("name:-");
        setSname(input.nextLine());
        input.nextLine();
        System.out.print("Address:-");
        setSaddress (input.nextLine());
        input.nextLine();
        System.out.print("Services:-");
        setServices ( input.nextLine());
        input.nextLine();
        System.out.print("Email:-");
        setSemail(input.nextLine());
        input.nextLine();
       
        try {
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:bajaj/bajaj@localhost:1521");   
			PreparedStatement stmt=con.prepareStatement("insert into Sellers values(?,?,?,?,?)");  
			stmt.setInt(1,getSid());
			stmt.setString(2,getSname());
			stmt.setString(3,getSaddress());
			stmt.setString(4,getServices());
			stmt.setString(5,getSemail());
			int i=stmt.executeUpdate();
			con.close();
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			//con.close();
			System.out.print("  Sellers added...");
		}
    
}
 public void existSeller()
 {
	 try {
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection( "jdbc:oracle:thin:bajaj/bajaj@localhost:1521"); 
			PreparedStatement st= con.prepareStatement("Select * from Sellers");
			ResultSet rs= st.executeQuery();
			System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("id      Name      Address      Services      Email");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            while(rs.next())
            {
            	System.out.println(rs.getString(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      ");
            	System.out.println("--------------------------------------------------------------------------------------------------------");
            }
            con.close();
	 }
	 catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			System.out.println("Existing Sellers in the Mart ");
		}
	 
	 
 }



}