package assignment_05;

/**
 * defines the strategy interface, which a player may be playing upon as a
 * strategy
 * 
 * @author Hannes
 *
 */
public interface GefangenenStrategie {

	/**
	 * Returns next decision of the player with set strategy
	 * 
	 * @return true if player cooperates
	 */
	public boolean getNextDecision();

	/**
	 * gets the decision the opponent has made
	 * 
	 * @param decision
	 */
	public void setOpponentsLastDecision(boolean decision);

}
