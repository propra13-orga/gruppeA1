package gruppeA1.dungeon;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Entity {
	protected int x;
	protected int y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	protected int size;
		
	public Entity (int x, int y, int size) {
		this.x = x;
		this.y = y;
		
		this.size = size;
	}
	
	protected void draw(Graphics2D graphics2D, char type) {
		ImageIcon imageIcon = new ImageIcon("resources/tiles/tile-"+type+".png");
		graphics2D.drawImage(imageIcon.getImage(), this.x*this.size, this.y*this.size, null);
	}
}
