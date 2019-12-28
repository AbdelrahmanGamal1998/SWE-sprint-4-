import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit {
	
	static  ArrayList<Products> products = new ArrayList<Products>();
	Database_write_infile Filewrite = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	History edit_History = new History();

	public ArrayList<String> EditPrice() throws IOException {
		ArrayList<String> edit = new ArrayList<String>();
		System.out.println("Please enter the offerd product name you want to Edit");
		Scanner x1 = new Scanner(System.in);
		String edited = x1.next();
		System.out.println("Please enter the new offerd product price ");
		Scanner x2 = new Scanner(System.in);
		String edited2 = x2.next();
		edit.add(0, edited);
		edit.add(1,edited2);
		return edit;
	}
	
	public void UpdatedProductPrice() throws IOException {
		File f = new File("StoreProducts.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1, s4 = null;
		String s2, s3 = null;
		ArrayList<String> to_BeEdited = new ArrayList<String>();
		to_BeEdited = EditPrice();
		String a = to_BeEdited.get(0);
		String b = to_BeEdited.get(1);

		while (read.hasNext()) {
			s1 = read.nextLine();
			s2 = read.nextLine();
			s3 = read.nextLine();
			s4 = read.nextLine();
			Products x = new Products(s1, s2, s3, s4);
			products.add(x);
                        
                        File filex = new File("Before Edit.txt");
                        for (int j = 0; j < products.size(); j++) 
                        {
			s1 = products.get(j).getName();
			s2 = products.get(j).getPrice();
			s3 = products.get(j).getBrand();
			s4 = products.get(j).getCategory();
			String str[] = { s1, s2, s3, s4 };
			Filewrite.Write(filex, str);
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
			Filewrite.Write(file1, str);
			String s[] = { "Product Edited by StoreOwner is " + a, dtf.format(now) };
			edit_History.write_Historyfile(s);
		}
		System.out.println("The Price Of This Product Is Updated Successfuly");

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
      	Filewrite.Write(file1, str);
            }
          
            }

    }



}
