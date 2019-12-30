import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class AdminMain {

	public void AdminMain() throws IOException {
		Admin Admin = new Admin();
		Admin.Admin_login();
		int loop = 1;
		while (loop == 1) {
			System.out.println(
					"Want to Add Products? Press 0 / Want to Add Brands? Press 1 / View Statistics? Press 2  / Want to Add Offer? Press 3 / Want to Delete Offer? Press 4 / Want to Edit Offer? Press 5");
			Scanner button = new Scanner(System.in);
			int button1 = button.nextInt();
			if (button1 == 0) {
				System.out.println("Enter name");
				Scanner input_name = new Scanner(System.in);
				String name = input_name.next();
				System.out.println("Enter price");
				Scanner input_price = new Scanner(System.in);
				String price = input_price.next();
				System.out.println("Enter Brand");
				Scanner input_brand = new Scanner(System.in);
				String brand = input_brand.next();
				System.out.println("Enter category");
				Scanner input_category = new Scanner(System.in);
				String category = input_category.next();
				Admin.Admin_addProduct(name, price, brand, category);
			} else if (button1 == 1) {
				System.out.println("Enter Brand name");
				Scanner brand_Name = new Scanner(System.in);
				System.out.println("Enter Brand category");
				Scanner brand_Category = new Scanner(System.in);
				Admin.Admin_brands(brand_Name, brand_Category);
			} else if (button1 == 2) {
				System.out.println("Sum Users: ");
				Admin.Sum_User_statistics();
				System.out.println("Average Users : ");
				Admin.Average_User_statistics();

				Admin.Maxiumum_User_statistics();

				Admin.Min_User_statistics();
				System.out.println("Sum products: ");
				Admin.Sum_Products_statistics();
				System.out.println("Average Products : ");
				Admin.Average_Products_statistics();
				Admin.max_Products_statistics();
				Admin.min_Products_statistics();

			} else if (button1 == 3) {
				System.out.println("Enter name");
				Scanner inputname = new Scanner(System.in);
				String name = inputname.next();
				System.out.println("Enter Offerd price");
				Scanner input_offer_price = new Scanner(System.in);
				String price = input_offer_price.next();
				Admin.Add_offer(name, price);

			} else if (button1 == 4) {
				Admin.Delete_offer();
			} else if (button1 == 5) {
				Admin.Update_offer();
			} else
				System.out.println("Fawa2 ya3am el hag 2olna Press 0 aw 1");

			System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
			Scanner button2 = new Scanner(System.in);
			loop = button2.nextInt();

		}
		System.out.println("Thanks For Using Our Website!!");
	}
}