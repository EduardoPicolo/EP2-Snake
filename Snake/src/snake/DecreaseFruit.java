package snake;

import javax.swing.ImageIcon;

public class DecreaseFruit extends FruitSprite {
	public DecreaseFruit() {
		super();
	}
	
	@Override
	public void specialEffect() {
		scoreValue = 0;
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("./src/assets/dot.png");
        fruit_image = iia.getImage();
	}
}
