import java.lang.Integer;
import java.lang.Number;

class Coordinate extends Blank<Integer>{
	//Instance Variables:
	private int xCoordinate;
	private int yCoordinate;
	private int squareValue;
	private boolean valueLocked;
	private SudokuBoard mySudokuBoard;
	
	//Constructors:
	Coordinate(int x, int y){
		super(0);
		this.xCoordinate = x; 
		this.yCoordinate = y; 
		this.squareValue = Coordinate.calculateSquareValue(x, y);
		this.valueLocked = false; 
	}
	
	//Methods:
	public static int calculateSquareValue(int x, int y){
		return ((x-1)/3 + ((y-1)/3)*3)+1; 
	}
	
	
	public int getXCoordinate(){return this.xCoordinate;} 
	public int getYCoordinate(){return this.yCoordinate;} 
	public int getSquareValue(){return this.squareValue;}
	public boolean getValueLocked(){return this.valueLocked;}
	public SudokuBoard getMySudokuBoard(){return this.mySudokuBoard;}
	
	public void setXCoordinate(int newX){this.xCoordinate = newX;}
	public void setYCoordinate(int newY){this.yCoordinate = newY;}
	public void setSquareValue(int newSquareValue){this.squareValue = newSquareValue;}
	public void setValueLocked(boolean locked){valueLocked = locked;}
	public void setMySudokuBoard(SudokuBoard inputSudokuBoard){this.mySudokuBoard = inputSudokuBoard;}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Coordinate)){
			return false;
		}
		
		Coordinate anotherCoordinate = (Coordinate) o;
		
		if (this.getXCoordinate() == anotherCoordinate.getXCoordinate() && this.getYCoordinate() == anotherCoordinate.getYCoordinate()){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public Coordinate clone(){
		Coordinate outputCoordinate = new Coordinate(this.getXCoordinate(), this.getYCoordinate()); 
		outputCoordinate.setValue(this.getValue()); 
		outputCoordinate.setValueLocked(this.getValueLocked()); 
		return outputCoordinate;
	}
	
	@Override
	public String toString(){
		String resultString = "Coordinates: (" + getXCoordinate() + ", " + getYCoordinate() + ")\n" + "Square Value: " + getSquareValue() + "\n" + "Value at Coordinate: " + getValue() + "\n" + "Locked: " + getValueLocked() + "\n";
		
		return resultString; 
	}
	
	public void printCoordinate(){System.out.println(this.toString());}
	
	@Override
	public boolean checkValueAtBlank(Integer checkValue){
		int unwrappedCheckValue = checkValue;
		if (checkXRow(unwrappedCheckValue) && checkYRow(unwrappedCheckValue) && checkSquare(unwrappedCheckValue) == true){
			return true; 
		}
		return false; 
	}
		
	public boolean checkXRow(int checkValue){
		int xCoordinate = this.getXCoordinate(); 
		Coordinate[][] sudokuBoardCoordinates = this.mySudokuBoard.getCoordinates(); 
		
		for (int yCounter = 0; yCounter < 9; yCounter++){
			int currentValue; 
			if (sudokuBoardCoordinates[xCoordinate-1][yCounter].getValue() == null){
				currentValue = 0;
			}
			else{
				currentValue = sudokuBoardCoordinates[xCoordinate-1][yCounter].getValue().intValue();
			}
			if (sudokuBoardCoordinates[xCoordinate-1][yCounter].equals(this)){
				continue;
			}
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
	}
	
	public boolean checkYRow(int checkValue){
		int yCoordinate = this.getYCoordinate(); 
		Coordinate[][] sudokuBoardCoordinates = this.mySudokuBoard.getCoordinates(); 
		
		for (int xCounter = 0; xCounter < 9; xCounter++){
			int currentValue; 
			if (sudokuBoardCoordinates[xCounter][yCoordinate-1].getValue() == null){
				currentValue = 0;
			}
			else{
				currentValue = sudokuBoardCoordinates[xCounter][yCoordinate-1].getValue().intValue();
			}
			if (sudokuBoardCoordinates[xCounter][yCoordinate-1].equals(this)){
				continue;
			}
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
		}
	
	public boolean checkSquare(int checkValue){
		int checkSquareValue = this.getSquareValue(); 
		
		Coordinate[][] sudokuBoardCoordinates = this.mySudokuBoard.getCoordinates(); 
		
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				Coordinate checkCoordinate = sudokuBoardCoordinates[yCounter][xCounter];
				if (checkCoordinate.equals(this)){
					continue;
				}
				if (checkSquareValue == checkCoordinate.getSquareValue()){
					if (checkValue == checkCoordinate.getValue().intValue()){
						return false;
					}
				}
			}
		}
		return true;
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		