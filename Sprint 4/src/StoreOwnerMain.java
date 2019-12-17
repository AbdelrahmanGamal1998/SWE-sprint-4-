import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class StoreOwnerMain {
	
public void StoreOwnerMain() throws IOException {
	User x = new User();
	x.setUser_type("StoreOwner");
	StoreOwner z = new StoreOwner();
	z.StoreOwner_login();
	int r=1;
	while(r==1) {
	System.out.println("Want to Add Products? Press 0 / Want to Add Store? Press 1 / Want to show views? Press 2");
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
	  else
		  System.out.println("Ma saba7 el fool ba2a :D");
	  
	  System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
	  Scanner m = new Scanner(System.in);
			 r = m.nextInt();
	}
}

}