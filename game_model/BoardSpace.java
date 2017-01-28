package game_model;

import java.util.List;
import java.util.ArrayList;

public class BoardSpace {
	private List<Player> playersOnSpace;
	private int moveValue;
	
	public BoardSpace() {
		this.playersOnSpace = new ArrayList<Player>();
		this.moveValue = 0;
	}
	
	public BoardSpace(List<Player> players) {
		this.playersOnSpace = new ArrayList<Player>();
		int numPlayers = players.size();
		for(int i=0; i < numPlayers; i++) {
			this.playersOnSpace.add(players.get(i));
		}
		this.moveValue = 0;
	}
	
	protected void addPlayer(Player player) {
		this.playersOnSpace.add(player);
	}
	
	protected void removePlayer(Player player) {
		this.playersOnSpace.remove(player);
	}
	
	public int getNumPlayers() {
		return this.playersOnSpace.size();
	}
	
	protected void changeMoveValue(int newValue) {
		this.moveValue = newValue;
	}
	
	public int getMoveValue() {
		return this.moveValue;
	}
	
	public List<Player> getPlayersOnSpace() {
		return this.playersOnSpace;
	}

}
