package snake;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.ImageIcon;

public class SnakeSprite {
    protected Deque<Point> snakeBody;
    
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
    	snakeBody = new ArrayDeque<>();
    	snakeBody.add(new Point(50,150));
    	body_size = 1;
    	score_multiplier = 1;
        rightDirection = true;
    }
    
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("dot.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        snake_head_image = iih.getImage();
    }
    
    public void move() {
        Point headPosition = snakeBody.getFirst().getLocation();
        
        if(leftDirection) {
        	headPosition.translate(-snake_image_width, 0);
        }

        else if(rightDirection) {
        	headPosition.translate(snake_image_width, 0);
        }

        else if(upDirection) {
        	headPosition.translate(0, -snake_image_height);
        }

        else if(downDirection) {
        	headPosition.translate(0, snake_image_height);
        }
        
        snakeBody.removeLast();
        snakeBody.addFirst(headPosition);       
    }
        
    public void checkCollision() {
    	for(int i=1 ; i<this.getBounds().size() ;i++) {
    		if(this.getBounds().get(i).intersects(this.getBounds().get(0))) {
				GamePanel.setInGame(false);
				return;
			}    		
    	}
    	
    	if(snakeBody.getFirst().getY() >= GamePanel.PLAYABLE_AREA_HEIGHT || snakeBody.getFirst().getY() < 0 ||
    			snakeBody.getFirst().getX() >= GamePanel.PLAYABLE_AREA_WIDTH || snakeBody.getFirst().getX() < 0) {
    		GamePanel.setInGame(false);
    	}
    }
    
    public void checkFruitCollision(List<FruitSprite> fruits) {
    	for(int i=0; i<fruits.size() ; i++) {
    		if(snakeBody.getFirst().equals(fruits.get(i).getPosition())) {
    			increaseBody();
    			GamePanel.setScore(this.score_multiplier * fruits.get(i).getScoreValue());
    			fruits.remove(i);
    		}
    	}
    }
    
    public void increaseBody() {
    	snakeBody.addLast(new Point((int)snakeBody.getLast().getX(), (int)snakeBody.getLast().getY()));
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
    	return snakeBody.size();
    }
    
    public Deque<Point> getSnakeBody(){
    	return snakeBody;
    }
    
    public Point getHeadPosition() {
    	return snakeBody.getFirst().getLocation();
    }
    
    public void setHeadPosition(int X, int Y) {
    	snakeBody.getFirst().setLocation(X, Y);
    }
    
    public void updateBodySize() {
    	body_size += 1;
    }
    
    public List<Rectangle> getBounds() {
    	List<Rectangle> snake_bounds = new ArrayList<>();
    	for(Point point : snakeBody) {
    		snake_bounds.add(new Rectangle((int)point.getX(), (int)point.getY(), snake_image_width, snake_image_height));
    	}
    	return snake_bounds;
    }

}
