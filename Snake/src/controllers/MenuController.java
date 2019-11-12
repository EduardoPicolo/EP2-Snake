package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Menu;
import util.Difficulties;
import util.Snakes;

public class MenuController implements ActionListener{
	private Snakes chosenSnake;
	private Difficulties chosenDifficulty;
	
	private Menu menu;
	
	public MenuController(Menu menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "PLAY":
				System.out.println("PLAY");
				menu.gameOptions();
			break;
			
			case "HELP":
				System.out.println("HELP");
				menu.gameInfo();
			break;
			case "BACK":
				System.out.println("BACK");
				menu.mainMenu();
			break;
			
			case "EXIT":
				System.out.println("EXIT");
				System.exit(0);
			break;
			
			case "CLASSIC":
				System.out.println("CLASSIC");
				if(!(chosenDifficulty == null))
					menu.getDisplay().getSnakeSelection().enableButton();
				chosenSnake = Snakes.CLASSIC;
				menu.getDisplay().getSnakeSelection().setLblImage();
			break;
			
			case "STAR":
				System.out.println("STAR");
				if(!(chosenDifficulty == null))
					menu.getDisplay().getSnakeSelection().enableButton();
				chosenSnake = Snakes.STAR;
				menu.getDisplay().getSnakeSelection().setLblImage();
			break;
			
			case "KITTY":
				System.out.println("KITTY");
				if(!(chosenDifficulty == null))
					menu.getDisplay().getSnakeSelection().enableButton();
				chosenSnake = Snakes.KITTY;
				menu.getDisplay().getSnakeSelection().setLblImage();
			break;
			
			case "CONFIRM":
				System.out.println("CONFIRM: "+chosenSnake+"::"+chosenDifficulty);
				menu.gamePanel(chosenSnake, chosenDifficulty);
			break;
			
			case "MENU":
				System.out.println("MENU");
				chosenSnake = null;
				chosenDifficulty = null;
				menu.clearSelections();
				menu.gameOptions();
				menu.mainMenu();
			break;
			
			case "CHANGE":
				System.out.println("CHANGE");
				chosenSnake = null;
				chosenDifficulty = null;
				menu.clearSelections();
				menu.gameOptions();
			break;
			
			case "RESTART":
				System.out.println("RESTART");
				menu.gamePanel(chosenSnake, chosenDifficulty);
			break;
			
			case "EASY":
				System.out.println("EASY");
				if(!(chosenSnake == null))
					menu.getDisplay().getSnakeSelection().enableButton();
				chosenDifficulty = Difficulties.EASY;
			break;
			case "NORMAL":
				System.out.println("NORMAL");
				if(!(chosenSnake == null))
					menu.getDisplay().getSnakeSelection().enableButton();
				chosenDifficulty = Difficulties.NORMAL;
			break;
			case "HARD":
				System.out.println("HARD");
				if(!(chosenSnake == null))
					menu.getDisplay().getSnakeSelection().enableButton();
				chosenDifficulty = Difficulties.HARD;
			break;
			case "INSANE":
				System.out.println("INSANE");
				if(!(chosenSnake == null))
					menu.getDisplay().getSnakeSelection().enableButton();
				chosenDifficulty = Difficulties.INSANE;
			break;
			
			default:
				break;
		}
	}
}
