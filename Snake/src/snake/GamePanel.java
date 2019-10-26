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
	
    private final int DELAY = 100;
    
	private SnakeSprite snake;
	private FruitSprite fruit;
	private JLabel scoreLabel;

    private boolean inGame = true;
    private int score;
    private Thread animator;

    public GamePanel() {
    	addKeyListener(this);
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
        setPreferredSize(new Dimension(PLAYABLE_AREA_WIDTH, PLAYABLE_AREA_HEIGHT));
        setLayout(null);
        
        scoreLabel = new JLabel("Score: "+score);
        scoreLabel.setBounds(12, 12, 55, 15);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        add(scoreLabel);
        
        initGame();
    }

    private void initGame() {
    	inGame = true;
    	score = 0;
    	snake = new SnakeSprite();
//    	snake = new KittySnake();
    	fruit = new FruitSprite();
        
    	animator = new Thread(this);
    	animator.start();
    }
    
//    @Override
//    public void addNotify() {
//        super.addNotify();
//
//        animator = new Thread(this);
//        animator.start();
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(inGame)
        	doDrawing(g);
        else {
        	gameOver(g);
        	initGame();
        }
    }
    
    private void doDrawing(Graphics g) {
	    g.drawImage(fruit.getFruitImage(), fruit.getPOS_X(), fruit.getPOS_Y(), this);
	    
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
        animator.stop();
    }

	@Override
	public void run() {
	    long beforeTime, timeDiff, sleep;
	
	    while (inGame) {
	    	beforeTime = System.nanoTime();
	    	snake.move();
	    	if(fruit.checkFruit(snake)) {
	    		score += 1;
	    	}
	    	if(!snake.checkCollision()) {
	    		inGame = false;
	    	}
	        repaint();
	
	        timeDiff = System.nanoTime() - beforeTime;
	        sleep = DELAY - timeDiff / 1000000;
	
	        if (sleep < 0) {
	            sleep = 2;
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
}

