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
        ImageIcon iid = new ImageIcon("./src/assets/Star10px.png");
        snake_body_image = iid.getImage();

        ImageIcon iih = new ImageIcon("./src/assets/StarHead10px.png");
        snake_head_image = iih.getImage();
    }
	
	@Override
	public void increaseBody() {
		snakeBody.addLast(new Point((int)snakeBody.getLast().getX(), (int)snakeBody.getLast().getY()));
		snakeBody.addLast(new Point((int)snakeBody.getLast().getX(), (int)snakeBody.getLast().getY()));
	}
}
