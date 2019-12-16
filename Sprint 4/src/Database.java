import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {

	public void Write(File file,String []a) throws IOException {
		
		FileWriter h = new FileWriter(file, true);
		 for (String i: a) {
		h.write(i);
		h.write("\n");
	      }     
		 h.close();
		 }
}
