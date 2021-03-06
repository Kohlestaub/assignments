package assignment_08;

public class TestFall {

	public static void main(String[] args) {
		// Test eines Turms
		Rook rook = new Rook(new Position(4, 5));
		System.out.println(rook);
		rook.moveTo(new Position(4, 1));
		System.out.println(rook);
		System.out.println(rook.getMoveList());

		// Test eines Springers
		Knight knight = new Knight(new Position(5, 4));
		System.out.println(knight);
		knight.moveTo(new Position(6, 6));
		System.out.println(knight);
		System.out.println(knight.getMoveList());
		knight.moveTo(new Position(8, 5));
		System.out.println(knight);
		System.out.println(knight.getMoveList());

	}
}
