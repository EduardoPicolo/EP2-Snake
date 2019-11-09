package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.GameController;
import models.FruitSprite;
import models.SnakeSprite;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
    private Graphics2D g2d;
    
	private SnakeSprite snake;
	private List<FruitSprite> fruits;
	
	private int score;
	
	private GameHeader header;
	
    public GamePanel() {
    	header = new GameHeader();
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(MainFrame.getFrameWidth(), MainFrame.getFrameHeight()));
        setLayout(new BorderLayout());
//	    add(header, BorderLayout.PAGE_START);
    }
    
    @Override
    public void addNotify() {
    	super.addNotify();
    	add(header, BorderLayout.PAGE_START);
    	requestFocus();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(GameController.isRunning()) {
        	doDrawing(g2d);
        }
        else {
        	System.out.println("GAMEOVER");
        }
    }
    
    private void doDrawing(Graphics2D g) {
    	g2d.setColor(Color.YELLOW);
    	g2d.fillRect(247, 143, 13, 39);
    	g2d.fillRect(208, 130, 52, 13);
    	
    	g2d.fillRect(130, 208, 13, 39);
    	g2d.fillRect(130, 247, 52, 13);
    	
    	if(!fruits.isEmpty()) {
	    	for(int i=0; i<fruits.size(); i++) {
	    		g.drawImage(fruits.get(i).getFruitImage(), (int)fruits.get(i).getPosition().getX(), (int)fruits.get(i).getPosition().getY(), this);
	    	}
    	}
    	
    	g.drawImage(snake.getSnakeHead_Image(), (int)snake.getSnakeBody().getFirst().getX(), (int)snake.getSnakeBody().getFirst().getY(), this);
    	for(int i=1; i<snake.getBodySize(); i++ ) {
    		g.drawImage(snake.getSnakeBody_Image(), (int) snake.getSnakeBody().get(i).getX(), (int) snake.getSnakeBody().get(i).getY(), this);
    	}
	    
    	
    	header.updateLabel(score);
	    Toolkit.getDefaultToolkit().sync(); 
    }
	
	public void setSnake(SnakeSprite snake) {
		this.snake = snake;
	}
	public void setFruits(List<FruitSprite> fruitList) {
		fruits = fruitList;
	}
	
	public void updateScore(int score) {
		this.score = score;
	}
	
}

