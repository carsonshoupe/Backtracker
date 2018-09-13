import java.util.ArrayList;

class BacktrackerTester{
public static void main(String args[]){
	SudokuBoard testSudokuBoard = new SudokuBoard("409300000500407000017680000000000520108000603065000000000076350000209008000004906");
	
	Coordinate[][] testSudokuBoardCoordinatres = testSudokuBoard.getCoordinates();
	
	int blanksArrayLengthCounter = 0; 
	for (int yCounter = 0; yCounter<9; yCounter++){
		for (int xCounter = 0; xCounter<9; xCounter++){
			if (testSudokuBoardCoordinatres[yCounter][xCounter].getValueLocked() == false){
				blanksArrayLengthCounter++; 
			}
		}
	}
	
	Blank[] blanksForBacktracker = new Blank [blanksArrayLengthCounter];
	int orderedCoordinatesCounter = 0; 
	for (int yCounter = 0; yCounter<9; yCounter++){
		for (int xCounter = 0; xCounter<9; xCounter++){
			if (testSudokuBoardCoordinatres[yCounter][xCounter].getValueLocked() == false){
				blanksForBacktracker[orderedCoordinatesCounter] = testSudokuBoardCoordinatres[xCounter][yCounter];
				orderedCoordinatesCounter++;
			}
		}
	}
	
	ArrayList<Integer> arrayListForBacktracker = new ArrayList<Integer>();
	for (int counter = 1; counter < 10; counter++){
		arrayListForBacktracker.add(counter);
	}

	Backtracker bt = new Backtracker(blanksForBacktracker, arrayListForBacktracker);
	
	try{
		Blank[] ans = bt.runBacktracker();
	}
	catch (UnimplementedFunctionException e){
		System.out.println("Ya dun goofed");
	}
		
}
}
	
