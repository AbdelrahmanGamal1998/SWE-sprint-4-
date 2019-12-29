import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Collaborator extends TimerTask {

	StoreOwner collaborator = new StoreOwner();
	UsersStatistics Collaborator_stat = new UsersStatistics();
	ProductsStatistics Collaboratorprod_stat = new ProductsStatistics();
	Collaborator_controller Collaborator_cont = new Collaborator_controller();
	History history = new History();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	public void addProduct_bycollaborator(Scanner name,Scanner price,Scanner brand,Scanner category) throws IOException {
		collaborator.StoreOwner_addProduct(name, price, brand, category);
		String  productadded_in_history_file[] = { "Product added by collaborator is " + collaborator.getProduct_Name(), dtf.format(now) };
		history.write_Historyfile(productadded_in_history_file);
	}
		
	public void viewStatistics_bycollaborator() throws IOException {
		String arr[] = { "Statistacs viewed by collaborator", dtf.format(now) };
		history.write_Historyfile(arr);

	}

	@Override
	public void run() {
		try {
			viewStatistics_bycollaborator();
		} catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}

		System.out.println("the sold products Statistics by Collaborator");
		try {
			System.out.println(Collaborator_stat.sum_users());
		} catch (IOException excp) {
			// TODO Auto-generated catch block
			excp.printStackTrace();
		}
		System.out.println("the  Most Ordered Product Statistics  by Collaborator");
		try {
			Collaboratorprod_stat.maxproduct();
		} catch (IOException excpp) {
			// TODO Auto-generated catch block
			excpp.printStackTrace();
		}

	}

	public void Collabrorator_login(String username,String store_Name) throws IOException {
		Collaborator_cont.verify_Collaborator(username,store_Name);
	}
	
}