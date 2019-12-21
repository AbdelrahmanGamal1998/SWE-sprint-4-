import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StoreController {
	Database_verification Databaseverify = new Database_verification();
public boolean VerifyStore(String w) throws IOException {
		File f = new File("Types.txt");
		String a[]= {w};
		int value=Databaseverify.verify(f, a);
		
		if(value==1) {
			
			return true;
		}
		else  
			return false;		
		
		
}
}