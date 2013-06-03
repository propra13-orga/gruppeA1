package gruppeA1.dungeon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyDispatcher extends KeyAdapter {
	private Map map;
	
	public KeyDispatcher(Map map){
		this.map = map;	
	}

	public void keyReleased(KeyEvent keyEvent) {
		map.action(keyEvent);
	}
}
