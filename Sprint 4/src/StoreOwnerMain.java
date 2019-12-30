import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class StoreOwnerMain {

	public void StoreOwnerMain() throws IOException {
		Buy_Offer offer = new Buy_Offer();
		StoreOwner_Edit storeowmer_Edit=new StoreOwner_Edit();
		offer.setUser_type("StoreOwner");
		User user = new User();
		User curruse = new User();
		curruse = user.login();
		StoreOwner storeowmer = new StoreOwner();
		RemoteControlForCommandPattern remotecontrol;
		int r = 1;
		while (r == 1) {
			System.out.println(
					"Want to Add Products? Press 0 / Want to Add Store? Press 1 / Want to show views? Press 2 / Want to Buy Product? Press 3 / Want to Delete Product? Press 4 / Want to Edit Product's Price? Press 5 / Want to Check History and Undo Action? Press 6 /Want to add Collaborator press 7? /Want to view press 8"
					+ "/ Want Undo Add ? Press 9 / Want Undo Delete ? Press 10 / Want Undo Edit ? Press 11");
			Scanner StoreOwnerChoice = new Scanner(System.in);
			int a = StoreOwnerChoice.nextInt();
			if (a == 0) {
				System.out.println("Enter name");
				Scanner name = new Scanner(System.in);
				System.out.println("Enter price");
				Scanner price = new Scanner(System.in);
				System.out.println("Enter Brand");
				Scanner brand = new Scanner(System.in);
				System.out.println("Enter category");
				Scanner category = new Scanner(System.in);
				storeowmer.StoreOwner_addProduct(name, price, brand, category);
			} else if (a == 1) {
				storeowmer.addStore();
			} else if (a == 2) {
				Timer timer = new Timer();
				timer.schedule(new StoreOwner_Statistics(), 0, 600000);
			} else if (a == 3) {
				offer.BuyProduct(curruse);
			} else if (a == 4) {
				storeowmer.StoreOwner_Deleteproduct();
			} else if (a == 5) {
				storeowmer.StoreOwner_Updateproduct();

			}

			else if (a == 6) {
        
				
				System.out.println("Do You Want to Undo Action? Press 1");
				Scanner UndoAction = new Scanner(System.in);
				int g = UndoAction.nextInt();
				if (g == 1) {
					storeowmer_Edit.undoEdit() ;
					//storeowmer.StoreOwner_Undo();
				}
			} else if (a == 7) {
				System.out.println("Please Enter Collaborator name");
				Scanner Collaboratorname = new Scanner(System.in);
				String Collaborator_name = Collaboratorname.next();
				System.out.println("Please Enter the Collaborator Store Name ");
				Scanner CollaboratorSname = new Scanner(System.in);
				String Store_Name = CollaboratorSname.next();
				storeowmer.add_Collaborator(Collaborator_name, Store_Name);
			}
			else if (a == 8) {
				storeowmer.View_History();

			}
			else if(a==9) {
				remotecontrol=new RemoteControlForCommandPattern(new UndoAddedProductCommand(storeowmer));
				remotecontrol.ButtonPressed();
			}
            else if(a==10) {
            	remotecontrol=new RemoteControlForCommandPattern(new UndoDeletedProduct(storeowmer));
				remotecontrol.ButtonPressed();
			}
            else if(a==11) {
            	remotecontrol=new RemoteControlForCommandPattern(new UndoEditedProductPrice(storeowmer_Edit));
				remotecontrol.ButtonPressed();
			}


			else
				System.out.println("Ma saba7 el fool ba2a :D");

			System.out.println("Do you Wish to Perform Another Operation? Press 1 / Exit? Press 2");
			Scanner m = new Scanner(System.in);
			r = m.nextInt();
		}
		System.out.println("Thanks For Using Our Website!!");
	}

}