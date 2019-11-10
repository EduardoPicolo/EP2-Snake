package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;

import models.Menus;
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
	
	private Menus menu;
	
	public MenuController(Menus menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "PLAY":
				System.out.println("PLAY");
				menu.snakeSelection();
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
				menu.gamePanel(chosenSnake);
			break;
			
			case "MENU":
				System.out.println("MENU");
				menu.mainMenu();
			break;
			case "RESTART":
				System.out.println("RESTART");
				menu.gamePanel(chosenSnake);
			break;
			
			default:
				break;
		}
	}
	
	public int getSelectedSnake() {
		return chosenSnake;
	}
}
