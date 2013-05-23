package gruppeA1.dungeon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Entity {

	public Enemy(int x, int y) {
		super(x, y);
		
	}

	
	public void draw(Graphics2D g){
		g.drawImage(getEnemyimage(),x,y,null);
		//g.draw(getBounds());
	}
	public Image getEnemyimage(){
		
		ImageIcon plimg = new ImageIcon("res/enemy.png");
		return plimg.getImage();
}
//	public Rectangle getBounds(){
//		return new Rectangle(x,y,getEnemyimage().getWidth(null),getEnemyimage().getHeight(null) );
//	}
}