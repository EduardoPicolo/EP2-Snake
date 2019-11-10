package models;

import java.awt.Point;

import javax.swing.ImageIcon;

public class StarSnake extends SnakeSprite {
	public StarSnake() {
		super();
		score_multiplier = 2;
	}
	
	@Override
    protected void loadImages() {
        ImageIcon iid = new ImageIcon("./src/assets/head13px.png");
        body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/head13px.png");
        head_image = iih.getImage();
    }
	
	@Override
	public void increaseBody() {
		body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
		body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
	}
}
