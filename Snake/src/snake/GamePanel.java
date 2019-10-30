package snake;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {
	public static final int PLAYABLE_AREA_WIDTH = 300;
	public static final int PLAYABLE_AREA_HEIGHT = 300;
	private static boolean inGame;
    private final int DELAY = 100;
    private Graphics2D g2d;
    
	private SnakeSprite snake;
	private static List<FruitSprite> fruits;
	private GameOverPanel gameOverPanel;
	
	private static int score;
	private JLabel scoreLabel;

    private Thread animator;
    private FruitSpawner fruitSpawner;

    public GamePanel() {
    	addKeyListener(this);
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
        setPreferredSize(new Dimension(PLAYABLE_AREA_WIDTH, PLAYABLE_AREA_HEIGHT));
        setLayout(null);
        
        scoreLabel = new JLabel("Score: "+score);
        scoreLabel.setBounds(113, 5, 73, 15);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
//        add(scoreLabel);
                
        gameOverPanel = new GameOverPanel(this);
        
        initGame();
    }

    public void initGame() {
    	inGame = true;
    	score = 0;
    	snake = new SnakeSprite();
    	fruits = new ArrayList<>();
    	animator = new Thread(this);
    	fruitSpawner = new FruitSpawner();
    	add(scoreLabel);
    	scoreLabel.setVisible(true);
//    	snake = new KittySnake();
//    	fruit = new FruitSprite();
//    	fruit = new BombFruit();
        
    	animator.start();
    	new Thread(fruitSpawner).start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(inGame)
        	doDrawing();
        else {
        	gameOver();
        }
    }
    
    private void doDrawing() {
    	
    	for (FruitSprite fruit : fruits) {
    		g2d.drawImage(fruit.getFruitImage(), (int)fruit.getPosition().getX(), (int)fruit.getPosition().getY(), null);
    	}
	    
    	for(Point point : snake.getSnakeBody()) {
    		if(point == snake.getSnakeBody().getFirst()) {
    			g2d.drawImage(snake.getSnakeHead_Image(), (int) point.getX(), (int) point.getY(), null);
    		}
    		else {
    			g2d.drawImage(snake.getSnakeBody_Image(), (int) point.getX(), (int) point.getY(), null);
    		}
    	}
//		g2d.drawImage(snake.getSnakeHead_Image(), (int) snake.getSnakeBody().getFirst().getX(), (int) snake.getSnakeBody().getFirst().getY(), null);
//    	g2d.drawImage(snake.getSnakeBody_Image(), (int) snake.getSnakeBody().getLast().getX(), (int) snake.getSnakeBody().getLast().getY(), null);

    	scoreLabel.setText("Score: "+score);
	    Toolkit.getDefaultToolkit().sync(); 
    }

    private void gameOver() {
    	scoreLabel.setVisible(false);
    	remove(scoreLabel);
    	add(gameOverPanel);
    	gameOverPanel.setBounds( 25, 50, gameOverPanel.getWidth(), gameOverPanel.getHeight());
    }

	@Override
	public void run() {
	    long beforeTime, timeDiff, sleep;
	
	    while (inGame) {
	    	beforeTime = System.nanoTime();
	    	
	    	snake.move();
	    	snake.checkCollision();
	    	snake.checkFruitCollision(fruits);
//	    	snake.checkCollision();
	        repaint();
	
	        timeDiff = System.nanoTime() - beforeTime;
	        sleep = DELAY - timeDiff;
	
	        if (sleep < 0) {
	            sleep = 100;
	        }
	
	        try {
	            Thread.sleep(sleep);
	        } catch (InterruptedException e) {
	            String msg = String.format("Thread interrupted: %s", e.getMessage());
	            JOptionPane.showMessageDialog(this, msg, "Error", 
	                    JOptionPane.ERROR_MESSAGE);
            	}
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		snake.setDirection(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public SnakeSprite getSnake() {
		return snake;
	}
	
	public static void setScore(int value) {
		score += value;
	}
	public static int getScore(){
		return score;
	}
	
	public static void setInGame(boolean value) {
		inGame = value;
	}
	public static boolean getInGame() {
		return inGame;
	}
	
	public static void setFruits(List<FruitSprite> fruitList) {
		fruits = fruitList;
	}
	
}

