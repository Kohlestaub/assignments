package assignment_05;

//mir ist klar, dass der Name mit Java.util.Random kollidiert, jedoch war es mir wichtiger die 
//Strategien schoen zu benennen; in Arbeitsprojekten waere dies wohl eine schlechte Entscheidung
public class Random implements GefangenenStrategie {

	/**
	 * returns a random boolean
	 */
	@Override
	public boolean getNextDecision() {
		java.util.Random rand = new java.util.Random();
		return rand.nextBoolean();
	}

	@Override
	public void setOpponentsLastDecision(boolean decision) {
		// empty, since not needed

	}

}
