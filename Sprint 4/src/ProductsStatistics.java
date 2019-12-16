import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductsStatistics {

	Database database2=new Database();
public void  minproduct() throws IOException {
		
	File file=new File("SoldProducts.txt");
	System.out.println("Min Products :\n  " + database2.Sort(4, file, "min"));
		}

public void  maxproduct() throws IOException {
	
	File file=new File("SoldProducts.txt");
	System.out.println("Max Products : \n " + database2.Sort(4, file, "MAX"));
}
		
}		


