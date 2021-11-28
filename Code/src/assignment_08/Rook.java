package assignment_08;

import java.util.ArrayList;

public class Rook extends Chessman {

	public Rook(Position pos) {
		super(pos);
	}

	@Override
	public ArrayList<Position> getMoveList() {
		int xPos = this.getPosition().getX();
		int yPos = this.getPosition().getY();
		ArrayList<Position> positions = new ArrayList<>();
		for (int i = 1; i < 9; i++) {
			if (!(i == yPos)) {
				positions.add(new Position(xPos, i));
			}
			if (!(i == xPos)) { // hier wird die eigene Position des Sprigers ausgelassen, da ein Zug des
								// Springers an eine andere Position geschehen muss
				positions.add(new Position(i, yPos));
			}
		}
		return positions;
	}

	@Override
	public String toString() {
		return "Turm: " + this.getPosition().toString();
	}

}
