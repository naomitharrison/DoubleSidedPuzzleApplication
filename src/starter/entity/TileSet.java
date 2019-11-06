package starter.entity;

import java.awt.Rectangle;

public class TileSet {
	
	// rectangles are used to put the tiles in the correct location/size in the display
	Rectangle LT = new Rectangle(100, 100, 100, 100);
	Rectangle LM = new Rectangle(100, 250, 100, 100);
	Rectangle LB = new Rectangle(100, 400, 100, 100);
	Rectangle MT = new Rectangle(250, 100, 100, 100);
	Rectangle MM = new Rectangle(250, 250, 100, 100);
	Rectangle MB = new Rectangle(250, 400, 100, 100);
	Rectangle RT = new Rectangle(400, 100, 100, 100);
	Rectangle RM = new Rectangle(400, 250, 100, 100);
	Rectangle RB = new Rectangle(400, 400, 100, 100);	
	
	// initial configuration: the last digit of my ID is 1
	Tile t1 = new Tile("1", "4", LT, false);
	Tile t2 = new Tile("4", "1", LM, true);
	Tile t3 = new Tile("3", "2", LB, true);
	Tile t4 = new Tile("4", "1", MT, false);
	Tile t5 = new Tile("3", "2", MM, false);
	Tile t6 = new Tile("2", "3", MB, false);
	Tile t7 = new Tile("4", "1", RM, false);
	Tile t8 = new Tile("3", "2", RB, false);
	
	Tile[][] initialShape = {{t1, t4, null},
							{t2, t5, t7},
							{t3, t6, t8}};
	
	
	public TileSet() { // future work: add an input to instantiation that determines initial configuration
		
	}
	
	void updateTileLocation(Tile t, int row, int column) { // row and column have to be integers 0-2
		if(column == 0) { // left
			if(row==0) {
				t.setLocation(LT);
				t.flip();
			}
			if(row==1) {
				t.setLocation(LM);
				t.flip();
			}
			if(row==2) {
				t.setLocation(LB);
				t.flip();
			}
		}
		if(column == 1) { // middle
			if(row==0) {
				t.setLocation(MT);
				t.flip();
			}
			if(row==1) {
				t.setLocation(MM);
				t.flip();
			}
			if(row==2) {
				t.setLocation(MB);
				t.flip();
			}
		}
		if(column == 2) { // right
			if(row==0) {
				t.setLocation(RT);
				t.flip();
			}
			if(row==1) {
				t.setLocation(RM);
				t.flip();
			}
			if(row==2) {
				t.setLocation(RB);
				t.flip();
			}
		}
	}

}