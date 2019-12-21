import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit {

	public ArrayList<String> EditPrice() throws IOException {
		ArrayList<String> edit = new ArrayList<String>();
		System.out.println("Please enter the offerd product name you want to Edit");
		Scanner x1 = new Scanner(System.in);
		String edited = x1.next();
		System.out.println("Please enter the new offerd product price ");
		Scanner x2 = new Scanner(System.in);
		String edited2 = x2.next();
		edit.add(0, edited);
		edit.add(1,edited2);
		return edit;
	}

}
