package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton schliessen;
	private JButton Options;
	private JButton Info;
	private JButton exit;
	
	public static void main(String[] args) {
		Frame frame = new Frame("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public Frame (String title){
		super (title);
		
		schliessen = new JButton("Spiel Starten");
		schliessen.setBounds(120,40,160,40);
		schliessen.addActionListener(this);
		add(schliessen);
		
		Options = new JButton("einstellungen");
		Options.setBounds(120,120,160,40);
		Options.addActionListener(this);
		add(Options);
		
		Info = new JButton("Credits");
		Info.setBounds(120,200,160,40);
		Info.addActionListener(this);
		add(Info);
		
		exit = new JButton("Spiel beenden");
		exit.setBounds(120,280,160,40);
		exit.addActionListener(this);
		add(exit);
			
	}

	private void auswahl() {
		// TODO Auto-generated method stub
		
	}

	private void fenster() {
		JFrame fenster = new JFrame();
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(800, 800);
		fenster.setVisible(true);
		fenster.setLayout(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent action) {
		
		if (action.getSource()== schliessen){
			fenster();
		}
		
		if (action.getSource()== Options){
			auswahl();
		}
		
		if (action.getSource()== Info){
			Object[] options = {"ok"};
			
			JOptionPane.showOptionDialog(null, "programmiert von Dee!!","Information",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
		}
		
		if (action.getSource()== exit){
			System.exit(0);
		}
		
	}	
	}
