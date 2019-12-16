
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.Random;

import test.Products;

import java.awt.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;



public class StoreOwner  extends User   implements Products{

	private Store Add_store;
	private Admin Approve_products;	
	
	private Products1 StoreOwner_Add;
	private Statistics viewers;
	private Object inputFile;		
	Database Database1= new Database(); 
public void addStore() throws IOException {
	Store Add_store = new Store();
	Add_store.IsOnline();
}
	 
public void addProduct() throws IOException {
	// TODO Auto-generated method stub
   
	File f = new File("StoreProducts.txt");
	
	Products1 StoreOwner_Add = new Products1();
	System.out.println("Enter name");
	Scanner x = new Scanner(System.in);
	StoreOwner_Add.setName(x.next());
	System.out.println("Enter price");
	Scanner y = new Scanner(System.in);
	StoreOwner_Add.setPrice(y.next());
	System.out.println("Enter Brand");
	Scanner u = new Scanner(System.in);
	StoreOwner_Add.setBrand(u.next());
	System.out.println("Enter category");
	Scanner p = new Scanner(System.in);
	StoreOwner_Add.setCategory(p.next());
	Admin Approve_products = new Admin();
	if(Approve_products.approveProduct(StoreOwner_Add.getName())==true) {
		String a[]= {StoreOwner_Add.getName(),StoreOwner_Add.getPrice() ,StoreOwner_Add.getBrand(),StoreOwner_Add.getCategory() };
		Database1.Write(f, a);

	System.out.println("Product Is Added Successfuly");
	
	
	}
	else {
		System.out.println("Product Is Not Approved");
	}
}


public String deleteProduct1() {
	System.out.println("Please enter the product name you want to delete ");
	Scanner x1 = new Scanner(System.in);
	String deleted = x1.next();
	return deleted;
}

public void deleteProduct() throws IOException {
	File inputFile = new File("StoreProducts.txt");
	File tempFile = new File("newFile.txt");

	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	String lineToRemove = deleteProduct1();
	String s0;
	String s1;
	String s2;
	String s3;

	while ((s0 = reader.readLine()) != null & (s1 = reader.readLine()) != null & (s2 = reader.readLine()) != null
			& (s3 = reader.readLine()) != null) {
		// trim newline when comparing with lineToRemove
		String trimmedLine0 = s0.trim();
		String trimmedLine1 = s1.trim();
		String trimmedLine2 = s2.trim();
		String trimmedLine3 = s3.trim();
		if (trimmedLine0.equals(lineToRemove))
			continue;
		writer.write(s0 + System.getProperty("line.separator"));
		writer.write(s1 + System.getProperty("line.separator"));
		writer.write(s2 + System.getProperty("line.separator"));
		writer.write(s3 + System.getProperty("line.separator"));
	}
	writer.close();
	reader.close();
	inputFile.delete();
	boolean successful = tempFile.renameTo(inputFile);
	System.out.println("Product Is deleted  Successfuly");
}


public void EditProduct() throws IOException {
	System.out.println("Please enter the product name you want to Edit");
	Scanner x1 = new Scanner(System.in);
	String edited = x1.next();
	System.out.println("Please enter the new product price ");
	Scanner x2 = new Scanner(System.in);
	String edited2 = x2.next();
	UpdatedProductPrice(edited, edited2);
	 System.out.println(" The Price Of This Product Is Updated Successfuly");
}

public void UpdatedProductPrice(String a, String b) throws IOException {
	ArrayList<Products1> P = new ArrayList<Products1>();
	File f = new File("StoreProducts.txt");
	FileReader r = new FileReader(f);
	Scanner read = new Scanner(f);
	String s1, s4 = null;
	String s2, s3 = null;

	while (read.hasNext()) {
		s1 = read.nextLine();
		s2 = read.nextLine();
		s3 = read.nextLine();
		s4 = read.nextLine();
		Products1 x = new Products1(s1, s2, s3, s4);
		P.add(x);
		PrintWriter writer = new PrintWriter("StoreProducts.txt");
		writer.print("");
		writer.close();
	}

	for (int i = 0; i < P.size(); i++) {
		if (P.get(i).getName().equals(a)) {
			P.get(i).setPrice(b);
		}
	}
	File file1 = new File("StoreProducts.txt");
	for (int j = 0; j < P.size(); j++) {
		s1 = P.get(j).getName();
		s2 = P.get(j).getPrice();
		s3 = P.get(j).getBrand();
		s4 = P.get(j).getCategory();
		String str[]= {s1,s2,s3,s4 };
		Database1.Write(file1, str);
	}

}

public void StoreOwner_login() throws IOException { 
	 User obj3 = new User();
    obj3.login(); 
    }


public void Check_History() throws IOException {
	String s0;
	File file = new File("History.txt"); 
	 
	BufferedReader br = new BufferedReader(new FileReader(file)); 

	while((s0 = br.readLine()) != null) {
		 
	  System.out.println(s0);
		 }
	
	
}


}


/*public void getviews() throws FileNotFoundException, IOException {
	int x = (int)(Math.random()*((15-9)+1))+9;
    System.out.println("Number of Store views : " + x);
    int s = (int)(Math.random()*((8-2)+1))+2;
    System.out.println("Number of user buy a store’s produce : " + s);
    int t = (int)(Math.random()*((7-6)+1))+6;
    System.out.println("Number of sold products in store : " + t);
}
		*/
