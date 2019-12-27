
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
	
    static  ArrayList<Products> products = new ArrayList<Products>();
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

			String str[] = { "Product added by StoreOwner is " + StoreOwner_Add.getName(), dtf.format(now) };
			hist.write_Historyfile(str);

			System.out.println("Product Is Added Successfuly");

		} else {
			System.out.println("Product Is Not Approved");
		}
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

	public void undoEdit(Products x) throws IOException
        {
                File f = new File("Before Edit.txt");
                FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1 = null, s4 = null;
		String s2 = null, s3 = null;
                while (read.hasNext()) {
			s1 = read.nextLine();
			s2 = read.nextLine();
			s3 = read.nextLine();
			s4 = read.nextLine();
                
                 if (x.getName().contentEquals(s1))
                    {   x.setName(s1);
                        x.setPrice(s2);
                        x.setBrand(s3);
                        x.setCategory(s4);
                        System.out.println(x.getName());
                        System.out.println(x.getPrice());
                        System.out.println(x.getBrand());
                        System.out.println(x.getCategory());
                        break;
                    }
                        
                    }
               for (int i=0;i<products.size();i++)
                {
                if (x.getName().contentEquals(products.get(i).getName()))
                {
                products.get(i).setName(x.getName());
                products.get(i).setPrice(x.getPrice());
                products.get(i).setBrand(x.getBrand());
                products.get(i).setCategory(x.getCategory());
                //System.out.println(products.get(i).getName());
                //System.out.println(products.get(i).getPrice());
                
                }
            
                 
                 
     			PrintWriter writer = new PrintWriter("StoreProducts.txt");
     			writer.print("");
     			writer.close();
                 
     			File file1 = new File("StoreProducts.txt");

          
     			
     			for (int j = 0; j < products.size(); j++) {
			   s1= products.get(j).getName();
		        s2=products.get(j).getPrice();
		        s3=products.get(j).getBrand();
			    s4=products.get(j).getCategory();
			 /* System.out.println(products.get(j).getName());
              System.out.println(products.get(j).getPrice());*/
          	  String str[] = { s1, s2, s3, s4 };
          	File_write.Write(file1, str);
                }
              
                }
   
        }

	
	}

