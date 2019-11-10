package starter.entity;

import java.util.ArrayList;
import java.util.Arrays;

import starter.entity.Tile;

public class Puzzle {
	
	TileSet tiles;
	int moves;
	
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
	
	public boolean checkWin() {
		if(currentShape[1][1] != null) {
			return false;
		}
		for(int i=0;i<currentShape[0].length;i++) {
			if(currentShape[0][i].flipped) { //if any tile in first row is flipped
				return false;
			}
			if(!currentShape[2][i].flipped) { //if any tile in bottom row is not flipped
				return false;
			}
		}
		if (!currentShape[1][0].flipped) { // if left tile in middle row is flipped
			return false;
		}
		if (currentShape[1][2].flipped) { // if right tile in middle row is not flipped
			return false;
		}
		//if the numbers are in the correct order
		for(int j=0;j<currentShape[0].length;j++) {
			int topRowNum = j+1;
			String topRow = String.valueOf(topRowNum);
			String digit = currentShape[0][j].getVisibleDigit();
			if(!topRow.equals(digit)){
				return false;
			} 
		}
		for(int k=0;k<currentShape[2].length;k++) {
			int bottomRowNum = 3-k;
			String bottomRow = String.valueOf(bottomRowNum);
			if(!bottomRow.equals(currentShape[2][k].getVisibleDigit())){
				return false;
			}
		}
		String four = "4";
		if(!four.equals(currentShape[1][0].getVisibleDigit())) {
			return false;
		}
		if(!four.equals(currentShape[1][2].getVisibleDigit())) {
			return false;
		}
		return true;
	}
	
	
	public boolean checkLose() {
		int ones = 0;
		int twos = 0;
		int threes = 0;
		int fours = 0;
		int maxDigits = 3;
		for(int i=0;i<currentShape.length;i++) {
			for(int j=0;j<currentShape[i].length;j++) {
				Tile t = currentShape[i][j];
				if(t != null) {
					String digit = t.getVisibleDigit();
					if(digit.equals("1")) {
						ones+=1;
					}
					if(digit.equals("2")) {
						twos+=1;
					}
					if(digit.equals("3")) {
						threes+=1;
					}
					if(digit.equals("4")) {
						fours+=1;
					}
				}
			}
		}
		if((ones>maxDigits)||(twos>maxDigits)||(threes>maxDigits)||(fours>maxDigits)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Tile> movableTiles() { //returns a list of tiles that are adjacent to the empty space
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		
		ArrayList<int[]> coordinates = moveableCoordinates();
		for(int i = 0; i<coordinates.size(); i++) {
			int[] location = coordinates.get(i);
			int x = location[0];
			int y = location[1];
			Tile t = currentShape[x][y];
			tiles.add(t);
		}
		
		return tiles;
	}
	
	ArrayList<int[]> moveableCoordinates() { //returns a list of coordinates (int array: [column, row]) of tiles adjacent to the empty space
		ArrayList<int[]> movableLocations = new ArrayList<int[]>();

		int[] nullLocation = this.findNullTile();
		
		int[] yTile = new int[2];
		int[] yTile2 = new int[2];
		int[] xTile = new int[2];
		int[] xTile2 = new int[2];
		
		if ((nullLocation[0]==0) || (nullLocation[0]==2)) { // 0 = row
			yTile[0] = 1;
			yTile[1] = nullLocation[1]; 
			yTile2 = null;
		}
		else if(nullLocation[0]==1) {
			yTile[0] = 0;
			yTile2[0] = 2;
			yTile[1] = nullLocation[1]; 
			yTile2[1] = nullLocation[1];
		}
		if ((nullLocation[1]==0) || (nullLocation[1]==2)) { // 1 = column
			xTile[1] = 1;
			xTile[0] = nullLocation[0];
			xTile2 = null;
		}
		else if(nullLocation[1]==1) {
			xTile[1] = 0;
			xTile2[1] = 2;
			xTile[0] = nullLocation[0]; 
			xTile2[0] = nullLocation[0];
		}
		
		movableLocations.add(yTile);
		if(yTile2 != null) {movableLocations.add(yTile2);}
		movableLocations.add(xTile);
		if(xTile2 != null) {movableLocations.add(xTile2);}
		
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
		for (int row = 0; row < currentShape.length; row++) {
		    for (int column = 0; column < currentShape[row].length; column++) {
		        if (currentShape[row][column] == null) {
		        	nullLocation[0] = row;
		        	nullLocation[1] = column;
		        }
		    }
		}
		
		return nullLocation;
	}

	public TileSet getTileSet() {
		return this.tiles;
	}
	
	public Tile[][] getShape() {
		return currentShape;
	}
	
	public void addOneMove() {
		moves += 1;
	}
	
	public int getMoves() {
		return moves;
	}
	
	public void resetMoves() {
		moves = 0;
	}
	
	//functions below are used for test cases
	public void setShape(Tile[][] shape) {
		this.currentShape = shape;
	}
	
	public int[] getFindNullTile() {
		return this.findNullTile();
	}



}
