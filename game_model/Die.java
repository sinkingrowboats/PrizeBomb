package game_model;

import java.util.Random;

public class Die {
	private Random die;
	
	public Die() {
		this.die = new Random();
	}
	
	public int rollDie() {
		return die.nextInt(6) + 1;
	}
	
	public static int staticRollDie() {
		return	1 + ((int) Math.floor(Math.random() * 6));
	}
}
