package snake;

import javax.swing.ImageIcon;

public class ClassicSnake extends SnakeSprite {
	public ClassicSnake() {
		super();
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("dot.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        snake_head_image = iih.getImage();
    }
}
