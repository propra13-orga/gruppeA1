package gruppeA1.dungeon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;

import gruppeA1.dungeon.Tile;

public class Map extends JComponent {
	private static final long serialVersionUID = 1L;
	
	private static int sizeX = 20;
	private static int sizeY = 20;
	private static int tileSize = 24;

	private int mapNr;
	
	public int getMapNr() {
		return this.mapNr;
	}
	
	private char playerSpawnPoint;

	private Tile[][] tiles;
	
	public Tile getTileAt(int x, int y) {
		return this.tiles[x][y];
	}
	
	private Player player;
	private ArrayList<Enemy> enemies;
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	private Game game;
	
	public Map(int mapNr, char playerSpawnPoint, Game game) {
		this.mapNr = mapNr;
		this.playerSpawnPoint = playerSpawnPoint;
		this.game = game;
		
		this.readMap();
		
		this.setSize(480,480);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y ++) {
				this.tiles[x][y].draw(graphics2D);
			}
		}

		this.player.draw(graphics2D);
		
		for (Enemy enemy: this.enemies) {
		    enemy.draw(graphics2D);
		}
	}
	
	private void readMap() {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("resources/maps/map-"+this.mapNr+".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		
		int countX;
		int countY = 0;
		
		this.tiles = new Tile[sizeX][sizeY];
		this.enemies = new ArrayList<Enemy>();
		
		try {
			while ((line = bufferedReader.readLine()) != null) {
				countX = 0;
				for (char type: line.toCharArray()) {
					this.tiles[countX][countY] = new Tile(countX, countY, tileSize, this, type);
					
					if (type == '0' && this.playerSpawnPoint == '0') {
						this.player = new Player(countX, countY, tileSize, this);
					}
					
					if (type == 'x' && this.playerSpawnPoint == 'x') {
						this.player = new Player(countX, countY, tileSize, this);
					}
					
					if (type == 'e') {
						this.enemies.add(new Enemy(countX, countY, tileSize, this));
					}
					
					countX++;
				}
				countY++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void movePlayer(int x, int y) {		
		if (this.tryToMoveEntity(this.player, x, y)) {
			Tile targetTile = this.tiles[this.player.getX()][this.player.getY()];
			
			if (targetTile.isEntrance()) {
				this.game.previousMap();
			}
			
			if (targetTile.isExit()) {
				this.game.nextMap();
			}
			
			if (targetTile.isEnemy()) {
				this.game.stopGame(false);
			}
			
			this.repaint();
		}
	}
	
	public void moveEnemy(Enemy enemy, int x, int y) {
		if (this.tryToMoveEntity(enemy, x, y)) {
			if (this.player.getX() == enemy.getX() && this.player.getY() == enemy.getY()) {
				this.game.stopGame(false);
			}
		}
	}
	
	public boolean tryToMoveEntity(MoveableEntity moveableEntity, int x, int y) {
		int moveableEntityX = moveableEntity.getX();
		int moveableEntityY = moveableEntity.getY();
		
		if(moveableEntityX == 0 || moveableEntityX == sizeX-1 || moveableEntityY == 0 || moveableEntityY == sizeY-1) {
			return false;
		}
		
		Tile targetTile = this.tiles[moveableEntityX+x][moveableEntityY+y];
		
		return moveableEntity.moveTo(targetTile);
	}
}
