import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Offer {
	
	Database_write_infile write = new Database_write_infile();
	Delete_view  offer = new Delete_view ();
	Edit offer_Price = new Edit();
	Edit_view Edit_view=new Edit_view();
	public void Offers(String name,String price) throws IOException {
		File f = new File("Offers.txt");
		String a[] = { name, price };
		write.Write(f, a);
	}

	public void deleteOffer() throws IOException {
		File inputFile = new File("Offers.txt");
		File tempFile = new File("newFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = offer.Delete();
		String s0;
		String s1;
	

		while ((s0 = reader.readLine()) != null & (s1 = reader.readLine()) != null)
				 {
			// trim newline when comparing with lineToRemove
			String trimmedLine0 = s0.trim();
			String trimmedLine1 = s1.trim();
		
			if (trimmedLine0.equals(lineToRemove))
				continue;
			String a[] = { s0,s1 };
			write.Write(tempFile, a);
			
		}
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		System.out.println("Offer Is deleted  Successfuly");
	}
	
	public void UpdatedOfferPrice() throws IOException {
		ArrayList<Admin> A = new ArrayList<Admin>();
		File f = new File("Offers.txt");
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
		String s1, s2 = null;
		ArrayList<String> to_BeEdited = new ArrayList<String>();
		to_BeEdited = Edit_view.EditPrice();
	    String a = to_BeEdited.get(0);
	    String b = to_BeEdited.get(1);

		while (read.hasNext()) {
			s1 = read.nextLine();
			s2 = read.nextLine();

			Admin x = new Admin(s1, s2);
			A.add(x);
			PrintWriter writer = new PrintWriter("Offers.txt");
			writer.print("");
			writer.close();
		}

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).getOfferName().equals(a)) {
				A.get(i).setOfferprice(b);
			}
		}
		File file1 = new File("Offers.txt");
		FileWriter h1 = new FileWriter(file1, true);
		for (int j = 0; j < A.size(); j++) {
			s1 = A.get(j).getOfferName();
			s2 = A.get(j).getOfferprice();
			String x[] = { s1, s2 };
			write.Write(file1, x);
		}
		System.out.println("The Price Of this Offer Is Updated Successfuly");

	}

}
