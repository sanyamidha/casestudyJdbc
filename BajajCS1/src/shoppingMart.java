package mart;
import java.util.Scanner;

public class shoppingMart {

	public static void main(String[] args)
	{
		
		   System.out.println("             Welcome to Shopping Mart ");
	        System.out.println("--------------------------------------------------------------------------------");

	        Scanner input = new Scanner(System.in);
	        int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1;
	        products p1 = new products();
	        customers ob = new customers();
	        sellers s = new sellers();
	        
	        while (status == 1)
	        {
	            System.out.println("\n                                    MAIN MENU");
	            System.out.println("-----------------------------------------------------------------------------------");

	 

	            System.out.println("1.Products  2. Customers  3.Sellers  ");
	            System.out.println("-----------------------------------------------------------------------------------");
	            choice = input.nextInt();
	            
	            switch (choice)
	            {
	                case 1:
	                    {
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                      **PRODUCTS SECTION**");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        s1 = 1;
	                        while (s1 == 1)
	                        {
	                            System.out.println("1.Add New Product\n2.Existing Product List \\n3. Search Product by Name");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                    p1.addProduct();
	                         	           
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                        System.out.println("--------------------------------------------------------------------------------");
	                                        System.out.println("id \t Name\t Price \t Quantity \t Description ");

	 

	                                        System.out.println("--------------------------------------------------------------------------------");
	                      
	                                        	 p1.existProduct();
	                                        
	                                        break;
	                                    }
	                                case 3:
	                                {
	                                	p1.searchProduct();
	                                	break;
	                                }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s1 = input.nextInt();
	                        }
	                        break;
	                    }
	                case 2:
	                    {
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                     **CUSTOMERS SECTION**");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        s2 = 1;
	                        while (s2 == 1)
	                        {
	                            System.out.println("1.Add New Customer\n2.Existing Customer List");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                        ob.addCustomer();
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                        ob.existCustomer();
	                                        break;
	                                    }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s2 = input.nextInt();
	                        }
	                        break;
	                    }
	               case 3:
	                    {
	                        s3 = 1;
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                     **SELLERS SECTION**");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        while (s3 == 1)
	                        {
	                            System.out.println("1.Add New Seller\n2. Existing Seller List");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                    	s.addSeller();
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                        s.existSeller();
	                                        break;
	                                    }
	                               
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s3 = input.nextInt();
	                        }
	                        break;
	                    }
	              
	                default:
	                    {
	                        System.out.println(" You Have Enter Wrong Choice!!!");
	                    }
	            }
	            System.out.println("\nReturn to MAIN MENU Press 1");
	            status = input.nextInt();
		}
}
}

	
