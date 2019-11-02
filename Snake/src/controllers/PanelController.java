package controllers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import views.GameOverPanel;
import views.MainMenu;
import views.SnakeSelection;

@SuppressWarnings("serial")
public class PanelController extends JFrame {
	public static final int SCREEN_WIDTH = 300;
	public static final int SCREEN_HEIGHT = 300;
	
	private GameController game;
	private MainMenu mainMenu;
	private SnakeSelection snakeSelection;
	private GameOverPanel gameOverPanel;
	private JComponent content;
	
	public PanelController() {
		setTitle("Snake");
		setPreferredSize(new Dimension(PanelController.SCREEN_WIDTH, PanelController.SCREEN_HEIGHT));
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
		game = new GameController();
		gameOverPanel = new GameOverPanel(this);
		
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
		content.add(game.getGamePanel());
		game.getGamePanel().requestFocus();
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
					PanelController frame = new PanelController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
