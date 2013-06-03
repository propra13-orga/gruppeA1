package gruppeA1.dungeon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton start;
	/*private JButton settings;
	private JButton info;*/
	private JButton quit;
	
	public static void main(String[] args) {
		Main frame = new Main("Dungeon Crawler Deluxe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480,480);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public Main(String title) {
		super(title);
		
		start = new JButton("Spiel Starten");
		start.setBounds(40,380,160,40);
		start.addActionListener(this);
		add(start);
		
		/*settings = new JButton("Optionen");
		settings.setBounds(120,90,160,40);
		settings.addActionListener(this);
		add(settings);*/
		
		/*info = new JButton("Credits");
		info.setBounds(120,140,160,40);
		info.addActionListener(this);
		add(info);*/
		
		quit = new JButton("Spiel verlassen");
		quit.setBounds(280,380,160,40);
		quit.addActionListener(this);
		add(quit);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			startMap();
		}
		/*else if(e.getSource() == info) {
			Object[] options = {"OK"};
			
			JOptionPane.showOptionDialog(null, "Das Spiel wurde programmiert von Mir und ich hab auch etwas gemacht! hihi :D!", "Credits", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}*/
		/*else if(e.getSource() == einstellungen){
							auswahl();
		}*/
		else if(e.getSource() == quit) {
			System.exit(0);
		}
	}
	
	public static void startMap() {
		JFrame map = new JFrame("Dungeon Crawler Deluxe");
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setSize(480,500);
		map.setVisible(true);
		map.add(new Map(1));
	}
	
	/*public static void auswahl() {
		JFrame auswahl = new JFrame("Einstellungen");
		auswahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		auswahl.setSize(400,400);
		auswahl.setVisible(true);
	}*/
}