package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GameController;
import controllers.MenuController;
import models.Menu;

@SuppressWarnings("serial")
public class Display extends JFrame {
	private static final int SCREEN_WIDTH = 377;
	private static final int SCREEN_HEIGHT = 377;
	
	private Menu menu;
	private MenuController menuController;
	private GameController gameController;
	private MainMenu mainMenu;
	private GameInfo gameInfo;
	private GameOptions gameOptions;
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;
	private JComponent content;
		
	public Display() {
		initFrame();
		menu = new Menu(this);
		menuController = new MenuController(menu);
		mainMenu = new MainMenu(menuController);
		gameInfo = new GameInfo(menuController);
		gameOptions = new GameOptions(menuController);
		gamePanel = new GamePanel();
		gameOverPanel = new GameOverPanel(menuController);
		gameController = new GameController(gamePanel, gameOverPanel);
		menu.mainMenu();
	}
	private void initFrame() {
		setTitle("Snake");
		setPreferredSize(new Dimension(Display.SCREEN_WIDTH, Display.SCREEN_HEIGHT));
		setBackground(Color.black);
		content = new JPanel();
		content.setOpaque(true);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		setContentPane(content);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static int getFrameWidth() {
		return SCREEN_WIDTH;
	}
	
	public static int getFrameHeight() {
		return SCREEN_HEIGHT;
	}
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public GameInfo getGameInfo() {
		return gameInfo;
	}
	public GameOptions getSnakeSelection() {
		return gameOptions;
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	public GameOverPanel getGameOverPanel() {
		return gameOverPanel;
	}
	public GameController getGameController() {
		return gameController;
	}
	public MenuController getMenuController() {
		return menuController;
	}

}
