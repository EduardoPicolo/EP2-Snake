package snake;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class SnakeSprite {
    protected final int POS_X[] = new int[Main.SCREEN_WIDTH*Main.SCREEN_HEIGHT];
    protected final int POS_Y[] = new int[Main.SCREEN_WIDTH*Main.SCREEN_HEIGHT];
//    private final int SNAKE_IMAGE_BODY_SIZE = 10; //10px
    
    protected int body_size;
    protected boolean leftDirection = false;
    protected boolean rightDirection = true;
    protected boolean upDirection = false;
    protected boolean downDirection = false;
    
    protected Image snake_head_image;
    protected Image snake_body_image;
    protected int snake_image_width;
    protected int snake_image_height;
    
    public SnakeSprite() {
    	loadImages();
    	setImageDimension();
    	body_size = 3;
        for (int position = 0; position < body_size; position++) {
            POS_X[position] = 50 - position * 10;
            POS_Y[position] = 50;
        }
    }
    
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("dot.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        snake_head_image = iih.getImage();
    }
    
    public void move() {

        for (int position = body_size; position > 0; position--) {
            POS_X[position] = POS_X[(position - 1)];
            POS_Y[position] = POS_Y[(position - 1)];
        }

        if (leftDirection) {
            POS_X[0] -= snake_image_width;
        }

        if (rightDirection) {
            POS_X[0] += snake_image_width;
        }

        if (upDirection) {
            POS_Y[0] -= snake_image_height;
        }

        if (downDirection) {
            POS_Y[0] += snake_image_height;
        }
    }
    
    public void setDirection(KeyEvent e) {
    	int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
            
        }

        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == KeyEvent.VK_UP) && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        }

        if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
    }
    
	public void setImageDimension() {
		snake_image_width = snake_head_image.getWidth(null);
		snake_image_height = snake_head_image.getHeight(null);
//		snake_body_width = snake_body_image.getWidth(null);
//		snake_body_height = snake_body_image.getHeight(null);
	}
    
    public Image getSnakeHead_Image() {
    	return snake_head_image;
    }
    
    public Image getSnakeBody_Image() {
    	return snake_body_image;
    }
    
    public int getBodySize() {
    	return body_size;
    }
    public void setBodySize(int value) {
    	body_size += value;
    }
    
    public int[] getPOS_X() {
    	return POS_X;
    }
    
    public int[] getPOS_Y() {
    	return POS_Y;
    }
    
    
    public Rectangle getBounds() {
    	return new Rectangle(POS_X[0], POS_Y[0], snake_image_width, snake_image_height);
    }

}
