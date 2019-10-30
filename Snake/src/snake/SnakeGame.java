package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SnakeGame extends JFrame {
	public static final int SCREEN_WIDTH = 300;
	public static final int SCREEN_HEIGHT = 300;
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;
	private JPanel content;
	
	public SnakeGame() {
		setTitle("Snake");
		setPreferredSize(new Dimension(SnakeGame.SCREEN_WIDTH, SnakeGame.SCREEN_HEIGHT));
		setBackground(Color.black);
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(Color.BLACK);
		setContentPane(content);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gamePanel = new GamePanel(this);
		gameOverPanel = new GameOverPanel(this);
		
		mainMenu();
	}
	
	public void mainMenu() {
		
		
		startGame();
	}
	
	public void startGame() {
		content.removeAll();
		content.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		content.add(gamePanel);
	}

	public void gameOver() {
		content.removeAll();
		content.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		content.add(gameOverPanel);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeGame frame = new SnakeGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
