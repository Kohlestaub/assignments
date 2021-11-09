package assignment_05;

public class PerKind implements GefangenenStrategie {
	int counter = 1;

	/**
	 * always follows the pattern: cooperation, cooperation, mistrust
	 */
	@Override
	public boolean getNextDecision() {
		if (counter % 3 == 0) {
			counter = 0;
			return false;
		}
		return true;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		counter++;
	}

}
