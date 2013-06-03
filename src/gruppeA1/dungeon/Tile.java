package gruppeA1.dungeon;

import java.awt.Graphics2D;

public class Tile extends Entity {
	private char type;
	
	public char getType() {
		return type;
	}
	
	private boolean isWalkable;
	private boolean isDeadly;
	private boolean isEntrance;
	private boolean isExit;
	
	public boolean isWalkable() {
		return isWalkable;
	}
	
	public boolean isDeadly() {
		return isDeadly;
	}
	
	public boolean isEntrance() {
		return isEntrance;
	}
	
	public boolean isExit() {
		return isExit;
	}
	
	public Tile(int x, int y, int size, char type) {
		super(x, y, size);
		
		this.type = type;
		
		this.isWalkable = false;
		this.isDeadly = false;
		this.isEntrance = false;
		this.isExit = false;
		
		switch (type) {
		case '0':
			this.isWalkable = true;
			this.isEntrance = true;
			break;
		case 's':
			this.isWalkable = true;
			break;
		case 'g':
			this.isWalkable = true;
			break;
		case 'e':
			this.isWalkable = true;
			this.isDeadly = true;
			break;
		case 'x':
			this.isWalkable = true;
			this.isExit = true;	
			break;
		}
	}
	
	public void draw(Graphics2D graphics2D) {
		if(this.type == '0' || this.type == 'x') {
			super.draw(graphics2D, 's');
		}
		
		if(this.type == 'e') {
			super.draw(graphics2D, 'g');
		} else {
			super.draw(graphics2D, this.type);
		}
	}
}
