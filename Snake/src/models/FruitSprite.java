package models;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import controllers.GameController;
import views.GamePanel;
import views.MainFrame;

public abstract class FruitSprite {
	protected Point position;
	protected int scoreValue;
	
	protected Image fruit_image;
	protected int fruit_image_width;
	protected int fruit_image_height;
	
	public FruitSprite() {
		scoreValue = 1;
		position = new Point();
		loadImage();
		setDimension();
		generateLocation();
	}
	
	protected abstract void loadImage();
	
	protected void setDimension() {
		fruit_image_width = fruit_image.getWidth(null);
		fruit_image_height = fruit_image.getHeight(null);
	}
	
    public void generateLocation() {
    	Random randomInt = new Random();
    	int X,Y;
    	Point p;
    	do {
    		X = randomInt.nextInt((int)(MainFrame.getFrameWidth()/fruit_image_width))*fruit_image_width;
    		Y = randomInt.nextInt((int)((MainFrame.getFrameHeight()-20)/fruit_image_height))*fruit_image_height;
    		Y += 20;
    		p = new Point(X,Y);
    	}while(GameController.getOccupiedPositions().contains(p));
    	position.setLocation(X,Y);
    }
    
    public Point getPosition() {
    	return position;
    }
        
    public int getScoreValue() {
    	return scoreValue;
    }
    
    public Image getFruitImage() {
    	return fruit_image;
    }
    
    public int getPOS_X() {
    	return (int)position.getX();
    }
    
    public int getPOS_Y() {
    	return (int)position.getY();
    }
    
    public Rectangle getBounds() {
    	return new Rectangle((int)position.getX(), (int)position.getY(), fruit_image_width, fruit_image_height);
    }
    
    public abstract void specialEffect(SnakeSprite snake);
	
}
