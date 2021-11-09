package assignment_05;

public class Pavlov implements GefangenenStrategie {

	private boolean ownLastDecison = true;
	private boolean opponentLastDecison = true;

	/**
	 * Cooperates if both players took the same action. Does not otherwise.
	 */
	@Override
	public boolean getNextDecision() {
		boolean ret;
		if (ownLastDecison == opponentLastDecison) {
			ret = true;
		} else {
			ret = false;
		}
		ownLastDecison = ret;
		return ret;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		opponentLastDecison = decision;
	}

}
