package starter.entity;

public class Model {

	Puzzle puzzle;
	
	boolean win = false;
	boolean lose = false;
	
	public Model() {
	}
		
	public Puzzle getPuzzle() {
		return puzzle;
	}
	
	public void setPuzzle(Puzzle p) {
		this.puzzle = p;		
	}
		
	public void setStatus(boolean won, boolean lost) {
		this.win = won;
		this.lose = lost;
	}

	public void resetStatus() {
		this.win = false;
		this.lose = false;
	}

	public boolean getWin() {
		return this.win;
	}
	
	public boolean getLose() {
		return this.lose;
	}

	public void resetPuzzle() {
		TileSet ts = new TileSet();
		Puzzle p = new Puzzle(ts);
		setPuzzle(p);
	}
}
