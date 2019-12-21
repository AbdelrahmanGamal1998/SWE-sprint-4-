import java.io.IOException;
import java.util.Scanner;

public class CollaboratorMain {

	public void CollaboratorMain() throws IOException {
		Collaborator h = new Collaborator();
        h.Collabrorator_login();
		int p = 1;
		while (p == 1) {
			System.out.println("Want to Add Products? Press 0 / Want to View Statistics? Press 1? ");
			Scanner j = new Scanner(System.in);
			int a = j.nextInt();
			if (a == 0) {
				h.addProduct_bycollaborator();
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
