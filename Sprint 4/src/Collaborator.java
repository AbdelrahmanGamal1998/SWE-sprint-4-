import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
public class Collaborator extends TimerTask {

	StoreOwner collaborator = new StoreOwner();
	
	Database Database1=new Database();
	
public void addProduct_bycollaborator() throws IOException {
		File f = new File("Collaborator.txt");
	   Products1 Product_name = new Products1();
		collaborator.addProduct();	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		   String a[]= {"Product added by collaborator is "+ collaborator.StoreOwner_Add.getName(), dtf.format(now)};
			Database1.Write(f, a);
			System.out.println("Product added by collaborator at :");
			System.out.println(dtf.format(now));
		
	}

	
	
	
	public void viewStatistics_bycollaborator() throws IOException {
		File file = new File("Collaborator.txt");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String a[]= {"Statistacs viewed by collaborator", dtf.format(now)};
					Database1.Write(file, a);
		            
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
		t.maxproduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		}
	 
	
	
}

