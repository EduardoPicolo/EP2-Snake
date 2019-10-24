package snake;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FruitSprite {
	protected int POS_X;
	protected int POS_Y;
	
	protected Image fruit_image;
	
	public FruitSprite() {
		loadImages();
		generateFruit();
	}
	
	protected void loadImages() {
        ImageIcon iia = new ImageIcon("apple.png");
        fruit_image = iia.getImage();
	}
	
    public void generateFruit() {
        int r = (int) (Math.random() * 29);
        POS_X = ((r * 10));
//        POS_X = r;

        r = (int) (Math.random() * 29);
        POS_Y = ((r * 10));
//        POS_Y = r;
    }
    
    public void checkFruit(SnakeSprite snake) {
        if ((snake.getPOS_X()[0] == POS_X) && (snake.getPOS_Y()[0] == POS_Y)) {

//          dots++;
      	snake.setBodySize(1);
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
	
}
