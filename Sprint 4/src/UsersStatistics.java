import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class UsersStatistics  {
	Database_map_file databasemap=new Database_map_file();
public int sum_users() throws IOException {
		File file = new File("SoldProducts.txt"); 
	 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		 String user; 
		 String productname;
		 String price;
		 String brand;
		 String category;
		 int  sum_users=0;
		while((user = br.readLine()) != null&(productname = br.readLine()) != null&(price = br.readLine()) != null &(brand = br.readLine()) != null&(category = br.readLine()) != null) {
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
	System.out.println("Max Users : \n " + databasemap.Sort(0, file, "MAX"));	
}
	
public void min() throws IOException {
	File file=new File("SoldProducts.txt");
	System.out.println("Min Users : \n " + databasemap.Sort(0, file, "min"));
}
}
