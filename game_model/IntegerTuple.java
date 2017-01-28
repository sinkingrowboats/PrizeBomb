package game_model;

public class IntegerTuple {
	private int x;
	private int y;
	
	public IntegerTuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void changeTuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void changeX(int x) {
		this.x = x;
	}
	
	public void changeY(int y ) {
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public String toString(){
		return("X: " + this.x + "  Y: " + this.y);
	}
}
