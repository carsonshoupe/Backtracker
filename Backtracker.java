import java.util.ArrayList;

class Backtracker<V>{
	//Instance Variables: 
	private Blank[] blanks; 
	private ArrayList<V> checkValues = new ArrayList<V>(); 
	private BacktrackableObject board; 
	
	
	
	
	//Constructors: 
	Backtracker(Blank[] inputBlanks, ArrayList<V> inputCheckValues, BacktrackableObject inputBoard){
		this.blanks = inputBlanks; 
		this.checkValues = inputCheckValues; 
		this.board = inputBoard;
	}
		
	
	//Methods:
	public Blank[] getBlanks(){return this.blanks;}
	public ArrayList<V> getCheckValues(){return this.checkValues;}
	public BacktrackableObject getBoard(){return this.board;}
	
	public void setBlanks(Blank[] inputBlanks){
		this.blanks = inputBlanks;
	}
	public void setCheckValues(ArrayList<V> inputCheckValues){
		checkValues = inputCheckValues; 
	}
	
	public Blank[] runBacktracker() throws UnsolveableException{
		int tracker = 0; 
		while (tracker < blanks.length){
			//System.out.println(blanks[tracker].toString());
			if (tracker == -1){ //Quick exception check//
				throw new UnsolveableException("There is no combination of values that makes this board work.");
			}				
			
			if (tryCheckValuesInBlank(blanks[tracker]) == true){
				tracker++;
			}
			else{
				blanks[tracker].setValue(null); 
				tracker--; 
			}
		}
		return this.blanks; 
	}
	
	public boolean tryCheckValuesInBlank(Blank inputBlank){
		int checkValuesIndex; 
		if (inputBlank.getValue() == null){
			checkValuesIndex = 0; 
		}
		else{
			checkValuesIndex = this.checkValues.indexOf(inputBlank.getValue())+1; 
		}
		
		while (checkValuesIndex < this.checkValues.size()){
			//System.out.println("checkValuesIndex: " + checkValuesIndex);
			//System.out.println("checkValue: " + checkValues.get(checkValuesIndex));
			if (inputBlank.checkValueAtBlank(checkValues.get(checkValuesIndex), this.board) == true){
				inputBlank.setValue(checkValues.get(checkValuesIndex)); 
				return true; 
			}
			else{
				checkValuesIndex++;
			}
		}
		return false;
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				