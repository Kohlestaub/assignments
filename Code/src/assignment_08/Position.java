package assignment_08;

/**
 * Implementiert die Positionen eines Schachfeldes. Die Koordinaten liegen
 * zwischen 0 und 8.
 * 
 * @author Hannes
 *
 */
public class Position {
	public final int x; // XXX wieso muss das hier final sein? Wenn ich die Variable auf static setzte
						// oder einfach so lasse gibt es anscheinend nur ein Positionsobjekt, bzw. haben
						// alle die selben Werte. Das verstehe ich nicht -> was passiert hier?
	public final int y;

	/**
	 * Setzt die Position auf den Wert (x,y). Wirft eine Exception, falls die
	 * eingegebenen Koordinaten nicht auf dem Schachbrett liegen. *
	 * 
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		if (isValid(x, y)) {
			this.x = x;
			this.y = y; // XXX ich kann die attribute auf final setzen und dann Position.y schrieben,
						// das verstehe ich auch nicht -> was mache ich dann? / wie funktioniert das
						// dann, hat das etwas mit dem oben zu tun?
		} else {
			throw new WrongPositionException("The entered position is not valid.");
		}
	}

	/**
	 * Gibt die x-Koordinate der Position zurueck.
	 * 
	 * @return
	 */
	public int getX() {
		int copy = x;
		return copy;
	}

	/**
	 * Gibt die y-Koordinate der Position zurueck.
	 * 
	 * @return
	 */
	public int getY() {
		int copy = y;
		return copy;
	}

	/**
	 * Vergleicht, ob die this und pos Positionen gleich sind.
	 * 
	 * @param pos
	 * @return
	 */
	public boolean equals(Position pos) {
		if (this.getX() == pos.getX() && this.getY() == pos.getY()) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt an, ob die angegebenen Koordinaten eine gueltige Position auf dem
	 * Schachbrett definieren.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isValid(int x, int y) {
		if ((x > 0 && x < 9) && (y > 0 && y < 9)) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt die Sting Raepresentation der Position zurueck. Im Format: (x/y)
	 */
	public String toString() {
		return String.format("(%d/%d)", x, y);
	}

}
