package assignment_08;

import java.util.ArrayList;

/**
 * abstrakte Klasse, von der alle Schachfiguren erben. Die getMoveList Methode
 * muss ueberschrieben werden, um eine Schachfigur zu erstellen. Diese Methode
 * gibt einen Algorithmus vor, welcher alle gueltigen Bewegungen einer Figur
 * angibt.
 * 
 * @author Hannes
 *
 */
public abstract class Chessman {
	public Position pos;

	/**
	 * Setzt die Figur auf einen angegebenen Punkt
	 * 
	 * @param pos
	 */
	public Chessman(Position pos) {
		this.pos = pos;
	}

	/**
	 * Gibt die aktuelle Position zurueck.
	 * 
	 * @return
	 */
	public Position getPosition() { // TODO: reicht das hier fuer die Datenkapsellung?
		Position copy = this.pos;
		return copy;
	}

	/**
	 * Setzt die Figur auf einen angegebenen Punkt. Wirft eine Exception, falls das
	 * Feld nicht in einem Zug erreicht werden kann.
	 * 
	 * @param pos
	 */
	public void moveTo(Position pos) {
		// XXX hier hat das this Objekt schon seine Position geandert zur Position pos,
		// die uebergeben wurde
		if (canMoveTo(pos)) {
			this.pos = pos;
		} else {
			throw new WrongMoveException("Try another move, this one is not valid");
		}
	}

	public abstract ArrayList<Position> getMoveList();

	/**
	 * Gibt zurueck ob die angegebene Position im naechsten Zug erreicht werden
	 * kann.
	 * 
	 * @param pos
	 * @return
	 */
	public boolean canMoveTo(Position pos) {
		for (Position entry : getMoveList()) {
			if (entry.equals(pos)) { // XXX hier vergleicht contains auf Objektgleichheit, ist das richtig? (Deswegen
										// brauchte ich eine equals methode?)
				return true;
			}
		}
		return false;
	}
}
