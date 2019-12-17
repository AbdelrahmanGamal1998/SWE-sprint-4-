import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StoreController {
	
public boolean VerifyStore(String w) throws IOException {
		File f = new File("Types.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s = null ;
		while(read.hasNext()) {
		        s = read.nextLine();
		            if(s.equalsIgnoreCase(w)){
		            	return true;
		            }
		}
		return false;
}

}