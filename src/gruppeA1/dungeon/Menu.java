package gruppeA1.dungeon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Menu extends JComponent implements ActionListener {
	private static final long serialVersionUID = 1L;

	private List<EventListener> menuListeners = new ArrayList<EventListener>();
	
	private JButton start;
	private JButton restart;
	private JButton quit;
	
	private String state;
		
	public Menu() {
		super();
		
		this.setSize(480, 480);
		
		this.start = new JButton("Start");
		this.start.setBounds(120, 240, 240, 40);
		this.start.addActionListener(this);
		
		this.restart = new JButton("Neustart");
		this.restart.setBounds(120, 240, 240, 40);
		this.restart.addActionListener(this);
		
		this.quit = new JButton("Beenden");
		this.quit.setBounds(120, 300, 240, 40);
		this.quit.addActionListener(this);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Graphics2D graphics2D = (Graphics2D) graphics;

		String message = "";
		
		if (this.state == "win") {
			message = "Gewonnen!";
		}
		
		if (this.state == "lose") {
			message = "Verloren!";
		}
		
		if (message != "") {
			graphics2D.drawString(message, 240-(graphics2D.getFontMetrics().stringWidth(message)/2), 120);
		}
	}
	
	public void setState(String state) {
		this.state = state;
		
		this.remove(this.start);
		this.remove(this.restart);
		this.remove(this.quit);
		
		if (state == "main") {
			this.add(this.start);
			this.add(this.quit);
		}
		
		if (state == "win") {
			Graphics graphics = this.getGraphics();
			
			graphics.drawString("Gewonnen!", 0, 0);
			
			this.add(this.restart);
			this.add(this.quit);
		}
		
		if (state == "lose") {
			Graphics graphics = this.getGraphics();
			
			graphics.drawString("Verloren!", 0, 0);
			
			this.add(this.restart);
			this.add(this.quit);
		}
	}
	
	public void addMenuListener(EventListener eventListener) {
		this.menuListeners.add(eventListener);
	}
	
	public void notifyMenuListeners(Event event) {
		for (EventListener eventListener: this.menuListeners) {
			eventListener.handleMenuEvent(event);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		
		if (source == this.start) {
			this.notifyMenuListeners(new Event("start"));
		}
		if (source == this.restart) {
			this.notifyMenuListeners(new Event("start"));
		}
		if (source == this.quit) {
			this.notifyMenuListeners(new Event("quit"));
		}
	}
}
