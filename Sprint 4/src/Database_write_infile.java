import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Database_write_infile {

	public void Write(File file, String[] a) throws IOException {

		FileWriter h = new FileWriter(file, true);
		for (String i : a) {
			h.write(i);
			h.write("\n");
		}
		h.close();
	}

	
/*public ArrayList<?> UpdateVerfication(File f,int lines) throws FileNotFoundException {
	FileReader r = new FileReader(f);
	Scanner read = new Scanner(f);

	String s1, s4 = null;
	String s2, s3 = null;
	

	ArrayList<Products1> P = new ArrayList<Products1>();
	ArrayList<Admin> A = new ArrayList<Admin>();
		if(lines==4) {
			
			
			
			while (read.hasNext()) {
				s1 = read.nextLine();
				s2 = read.nextLine();
				s3 = read.nextLine();
				s4 = read.nextLine();
				Products1 x = new Products1(s1, s2, s3, s4);
				String a[]= {s1,s2,s3,s4};
				P.add(x);
				
				
			
		}
			return P;
			}
		else if (lines==2) {
			
				
				

				while (read.hasNext()) {
					s1 = read.nextLine();
					s2 = read.nextLine();

					Admin x = new Admin(s1, s2);
				A.add(x);	
			}
				return A;
			}
		return null;
}
	
/*public void Delete(File f,File f2,String lineToRemove) throws IOException {
	
	
	

	BufferedReader reader = new BufferedReader(new FileReader(f));
	BufferedWriter writer = new BufferedWriter(new FileWriter(f2));


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
	
	
}
}*/
}
