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

public class Admin {

	private String OfferName;
	private String Offerprice;
	private String brandname;
	private String brandcategory;
	StoreController Admin_controller = new StoreController();
	User Admin_log = new User();
	Products Add_product = new Products();
	ProductController AdminProd_Controller = new ProductController();
	UsersStatistics user = new UsersStatistics();
	ProductsStatistics products = new ProductsStatistics();
	Database_write_infile write_File = new Database_write_infile();
	Offer offer = new Offer();

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
	
	public void Add_offer(String name,String price) throws IOException {
		offer.Offers(name,price);
	}
	
	public void Delete_offer() throws IOException {
		offer.deleteOffer();
	}
	
	public void Update_offer() throws IOException {
		offer.UpdatedOfferPrice();
	}

	
	
	public void addbrands(Scanner brand_Name,Scanner brand_Category) throws IOException {
		File f = new File("AdminBrands.txt");
		this.setBrandname(brand_Name.next());
		this.setBrandcategory(brand_Category.next().toLowerCase());
		String a[] = { this.getBrandname(), this.getBrandcategory() };
		write_File.Write(f, a);
		System.out.println("Brand Is Added Successfuly");

	}

	public void addProduct(Scanner name,Scanner price,Scanner brand,Scanner category) throws IOException {
		File f = new File("AdminProducts.txt");
		Add_product.setName(name.next());
		Add_product.setPrice(price.next());
		Add_product.setBrand(brand.next());
		Add_product.setCategory(category.next());
		String a[] = { Add_product.getName(), Add_product.getPrice(), Add_product.getBrand(),
				Add_product.getCategory() };
		write_File.Write(f, a);
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
