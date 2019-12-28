import java.util.Scanner;

public class Delete_view {
	public String Delete() {
		System.out.println("Please enter the product name you want to delete ");
		Scanner x1 = new Scanner(System.in);
		String deleted = x1.next();
		return deleted;
	}
}
