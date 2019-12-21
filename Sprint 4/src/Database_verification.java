

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Database_verification {

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
	
	
	
	
	
	
	
	
	public int verify_controller (File f, String[] a) throws FileNotFoundException {
	
	FileReader r = new FileReader(f);
	Scanner read = new Scanner(f);
	String s1 = null;
	String x, y, s2 = null;
	while (read.hasNext()) {

		s1 = read.nextLine();
		s2 = read.nextLine();
		if (s1.equals(a[0]) && s2.equals(a[1])) {
			break;
		}
	}
	y = s1;
	x = s2;
	if (y.equals(a[0]) && x.equals(a[1])) {
		
		return 1;

	}

	else if (y.equals(a[0])) {
		return 0;
	} else if (x.equals(a[1])) {
		return 2;

	} else {
		return 4;
	}
}
	
	
	
	
}
