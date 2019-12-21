
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Collaborator_controller {
 
	public static void verify_Collaborator(String name, String storename) throws IOException {
		Database_verification Databaseverify = new Database_verification();
		
		File f = new File("Collaborator.txt");
		String a[]= {name,storename};
		int value=Databaseverify.verify_controller(f, a);
		
		if(value==1) {
			
			System.out.println("Access Granted! Welcome in :" + a[1]);
			
			
		}
		else if (value==2){
			
			System.out.println("Invalid Collaborator name !");
			System.exit(0);

			
		}
		
		else if (value==0) {
			
			System.out.println("Invalid Store name!");
			System.exit(0);
		}
		
		else {
			
			
			System.out.println("Invalid name & Store name ");
			System.exit(0);
		}
			
}
}