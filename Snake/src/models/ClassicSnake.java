package models;

import javax.swing.ImageIcon;

public class ClassicSnake extends SnakeSprite {
	public ClassicSnake() {
		super();
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("./src/assets/dot.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/head10px.png");
        snake_head_image = iih.getImage();
    }
}
