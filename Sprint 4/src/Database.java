import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

	public void Write(File file,String []a) throws IOException {
		
		FileWriter h = new FileWriter(file, true);
		 for (String i: a) {
		h.write(i);
		h.write("\n");
	      }     
		 h.close();	 
	}
	
	
	public String Sort(int count,File file,String m) throws IOException{
        
        
	       
		int minnum=100;
	        String name = null;
	        int maxmum=0;

	       
	    BufferedReader br = new BufferedReader(new FileReader(file)); 
		Map<String,Integer>x =new HashMap<String, Integer>();
		
		String line; 
		while((line = br.readLine()) != null) {
			if(count==0) {
			if(x.get(line)!=null) {
				x.put(line,x.get(line)+1);
			}else {
				x.put(line,1);
			}
			
			}	
			count++;
			if(count==5) {
				count=0;
			}
	              
		}
	        
	        if(m.equals("MAX"))
	        {
	        
	     
		for(Map.Entry<String, Integer>entry:x.entrySet()) {
			if(entry.getValue()>maxmum)
			{
				maxmum=entry.getValue();
				name=entry.getKey();
			}
	              
		
	        }}
	        else 
	            
	   
	        {
	         for(Map.Entry<String, Integer>entry:x.entrySet()) {
			if(entry.getValue()<minnum)
			{
				minnum=entry.getValue();
		 name=entry.getKey();
	                        

			}
	                
	    
	         }}
	        return name;
	    
	      
	    
	    }
}

