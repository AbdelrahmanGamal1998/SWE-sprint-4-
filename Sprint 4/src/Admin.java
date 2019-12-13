import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import test.Products;

public class Admin implements Products {

	private String OfferName;
	private String Offerprice;
	private String brandname;

	private String brandcategory;
	private StoreController Admin_controller;
	private User Admin_log;
	private Products1 Add_product;
	private ProductController AdminProd_Controller;
	private UsersStatistics user;
	private ProductsStatistics products;

	public String getOfferName() {
		return OfferName;
	}

	public void setOfferName(String offerName) {
		OfferName = offerName;
	}

	public String getOfferprice() {
		return Offerprice;
	}

	public void setOfferprice(String offerprice) {
		Offerprice = offerprice;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrandcategory() {
		return brandcategory;
	}

	public void setBrandcategory(String brandcategory) {
		this.brandcategory = brandcategory;
	}

	public Admin(String offerName, String offerprice) {
		super();
		OfferName = offerName;
		Offerprice = offerprice;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addbrands() throws IOException {
		File f = new File("AdminBrands");
		FileWriter h = new FileWriter(f, true);
		System.out.println("Enter Brand name");
		Scanner x = new Scanner(System.in);
		this.setBrandname(x.next());
		System.out.println("Enter Brand category");
		Scanner p = new Scanner(System.in);
		this.setBrandcategory(p.next());
		h.write(this.getBrandname());
		h.write("\n");
		h.write(this.getBrandcategory());
		h.write("\n");
		System.out.println("Brand Is Added Successfuly");
		h.close();

	}

	public void Offers() throws IOException {

		File f = new File("Offers.txt");
		FileWriter h = new FileWriter(f, true);
		System.out.println("Enter name");
		Scanner e = new Scanner(System.in);
		String v = e.next();
		System.out.println("Enter Offerd price");
		Scanner j1 = new Scanner(System.in);
		String a1 = j1.next();
		h.write(v);
		h.write("\n");
		h.write(a1);
		h.write("\n");
		h.close();
	}

	public String Get_the_deleted_offer_name(){
		System.out.println("Please enter the Offer name you want to delete ");
		Scanner x1 = new Scanner(System.in);
		String deleted = x1.next();
		return deleted;
	}

	public void deleteOffer() throws IOException {
		File inputFile = new File("Offers.txt");
		File tempFile = new File("newFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = Get_the_deleted_offer_name();
		String s0;
		String s1;
	

		while ((s0 = reader.readLine()) != null & (s1 = reader.readLine()) != null )
				 {
			// trim newline when comparing with lineToRemove
			String trimmedLine0 = s0.trim();
			String trimmedLine1 = s1.trim();
			
			if (trimmedLine0.equals(lineToRemove))
				continue;
			writer.write(s0 + System.getProperty("line.separator"));
			writer.write(s1 + System.getProperty("line.separator"));
			
		}
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		System.out.println("Product Is deleted  Successfuly");
	}


	public void EditOffer() throws IOException {
		System.out.println("Please enter the product name you want to Edit");
		Scanner x1 = new Scanner(System.in);
		String edited = x1.next();
		System.out.println("Please enter the new product price ");
		Scanner x2 = new Scanner(System.in);
		String edited2 = x2.next();
		 UpdatedOfferPrice(edited, edited2);
		 System.out.println(" The Price On this Offer Is Updated Successfuly");
	}

	public void UpdatedOfferPrice(String a, String b) throws IOException {
		ArrayList<Admin> A = new ArrayList<Admin>();
		File f = new File("Offers.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1, s2 = null;

		while (read.hasNext()) {
			s1 = read.nextLine();
			s2 = read.nextLine();

			Admin x = new Admin(s1, s2);
			A.add(x);
			PrintWriter writer = new PrintWriter("Offers.txt");
			writer.print("");
			writer.close();
		}

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).getOfferName().equals(a)) {
				A.get(i).setOfferprice(b);
			}
		}
		File file1 = new File("Offers.txt");
		FileWriter h1 = new FileWriter(file1, true);
		for (int j = 0; j < A.size(); j++) {
			s1 = A.get(j).getOfferName();
			s2 = A.get(j).getOfferprice();

			h1.write(s1);
			h1.write("\n");
			h1.write(s2);
			h1.write("\n");

		}
		h1.close();
	}

	public void addProduct() throws IOException {
		// TODO Auto-generated method stub
		File f = new File("AdminProducts.txt");
		FileWriter h = new FileWriter(f, true);
		Products1 Add_product = new Products1();
		System.out.println("Enter name");
		Scanner x = new Scanner(System.in);
		Add_product.setName(x.next());
		System.out.println("Enter price");
		Scanner y = new Scanner(System.in);
		Add_product.setPrice(y.next());
		System.out.println("Enter Brand");
		Scanner u = new Scanner(System.in);
		Add_product.setBrand(u.next());
		System.out.println("Enter category");
		Scanner p = new Scanner(System.in);
		Add_product.setCategory(p.next());
		h.write(Add_product.getName());
		h.write("\n");
		h.write(Add_product.getPrice());
		h.write("\n");
		h.write(Add_product.getBrand());
		h.write("\n");
		h.write(Add_product.getCategory());
		h.write("\n");
		System.out.println("Product Is Added Successfuly");
		h.close();
	}

	public boolean approveStore(String w) throws IOException {
		StoreController Admin_controller = new StoreController();
		return Admin_controller.VerifyStore(w);
	}

	public boolean approveProduct(String i) throws IOException {
		ProductController AdminProd_Controller = new ProductController();
		return AdminProd_Controller.VerifyProduct(i);
	}

	public void Admin_login() throws IOException {
		User Admin_log = new User();
		Admin_log.login();
	}

	public void User_statistics() throws IOException {
		UsersStatistics user = new UsersStatistics();
		System.out.println("Sum Users: ");
		System.out.println(user.sum_users());
		System.out.println("Max Users : ");
		System.out.println(user.max());
		System.out.println("Average Users : ");
		System.out.println(user.avg_users());
		System.out.println("Min Users : ");
		System.out.println(user.min());
		System.out.println("Sum products: ");
		System.out.println(user.sum_users());
		System.out.println("Average Products : ");
		System.out.println(user.avg_users());
	}

	public void Products_statistics() throws IOException {
		ProductsStatistics products = new ProductsStatistics();
		System.out.println("Min Products : ");
		System.out.println(products.minproduct());
		System.out.println("Max Products : ");
		System.out.println(products.maxproduct());
	}

}

/*
 * public Products search(String name) throws FileNotFoundException,
 * IOException{ int count = 1; Integer intInstance = new Integer(count); String
 * numberAsString = intInstance.toString(); BufferedReader reader=new
 * BufferedReader(new
 * FileReader("F:\\College\\Software Engineering 2 project code\\SWE - copy"));
 * String row=reader.readLine(); while(row!=null){ String[]
 * fields=row.split(" "); String CurrentProduct=fields[0];
 * if(name.equals(CurrentProduct)){ System.out.println(row); }
 * row=reader.readLine(); } DateTimeFormatter dtf =
 * DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); LocalDateTime now =
 * LocalDateTime.now(); PrintWriter writer =new PrintWriter(new
 * FileWriter("",true)); String newRow=this.getName(); newRow =
 * newRow.concat(" "); newRow=newRow.concat(name); newRow = newRow.concat(" ");
 * newRow=newRow.concat(dtf.format(now)); newRow = newRow.concat(" ");
 * newRow=newRow.concat(numberAsString); writer.println(newRow); writer.close();
 * return null; }
 */
