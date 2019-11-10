package models;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import controllers.GameController;
import util.Difficulties;
import util.Snakes;
import views.Display;

public class Menus {
	private Display frame;
	
	public Menus() {
		frame = new Display(this);
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
	
	public void gamePanel(Snakes chosenSnake, Difficulties chosenDifficulty) {
		frame.getGamePanel().removeAll();
		frame.getContentPane().removeAll();
		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		GameController game = new GameController(frame.getGamePanel(), frame.getGameOverPanel());
		frame.getContentPane().add(frame.getGamePanel());
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		game.initGame(chosenSnake, chosenDifficulty);
	}
	
	public void clearSelections() {
		frame.getSnakeSelection().clearSelections();
	}
	
	public Display getDisplay() {
		return frame;
	}
}
