import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
public class Collaborator extends TimerTask {

	StoreOwner collaborator = new StoreOwner();
	

	public void addProduct_bycollaborator() throws IOException {
		File f = new File("Collaborator.txt");
		FileWriter h = new FileWriter(f, true);
		collaborator.addProduct();	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
			h.write("Product added by collaborator" );
			h.write("\n");
			h.write(dtf.format(now));
			h.write("\n");
			System.out.println("Product added by collaborator at :");
			System.out.println(dtf.format(now));
			h.close();
	}
	
	
	
	
	public void viewStatistics_bycollaborator() throws IOException {
		File file = new File("Collaborator.txt");
		FileWriter h2 = new FileWriter(file, true);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		
		            h2.write("Statistacs viewed by collaborator" );
					h2.write("\n");
					h2.write(dtf.format(now));
					h2.write("\n");
					
					h2.close();
	}
		
		
		
	
	@Override
	public void run() {
		 try {
			viewStatistics_bycollaborator();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UsersStatistics v=new UsersStatistics();
		ProductsStatistics t=new  ProductsStatistics();
		System.out.println("the sold products Statistics by Collaborator");
		try {
			System.out.println(v.sum_users());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the  Most Ordered Product Statistics  by Collaborator");
		try {
			System.out.println(t.maxproduct());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		}
	 
	
	
}

