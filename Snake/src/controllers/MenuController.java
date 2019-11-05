package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

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
	private MainMenu mainMenu;
	private SnakeSelection snakeSelection;
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;
	
	public MenuController() {
		frame = new MainFrame();
		mainMenu = new MainMenu(this);
		snakeSelection = new SnakeSelection(this);
		gamePanel = new GamePanel();
		gameOverPanel = new GameOverPanel(this);
		mainMenu();
	}
	
	public void mainMenu() {
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(mainMenu);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void snakeSelection() {
		selectedSnake = CLASSIC;
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(snakeSelection);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void startGame() {
		gamePanel.removeAll();
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		GameController game = new GameController(gamePanel, gameOverPanel);
		frame.getContentPane().add(gamePanel);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		game.initGame(selectedSnake);
	}

	public void gameOver() {
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		frame.getContentPane().add(gameOverPanel);
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
