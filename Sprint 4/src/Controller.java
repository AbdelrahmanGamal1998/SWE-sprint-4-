import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;

public class Controller /*extends TimerTask*/ {
	
public User verify(String type ,String us,String ps) throws IOException {
		File f = new File("Users.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s = null ;
		String x,y,z,s1 = null;
		String	s2 = null;	
		User u=new User();
		while(read.hasNext()) {
			        s2=read.nextLine();
                    s1=read.nextLine();
	                s = read.nextLine();
                    if(s2.equals(type) && s1.equals(us) && s.equals(ps)){
                        break;
                    }
		}
		z=s2;
		y=s1;
		x = s;
		  if (z.equalsIgnoreCase(type)&&y.equals(us) && x.equals(ps)) {
		      u.setName(s1);
			  System.out.println("Access Granted! Welcome!");
			  return u;
		      
		  }
		 
		    else  if(y.equals(us)) {
		        System.out.println("Invalid Password!");
		        return null;
		       
		 } else if (x.equals(ps)) {
		        System.out.println("Invalid Username!");
		        return null;
		    } else {
		        System.out.println("Invalid Username & Password!");
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