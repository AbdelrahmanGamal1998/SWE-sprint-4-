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
		  y.addProduct();
	  }
	  else if(a==1) {
		  y.addbrands();
	  }
	  else if(a==2) {  
		    y.User_statistics();
			y.Products_statistics();
		 
	  }
	  else if(a==3) {
		  y.Offers();
		  
	  }
	  else if(a==4) {
		  y.deleteOffer();
	  }
	  else if(a==5) {
		  y.EditOffer();
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