package snake;

import javax.swing.ImageIcon;

public class KittySnake extends SnakeSprite {
	public KittySnake() {
		super();
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("./src/assets/dot.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/head.png");
        snake_head_image = iih.getImage();
    }
		
	@Override
	public void checkCollision() {

        if (getHeadPosition().getY() >= GamePanel.PLAYABLE_AREA_HEIGHT) {
        	setHeadPosition((int)getHeadPosition().getX(), 0);
        }
        else if (getHeadPosition().getY() < 0) {
        	setHeadPosition((int)getHeadPosition().getX(), GamePanel.PLAYABLE_AREA_HEIGHT);
        }
        else if (getHeadPosition().getX() >= GamePanel.PLAYABLE_AREA_WIDTH) {
        	setHeadPosition(0, (int)getHeadPosition().getY());
        }
        else if (getHeadPosition().getX() < 0) {
        	setHeadPosition(GamePanel.PLAYABLE_AREA_WIDTH, (int)getHeadPosition().getY());    
        }
        
    }
}
