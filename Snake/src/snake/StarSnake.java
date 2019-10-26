package snake;

import javax.swing.ImageIcon;

public class StarSnake extends SnakeSprite {
	public StarSnake() {
		super();
		score_multiplier = 2;
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("dot.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        snake_head_image = iih.getImage();
    }
	
	@Override
	public void updateBodySize() {
		body_size += 2;
	}
}
