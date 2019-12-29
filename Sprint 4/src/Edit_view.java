import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit_view {

	
	
	public ArrayList<String> EditPrice() throws IOException {
		ArrayList<String> edit = new ArrayList<String>();
		System.out.println("Please Enter the Offerd Product Name you Want to Edit");
		Scanner PNAme = new Scanner(System.in);
		String edited = PNAme.next();
		System.out.println("Please Enter the New Offerd Product Price ");
		Scanner NewPrice = new Scanner(System.in);
		String edited2 = NewPrice.next();
		edit.add(0, edited);
		edit.add(1,edited2);
		return edit;
	}
	
	
	
}
