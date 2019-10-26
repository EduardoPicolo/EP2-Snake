package snake;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class FruitSprite {
	protected int POS_X;
	protected int POS_Y;
	
	protected Image fruit_image;
	protected int fruit_image_width;
	protected int fruit_image_height;
	
	public FruitSprite() {
		loadImages();
		setDimension();
		generateFruit();
	}
	
	protected void loadImages() {
        ImageIcon iia = new ImageIcon("apple.png");
        fruit_image = iia.getImage();
	}
	
	protected void setDimension() {
		fruit_image_width = fruit_image.getWidth(null);
		fruit_image_height = fruit_image.getHeight(null);
	}
	
    public void generateFruit() {
        int randomNumber = (int)(Math.random() * (GamePanel.PLAYABLE_AREA_WIDTH - fruit_image_width));
        randomNumber = randomNumber - (randomNumber % fruit_image_width);
        POS_X = randomNumber;

        randomNumber = (int)(Math.random() * (GamePanel.PLAYABLE_AREA_HEIGHT - fruit_image_height));
        randomNumber = randomNumber - (randomNumber % fruit_image_height);
        POS_Y = randomNumber;
    }
    
    public void checkFruit(SnakeSprite snake) {
//        if ((snake.getPOS_X()[0] == POS_X) && (snake.getPOS_Y()[0] == POS_Y)) {
//
//      	snake.updateBodySize();
//      	generateFruit();
//      	}
    	Rectangle r1 = snake.getBounds();
        if (r1.intersects(this.getBounds())) {
          	snake.updateBodySize();
          	generateFruit();
        }	
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
