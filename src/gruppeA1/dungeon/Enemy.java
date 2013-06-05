package gruppeA1.dungeon;

import java.awt.Graphics2D;

public class Enemy extends MoveableEntity {
	public Enemy(int x, int y, int size, Map map) {
		super(x, y, size, map);
	}
	
	public void draw(Graphics2D graphics2D) {
		super.draw(graphics2D, 'e');
	}
	
	public boolean moveTo(Tile tile) {
		if (tile.isWalkable() && !tile.isEnemy()) {
			this.map.getTileAt(this.x, this.y).setEnemy(false);
			
			this.x = tile.getX();
			this.y = tile.getY();
			
			tile.setEnemy(true);
			
			return true;
		}
		
		return false;
	}
}
