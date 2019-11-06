package starter.entity;

import java.util.ArrayList;
import starter.entity.Tile;

public class Puzzle {
	
	TileSet tiles;
	public int moves;
	
	Tile[][] currentShape;
	
	public Puzzle(TileSet t) {
		this.tiles = t;
		this.currentShape = t.initialShape;
		this.moves = 0;
	}
	
	public void updatePuzzle(Tile clickedTile) { // updates currentShape and clickedTile location
		int[] clickedLocation = findTile(clickedTile);
		int[] nullLocation = findNullTile();
		
		tiles.flipTile(clickedTile, nullLocation[0], nullLocation[1]);
		
		currentShape[clickedLocation[0]][clickedLocation[1]] = null;
		currentShape[nullLocation[0]][nullLocation[1]] = clickedTile;
	}
	
	
	public ArrayList<Tile> movableTiles() { //returns a list of tiles that are adjacent to the empty space
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		
		ArrayList<int[]> coordinates = moveableCoordinates();
		for(int i = 0; i<coordinates.size(); i++) {
			int[] location = coordinates.get(i);
			Tile t = currentShape[location[0]][location[1]];
			tiles.add(t);
		}
		
		return tiles;
	}
	
	ArrayList<int[]> moveableCoordinates() { //returns a list of coordinates (int array: [column, row]) of tiles adjacent to the empty space
		ArrayList<int[]> movableLocations = new ArrayList<int[]>();

		int[] nullLocation = this.findNullTile();
		int[] xTile = new int[2];
		int[] xTile2 = new int[2];
		int[] yTile = new int[2];
		int[] yTile2 = new int[2];
		
		if ((nullLocation[0]==0) || (nullLocation[0]==2)) { // 0 = column
			xTile[0] = 1;
			xTile[1] = nullLocation[1]; 
			xTile2 = null;
		}
		if(nullLocation[0]==1) {
			xTile[0] = 0;
			xTile2[0] = 2;
			xTile[1] = nullLocation[1]; 
			xTile2[1] = nullLocation[1];
		}
		if ((nullLocation[1]==0) || (nullLocation[1]==2)) { // 1 = row
			yTile[1] = 1;
			yTile[0] = nullLocation[0];
		}
		if(nullLocation[1]==1) {
			yTile[1] = 0;
			yTile2[1] = 2;
			yTile[0] = nullLocation[1]; 
			yTile2[0] = nullLocation[1];
		}
		
		movableLocations.add(xTile);
		movableLocations.add(xTile2);
		movableLocations.add(yTile);
		movableLocations.add(yTile2);
		
		return movableLocations;
	}
	
	int[] findTile(Tile t) { // returns coordinates (int array: [column, row]) of given tile in currentShape
		int[] location = new int[2];

		//Find indices of element with 0 value
		for (int column = 0; column < currentShape.length; column++) {
		    for (int row = 0; row < currentShape[column].length; row++) {
		        if (currentShape[column][row] == t) {
		        	location[0] = column;
		        	location[1] = row;
		        }
		    }
		}
		return location;
	}

	int[] findNullTile() { // returns coordinates (int array: [column, row]) of empty tile in currentShape
		int[] nullLocation = new int[2];

		//Find indices of element with 0 value
		for (int column = 0; column < currentShape.length; column++) {
		    for (int row = 0; row < currentShape[column].length; row++) {
		        if (currentShape[column][row] == null) {
		        	nullLocation[0] = column;
		        	nullLocation[1] = row;
		        }
		    }
		}
		
		return nullLocation;
	}

	public TileSet getTileSet() {
		return tiles;
	}
	
	public Tile[][] getShape() {
		return currentShape;
	}

}
