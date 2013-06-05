package gruppeA1.dungeon;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JComponent;

public class Game extends JComponent {
	private static final long serialVersionUID = 1L;

	private static int lastMapNr = 3;
	
	private List<EventListener> gameListeners = new ArrayList<EventListener>();
	
	private Map currentMap = null;
	
	private Timer timer;
	
	public Game() {
		super();
		
		this.setSize(480, 480);
	}
	
	public void addGameListener(EventListener eventListener) {
		this.gameListeners.add(eventListener);
	}
	
	public void notifyGameListeners(Event event) {
		for (EventListener eventListener: this.gameListeners) {
			eventListener.handleGameEvent(event);
		}
	}
	
	public void startGame() {
		this.currentMap = new Map(1, '0', this);
		this.add(this.currentMap);
			
		this.startTasks();
		
		this.notifyGameListeners(new Event("go"));
	}
	
	public void pauseGame() {
		this.stopTasks();
		
		this.notifyGameListeners(new Event("pause"));
	}
	
	public void resumeGame() {
		this.startTasks();
		
		this.notifyGameListeners(new Event("resume"));
	}
	
	public void stopGame(boolean win) {
		this.stopTasks();

		this.remove(this.currentMap);
		
		this.currentMap = null;
		
		if (win) {
			this.notifyGameListeners(new Event("win"));
		}
		else {
			this.notifyGameListeners(new Event("lose"));
		}
	}
	
	public void nextMap() {
		int currentMapNr = this.currentMap.getMapNr();
		
		if (currentMapNr != Game.lastMapNr) {
			this.stopTasks();
			
			this.remove(this.currentMap);
			
			this.currentMap = new Map(currentMapNr+1, '0', this);
			
			this.add(this.currentMap);
			
			this.startTasks();
		}
		else {
			this.stopGame(true);
		}
	}
	
	public void previousMap() {
		int previousMapNr = this.currentMap.getMapNr()-1;
		
		if (previousMapNr > 0) {
			this.stopTasks();
			
			this.remove(this.currentMap);
			
			this.currentMap = new Map(previousMapNr, 'x', this);
			
			this.add(this.currentMap);
			
			this.startTasks();
		}
	}
	
	private void startTasks() {
		int mapTaskFrequency = (lastMapNr*200)-(this.currentMap.getMapNr()*100);
		
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(new MapTask(this.currentMap), mapTaskFrequency, mapTaskFrequency);
	}
	
	private void stopTasks() {
		this.timer.cancel();
		this.timer = null;
	}
	
	public void keyHandler(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.currentMap.movePlayer(-1, 0);
			break;
		case KeyEvent.VK_UP:
			this.currentMap.movePlayer(0, -1);
			break;
		case KeyEvent.VK_RIGHT:
			this.currentMap.movePlayer(1, 0);
			break;
		case KeyEvent.VK_DOWN:
			this.currentMap.movePlayer(0, 1);
			break;
		}
	}
}
