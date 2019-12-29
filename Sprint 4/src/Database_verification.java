
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Database_verification {

	String line1 = null;
	String line2 = null;
	String line3 = null;
	String line4 = null;

	public int verify(File file, String[] arr) throws FileNotFoundException {

		FileReader Freader = new FileReader(file);
		Scanner read = new Scanner(file);

		if (arr.length == 3) {

			while (read.hasNext()) {
				line1 = read.nextLine();
				line2 = read.nextLine();
				line3 = read.nextLine();
				if (line1.equals(arr[0]) && line2.equals(arr[1]) && line3.equals(arr[2])) {
					break;
				}
			}

			if (line1.equalsIgnoreCase(arr[0]) && line2.equals(arr[1]) && line3.equals(arr[2])) {

				return 1;

			}

			else {

				return 0;
			}

		}

		else if (arr.length == 1) {

			while (read.hasNext()) {
				line1 = read.nextLine();
				if (line1.equalsIgnoreCase(arr[0])) {
					break;
				}
			}

			if (line1.equalsIgnoreCase(arr[0])) {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;

	}

	public int verify_controller(File file1, String[] arr1) throws FileNotFoundException {

		FileReader FReader = new FileReader(file1);
		Scanner read = new Scanner(file1);
		String line1 = null;
		String x, y, line2 = null;
		while (read.hasNext()) {

			line1 = read.nextLine();
			line2 = read.nextLine();
			if (line1.equals(arr1[0]) && line2.equals(arr1[1])) {
				break;
			}
		}
		y = line1;
		x = line2;
		if (y.equals(arr1[0]) && x.equals(arr1[1])) {

			return 1;

		}

		else if (y.equals(arr1[0])) {
			return 0;
		} else if (x.equals(arr1[1])) {
			return 2;

		} else {
			return 4;
		}
	}

}
