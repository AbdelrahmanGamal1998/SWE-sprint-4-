import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class UsersStatistics  {

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

public String max() throws IOException {
	File file = new File("SoldProducts.txt");  
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	Map<String,Integer>x =new HashMap<String, Integer>();
	int i=0;
	String s0; 
	while((s0 = br.readLine()) != null) {
		if(i==0) {
		if(x.get(s0)!=null) {
			x.put(s0,x.get(s0)+1);
		}else {
			x.put(s0,1);
		}
		}
		
		i++;
		if(i==5) {
			i=0;
		}
	}
	int maxnum=0;
	String name = null;
	for(Map.Entry<String, Integer>entry:x.entrySet()) {
		if(entry.getValue()>maxnum) {
			name=entry.getKey();
		}
		}
	
	return name;
	
	}
public String min() throws IOException {
	File file = new File("SoldProducts.txt");  
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	Map<String,Integer>x =new HashMap<String, Integer>();
	int i=0;
	String s0; 
	while((s0 = br.readLine()) != null) {
		if(i==0) {
		if(x.get(s0)!=null) {
			x.put(s0,x.get(s0)+1);
		}else {
			x.put(s0,1);
		}
		
		}	
		i++;
		if(i==5) {
			i=0;
		}
	}
	int minnum=100;
	String name = null;
	for(Map.Entry<String, Integer>entry:x.entrySet()) {
		if(entry.getValue()<minnum)
		{
			minnum=entry.getValue();
			name=entry.getKey();
		}}
	return name;
		}



	
}

