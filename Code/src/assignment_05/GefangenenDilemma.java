package assignment_05;

public class GefangenenDilemma {

	public GefangenenStrategie[] strategie = new GefangenenStrategie[2];
	public int[] stats = new int[2];

	/**
	 * Constructs a new game with the strategies of two players implementedd
	 * 
	 * @param player1
	 * @param player2
	 */
	public GefangenenDilemma(GefangenenStrategie player1, GefangenenStrategie player2) {
		strategie[0] = player1;
		strategie[1] = player2;
	}

	/**
	 * a game of n rounds is being played, the number of rounds is unknown to the
	 * players involved
	 * 
	 * @param n
	 */
	public void spiele(int n) {
		for (int i = 0; i < n; i++) {
			boolean decision1 = strategie[0].getNextDecision();
			boolean decision2 = strategie[1].getNextDecision();

			if (decision1 == decision2) {
				// both have chosen the same strategy
				if (decision1) {
					// both players have cooperated
					stats[0] += 2;
					stats[1] += 2;
				} else {
					// both players have not cooperated
					stats[0] += 4;
					stats[1] += 4;
				}

			} else {
				if (decision1) {
					// player one has cooperated
					stats[0] += 6;
					stats[1] += 1;
				} else {
					// player two has cooperated
					stats[0] += 1;
					stats[1] += 6;
				}
			} // end point distribution

			// both players get the decisions of the opponent back
			strategie[0].setOpponentsLastDecision(decision2);
			strategie[1].setOpponentsLastDecision(decision1);
		} // end loop

		// print out result
		String winner;
		if (stats[1] > stats[0]) {
			winner = "Spieler Eins";
		} else {
			winner = "Spieler Zwei";
		}
		System.out.printf("Spieler Eins: %d Punkte\n", stats[0]);
		System.out.printf("Spieler Zwei: %d Punkte\n", stats[1]);
		System.out.printf("%s hat gewonnen", winner);
	}

}
