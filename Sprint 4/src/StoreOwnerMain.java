import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class StoreOwnerMain {
	
public void StoreOwnerMain() throws IOException {
	User x = new StoreOwner();
	x.setUser_type("StoreOwner");
	User curruse=new User();
	curruse=x.login();
	StoreOwner z = new StoreOwner();
	int r=1;
	while(r==1) {
	System.out.println("Want to Add Products? Press 0 / Want to Add Store? Press 1 / Want to show views? Press 2 / Want to Buy Product? Press 3 / Want to Delete Product? Press 4 / Want to Edit Product's Price? Press 5 / Want to Check History and Undo Action? Press 6");
	Scanner j = new Scanner(System.in);
	  int a = j.nextInt();
	  if(a==0) {
		  z.addProduct();
	  }
	  else if(a==1) {
		  z.addStore();
	  }
	  else if(a==2) {
		  //z.getviews();
	
   Timer timer = new Timer();
   timer.schedule(new Statistics(), 0, 600000);
	 }
	  else if(a==3) {
		  x.BuyProduct(curruse);
	  }
	  else if(a==4) {
		  z.deleteProduct();
	  }
	  else if(a==5) {
		  z.UpdatedProductPrice();
	  }
	  else if(a==6) {
		  z.Check_History();
		  System.out.println("Do You Want to Undo Action? Press 1");
		  Scanner t = new Scanner(System.in);
			int g = t.nextInt();
		  if(g==1) {
		  z.Undo();
		  }
	  }
	  else
		  System.out.println("Ma saba7 el fool ba2a :D");
	  
	  System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
	  Scanner m = new Scanner(System.in);
			 r = m.nextInt();
	}
	System.out.println("Thanks For Using Our Website!!");
}

}