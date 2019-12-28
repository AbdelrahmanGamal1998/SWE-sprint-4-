
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.Random;
import java.awt.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoreOwner extends User {
	
	Store Add_store = new Store();
	Admin Approve_products = new Admin();
	Products StoreOwner_Add = new Products();
	Database_write_infile File_write = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	User StoreOwn = new User();
	Delete item = new Delete();
	Edit update = new Edit();
	History hist = new History();

	public void Buy_Product(User u) throws IOException {
		StoreOwn.BuyProduct(u);
	}

	public void add_Collaborator(String Collaborator_name,String Store_Name) throws IOException {
		File f = new File("Collaborator.txt");
		System.out.println(" Collaborator Added Successfuly");
		String a[] = {Collaborator_name,Store_Name};
		File_write.Write(f, a);
	}

	public void addStore() throws IOException {
		Add_store.IsOnline();
	}

	public void addProduct(Scanner name,Scanner price,Scanner brand,Scanner category) throws IOException {
		File f = new File("StoreProducts.txt");
		StoreOwner_Add.setName(name.next());
		StoreOwner_Add.setPrice(price.next());
		StoreOwner_Add.setBrand(brand.next());
		StoreOwner_Add.setCategory(category.next().toLowerCase());
		if (Approve_products.approveProduct(StoreOwner_Add.getName()) == true) {
			String a[] = { StoreOwner_Add.getName(), StoreOwner_Add.getPrice(), StoreOwner_Add.getBrand(),
					StoreOwner_Add.getCategory() };
			File_write.Write(f, a);

			/*String str[] = { "Product added by StoreOwner is " + StoreOwner_Add.getName(), dtf.format(now) };
			hist.write_Historyfile(str);
*/              Added_Prtoduct_StoreOwner_write_in_history_file();
			System.out.println("Product Is Added Successfuly");

		} else {
			System.out.println("Product Is Not Approved");
		}
	}

	
	
	public void Added_Prtoduct_StoreOwner_write_in_history_file() throws IOException {
	String str[] = { "Product added by StoreOwner is " + StoreOwner_Add.getName(), dtf.format(now) };
	hist.write_Historyfile(str);
	}
	
	public void StoreOwner_Deleteproduct() throws IOException {
		item.deleteProduct();
	}

	public void StoreOwner_Updateproduct() throws IOException {
		update.UpdatedProductPrice();
	}

	public void StoreOwner_login() throws IOException {
		StoreOwn.login();
	}

	public void Check_History() throws IOException {
		File file = new File("History.txt");
		String s0;
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((s0 = br.readLine()) != null) {
			System.out.println(s0);
		}
	}
	
	public void StoreOwner_Undo() throws IOException {
		 Products s = new Products();
		  s.setName("coca");
		  s.setPrice("15");
		  s.setBrand(null);
		  s.setCategory(null);
		update.undoEdit(s);
	}
	
}