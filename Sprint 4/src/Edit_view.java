import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit_view {

	
	
	public ArrayList<String> EditPrice() throws IOException {
		ArrayList<String> edit = new ArrayList<String>();
		System.out.println("Please Enter the  Product Name you Want to Edit");
		Scanner PNAme = new Scanner(System.in);
		String edited = PNAme.next();
		System.out.println("Please Enter the New Product name ");
		Scanner Newname = new Scanner(System.in);
		String edited2 = Newname.next();
		System.out.println("Please Enter the New Product Price ");
		Scanner Newprice = new Scanner(System.in);
		String edited3 = Newprice.next();
		System.out.println("Please Enter the New  Product brand ");
		Scanner Newbrand = new Scanner(System.in);
		String edited4 = Newbrand.next();
		System.out.println("Please Enter the New  Product category  ");
		Scanner Newcategory = new Scanner(System.in);
		String edited5 = Newcategory.next();
		edit.add(0, edited);
		edit.add(1,edited2);
		edit.add(2, edited3);
		edit.add(3, edited4);
		edit.add(4, edited5);
		return edit;
	}
	
	
	
}
