package models;

import javax.swing.ImageIcon;

public class SimpleFruit extends FruitSprite{
	public SimpleFruit() {
		super();
	}
	
	@Override
	public void specialEffect() {
		scoreValue = 1;
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("./src/assets/apple.png");
        fruit_image = iia.getImage();
	}
}
