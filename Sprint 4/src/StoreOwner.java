
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
	
	private String product_Name;
	Store Add_store = new Store();
	Products StoreOwner_Add = new Products();
	Database_write_infile File_write = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	User StoreOwn = new User();
	Delete item = new Delete();
	Edit update = new Edit();
	History hist = new History();
	Buy_Offer buuy = new Buy_Offer();
	
	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public void Buy_Product(User u) throws IOException {
		buuy.BuyProduct(u);
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

	public void StoreOwner_addProduct(Scanner name,Scanner price,Scanner brand,Scanner category) throws IOException {
		String file_Name = "StoreProducts.txt";
		setProduct_Name(StoreOwner_Add.addProduct(name, price, brand, category, file_Name));
		String str[] = { "Product added by StoreOwner is " + getProduct_Name(), dtf.format(now) };
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