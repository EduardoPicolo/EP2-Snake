package snake;

import javax.swing.ImageIcon;

public class KittySnake extends SnakeSprite {
	public KittySnake() {
		super();
	}
	
	@Override
	protected void loadImages() {
        ImageIcon iid = new ImageIcon("dot.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        snake_head_image = iih.getImage();
	}
	
	@Override
	public boolean checkCollision() {
    	for (int i = body_size; i > 0; i--) {
            if ((i > 4) && (POS_X[0] == POS_X[i]) && (POS_Y[0] == POS_Y[i])) {
            	return false;
            }
        }

        if (POS_Y[0] >= Main.SCREEN_HEIGHT) {
        	POS_Y[0] = 0;
        }
        else if (POS_Y[0] < 0) {
        	POS_Y[0] = Main.SCREEN_HEIGHT-(snake_image_height);
        }
        else if (POS_X[0] >= Main.SCREEN_WIDTH) {
        	POS_X[0] = 0;
        }
        else if (POS_X[0] < 0) {
        	POS_X[0] = Main.SCREEN_WIDTH-(snake_image_width);
        }
        
        return true;
    }
}
