package assignment_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Goldpreis {

	private ArrayList<Goldtagespreis> list = new ArrayList<>();

	/**
	 * Konstruktor: erstellt eine Liste mit allen Goldtagespreisen aus einer Datei.
	 * Uebergabeparameter ist der Name der Datei, in welcher die Goldpreise stehen.
	 * Wenn an einem Tag kein Goldpreis ausgestellt wurde, wird eine -1 als
	 * Tagespreis angegeben.
	 * 
	 * @param dateiname
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public Goldpreis(String dateiname) throws FileNotFoundException {
		// Scanner wird mit der angegebenen Datei initialisiert und Zeile fuer Zeile
		// eingelesen
		File f = new File(dateiname);
		try (Scanner sc = new Scanner(f);) {
			while (sc.hasNextLine()) {
				String[] rawData = sc.nextLine().split("\t", 0);
				// Die Eintraege sind durch einen Tabulator getrennt, welcher entfernt werden
				// muss.
				double preis;
				try { // Preise die nicht eingetragen wurden werden mit -1 angegeben
					if (rawData[1].equals("kein Nachweis")) {
						preis = -1;
						Goldtagespreis newEntry = new Goldtagespreis(rawData[0], preis);
						list.add(newEntry);
						continue;
					}
					// das Preisformat laesst sich nicht einfach parsen, deswegen muss der Umweg
					// ueber Numberformat gegangen werden, welcher eine Exception werfen kann
					// (welche in unserem Bsp. nicht auftreten sollte)
					NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
					Number number = format.parse(rawData[1]);
					preis = number.doubleValue();
				} catch (ParseException e) {
					continue;
				}
				Goldtagespreis newEntry = new Goldtagespreis(rawData[0], preis);
				list.add(newEntry);
			}

		}

	}

	/**
	 * Der die min und max Werte des Goldpreises werden in einem String ausgegeben
	 * und mit den entsprechenden Tagen versehen.
	 */
	public void printMinMax() {
		// min und max werden auf den ersten Wert, welcher ungleich -1 ist initalisiert
		double min, max;
		// wir brauchen eine Moeglichkeit mehrere Tage ausgeben zu koennen, an denen der
		// Goldpreis minimal ist
		ArrayList<String> sMin = new ArrayList<>(), sMax = new ArrayList<>();
		int i = 0;
		try {
			while (true) {
				if (list.get(i).preis != -1) {
					min = list.get(i).preis;
					break;
				}
				i++;
			}
		} catch (Exception e) { // sollte die Liste keine Goldpreise enthalten wird eine Exception geworfen,
								// welche hier gefangen wird
			System.out.println("eine leere Goldpreisliste enthaelt keine min und max Werte");
			return;
		}
		max = list.get(i).preis;

		// findet die min und max Werte des Preises
		for (Goldtagespreis a : list) {
			if (a.preis > max) {
				max = a.preis;
			}
			if (a.preis < min && a.preis != -1) {
				min = a.preis;
			}
		}

		// findet alle Daten, an denen der Preis min/ max ist
		for (Goldtagespreis a : list) {
			if (a.preis == min) {
				sMin.add(a.datum);
			}
			if (a.preis == max) {
				sMax.add(a.datum);
			}
		}
		// Output in Form eines Strings
		System.out.printf(
				"Den niedrigsten Goldpreis von %.1f gab es an folgenden Tagen:\n%s\n"
						+ "Den hoechsten Goldpreis von %.1f gab es an folgenden Tagen:\n%s\n",
				min, sMin.toString(), max, sMax.toString());
	}

	/**
	 * Gibt den Goldpreis eines bestimmten Tages zurueck. Wirft eine Exception,
	 * falls das Datum falsch formatiert wurde
	 * 
	 * @param datum
	 * @return
	 */
	public String getPreis(String datum) {
		for (Goldtagespreis a : list) {
			if (datum.equals(a.datum)) {
				return "" + a.preis;
			}
		}
		throw new NumberFormatException("Bitte Datum als yyyy-mm-tt angeben");
	}

	// vorgegebene Testmethode
	public static void main(String[] args) throws ParseException {
		try {
			Goldpreis test = new Goldpreis("gold.txt"); // eventuell anderer Pfad
			System.out.println(test.getPreis("2009-10-20")); // 22870.0
			System.out.println(test.getPreis("2009-02-07")); // -1
			test.printMinMax();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}
}
