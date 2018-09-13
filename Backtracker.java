import java.util.ArrayList;

class Backtracker<V>{
	//Instance Variables: 
	private Blank[] blanks; 
	private ArrayList<V> checkValues = new ArrayList<V>(); 
	
	
	
	
	//Constructors: 
	Backtracker(Blank[] inputBlanks, ArrayList<V> inputCheckValues){
		this.blanks = inputBlanks; 
		this.checkValues = inputCheckValues; 
	}
		
	
	//Methods:
	public Blank[] getBlanks(){return this.blanks;}
	public ArrayList<V> getCheckValues(){return this.checkValues;}
	
	public void setBlanks(Blank[] inputBlanks){
		this.blanks = inputBlanks;
	}
	public void setCheckValues(ArrayList<V> inputCheckValues){
		checkValues = inputCheckValues; 
	}
	
	public Blank[] runBacktracker() throws UnimplementedFunctionException{
		int tracker = 0; 
		while (tracker < blanks.length){
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
	
	public boolean tryCheckValuesInBlank(Blank inputBlank) throws UnimplementedFunctionException{
		int checkValuesIndex; 
		if (inputBlank.getValue() == null){
			checkValuesIndex = 0; 
		}
		else{
			checkValuesIndex = this.checkValues.indexOf(inputBlank.getValue())+1; 
		}
		
		while (checkValuesIndex < this.checkValues.size()){
			if (inputBlank.checkValueAtBlank(checkValues.get(checkValuesIndex)) == true){
				inputBlank.setValue(checkValues.get(checkValuesIndex)); 
				return true; 
			}
			else{
				continue;
			}
		}
		return false;
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				