
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;


public class Store  {

	private String storeName;
	private String storeType;
	private String storeAddress;
	private Admin Approve_store;
	Database Database1=new Database();
	
public String getStoreType() {
		return storeType;
	}

public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

public String getStoreName() {
		return storeName;
	}
	
public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
public String getStoreAddress() {
		return storeAddress;
	}
	
public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
		
public void IsOnline() throws IOException {	
		File f = new File("Store.txt");
	
	    System.out.println("Online? if yes press 1");
		Scanner x = new Scanner(System.in);
		int z = x.nextInt();
		if(z==1) {
			System.out.println("Enter store name");
			Scanner y = new Scanner(System.in);
			this.setStoreName(y.next());
			System.out.println("Enter store Type");
			Scanner q = new Scanner(System.in);
			this.setStoreType(q.next());
			Admin Approve_store = new Admin();
			Approve_store.approveStore(this.getStoreType());
			if(Approve_store.approveStore(this.getStoreType()) == true) {
				String a[]= {this.getStoreName(),this.getStoreType()};
				Database1.Write(f, a);
		
			System.out.println("Store Created!");
			
			}
			else 
				System.out.println("Store doesn't meet criteria!");
		}
		else {
			System.out.println("Enter store name");
			Scanner e = new Scanner(System.in);
			this.setStoreName(e.next());
			System.out.println("Enter store Type");
			Scanner t = new Scanner(System.in);
			this.setStoreType(t.next());
			System.out.println("Enter store address");
			Scanner u = new Scanner(System.in);
			this.setStoreAddress(u.next());
			Admin Approve_store = new Admin();
			Approve_store.approveStore(this.getStoreType());
			if(Approve_store.approveStore(this.getStoreType()) == true) {
				String a[]= {this.getStoreName(),this.getStoreType(),this.getStoreAddress()};
				Database1.Write(f, a);
			
			System.out.println("Store Created!");
		
			}
			else 
				System.out.println("Store doesn't meet criteria!");
		}
		
	}






		
}