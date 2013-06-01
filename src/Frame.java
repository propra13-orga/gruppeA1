//package testing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton schliessen;
	private static JButton einstellungen;
	private JButton info;
	private JButton exit;
	
	
	public static void main(String[] args) {
		
		Frame frame = new Frame("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);

	}
			public  Frame(String title){ 
					super(title);
		
						schliessen = new JButton("Spiel Starten");
						schliessen.setBounds(120,40,160,40);
						schliessen.addActionListener(this);
						add(schliessen);
		
						einstellungen = new JButton("Optionen");
						einstellungen.setBounds(120,90,160,40);
						einstellungen.addActionListener(this);
						add(einstellungen);
		
						info = new JButton("Credits");
						info.setBounds(120,140,160,40);
						info.addActionListener(this);
						add(info);
		
						exit = new JButton("Spiel verlassen");
						exit.addActionListener(this);
						exit.setBounds(120,190,160,40);
						add(exit);
		
		
			}
			public void actionPerformed(ActionEvent e){
							
						if(e.getSource() == schliessen){
								fenster();
						}
						if(e.getSource() == info){
							Object[] options = {"OK"};
							
							JOptionPane.showOptionDialog(null,"Das Spiel wurde von Dorine Simiyu, Tim Wachsener, Alexander Schmelter, Alida Wolner und Alexandra Karina programmiert!!","Credits",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
						}
						if(e.getSource() == einstellungen){
							auswahl();
							
						}
						if(e.getSource() == exit){
							System.exit(0);
						}
				}
				public static void fenster(){
								JFrame fenster = new JFrame("Dungeon Crawler Deluxe");
								fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								fenster.setSize(1000,675);
								fenster.setVisible(true);
								fenster.add(new Gui());
				}
				public static void auswahl(){
								
								JFrame auswahl = new JFrame("Einstellungen");
								auswahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								auswahl.setSize(400,400);
								auswahl.setVisible(true);
				}
}
