package snake;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class FruitSprite {
	protected int POS_X;
	protected int POS_Y;
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
	
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("apple.png");
        fruit_image = iia.getImage();
	}
	
	protected void setDimension() {
		fruit_image_width = fruit_image.getWidth(null);
		fruit_image_height = fruit_image.getHeight(null);
	}
	
    public void generateLocation() {
    	Random randomInt = new Random();
//    	POS_X = randomInt.nextInt(GamePanel.PLAYABLE_AREA_WIDTH-fruit_image_width);
//    	POS_Y = randomInt.nextInt(GamePanel.PLAYABLE_AREA_HEIGHT-fruit_image_height);
    	
    	int X = randomInt.nextInt(GamePanel.PLAYABLE_AREA_WIDTH/fruit_image_width)*fruit_image_width;
    	int Y = randomInt.nextInt(GamePanel.PLAYABLE_AREA_HEIGHT/fruit_image_height)*fruit_image_height;
    	position.setLocation(X,Y);
    	
//    	POS_X = POS_X - (POS_X % fruit_image_width);
//    	POS_Y = POS_Y - (POS_Y % fruit_image_height);
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
    	return POS_X;
    }
    
    public int getPOS_Y() {
    	return POS_Y;
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(POS_X, POS_Y, fruit_image_width, fruit_image_height);
    }
	
}
