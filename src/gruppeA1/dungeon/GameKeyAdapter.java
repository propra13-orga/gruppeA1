package gruppeA1.dungeon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyAdapter extends KeyAdapter {
	private Game game;
	
	public GameKeyAdapter(Game game){
		this.game = game;
	}

	public void keyReleased(KeyEvent keyEvent) { 
		game.keyHandler(keyEvent);
	}
}
