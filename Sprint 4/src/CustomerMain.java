import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class CustomerMain {

public void CustomerMain() throws IOException {
		User x = new Customer();
		x.setUser_type("User");
		User curruse=new User();
		curruse=x.login();
		while(true) {
			System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
			Scanner m = new Scanner(System.in);
			int r = m.nextInt();
	     System.out.println("To view The Store Prducts? Press 1 / Exit? Press 2");
	     
			Scanner m1 = new Scanner(System.in);
			int r1 = m1.nextInt();
			if (r1==1) {
			x.BuyProduct(curruse);
			}
			else 
				System.out.println("THANKS FOR USING OUR WEBSITE");
		}
	       
	 }
	}

