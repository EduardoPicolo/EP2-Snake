package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JPanel;
import controllers.GameController;
import models.FruitSprite;
import models.SnakeSprite;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
    private Graphics2D g2d;
    
	private SnakeSprite snake;
	private List<FruitSprite> fruits;
	private List<Rectangle> obstacles;
	
	private GameHeader header;
	
    public GamePanel() {
    	header = new GameHeader();
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(Display.getFrameWidth(), Display.getFrameHeight()));
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
        
        try {
        	if(GameController.isRunning()) {
        		doDrawing(g2d);
        	}
        	else {
        		System.out.println("GAMEOVER");
        	}
        }catch(NullPointerException e) {
        	System.out.println("Failed to load/draw image!");
        	e.printStackTrace();
        }
        
    }
    
    private void doDrawing(Graphics2D g) {
    	g2d.setColor(Color.YELLOW);
    	for(Rectangle r : obstacles) {
    		g2d.fill(r);
    	}
    	
    	if(!fruits.isEmpty()) {
	    	for(int i=0; i<fruits.size(); i++) {
	    		g.drawImage(fruits.get(i).getFruitImage(), (int)fruits.get(i).getPosition().getX(), (int)fruits.get(i).getPosition().getY(), this);
	    	}
    	}
    	
    	g.drawImage(snake.getHeadImage(), (int)snake.getSnakeBody().getFirst().getX(), (int)snake.getSnakeBody().getFirst().getY(), this);
    	for(int i=1; i<snake.getBodySize(); i++ ) {
    		g.drawImage(snake.getBodyImage(), (int) snake.getSnakeBody().get(i).getX(), (int) snake.getSnakeBody().get(i).getY(), this);
    	}
	    
	    Toolkit.getDefaultToolkit().sync(); 
    }
	
	public void setSnake(SnakeSprite snake) {
		this.snake = snake;
	}
	public void setFruits(List<FruitSprite> fruitList) {
		fruits = fruitList;
	}
	public void setObstacles(List<Rectangle> obstacles) {
		this.obstacles = obstacles;
	}
	
	public void updateHeader(int score, long time) {
		header.updateHeader(score, time);
	}
	
	public void setHeaderDifficulty(String difficulty) {
		header.setLblDifficulty(difficulty);
	}
	
}

