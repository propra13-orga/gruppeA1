

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Player extends Entity{
	
	int moveX = 0;
	int moveY = 0;
	
	public Player(int x, int y) {
		super(x, y);
		}
	
	public  void update(){
		y += moveY;
		x += moveX;	
		}
	
	public void draw(Graphics2D g){
		g.drawImage(getplayerimage(),x,y,null);
		
	}
	
	public Image getplayerimage(){
		
		ImageIcon plimg = new ImageIcon("res/player.png");
		return plimg.getImage();
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP){
			moveY = -2;
		}
		else if(key == KeyEvent.VK_DOWN){
			moveY = 2;
		}
		else if(key == KeyEvent.VK_LEFT){
			moveX = -2;
		}
		else if(key == KeyEvent.VK_RIGHT){
			moveX = 2;
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

}
