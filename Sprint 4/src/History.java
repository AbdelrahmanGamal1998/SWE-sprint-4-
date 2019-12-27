import java.io.File;
import java.io.IOException;


public class History {
	
	Database_write_infile fileWrite = new Database_write_infile();
	
	public void write_Historyfile(String a[]) throws IOException {
		File file = new File("History.txt");
		fileWrite.Write(file, a);

	}

}
