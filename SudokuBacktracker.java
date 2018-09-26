class SudokuBacktracker extends Backtracker<Integer>{
	//Instance Variables:
	
	//Constructors:
	SudokuBacktracker(Coordinate[] blankCoordinatesArr, Integer[] checkValuesArr, SudokuBoard inputBoard){
		this.setBlanks(blankCoordinatesArr); 
		this.setCheckValues(checkValuesArr); 
		this.setBacktrackableObject(inputBoard); 
	}
	
	//Methods:
	
	public boolean checkValueAtBlank(Integer checkValue, Blank inputCoordinate){
		Coordinate checkCoordinate = (Coordinate) inputCoordinate;
		
		if (checkXRow(checkValue, checkCoordinate) && checkYRow(checkValue, checkCoordinate) && checkSquare(checkValue, checkCoordinate) == true){
			return true; 
		}
		return false; 
	}
	
	
	
	public boolean checkXRow(Integer checkValue, Coordinate inputCoordinate){
		int xCoordinate = inputCoordinate.getXCoordinate(); 
		SudokuBoard typecastBoard = (SudokuBoard) getBoard(); 
		Coordinate[][] sudokuBoardCoordinates = typecastBoard.getCoordinates(); 
		
		for (int yCounter = 0; yCounter < 9; yCounter++){
			int currentValue; 
			if (sudokuBoardCoordinates[xCoordinate-1][yCounter].getValue() == null){
				currentValue = 0;
			}
			else{
				currentValue = sudokuBoardCoordinates[xCoordinate-1][yCounter].getValue();
			}
			if (sudokuBoardCoordinates[xCoordinate-1][yCounter].equals(inputCoordinate)){
				continue;
			}
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
	}
	
	public boolean checkYRow(Integer checkValue, Coordinate inputCoordinate){
		int yCoordinate = inputCoordinate.getYCoordinate(); 
		SudokuBoard typecastBoard = (SudokuBoard) getBoard(); 
		Coordinate[][] sudokuBoardCoordinates = typecastBoard.getCoordinates(); 
		
		for (int xCounter = 0; xCounter < 9; xCounter++){
			int currentValue; 
			if (sudokuBoardCoordinates[xCounter][yCoordinate-1].getValue() == null){
				currentValue = 0;
			}
			else{
				currentValue = sudokuBoardCoordinates[xCounter][yCoordinate-1].getValue();
			}
			if (sudokuBoardCoordinates[xCounter][yCoordinate-1].equals(inputCoordinate)){
				continue;
			}
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
		}
	
	public boolean checkSquare(int checkValue, Coordinate inputCoordinate){
		int checkSquareValue = inputCoordinate.getSquareValue(); 
		
		SudokuBoard typecastBoard = (SudokuBoard) getBoard(); 
		Coordinate[][] sudokuBoardCoordinates = typecastBoard.getCoordinates(); 
		
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				Coordinate checkCoordinate = sudokuBoardCoordinates[xCounter][yCounter];
				if (checkCoordinate.getValue() == null){
					continue;
				}
				//System.out.println("checkCoordinate Info: " + checkCoordinate.toString());
				if (checkCoordinate.equals(inputCoordinate)){
					continue;
				}
				if (checkSquareValue == checkCoordinate.getSquareValue()){
					if (checkValue == checkCoordinate.getValue()){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
}

	