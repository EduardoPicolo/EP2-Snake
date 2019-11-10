package models;

import javax.swing.ImageIcon;

public class DecreaseFruit extends FruitSprite {
	public DecreaseFruit() {
		super();
	}
	
	@Override
	public void skill(SnakeSprite snake) {
		scoreValue = 0;
		snake.getSnakeBody().subList(1, snake.getBodySize()).clear();
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("./src/assets/DecreaseFruit13px.png");
        image = iia.getImage();
	}
}
