package models;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import controllers.GameController;
import util.Directions;
import views.GamePanel;
import views.MainFrame;

public abstract class SnakeSprite {
	protected LinkedList<Point> snakeBody;
    
    protected int score_multiplier;
    protected Directions direction;
    
    protected Image snake_head_image;
    protected Image snake_body_image;
    protected int snake_image_width;
    protected int snake_image_height;
    
    public SnakeSprite() {
    	loadImages();
    	setImageDimension();
    	snakeBody = new LinkedList<Point>();
    	snakeBody.add(new Point(169,169));
    	score_multiplier = 1;
//    	direction = Directions.RIGHT;
    }
    
    protected abstract void loadImages();
    
    public void move() {
        Point headPosition = snakeBody.getFirst().getLocation();
        
        if(this.direction == null)
        	return;
        switch(this.direction) {
	        case LEFT:
	        	headPosition.translate(-snake_image_width, 0);
	    	break;
	        case RIGHT:
	        	headPosition.translate(snake_image_width, 0);
        	break;
	        case UP:
	        	headPosition.translate(0, -snake_image_height);
        	break;
	        case DOWN:
	        	headPosition.translate(0, snake_image_height);
        	break;
        	default:
        		break;
        }
        
        snakeBody.removeLast();
        snakeBody.addFirst(headPosition);       
    }
        
    public void checkCollision() {
    	for(int i=1 ; i<this.getBounds().size() ;i++) {
    		if(this.getBounds().get(i).intersects(this.getBounds().get(0))) {
    			GameController.setGameOver();
				return;
			}    		
    	}
    	
    	if(snakeBody.getFirst().getY() >= MainFrame.getFrameHeight() || snakeBody.getFirst().getY() < 20 ||
    			snakeBody.getFirst().getX() >= MainFrame.getFrameWidth() || snakeBody.getFirst().getX() < 0) {
    		GameController.setGameOver();
    	}
    }
    
    public void increaseBody() {
    	snakeBody.addLast(new Point((int)snakeBody.getLast().getX(), (int)snakeBody.getLast().getY()));
    }
    
    public void setDirection(Directions direction) {
    	this.direction = direction;
    }
    
	public void setImageDimension() {
		snake_image_width = snake_head_image.getWidth(null);
		snake_image_height = snake_head_image.getHeight(null);
	}
    
    public Image getSnakeHead_Image() {
    	return snake_head_image;
    }
    
    public Image getSnakeBody_Image() {
    	return snake_body_image;
    }
    
    public int getBodySize() {
    	return snakeBody.size();
    }
    
    public int getScoreMultiplier() {
    	return score_multiplier;
    }
    
    public LinkedList<Point> getSnakeBody(){
    	return snakeBody;
    }
    
    public Point getHeadPosition() {
    	return snakeBody.getFirst().getLocation();
    }
    
    public void setHeadPosition(int X, int Y) {
    	snakeBody.getFirst().setLocation(X, Y);
    }
    
    public List<Rectangle> getBounds() {
    	List<Rectangle> snake_bounds = new ArrayList<>();
    	for(Point point : snakeBody) {
    		snake_bounds.add(new Rectangle((int)point.getX(), (int)point.getY(), snake_image_width, snake_image_height));
    	}
    	return snake_bounds;
    }

}
