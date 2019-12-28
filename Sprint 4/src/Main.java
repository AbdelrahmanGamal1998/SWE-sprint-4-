import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;


public class Main{

public static void main(String[] args) throws IOException {

 User q = new User();
	System.out.println("Welcome to 5od Fekra w Eshtery Bokra!"); 
	int r=1;
	while(r==1) {
	System.out.println("New Account? Press 0 / Login? Press 1");
	Scanner l = new Scanner(System.in);
	int h = l.nextInt();
	if(h==0) {
		q.createaccount();
		 System.out.println("Do you wish to login to our website 1 / Exit? Press 2");
		  Scanner m = new Scanner(System.in);
				 r = m.nextInt();
				 if(r==2) {	System.out.println("salam  yabn el gazma matgesh hena tany!!");}
	}
	else if(h==1) {
	System.out.println("Admin? Press 0 / Customer? Press 1 / StoreOwner? Press 2 / Collaborator? Press 3");
	Scanner k = new Scanner(System.in);
	int o = k.nextInt();
	if(o == 0) {
		AdminMain d = new AdminMain();
		d.AdminMain();
		
	}
	else if(o == 1) {
		CustomerMain s = new CustomerMain();
		s.CustomerMain();
	
	}
	else if(o == 2) {
		StoreOwnerMain c = new StoreOwnerMain();
		c.StoreOwnerMain();
		
	}
	else if(o == 3) {
		CollaboratorMain m = new CollaboratorMain();
		m.CollaboratorMain();
	}

	else
		System.out.println("3ayez eh delwa2ty!!");
	}
	
	else
		System.out.println("Yagada3 2olna 0 aw 1 :D");

}}
}