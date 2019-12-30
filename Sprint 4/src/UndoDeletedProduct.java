import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UndoDeletedProduct implements Command{
	private StoreOwner StoreOwner;

	public UndoDeletedProduct(StoreOwner storeOwner) {
		super();
		StoreOwner = storeOwner;
	}

	@Override
	public void execute() throws IOException {
		System.out.println("Enter product name");
		Scanner input_name = new Scanner(System.in);
		String name = input_name.next();
		System.out.println("Enter product price");
		Scanner input_price = new Scanner(System.in);
		String price = input_price.next();
		System.out.println("Enter product Brand");
		Scanner input_brand = new Scanner(System.in);
		String brand = input_brand.next();
		System.out.println("Enter product category");
		Scanner input_category = new Scanner(System.in);
		String category = input_category.next();
		StoreOwner.StoreOwner_addProduct(name, price, brand,category);
	
		
	}
}
