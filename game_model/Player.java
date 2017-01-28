package game_model;

import java.util.Scanner;

public class Player {
	private String name;
	private boolean myTurn;
	private IntegerTuple currentPos;
	//dist subclass can add ME token
	
	public Player(String newName) {
		this.name = newName;
		this.myTurn = false;
		this.currentPos = new IntegerTuple(0,0);
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isMyTurn() {
		return this.myTurn;
	}
	
	public void changeTurn() {
		this.myTurn = (!this.myTurn);
	}
	
	public int getRow() {
		return this.currentPos.getX();
	}
	
	public int getCol() {
		return this.currentPos.getY();
	}
	
	public IntegerTuple getPos() {
		return this.currentPos;
	}
	
	public void changePos(IntegerTuple newPos) {
		this.currentPos.changeTuple(newPos.getX(), newPos.getY());
	}
	
	public void changePos(int newRow, int newCol) {
		this.currentPos.changeTuple(newRow, newCol);
	}
	
	public int roll() {
		//dist subclass will do communication somehow
		Scanner scanner = new Scanner(System.in);
		String input;
		do {
			System.out.println("Type \"Roll\" to proceed");
			input = scanner.nextLine();
		} while (!(input.equals("Roll")));
		
		return Die.staticRollDie();	
	}
}
