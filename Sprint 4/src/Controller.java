import java.io.File;
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
			  



/*public void run() {	
	     int x = (int)(Math.random()*((15-9)+1))+9;
	     System.out.println("Number of Store views : " + x);
	     int s = (int)(Math.random()*((8-2)+1))+2;
	     System.out.println("Number of user buy a store’s produce : " + s);
	     int t = (int)(Math.random()*((7-6)+1))+6;
	     System.out.println("Number of sold products in store : " + t);
	}*/

}