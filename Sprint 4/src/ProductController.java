import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductController {
	Database_verification Databaseverify = new Database_verification();

public boolean VerifyProduct(String i) throws IOException {
		File f = new File("AdminProducts.txt");
		String a[]= {i};
		int value=Databaseverify.verify(f, a);
		
		if(value==1) {
			
			return true;
		}
		else  
			return false;
}
}