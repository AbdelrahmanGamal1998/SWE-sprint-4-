import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class UsersStatistics  {
    Database database2=new Database();

public int sum_users() throws IOException {
		File file = new File("SoldProducts.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		 String s0; 
		 String s1;
		 String s2;
		 String s3;
		 String s4;
		 int  sum_users=0;
		while((s0 = br.readLine()) != null&(s1 = br.readLine()) != null&(s2 = br.readLine()) != null &(s3 = br.readLine()) != null&(s4 = br.readLine()) != null) {
			sum_users++;
	}
		
		return sum_users;		
}


public int avg_users() throws IOException {
		int sum = sum_users();
		return sum/2 ;
		
}

public void max() throws IOException {
	File file=new File("SoldProducts.txt");
	System.out.println("Max Users : \n " + database2.Sort(0, file, "MAX"));	
}
	
public void min() throws IOException {
	File file=new File("SoldProducts.txt");
	System.out.println("Min Users : \n " + database2.Sort(0, file, "min"));
}

}