package starter.entity;

import java.util.ArrayList;

public class Puzzle {
	
	Tile[][] currentShape;
	
	ArrayList moveableTiles() { //returns a list of tiles that are adjacent to the empty space
		
	}
	
	ArrayList findNullTile() { // returns location of null tile in currentShape array
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Tile thisTile = currentShape[i][j];
				if (thisTile == null) {
					
				}
			}
		}
	}

}
