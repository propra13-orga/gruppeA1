package gruppeA1.dungeon;

import java.awt.Graphics2D;

public class Player extends MoveableEntity{
	public Player(int x, int y, int size) {
		super(x, y, size);
	}
	
	public void draw(Graphics2D graphics2D) {
		super.draw(graphics2D, 'p');
	}
	
	/*
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
	*/
}
