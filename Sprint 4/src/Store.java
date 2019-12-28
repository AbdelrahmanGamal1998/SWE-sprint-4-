
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;

public class Store {

	private String storeName;
	private String storeType;
	private String storeAddress;
	Admin Approve_store = new Admin();
	Database_write_infile Database1 = new Database_write_infile();

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
		Scanner input1 = new Scanner(System.in);
		int z = input1.nextInt();
		if (z == 1) {
			System.out.println("Enter store name");
			Scanner input2 = new Scanner(System.in);
			this.setStoreName(input2.next());
			System.out.println("Enter store Type");
			Scanner input3 = new Scanner(System.in);
			this.setStoreType(input3.next());
			Approve_store.approveStore(this.getStoreType());
			if (Approve_store.approveStore(this.getStoreType()) == true) {
				String  Store_info[] = { this.getStoreName(), this.getStoreType() };
				Database1.Write(f,Store_info);

				System.out.println("Store Created!");

			} else
				System.out.println("Store doesn't meet criteria!");
		} else {
			System.out.println("Enter store name");
			Scanner input11 = new Scanner(System.in);
			this.setStoreName(input11.next());
			System.out.println("Enter store Type");
			Scanner input2 = new Scanner(System.in);
			this.setStoreType(input2.next());
			System.out.println("Enter store address");
			Scanner input3 = new Scanner(System.in);
			this.setStoreAddress(input3.next());

			Approve_store.approveStore(this.getStoreType());
			if (Approve_store.approveStore(this.getStoreType()) == true) {
				String Store_info[] = { this.getStoreName(), this.getStoreType(), this.getStoreAddress() };
				Database1.Write(f,Store_info );

				System.out.println("Store Created!");

			} else
				System.out.println("Store doesn't meet criteria!");
		}

	}

}