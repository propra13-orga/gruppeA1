package gruppeA1.dungeon;

import java.util.TimerTask;

public class MapTask extends TimerTask {
	private Map map;
	
	@Override
	public void run() {
		for (Enemy enemy: this.map.getEnemies()) {
			int moveX = this.getRandomStep();
			int moveY = this.getRandomStep();
			
			if (moveX > 0 || moveX < 0) {
				this.map.moveEnemy(enemy, moveX, 0);
			} else if (moveY > 0 || moveY < 0) {
				this.map.moveEnemy(enemy, 0, moveY);
			}
		}
		
		this.map.repaint();
	}

	public MapTask(Map map) {
		this.map = map;
	}
	
	private int getRandomStep() {
		int min = Math.min(-1,1);
		int max = Math.max(-1,1);
		
		return min+(int)(Math.random()*((max-min) + 1));
	}
}
