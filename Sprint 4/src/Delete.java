import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Delete {
	
	Database_write_infile File = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	History delete_History = new History();
	Delete_view Delete_view =new Delete_view (); 

	
	public void deleteProduct() throws IOException {
		File inputFile = new File("StoreProducts.txt");
		File tempFile = new File("newFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = Delete_view.Delete();
		String s0;
		String s1;
		String s2;
		String s3;

		while ((s0 = reader.readLine()) != null & (s1 = reader.readLine()) != null & (s2 = reader.readLine()) != null
				& (s3 = reader.readLine()) != null) {
			// trim newline when comparing with lineToRemove
			String trimmedLine0 = s0.trim();
			String trimmedLine1 = s1.trim();
			String trimmedLine2 = s2.trim();
			String trimmedLine3 = s3.trim();
			if (trimmedLine0.equals(lineToRemove))
				continue;
			String a[] = { s0, s1, s2, s3 };
			File.Write(tempFile, a);

		}
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		delete_History.Deleted_Prtoduct_StoreOwner_write_in_history_file(lineToRemove);
		System.out.println("Product Is deleted  Successfuly");
}

	
}