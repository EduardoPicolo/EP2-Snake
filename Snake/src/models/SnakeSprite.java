package models;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import util.Directions;
import views.Display;

public abstract class SnakeSprite {
	protected LinkedList<Point> body;
    
    protected int score_multiplier;
    protected Directions direction;
    
    protected BufferedImage head_image;
    protected BufferedImage body_image;
    protected int snake_width;
    protected int snake_height;
    
    public SnakeSprite() {
    	loadImages();
    	body = new LinkedList<Point>();
    	body.add(new Point(182, 195));
//    	direction = Directions.RIGHT;
    }
    
    protected abstract void loadImages();
    
    public void move() {
        Point headPosition = body.getFirst().getLocation();
        
        if(this.direction == null)
        	return;
        switch(this.direction) {
	        case LEFT:
	        	headPosition.translate(-snake_width, 0);
	    	break;
	        case RIGHT:
	        	headPosition.translate(snake_width, 0);
        	break;
	        case UP:
	        	headPosition.translate(0, -snake_height);
        	break;
	        case DOWN:
	        	headPosition.translate(0, snake_height);
        	break;
        	default:
        		break;
        }
        
        body.removeLast();
        body.addFirst(headPosition);       
    }
        
    public boolean checkCollision() {
    	for(int i=1 ; i<this.getBounds().size() ;i++) {
    		if(this.getBounds().get(i).intersects(this.getBounds().get(0))) {
				return true;
			}    		
    	}
    	
    	if(body.getFirst().getY() >= Display.getFrameHeight() || body.getFirst().getY() < 20 ||
    			body.getFirst().getX() >= Display.getFrameWidth() || body.getFirst().getX() < 0) {
    		return true;
    	}
    	return false;
    }
    
    public void increaseBody() {
    	body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
    }
    
    public void setDirection(Directions direction) {
    	this.direction = direction;
    }
    
	public void setDimensions() {
		snake_width = head_image.getWidth();
		snake_height = head_image.getHeight();
	}
    
    public BufferedImage getHeadImage() {
    	return head_image;
    }
    
    public BufferedImage getBodyImage() {
    	return body_image;
    }
    
    public int getBodySize() {
    	return body.size();
    }
    
    public int getScoreMultiplier() {
    	return score_multiplier;
    }
    
    public LinkedList<Point> getSnakeBody(){
    	return body;
    }
    
    public Point getHeadPosition() {
    	return body.getFirst().getLocation();
    }
    
    public void setHeadPosition(int X, int Y) {
    	body.getFirst().setLocation(X, Y);
    }
    
    public List<Rectangle> getBounds() {
    	List<Rectangle> bounds = new ArrayList<Rectangle>();
    	for(Point point : body) {
    		bounds.add(new Rectangle((int)point.getX(), (int)point.getY(), snake_width, snake_height));
    	}
    	return bounds;
    }

}
