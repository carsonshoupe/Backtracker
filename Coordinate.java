import java.lang.Integer;
import java.lang.Number;

class Coordinate extends Blank<Integer>{
	//Instance Variables:
	private int xCoordinate;
	private int yCoordinate;
	private int squareValue;
	private boolean valueLocked;
	
	//Constructors:
	Coordinate(int x, int y){
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
	
	public void setXCoordinate(int newX){this.xCoordinate = newX;}
	public void setYCoordinate(int newY){this.yCoordinate = newY;}
	public void setSquareValue(int newSquareValue){this.squareValue = newSquareValue;}
	public void setValueLocked(boolean locked){valueLocked = locked;}
	
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
		String resultString = " \nCoordinate: (" + getXCoordinate() + ", " + getYCoordinate() + ")\n" + "Square Value: " + getSquareValue() + "\n" + "Value at Coordinate: " + getValue() + "\n" + "Locked: " + getValueLocked() + "\n";
		
		return resultString; 
	}
	
	public void printCoordinate(){System.out.println(this.toString());}
}
		
		
		
		
		
		
		
		
		
		
		
		
		