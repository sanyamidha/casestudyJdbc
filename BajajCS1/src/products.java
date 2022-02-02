package mart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class products {
	
	String  p_name, p_desc;
	int p_id, p_price, p_qty;
    public int getPid() {
		return p_id;
	}

	public void setPid(String p_id) {
		this.p_id = p_id;
	}

	public String getPname() {
		return p_name;
	}

	public void setPname(String p_name) {
		this.p_name = p_name;
	}

	public int getPprice() {
		return p_price;
	}

	public void setPprice(String p_price) {
		this.p_price = p_price;
	}

	public String getPdesc() {
		return p_desc;
	}

	public void setPdesc(String p_desc) {
		this.p_desc = p_desc;
	}

	public int getPqty() {
		return p_qty;
	}

	public void setPqty(String p_qty) {
		this.p_qty = p_qty;
	}

	 public void addProduct()
	    {
	        Scanner input = new Scanner(System.in);
	        System.out.print("id:-");
	        setPid( input.nextInt());
	        System.out.print("name:-");
	        setPname(input.nextLine());
	        System.out.print("price:-");
	        setPprice (input.nextInt());
	        System.out.print("Description:-");
	        setPdesc ( input.nextLine());
	        System.out.print("quantity:-");
	        setPqty(input.nextInt());
	        
	        
	        try {
				Class.forName("oracle.jdbc.OracleDriver");   
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:BAJAJCS1/bajaj123@localhost:1521");   
				PreparedStatement stmt=con.prepareStatement("insert into Products values(?,?,?,?,?,?)");  
				stmt.setInt(1,getPid());
				stmt.setString(2,getPname());
				stmt.setInt(3,getPprice());
				stmt.setString(4,getPdesc());
				stmt.setInt(5,getPqty());
				int i=stmt.executeUpdate();
				con.close();
			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
				
			}		
			finally {
				
				//con.close();
				System.out.print("  Products added...");
			}
	    
	}
	    
	 
	 public void existProduct()
	 {
		 try {
				Class.forName("oracle.jdbc.OracleDriver");   
				Connection con=DriverManager.getConnection( "jdbc:oracle:thin:BAJAJCS1/bajaj123@localhost:1521"); 
				Statement st= con.createStatement();
				ResultSet rs= st.executeQuery("Select * from Products");
				System.out.println("--------------------------------------------------------------------------------------------------------");
	            System.out.println("id      Name      Price      Description      Quantity");
	            System.out.println("--------------------------------------------------------------------------------------------------------");
	            while(rs.next())
	            {
	            	System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"       "+rs.getInt(3)+"      "+rs.getString(4)+"      "+rs.getInt(5)+"     );
	            	System.out.println("--------------------------------------------------------------------------------------------------------");
	            }
	            con.close();
		 }
		 catch(Exception e1)
			{
				e1.printStackTrace();
				
			}		
			finally {
				
				System.out.println("Existing Product's in the Mart ");
			}
		 
		 
	 }
	 
	 public void searchProduct()
	 {
		 try
		 {
			 System.out.println("Enter Product name : ");
			 String searchProduct,choice;
			 int no;
			 Scanner sc = new Scanner(System.in);
			 searchProduct= sc.nextLine();
			 System.out.println("Do you want to Purchase? yes/no: ");
			 choice=sc.nextLine();
		
			 Class.forName("oracle.jdbc.OracleDriver");   
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:BAJAJCS1/bajaj123@localhost:1521");
				switch(choice){
				case "no":
				{
			  
				  int available=-1;
			      PreparedStatement st0= con.prepareStatement("Select p_qty from Products where p_name=?");
			      st0.setString(1,searchProduct);
			      ResultSet r=st0.executeQuery();
			      while(r.next())
			      {
			    	  available=r.getInt(1);
			      }
				if(available<0)
				{
					 System.out.println("Product Out of Stock....");
			    	 System.out.println("Do you want to add stock ? yes/no ");
			    	 String ch;
			    	 Scanner s= new Scanner(System.in);
			    	 ch=s.nextLine();
			    	 switch(ch)
			    	 {
			    	 case "yes":
			    	 {
			    	 addProduct();
			    	 break;
			    	 }
			    	 case "no":
			    	 {
			    		 System.out.println("Out of Stock Sorry!");
			    	 break;
			    	 }
			    	 }
					
				}
				
				PreparedStatement st= con.prepareStatement("select * from Products where p_name= ?  ");
				st.setString(1,searchProduct);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					System.out.println("Id      Name      Price      Quantity      Description");
					if(available>0)
					{
					System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"       "+rs.getInt(3)+"      "+rs.getInt(4)+"        "+rs.getString(5));
					System.out.println("--------------------------------------------------------------------------------------------------------");
					}
				}
				break;
				}
				case "yes":
				{    System.out.println("How much do you want to purchase : ");
				      no=sc.nextInt();
				      int available=0;
				      PreparedStatement st0= con.prepareStatement("Select p_qty from Products where p_name=?");
				      st0.setString(1,searchProduct);
				      ResultSet r=st0.executeQuery();
				      while(r.next())
				      {
				    	  available=r.getInt(1);
				      }
				     if(available>no)
				     {
					 PreparedStatement st= con.prepareStatement(" Update Products SET p_qty=(p_qty-?) where p_name=?");
					 st.setInt(1,no);
					 st.setString(2,searchProduct);
	                 st.executeUpdate();
					 PreparedStatement st1= con.prepareStatement("select * from Products");
						ResultSet rs=st1.executeQuery();
						System.out.println("Id      Name      Price      Quantity      Description");
						System.out.println();
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"       "+rs.getInt(3)+"      "+rs.getInt(4)+"        "+rs.getString(5));
							System.out.println("--------------------------------------------------------------------------------------------------------");
						}
						break;
				     }
				     else if(available<no && available >1)
				     {
				    	 System.out.println("Product Out of Stock....");
				    	 System.out.println("Do you want to add stock ? yes/no ");
				    	 String ch;
				    	 int n;
				    	 Scanner s= new Scanner(System.in);
				    	 ch=s.nextLine();
				    	 switch(ch)
				    	 {
				    	 case "yes":
				    	 {   int num;
				    	     System.out.println("Enter how much do you want to add in stock: ?");
				    	     num=sc.nextInt();
				    		 PreparedStatement st3= con.prepareStatement(" update Products set p_qty=(p_qty+?) where p_name=?");
				    		 st3.setInt(1,num);
				    		 st3.setString(2,searchProduct);
				    		 st3.executeUpdate();
				    		 break;
				    	 }
				    	 case "no":
				    	 {
				    		 System.out.println("Out of Stock Sorry!");
				    		 break;
				    	 }
				    	 }
				     }
				     else
				     {
				    	 System.out.println("Product Out of Stock....");
				    	 System.out.println("Do you want to add stock ? yes/no ");
				    	 String ch;
				    	 Scanner s= new Scanner(System.in);
				    	 ch=s.nextLine();
				    	 switch(ch)
				    	 {
				    	 case "yes":
				    	 {
				    	 addProduct();
				    	 break;
				    	 }
				    	 case "no":
				    	 {
				    		 System.out.println("Out of Stock Sorry!");
				    	 }
				    	 break;
				    	 }
				     }
				}
				
				
				}
			
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }


}
