import java.util.Scanner;

public class Delete_view {
	public String Delete() {
		System.out.println("Please Enter The Product Name You Want to Delete ");
		Scanner Pname = new Scanner(System.in);
		String deleted = Pname.next();
		return deleted;
	}
}
