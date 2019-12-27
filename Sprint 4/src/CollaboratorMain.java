import java.io.IOException;
import java.util.Scanner;

public class CollaboratorMain {

	public void CollaboratorMain() throws IOException {
		Collaborator h = new Collaborator();
		System.out.println("Please Enter Username : ");
		Scanner e = new Scanner(System.in);
		String username = e.next();
		System.out.println("Please Enter Store Name : ");
		Scanner e1 = new Scanner(System.in);
		String store_Name = e1.next();
        h.Collabrorator_login(username,store_Name);
		int p = 1;
		while (p == 1) {
			System.out.println("Want to Add Products? Press 0 / Want to View Statistics? Press 1? ");
			Scanner j = new Scanner(System.in);
			int a = j.nextInt();
			if (a == 0) {
				System.out.println("Enter name");
				Scanner name = new Scanner(System.in);
				System.out.println("Enter price");
				Scanner price = new Scanner(System.in);
				System.out.println("Enter Brand");
				Scanner brand = new Scanner(System.in);
				System.out.println("Enter category");
				Scanner category = new Scanner(System.in);
				h.addProduct_bycollaborator(name,price,brand,category);
			} else if (a == 1) {
				h.run();
			}
			else
				System.out.println("Maho Mafesh 7aga tanya :D");

			System.out.println("Do you wish to perform another operation? Press 1 / Exit? Press 2");
			Scanner m = new Scanner(System.in);
			p = m.nextInt();
		}
		System.out.println("Thanks For Using Our Website!!");
	}
}
