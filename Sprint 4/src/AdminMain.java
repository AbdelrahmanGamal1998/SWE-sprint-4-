import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class AdminMain {
	
public void AdminMain() throws IOException {
	Admin Admin  = new Admin();
	Admin.Admin_login();
	int loop=1;
	while(loop==1) {
	System.out.println("Want to Add Products? Press 0 / Want to Add Brands? Press 1 / View Statistics? Press 2  / Want to Add Offer? Press 3 / Want to Delete Offer? Press 4 / Want to Edit Offer? Press 5");
	Scanner botton = new Scanner(System.in);
	  int botton1 = botton.nextInt();
	  if(botton1==0) {
		  System.out.println("Enter name");
		  Scanner name = new Scanner(System.in);
		  System.out.println("Enter price");
		  Scanner price = new Scanner(System.in);
		  System.out.println("Enter Brand");
		  Scanner brand = new Scanner(System.in);
		  System.out.println("Enter category");
		  Scanner category = new Scanner(System.in);
		  Admin.Admin_addProduct(name, price, brand, category);
	  }
	  else if(botton1==1) {
		  System.out.println("Enter Brand name");
		  Scanner brand_Name = new Scanner(System.in);
		  System.out.println("Enter Brand category");
		  Scanner brand_Category = new Scanner(System.in);
		  Admin.Admin_brands(brand_Name, brand_Category);
	  }
	  else if(botton1==2) {  
		  Admin.User_statistics();
		  Admin.Products_statistics();
		 
	  }
	  else if(botton1==3) {
		  System.out.println("Enter name");
		  Scanner inputname = new Scanner(System.in);
		  String name = inputname.next();
		  System.out.println("Enter Offerd price");
		  Scanner input_offer_price = new Scanner(System.in);
		  String price = input_offer_price.next();
		  Admin.Add_offer(name,price);
		  
	  }
	  else if(botton1==4) {
		  Admin.Delete_offer();
	  }
	  else if(botton1==5) {
		  Admin.Update_offer();
	  }
	  else 
		  System.out.println("Fawa2 ya3am el hag 2olna Press 0 aw 1");
	  
	 System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
	 Scanner botton2 = new Scanner(System.in);
		 loop = botton2.nextInt();
		 
			 
}
	System.out.println("Thanks For Using Our Website!!");
}
}