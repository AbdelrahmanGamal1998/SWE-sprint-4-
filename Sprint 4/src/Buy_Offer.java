import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Buy_Offer {
	private String User_type;
	Database_write_infile write = new Database_write_infile();

	public String getUser_type() {
		return User_type;
	}

	public void setUser_type(String user_type) {
		this.User_type = user_type;
	}
	
public void BuyProduct(User u) throws IOException {
	    ArrayList<String> to_beWritten = new ArrayList<String>();
		int result = 0;
		String line0 = null;
		String line1 = null;
		String line2 = null;
		String line3 = null;
		view_Products(line0, line1, line2, line3);
		System.out.println("PLEASE choose a SPECIFIC Product ");
		Scanner e = new Scanner(System.in);
		String product = e.next();
		System.out.println("This Products Details is   ");
		if (product != null) {
			offer_File(line0, line1, line2, line3, product);
		}
		to_beWritten = StoreProducts_file(line0, line1, line2, line3, product);
		result = Integer.parseInt(to_beWritten.get(0));
		System.out.println("Please enter the amount You want  ");
		Scanner e1 = new Scanner(System.in);
		int amount = e1.nextInt();
		int Discount = Calculate_offer(result, amount);
		String Dis = String.valueOf(Discount);
		System.out.println("Congratulation you got an offer : " + Dis + " L.E");
		System.out.println("To Buy The Product?Press 1 ");
		Scanner e5 = new Scanner(System.in);
		int choice = e5.nextInt();
		if (choice == 1) {
			File file2 = new File("SoldProducts.txt");
			System.out.println("Please Enter The Shipping address ?  ");
			Scanner e2 = new Scanner(System.in);
			String Shipping_Address = e2.next();
			System.out.println("-------------------");
			System.out.println("If You Agree To Our Product Agreement?Press 1 ");
			Scanner e3 = new Scanner(System.in);
			int agree = e3.nextInt();
			if (agree == 1) {
				System.out.println("we will send you a confirmation mail ");
				System.out.println("the product will be shipping 2 Working days Thanks for Using Our Website  ");
				String a[] = { u.getName(), product, Dis,to_beWritten.get(1) ,to_beWritten.get(2) };
				write.Write(file2, a);
				System.out.println("The Product On The Cart ");
			} else
				System.out.println("The product is discareded ,THANKS FOR USING OUR WEBSITE");
		} else
			System.out.println("THANKS FOR USING OUR WEBSITE");
}

public void view_Products(String line0, String line1, String line2, String line3) throws IOException {
		System.out.println("Our Products are   ........ ");
		File file = new File("StoreProducts.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line0 = br.readLine()) != null & (line1 = br.readLine()) != null & (line2 = br.readLine()) != null
				& (line3 = br.readLine()) != null) {
			System.out.println(line0);
		}
}

	public void offer_File(String line0, String line1, String line2, String line3, String product) throws IOException {
		File f5 = new File("Offers.txt");
		FileReader r5 = new FileReader(f5);
		Scanner read5 = new Scanner(f5);
		System.out.println("This Product After offer");
		while (read5.hasNext()) {
			line0 = read5.nextLine();
			line1 = read5.nextLine();
			if (line0.equalsIgnoreCase(product)) {
				System.out.println("the product price is :");
				System.out.println(line1 + " L.E");

				break;
			}
		}
}
	
	public ArrayList<String> StoreProducts_file(String line0, String line1, String line2, String line3, String product)throws IOException {
		ArrayList<String> info = new ArrayList<String>();	
		File f = new File("StoreProducts.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		System.out.println("------------------------");
		System.out.println("This Product Before offer");
		while (read.hasNext()) {
			line0 = read.nextLine();
			line1 = read.nextLine();
			line2 = read.nextLine();
			line3 = read.nextLine();
			if (line0.equalsIgnoreCase(product)) {
				System.out.println("the product price is :");
				info.add(0, line1);
				System.out.println(line1 + "L.E");
				System.out.println("the product brand is :");
				info.add(1, line2);
				System.out.println(line2);
				System.out.println("the product category is :");
				info.add(2,line3);
				System.out.println(line3);
				System.out.println("------------------------");
				return info;
			}
		}
		return null;
}
	
public int Calculate_offer(int result, int amount) {
		if (getUser_type() == "User") {
			if (amount == 1) {
				return (int) (result - (result * 0.05));
			} else
				return (int) (result - (result * 0.1));
		} else if (getUser_type() == "StoreOwner") {
			if (amount == 1) {
				return (int) (result - (result * 0.15));
			} else
				return (int) (result - (result * 0.3));
		}
		return 0;
	}

}