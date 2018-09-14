import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class BacktrackerTester{
	private SudokuBoard testSudokuBoard; 
	private Blank[] blanksForBacktracker;
	private ArrayList<Integer> arrayListForBacktracker;
	
	@Before
	public void setUp(){
		this.testSudokuBoard = new SudokuBoard("409300000500407000017680000000000520108000603065000000000076350000209008000004906");
		
		this.blanksForBacktracker = testSudokuBoard.getUnlockedCoordinates();
		
		this.arrayListForBacktracker = new ArrayList<Integer>();
		for (int counter = 1; counter < 10; counter++){
			arrayListForBacktracker.add(counter);
		}
	}
	
	@Test
	public void printTestSudokuBoard(){
		System.out.println(this.testSudokuBoard.toString()); 
	}
	
	@Test
	public void testBacktracker(){		
		Backtracker bt = new Backtracker(blanksForBacktracker, arrayListForBacktracker);
		
		Blank[] ans = bt.runBacktracker();
		 
	}
}	

//javac -cp .;C:\junit\junit-4.10.jar BacktrackerTester.java
//java -cp .;C:\junit\junit-4.10.jar org.junit.runner.JUnitCore BacktrackerTester
