package models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GameController;
import views.GameOverPanel;
import views.GamePanel;
import views.MainMenu;
import views.SnakeSelection;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public static final int SCREEN_WIDTH = 300;
	public static final int SCREEN_HEIGHT = 300;
	
	private GameController game;
	private MainMenu mainMenu;
	private SnakeSelection snakeSelection;
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;
	private JComponent content;
		
	public MainFrame() {
		setTitle("Snake");
		setPreferredSize(new Dimension(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT));
		setBackground(Color.black);
		content = new JPanel();
		content.setOpaque(true);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(Color.BLACK);
		setContentPane(content);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mainMenu = new MainMenu(this);
		snakeSelection = new SnakeSelection(this);
		gamePanel = new GamePanel(this);
		gameOverPanel = new GameOverPanel(this);
		game = new GameController(gamePanel);
		
		mainMenu();
	}
	
	public void mainMenu() {
		content.removeAll();
		content.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		content.add(mainMenu);
		content.validate();
		content.repaint();
	}
	
	public void snakeSelection() {
		content.removeAll();
		content.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		content.add(snakeSelection);
		content.validate();
		content.repaint();
	}
	
	public void startGame() {
		content.removeAll();
		content.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		game.initGame();
		content.add(gamePanel);
		content.validate();
		content.repaint();
	}

	public void gameOver() {
		content.removeAll();
		content.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		content.add(gameOverPanel);
		content.validate();
		content.repaint();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
