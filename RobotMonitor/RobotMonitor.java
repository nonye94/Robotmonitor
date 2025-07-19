public class RobotMonitor {
	public static final int MAX = 5; 
	private int row;
	private int col;
	private Move lastMove;

	public enum Move {
		LEFT, RIGHT, UP, DOWN, NULL
	}

	// Constructor
	public RobotMonitor() {
		this.row = 1;
		this.col = 1;
		this.lastMove = Move.NULL; // No move initially
	}

	public void MoveRight() throws VDMException {
		if (lastMove == Move.RIGHT) {
			throw new VDMException("Cannot move RIGHT twice in a row.");
		}
		if (col < MAX) {
			col++;
			lastMove = Move.RIGHT;
		} else {
			throw new VDMException("Move out of bounds!");
		}
	}

	public void MoveLeft() throws VDMException {
		if (lastMove == Move.LEFT) {
			throw new VDMException("Cannot move LEFT twice in a row.");
		}
		if (col > 1) {
			col--;
			lastMove = Move.LEFT;
		} else {
			throw new VDMException("Move out of bounds!");
		}
	}

	public void MoveUp() throws VDMException {
		if (lastMove == Move.UP) {
			throw new VDMException("Cannot move UP twice in a row.");
		}
		if (row > 1) {
			row--;
			lastMove = Move.UP;
		} else {
			throw new VDMException("Move out of bounds!");
		}
	}

	public void MoveDown() throws VDMException {
		if (lastMove == Move.DOWN) {
			throw new VDMException("Cannot move DOWN twice in a row.");
		}
		if (row < MAX) {
			row++;
			lastMove = Move.DOWN;
		} else {
			throw new VDMException("Move out of bounds!");
		}
	}

	public int GetRow() {
		return row;
	}

	public int GetCol() {
		return col;
	}

	public Move GetMove() {
		return lastMove;
	}

	public void Exit() {
		row = 1;
		col = 1;
		lastMove = Move.NULL;
	}
}
