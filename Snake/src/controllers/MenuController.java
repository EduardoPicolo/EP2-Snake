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
	private int selectedSnake;
	
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
		selectedSnake = CLASSIC;
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
		game.initGame(selectedSnake);
	}

	public void gameOver() {
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		frame.getContentPane().add(frame.getGameOverPanel());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
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
				selectedSnake = CLASSIC;
			break;
			
			case "STAR":
				System.out.println("STAR");
				selectedSnake = STAR;
			break;
			
			case "KITTY":
				System.out.println("KITTY");
				selectedSnake = KITTY;
			break;
			
			case "CONFIRM":
				System.out.println("CONFIRM: "+selectedSnake);
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
		return selectedSnake;
	}
}
