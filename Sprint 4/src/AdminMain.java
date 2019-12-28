import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class AdminMain {
	
public void AdminMain() throws IOException {
	Admin y = new Admin();
	y.Admin_login();
	int r=1;
	while(r==1) {
	System.out.println("Want to Add Products? Press 0 / Want to Add Brands? Press 1 / View Statistics? Press 2  / Want to Add Offer? Press 3 / Want to Delete Offer? Press 4 / Want to Edit Offer? Press 5");
	Scanner j = new Scanner(System.in);
	  int a = j.nextInt();
	  if(a==0) {
		  System.out.println("Enter name");
		  Scanner name = new Scanner(System.in);
		  System.out.println("Enter price");
		  Scanner price = new Scanner(System.in);
		  System.out.println("Enter Brand");
		  Scanner brand = new Scanner(System.in);
		  System.out.println("Enter category");
		  Scanner category = new Scanner(System.in);
		  y.Admin_addProduct(name, price, brand, category);
	  }
	  else if(a==1) {
		  System.out.println("Enter Brand name");
		  Scanner brand_Name = new Scanner(System.in);
		  System.out.println("Enter Brand category");
		  Scanner brand_Category = new Scanner(System.in);
		  y.Admin_brands(brand_Name, brand_Category);
	  }
	  else if(a==2) {  
		    y.User_statistics();
			y.Products_statistics();
		 
	  }
	  else if(a==3) {
		  System.out.println("Enter name");
		  Scanner e = new Scanner(System.in);
		  String name = e.next();
		  System.out.println("Enter Offerd price");
		  e = new Scanner(System.in);
		  String price = e.next();
		  y.Add_offer(name,price);
		  
	  }
	  else if(a==4) {
		  y.Delete_offer();
	  }
	  else if(a==5) {
		  y.Update_offer();
	  }
	  else 
		  System.out.println("Fawa2 ya3am el hag 2olna Press 0 aw 1");
	  
	 System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
	 Scanner m = new Scanner(System.in);
		 r = m.nextInt();
		 
			 
}
	System.out.println("Thanks For Using Our Website!!");
}
}