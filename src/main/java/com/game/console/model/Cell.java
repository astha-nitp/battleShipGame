package com.game.console.model;

public class Cell{

	 private int x_Coordinate;
	 
	 private char y_Coordinate;
	 
	 private String cellName;

	public Cell(int x_Coordinate, char y_Coordinate) {
		super();
		this.x_Coordinate = x_Coordinate;
		this.y_Coordinate = y_Coordinate;
		this.cellName = this.y_Coordinate+""+this.x_Coordinate;
	}

	
	public int getX_Coordinate() {
		return x_Coordinate;
	}

	public void setX_Coordinate(int x_Coordinate) {
		this.x_Coordinate = x_Coordinate;
	}

	public char getY_Coordinate() {
		return y_Coordinate;
	}

	public void setY_Coordinate(char y_Coordinate) {
		this.y_Coordinate = y_Coordinate;
	}

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}


}
