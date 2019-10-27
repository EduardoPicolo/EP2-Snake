package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {
	public static final int PLAYABLE_AREA_WIDTH = 300;
	public static final int PLAYABLE_AREA_HEIGHT = 300;
	private static boolean inGame;
    private final int DELAY = 100;
    
	private SnakeSprite snake;
	private static List<FruitSprite> fruits;
	
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
        scoreLabel.setBounds(12, 12, 100, 15);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        add(scoreLabel);
        
        initGame();
    }

    private void initGame() {
    	inGame = true;
    	score = 0;
    	snake = new SnakeSprite();
    	fruits = new ArrayList<>();
    	animator = new Thread(this);
    	fruitSpawner = new FruitSpawner();
//    	snake = new KittySnake();
//    	fruit = new FruitSprite();
//    	fruit = new BombFruit();
        
    	animator.start();
    	new Thread(fruitSpawner).start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(inGame)
        	doDrawing(g);
        else {
        	gameOver(g);
        }
    }
    
    private void doDrawing(Graphics g) {
    	for (FruitSprite fruit : fruits) {
    		g.drawImage(fruit.getFruitImage(), fruit.getPOS_X(), fruit.getPOS_Y(), this);
    	}
	    
	    for (int i = 0; i < snake.getBodySize(); i++) {
	        if (i == 0) {
	            g.drawImage(snake.getSnakeHead_Image(), snake.getPOS_X()[i], snake.getPOS_Y()[i], this);
	        } else {
	            g.drawImage(snake.getSnakeBody_Image(), snake.getPOS_X()[i], snake.getPOS_Y()[i], this);
	        }
	    }
	    scoreLabel.setText("Score: "+score);
	    Toolkit.getDefaultToolkit().sync(); 
    }

    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (PLAYABLE_AREA_WIDTH - metr.stringWidth(msg)) / 2, PLAYABLE_AREA_WIDTH / 2);
    }

	@Override
	public void run() {
	    long beforeTime, timeDiff, sleep;
	
	    while (inGame) {
	    	beforeTime = System.nanoTime();
	    	
	    	snake.move();
	    	snake.checkFruitCollision(fruits);
	    	snake.checkCollision();

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

