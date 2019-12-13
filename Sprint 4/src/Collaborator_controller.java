

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Collaborator_controller {
	public void verify_Collaborator(String name ,String storename) throws IOException {
		File f = new File("StoreOwner.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1 = null ;
		String x,y,s2 = null;
        while(read.hasNext()) {
			   
                     s1=read.nextLine();
	                s2 = read.nextLine();
                    if(s1.equals(name) && s1.equals(storename)){
                        break;
                    }
		}
		y=s1;
		x = s2;
		  if (y.equals(name) && x.equals(storename)) {
			  System.out.println("Access Granted! Welcome in :" + storename);
		      
		  }
		 
		    else  if(y.equals(name)) {
		        System.out.println("Invalid Collaborator name !");
		     
		       
		 } else if (x.equals(storename)) {
		        System.out.println("Invalid Store name!");
		     
		    } else {
		        System.out.println("Invalid name & Store name ");
		      
		    }
	}
}
