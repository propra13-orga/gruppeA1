package gruppeA1.dungeon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

import gruppeA1.dungeon.Tile;

public class Map extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static int sizeX = 20;
	private static int sizeY = 20;
	private static int tileSize = 24;
	
	private static int minLevel = 1;
	private static int maxLevel = 3;
	
	private int currentLevel;
	private int previousLevel;
	
	private Tile[][] tiles;
	private Player player;
	
	public Map(int level) {
		this.currentLevel = level;
		this.previousLevel = 0;
		
		try {
			this.readLevel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new KeyDispatcher(this));
		
		setSize(480,500);
		setFocusable(true);
	}
	
	private void readLevel() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/maps/map-"+this.currentLevel+".txt"));
		String line;
		
		int countX;
		int countY = 0;
		
		this.tiles = new Tile[sizeX][sizeY];
		
		while ((line = bufferedReader.readLine()) != null) {
			countX = 0;
			for (char type: line.toCharArray()) {
				this.tiles[countX][countY] = new Tile(countX, countY, tileSize, type);
				
				if (type == '0' && this.currentLevel > this.previousLevel) {
					this.player = new Player(countX, countY, tileSize);
				}
				
				if (type == 'x' && this.currentLevel < this.previousLevel) {
					this.player = new Player(countX, countY, tileSize);
				}
				
				countX++;
			}
			countY++;
		}
		
		bufferedReader.close();
	}
	
	private void nextLevel() {
		this.previousLevel = this.currentLevel;
		this.currentLevel++;
		
		try {
			this.readLevel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void previousLevel() {
		this.previousLevel = this.currentLevel;
		this.currentLevel--;
		
		try {
			this.readLevel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void win() {
		/*
		 * Spiel wurde gewonnen.
		 * TO DO: Dialog zum bestŠtigen anzeigen und danach das HauptmenŸ.
		 */
	}
	
	private void lose() {
		/*
		 * Spiel wurde verloren.
		 * TO DO: Dialog zum bestŠtigen anzeigen und danach das HauptmenŸ.
		 */
	}
	
	public void paint(Graphics graphics) {
		super.paint(graphics);
		
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y ++) {
				this.tiles[x][y].draw(graphics2D);
			}
		}
		
		this.player.draw(graphics2D);
	}

	public void action(KeyEvent keyEvent) {
		int keyPressed = keyEvent.getKeyCode();
		
		int playerX = this.player.getX();
		int playerY = this.player.getY();
		
		if(playerX == 0 || playerX == 19 || playerY == 0 || playerY == 19) {
			return;
		}
		
		Tile targetTile = null;
		
		switch (keyPressed) {
		case KeyEvent.VK_LEFT:
			targetTile = this.tiles[playerX-1][playerY];
			break;
		case KeyEvent.VK_UP:
			targetTile = this.tiles[playerX][playerY-1];
			break;
		case KeyEvent.VK_RIGHT:
			targetTile = this.tiles[playerX+1][playerY];
			break;
		case KeyEvent.VK_DOWN:
			targetTile = this.tiles[playerX][playerY+1];
			break;
		}
		
		if (targetTile.isWalkable()) {
			this.player.moveTo(targetTile.getX(), targetTile.getY());
		}
		
		if (targetTile.isDeadly()) {
			this.lose();
		}
		
		if (targetTile.isEntrance() && this.currentLevel > minLevel) {
			this.previousLevel();
		}
		
		if (targetTile.isExit() && this.currentLevel < maxLevel) {
			this.nextLevel();
		}
		else if (this.currentLevel == maxLevel) {
			this.win();
		}
		
		repaint();
	}
}
