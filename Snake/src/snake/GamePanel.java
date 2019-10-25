package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {
    private final int DELAY = 100;
    
	private SnakeSprite snake;
	private FruitSprite fruit;

    private boolean inGame = true;

    private Thread animator;

    public GamePanel() {
        initGame();
    }

    private void initGame() {
    	inGame = true;
    	snake = new SnakeSprite();
    	fruit = new FruitSprite();
    	addKeyListener(this);
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT));
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
	
	    Toolkit.getDefaultToolkit().sync(); 
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (Main.SCREEN_WIDTH - metr.stringWidth(msg)) / 2, Main.SCREEN_HEIGHT / 2);
        animator.stop();
    }

	@Override
	public void run() {
	    long beforeTime, timeDiff, sleep;
	
	    while (inGame) {
	    	beforeTime = System.currentTimeMillis();
	    	snake.move();
	    	fruit.checkFruit(snake);
	    	if(!snake.checkCollision()) {
	    		inGame = false;
	    	}
	        repaint();
	
	        timeDiff = System.currentTimeMillis() - beforeTime;
	        sleep = DELAY - timeDiff;
	
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
//        	beforeTime = System.currentTimeMillis();
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

