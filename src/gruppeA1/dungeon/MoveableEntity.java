package gruppeA1.dungeon;

public class MoveableEntity extends Entity {
	public MoveableEntity(int x, int y, int size, Map map) {
		super(x, y, size, map);
	}
	
	public void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean moveTo(Tile tile) {
		if (tile.isWalkable()) {
			this.x = tile.getX();
			this.y = tile.getY();
			
			return true;
		}
		
		return false;
	}
}
