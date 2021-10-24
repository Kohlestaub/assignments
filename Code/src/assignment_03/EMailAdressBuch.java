package assignment_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class collects entries to an address index, contains the name and Email address for a given person
 * @author Hannes
 *
 */
public class EMailAdressBuch {
	// is public, since we have trust in the dev, that he does not butcher with his
	// own set of data
	public HashMap<String, String> adressBuch;

	public EMailAdressBuch() {
		adressBuch = new HashMap<>();
	}

	/**
	 * Set a key-value pair. The email String cannot be null.
	 * 
	 * @param name
	 * @param email
	 */
	public void einfuegen(String name, String email) {
		// TODO: Evtl koennen wir hier mehr ausschliessen
		if (email.equals(null)) {
			throw new RuntimeException("The email String is null, which is not a valid format for emails");
		}
		adressBuch.put(name, email);
	}

	/**
	 * returns the Email address of one person in the registry 
	 * @param name
	 * @return
	 */
	public String abfragen(String name) {
		String s1 = adressBuch.get(name);
		if (s1.isBlank()) {
			throw new UnknownNameException("the name does not exist in our registry");
		}
		return s1;
	}

	/**
	 * returns a String with all Registry information stored in one registry
	 */
	public String toString() {
		ArrayList<String> temp = new ArrayList<>();
		String ret = "{";
		// adds all email name pairs to a List
		for (String s : adressBuch.keySet()) {
			String s1 = String.format("%s=%s", s, adressBuch.get(s));
			temp.add(s1);
		}
//TODO: improvement with StringBuilder would help with the runtime, for large sets of Registry entries
		int finish = 0;
		for (String s : temp) {
			finish++;
			ret += s;
			if (finish < temp.size()) {
				ret += ", ";
			}
		}
		ret += "}";
		return ret;
	}

	/**
	 * Reads in a new file into the address index; does append new entries to an
	 * existing index.
	 * 
	 * @param dateiname
	 * @throws FileNotFoundException
	 */
	public void einlesen(String dateiname) throws FileNotFoundException {
		File f = new File(dateiname);
		try (Scanner sc = new Scanner(f)) {
			while (sc.hasNextLine()) {
				String[] temp = sc.nextLine().split(";");
				adressBuch.put(temp[0], temp[1]);
			}
		}
	}
}
