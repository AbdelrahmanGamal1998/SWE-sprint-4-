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

public class Database {

	public void Write(File file, String[] a) throws IOException {

		FileWriter h = new FileWriter(file, true);
		for (String i : a) {
			h.write(i);
			h.write("\n");
		}
		h.close();
	}

	public String Sort(int count, File file, String m) throws IOException {

		int minnum = 100;
		String name = null;
		int maxmum = 0;

		BufferedReader br = new BufferedReader(new FileReader(file));
		Map<String, Integer> x = new HashMap<String, Integer>();

		String line;
		while ((line = br.readLine()) != null) {
			if (count == 0) {
				if (x.get(line) != null) {
					x.put(line, x.get(line) + 1);
				} else {
					x.put(line, 1);
				}

			}
			count++;
			if (count == 5) {
				count = 0;
			}

		}

		if (m.equals("MAX")) {

			for (Map.Entry<String, Integer> entry : x.entrySet()) {
				if (entry.getValue() > maxmum) {
					maxmum = entry.getValue();
					name = entry.getKey();
				}

			}
		} else

		{
			for (Map.Entry<String, Integer> entry : x.entrySet()) {
				if (entry.getValue() < minnum) {
					minnum = entry.getValue();
					name = entry.getKey();

				}

			}
		}
		return name;

	}
	String s1 = null;
	String s2 = null;
	String s3 = null;
	String s4=null;
	public int verify(File f, String[] a) throws FileNotFoundException {
		
		FileReader r = new FileReader(f);
		Scanner read = new Scanner(f);
	

		if (a.length == 3) {

			while (read.hasNext()) {
				s1 = read.nextLine();
				s2 = read.nextLine();
				s3 = read.nextLine();
				if (s1.equals(a[0]) && s2.equals(a[1]) && s3.equals(a[2])) {
					break;
				}
			}

			if (s1.equalsIgnoreCase(a[0]) && s2.equals(a[1]) && s3.equals(a[2])) {

				return 1;

			}

			else {

				return 0;
			}

		}

		else if (a.length == 1) {

			while (read.hasNext()) {
				s1 = read.nextLine();
				if (s1.equalsIgnoreCase(a[0])) {
					break;
				}
			}

			if (s1.equalsIgnoreCase(a[0])) {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;

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
