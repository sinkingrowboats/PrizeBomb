package game_model;

import java.util.List;

public class Board {
	private BoardSpace[][] gameBoard;
	int rows;
	int cols;
	int numSpaces;
	
	//Various Constructors
	public Board(List<Player> players) {
		this(10,10,players);
	}
	
	public Board(int rows, int cols, List<Player> players) {
		this.rows = rows;
		this.cols = cols;
		this.numSpaces = rows * cols;
		
		//number of rows and columns must be greater than 1 to create a Board;
		if(rows <= 1 || cols <= 1) {
			throw new RuntimeException("Invalid Number of Rows or Columns");
		}
		
		else {
			this.gameBoard = new BoardSpace[rows][cols];
			
			/* determine where the starting position will be based on
			 * whether there is an even or odd number of rows
			 */
			int startRow = rows -1;
			int startCol;
			if(rows%2 == 0) {
				startCol = 0;
			}
			else {
				startCol = cols-1;
			}
			
			//instantiate gameBoard with BoardSpace objects
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					if(!(i==startRow && j==startCol)) {
						this.gameBoard[i][j] = new BoardSpace();
					}
				}
			}
			
			//Instantiating the start BoardSpace to have all the players in it
			// Setting the start Position to the BoardSpace at the determined start			
			this.gameBoard[startRow][startCol] = new BoardSpace(players);
			for(int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				player.changePos(startRow, startCol);
			}
				
		}
	}
	
	protected void addPlayerToSpace(Player player, IntegerTuple boardSpace) {
		this.gameBoard[boardSpace.getX()][boardSpace.getY()].addPlayer(player);
	}
	protected void removePlayerFromSpace(Player player, IntegerTuple boardSpace) {
		this.gameBoard[boardSpace.getX()][boardSpace.getY()].removePlayer(player);
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getCols() {
		return this.cols;
	}
	
	//board numbers go from 0 to (rows x cols)-1
	public int getBoardSpaceNumFromArrayPos(IntegerTuple Pos) {
		int rowIndex = Pos.getX();
		int colIndex = Pos.getY();
		int spaceNum;
		int numRows = this.rows;
		int numCols = this.cols;
		
		if((rowIndex >= numRows || rowIndex < 0) ||
				(colIndex >= numCols || colIndex < 0)){
			throw new RuntimeException("Invalid Board Position");
		}
		else {
			spaceNum = (numRows - 1 - rowIndex) * numCols;
			if (rowIndex % 2 == 0) {
				spaceNum = spaceNum + (numCols - 1 - colIndex);
			}
			else {
				spaceNum = spaceNum + colIndex;
			}
			
			return spaceNum;
		}
	}
	
	public IntegerTuple getArrayPosFromSpaceNum(int spaceNum) {
		int rowIndex;
		int colIndex;
		int numCols = this.cols;
		int numRows = this.rows;
		
		if(spaceNum < 0 || spaceNum >= this.numSpaces) {
			throw new RuntimeException("Invalid Board Position");
		}
		
		else {
			int inverseRowIndex = spaceNum/numCols;
			rowIndex = numRows - 1 - (inverseRowIndex);
			int i = inverseRowIndex * numCols;
			i = spaceNum - i;
			
			if(rowIndex % 2 == 0) {
				colIndex = numCols - 1 - i;
			}
			else {
				colIndex = i;
			}
			
			return new IntegerTuple(rowIndex, colIndex);
		}
	}
	
	public int getNumSpaces() {
		return numSpaces;
	}
	
	public int getMoveValueFromArrayPos(IntegerTuple boardSpace){
		return this.gameBoard[boardSpace.getX()][boardSpace.getY()].getMoveValue();
	}
	
	public List<Player> getPlayerListPos(IntegerTuple pos) {
		return this.gameBoard[pos.getX()][pos.getY()].getPlayersOnSpace();
	}
}
