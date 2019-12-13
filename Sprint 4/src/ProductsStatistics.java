import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductsStatistics {

public String minproduct() throws IOException {
		File file = new File("SoldProducts.txt");  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		Map<String,Integer>x =new HashMap<String, Integer>();
		int i=0;
		String s0; 
		while((s0 = br.readLine()) != null) {
			if(i==1) {
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
			}
			}
		
		return name;
		
		}

public String maxproduct() throws IOException {
	
	File file = new File("SoldProducts.txt");  
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	Map<String,Integer>x =new HashMap<String, Integer>();
	int i=0;
	String s0; 
	while((s0 = br.readLine()) != null) {
		if(i==1) {
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
	int maxmum=0;
	String name = null;
	for(Map.Entry<String, Integer>entry:x.entrySet()) {
		if(entry.getValue()>maxmum)
		{
			maxmum=entry.getValue();
			name=entry.getKey();
		}
		}
	
	return name;
	
	}
}
		
		


