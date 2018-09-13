class Blank<V>{
	//Instance Variables:
	private V value;  
	
	//Constructors: 
	Blank(V inputV){
		this.value = inputV; 
	}
	
	//Methods:
	public V getValue(){return this.value;}
	
	public void setValue(V inputValue){
		this.value = inputValue; 
	}
	
	public boolean checkValueAtBlank(V checkValue) throws UnimplementedFunctionException{
		throw new UnimplementedFunctionException();
	}
}
		
		