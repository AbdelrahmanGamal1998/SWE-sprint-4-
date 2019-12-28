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
	StoreController Admin_controller = new StoreController();
	User Admin_log = new User();
	ProductController AdminProd_Controller = new ProductController();
	UsersStatistics user = new UsersStatistics();
	ProductsStatistics products = new ProductsStatistics();
	Brands brand = new Brands();
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

	public void Admin_brands(Scanner brand_Name,Scanner brand_Category) throws IOException {
		brand.addbrands(brand_Name, brand_Category);
	}

	public void Admin_addProduct(Scanner name,Scanner price,Scanner brand,Scanner category) throws IOException {
	   Products Add_product = new Products();
	   String file_Name = "AdminProducts.txt";
	   Add_product.addProduct(name, price, brand, category, file_Name);
	}

	public boolean approveStore(String check_storetype) throws IOException {
		return Admin_controller.VerifyStore(check_storetype);
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
