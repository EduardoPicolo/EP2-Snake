package models;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ConcurrentModificationException;
import java.util.Random;

import controllers.GameEngine;
import views.Display;

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
    	Point[] p = {new Point(0,0)};
    	boolean occupiedPos = false;
    	do {
    		X = randomInt.nextInt((int)(Display.getFrameWidth()/image_width))*image_width;
    		Y = randomInt.nextInt((int)((Display.getFrameHeight()-26)/image_height))*image_height;
    		Y += 26;
    		p[0] = new Point(X,Y);
    		try {
	    		if(GameEngine.getOccupiedPositions().stream()
    				.anyMatch(rect -> rect.intersects(new Rectangle((int)p[0].getX(), (int)p[0].getY(), image_width, image_height))))
	    			occupiedPos = true;
	    		else 
	    			occupiedPos = false;
    		}catch(ConcurrentModificationException e) {
    			System.out.println("Concurrent Modification, ignore.");
    			continue;
    		}
    	}while(occupiedPos);
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
