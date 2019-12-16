import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;


public class Main{

public static void main(String[] args) throws IOException {
	//Collaborator v=new Collaborator();
	//Admin Q = new Admin();
StoreOwner x = new StoreOwner();
	//d.EditOffer();
//Q.deleteOffer();
//x.deleteProduct();
	//v.addProduct_bycollaborator();
	//v.viewStatistics_bycollaborator();
	//StoreOwner c = new StoreOwner();
    //c.check_History_of_collaborator();
	//c.deleteProduct();
 // x .EditProduct();
	  //c.deleteProduct();
//}}
 User q = new User();
	System.out.println("Welcome to 5od Fekra w Eshtery Bokra!"); 
	System.out.println("New Account? Press 0 / Login? Press 1");
	Scanner l = new Scanner(System.in);
	int h = l.nextInt();
	if(h==0) {
		q.createaccount();
	}
	else if(h==1) {
	System.out.println("Admin? Press 0 / User? Press 1 / StoreOwner? Press 2");
	Scanner k = new Scanner(System.in);
	int o = k.nextInt();
	if(o == 0) {
		AdminMain d = new AdminMain();
		d.AdminMain();
		
	}
	else if(o == 1) {
		UserMain s = new UserMain();
		s.UserMain();
	
	}
	else if(o == 2) {
		StoreOwnerMain c = new StoreOwnerMain();
		c.StoreOwnerMain();
		
	}

	else
		System.out.println("3ayez eh delwa2ty!!");
	}
	
	else
		System.out.println("Yagada3 2olna 0 aw 1 :D");

	}

	
}