package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;

import views.GameHeader;
import views.GameOverPanel;
import views.GamePanel;
import views.MainFrame;
import views.MainMenu;
import views.SnakeSelection;

public class MenuController implements ActionListener{
	private final int CLASSIC = 1;
	private final int STAR = 2;
	private final int KITTY = 3;
	private int chosenSnake;
	
	private MainFrame frame;
	
	public MenuController(MainFrame frame) {
		this.frame = frame;
	}
	
	public void mainMenu() {
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(frame.getMainMenu());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void snakeSelection() {
		chosenSnake = CLASSIC;
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(frame.getSnakeSelection());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void startGame() {
		frame.getGamePanel().removeAll();
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		GameController game = new GameController(frame.getGamePanel(), frame.getGameOverPanel());
		frame.getContentPane().add(frame.getGamePanel());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		game.initGame(chosenSnake);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "PLAY":
				System.out.println("PLAY");
				snakeSelection();
			break;
			case "EXIT":
				System.out.println("EXIT");
				System.exit(0);
			break;
			
			case "CLASSIC":
				System.out.println("CLASSIC");
				chosenSnake = CLASSIC;
			break;
			
			case "STAR":
				System.out.println("STAR");
				chosenSnake = STAR;
			break;
			
			case "KITTY":
				System.out.println("KITTY");
				chosenSnake = KITTY;
			break;
			
			case "CONFIRM":
				System.out.println("CONFIRM: "+chosenSnake);
				startGame();
			break;
			
			case "MENU":
				System.out.println("MENU");
				mainMenu();
			break;
			case "RESTART":
				System.out.println("RESTART");
				startGame();
			break;
			
			default:
				break;
		}
	}
	
	public int getSelectedSnake() {
		return chosenSnake;
	}
}
