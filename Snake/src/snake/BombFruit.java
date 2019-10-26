package snake;

import javax.swing.ImageIcon;

public class BombFruit extends FruitSprite {
	public BombFruit() {
		super();
		scoreValue = 0;
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("head.png");
        fruit_image = iia.getImage();
	}
}
