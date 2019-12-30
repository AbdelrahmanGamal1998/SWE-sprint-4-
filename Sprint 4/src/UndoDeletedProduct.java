import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UndoDeletedProduct implements Command{
	private StoreOwner StoreOwner;
	Scanner name=null;
	Scanner price=null;
	Scanner brand=null;
	Scanner Category=null;
	//File file=new File("StoreProducts.txt");
	//Buy_Offer storeownerbuy;

	public UndoDeletedProduct(StoreOwner storeOwner) {
		super();
		StoreOwner = storeOwner;
	}

	@Override
	public void execute() throws IOException {
		StoreOwner.StoreOwner_addProduct(name, price, brand, Category);
	
		
	}
}
