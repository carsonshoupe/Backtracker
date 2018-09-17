class SudokuBoard extends BacktrackableObject{
	//Instance Variables:
	private Coordinate[][] coordinates = new Coordinate[9][9];
	private String boardInputAsString; 
	
	//Constructors:
	SudokuBoard(String boardAsNumbers){
		this.boardInputAsString = boardAsNumbers; 
		int locationCounter = 0; //This var is the location in the string of boardAsNumbers
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				this.coordinates[xCounter][yCounter] = new Coordinate(xCounter+1, yCounter+1);
				
				char tempChar = boardAsNumbers.charAt(locationCounter);
				int tempInt = Integer.parseInt(String.valueOf(tempChar)); //converting the charAt char to an int
				
				this.coordinates[xCounter][yCounter].setValue(tempInt); 
				
				if (tempInt !=0){
					this.coordinates[xCounter][yCounter].setValueLocked(true); //locking preset values
				}
				
				locationCounter++;
			}
		}
		setSingleDimArrOfCoordinates();
	}
	
	SudokuBoard(Coordinate[][] inputCoordinates){ //clones coordinates
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				Coordinate updatedCoordinate = inputCoordinates[xCounter][yCounter].clone(); 
				this.coordinates[xCounter][yCounter] = updatedCoordinate; 
			}
		}
		setSingleDimArrOfCoordinates();
	}
	
	SudokuBoard(){
		this("000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		}
	
	//Methods:
	public Coordinate[][] getCoordinates(){return this.coordinates;} 
	public void setCoordinates(Coordinate[][] updatedCoordinates){this.coordinates = updatedCoordinates;}
	
	public Coordinate[] getUnlockedCoordinates(){
		int unlockedCoordinatesLength = 0; 
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				if (this.getCoordinates()[yCounter][xCounter].getValueLocked() == false){
					unlockedCoordinatesLength++; 
				}
			}
		}
		Coordinate[] unlockedCoordinatesArray = new Coordinate[unlockedCoordinatesLength];
		int orderedCoordinatesCounter = 0; 
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				if (this.getCoordinates()[xCounter][yCounter].getValueLocked() == false){
					unlockedCoordinatesArray[orderedCoordinatesCounter] = this.getCoordinates()[xCounter][yCounter];
					orderedCoordinatesCounter++;
				}
			}
		}
		return unlockedCoordinatesArray; 
	}
	
	public void setSingleDimArrOfCoordinates(){
		Coordinate[] outputArr = new Coordinate[81];
		int counter = 0;
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				outputArr[counter] = this.getCoordinates()[xCounter][yCounter]; 
				counter++;
			}
		}
		this.setArrOfBlanks(outputArr); 
	}
	
	
	
	
	
	
	@Override
	public String toString(){ 
	//Not sure if its better to save the string formatted as I want it to print or to save it as a flat string of numbers.  Same follows for the toString fxn for Coordinate. 
		String resultString = ""; 
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				Coordinate[][] currentCoordinates = this.getCoordinates();
				resultString = resultString + currentCoordinates[xCounter][yCounter].getValue() +("   ");
			}
			resultString = resultString + "\n"; 
		}
		return resultString; 
	}
	
	public void printSudokuBoard(){System.out.println(this.toString());}
	
	@Override
	public SudokuBoard clone(){
		//Whenever you make a sudokuboard from input coordinates, it clones all the coordinates and makes a board from there.  So my cloner just uses the SudokuBoard(coordinates[][]) constructor.  
		SudokuBoard outputSudokuBoard = new SudokuBoard(this.getCoordinates()); 
		return outputSudokuBoard; 
	}
}