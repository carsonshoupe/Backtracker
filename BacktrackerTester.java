import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class BacktrackerTester{
	private SudokuBoard testSudokuBoard; 
	private Blank[] blanksForBacktracker;
	private ArrayList<Integer> arrayListForBacktracker;
	
	@Before
	public void setUp(){
		this.testSudokuBoard = new SudokuBoard("000200700060004000020089301280003006005000200300600058106870040000100080008006000");
		
		this.blanksForBacktracker = testSudokuBoard.getUnlockedCoordinates();
		
		this.arrayListForBacktracker = new ArrayList<Integer>();
		for (int counter = 1; counter < 10; counter++){
			arrayListForBacktracker.add(counter);
		}
		System.out.println(this.testSudokuBoard.toString()); 
	}
	/* 
	@Test
	public void testCheckFunctions(){
		Coordinate testCoordinate = testSudokuBoard.getCoordinates()[4][7]; 
		System.out.println(testCoordinate); 
		
		for (int counter = 1; counter < 10; counter++){
			if (testCoordinate.checkValueAtBlank(counter, testSudokuBoard) == true){
				System.out.println("checkValue " + counter + " worked."); 
			}
			else{
				System.out.println("checkValue " + counter + " failed.");
			}
		}
		assertEquals(true, testCoordinate.checkXRow(7, testSudokuBoard));
		assertEquals(true, testCoordinate.checkYRow(2, testSudokuBoard));
		assertEquals(true, testCoordinate.checkYRow(5, testSudokuBoard));
		assertEquals(true, testCoordinate.checkSquare(6, testSudokuBoard));
		assertEquals(true, testCoordinate.checkSquare(2, testSudokuBoard));
	}
	*/
	
	/* 
	@Test
	public void printBlanks(){
		for (int counter = 0; counter < blanksForBacktracker.length; counter++){
			System.out.println(blanksForBacktracker[counter].toString());
		}
	}
	 */
	
	/* 
	@Test
	public void printCheckValues(){
		System.out.println("CheckValues: " + this.arrayListForBacktracker.toString()); 
	}
	 */

	@Test
	public void testBacktracker(){	
		try{
			Backtracker bt = new Backtracker(blanksForBacktracker, arrayListForBacktracker, testSudokuBoard);
			Coordinate[] ans = (Coordinate[]) bt.runBacktracker();
			testSudokuBoard.printSudokuBoard();
		}
		catch(UnsolveableException e) {
			System.out.println(e.getMessage()); 
		}
		 
	}
	
}	

//javac -cp .;C:\junit\junit-4.10.jar BacktrackerTester.java
//java -cp .;C:\junit\junit-4.10.jar org.junit.runner.JUnitCore BacktrackerTester
