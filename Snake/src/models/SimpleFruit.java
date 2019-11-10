package models;

import javax.swing.ImageIcon;

public class SimpleFruit extends FruitSprite{
	public SimpleFruit() {
		super();
	}
	
	@Override
	public void skill(SnakeSprite snake) {
		scoreValue = 1;
		snake.increaseBody();
	}
	
	@Override
	protected void loadImage() {
		ImageIcon iia = new ImageIcon("./src/assets/SimpleFruit13px.png");
        image = iia.getImage();
	}
}
