package views;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.MenuController;
import models.Menus;

@SuppressWarnings("serial")
public class Display extends JFrame {
	private static final int SCREEN_WIDTH = 377;
	private static final int SCREEN_HEIGHT = 377;
	
	private MenuController controller;
	private MainMenu mainMenu;
	private SnakeSelection snakeSelection;
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;
	private JComponent content;
		
	public Display(Menus menu) {
		initFrame();
		controller = new MenuController(menu);
		mainMenu = new MainMenu(controller);
		snakeSelection = new SnakeSelection(controller);
		gamePanel = new GamePanel();
		gameOverPanel = new GameOverPanel(controller);
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
	public SnakeSelection getSnakeSelection() {
		return snakeSelection;
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	public GameOverPanel getGameOverPanel() {
		return gameOverPanel;
	}

}
