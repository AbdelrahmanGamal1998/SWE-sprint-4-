import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class CustomerMain {

public void CustomerMain() throws IOException {
		User x = new Customer();
		x.setUser_type("User");
		User curruse=new User();
		curruse=x.login();
		int r=1;
		while(r==1) {
			System.out.println("Want to Buy Product? Press 1");
			Scanner j = new Scanner(System.in);
			  int a = j.nextInt();
			if(a==1) {
				x.BuyProduct(curruse);
			}
			else 
				System.out.println("A3melak eh delwa2ty :D");
			
			 System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
			  Scanner m = new Scanner(System.in);
					 r = m.nextInt();
		}
		System.out.println("Thanks For Using Our Website!!");
	       
	 }
}

