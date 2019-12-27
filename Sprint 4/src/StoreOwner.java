
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

public class StoreOwner extends User implements Products     {
        static  ArrayList<Products1> products = new ArrayList<>();
	Store Add_store = new Store();
	Admin Approve_products = new Admin();
	Products1 StoreOwner_Add = new Products1();
	Database_write_infile Database1 = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	User StoreOwn = new User();
	Delete item = new Delete();
	Edit price = new Edit();

	public void Buy_Product(User u) throws IOException {
		StoreOwn.BuyProduct(u);
	}

	public void add_Collaborator() throws IOException {
		File f = new File("Collaborator.txt");
		System.out.println("Please Enter Collaborator name");
		Scanner e = new Scanner(System.in);
		String v = e.next();
		System.out.println("Please Enter the Collaborator Store Name ");
		Scanner e1 = new Scanner(System.in);
		String v1 = e1.next();
		System.out.println(" Collaborator Added Successfuly");
		String a[] = { v, v1 };
		Database1.Write(f, a);

	}

	public void addStore() throws IOException {
		Add_store.IsOnline();
	}

	public void addProduct() throws IOException {
		// TODO Auto-generated method stub
		File f = new File("StoreProducts.txt");
		File file = new File("History.txt");
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
		StoreOwner_Add.setCategory(p.next().toLowerCase());
		if (Approve_products.approveProduct(StoreOwner_Add.getName()) == true) {
			String a[] = { StoreOwner_Add.getName(), StoreOwner_Add.getPrice(), StoreOwner_Add.getBrand(),
					StoreOwner_Add.getCategory() };
			Database1.Write(f, a);

			String str[] = { "Product added by StoreOwner is " + StoreOwner_Add.getName(), dtf.format(now) };
			Database1.Write(file, str);

			System.out.println("Product Is Added Successfuly");

		} else {
			System.out.println("Product Is Not Approved");
		}
	}

	public void deleteProduct() throws IOException {
		File inputFile = new File("StoreProducts.txt");
		File tempFile = new File("newFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = item.Delete();
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
			String a[] = { s0, s1, s2, s3 };
			Database1.Write(tempFile, a);

		}
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		File file = new File("History.txt");
		String s[] = { "Product Deleted by StoreOwner is " + lineToRemove, dtf.format(now) };
		Database1.Write(file, s);
		System.out.println("Product Is deleted  Successfuly");
	}

	public void UpdatedProductPrice() throws IOException {
		File f = new File("StoreProducts.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1, s4 = null;
		String s2, s3 = null;
		ArrayList<String> to_BeEdited = new ArrayList<String>();
		to_BeEdited = price.EditPrice();
		String a = to_BeEdited.get(0);
		String b = to_BeEdited.get(1);

		while (read.hasNext()) {
			s1 = read.nextLine();
			s2 = read.nextLine();
			s3 = read.nextLine();
			s4 = read.nextLine();
			Products1 x = new Products1(s1, s2, s3, s4);
			products.add(x);
                        
                        File filex = new File("Before Edit.txt");
                        for (int j = 0; j < products.size(); j++) 
                        {
			s1 = products.get(j).getName();
			s2 = products.get(j).getPrice();
			s3 = products.get(j).getBrand();
			s4 = products.get(j).getCategory();
			String str[] = { s1, s2, s3, s4 };
			Database1.Write(filex, str);
                        }
                        
			PrintWriter writer = new PrintWriter("StoreProducts.txt");
			writer.print("");
			writer.close();
		}

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(a)) {
				products.get(i).setPrice(b);
			}
		}
		File file1 = new File("StoreProducts.txt");
		for (int j = 0; j < products.size(); j++) {
			s1 = products.get(j).getName();
			s2 = products.get(j).getPrice();
			s3 = products.get(j).getBrand();
			s4 = products.get(j).getCategory();
			String str[] = { s1, s2, s3, s4 };
			Database1.Write(file1, str);
			File file = new File("History.txt");
			String s[] = { "Product Edited by StoreOwner is " + a, dtf.format(now) };
			Database1.Write(file, s);
		}
		System.out.println("The Price Of This Product Is Updated Successfuly");
		/*for (int i=0;i<products.size();i++)
		{
			System.out.println(products.get(i).getName());
			System.out.println(products.get(i).getPrice());
			
		}*/

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

	public void undoEdit(Products1 x) throws IOException
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
			  Database1.Write(file1, str);
                }
              
                }
   
        }

	
	}

