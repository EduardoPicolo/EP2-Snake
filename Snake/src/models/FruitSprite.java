package models;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import controllers.GameController;
import views.GamePanel;
import views.MainFrame;

public abstract class FruitSprite implements SpecialSkill{
	protected Point position;
	protected int scoreValue;
	
	protected Image image;
	protected int image_width;
	protected int image_height;
	
	public FruitSprite() {
		scoreValue = 1;
		position = new Point();
		loadImage();
		setDimension();
		generateLocation();
	}
	
	protected abstract void loadImage();
	
	protected void setDimension() {
		image_width = image.getWidth(null);
		image_height = image.getHeight(null);
	}
	
    public void generateLocation() {
    	Random randomInt = new Random();
    	int X,Y;
    	Point p;
    	do {
    		X = randomInt.nextInt((int)(MainFrame.getFrameWidth()/image_width))*image_width;
    		Y = randomInt.nextInt((int)((MainFrame.getFrameHeight()-26)/image_height))*image_height;
    		Y += 26;
    		p = new Point(X,Y);
    	}while(GameController.getOccupiedPositions().contains(p.getLocation()));
    	position.setLocation(X,Y);
    }
    
    public Point getPosition() {
    	return position;
    }
        
    public int getScoreValue() {
    	return scoreValue;
    }
    
    public Image getFruitImage() {
    	return image;
    }
    
    public int getPOS_X() {
    	return (int)position.getX();
    }
    
    public int getPOS_Y() {
    	return (int)position.getY();
    }
    
    public Rectangle getBounds() {
    	return new Rectangle((int)position.getX(), (int)position.getY(), image_width, image_height);
    }
	
}
