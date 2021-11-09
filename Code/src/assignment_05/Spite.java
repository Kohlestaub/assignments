package assignment_05;

public class Spite implements GefangenenStrategie {

	private boolean strategyHook = true;

	/**
	 * cooperates until the first time the opponent has not been cooperative; then
	 * it does not cooperate anymore
	 */
	@Override
	public boolean getNextDecision() {
		return strategyHook;
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if (!decision) {
			strategyHook = decision;
		}
	}

}
