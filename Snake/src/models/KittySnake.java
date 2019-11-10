package models;

import javax.swing.ImageIcon;

import views.Display;

public class KittySnake extends SnakeSprite {
	public KittySnake() {
		super();
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("./src/assets/KittyGreenBody13px.png");
        body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/GreenHead13px.png");
        head_image = iih.getImage();
    }
		
	@Override
	public boolean checkCollision() {

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
