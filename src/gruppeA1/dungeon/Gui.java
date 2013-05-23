package gruppeA1.dungeon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gui extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
		Image img;
		Timer maintimer;
		Player player;
	
	public Gui() {
		setFocusable(true);
		player = new Player(1,45);
		addKeyListener(new KeyAdapt(player));
		
		maintimer = new Timer(10,this);
		maintimer.start();
		
		ImageIcon u = new ImageIcon("res/labyrinth1.png");
		img = u.getImage();

		}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D f2 = (Graphics2D)g;
		
		f2.drawImage(img,0,0,null);
		
		player.draw(f2);
		Enemy e = new Enemy(320,315);
		e.draw(f2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		player.update();
		repaint();
		
	}
}
