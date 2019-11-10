package models;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import controllers.GameController;
import util.Difficulties;
import util.Snakes;
import views.Display;

public class Menus {
	private Display display;
	
	public Menus() {
		display = new Display(this);
		mainMenu();
	}
	
	public void mainMenu() {
		display.getContentPane().removeAll();
		((JComponent)display.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		display.getContentPane().add(display.getMainMenu());
		display.getContentPane().validate();
		display.getContentPane().repaint();
	}
	
	public void snakeSelection() {
		display.getContentPane().removeAll();
		((JComponent)display.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		display.getContentPane().add(display.getSnakeSelection());
		display.getContentPane().validate();
		display.getContentPane().repaint();
	}
	
	public void gamePanel(Snakes chosenSnake, Difficulties chosenDifficulty) {
		display.getGamePanel().removeAll();
		display.getContentPane().removeAll();
		((JComponent)display.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		GameController game = new GameController(display.getGamePanel(), display.getGameOverPanel());
		display.getContentPane().add(display.getGamePanel());
		display.getContentPane().validate();
		display.getContentPane().repaint();
		game.setDifficulty(chosenDifficulty);
		game.initGame(chosenSnake);
	}
	
	public void clearSelections() {
		display.getSnakeSelection().clearSelections();
	}
	
	public Display getDisplay() {
		return display;
	}
}
