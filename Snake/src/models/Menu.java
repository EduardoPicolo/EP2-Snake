package models;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import util.Difficulties;
import util.Snakes;
import views.Display;

public class Menu {
	private Display display;
	
	public Menu(Display display) {
		this.display = display;
	}
	
	public void mainMenu() {
		display.getContentPane().removeAll();
		((JComponent)display.getContentPane()).setBorder(BorderFactory.createStrokeBorder(new BasicStroke(0.75f), Color.white));
		display.getContentPane().add(display.getMainMenu());
		display.getContentPane().validate();
		display.getContentPane().repaint();
	}
	
	public void snakeSelection() {
		display.getContentPane().removeAll();
		((JComponent)display.getContentPane()).setBorder(BorderFactory.createStrokeBorder(new BasicStroke(0.75f), Color.white));
		display.getContentPane().add(display.getSnakeSelection());
		display.getContentPane().validate();
		display.getContentPane().repaint();
	}
	
	public void gamePanel(Snakes chosenSnake, Difficulties chosenDifficulty) {
		display.getGamePanel().removeAll();
		display.getContentPane().removeAll();
		((JComponent)display.getContentPane()).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		display.getGameController().setDifficulty(chosenDifficulty);
		display.getGameController().initGame(chosenSnake);
		display.getContentPane().add(display.getGamePanel());
		display.getContentPane().validate();
		display.getContentPane().repaint();
	}
	
	public void gameInfo() {
		display.getContentPane().removeAll();
		((JComponent)display.getContentPane()).setBorder(BorderFactory.createStrokeBorder(new BasicStroke(0.75f), Color.white));
		display.getContentPane().add(display.getGameInfo());
		display.getContentPane().validate();
		display.getContentPane().repaint();
	}
	
	public void clearSelections() {
		display.getSnakeSelection().clearSelections();
	}
	
	public Display getDisplay() {
		return display;
	}
}
