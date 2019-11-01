package snake;

import javax.swing.ImageIcon;

public class BigFruit extends FruitSprite {
	public BigFruit() {
		super();
	}
	
	@Override
	public void specialEffect() {
		scoreValue = 2;
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("./src/assets/BigFruit10px.png");
        fruit_image = iia.getImage();
	}
}
