package assignment_02;

public class Goldtagespreis {
	public String datum;
	public double preis;

	// initalisiert und deklariert datum und preis
	public Goldtagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}

	// erzeugt eine toString Ausgabe
	public String toString() {
		return String.format("Am %s lag der Goldpreis bei %d", datum, preis);
	}
}
