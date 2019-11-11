package models;

import javax.swing.ImageIcon;

public class ClassicSnake extends SnakeSprite {
	public ClassicSnake() {
		super();
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("./src/assets/GreenBody13px.png");
        body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/GreenHead13px.png");
        head_image = iih.getImage();
    }
}
