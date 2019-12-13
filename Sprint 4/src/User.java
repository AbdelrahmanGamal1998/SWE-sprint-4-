import java.util.Scanner;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
public class User {
	private String name;
	private String pass;
	private String email;
	private String username;
	private String Type;
	private String phoneno;
	public String Username_verify ;
	public String Password_verify ;
	public String type_verify ;
	private Controller User_verify;
	private String User_type;

public String getUser_type() {
		return User_type;
}

public void setUser_type(String user_type) {
		this.User_type = user_type;
}

public String getName() {
		return name;
}
	
public void setName(String name) {
		this.name = name;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getPass() {
		return pass;
}
	
public String getEmail() {
		return email;
}
	
public void setEmail(String email) {
		this.email = email;
}
	
public void setUsername(String username) {
	this.username = username;
}

public String getUsername() {
		return username;
}
	
public String getPhoneno() {
		return phoneno;
}
	
public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
}
public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public User login() throws IOException {
	    User u=new User();
	    Scanner input3 = new Scanner(System.in);
		System.out.println("Enter Your type Admin? / User? / StoreOwner? ");
		type_verify = input3.next();
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter Username : ");
		Username_verify = input1.next();
		Scanner input2 = new Scanner(System.in);
	    System.out.println("Enter Password : ");	    
	    Password_verify = input2.next();
	    Controller User_verify = new Controller();
		u=User_verify.verify(type_verify,Username_verify,Password_verify);
		if(u!=null) {
			return u;
		}
		return null;
}
	 /*  if (type_verify.equalsIgnoreCase("collaborator")) {
		   Collaborator_controller collaborator_verify =new Collaborator_controller();
		   c=collaborator_verify( )
		   
		   
	   }*/
	   //else {	   

public void createaccount() throws IOException{		
		File f = new File("Users.txt");
		FileWriter h = new FileWriter(f, true);
		System.out.println("Enter name");
		Scanner x = new Scanner(System.in);
		this.setName(x.next());
		System.out.println("Enter password");
		Scanner y = new Scanner(System.in);
		this.setPass(y.next());
		System.out.println("Enter Your type Admin? / User? / StoreOwner? ");
		Scanner z = new Scanner(System.in);
		this.setType(z.next());
		System.out.println("Enter email");
		Scanner u = new Scanner(System.in);
		this.setEmail(u.next());
		System.out.println("Enter username");
		Scanner Password_verify = new Scanner(System.in);
		this.setUsername(Password_verify.next());
		System.out.println("Enter phoneno");
		Scanner k = new Scanner(System.in);
		this.setPhoneno(k.next());
		h.write(this.getType());
		h.write("\n");
		h.write(this.getUsername());
		h.write("\n");
		h.write(this.getPass());
		h.write("\n");
		System.out.println("Account Created Successfuly");
		System.out.println("Now You Can Login To Our Stores");
		h.close();
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
	            	   }}}
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
 			FileWriter h = new FileWriter(file2, true);
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
   		
   		h.write(u.getName());
   		h.write("\n");
   		h.write(v);
		h.write("\n");
		h.write(Dis);
		h.write("\n");
		h.write(s2);
		h.write("\n");
		h.write(s3);
		h.write("\n");
		System.out.println("The Product On The Cart ");
		h.close();
   		
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