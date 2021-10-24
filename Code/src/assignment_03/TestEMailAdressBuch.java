package assignment_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestEMailAdressBuch {
	public static void main(String[] args) {
		TestEMailAdressBuch test = new TestEMailAdressBuch();
		EMailAdressBuch own, matse = new EMailAdressBuch();
		own = test.eigenerTest();
		matse = test.matseTest();
		System.out.println("Hier mein eigener Test: " + own);
		System.out.println("Hier der MATSE Test: " + matse);
		test.createTxt(matse, "mitatbeiter_maste_zusammen");

	}
/**
 * Test case for the collection of a self written collection of Email addresses 
 * @return
 */
	public EMailAdressBuch eigenerTest() {
		EMailAdressBuch ret = new EMailAdressBuch();
		try {
			ret.einlesen("emailadressbuch.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * Test for the collection of matse Email addresses
	 * @return
	 */
	public EMailAdressBuch matseTest() {
		EMailAdressBuch ret = new EMailAdressBuch();
		try {
			ret.einlesen("mitarbeiter_matse_extern.txt");
			ret.einlesen("mitarbeiter_matse_intern.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(ret.toString());
		return ret;
	}
/**
 * creates a .txt file containing all data stored in an address index
 * @param a
 * @param filename
 */
	public void createTxt(EMailAdressBuch a, String filename) {
		File f = new File(filename + ".txt");
		try (PrintWriter pw = new PrintWriter(f);) {
			for (String s1 : a.adressBuch.keySet()) {
				pw.printf("%s;%s\n", s1, a.adressBuch.get(s1));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}

