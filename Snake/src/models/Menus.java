package models;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import controllers.GameController;
import views.MainFrame;

public class Menus {
	private MainFrame frame;
	
	public Menus() {
		this.frame = new MainFrame(this);
		mainMenu();
	}
	
	public void mainMenu() {
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(frame.getMainMenu());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void snakeSelection() {
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(frame.getSnakeSelection());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void gamePanel(int chosenSnake) {
		frame.getGamePanel().removeAll();
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		GameController game = new GameController(frame.getGamePanel(), frame.getGameOverPanel());
		frame.getContentPane().add(frame.getGamePanel());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		game.initGame(chosenSnake);
	}
}
