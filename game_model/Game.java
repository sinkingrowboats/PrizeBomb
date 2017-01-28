package game_model;

import java.util.List;

public class Game {
	private List<Player> players;
	private int numPlayers;
	private int currentPlayerIndex;
	private Board board;

	public Game(Board gameBoard, List<Player> gamePlayers) {
		this.board = gameBoard;
		this.players = gamePlayers;
		this.numPlayers = gamePlayers.size();
		this.currentPlayerIndex = 0;
	}
	
	private void move(Player player, int spacesToMove) {
		int numSpaces = this.board.getNumSpaces();
		this._move(player, spacesToMove, numSpaces);
	}
	
	private void _move(Player player, int spacesToMove, int numSpaces) {
		IntegerTuple currentPos = player.getPos();
		IntegerTuple newPos = currentPos;
		int toMove = spacesToMove;
		int currentPosNum = this.board.getBoardSpaceNumFromArrayPos(currentPos);
		System.out.println("Your start pos was " + currentPosNum);
		while (toMove != 0) {
			int newSpace = toMove + currentPosNum;
			if(newSpace >= numSpaces) {
				currentPosNum = numSpaces-1;
			}
			else if (newSpace < 0) {
				currentPosNum = 0;
			}
			else {
				currentPosNum = newSpace;
			}
			newPos = this.board.getArrayPosFromSpaceNum(currentPosNum);
			toMove = this.board.getMoveValueFromArrayPos(newPos);
		}
		System.out.println("Your end pos is " + currentPosNum);
		
		this.changePlayerPos(player, currentPos, newPos);
	}
	
	//change to Private
	public void changePlayerPos(Player player, IntegerTuple oldPos,
			IntegerTuple newPos) {
		this.board.removePlayerFromSpace(player, oldPos);
		this.board.addPlayerToSpace(player, newPos);
		player.changePos(newPos);
	}
	
	//make private after testing
	public void playTurn() {
		Player currentPlayer = players.get(currentPlayerIndex);
		currentPlayer.changeTurn();
		
		int roll = currentPlayer.roll();
		
		this.move(currentPlayer, roll);
		
		currentPlayer.changeTurn();
		if (this.currentPlayerIndex == this.numPlayers - 1) {
			this.currentPlayerIndex = 0;
		}
		else {
			this.currentPlayerIndex++;
		}
	}
	
	private List<Player> winList(){
		List<Player> winList =
				this.board.getPlayerListPos(new IntegerTuple(0,0));
		return winList;
	}
	
	public void playGame() {
		List<Player> winList;
		do{
			this.playTurn();
			winList = this.winList();
		} while(winList.size() == 0);
		
		System.out.println("The winner is " + winList.get(0).getName());
	}
	
}
