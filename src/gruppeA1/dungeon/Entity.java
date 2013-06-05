package gruppeA1.dungeon;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Entity {
	protected Map map;
	
	public Map getMap() {
		return this.map;
	}
	
	protected int x;
	protected int y;
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	protected int size;
		
	public Entity (int x, int y, int size, Map map) {
		this.x = x;
		this.y = y;
		
		this.size = size;
		
		this.map = map;
	}
	
	protected void draw(Graphics2D graphics2D, char type) {
		ImageIcon imageIcon = new ImageIcon("resources/tiles/tile-"+type+".png");
		graphics2D.drawImage(imageIcon.getImage(), this.x*this.size, this.y*this.size, null);
	}
}
