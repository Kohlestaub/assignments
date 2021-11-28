package assignment_08;

import java.util.ArrayList;

public class Knight extends Chessman {

	public Knight(Position pos) {
		super(pos);
	}

	@Override
	public ArrayList<Position> getMoveList() {
		int xPos = this.getPosition().getX();
		int yPos = this.getPosition().getY();
		ArrayList<Position> positions = new ArrayList<>();

		for (int i = -2; i < 3; i += 2) {
			if (i == 0) {
				continue;
			}
			for (int k = -1; k < 2; k++) {
				if (k == 0) {
					continue;
				}
				try {
					positions.add(new Position(xPos + i, yPos + k));
				} catch (Exception e) {
				}
				try {
					positions.add(new Position(xPos + k, xPos + i));
				} catch (Exception e) {
				}
			}

		}
		return positions;
	}

	@Override
	public String toString() {
		return "Springer: " + this.getPosition().toString();

	}

}
