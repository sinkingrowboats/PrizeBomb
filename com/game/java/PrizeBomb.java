package com.game.java;

import java.util.List;
import java.util.ArrayList;

import game_model.*;

public class PrizeBomb {

	public static void main(String[] args) {
		
		//Get some Players
		Player me = new Player("me");
		Player you = new Player("You");
		List<Player> players = new ArrayList<Player>();
		players.add(me);
		players.add(you);
		
		//Create a board
		Board gameBoard = new Board(6,6, players);
		
		//Play the game
		Game testGame = new Game(gameBoard, players);
		
		testGame.playGame();

	}

}
