package mart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class sellers {
	
	String  s_name, s_address, s_age;
	int s_id, s_number ;
    public int getSid() {
		return s_id;
	}

	public void setSid(String s_id) {
		this.s_id = s_id;
	}

	public String getSname() {
		return s_name;
	}

	public void setSname(String s_name) {
		this.s_name = s_name;
	}

	public String getAddress() {
		return s_address;
	}

	public void setAddress(String s_address) {
		this.s_address = s_address;
	}

	public String getAge() {
		return s_age;
	}

	public void setAge(String s_age) {
		this.s_age = s_age;
	}

	public int getNumber() {
		return s_number;
	}

	public void setNumber(String s_number) {
		this.s_number = s_number;
	}

	 public void addSeller()
	    {
	        Scanner input = new Scanner(System.in);
	        System.out.print("id:-");
	        setSid( input.nextInt());
	        System.out.print("name:-");
	        setSname(input.nextLine());
	        System.out.print("address:-");
	        setAddress (input.nextLine());
	        System.out.print("Age:-");
	        setAge ( input.nextLine());
	        System.out.print("Contact Number:-");
	        setNumber(input.nextInt());
	        
	        
	        try {
				Class.forName("oracle.jdbc.OracleDriver");   
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:BAJAJCS1/bajaj123@localhost:1521");   
				PreparedStatement stmt=con.prepareStatement("insert into Products values(?,?,?,?,?,?)");  
				stmt.setInt(1,getSid());
				stmt.setString(2,getSname());
				stmt.setInt(3,getAddress());
				stmt.setString(4,getAge());
				stmt.setInt(5,getNumber());
				int i=stmt.executeUpdate();
				con.close();
			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
				
			}		
			finally {
				
				//con.close();
				System.out.print("  Seller added...");
			}
	    
	}
	    
	 
	 public void existSeller()
	 {
		 try {
				Class.forName("oracle.jdbc.OracleDriver");   
				Connection con=DriverManager.getConnection( "jdbc:oracle:thin:BAJAJCS1/bajaj123@localhost:1521"); 
				Statement st= con.createStatement();
				ResultSet rs= st.executeQuery("Select * from Sellers");
				System.out.println("--------------------------------------------------------------------------------------------------------");
	            System.out.println("id      Name      Address      Age      Contact_Number");
	            System.out.println("--------------------------------------------------------------------------------------------------------");
	            while(rs.next())
	            {
	            	System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getInt(5)+"     );
	            	System.out.println("--------------------------------------------------------------------------------------------------------");
	            }
	            con.close();
		 }
		 catch(Exception e1)
			{
				e1.printStackTrace();
				
			}		
			finally {
				
				System.out.println("Existing Seller in the Mart ");
			}
		 
		 
	 }


}


