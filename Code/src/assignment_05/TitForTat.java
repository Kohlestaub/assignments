package assignment_05;

public class TitForTat implements GefangenenStrategie {

	private boolean opponantDecision = true;

	/**
	 * plays along so far as the other player is cooperative, otherwise a random
	 * decision is taken
	 */
	@Override
	public boolean getNextDecision() {
		if (opponantDecision) {
			return opponantDecision;
		} else {
			java.util.Random rand = new java.util.Random();
			return rand.nextBoolean();
		}
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		opponantDecision = decision;
	}

}
