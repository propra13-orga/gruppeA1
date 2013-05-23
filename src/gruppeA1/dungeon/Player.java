package gruppeA1.dungeon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Player extends Entity{
	
	int moveX = 0;
	int moveY = 0;
	int speed = 1;
	
	public Player(int x, int y) {
		super(x, y);
		}
	
	public  void update(){
		y += moveY;
		x += moveX;	
		}
	
	public void draw(Graphics2D g){
		
		g.drawImage(getplayerimage(),x,y,null);
		//g.draw(getBounds());
	}
	
	public Image getplayerimage(){
		
		ImageIcon plimg = new ImageIcon("res/player_down.png");
		return plimg.getImage();
		
	}
	public Image getdeadimage(){
		
		ImageIcon plimg = new ImageIcon("res/player_down.png");
		return plimg.getImage();
	}
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP){
			moveY = -speed;
			
		}
		else if(key == KeyEvent.VK_DOWN){
			moveY = speed;
			
		}
		else if(key == KeyEvent.VK_LEFT){
			moveX = -speed;
			
		}
		else if(key == KeyEvent.VK_RIGHT){
			moveX = speed;
			
		}
		
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP){
			moveY = 0;
		}
		else if(key == KeyEvent.VK_DOWN){
			moveY = 0;
		}
		else if(key == KeyEvent.VK_LEFT){
			moveX = 0;
		}
		else if(key == KeyEvent.VK_RIGHT){
			moveX = 0;
		}
	}
//	public void  kollision(){
//		
//		if (getBounds().intersects(getBounds())){
//			
//		}
//	}
//	public Rectangle getBounds(){
//		return new Rectangle(x,y,getplayerimage().getWidth(null),getplayerimage().getHeight(null) );
//	}
	
}
