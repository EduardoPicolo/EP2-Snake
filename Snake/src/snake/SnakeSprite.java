package snake;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class SnakeSprite {
    protected final int POS_X[] = new int[Main.SCREEN_WIDTH*Main.SCREEN_HEIGHT];
    protected final int POS_Y[] = new int[Main.SCREEN_WIDTH*Main.SCREEN_HEIGHT];
    
    protected int body_size;
    protected int score_multiplier;
    protected boolean leftDirection = false;
    protected boolean rightDirection = false;
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
    	score_multiplier = 1;
        for (int i = 0; i < this.body_size; i++) {
            POS_X[i] = 50 - i * 10;
            POS_Y[i] = GamePanel.PLAYABLE_AREA_WIDTH/2;
        }
        rightDirection = true;
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

        if(leftDirection) {
            POS_X[0] -= snake_image_width;
        }

        else if(rightDirection) {
            POS_X[0] += snake_image_width;
        }

        else if(upDirection) {
            POS_Y[0] -= snake_image_height;
        }

        else if(downDirection) {
            POS_Y[0] += snake_image_height;
        }
    }
        
    public void checkCollision() {
    	for(int i=1 ; i<this.getBounds().size() ;i++) {
    		if(this.getBounds().get(i).intersects(this.getBounds().get(0))) {
				GamePanel.setInGame(false);
				return;
			}    		
    	}
    	
        if (POS_Y[0] >= GamePanel.PLAYABLE_AREA_HEIGHT) {
        	GamePanel.setInGame(false);
        	return;
        }
        else if (POS_Y[0] < 0) {
        	GamePanel.setInGame(false);
        	return;
        }
        else if (POS_X[0] >= GamePanel.PLAYABLE_AREA_WIDTH) {
        	GamePanel.setInGame(false);
        	return;
        }
        else if (POS_X[0] < 0) {
        	GamePanel.setInGame(false);
        	return;
        }
    }
    
    public void checkFruitCollision(List<FruitSprite> fruits) {
    	for(int i=0; i<fruits.size() ; i++) {
    		Rectangle fruit_area = fruits.get(i).getBounds();
    		if (this.getBounds().get(0).intersects(fruit_area)) {
    			updateBodySize();
    			GamePanel.setScore(this.score_multiplier * fruits.get(i).getScoreValue());
    			fruits.remove(i);
    		}
    	}
    }
    
    public void setDirection(KeyEvent e) {
    	int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
            rightDirection = false;
        }

        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
            leftDirection = false;
        }

        if ((key == KeyEvent.VK_UP) && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
            downDirection = false;
        }

        if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
            upDirection = false;
        }
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
    	return body_size;
    }
    public void updateBodySize() {
    	body_size += 1;
    }
    
    public int[] getPOS_X() {
    	return POS_X;
    }
    
    public int[] getPOS_Y() {
    	return POS_Y;
    }
    
    public List<Rectangle> getBounds() {
    	List<Rectangle> snake_bounds;
    	snake_bounds = new ArrayList<>();
    	for(int i=0; i<body_size; i++){
    		snake_bounds.add(new Rectangle(POS_X[i], POS_Y[i], snake_image_width, snake_image_height));
    	}
    	return snake_bounds;
    }

}
