package gruppeA1.dungeon;

import javax.swing.*;

public class Main extends JFrame implements EventListener {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	private Menu menu;
	
	private GameKeyAdapter gameKeyAdapter;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		super("Dungeon Crawler Deluxe");
		
		this.game = new Game();
		this.menu = new Menu();
		
		this.gameKeyAdapter = new GameKeyAdapter(this.game);
		
		this.game.addGameListener(this);
		this.menu.addMenuListener(this);
		
		this.menu.setState("main");
		
		this.game.setVisible(false);
		this.menu.setVisible(true);
		
		this.add(this.game);
		this.add(this.menu);
		
		this.setSize(480, 500);
		this.setVisible(true);
		this.setFocusable(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void handleMenuEvent(Event event) {
		String type = event.getType();
		
		if (type == "start") {
			this.game.startGame();
		}
		
		if (type == "quit") {
			System.exit(0);
		}
	}

	@Override
	public void handleGameEvent(Event event) {
		String type = event.getType();
		
		if (type == "go") {
			this.addKeyListener(this.gameKeyAdapter);
			
			this.game.setVisible(true);
			
			this.menu.setVisible(false);
		}
		
		if (type == "win") {
			this.removeKeyListener(this.gameKeyAdapter);
			
			this.game.setVisible(false);
			
			this.menu.setState("win");
			this.menu.setVisible(true);
		}
		
		if (type == "lose") {
			this.removeKeyListener(this.gameKeyAdapter);
			
			this.game.setVisible(false);
			
			this.menu.setState("lose");
			this.menu.setVisible(true);
		}
	}
}