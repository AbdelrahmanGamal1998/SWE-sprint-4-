import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;

public class Controller  {
	
public User verify(String type ,String us,String ps) throws IOException {
		File f = new File("Users.txt");
		Database database3= new Database();
			String a[]= { type,us,ps };
		int value=database3.verify(f, a);
		User u=new User();
		u.setName(us);
		
		if(value==1) {
			
			 System.out.println("Access Granted! Welcome!");
			 return u;
		

			
		}
		else {
			System.out.println("Invalid Username & Password!");
			System.exit(0);
			 return null;
		}
	     
}

public boolean verify_Account(String username,String password) throws IOException {
	File check = new File("Users.txt");
	BufferedReader reader = new BufferedReader(new FileReader(check));
	String s0,s1,s2;
	while((s0 = reader.readLine())!=null & (s1 = reader.readLine())!=null & (s2 = reader.readLine())!=null) {
		if(s1.equals(username)) {
			System.out.println("UserName Is Used");
			return false;
		}
	}
	return true;
}
			  
}