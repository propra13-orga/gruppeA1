package gruppeA1.dungeon;

import java.awt.Graphics2D;

public class Player extends MoveableEntity{
	public Player(int x, int y, int size) {
		super(x, y, size);
	}
	
	public void draw(Graphics2D graphics2D) {
		super.draw(graphics2D, 'p');
	}
}
