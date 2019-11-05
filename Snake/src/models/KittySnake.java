package models;

import javax.swing.ImageIcon;

import views.GamePanel;

public class KittySnake extends SnakeSprite {
	public KittySnake() {
		super();
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("./src/assets/KittyBody10px.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/head10px.png");
        snake_head_image = iih.getImage();
    }
		
	@Override
	public void checkCollision() {

        if (getHeadPosition().getY() >= MainFrame.getFrameHeight()) {
        	setHeadPosition((int)getHeadPosition().getX(), 20);
        }
        else if (getHeadPosition().getY() < 20) {
        	setHeadPosition((int)getHeadPosition().getX(), MainFrame.getFrameHeight());
        }
        else if (getHeadPosition().getX() >= 300) {
        	setHeadPosition(0, (int)getHeadPosition().getY());
        }
        else if (getHeadPosition().getX() < 0) {
        	setHeadPosition(300, (int)getHeadPosition().getY());    
        }
        
    }
}
