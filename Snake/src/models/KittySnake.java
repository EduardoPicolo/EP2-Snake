package models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import views.Display;

public class KittySnake extends SnakeSprite {
	public KittySnake() {
		super();
		score_multiplier = 1;
		setDimensions();
	}
	
	@Override
    protected void loadImages() {
		try {
			head_image = ImageIO.read(new File("./src/assets/KittyHead13px.png"));
			body_image = ImageIO.read(new File("./src/assets/KittyBody13px.png"));
		} catch (IOException e) {
			System.out.println("Failed to load KittySnake Image");
			e.printStackTrace();
		}
    }
		
	@Override
	public boolean checkCollision() {
		for(int i=1 ; i<this.getBounds().size() ;i++) {
    		if(this.getBounds().get(i).intersects(this.getBounds().get(0))) {
				return true;
			}    		
    	}

        if (getHeadPosition().getY() >= Display.getFrameHeight()) {
        	setHeadPosition((int)getHeadPosition().getX(), 26);
        }
        else if (getHeadPosition().getY() < 26) {
        	setHeadPosition((int)getHeadPosition().getX(), Display.getFrameHeight());
        }
        else if (getHeadPosition().getX() >= Display.getFrameWidth()) {
        	setHeadPosition(0, (int)getHeadPosition().getY());
        }
        else if (getHeadPosition().getX() < 0) {
        	setHeadPosition(Display.getFrameWidth(), (int)getHeadPosition().getY());    
        }
        
        return false;
        
    }
}
