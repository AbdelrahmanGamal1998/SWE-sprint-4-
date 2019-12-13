import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductController {

public boolean VerifyProduct(String i) throws IOException {
		File f = new File("AdminProducts.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s = null ;
		while(read.hasNext()) {
		        s = read.nextLine();
		            if(s.equalsIgnoreCase(i)){
		            	return true;
		            }
		}
		return false;
	}

}
