package models;

import javax.swing.ImageIcon;

import views.GamePanel;
import views.MainFrame;

public class KittySnake extends SnakeSprite {
	public KittySnake() {
		super();
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("./src/assets/KittyBody13px.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/GreenHead13px.png");
        snake_head_image = iih.getImage();
    }
		
	@Override
	public void checkCollision() {

        if (getHeadPosition().getY() >= MainFrame.getFrameHeight()) {
        	setHeadPosition((int)getHeadPosition().getX(), 26);
        }
        else if (getHeadPosition().getY() < 26) {
        	setHeadPosition((int)getHeadPosition().getX(), MainFrame.getFrameHeight());
        }
        else if (getHeadPosition().getX() >= MainFrame.getFrameWidth()) {
        	setHeadPosition(0, (int)getHeadPosition().getY());
        }
        else if (getHeadPosition().getX() < 0) {
        	setHeadPosition(MainFrame.getFrameWidth(), (int)getHeadPosition().getY());    
        }
        
    }
}
