package models;

import javax.swing.ImageIcon;

public class BigFruit extends FruitSprite {
	public BigFruit() {
		super();
	}
	
	@Override
	public void specialEffect(SnakeSprite snake) {
		scoreValue = 2;
		snake.increaseBody();
//		snake.increaseBody();
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("./src/assets/BigFruit13px.png");
        fruit_image = iia.getImage();
	}
}
