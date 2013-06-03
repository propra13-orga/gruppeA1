package gruppeA1.dungeon;

import java.awt.Graphics2D;

public class Enemy extends MoveableEntity {
	public Enemy(int x, int y, int size) {
		super(x, y, size);
	}
	
	public void draw(Graphics2D graphics2D) {
		super.draw(graphics2D, 'e');
	}
	
	public boolean moveTo(Tile tile) {
		if (tile.isWalkable() && !tile.isDeadly()) {
			this.x = tile.getX();
			this.y = tile.getY();
			
			return true;
		}
		
		return false;
	}
}
