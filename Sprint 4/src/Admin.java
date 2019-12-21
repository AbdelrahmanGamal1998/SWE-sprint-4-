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

public class Admin implements Products {

	private String OfferName;
	private String Offerprice;
	private String brandname;
	private String brandcategory;
	StoreController Admin_controller = new StoreController();
	User Admin_log = new User();
	Products1 Add_product = new Products1();
	ProductController AdminProd_Controller = new ProductController();
	UsersStatistics user = new UsersStatistics();
	ProductsStatistics products = new ProductsStatistics();
	Database_write_infile Database1 = new Database_write_infile();
	Delete offer = new Delete();
	Edit offer_Price = new Edit();

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
		File f = new File("AdminBrands.txt");

		System.out.println("Enter Brand name");
		Scanner x = new Scanner(System.in);
		this.setBrandname(x.next());
		System.out.println("Enter Brand category");
		Scanner p = new Scanner(System.in);
		this.setBrandcategory(p.next().toLowerCase());
		String a[] = { this.getBrandname(), this.getBrandcategory() };
		Database1.Write(f, a);
		System.out.println("Brand Is Added Successfuly");

	}

	public void Offers() throws IOException {

		File f = new File("Offers.txt");
		System.out.println("Enter name");
		Scanner e = new Scanner(System.in);
		String v = e.next();
		System.out.println("Enter Offerd price");
		Scanner j1 = new Scanner(System.in);
		String a1 = j1.next();
		String a[] = { v, a1 };
		Database1.Write(f, a);

	}


	public void deleteOffer() throws IOException {
		File inputFile = new File("Offers.txt");
		File tempFile = new File("newFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = offer.Delete();
		String s0;
		String s1;
	

		while ((s0 = reader.readLine()) != null & (s1 = reader.readLine()) != null)
				 {
			// trim newline when comparing with lineToRemove
			String trimmedLine0 = s0.trim();
			String trimmedLine1 = s1.trim();
		
			if (trimmedLine0.equals(lineToRemove))
				continue;
			String a[] = { s0,s1 };
			Database1.Write(tempFile, a);
			
		}
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		System.out.println("Offer Is deleted  Successfuly");
	}
	
	public void UpdatedOfferPrice() throws IOException {
		ArrayList<Admin> A = new ArrayList<Admin>();
		File f = new File("Offers.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1, s2 = null;
		ArrayList<String> to_BeEdited = new ArrayList<String>();
		to_BeEdited = offer_Price.EditPrice();
	    String a = to_BeEdited.get(0);
	    String b = to_BeEdited.get(1);

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
			String x[] = { s1, s2 };
			Database1.Write(file1, x);
		}
		System.out.println("The Price Of this Offer Is Updated Successfuly");

	}

	public void addProduct() throws IOException {
		// TODO Auto-generated method stub
		File f = new File("AdminProducts.txt");
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
		String a[] = { Add_product.getName(), Add_product.getPrice(), Add_product.getBrand(),
				Add_product.getCategory() };
		Database1.Write(f, a);
		System.out.println("Product Is Added Successfuly");

	}

	public boolean approveStore(String w) throws IOException {
		return Admin_controller.VerifyStore(w);
	}

	public boolean approveProduct(String i) throws IOException {
		return AdminProd_Controller.VerifyProduct(i);
	}

	public void Admin_login() throws IOException {
		Admin_log.login();
	}

	public void User_statistics() throws IOException {
		System.out.println("Sum Users: ");
		System.out.println(user.sum_users());
		
		user.max();

		System.out.println("Average Users : ");
		System.out.println(user.avg_users());
		
	user.min();
		System.out.println("Sum products: ");
		System.out.println(user.sum_users());
		System.out.println("Average Products : ");
		System.out.println(user.avg_users());
	}

	public void Products_statistics() throws IOException {
		
	
		products.minproduct();
		
	    products.maxproduct();
	}

}
