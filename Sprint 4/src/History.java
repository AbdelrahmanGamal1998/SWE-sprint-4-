import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class History {
	
	Database_write_infile fileWrite = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	
	public void write_Historyfile(String a[]) throws IOException {
		File file = new File("History.txt");
		fileWrite.Write(file, a);

	}
	
	public void Edited_Prtoduct_StoreOwner_write_in_history_file(String a) throws IOException {
		String productedited_in_history_file[] = { "Product Edited by StoreOwner is " + a, dtf.format(now) };
		write_Historyfile(productedited_in_history_file);
		}

	public void Deleted_Prtoduct_StoreOwner_write_in_history_file(String linetoremove) throws IOException {
		String productdeleted_in_history_file[] = { "Product Deleted by StoreOwner is " + linetoremove, dtf.format(now) };
		write_Historyfile(productdeleted_in_history_file);
		}
	

}
