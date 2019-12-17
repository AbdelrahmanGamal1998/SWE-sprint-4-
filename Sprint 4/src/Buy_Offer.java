import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class Buy_Offer {
	private String User_type;
	Database Database1= new Database();
	
public String getUser_type() {
		return User_type;
}

public void setUser_type(String user_type) {
		this.User_type = user_type;
}
	
public void BuyProduct(User u) throws IOException {
		int result = 0;
		System.out.println("Our Products are   ........ ");
		 String s0; 
		 String s1;
		 String s2;
		 String s3;
	File file = new File("StoreProducts.txt"); 
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	while((s0 = br.readLine()) != null&(s1 = br.readLine()) != null&(s2 = br.readLine()) != null &(s3 = br.readLine()) != null ) {
	  System.out.println(s0);
		 }
	  System.out.println("PLEASE choose a SPECIFIC Product ");
	  Scanner e = new Scanner(System.in);
		 String v = e.next();
		 System.out.println("This Products Details is   ");
		if(v!=null) {	 
				File f5 = new File("Offers.txt");
				FileReader r5 = new FileReader(f5);
				Scanner read5 = new Scanner(f5);
				  System.out.println("This Product After offer");
				while(read5.hasNext()) {
			      s0=read5.nextLine();
		             s1=read5.nextLine();    
		               if(s0.equalsIgnoreCase(v) ){
		            	   System.out.println("the product price is :");
		            	   //result = Integer.parseInt(s1);
		            	   System.out.println(s1);
		            	
		            break;
		            	   }
		               }
				}
		           		File f = new File("StoreProducts.txt");
		           		FileReader r = new FileReader(f);
		           		Scanner read = new Scanner(f);
		           		System.out.println("------------------------"); 
		           		System.out.println("This Product Before offer");
		           		while(read.hasNext()) {
		           		 s0=read.nextLine();
			             s1=read.nextLine();
				         s2 = read.nextLine();  
				         s3 = read.nextLine();
		                          if(s0.equalsIgnoreCase(v) ){
		                           System.out.println("the product price is :");
		                           result = Integer.parseInt(s1);
		                       	   System.out.println(s1); 
		                       	   System.out.println("the product brand is :"); 
		                       	   System.out.println(s2);
		                       	   System.out.println("the product category is :"); 
		                       	   System.out.println(s3);
		                       	System.out.println("------------------------"); 
		                       	 break;
		                               }
		                         
		           		}
			System.out.println("Please enter the amount You want  ");
	 	   Scanner e1 = new Scanner(System.in);
	 		 int v1 = e1.nextInt();
	 		int Discount = Calculate_offer(result,v1);
	 		String Dis = String.valueOf(Discount);
	  		System.out.println("to buy this product press buy product  ");
	 		System.out.println("buy product? press 1 ");
	 		System.out.println("else press 2");
			 Scanner e5 = new Scanner(System.in);
	 		 int v5 = e5.nextInt();
	 		if (v5==1) {
	 			File file2 = new File("SoldProducts.txt");
	 		System.out.println("Please Enter The Shipping address ?  ");
	  	   Scanner e2 = new Scanner(System.in);
	  		 String v2= e2.next();
	  		System.out.println("-------------------");
	  		System.out.println("--------------------");
	  		System.out.println("Tax Calculation Services Fees: If you use the tax calculation services,\n ");
				System.out.println("you will pay us 2.9% of all sales and use taxes and other transaction-based charges,we calculate\n");
				System.out.println(" We will retain these fees in the event of any refund on related transactions. \n");
				System.out.println("Calculation of Refunds: For products you fulfill,\n");
				System.out.println (" you are responsible for calculating refunds of all taxes \n");
				System.out.println("and other transaction-based charges calculated through the tax calculation services\n");
				System.out.println("and you will process them using functionality\n");
				System.out.println(" we make available through your seller account.\n ");
	  		System.out.println("Please Agree /1 or Disagree /2 to Our Product agreement?  ");
	   	    Scanner e3 = new Scanner(System.in);
	     	int  v3= e3.nextInt();
	   		 if (v3==1) {
	   			 System.out.println("we will send you a confirmation mail ");
	   			System.out.println("the product will be shipping 2 Working days Thanks for Using Our Website  ");
	   			String a[]= {u.getName(),v,Dis,s2,s3};
	   			Database1.Write(file2, a);
			System.out.println("The Product On The Cart ");
	   		 }
	   		 if (v3==2) {
	   			 System.out.println("The product is discareded , "
	   			 		+ "THANKS FOR USING OUR WEBSITE  ");
	   		 }
	 		}
	 		else {
	 			 System.out.println("the viewers of the products is (Statistics) ");
	 			 System.out.println("THANKS FOR USING OUR WEBSITE  ");
	 		}

}

public int Calculate_offer(int result,int amount) {
		 if(getUser_type()=="User") {
			if(amount == 1) {
				return (int) (result-(result*0.05));
			}
			else
				return (int) (result-(result*0.1));
		}
		else if(getUser_type()=="StoreOwner") {
			if(amount == 1) {
				return (int) (result-(result*0.15));
			}
			else
				return (int) (result-(result*0.3));
		}
		 return 0;
	}

}