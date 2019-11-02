package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.GameController;
import models.FruitSprite;
import models.SnakeSprite;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	public static final int PLAYABLE_AREA_WIDTH = 300;
	public static final int PLAYABLE_AREA_HEIGHT = 300;
    private Graphics2D g2d;
    
	private SnakeSprite snake;
	private static List<FruitSprite> fruits;
	
	private int score;
	private JLabel scoreLabel;

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(PLAYABLE_AREA_WIDTH, PLAYABLE_AREA_HEIGHT));
        setLayout(null);
        
        scoreLabel = new JLabel("Score: "+score);
        scoreLabel.setBounds(113, 5, 73, 15);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        add(scoreLabel);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(GameController.isRunning()) {
        	doDrawing();
        }
        else {
//        	gameOver();
        	System.out.println("GAMEOVER");
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

    	scoreLabel.setText("Score: "+score);
	    Toolkit.getDefaultToolkit().sync(); 
    }

	public SnakeSprite getSnake() {
		return snake;
	}
	
	public void setSnake(SnakeSprite snake) {
		this.snake = snake;
	}
	
	public void setScore(int value) {
		score += value;
	}
	
	public void setFruits(List<FruitSprite> fruitList) {
		fruits = fruitList;
	}
	
}

